# DevArena

A gamified programming learning platform that combines elements from Duolingo, LeetCode, Discord, and RPGs.

## Overview

DevArena is an innovative platform designed to make programming education engaging, fun, and effective. Users can compete in real-time coding battles, solve progressive challenges, earn XP, level up, and track their progress through a comprehensive gamification system.

## Tech Stack

### Frontend
| Technology | Version | Purpose |
|------------|---------|---------|
| Next.js | 15 | React framework with App Router |
| TypeScript | 5 | Type-safe development |
| TailwindCSS | 4 | Utility-first CSS |
| Zustand | - | Client state management |
| TanStack Query | 5 | Server state management |
| shadcn/ui | - | UI components (Radix) |
| Framer Motion | - | Animations |

### Backend
| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 21 | Programming language |
| Spring Boot | 3.4 | Application framework |
| Spring Security | 6.x | Authentication/Authorization |
| JWT | 0.12.6 | Stateless auth |
| WebSocket | STOMP | Real-time communication |
| PostgreSQL | 16 | Primary database |
| Redis | 7 | Cache & sessions |

### Infrastructure
| Technology | Purpose |
|------------|---------|
| Docker | Containerization |
| Docker Compose | Orchestration |
| Nginx | Reverse proxy |
| Kubernetes | Orchestration (ready) |

### External APIs
| API | Purpose |
|-----|---------|
| Piston | Code execution engine |
| Groq | AI-powered assistance |

## Architecture

```
Client -> Nginx -> Backend (Spring Boot)
                   |
             +-----+-----+
             |           |
          PostgreSQL    Redis
```

## Modules

### Backend Modules
| Module | Description |
|--------|-------------|
| Auth | JWT + OAuth2 authentication |
| User | Profile, stats, XP, streak, follow |
| Challenge | Topics, challenges, hints, test cases |
| Submission | Code execution via Piston API |
| Mission | Daily/weekly missions |
| Badge | Achievements system |
| Ranking | Leaderboards |
| PvP | Real-time battles with WebSocket |
| Notification | Real-time notifications |
| AI | Groq-powered hints and code review |

### Frontend Pages
| Route | Description |
|-------|-------------|
| /public | Landing page |
| /auth/login | Login page |
| /auth/register | Registration page |
| /dashboard | Main dashboard |
| /dashboard/profile | User profile |
| /dashboard/settings | Settings |
| /dashboard/chat | Chat interface |
| /dashboard/users | User management |

## Project Structure

```
devarena/
├── frontend/              # Next.js application
├── backend/               # Spring Boot application
│   └── DevArenaBackend/
│       └── src/main/java/com/devarena/
│           ├── config/
│           ├── controller/
│           ├── dto/
│           ├── entity/
│           ├── exception/
│           ├── repository/
│           ├── service/
│           └── security/
├── docker/                # Docker configurations
├── infra/                 # Kubernetes manifests
├── docs/                  # Original documentation
├── docs-enterprise/       # Enterprise documentation
└── .github/               # CI/CD workflows
```

## Getting Started

### Prerequisites
- Node.js 18+
- Java 21
- Docker 24+
- Docker Compose v2

### Quick Start

```bash
# Clone the repository
git clone https://github.com/lkznx7/devarena.git
cd devarena

# Copy environment variables
cp .env.example .env

# Start all services
docker-compose up -d
```

### Manual Setup

**Backend:**
```bash
cd backend/DevArenaBackend
./mvnw clean install
./mvnw spring-boot:run
```

**Frontend:**
```bash
cd frontend
npm install
npm run dev
```

### Services
| Service | URL |
|---------|-----|
| Frontend | http://localhost:3000 |
| API | http://localhost:8080 |
| Swagger UI | http://localhost:8080/swagger-ui.html |
| OpenAPI JSON | http://localhost:8080/api-docs |

## Documentation

Enterprise-level documentation available in `docs-enterprise/`:

- `architecture/` - System architecture
- `backend/` - Backend implementation
- `frontend/` - Frontend implementation
- `devops/` - Infrastructure & deployment
- `product/` - Product specifications
- `engineering/` - Engineering standards
- `onboarding/` - Developer onboarding

## Contributing

1. Fork the repository
2. Create a feature branch (`feature/description`)
3. Make your changes
4. Submit a Pull Request

See [CONTRIBUTING.md](CONTRIBUTING.md) for details.

## License

MIT License - See [LICENSE](LICENSE) file for details.

---

Built with passion for developers, by developers.