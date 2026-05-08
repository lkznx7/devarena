# Local Setup

## Docker Setup

```bash
# Copy env
cp .env.example .env

# Start services
docker-compose up -d

# Verify
docker-compose ps
```

## Manual Backend Setup

```bash
cd backend

# Build
./mvnw clean install

# Run
./mvnw spring-boot:run
```

## Manual Frontend Setup

```bash
cd frontend

# Install
npm install

# Run
npm run dev
```

## Environment Variables

Create `.env.local` in frontend:
```
NEXT_PUBLIC_API_URL=http://localhost:8080/api
```

## Ports

| Service | Port |
|---------|------|
| Frontend | 3000 |
| Backend | 8080 |
| PostgreSQL | 5432 |
| Redis | 6379 |