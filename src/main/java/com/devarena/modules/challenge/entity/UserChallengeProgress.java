package com.devarena.modules.challenge.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_challenge_progress")
public class UserChallengeProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    private String status;
    private String currentCode;
    private Integer attempts;
    private Integer bestTime;

    public UserChallengeProgress() {
    }

    public UserChallengeProgress(Long id, User user, Challenge challenge, String status, String currentCode, Integer attempts, Integer bestTime) {
        this.id = id;
        this.user = user;
        this.challenge = challenge;
        this.status = status;
        this.currentCode = currentCode;
        this.attempts = attempts;
        this.bestTime = bestTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Integer getBestTime() {
        return bestTime;
    }

    public void setBestTime(Integer bestTime) {
        this.bestTime = bestTime;
    }

    @Override
    public String toString() {
        return "UserChallengeProgress{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : null) +
                ", challenge=" + (challenge != null ? challenge.getId() : null) +
                ", status='" + status + '\'' +
                ", currentCode='" + currentCode + '\'' +
                ", attempts=" + attempts +
                ", bestTime=" + bestTime +
                '}';
    }
}
