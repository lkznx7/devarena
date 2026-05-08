# Project Structure

## Root

```
devarena/
├── frontend/          # Next.js app
├── backend/           # Spring Boot app
├── docker/            # Docker configs
├── infra/            # K8s manifests
├── docs/             # Original docs
├── docs-enterprise/  # New docs
└── .github/          # CI/CD
```

## Frontend

```
frontend/src/
├── app/              # Pages
├── components/       # UI components
├── hooks/            # Custom hooks
├── services/         # API clients
├── stores/           # Zustand
└── types/            # TypeScript
```

## Backend

```
backend/src/main/java/com/devarena/
├── config/           # Spring config
├── controller/      # REST controllers
├── dto/              # Request/Response
├── entity/           # JPA entities
├── exception/       # Exceptions
├── repository/       # JPA repos
├── service/          # Business logic
└── security/        # Auth components
```