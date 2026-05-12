package com.devarena.modules.auth;

import com.devarena.modules.auth.dto.request.LoginRequest;
import com.devarena.modules.auth.dto.request.RegisterRequest;
import com.devarena.modules.auth.dto.request.TokenRefreshRequest;
import com.devarena.modules.auth.dto.response.AuthResponse;
import com.devarena.modules.email.entity.TokenEmail;
import com.devarena.modules.email.repository.TokenEmailRepository;
import com.devarena.shared.responses.ApiResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties = {
    "spring.ai.openai.api-key=dummy",
    "spring.cloud.function.scan.enabled=false"
})
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthFlowIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenEmailRepository tokenEmailRepository;

    private String testEmail;
    private String testPassword;
    private String testToken;
    private String testRefreshToken;

    @BeforeAll
    void init() {
        long timestamp = System.currentTimeMillis();
        testEmail = "integration_" + timestamp + "@test.com";
        testPassword = "Test@123";
    }

    @Test
    @Order(1)
    @DisplayName("1. Cadastro -> Registro bem-sucedido")
    void shouldRegisterUserSuccessfully() throws Exception {
        RegisterRequest request = new RegisterRequest(testEmail, testPassword);

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.user.email").value(testEmail));

        TokenEmail token = tokenEmailRepository.findByEmail(testEmail)
                .orElseThrow(() -> new AssertionError("Token não encontrado após registro"));

        testToken = token.getToken();
    }

    @Test
    @Order(2)
    @DisplayName("2. Login negado quando e-mail não verificado")
    void shouldDenyLoginWhenEmailNotVerified() throws Exception {
        LoginRequest loginRequest = new LoginRequest(testEmail, testPassword);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value(org.hamcrest.Matchers.containsString("User is disabled")));
    }

    @Test
    @Order(3)
    @DisplayName("3. Validação do token -> Ativar usuário")
    void shouldVerifyEmailWithValidToken() throws Exception {
        mockMvc.perform(get("/auth/verify-email")
                        .param("token", testToken)
                        .param("email", testEmail))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    @Order(4)
    @DisplayName("4. Login após verificação -> Retorna JWT e Refresh Token")
    void shouldLoginSuccessfullyAfterEmailVerification() throws Exception {
        LoginRequest loginRequest = new LoginRequest(testEmail, testPassword);

        MvcResult result = mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.token").isNotEmpty())
                .andExpect(jsonPath("$.data.refreshToken").isNotEmpty())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        ApiResponse<AuthResponse> apiResponse = objectMapper.readValue(responseBody, new TypeReference<>() {});
        AuthResponse authResponse = apiResponse.getData();

        assertThat(authResponse.refreshToken()).isNotNull();
        testRefreshToken = authResponse.refreshToken();
    }

    @Test
    @Order(5)
    @DisplayName("5. Refresh Token -> Gera novo Access Token")
    void shouldRefreshTokenSuccessfully() throws Exception {
        TokenRefreshRequest refreshRequest = new TokenRefreshRequest(testRefreshToken);

        mockMvc.perform(post("/auth/refresh")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(refreshRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.token").isNotEmpty());
    }

    @Test
    @Order(6)
    @DisplayName("6. Logout -> Invalida Refresh Token")
    void shouldLogoutSuccessfully() throws Exception {
        TokenRefreshRequest logoutRequest = new TokenRefreshRequest(testRefreshToken);

        mockMvc.perform(post("/auth/logout")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(logoutRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));

        // Tentar usar o token revogado
        mockMvc.perform(post("/auth/refresh")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(logoutRequest)))
                .andExpect(status().isBadRequest());
    }
}