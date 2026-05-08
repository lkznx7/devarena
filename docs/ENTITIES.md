# DevArena Backend - Entidades e Relacionamentos

## Visão Geral das Entidades

O projeto possui **19 entidades JPA** mapeadas com Lombok e Hibernate.

---

## Entidades por Módulo

### Auth Module

#### User
```java
@Entity
@Table(name = "users")
- id: Long (PK)
- email: String (unique)
- password: String
- displayName: String
- avatarUrl: String
- bio: String
- xp: Integer (default: 0)
- level: Integer (default: 1)
- plan: String (default: "FREE")
- role: String (default: "USER")
- isActive: Boolean (default: true)
- createdAt: LocalDateTime
- updatedAt: LocalDateTime
```

#### OAuthAccount
```java
@Entity
@Table(name = "oauth_accounts")
- id: Long (PK)
- userId: Long (FK)
- provider: String
- providerId: String
- accessToken: String
- refreshToken: String
- expiresAt: LocalDateTime
- createdAt: LocalDateTime
- updatedAt: LocalDateTime
```

#### RefreshToken
```java
@Entity
@Table(name = "refresh_tokens")
- id: Long (PK)
- userId: Long (FK)
- token: String (unique)
- expiresAt: LocalDateTime
- isRevoked: Boolean (default: false)
- createdAt: LocalDateTime
```

---

### User Module

#### UserStats
```java
@Entity
@Table(name = "user_stats")
- id: Long (PK)
- userId: Long (unique FK)
- totalXp: Integer (default: 0)
- challengesCompleted: Integer (default: 0)
- submissionsMade: Integer (default: 0)
- pvpWins: Integer (default: 0)
- pvpLosses: Integer (default: 0)
- currentStreak: Integer (default: 0)
- longestStreak: Integer (default: 0)
- rankScore: Integer (default: 0)
- updatedAt: LocalDateTime
```

#### XpTransaction
```java
@Entity
@Table(name = "xp_transactions")
- id: Long (PK)
- userId: Long (FK)
- amount: Integer
- reason: String
- createdAt: LocalDateTime
```

#### Follow
```java
@Entity
@Table(name = "follows")
- id: Long (PK)
- followerId: Long (FK)
- followingId: Long (FK)
- createdAt: LocalDateTime
```

---

### Challenge Module

#### Topic
```java
@Entity
@Table(name = "topics")
- id: Long (PK)
- name: String
- slug: String (unique)
- description: String
- iconUrl: String
- color: String
- isActive: Boolean (default: true)
- createdAt: LocalDateTime
```

#### Challenge
```java
@Entity
@Table(name = "challenges")
- id: Long (PK)
- title: String
- slug: String (unique)
- description: String
- difficulty: String
- category: String
- defaultCode: String
- solution: String
- language: String
- defaultTestCode: String
- xpReward: Integer (default: 100)
- timeLimit: Integer (default: 1000)
- memoryLimit: Integer (default: 128)
- topic: Topic (ManyToOne)
- hints: List<ChallengeHint> (OneToMany)
- testCases: List<ChallengeTestCase> (OneToMany)
- isActive: Boolean (default: true)
- createdAt: LocalDateTime
- updatedAt: LocalDateTime
```

#### ChallengeHint
```java
@Entity
@Table(name = "challenge_hints")
- id: Long (PK)
- challengeId: Long (FK)
- content: String
- orderIndex: Integer
- xpPenalty: Integer (default: 10)
```

#### ChallengeTestCase
```java
@Entity
@Table(name = "challenge_test_cases")
- id: Long (PK)
- challengeId: Long (FK)
- input: String
- expectedOutput: String
- isHidden: Boolean (default: false)
- orderIndex: Integer
```

#### UserChallengeProgress
```java
@Entity
@Table(name = "user_challenge_progress")
- id: Long (PK)
- userId: Long (FK)
- challengeId: Long (FK)
- status: String (default: "NOT_STARTED")
- currentCode: String
- attempts: Integer (default: 0)
- bestTime: Integer
- completedAt: LocalDateTime
- createdAt: LocalDateTime
- updatedAt: LocalDateTime
```

