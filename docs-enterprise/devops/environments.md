# Environments

## Variables

| Variable | Dev | Staging | Production |
|----------|-----|---------|------------|
| DB_URL | localhost | (config) | (config) |
| JWT_SECRET | dev-secret | (env) | (env) |
| API_URL | localhost:8080 | (url) | (url) |

## Configuration

Environment-specific configs in:
- Backend: application-{profile}.yml
- Frontend: .env.local

## Secrets

Never commit secrets. Use:
- Environment variables
- K8s Secrets
- Vault (future)