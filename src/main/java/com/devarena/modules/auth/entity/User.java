package com.devarena.modules.auth.entity;

import com.devarena.modules.badge.entity.UserBadge;
import com.devarena.modules.challenge.entity.UserChallengeProgress;
import com.devarena.modules.gamification.entity.UserMission;
import com.devarena.modules.notification.entity.Notification;
import com.devarena.modules.pvp.entity.PvpMatch;
import com.devarena.modules.pvp.entity.PvpQueue;
import com.devarena.modules.ranking.entity.Ranking;
import com.devarena.modules.submission.entity.Submission;
import com.devarena.modules.user.entity.Follow;
import com.devarena.modules.user.entity.UserStats;
import com.devarena.modules.user.entity.XpTransaction;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email;
    private String password;
    private String displayName;
    private String avatarUrl;
    private String bio;
    private Integer xp;
    private Integer level;
    private String plan;
    private String role;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<RefreshToken> refreshTokens;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<OAuthAccount> oauthAccounts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserMission> userMissions;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Ranking> rankings;

    @OneToMany(mappedBy = "follower", fetch = FetchType.LAZY)
    private List<Follow> following;

    @OneToMany(mappedBy = "following", fetch = FetchType.LAZY)
    private List<Follow> followers;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<XpTransaction> xpTransactions;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserStats userStats;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Submission> submissions;

    @OneToMany(mappedBy = "player1", fetch = FetchType.LAZY)
    private List<PvpMatch> pvpMatchesAsPlayer1;

    @OneToMany(mappedBy = "player2", fetch = FetchType.LAZY)
    private List<PvpMatch> pvpMatchesAsPlayer2;

    @OneToMany(mappedBy = "winner", fetch = FetchType.LAZY)
    private List<PvpMatch> wonMatches;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<PvpQueue> pvpQueues;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserBadge> userBadges;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserChallengeProgress> challengeProgress;
}