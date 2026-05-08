# System Design

## High-Level Architecture

```
┌─────────────┐
│   Clients   │
└──────┬──────┘
       │
┌──────▼──────┐
│    NGINX    │
│   Reverse   │
│    Proxy    │
└──────┬──────┘
       │
┌──────▼──────┐
│    API      │
│   Gateway   │
│  (Future)   │
└──────┬──────┘
       │
┌──────▼──────┐
│   Backend   │
│  (Spring)   │
└──────┬──────┘
       │
 ┌────┼────┐
 │    │    │
 ▼    ▼    ▼
Postgres Redis External
```

## Request Flow

```
Client → Nginx → Backend → Redis (Cache)
                    ↓
                  PostgreSQL
```

## Layers

### 1. NGINX Layer
- SSL termination (future)
- Rate limiting (10r/s)
- Security headers
- Static content serving
- Load balancing

### 2. Gateway Layer (Future)
- Route management
- Authentication
- Request/response transform
- Circuit breaker

### 3. Application Layer
- REST API (Spring Boot)
- Business logic
- Data access
- Async processing (future: RabbitMQ)

### 4. Data Layer
- PostgreSQL: Primary database
- Redis: Cache & sessions
- External: Piston (code execution), Groq (AI)

## Network Isolation

| Component | Exposure |
|-----------|----------|
| nginx | public |
| gateway | internal |
| backend | internal |
| postgres | internal |
| redis | internal |

## High Availability

| Component | Strategy |
|-----------|----------|
| Nginx | 2+ replicas |
| Backend | Horizontal scaling |
| PostgreSQL | StatefulSet-ready |
| Redis | AOF persistence |

## Monitoring

```
Logs → Promtail → Loki → Grafana
Metrics → Prometheus → Grafana
```