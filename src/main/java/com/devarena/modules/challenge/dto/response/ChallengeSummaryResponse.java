package com.devarena.modules.challenge.dto.response;

import com.devarena.modules.challenge.enums.ChallengeDifficulty;
import com.devarena.modules.challenge.enums.ProgrammingLanguage;

public record ChallengeSummaryResponse(
    Long id,
    String title,
    String slug,
    ChallengeDifficulty difficulty,
    ProgrammingLanguage language,
    Integer xpReward
) {}
