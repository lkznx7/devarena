package com.devarena.modules.auth.service;

import com.devarena.modules.auth.dto.request.*;
import com.devarena.modules.auth.dto.response.AuthResponse;
import com.devarena.modules.auth.dto.response.UserResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(String email, String password);

    AuthResponse refreshToken(TokenRefreshRequest request);

    void logout(String refreshToken);

    void forgotPassword(ForgotPasswordRequest request);

    void resetPassword(ResetPasswordRequest request);

    void verifyEmail(String token, String email);

    UserResponse onboarding(OnboardingRequest request, String userEmail);
}
