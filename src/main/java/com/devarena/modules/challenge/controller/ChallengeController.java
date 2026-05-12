package com.devarena.modules.challenge.controller;

import com.devarena.modules.challenge.dto.request.ChallengeCreateRequest;
import com.devarena.modules.challenge.dto.response.ChallengeResponse;
import com.devarena.modules.challenge.dto.response.ChallengeSummaryResponse;
import com.devarena.modules.challenge.enums.ChallengeDifficulty;
import com.devarena.modules.challenge.enums.ProgrammingLanguage;
import com.devarena.modules.challenge.service.ChallengeService;
import com.devarena.shared.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ChallengeResponse>> create(@RequestBody @Valid ChallengeCreateRequest request) {
        ChallengeResponse response = challengeService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Desafio criado com sucesso", response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ChallengeSummaryResponse>>> listAll(
            @RequestParam(required = false) ProgrammingLanguage language,
            @RequestParam(required = false) Long topicId,
            @RequestParam(required = false) ChallengeDifficulty difficulty,
            Pageable pageable) {
        Page<ChallengeSummaryResponse> response = challengeService.listAll(language, topicId, difficulty, pageable);
        return ResponseEntity.ok(ApiResponse.ok("Lista de desafios recuperada", response));
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ApiResponse<ChallengeResponse>> findBySlug(@PathVariable String slug) {
        ChallengeResponse response = challengeService.findBySlug(slug);
        return ResponseEntity.ok(ApiResponse.ok("Detalhes do desafio", response));
    }
}
