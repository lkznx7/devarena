package com.devarena.modules.user.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_stats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private Integer totalXp;
    private Integer challengesCompleted;
    private Integer submissionsMade;
    private Integer pvpWins;
    private Integer pvpLosses;
    private Integer currentStreak;
    private Integer longestStreak;
    private Integer rankScore;
}