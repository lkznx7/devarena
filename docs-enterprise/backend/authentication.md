# Authentication

## Endpoints

```
POST   /api/v1/auth/register    # Register new user
POST   /api/v1/auth/login       # Login
POST   /api/v1/auth/refresh    # Refresh token
POST   /api/v1/auth/logout      # Logout
```

## Login Request

```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

## Login Response

```json
{
  "accessToken": "eyJ...",
  "refreshToken": "eyJ...",
  "expiresIn": 3600
}
```

## OAuth2

Supported providers:
- Google
- GitHub

Flow: OAuth redirect → callback → JWT tokens

## JWT Configuration

| Property | Value |
|----------|-------|
| Algorithm | HS256 |
| Access expiration | 1 hour |
| Refresh expiration | 24 hours |
| Secret | 256-bit minimum |

## Security

- Stateless sessions
- CSRF disabled (API)
- JWT in Authorization header: `Bearer <token>`
- Refresh token rotation