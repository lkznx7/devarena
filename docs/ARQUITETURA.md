# DevArena - Arquitetura

## Diagrama de Arquitetura

```
                    ┌─────────────┐
                    │   Clients   │
                    └──────┬──────┘
                           │
                    ┌──────▼──────┐
                    │    NGINX    │
                    │ Reverse     │
                    │   Proxy     │
                    └──────┬──────┘
                           │
              ┌────────────┼────────────┐
              │            │            │
       ┌──────▼──────┐     │     ┌─────▼─────┐
       │     API     │     │     │  WebSocket│
       │   Gateway   │     │     │  Service  │
       └──┬─────┬────┘     │     └─────┬─────┘
          │     │          │           │
    ┌─────▼─┐ ┌▼────────┐  │           │
    │Backend│ │Backend 2│  │           │
    │ (API) │ │(Worker) │  │           │
    └───────┘ └─────────┘  │           │
                           │           │
     ┌─────────────────────┴───────────┤
     │                                   │
  ┌──▼───┐   ┌──────┐   ┌────────┐  ┌──▼──┐
  │Postgres│  │ Redis│   │RabbitMQ│  │MinIO│
  └───────┘   └──────┘   └────────┘  └─────┘
```

## Fluxo de Request

```
Client → Nginx (Security) → Gateway (Route) → Backend
                                       ↓
                                    Redis (Cache)
                                    RabbitMQ (Queue)
                                    PostgreSQL (Data)
```

## Componentes

### NGINX Layer
- SSL Termination (futuro)
- Rate Limiting
- Security Headers
- Static Content
- Load Balancing

### Gateway Layer
- Route Management
- Authentication
- Request/Response Transform
- Rate Limiting
- Circuit Breaker

### Application Layer
- REST API
- Business Logic
- Data Access
- Async Processing

### Data Layer
- PostgreSQL (Primary DB)
- Redis (Cache/Session)
- RabbitMQ (Messages)
- MinIO (Files)

## Network Isolation

```yaml
nginx: public
gateway: internal
backend: internal
postgres: internal
redis: internal
rabbitmq: internal
```

## High Availability

- Nginx: 2 replicas
- Gateway: 2 replicas
- Backend: 2 replicas
- PostgreSQL: StatefulSet ready
- Redis: AOF persistence
- RabbitMQ: Clustering ready

## Monitoring Flow

```
Logs → Promtail → Loki → Grafana
Metrics → Prometheus → Grafana
Traces → (future: Jaeger)
```