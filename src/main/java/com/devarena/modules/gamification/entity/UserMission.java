package com.devarena.modules.gamification.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_missions")
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    private Integer progress;
    private String status;

    public UserMission() {
    }

    public UserMission(Long id, User user, Mission mission, Integer progress, String status) {
        this.id = id;
        this.user = user;
        this.mission = mission;
        this.progress = progress;
        this.status = status;
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

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserMission{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : null) +
                ", mission=" + (mission != null ? mission.getId() : null) +
                ", progress=" + progress +
                ", status='" + status + '\'' +
                '}';
    }
}
