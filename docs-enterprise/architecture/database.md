# Database Schema

## Entities (19 Total)

### Authentication
| Entity | Description |
|--------|-------------|
| User | Core user entity |
| OAuthAccount | OAuth provider links |
| RefreshToken | JWT refresh tokens |

### User & Gamification
| Entity | Description |
|--------|-------------|
| UserStats | XP, level, rank scores |
| XpTransaction | XP history |
| Follow | Social connections |

### Challenges
| Entity | Description |
|--------|-------------|
| Topic | Challenge categories |
| Challenge | Programming challenges |
| ChallengeHint | Progressive hints |
| ChallengeTestCase | Test cases |
| UserChallengeProgress | User progress tracking |

### Submission
| Entity | Description |
|--------|-------------|
| Submission | Code submission records |

### Mission System
| Entity | Description |
|--------|-------------|
| Mission | Daily/weekly missions |
| UserMission | User mission progress |

### Achievements
| Entity | Description |
|--------|-------------|
| Badge | Achievement definitions |
| UserBadge | Earned badges |

### PvP System
| Entity | Description |
|--------|-------------|
| PvpMatch | Match records |
| PvpQueue | Matchmaking queue |

### Social
| Entity | Description |
|--------|-------------|
| Ranking | Leaderboard snapshots |
| Notification | User notifications |

## Relationships

| Entity | Relation | Entity |
|--------|----------|--------|
| User | 1:N | OAuthAccount |
| User | 1:1 | UserStats |
| Challenge | N:1 | Topic |
| Challenge | 1:N | ChallengeTestCase |
| Submission | N:1 | User, Challenge |

## Indexes

Indexes defined on:
- User.email (unique)
- Challenge.slug (unique)
- Topic.slug (unique)
- RefreshToken.token (unique)
- Various foreign keys