package com.devarena.modules.auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String token;
    private Boolean isRevoked;

    public RefreshToken() {
    }

    public RefreshToken(Long id, User user, String token, Boolean isRevoked) {
        this.id = id;
        this.user = user;
        this.token = token;
        this.isRevoked = isRevoked;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsRevoked() {
        return isRevoked;
    }

    public void setIsRevoked(Boolean isRevoked) {
        this.isRevoked = isRevoked;
    }

    @Override
    public String toString() {
        return "RefreshToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", isRevoked=" + isRevoked +
                '}';
    }
}
