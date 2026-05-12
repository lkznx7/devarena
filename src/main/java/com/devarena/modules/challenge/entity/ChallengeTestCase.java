package com.devarena.modules.challenge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "challenge_test_cases")
public class ChallengeTestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    private String input;
    private String expectedOutput;
    private Boolean isHidden;
    private Integer orderIndex;

    public ChallengeTestCase() {
    }

    public ChallengeTestCase(Long id, Challenge challenge, String input, String expectedOutput, Boolean isHidden, Integer orderIndex) {
        this.id = id;
        this.challenge = challenge;
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.isHidden = isHidden;
        this.orderIndex = orderIndex;
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    @Override
    public String toString() {
        return "ChallengeTestCase{" +
                "id=" + id +
                ", input='" + input + '\'' +
                ", expectedOutput='" + expectedOutput + '\'' +
                ", isHidden=" + isHidden +
                ", orderIndex=" + orderIndex +
                '}';
    }
}
