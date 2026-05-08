# Getting Started

## Prerequisites

| Tool | Version |
|------|---------|
| Node.js | 18+ |
| Java | 21 |
| Docker | 24+ |
| Git | latest |

## Quick Start

```bash
# Clone
git clone https://github.com/lkznx7/devarena.git
cd devarena

# Start (Docker)
docker-compose up -d

# Or manual:
# Backend: cd backend && ./mvnw spring-boot:run
# Frontend: cd frontend && npm run dev
```

## Verify

| Service | URL |
|---------|-----|
| Frontend | http://localhost:3000 |
| API | http://localhost:8080 |
| Swagger | http://localhost:8080/swagger-ui.html |

## Next Steps

1. Read [Project Structure](./project-structure.md)
2. Read [Local Setup](./local-setup.md)
3. Read [Contribution Guide](./contribution-guide.md)