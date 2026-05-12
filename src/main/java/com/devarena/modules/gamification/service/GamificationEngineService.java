package com.devarena.modules.gamification.service;

import com.devarena.modules.submission.entity.Submission;
import com.devarena.modules.submission.enums.SubmissionStatus;
import com.devarena.modules.user.entity.UserStats;
import com.devarena.modules.user.repository.UserStatsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GamificationEngineService {

    private final UserStatsRepository userStatsRepository;

    public GamificationEngineService(UserStatsRepository userStatsRepository) {
        this.userStatsRepository = userStatsRepository;
    }

    @Transactional
    public void processAcceptedSubmission(Submission submission) {
        if (submission.getStatus() != SubmissionStatus.ACCEPTED) return;

        UserStats stats = userStatsRepository.findByUser(submission.getUser())
                .orElseGet(() -> createInitialStats(submission));

        int xpGained = submission.getChallenge().getXpReward();
        
        stats.setTotalXp(stats.getTotalXp() + xpGained);
        stats.setChallengesCompleted(stats.getChallengesCompleted() + 1);
        
        // Lógica de Level Up (Simples para MVP: a cada 100 XP sobe um nível)
        // Em produção, usar uma fórmula logarítmica
        int newLevel = (stats.getTotalXp() / 100) + 1;
        
        // Aqui poderíamos disparar uma notificação se newLevel > stats.getUser().getLevel()
        submission.getUser().setLevel(newLevel);
        submission.getUser().setXp(stats.getTotalXp());

        userStatsRepository.save(stats);
    }

    private UserStats createInitialStats(Submission submission) {
        UserStats stats = new UserStats();
        stats.setUser(submission.getUser());
        stats.setTotalXp(0);
        stats.setChallengesCompleted(0);
        stats.setSubmissionsMade(0);
        stats.setPvpWins(0);
        stats.setPvpLosses(0);
        stats.setCurrentStreak(0);
        stats.setLongestStreak(0);
        stats.setRankScore(1000); // ELO inicial
        return stats;
    }
}
