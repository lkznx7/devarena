package com.devarena.modules.auth.controller;

import com.devarena.modules.auth.dto.request.*;
import com.devarena.modules.auth.dto.response.AuthResponse;
import com.devarena.modules.auth.dto.response.UserResponse;
import com.devarena.modules.auth.service.AuthService;
import com.devarena.shared.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Usuário registrado com sucesso. Verifique seu e-mail.", response));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request.email(), request.password());
        return ResponseEntity
                .ok(ApiResponse.ok("Login realizado com sucesso.", response));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<ApiResponse<Void>> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        authService.forgotPassword(request);
        return ResponseEntity
                .ok(ApiResponse.ok("Se o e-mail estiver cadastrado, instruções de recuperação foram enviadas.", null));
    }

    @PatchMapping("/reset-password")
    public ResponseEntity<ApiResponse<Void>> resetPassword(@RequestBody ResetPasswordRequest request) {
        authService.resetPassword(request);
        return ResponseEntity
                .ok(ApiResponse.ok("Senha redefinida com sucesso.", null));
    }

    @GetMapping("/verify-email")
    public ResponseEntity<ApiResponse<Void>> verifyEmail(@RequestParam String token, @RequestParam String email) {
        authService.verifyEmail(token, email);
        return ResponseEntity
                .ok(ApiResponse.ok("E-mail verificado com sucesso.", null));
    }

    @PostMapping("/onboarding")
    public ResponseEntity<ApiResponse<UserResponse>> onboarding(@RequestBody OnboardingRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        UserResponse response = authService.onboarding(request, userEmail);
        return ResponseEntity
                .ok(ApiResponse.ok("Onboarding concluído.", response));
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<AuthResponse>> refresh(@RequestBody TokenRefreshRequest request) {
        AuthResponse response = authService.refreshToken(request);
        return ResponseEntity
                .ok(ApiResponse.ok("Token renovado com sucesso.", response));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(@RequestBody TokenRefreshRequest request) {
        authService.logout(request.refreshToken());
        return ResponseEntity
                .ok(ApiResponse.ok("Logout realizado com sucesso.", null));
    }
}
