package com.devarena.modules.user.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "xp_transactions")
public class XpTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Integer amount;
    private String reason;

    public XpTransaction() {
    }

    public XpTransaction(Long id, User user, Integer amount, String reason) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.reason = reason;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "XpTransaction{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : null) +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
