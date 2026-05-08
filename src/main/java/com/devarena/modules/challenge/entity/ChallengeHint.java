package com.devarena.modules.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "challenge_hints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}