package com.devarena.modules.auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "oauth_accounts")
public class OAuthAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String provider;
    private String providerId;
    private String accessToken;
    private String refreshToken;

    public OAuthAccount() {
    }

    public OAuthAccount(Long id, User user, String provider, String providerId, String accessToken, String refreshToken) {
        this.id = id;
        this.user = user;
        this.provider = provider;
        this.providerId = providerId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "OAuthAccount{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                ", providerId='" + providerId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
