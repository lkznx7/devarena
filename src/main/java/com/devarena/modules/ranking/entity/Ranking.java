package com.devarena.modules.ranking.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "rankings")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String userDisplayName;
    private String userAvatarUrl;
    private Integer score;
    private Integer rank;
    private String type;
    private String period;

    public Ranking() {
    }

    public Ranking(Long id, User user, String userDisplayName, String userAvatarUrl, Integer score, Integer rank, String type, String period) {
        this.id = id;
        this.user = user;
        this.userDisplayName = userDisplayName;
        this.userAvatarUrl = userAvatarUrl;
        this.score = score;
        this.rank = rank;
        this.type = type;
        this.period = period;
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

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : null) +
                ", userDisplayName='" + userDisplayName + '\'' +
                ", userAvatarUrl='" + userAvatarUrl + '\'' +
                ", score=" + score +
                ", rank=" + rank +
                ", type='" + type + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
