package com.devarena.modules.notification.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String type;
    private String title;
    private String message;
    private Boolean isRead;
    private Long relatedId;
    private String relatedType;

    public Notification() {
    }

    public Notification(Long id, User user, String type, String title, String message, Boolean isRead, Long relatedId, String relatedType) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.title = title;
        this.message = message;
        this.isRead = isRead;
        this.relatedId = relatedId;
        this.relatedType = relatedType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Long getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
    }

    public String getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : null) +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", isRead=" + isRead +
                ", relatedId=" + relatedId +
                ", relatedType='" + relatedType + '\'' +
                '}';
    }
}
