package com.devarena.modules.auth.entity;

import com.devarena.modules.auth.enums.Roles;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {

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
    @Enumerated(EnumType.STRING)
    private Roles role;
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

    public User() {
    }

    public User(UUID id, String email, String password, String displayName, String avatarUrl, String bio, Integer xp, Integer level, String plan, Roles role, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, List<RefreshToken> refreshTokens, List<OAuthAccount> oauthAccounts, List<Notification> notifications, List<UserMission> userMissions, List<Ranking> rankings, List<Follow> following, List<Follow> followers, List<XpTransaction> xpTransactions, UserStats userStats, List<Submission> submissions, List<PvpMatch> pvpMatchesAsPlayer1, List<PvpMatch> pvpMatchesAsPlayer2, List<PvpMatch> wonMatches, List<PvpQueue> pvpQueues, List<UserBadge> userBadges, List<UserChallengeProgress> challengeProgress) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.xp = xp;
        this.level = level;
        this.plan = plan;
        this.role = role;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.refreshTokens = refreshTokens;
        this.oauthAccounts = oauthAccounts;
        this.notifications = notifications;
        this.userMissions = userMissions;
        this.rankings = rankings;
        this.following = following;
        this.followers = followers;
        this.xpTransactions = xpTransactions;
        this.userStats = userStats;
        this.submissions = submissions;
        this.pvpMatchesAsPlayer1 = pvpMatchesAsPlayer1;
        this.pvpMatchesAsPlayer2 = pvpMatchesAsPlayer2;
        this.wonMatches = wonMatches;
        this.pvpQueues = pvpQueues;
        this.userBadges = userBadges;
        this.challengeProgress = challengeProgress;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<RefreshToken> getRefreshTokens() {
        return refreshTokens;
    }

    public void setRefreshTokens(List<RefreshToken> refreshTokens) {
        this.refreshTokens = refreshTokens;
    }

    public List<OAuthAccount> getOauthAccounts() {
        return oauthAccounts;
    }

    public void setOauthAccounts(List<OAuthAccount> oauthAccounts) {
        this.oauthAccounts = oauthAccounts;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<UserMission> getUserMissions() {
        return userMissions;
    }

    public void setUserMissions(List<UserMission> userMissions) {
        this.userMissions = userMissions;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    public List<Follow> getFollowing() {
        return following;
    }

    public void setFollowing(List<Follow> following) {
        this.following = following;
    }

    public List<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follow> followers) {
        this.followers = followers;
    }

    public List<XpTransaction> getXpTransactions() {
        return xpTransactions;
    }

    public void setXpTransactions(List<XpTransaction> xpTransactions) {
        this.xpTransactions = xpTransactions;
    }

    public UserStats getUserStats() {
        return userStats;
    }

    public void setUserStats(UserStats userStats) {
        this.userStats = userStats;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public List<PvpMatch> getPvpMatchesAsPlayer1() {
        return pvpMatchesAsPlayer1;
    }

    public void setPvpMatchesAsPlayer1(List<PvpMatch> pvpMatchesAsPlayer1) {
        this.pvpMatchesAsPlayer1 = pvpMatchesAsPlayer1;
    }

    public List<PvpMatch> getPvpMatchesAsPlayer2() {
        return pvpMatchesAsPlayer2;
    }

    public void setPvpMatchesAsPlayer2(List<PvpMatch> pvpMatchesAsPlayer2) {
        this.pvpMatchesAsPlayer2 = pvpMatchesAsPlayer2;
    }

    public List<PvpMatch> getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(List<PvpMatch> wonMatches) {
        this.wonMatches = wonMatches;
    }

    public List<PvpQueue> getPvpQueues() {
        return pvpQueues;
    }

    public void setPvpQueues(List<PvpQueue> pvpQueues) {
        this.pvpQueues = pvpQueues;
    }

    public List<UserBadge> getUserBadges() {
        return userBadges;
    }

    public void setUserBadges(List<UserBadge> userBadges) {
        this.userBadges = userBadges;
    }

    public List<UserChallengeProgress> getChallengeProgress() {
        return challengeProgress;
    }

    public void setChallengeProgress(List<UserChallengeProgress> challengeProgress) {
        this.challengeProgress = challengeProgress;
    }

    // UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == null) {
            return Collections.emptySet();
        }
        return Set.of(new SimpleGrantedAuthority("ROLE_" + this.role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive != null && isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", bio='" + bio + '\'' +
                ", xp=" + xp +
                ", level=" + level +
                ", plan='" + plan + '\'' +
                ", role=" + role +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
