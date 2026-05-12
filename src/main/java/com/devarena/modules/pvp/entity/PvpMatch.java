package com.devarena.modules.pvp.entity;

import com.devarena.modules.auth.entity.User;
import com.devarena.modules.challenge.entity.Challenge;
import jakarta.persistence.*;

@Entity
@Table(name = "pvp_matches")
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

    public PvpMatch() {
    }

    public PvpMatch(Long id, User player1, User player2, String mode, String status, User winner, Integer player1Score, Integer player2Score, Challenge challenge) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.mode = mode;
        this.status = status;
        this.winner = winner;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.challenge = challenge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public Integer getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(Integer player1Score) {
        this.player1Score = player1Score;
    }

    public Integer getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(Integer player2Score) {
        this.player2Score = player2Score;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    @Override
    public String toString() {
        return "PvpMatch{" +
                "id=" + id +
                ", player1=" + (player1 != null ? player1.getId() : null) +
                ", player2=" + (player2 != null ? player2.getId() : null) +
                ", mode='" + mode + '\'' +
                ", status='" + status + '\'' +
                ", winner=" + (winner != null ? winner.getId() : null) +
                ", player1Score=" + player1Score +
                ", player2Score=" + player2Score +
                ", challenge=" + (challenge != null ? challenge.getId() : null) +
                '}';
    }
}
