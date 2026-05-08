# Scalability

## Horizontal Scaling (Future)

- Load balancer (Nginx)
- Multiple backend instances (stateless)
- PostgreSQL read replicas
- Redis cluster

## Vertical Scaling (Current)

- Connection pooling (HikariCP)
- Query optimization (indexes)
- Entity caching (Redis)

## Performance Targets

| Metric | Target |
|--------|--------|
| API response | <200ms |
| Code execution | <10s timeout |
| WebSocket | Real-time |

## Bottlenecks Identified

1. **Piston API** - Implement retry with backoff
2. **WebSocket** - Connection limits per user
3. **Database** - Proper transaction handling
4. **MMR** - Server-side validation

## Caching Strategy

- Redis for frequent queries
- Ranking cache
- User session cache

## Rate Limiting

- Redis-based sliding window
- Per-endpoint configuration