---

### Submission Module

#### Submission
```java
@Entity
@Table(name = "submissions")
- id: Long (PK)
- userId: Long (FK)
- challengeId: Long (FK)
- code: String
- language: String
- status: String (default: "PENDING")
- errorMessage: String
- executionTime: Integer
- memoryUsed: Integer
- createdAt: LocalDateTime
```

---

### Mission Module

#### Mission
```java
@Entity
@Table(name = "missions")
- id: Long (PK)
- title: String
- description: String
- type: String
- goalType: String
- goalValue: Integer
- xpReward: Integer
- isActive: Boolean (default: true)
- startsAt: LocalDateTime
- expiresAt: LocalDateTime
- createdAt: LocalDateTime
```

#### UserMission
```java
@Entity
@Table(name = "user_missions")
- id: Long (PK)
- userId: Long (FK)
- missionId: Long (FK)
- progress: Integer (default: 0)
- status: String (default: "IN_PROGRESS")
- completedAt: LocalDateTime
- createdAt: LocalDateTime
```

---

### Badge Module

#### Badge
```java
@Entity
@Table(name = "badges")
- id: Long (PK)
- name: String
- description: String
- iconUrl: String
- rarity: String
- category: String
- xpReward: Integer
- requirementType: String
- requirementValue: Integer
- isActive: Boolean (default: true)
- createdAt: LocalDateTime
```

#### UserBadge
```java
@Entity
@Table(name = "user_badges")
- id: Long (PK)
- userId: Long (FK)
- badgeId: Long (FK)
- earnedAt: LocalDateTime
```

---

### Ranking Module

#### Ranking
```java
@Entity
@Table(name = "rankings")
- id: Long (PK)
- userId: Long (FK)
- userDisplayName: String
- userAvatarUrl: String
- score: Integer (default: 0)
- rank: Integer (default: 0)
- type: String
- period: String
- createdAt: LocalDateTime
```

---

### PvP Module

#### PvpMatch
```java
@Entity
@Table(name = "pvp_matches")
- id: Long (PK)
- player1Id: Long (FK)
- player2Id: Long (FK)
- mode: String
- status: String (default: "WAITING")
- winnerId: Long
- player1Score: Integer (default: 0)
- player2Score: Integer (default: 0)
- challengeId: Long
- startedAt: LocalDateTime
- endedAt: LocalDateTime
- createdAt: LocalDateTime
```

#### PvpQueue
```java
@Entity
@Table(name = "pvp_queues")
- id: Long (PK)
- userId: Long (FK)
- mode: String
- status: String (default: "WAITING")
- createdAt: LocalDateTime
```

---

### Notification Module

#### Notification
```java
@Entity
@Table(name = "notifications")
- id: Long (PK)
- userId: Long (FK)
- type: String
- title: String
- message: String
- isRead: Boolean (default: false)
- relatedId: Long
- relatedType: String
- createdAt: LocalDateTime
```

---

## Tabela de Relacionamentos

| Entidade 1 | Relação | Entidade 2 | Tipo |
|------------|---------|------------|------|
| User | 1:N | OAuthAccount | OneToMany |
| User | 1:N | RefreshToken | OneToMany |
| User | 1:1 | UserStats | OneToOne |
| User | 1:N | XpTransaction | OneToMany |
| User | 1:N | Follow (follower) | OneToMany |
| User | 1:N | Follow (following) | OneToMany |
| Challenge | N:1 | Topic | ManyToOne |
| Challenge | 1:N | ChallengeHint | OneToMany |
| Challenge | 1:N | ChallengeTestCase | OneToMany |
| User | 1:N | Submission | OneToMany |
| Challenge | 1:N | Submission | OneToMany |
| User | 1:N | UserMission | OneToMany |
| Mission | 1:N | UserMission | OneToMany |
| User | 1:N | UserBadge | OneToMany |
| Badge | 1:N | UserBadge | OneToMany |
| User | 1:N | Notification | OneToMany |