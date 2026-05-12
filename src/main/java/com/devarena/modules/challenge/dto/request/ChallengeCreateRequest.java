package com.devarena.modules.challenge.dto.request;

import com.devarena.modules.challenge.enums.ChallengeDifficulty;
import com.devarena.modules.challenge.enums.ProgrammingLanguage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChallengeCreateRequest(
    @NotBlank String title,
    @NotBlank String description,
    @NotNull ChallengeDifficulty difficulty,
    @NotNull ProgrammingLanguage language,
    String defaultCode,
    String solution,
    @NotNull Long topicId
) {}
