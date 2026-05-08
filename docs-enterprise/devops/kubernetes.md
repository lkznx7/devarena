# Kubernetes

## Structure

```
infra/kubernetes/
├── namespace/
├── backend/
├── nginx/
├── postgres/
├── redis/
├── rabbitmq/
└── monitoring/
```

## Deploy

```bash
kubectl apply -f infra/kubernetes/namespace/
kubectl apply -f infra/kubernetes/backend/
kubectl apply -f infra/kubernetes/nginx/
```

## Resources

- HPA-ready configurations
- Liveness/readiness probes
- PVC for state persistence
- Ingress configured