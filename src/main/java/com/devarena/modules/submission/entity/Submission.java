package com.devarena.modules.submission.entity;

import com.devarena.modules.auth.entity.User;
import com.devarena.modules.challenge.entity.Challenge;
import com.devarena.modules.submission.enums.SubmissionStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubmissionStatus status;

    private Long executionTimeMs;
    private LocalDateTime createdAt;

    public Submission() {}

    public Submission(Long id, User user, Challenge challenge, String code, SubmissionStatus status, Long executionTimeMs, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.challenge = challenge;
        this.code = code;
        this.status = status;
        this.executionTimeMs = executionTimeMs;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Challenge getChallenge() { return challenge; }
    public void setChallenge(Challenge challenge) { this.challenge = challenge; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public SubmissionStatus getStatus() { return status; }
    public void setStatus(SubmissionStatus status) { this.status = status; }

    public Long getExecutionTimeMs() { return executionTimeMs; }
    public void setExecutionTimeMs(Long executionTimeMs) { this.executionTimeMs = executionTimeMs; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Submission{id=" + id + ", status=" + status + "}";
    }
}
