# Error Handling

## Exception Hierarchy

```
DevArenaException (base)
├── ResourceNotFoundException
├── ValidationException
├── AuthenticationException
└── UnauthorizedException
```

## Global Handler

`@RestControllerAdvice` handles all exceptions centrally.

## Error Responses

```json
{
  "success": false,
  "message": "Resource not found: User with id 123",
  "data": null,
  "timestamp": "2026-05-08T10:30:00"
}
```

## HTTP Status Mapping

| Exception | Status |
|-----------|--------|
| ResourceNotFoundException | 404 |
| ValidationException | 400 |
| AuthenticationException | 401 |
| UnauthorizedException | 403 |

## Logging

- ERROR: Exceptions, failures
- WARN: Expected errors
- INFO: Business events
- DEBUG: Detailed info

## Client Error Handling

- 401 → Redirect to login
- 403 → Show permission error
- 404 → Show not found
- 500 → Show generic error