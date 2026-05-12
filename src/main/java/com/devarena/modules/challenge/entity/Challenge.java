package com.devarena.modules.challenge.entity;

import com.devarena.modules.challenge.enums.ChallengeDifficulty;
import com.devarena.modules.challenge.enums.ProgrammingLanguage;
import com.devarena.modules.submission.entity.Submission;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "challenges")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChallengeDifficulty difficulty;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgrammingLanguage language;

    @Column(columnDefinition = "TEXT")
    private String defaultCode;

    @Column(columnDefinition = "TEXT")
    private String solution;

    private Integer xpReward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChallengeTestCase> testCases;

    @OneToMany(mappedBy = "challenge")
    private List<Submission> submissions;

    public Challenge() {}

    public Challenge(Long id, String title, String slug, String description, ChallengeDifficulty difficulty, ProgrammingLanguage language, String defaultCode, String solution, Integer xpReward, Topic topic) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.difficulty = difficulty;
        this.language = language;
        this.defaultCode = defaultCode;
        this.solution = solution;
        this.xpReward = xpReward;
        this.topic = topic;
    }

    // Getters e Setters explícitos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ChallengeDifficulty getDifficulty() { return difficulty; }
    public void setDifficulty(ChallengeDifficulty difficulty) { this.difficulty = difficulty; }

    public ProgrammingLanguage getLanguage() { return language; }
    public void setLanguage(ProgrammingLanguage language) { this.language = language; }

    public String getDefaultCode() { return defaultCode; }
    public void setDefaultCode(String defaultCode) { this.defaultCode = defaultCode; }

    public String getSolution() { return solution; }
    public void setSolution(String solution) { this.solution = solution; }

    public Integer getXpReward() { return xpReward; }
    public void setXpReward(Integer xpReward) { this.xpReward = xpReward; }

    public Topic getTopic() { return topic; }
    public void setTopic(Topic topic) { this.topic = topic; }

    public List<ChallengeTestCase> getTestCases() { return testCases; }
    public void setTestCases(List<ChallengeTestCase> testCases) { this.testCases = testCases; }

    @Override
    public String toString() {
        return "Challenge{id=" + id + ", title='" + title + "', difficulty=" + difficulty + "}";
    }
}
