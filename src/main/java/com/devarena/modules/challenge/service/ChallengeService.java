package com.devarena.modules.challenge.service;

import com.devarena.modules.challenge.dto.request.ChallengeCreateRequest;
import com.devarena.modules.challenge.dto.response.ChallengeResponse;
import com.devarena.modules.challenge.dto.response.ChallengeSummaryResponse;
import com.devarena.modules.challenge.enums.ChallengeDifficulty;
import com.devarena.modules.challenge.enums.ProgrammingLanguage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChallengeService {
    ChallengeResponse create(ChallengeCreateRequest request);
    Page<ChallengeSummaryResponse> listAll(ProgrammingLanguage language, Long topicId, ChallengeDifficulty difficulty, Pageable pageable);
    ChallengeResponse findBySlug(String slug);
}
