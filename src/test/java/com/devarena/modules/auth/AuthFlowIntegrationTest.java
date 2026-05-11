package com.devarena.modules.auth;

import com.devarena.modules.auth.dto.request.LoginRequest;
import com.devarena.modules.auth.dto.request.RegisterRequest;
import com.devarena.modules.auth.dto.response.AuthResponse;
import com.devarena.modules.email.entity.TokenEmail;
import com.devarena.modules.email.repository.TokenEmailRepository;
import com.devarena.shared.responses.ApiResponse;
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

@SpringBootTest
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
                .andExpect(jsonPath("$.message").value("Usuário registrado com sucesso. Verifique seu e-mail."))
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
                .andExpect(status().isForbidden());
    }

    @Test
    @Order(3)
    @DisplayName("3. Busca token de 6 dígitos no banco de dados")
    void shouldRetrieveTokenFromDatabase() throws Exception {
        TokenEmail token = tokenEmailRepository.findByEmail(testEmail)
                .orElseThrow(() -> new AssertionError("Token não encontrado no banco para: " + testEmail));

        assertThat(token.getToken()).hasSize(6);
        assertThat(token.getEmail()).isEqualTo(testEmail);

        testToken = token.getToken();
    }

    @Test
    @Order(4)
    @DisplayName("4. Validação do token de 6 dígitos -> Ativar usuário")
    void shouldVerifyEmailWithValidToken() throws Exception {
        mockMvc.perform(get("/auth/verify-email")
                        .param("token", testToken)
                        .param("email", testEmail))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("E-mail verificado com sucesso."));
    }

    @Test
    @Order(5)
    @DisplayName("5. Login após verificação -> Retorna JWT com sucesso")
    void shouldLoginSuccessfullyAfterEmailVerification() throws Exception {
        LoginRequest loginRequest = new LoginRequest(testEmail, testPassword);

        MvcResult result = mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Login realizado com sucesso."))
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        ApiResponse apiResponse = objectMapper.readValue(responseBody, ApiResponse.class);
        AuthResponse authResponse = objectMapper.convertValue(apiResponse.getData(), AuthResponse.class);

        assertThat(authResponse.token()).isNotNull();
        assertThat(authResponse.token()).isNotEmpty();
        assertThat(authResponse.user().email()).isEqualTo(testEmail);
    }
}