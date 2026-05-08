package com.devarena.modules.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "challenge_test_cases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}