# Conventions Reference

## DTO Pattern

Request: Java records with validation annotations

Response: Immutable records with mapper

```java
public record UserResponse(
    Long id,
    String username,
    String email,
    Integer level
) {}
```

## Response Wrapper

```java
public record ApiResponse<T>(
    boolean success,
    String message,
    T data,
    LocalDateTime timestamp
) {}
```

## Exception Pattern

- Base: DevArenaException
- Specific: ResourceNotFoundException, ValidationException
- Handler: @RestControllerAdvice

## API Versioning

- URL: /api/v1/*
- Default latest
- Support previous 6 months