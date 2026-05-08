# API Standards

## Versioning

- URL-based: `/api/v1/...`
- Default to latest version

## Base Endpoints

```
/api/v1/auth/*
/api/v1/users/*
/api/v1/challenges/*
/api/v1/submissions/*
/api/v1/missions/*
/api/v1/rankings/*
/api/v1/pvp/*
/api/v1/notifications/*
/api/v1/ai/*
```

## HTTP Methods

| Method | Usage |
|--------|-------|
| GET | Retrieve |
| POST | Create |
| PUT | Full update |
| PATCH | Partial update |
| DELETE | Delete |

## Status Codes

| Code | Meaning |
|------|---------|
| 200 | Success |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 422 | Validation Error |
| 500 | Internal Error |

## Response Format

```json
{
  "success": true,
  "message": "Success",
  "data": { ... },
  "timestamp": "2026-05-08T10:30:00"
}
```

## Pagination

```json
{
  "content": [...],
  "page": 0,
  "size": 20,
  "totalElements": 100,
  "totalPages": 5
}
```

## Documentation

- Swagger UI: `/swagger-ui.html`
- OpenAPI JSON: `/api-docs`