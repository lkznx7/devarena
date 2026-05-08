# NGINX Configuration

## Features

- Rate limiting: 10r/s with burst
- Security headers: CSP, HSTS, X-Frame-Options
- Gzip compression
- WebSocket support

## Files

```
docker/nginx/
├── conf.d/
│   ├── api.conf
│   ├── websocket.conf
│   └── security.conf
└── nginx.conf
```

## Endpoints

| Path | Backend |
|------|---------|
| /api/* | Backend :8080 |
| /ws/* | Backend :8080 |
| /* | Frontend :3000 |