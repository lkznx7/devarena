# DevArena - Architecture Overview

## Table of Contents

1. [System Architecture](#system-architecture)
2. [Technology Stack](#technology-stack)
3. [Project Structure](#project-structure)
4. [Module Design](#module-design)
5. [Data Flow](#data-flow)
6. [Security](#security)
7. [Scalability](#scalability)

---

## System Architecture

### High-Level Architecture

```
┌─────────────────────────────────────────────────────────────────────────┐
│                            CLIENT LAYER                                  │
│  ┌─────────────────────────────────────────────────────────────────────┐ │
│  │                      Next.js Frontend                               │ │
│  │  ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐  │ │
│  │  │  Pages   │ │Components│ │  Hooks   │ │  Stores  │ │ Services │  │ │
│  │  └──────────┘ └──────────┘ └──────────┘ └──────────┘ └──────────┘  │ │
│  └─────────────────────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ HTTPS/WSS
                                    ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                           PROXY LAYER                                    │
│  ┌─────────────────────────────────────────────────────────────────────┐ │
│  │                           Nginx                                     │ │
│  │         (SSL Termination, Load Balancing, Caching)                │ │
│  └─────────────────────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                           API GATEWAY                                    │
│  ┌─────────────────────────────────────────────────────────────────────┐ │
│  │                    Spring Boot API Gateway                         │ │
│  │  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐   │ │
│  │  │   Auth      │ │   Rate      │ │     Log     │ │    Cache    │   │ │
│  │  │   Filter    │ │   Limiter   │ │   Gateway   │ │   Layer     │   │ │
│  │  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘   │ │
│  └─────────────────────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────────────────────┘
                                    │
                    ┌───────────────┼───────────────┐
                    ▼               ▼               ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                          SERVICE LAYER                                   │
│  ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐      │
│  │   Auth   │ │   User   │ │Challenge│ │   Rank   │ │  Notif   │      │
│  │ Service  │ │ Service  │ │ Service  │ │ Service  │ │ Service  │      │
│  └──────────┘ └──────────┘ └──────────┘ └──────────┘ └──────────┘      │
│  ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐      │
│  │   PvP    │ │   AI     │ │ Mission  │ │  Submis  │ │  Social  │      │
│  │ Service  │ │ Service  │ │ Service  │ │ Service  │ │ Service  │      │
│  └──────────┘ └──────────┘ └──────────┘ └──────────┘ └──────────┘      │
└─────────────────────────────────────────────────────────────────────────┘
                                    │
                    ┌───────────────┼───────────────┐
                    ▼               ▼               ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                            DATA LAYER                                    │
│  ┌──────────────────┐  ┌──────────────────┐  ┌──────────────────┐     │
│  │   PostgreSQL     │  │      Redis       │  │   External API   │     │
│  │   (Primary DB)   │  │  (Cache/Session) │  │ (Piston/Groq)    │     │
│  └──────────────────┘  └──────────────────┘  └──────────────────┘     │
└─────────────────────────────────────────────────────────────────────────┘
```

### Architecture Pattern

We use **Modular Monolith** architecture with **Layered Architecture**:

```
┌────────────────────────────────────────────────────────────────┐
│                    PRESENTATION LAYER                         │
│  (Controllers, DTOs, Response Wrappers)                       │
├────────────────────────────────────────────────────────────────┤
│                    APPLICATION LAYER                           │
│  (Services, Use Cases, Business Logic)                       │
├────────────────────────────────────────────────────────────────┤
│                      DOMAIN LAYER                              │
│  (Entities, Value Objects, Domain Events, Repositories)     │
├────────────────────────────────────────────────────────────────┤
│                   INFRASTRUCTURE LAYER                        │
│  (Database, External APIs, Messaging, Caching)               │
└────────────────────────────────────────────────────────────────┘
```

---

## Technology Stack

### Frontend

| Technology | Version | Purpose |
|------------|---------|---------|
| Next.js | 15.x | React framework with App Router |
| TypeScript | 5.x | Type-safe JavaScript |
| TailwindCSS | 3.x | Utility-first CSS |
| Shadcn/UI | latest | UI component library |
| Framer Motion | 11.x | Animations |
| Zustand | 4.x | State management |
| TanStack Query | 5.x | Server state |

### Backend

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 21 | Programming language |
| Spring Boot | 3.3 | Application framework |
| Spring Security | 6.x | Authentication/Authorization |
| Spring Data JPA | 3.x | ORM/Hibernate |
| Spring WebSocket | 6.x | Real-time communication |
| Spring Cache | 6.x | Caching |
| PostgreSQL | 15.x | Primary database |
| Redis | 7.x | Cache/Session/Pub-Sub |

### Infrastructure

| Technology | Version | Purpose |
|------------|---------|---------|
| Docker | 24.x | Containerization |
| Docker Compose | 2.x | Orchestration |
| Nginx | 1.x | Reverse proxy/Load balancer |

### External Services

| Service | Purpose |
|---------|---------|
| Piston API | Code execution (sandbox) |
| Groq API | AI-powered code assistance |

---

## Project Structure

### Root Structure

```
devarena/
├── frontend/                 # Next.js application
│   ├── src/
│   │   ├── app/             # Next.js App Router pages
│   │   ├── components/      # Reusable UI components
│   │   ├── hooks/           # Custom React hooks
│   │   ├── lib/             # Utilities and helpers
│   │   ├── services/        # API service layer
│   │   ├── stores/          # Zustand stores
│   │   ├── types/           # TypeScript types
│   │   └── styles/          # Global styles
│   ├── public/              # Static assets
│   ├── tests/               # Test files
│   └── package.json
│
├── backend/                  # Spring Boot application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/devarena/
│   │   │   │       ├── config/         # Configuration classes
│   │   │   │       ├── controller/    # REST controllers
│   │   │   │       ├── dto/            # Data Transfer Objects
│   │   │   │       ├── entity/         # JPA entities
│   │   │   │       ├── exception/      # Custom exceptions
│   │   │   │       ├── repository/    # JPA repositories
│   │   │   │       ├── security/       # Security config
│   │   │   │       └── service/        # Business logic
│   │   │   └── resources/
│   │   │       ├── application.yml
│   │   │       └── application-*.yml
│   │   └── test/
│   │       └── java/
│   └── pom.xml
│
├── docker/                   # Docker configurations
│   ├── docker-compose.yml
│   ├── Dockerfile.frontend
│   ├── Dockerfile.backend
│   └── nginx.conf
│
└── docs/                     # Documentation
    ├── architecture.md
    ├── conventions.md
    ├── api/
    └── guides/
```

### Backend Module Structure

```
com/devarena/
├── DevArenaApplication.java
│
├── module/
│   ├── auth/                    # Authentication module
│   │   ├── controller/
│   │   │   └── AuthController.java
│   │   ├── dto/
│   │   ├── entity/
│   │   │   ├── User.java
│   │   │   └── UserToken.java
│   │   ├── repository/
│   │   ├── service/
│   │   │   └── AuthService.java
│   │   └── security/
│   │       ├── JwtTokenProvider.java
│   │       └── JwtAuthenticationFilter.java
│   │
│   ├── user/                    # User management module
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   │
│   ├── challenge/               # Challenge system module
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   │
│   ├── submission/              # Code submission module
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   │
│   ├── mission/                 # Mission/Quest system module
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   │
│   ├── ranking/                 # Ranking/Leaderboard module
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   │
│   ├── pvp/                     # PvP Arena module
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   │   └── websocket/
│   │
│   ├── notification/            # Notification module
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   │   └── websocket/
│   │
│   └── ai/                      # AI Mentor module
│       ├── controller/
│       ├── dto/
│       ├── entity/
│       ├── repository/
│       └── service/
│
└── shared/                      # Shared utilities
    ├── config/
    ├── exception/
    ├── response/
    └── security/
```

---

## Module Design

### 1. Auth Module

**Responsibilities:**
- User registration and login
- JWT token generation and validation
- Password hashing and verification
- Session management
- OAuth integration (future)

**Key Components:**
- `AuthController` - REST endpoints
- `AuthService` - Business logic
- `JwtTokenProvider` - JWT handling
- `UserDetailsService` - User loading

### 2. User Module

**Responsibilities:**
- User profile management
- Avatar and customization
- Statistics tracking
- Achievement management
- Friend system

**Key Components:**
- `UserController` - REST endpoints
- `UserService` - Business logic
- `ProfileService` - Profile management

### 3. Challenge Module

**Responsibilities:**
- Challenge CRUD operations
- Category management
- Difficulty levels
- Test case validation
- Hints system

**Key Components:**
- `ChallengeController` - REST endpoints
- `ChallengeService` - Business logic
- `TestCaseRunner` - Code validation

### 4. Submission Module

**Responsibilities:**
- Code submission handling
- Code execution via Piston API
- Result validation
- Submission history

**Key Components:**
- `SubmissionController` - REST endpoints
- `SubmissionService` - Business logic
- `CodeExecutor` - Piston integration

### 5. Mission Module

**Responsibilities:**
- Daily/Weekly missions
- Quest chains
- Streak tracking
- Reward distribution
- Progress visualization

**Key Components:**
- `MissionController` - REST endpoints
- `MissionService` - Business logic
- `StreakCalculator` - Streak logic

### 6. Ranking Module

**Responsibilities:**
- Global leaderboard
- XP calculation
- Level progression
- Ranking algorithms

**Key Components:**
- `RankingController` - REST endpoints
- `RankingService` - Business logic
- `XpCalculator` - XP logic

### 7. PvP Module

**Responsibilities:**
- Real-time PvP matches
- Matchmaking system
- Arena management
- Live coding battles

**Key Components:**
- `PvPController` - REST endpoints
- `PvPService` - Business logic
- `Matchmaker` - Matchmaking algorithm
- `PvPWebSocketHandler` - Real-time communication

### 8. Notification Module

**Responsibilities:**
- In-app notifications
- Real-time notifications via WebSocket
- Notification preferences
- Push notifications (future)

**Key Components:**
- `NotificationController` - REST endpoints
- `NotificationService` - Business logic
- `WebSocketHandler` - Real-time push

### 9. AI Module

**Responsibilities:**
- AI code assistance via Groq
- Code review and suggestions
- Hint generation
- Learning recommendations

**Key Components:**
- `AIController` - REST endpoints
- `AIService` - Business logic
- `GroqClient` - External API client

---

## Data Flow

### Authentication Flow

```
1. User submits login credentials
     ↓
2. AuthController receives POST /api/v1/auth/login
     ↓
3. AuthService validates credentials
     ↓
4. JwtTokenProvider generates JWT tokens
     ↓
5. Response with access/refresh tokens
     ↓
6. Frontend stores tokens
     ↓
7. Subsequent requests include JWT in Authorization header
     ↓
8. JwtAuthenticationFilter validates token
     ↓
9. SecurityContext set for request
```

### Code Submission Flow

```
1. User submits code solution
     ↓
2. SubmissionController receives POST /api/v1/submissions
     ↓
3. SubmissionService creates submission record
     ↓
4. CodeExecutor sends code to Piston API
     ↓
5. Piston executes code in sandbox
     ↓
6. Results returned and validated
     ↓
7. Submission record updated with results
     ↓
8. XP/Rewards calculated if passed
     ↓
9. Notification sent to user
```

### Real-time PvP Flow

```
1. User joins PvP queue
     ↓
2. Matchmaker finds opponent
     ↓
3. PvPWebSocketHandler creates match session
     ↓
4. Both users connect to WebSocket
     ↓
5. Challenge presented to both
     ↓
6. Real-time code submissions via WebSocket
     ↓
7. Code execution on each submission
     ↓
8. Live leaderboard updates
     ↓
9. Winner determined
     ↓
10. XP/Rewards distributed
     ↓
11. Match history saved
```

---

## Security

### Authentication & Authorization

- JWT-based authentication
- Access tokens (short-lived: 15 min)
- Refresh tokens (long-lived: 7 days)
- Password hashing with BCrypt
- Role-based access control (RBAC)

### API Security

- HTTPS only in production
- Rate limiting per user/IP
- CORS configuration
- Input validation and sanitization
- SQL injection prevention (parameterized queries)
- XSS prevention (output encoding)

### Code Execution Security

- Piston API sandbox isolation
- Execution timeout limits
- Memory limits per execution
- No file system access in sandbox

### Data Security

- Database encryption at rest
- TLS for data in transit
- Environment variable secrets
- No secrets in code

---

## Scalability

### Horizontal Scaling

- Stateless backend services
- Session storage in Redis
- Database connection pooling
- Load balancing via Nginx

### Caching Strategy

- Redis for:
  - User sessions
  - API response caching
  - Leaderboard data
  - Challenge metadata
- HTTP caching headers
- CDN for static assets (frontend)

### Database Optimization

- Indexes on frequently queried columns
- Pagination for large datasets
- Batch operations for bulk updates
- Read replicas for heavy read queries

### Real-time Optimization

- WebSocket connection pooling
- Message queue for notifications
- Pub/Sub for live updates
- Room-based WebSocket management

---

## Monitoring & Observability

### Logging

- Structured JSON logging
- Log levels: ERROR, WARN, INFO, DEBUG
- Request/response logging
- Exception stack traces

### Metrics

- Response time metrics
- API usage metrics
- Error rate tracking
- User activity metrics

### Health Checks

- `/actuator/health` endpoint
- Database connectivity check
- Redis connectivity check
- External API availability

---

## CI/CD Pipeline

```
┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│    Push     │ →  │   Build     │ →  │    Test     │ →  │   Deploy    │
│  to branch  │    │  (Compile)  │    │  (CI/CD)    │    │ (Staging)   │
└─────────────┘    └─────────────┘    └─────────────┘    └─────────────┘
                                                                        │
                                                                        ▼
                                                               ┌─────────────┐
                                                               │   Deploy    │
                                                               │ (Production)│
                                                               └─────────────┘
```

---

## Future Considerations

- Microservices migration (if needed)
- GraphQL API layer
- Mobile app (React Native/Flutter)
- Multi-language support
- More external API integrations
- Advanced analytics dashboard