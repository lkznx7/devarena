package com.devarena.modules.auth.service;

import com.devarena.modules.auth.dto.request.ForgotPasswordRequest;
import com.devarena.modules.auth.dto.request.OnboardingRequest;
import com.devarena.modules.auth.dto.request.RegisterRequest;
import com.devarena.modules.auth.dto.request.ResetPasswordRequest;
import com.devarena.modules.auth.dto.response.AuthResponse;
import com.devarena.modules.auth.dto.response.UserResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(String email, String password);

    void forgotPassword(ForgotPasswordRequest request);

    void resetPassword(ResetPasswordRequest request);

    void verifyEmail(String token);

    UserResponse onboarding(OnboardingRequest request, String userEmail);
}
