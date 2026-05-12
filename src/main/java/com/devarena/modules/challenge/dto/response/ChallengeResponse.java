package com.devarena.modules.challenge.dto.response;

import com.devarena.modules.challenge.enums.ChallengeDifficulty;
import com.devarena.modules.challenge.enums.ProgrammingLanguage;
import java.util.List;

public record ChallengeResponse(
    Long id,
    String title,
    String slug,
    String description,
    ChallengeDifficulty difficulty,
    ProgrammingLanguage language,
    String defaultCode,
    Integer xpReward,
    String topicName
) {}
