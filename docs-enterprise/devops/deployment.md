# Deployment

## Environments

| Env | Purpose | URL |
|-----|---------|-----|
| Development | Local dev | localhost |
| Staging | Pre-production | (configurable) |
| Production | Live | (configurable) |

## CI/CD

GitHub Actions workflow:
1. Build check
2. Unit tests
3. Build images
4. Deploy to staging
5. Manual approval
6. Deploy to production

## Scripts

```bash
./scripts/start.sh    # Local start
./scripts/stop.sh     # Local stop
./scripts/deploy.sh   # K8s deploy
./scripts/logs.sh     # Log aggregation
```