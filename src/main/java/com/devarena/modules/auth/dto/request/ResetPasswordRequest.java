package com.devarena.modules.auth.dto.request;

public record ResetPasswordRequest(String email, String token, String newPassword) {
}
