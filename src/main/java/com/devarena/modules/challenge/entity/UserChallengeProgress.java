package com.devarena.modules.challenge.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_challenge_progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}