package com.devarena.modules.challenge.entity;

import com.devarena.modules.pvp.entity.PvpMatch;
import com.devarena.modules.submission.entity.Submission;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "challenges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String slug;
    private String description;
    private String difficulty;
    private String category;
    private String defaultCode;
    private String solution;
    private String language;
    private String defaultTestCode;
    private Integer xpReward;
    private Integer timeLimit;
    private Integer memoryLimit;
    private Boolean isActive;

    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY)
    private List<ChallengeHint> hints;

    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY)
    private List<ChallengeTestCase> testCases;

    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY)
    private List<Submission> submissions;

    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY)
    private List<PvpMatch> pvpMatches;

    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY)
    private List<UserChallengeProgress> userProgress;
}