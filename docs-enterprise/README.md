# DevArena - Technical Documentation

## Overview

DevArena is a gamified programming learning platform that combines elements from Duolingo, LeetCode, Discord, and RPGs.

## Tech Stack

| Layer | Technology |
|-------|------------|
| Frontend | Next.js 15, TypeScript, TailwindCSS, Zustand, TanStack Query |
| Backend | Java 21, Spring Boot 3.4, Spring Security, JWT, WebSocket |
| Database | PostgreSQL 16, Redis 7 |
| Infrastructure | Docker, Nginx, Kubernetes-ready |

## Documentation Structure

```
docs-enterprise/
├── architecture/          # System architecture
├── backend/               # Backend implementation
├── frontend/              # Frontend implementation
├── devops/                # Infrastructure & deployment
├── product/               # Product specifications
├── engineering/           # Engineering standards
└── onboarding/           # Developer onboarding
```

## Quick Links

- [Architecture Overview](./architecture/system-design.md)
- [Backend Modules](./backend/modules.md)
- [Frontend Structure](./frontend/frontend-architecture.md)
- [Coding Standards](./engineering/coding-standards.md)
- [Getting Started](./onboarding/getting-started.md)

## Resources

| Service | URL |
|---------|-----|
| API | http://localhost:8080 |
| Swagger | http://localhost:8080/swagger-ui.html |
| Frontend | http://localhost:3000 |

## License

MIT License - See [LICENSE](../LICENSE)