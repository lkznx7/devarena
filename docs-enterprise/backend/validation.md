# Validation

## Request Validation

### Annotations Used

| Annotation | Purpose |
|------------|---------|
| @NotNull | Non-null check |
| @NotBlank | Non-empty string |
| @Size | Length constraints |
| @Email | Email format |
| @Pattern | Regex validation |

### Example

```java
public record CreateUserRequest(
    @NotBlank
    @Size(min = 3, max = 50)
    String username,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Size(min = 8)
    String password
) {}
```

## Entity Validation

- DTO-level validation first
- Service-level business rules
- Database constraints as fallback

## Custom Validators

Custom validation implemented in services for:
- Unique constraints
- Business logic rules
- Cross-field validation