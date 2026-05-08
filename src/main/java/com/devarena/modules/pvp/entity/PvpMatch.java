package com.devarena.modules.pvp.entity;

import com.devarena.modules.auth.entity.User;
import com.devarena.modules.challenge.entity.Challenge;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pvp_matches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PvpMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player1_id", nullable = false)
    private User player1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player2_id", nullable = false)
    private User player2;

    private String mode;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id")
    private User winner;

    private Integer player1Score;
    private Integer player2Score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;
}