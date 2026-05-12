package com.devarena.modules.user.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_stats")
public class UserStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private Integer totalXp;
    private Integer challengesCompleted;
    private Integer submissionsMade;
    private Integer pvpWins;
    private Integer pvpLosses;
    private Integer currentStreak;
    private Integer longestStreak;
    private Integer rankScore;

    public UserStats() {
    }

    public UserStats(Long id, User user, Integer totalXp, Integer challengesCompleted, Integer submissionsMade, Integer pvpWins, Integer pvpLosses, Integer currentStreak, Integer longestStreak, Integer rankScore) {
        this.id = id;
        this.user = user;
        this.totalXp = totalXp;
        this.challengesCompleted = challengesCompleted;
        this.submissionsMade = submissionsMade;
        this.pvpWins = pvpWins;
        this.pvpLosses = pvpLosses;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.rankScore = rankScore;
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

    public Integer getTotalXp() {
        return totalXp;
    }

    public void setTotalXp(Integer totalXp) {
        this.totalXp = totalXp;
    }

    public Integer getChallengesCompleted() {
        return challengesCompleted;
    }

    public void setChallengesCompleted(Integer challengesCompleted) {
        this.challengesCompleted = challengesCompleted;
    }

    public Integer getSubmissionsMade() {
        return submissionsMade;
    }

    public void setSubmissionsMade(Integer submissionsMade) {
        this.submissionsMade = submissionsMade;
    }

    public Integer getPvpWins() {
        return pvpWins;
    }

    public void setPvpWins(Integer pvpWins) {
        this.pvpWins = pvpWins;
    }

    public Integer getPvpLosses() {
        return pvpLosses;
    }

    public void setPvpLosses(Integer pvpLosses) {
        this.pvpLosses = pvpLosses;
    }

    public Integer getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(Integer currentStreak) {
        this.currentStreak = currentStreak;
    }

    public Integer getLongestStreak() {
        return longestStreak;
    }

    public void setLongestStreak(Integer longestStreak) {
        this.longestStreak = longestStreak;
    }

    public Integer getRankScore() {
        return rankScore;
    }

    public void setRankScore(Integer rankScore) {
        this.rankScore = rankScore;
    }

    @Override
    public String toString() {
        return "UserStats{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : null) +
                ", totalXp=" + totalXp +
                ", challengesCompleted=" + challengesCompleted +
                ", submissionsMade=" + submissionsMade +
                ", pvpWins=" + pvpWins +
                ", pvpLosses=" + pvpLosses +
                ", currentStreak=" + currentStreak +
                ", longestStreak=" + longestStreak +
                ", rankScore=" + rankScore +
                '}';
    }
}
