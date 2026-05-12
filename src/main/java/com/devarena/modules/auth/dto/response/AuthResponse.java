package com.devarena.modules.auth.dto.response;

public record AuthResponse(
    String token,
    String refreshToken,
    String tokenType,
    UserResponse user
) {
    public AuthResponse(String token, String refreshToken, UserResponse user) {
        this(token, refreshToken, "Bearer", user);
    }
}
