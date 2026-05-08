# Monitoring

## Stack

| Tool | Port | Purpose |
|------|------|---------|
| Prometheus | 9090 | Metrics collection |
| Grafana | 3000 | Dashboards |
| Loki | 3100 | Log aggregation |
| Promtail | - | Log shipping |

## Access

- Grafana: admin/admin123 (change in production)
- Prometheus: http://localhost:9090

## Dashboards

Pre-configured dashboards for:
- Backend health
- API performance
- Database metrics