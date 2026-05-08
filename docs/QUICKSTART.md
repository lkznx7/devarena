# DevArena - Quick Start

## Requisitos
- Docker 24+
- Docker Compose v2
- Kubernetes (optional)
- 8GB RAM mínimo

## Início Rápido (Docker Compose)

```bash
# Copiar variáveis de ambiente
cp .env.example .env

# Iniciar toda stack
docker-compose up -d

# Verificar status
docker-compose ps

# Logs
docker-compose logs -f

# Parar
docker-compose down
```

## Kubernetes

```bash
# Aplicar namespaces
kubectl apply -f infra/kubernetes/namespace/

# Aplicar configmaps e secrets
kubectl apply -f infra/kubernetes/backend/
kubectl apply -f infra/kubernetes/nginx/
kubectl apply -f infra/kubernetes/postgres/
kubectl apply -f infra/kubernetes/redis/
kubectl apply -f infra/kubernetes/rabbitmq/

# Deploy monitoring
kubectl apply -f infra/kubernetes/monitoring/

# Deploy gateway e backend
kubectl apply -f infra/kubernetes/gateway/
kubectl apply -f infra/kubernetes/backend/

# Deploy nginx
kubectl apply -f infra/kubernetes/nginx/

# Ingress
kubectl apply -f infra/kubernetes/nginx/ingress.yaml
```

## Serviços

| Serviço | URL | Credenciais |
|---------|-----|-------------|
| API | http://localhost/api/ | - |
| Grafana | http://localhost:3000 | admin/admin123 |
| RabbitMQ | http://localhost:15672 | devarena/devarena123 |
| MinIO Console | http://localhost:9001 | devarena/devarena123 |
| Prometheus | http://localhost:9090 | - |

## Scripts

```bash
./scripts/start.sh    # Start local
./scripts/stop.sh     # Stop local
./scripts/deploy.sh    # Deploy K8s
./scripts/logs.sh      # Logs aggregation
```