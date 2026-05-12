package com.devarena.modules.challenge.service;

import com.devarena.modules.challenge.dto.request.ChallengeCreateRequest;
import com.devarena.modules.challenge.dto.response.ChallengeResponse;
import com.devarena.modules.challenge.dto.response.ChallengeSummaryResponse;
import com.devarena.modules.challenge.entity.Challenge;
import com.devarena.modules.challenge.entity.Topic;
import com.devarena.modules.challenge.enums.ChallengeDifficulty;
import com.devarena.modules.challenge.enums.ProgrammingLanguage;
import com.devarena.modules.challenge.repository.ChallengeRepository;
import com.devarena.modules.challenge.repository.TopicRepository;
import com.devarena.shared.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final TopicRepository topicRepository;

    public ChallengeServiceImpl(ChallengeRepository challengeRepository, TopicRepository topicRepository) {
        this.challengeRepository = challengeRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional
    public ChallengeResponse create(ChallengeCreateRequest request) {
        Topic topic = topicRepository.findById(request.topicId())
                .orElseThrow(() -> new ResourceNotFoundException("Tópico não encontrado"));

        Challenge challenge = new Challenge();
        challenge.setTitle(request.title());
        challenge.setSlug(generateSlug(request.title()));
        challenge.setDescription(request.description());
        challenge.setDifficulty(request.difficulty());
        challenge.setLanguage(request.language());
        challenge.setDefaultCode(request.defaultCode());
        challenge.setSolution(request.solution());
        challenge.setTopic(topic);
        challenge.setXpReward(request.difficulty().getXpReward());

        Challenge saved = challengeRepository.save(challenge);
        
        return new ChallengeResponse(
                saved.getId(), saved.getTitle(), saved.getSlug(), saved.getDescription(),
                saved.getDifficulty(), saved.getLanguage(), saved.getDefaultCode(),
                saved.getXpReward(), saved.getTopic().getName()
        );
    }

    @Override
    public Page<ChallengeSummaryResponse> listAll(ProgrammingLanguage language, Long topicId, ChallengeDifficulty difficulty, Pageable pageable) {
        // No MVP, usaremos uma query simplificada. Em produção, usar Specification ou QueryDSL.
        return challengeRepository.findAll(pageable)
                .map(c -> new ChallengeSummaryResponse(
                        c.getId(), c.getTitle(), c.getSlug(), c.getDifficulty(), c.getLanguage(), c.getXpReward()
                ));
    }

    @Override
    public ChallengeResponse findBySlug(String slug) {
        return challengeRepository.findBySlug(slug)
                .map(c -> new ChallengeResponse(
                        c.getId(), c.getTitle(), c.getSlug(), c.getDescription(),
                        c.getDifficulty(), c.getLanguage(), c.getDefaultCode(),
                        c.getXpReward(), c.getTopic().getName()
                ))
                .orElseThrow(() -> new ResourceNotFoundException("Desafio não encontrado"));
    }

    private String generateSlug(String input) {
        String nowhitespace = input.replaceAll("\\s+", "-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("")
                .toLowerCase(Locale.ENGLISH)
                .replaceAll("[^a-z0-9-]", "");
    }
}
