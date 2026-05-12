package com.devarena.modules.challenge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "challenge_hints")
public class ChallengeHint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    private String content;
    private Integer orderIndex;
    private Integer xpPenalty;

    public ChallengeHint() {
    }

    public ChallengeHint(Long id, Challenge challenge, String content, Integer orderIndex, Integer xpPenalty) {
        this.id = id;
        this.challenge = challenge;
        this.content = content;
        this.orderIndex = orderIndex;
        this.xpPenalty = xpPenalty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Integer getXpPenalty() {
        return xpPenalty;
    }

    public void setXpPenalty(Integer xpPenalty) {
        this.xpPenalty = xpPenalty;
    }

    @Override
    public String toString() {
        return "ChallengeHint{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", orderIndex=" + orderIndex +
                ", xpPenalty=" + xpPenalty +
                '}';
    }
}
