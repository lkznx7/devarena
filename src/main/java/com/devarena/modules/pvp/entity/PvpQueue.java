package com.devarena.modules.pvp.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pvp_queues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PvpQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String mode;
    private String status;
}