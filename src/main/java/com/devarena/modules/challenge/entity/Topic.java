package com.devarena.modules.challenge.entity;

import com.devarena.modules.challenge.enums.ProgrammingLanguage;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private ProgrammingLanguage language;

    private Integer orderIndex;

    @OneToMany(mappedBy = "topic")
    private List<Challenge> challenges;

    public Topic() {}

    public Topic(Long id, String name, String slug, String description, ProgrammingLanguage language, Integer orderIndex) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.language = language;
        this.orderIndex = orderIndex;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ProgrammingLanguage getLanguage() { return language; }
    public void setLanguage(ProgrammingLanguage language) { this.language = language; }

    public Integer getOrderIndex() { return orderIndex; }
    public void setOrderIndex(Integer orderIndex) { this.orderIndex = orderIndex; }

    public List<Challenge> getChallenges() { return challenges; }
    public void setChallenges(List<Challenge> challenges) { this.challenges = challenges; }

    @Override
    public String toString() {
        return "Topic{id=" + id + ", name='" + name + "', language=" + language + "}";
    }
}
