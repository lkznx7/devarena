# Infrastructure

## Components

| Service | Version | Ports | Purpose |
|---------|---------|-------|---------|
| nginx | latest | 80, 443 | Reverse proxy |
| postgres | 16 | 5432 | Primary database |
| redis | 7 | 6379 | Cache & sessions |
| rabbitmq | 3.13 | 5672, 15672 | Message broker |
| minio | latest | 9000, 9001 | Object storage |
| prometheus | latest | 9090 | Metrics |
| grafana | latest | 3000 | Dashboards |
| loki | latest | 3100 | Log aggregation |

## NGINX Configuration

- Rate limiting: 10r/s with burst
- Security headers: CSP, HSTS, X-Frame-Options
- WebSocket support enabled
- Gzip compression

## Docker Compose

Full local stack available with all services.

## Kubernetes

Manifests prepared for:
- Namespaces: devarena, monitoring
- HPA-ready configurations
- Liveness/readiness probes
- PVCs for state persistence

## Environment

| Variable | Default | Description |
|----------|---------|-------------|
| DB_URL | jdbc:postgresql://localhost:5432/devarena | Database URL |
| DB_USER | postgres | Database user |
| DB_PASSWORD | postgres | Database password |
| APP_PORT | 8080 | Application port |
| JWT_SECRET | (config) | JWT signing secret |

## Standards Applied

- 12-factor app methodology
- Container best practices
- K8s best practices
- Security by design
- Observability ready