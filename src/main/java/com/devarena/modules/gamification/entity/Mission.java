package com.devarena.modules.gamification.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "missions")
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

    public Mission() {
    }

    public Mission(Long id, String title, String description, String type, String goalType, Integer goalValue, Integer xpReward, Boolean isActive, List<UserMission> userMissions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.goalType = goalType;
        this.goalValue = goalValue;
        this.xpReward = xpReward;
        this.isActive = isActive;
        this.userMissions = userMissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public Integer getGoalValue() {
        return goalValue;
    }

    public void setGoalValue(Integer goalValue) {
        this.goalValue = goalValue;
    }

    public Integer getXpReward() {
        return xpReward;
    }

    public void setXpReward(Integer xpReward) {
        this.xpReward = xpReward;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<UserMission> getUserMissions() {
        return userMissions;
    }

    public void setUserMissions(List<UserMission> userMissions) {
        this.userMissions = userMissions;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", goalType='" + goalType + '\'' +
                ", goalValue=" + goalValue +
                ", xpReward=" + xpReward +
                ", isActive=" + isActive +
                '}';
    }
}
