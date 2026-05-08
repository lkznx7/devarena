# Backend Architecture

## Project Overview

| Property | Value |
|----------|-------|
| Package | com.devarena |
| Artifact | devarena-backend |
| Java | 21 |
| Spring Boot | 3.4.1 |

## Module Structure

```
src/main/java/com/devarena/
├── config/           (6 configs)
├── security/         (5 files)
├── shared/           (8 utilities)
└── modules/          (90+ files)
    ├── auth/
    ├── user/
    ├── challenge/
    ├── submission/
    ├── mission/
    ├── badge/
    ├── ranking/
    ├── pvp/
    ├── notification/
    └── ai/
```

## Component Distribution

| Type | Count |
|------|-------|
| Entities | 19 |
| Repositories | 18 |
| Services | 16 |
| Controllers | 10 |
| DTOs | 13 |
| Enums | 14 |
| Mappers | 9 |

## Module Dependencies

```
auth (base)
  ├── user
  ├── challenge
  ├── submission
  ├── mission
  ├── pvp
  ├── ranking
  ├── notification
  └── ai (independent)
```

## Key Components

### Security
- JWT authentication (stateless)
- OAuth2 support (Google, GitHub)
- Spring Security filter chain

### WebSocket
- STOMP protocol
- Endpoint: `/ws`
- Real-time notifications & PvP

### API Documentation
- OpenAPI 3 / Swagger UI
- Path: `/api-docs`
- Auth: Bearer JWT

## Build & Run

```bash
# Build
./mvnw clean install

# Run
./mvnw spring-boot:run
```

## Endpoints Base Path

```
/api/v1/*
```

## Status

✅ Compiling successfully