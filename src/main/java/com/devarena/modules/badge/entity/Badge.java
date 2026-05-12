package com.devarena.modules.badge.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String iconUrl;
    private String rarity;
    private String category;
    private Integer xpReward;
    private String requirementType;
    private Integer requirementValue;
    private Boolean isActive;

    @OneToMany(mappedBy = "badge", fetch = FetchType.LAZY)
    private List<UserBadge> userBadges;

    public Badge() {
    }

    public Badge(Long id, String name, String description, String iconUrl, String rarity, String category, Integer xpReward, String requirementType, Integer requirementValue, Boolean isActive, List<UserBadge> userBadges) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.iconUrl = iconUrl;
        this.rarity = rarity;
        this.category = category;
        this.xpReward = xpReward;
        this.requirementType = requirementType;
        this.requirementValue = requirementValue;
        this.isActive = isActive;
        this.userBadges = userBadges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getXpReward() {
        return xpReward;
    }

    public void setXpReward(Integer xpReward) {
        this.xpReward = xpReward;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public Integer getRequirementValue() {
        return requirementValue;
    }

    public void setRequirementValue(Integer requirementValue) {
        this.requirementValue = requirementValue;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<UserBadge> getUserBadges() {
        return userBadges;
    }

    public void setUserBadges(List<UserBadge> userBadges) {
        this.userBadges = userBadges;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", rarity='" + rarity + '\'' +
                ", category='" + category + '\'' +
                ", xpReward=" + xpReward +
                ", requirementType='" + requirementType + '\'' +
                ", requirementValue=" + requirementValue +
                ", isActive=" + isActive +
                '}';
    }
}
