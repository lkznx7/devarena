package com.devarena.modules.auth.dto.request;

public record ResetPasswordRequest(String token, String newPassword) {
}
