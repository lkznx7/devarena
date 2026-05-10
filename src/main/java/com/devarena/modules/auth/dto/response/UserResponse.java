package com.devarena.modules.auth.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
    UUID id,
    String email,
    String displayName,
    String avatarUrl,
    Integer xp,
    Integer level,
    String role,
    LocalDateTime createdAt
) {
}
