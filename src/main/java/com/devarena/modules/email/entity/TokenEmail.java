package com.devarena.modules.email.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;
@Entity
public class TokenEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String token;
    String email;
    LocalTime createdAt = LocalTime.now();
    LocalTime expireAt = createdAt.plusMinutes(10);


    public TokenEmail() {

    }
    public TokenEmail(String token,String email) {

    }
    public TokenEmail(String token, LocalTime createdAt, LocalTime expireAt) {
        this.token = token;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalTime expireAt) {
        this.expireAt = expireAt;
    }
}
