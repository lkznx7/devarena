# Security Architecture

## Authentication

### JWT
- Stateless token-based auth
- Access token: 1 hour expiration
- Refresh token: 24 hours expiration
- Secret: 256-bit minimum

### OAuth2
- Providers: Google, GitHub
- Access/refresh token storage

## Security Layers

```
NGINX (edge) → Gateway (future) → Backend
```

## Configuration

| Setting | Value |
|---------|-------|
| CSRF | Disabled (API) |
| Session | Stateless |
| CORS | Configured |
| Rate Limit | 10r/s |

## Public Endpoints

- `/api-docs/**`
- `/swagger-ui/**`
- `/actuator/**`
- `/ws/*` (WebSocket)

## Protected Resources

All other endpoints require valid JWT token.

## Headers

Security headers configured:
- Content-Security-Policy
- X-Frame-Options
- X-Content-Type-Options
- HSTS (future)

## Dependencies

- Spring Security 6.x
- JWT (jjwt 0.12.6)
- Spring OAuth2 Client