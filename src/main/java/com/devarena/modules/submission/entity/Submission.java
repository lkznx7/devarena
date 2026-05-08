package com.devarena.modules.submission.entity;

import com.devarena.modules.auth.entity.User;
import com.devarena.modules.challenge.entity.Challenge;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "submissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    private String code;
    private String language;
    private String status;
    private String errorMessage;
    private Integer executionTime;
    private Integer memoryUsed;
}