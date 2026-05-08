# Infraestrutura DevArena - Relatório Detalhado

## Visão Geral

Estrutura de infraestrutura profissional para projeto enterprise com microsserviços, prepared for future scaling.

## Estrutura de Diretórios

```
infra/
├── docker/                    # Docker images e configurações
│   ├── backend/              # Dockerfile backend Spring Boot
│   ├── nginx/                # Reverse proxy + configs
│   │   ├── conf.d/          # Configurações modulares
│   │   ├── api.conf         # Roteamento API
│   │   ├── websocket.conf   # WebSocket support
│   │   └── security.conf    # Headers segurança
│   ├── postgres/            # PostgreSQL 16 + init scripts
│   ├── redis/               # Redis 7 + config
│   ├── rabbitmq/             # RabbitMQ 3.13 + definitions
│   ├── minio/               # Object storage
│   ├── prometheus/          # Metrics collection
│   ├── grafana/             # Dashboards
│   ├── loki/                # Log aggregation
│   └── promtail/            # Log shipping
│
├── kubernetes/              # K8s manifests
│   ├── namespace/           # Namespaces
│   ├── backend/             # Deployment, Service, ConfigMap, Secret
│   ├── nginx/               # Deployment, Service, Ingress, ConfigMap
│   ├── postgres/            # Deployment, Service, PVC, Secret
│   ├── redis/               # Deployment, Service
│   ├── rabbitmq/            # Deployment, Service, Secret
│   ├── monitoring/          # Prometheus, Grafana, Loki, Promtail
│   └── gateway/             # API Gateway K8s
│
├── scripts/                 # Shell scripts operational
│   ├── start.sh            # Inicialização local
│   ├── stop.sh             # Parada limpa
│   ├── deploy.sh           # Deploy K8s
│   └── logs.sh             # Agregação logs
│
└── gateway/                 # API Gateway project (Spring Cloud Gateway)
    ├── src/main/java/com/devarena/gateway/
    │   ├── config/         # Configurações
    │   ├── filters/        # Filtros customizados
    │   ├── security/       # Segurança
    │   └── routes/         # Definição de rotas
    └── Dockerfile
```

## Componentes

### Backend
- **Technology**: Java 21, Spring Boot
- **Purpose**: API principal
- **Security**: NÃO exposto diretamente, passa pelo nginx
- **Scaling**: Prepared for horizontal scaling

### NGINX Reverse Proxy
- **Purpose**: Single entry point
- **Security Headers**: CSP, HSTS, X-Frame-Options, X-Content-Type-Options
- **Rate Limiting**: 10r/s with burst
- **Gzip**: Enabled for compression
- **WebSocket**: Support configured

### API Gateway (Spring Cloud Gateway)
- **Purpose**: Route, filter, secure requests
- **Location**: Behind nginx
- **Features**: Rate limiting, authentication, request/response transformation

### PostgreSQL 16
- **Purpose**: Primary database
- **Extensions**: uuid-ossp, pg_trgm
- **Initial Schema**: Users table + schema versioning

### Redis 7
- **Purpose**: Caching, sessions
- **Strategy**: allkeys-lru eviction
- **Persistence**: AOF enabled

### RabbitMQ 3.13
- **Purpose**: Message broker, async processing
- **Management**: UI disponível em :15672
- **Metrics**: Prometheus export em :15692

### MinIO
- **Purpose**: S3-compatible object storage
- **Console**: :9001

### Observability Stack
- **Prometheus**: Metrics collection
- **Grafana**: Dashboards and visualization
- **Loki**: Log aggregation
- **Promtail**: Log shipping

## Segurança

### Camadas de Segurança
1. NGINX (edge) → Gateway → Backend
2. Headers de segurança configurados
3. Rate limiting preparado (10r/s, burst 20)
4. Connection limiting (10 connections)
5. Backend isolation (não exposto diretamente)

### Configurações
- CORS preparado
- HTTPS ready (certbot incluso)
- Secrets via K8s Secrets
- Credentials via env/vault-ready

## Docker Compose

Stack completa local com todos os serviços:
- nginx (80, 443)
- gateway (internal)
- backend (internal)
- postgres (5432)
- redis (6379)
- rabbitmq (5672, 15672, 15692)
- minio (9000, 9001)
- prometheus (9090)
- grafana (3000)
- loki (3100)
- promtail (logs)

## Kubernetes

Manifests prepared for:
- Namespaces: devarena, monitoring
- HPA-ready (resources defined)
- Liveness/Readiness probes
- PVCs for state persistence
- Ingress configured

## Scripts Disponíveis

| Script | Função |
|--------|--------|
| start.sh | Inicializa stack local |
| stop.sh | Para containers |
| deploy.sh | Deploy para K8s |
| logs.sh | Agregação de logs |

## Ports Mapping

| Service | Internal Port | External |
|---------|---------------|----------|
| nginx | 80, 443 | 80, 443 |
| postgres | 5432 | 5432 |
| redis | 6379 | 6379 |
| rabbitmq | 5672, 15672 | 5672, 15672 |
| minio | 9000, 9001 | 9000, 9001 |
| prometheus | 9090 | 9090 |
| grafana | 3000 | 3000 |
| loki | 3100 | 3100 |

## Próximos Passos

1. Build das imagens Docker
2. Configurar secrets reais
3. Configurar TLS/SSL
4. Configurar CI/CD
5. Configurar backup strategy
6. Implementar service mesh (Istio)
7. Implementar service discovery

## Standards Applied

- 12-factor app methodology
- Container best practices
- K8s best practices
- Security by design
- Observability ready
- Scaling prepared