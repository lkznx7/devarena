package com.devarena.modules.gamification.entity;

import com.devarena.modules.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "missions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String type;
    private String goalType;
    private Integer goalValue;
    private Integer xpReward;
    private Boolean isActive;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    private List<UserMission> userMissions;
}