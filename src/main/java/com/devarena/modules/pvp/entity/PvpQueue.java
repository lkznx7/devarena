package com.devarena.modules.pvp.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "pvp_queues")
public class PvpQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String mode;
    private String status;

    public PvpQueue() {
    }

    public PvpQueue(Long id, User user, String mode, String status) {
        this.id = id;
        this.user = user;
        this.mode = mode;
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

    @Override
    public String toString() {
        return "PvpQueue{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : null) +
                ", mode='" + mode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
