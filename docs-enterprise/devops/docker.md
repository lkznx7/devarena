# Docker

## Images

| Service | Image | Config |
|---------|-------|--------|
| Backend | openjdk:21-jdk | Multi-stage build |
| Frontend | node:18-alpine | Next.js standalone |
| Nginx | nginx:alpine | Config in conf.d/ |

## Commands

```bash
# Start all services
docker-compose up -d

# View logs
docker-compose logs -f

# Stop
docker-compose down

# Rebuild
docker-compose build --no-cache
```

## Volumes

- postgres_data: PostgreSQL data
- redis_data: Redis persistence