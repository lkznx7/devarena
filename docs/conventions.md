# DevArena - Conventions and Standards

## Table of Contents

1. [Git Flow](#git-flow)
2. [Branch Strategy](#branch-strategy)
3. [Commit Pattern](#commit-pattern)
4. [Code Style](#code-style)
5. [Folder Structure](#folder-structure)
6. [DTO Pattern](#dto-pattern)
7. [Response Pattern](#response-pattern)
8. [Exception Pattern](#exception-pattern)
9. [Logging Pattern](#logging-pattern)
10. [API Versioning](#api-versioning)
11. [Naming Conventions](#naming-conventions)

---

## Git Flow

### Main Branches

| Branch | Purpose | Protected |
|--------|---------|-----------|
| `main` | Production release | Yes |
| `develop` | Integration branch | Yes |
| `release/X.Y.Z` | Release preparation | Yes |

### Supporting Branches

| Branch Type | Pattern | Example |
|-------------|---------|---------|
| Feature | `feature/TICKET-description` | `feature/123-user-auth` |
| Bug Fix | `fix/TICKET-description` | `fix/456-login-error` |
| Hotfix | `hotfix/TICKET-description` | `hotfix/789-security` |
| Refactor | `refactor/TICKET-description` | `refactor/101-cleanup` |
| Documentation | `docs/TICKET-description` | `docs/202-api-docs` |

### Git Flow Diagram

```
main ───────────────────────────────────────────────────────
  │        ▲
  │        │ Merge (Release)
  │        │
release/1.0.0 ─────────────────────────────────────────────
  │        │
  │        │ Merge (Release ready)
  │        │
develop ────────────────────────────────────────────────────
  │        │
  │        │ Merge (Feature complete)
  │        │
feature/123-user-auth
  │
fix/456-login-error
  │
hotfix/789-security
```

---

## Branch Strategy

### Branch Lifecycle

1. **Create** - Branch off from `develop`
2. **Develop** - Make changes, commit regularly
3. **Sync** - Rebase from `develop` frequently
4. **Test** - Ensure all tests pass
5. **Push** - Push branch to remote
6. **PR** - Create Pull Request
7. **Review** - Get approvals and address feedback
8. **Merge** - Squash and merge to `develop`
9. **Delete** - Delete branch after merge

### Branch Naming Rules

- Use lowercase letters
- Use hyphens to separate words
- Include ticket number when available
- Be descriptive but concise (max 50 chars)

### Branch Protection Rules

**develop branch:**
- Require pull request
- Require 1 approval
- Require status checks to pass
- No force push

**main branch:**
- Require pull request
- Require 2 approvals
- Require status checks to pass
- No direct commits

---

## Commit Pattern

We follow [Conventional Commits](https://www.conventionalcommits.org/):

```
<type>(<scope>): <subject>

[body]

[footer]
```

### Types

| Type | Description |
|------|-------------|
| `feat` | New feature |
| `fix` | Bug fix |
| `docs` | Documentation |
| `style` | Formatting, no code change |
| `refactor` | Code refactoring |
| `perf` | Performance improvement |
| `test` | Adding/updating tests |
| `chore` | Build, dependencies |
| `ci` | CI configuration |
| `revert` | Revert previous commit |

### Scopes (Backend)

| Scope | Description |
|-------|-------------|
| `auth` | Authentication module |
| `user` | User management |
| `challenge` | Challenge system |
| `submission` | Code submission |
| `mission` | Missions/quests |
| `ranking` | Leaderboard/ranking |
| `pvp` | PvP arena |
| `notification` | Notifications |
| `ai` | AI mentor |

### Scopes (Frontend)

| Scope | Description |
|-------|-------------|
| `auth` | Authentication UI |
| `user` | User profile UI |
| `challenge` | Challenge UI |
| `mission` | Mission UI |
| `ranking` | Ranking UI |
| `pvp` | PvP arena UI |
| `notification` | Notification UI |
| `dashboard` | Dashboard UI |
| `layout` | Layout/components |

### Examples

```bash
# Feature
git commit -m "feat(auth): add JWT refresh token mechanism"

# Bug fix
git commit -m "fix(submission): handle timeout in code execution"

# Documentation
git commit -m "docs(api): update authentication endpoints"

# Refactor
git commit -m "refactor(challenge): extract difficulty calculation"

# Test
git commit -m "test(pvp): add integration tests for matchmaking"
```

---

## Code Style

### Frontend (TypeScript/React)

#### General Rules

- Use functional components with hooks
- Use `const` over `let`
- Use arrow functions for callbacks
- Destructure props and objects
- Use early returns

#### Naming

```typescript
// Components: PascalCase
const UserProfile = () => {};
const ChallengeCard = () => {};

// Functions: camelCase
const getUserData = () => {};
const handleSubmit = () => {};

// Variables: camelCase
const userName = 'John';
const isLoading = false;

// Constants: UPPER_SNAKE_CASE
const MAX_FILE_SIZE = 1024;
const API_BASE_URL = '/api';

// Interfaces: PascalCase with 'I' prefix (optional)
interface UserData {
  id: string;
  name: string;
}

// Types: PascalCase
type AuthState = 'idle' | 'loading' | 'success' | 'error';
```

#### File Structure

```typescript
// Component file
import { useState, useEffect } from 'react';
import { useQuery } from '@tanstack/react-query';
import { Button } from '@/components/ui/button';
import { UserCard } from './user-card';

interface Props {
  userId: string;
}

export const UserProfile: React.FC<Props> = ({ userId }) => {
  const [state, setState] = useState(false);

  const { data, isLoading } = useQuery({
    queryKey: ['user', userId],
    queryFn: () => fetchUser(userId),
  });

  if (isLoading) return <Skeleton />;

  return <UserCard user={data} />;
};
```

#### Imports Order

1. External libraries (React, Next.js)
2. TanStack Query / Zustand
3. UI components (Shadcn)
4. Custom components
5. Custom hooks
6. Utils / helpers
7. Types
8. Styles

```typescript
// 1. React/Next
import { useState, useEffect } from 'react';
import Link from 'next/link';

// 2. TanStack Query
import { useQuery } from '@tanstack/react-query';

// 3. UI Components
import { Button } from '@/components/ui/button';
import { Card } from '@/components/ui/card';

// 4. Custom Components
import { UserAvatar } from '@/components/user-avatar';

// 5. Custom Hooks
import { useAuth } from '@/hooks/use-auth';

// 6. Utils
import { formatDate } from '@/lib/utils';

// 7. Types
import { User } from '@/types';

// 8. Styles
import styles from './component.module.css';
```

### Backend (Java/Spring)

#### General Rules

- Use dependency injection (constructor injection)
- Keep methods small (max 30 lines)
- Use meaningful names
- Add Javadoc for public APIs
- Handle exceptions properly

#### Class Structure

```java
@RestController
@RequestMapping("/api/v1/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;
    private final ChallengeMapper challengeMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ChallengeResponse> getChallenge(@PathVariable Long id) {
        Challenge challenge = challengeService.findById(id);
        return ResponseEntity.ok(challengeMapper.toResponse(challenge));
    }

    @PostMapping
    public ResponseEntity<ChallengeResponse> createChallenge(
            @Valid @RequestBody CreateChallengeRequest request) {
        Challenge challenge = challengeService.create(request);
        return ResponseEntity
                .created(URI.create("/api/v1/challenges/" + challenge.getId()))
                .body(challengeMapper.toResponse(challenge));
    }
}
```

#### Service Structure

```java
@Service
@Transactional
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final UserRepository userRepository;

    public Challenge findById(Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new ChallengeNotFoundException(id));
    }

    public Challenge create(CreateChallengeRequest request) {
        validateRequest(request);
        Challenge challenge = Challenge.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .difficulty(request.getDifficulty())
                .build();
        return challengeRepository.save(challenge);
    }

    private void validateRequest(CreateChallengeRequest request) {
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new ValidationException("Title is required");
        }
    }
}
```

#### Naming Conventions

| Element | Convention | Example |
|---------|------------|---------|
| Classes | PascalCase | `UserService`, `ChallengeController` |
| Methods | camelCase | `findById()`, `createUser()` |
| Variables | camelCase | `userId`, `challengeList` |
| Constants | UPPER_SNAKE_CASE | `MAX_ATTEMPTS`, `DEFAULT_PAGE_SIZE` |
| Packages | lowercase | `com.devarena.service` |
| Tables/Columns | snake_case | `user_profile`, `created_at` |

---

## Folder Structure

### Frontend

```
frontend/src/
├── app/                     # Next.js App Router
│   ├── (auth)/              # Auth route group
│   │   ├── login/
│   │   └── register/
│   ├── (dashboard)/         # Dashboard route group
│   │   ├── challenges/
│   │   ├── pvp/
│   │   └── profile/
│   ├── api/                 # API routes (proxy)
│   ├── layout.tsx
│   └── page.tsx
│
├── components/              # Reusable components
│   ├── ui/                  # Shadcn/UI components
│   ├── auth/                # Auth components
│   ├── challenge/          # Challenge components
│   ├── pvp/                # PvP components
│   └── shared/              # Shared components
│
├── hooks/                   # Custom hooks
│   ├── use-auth.ts
│   ├── use-challenge.ts
│   └── use-pvp.ts
│
├── lib/                     # Utilities
│   ├── api.ts              # Axios instance
│   ├── utils.ts            # Helper functions
│   └── constants.ts        # App constants
│
├── services/               # API services
│   ├── auth-service.ts
│   ├── challenge-service.ts
│   └── pvp-service.ts
│
├── stores/                 # Zustand stores
│   ├── auth-store.ts
│   └── user-store.ts
│
├── types/                  # TypeScript types
│   ├── user.ts
│   ├── challenge.ts
│   └── api.ts
│
└── styles/                # Global styles
    └── globals.css
```

### Backend

```
backend/src/main/java/com/devarena/
├── config/                 # Spring configuration
│   ├── SecurityConfig.java
│   ├── RedisConfig.java
│   └── WebSocketConfig.java
│
├── controller/            # REST controllers
│   ├── auth/
│   ├── user/
│   └── challenge/
│
├── dto/                   # Data Transfer Objects
│   ├── request/           # Input DTOs
│   └── response/          # Output DTOs
│
├── entity/                # JPA entities
│   ├── User.java
│   ├── Challenge.java
│   └── Submission.java
│
├── exception/             # Custom exceptions
│   ├── GlobalExceptionHandler.java
│   ├── ResourceNotFoundException.java
│   └── ValidationException.java
│
├── repository/            # JPA repositories
│   ├── UserRepository.java
│   └── ChallengeRepository.java
│
├── service/              # Business logic
│   ├── impl/             # Implementation
│   └── interface/        # Interfaces
│
└── security/             # Security components
    ├── JwtTokenProvider.java
    └── JwtAuthenticationFilter.java
```

---

## DTO Pattern

### Request DTOs

```java
// Validation annotations for clean validation
public record CreateUserRequest(
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be 3-50 characters")
    String username,

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    String password
) {}
```

### Response DTOs

```java
// Use records for immutable responses
public record UserResponse(
    Long id,
    String username,
    String email,
    String avatar,
    Integer level,
    Long xp
) {}

public record ChallengeResponse(
    Long id,
    String title,
    String description,
    Difficulty difficulty,
    List<TestCaseResponse> testCases,
    List<String> hints
) {}
```

### Mapper Pattern

```java
@Component
@RequiredArgsConstructor
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getAvatar(),
            user.getLevel(),
            user.getXp()
        );
    }

    public User toEntity(CreateUserRequest request) {
        return User.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();
    }
}
```

---

## Response Pattern

### Standard Response Wrapper

```java
// Generic response wrapper
public record ApiResponse<T>(
    boolean success,
    String message,
    T data,
    LocalDateTime timestamp
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse(true, "Success", data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse(false, message, null, LocalDateTime.now());
    }
}
```

### Response Examples

```json
// Success response
{
  "success": true,
  "message": "Challenge created successfully",
  "data": {
    "id": 1,
    "title": "Two Sum",
    "difficulty": "EASY"
  },
  "timestamp": "2026-05-08T10:30:00"
}

// Error response
{
  "success": false,
  "message": "Challenge not found with id: 999",
  "data": null,
  "timestamp": "2026-05-08T10:30:00"
}

// Paginated response
{
  "success": true,
  "message": "Challenges retrieved",
  "data": {
    "content": [...],
    "page": 0,
    "size": 20,
    "totalElements": 100,
    "totalPages": 5
  },
  "timestamp": "2026-05-08T10:30:00"
}
```

### Pagination DTO

```java
public record PagedResponse<T>(
    List<T> content,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean first,
    boolean last
) {
    public static <T> PagedResponse<T> of(Page<T> page) {
        return new PagedResponse<>(
            page.getContent(),
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.isFirst(),
            page.isLast()
        );
    }
}
```

---

## Exception Pattern

### Custom Exceptions

```java
// Base exception
public class DevArenaException extends RuntimeException {
    private final String errorCode;

    public DevArenaException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

// Specific exceptions
public class ResourceNotFoundException extends DevArenaException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " not found with id: " + id, "NOT_FOUND");
    }
}

public class ValidationException extends DevArenaException {
    public ValidationException(String message) {
        super(message, "VALIDATION_ERROR");
    }
}

public class AuthenticationException extends DevArenaException {
    public AuthenticationException(String message) {
        super(message, "AUTH_ERROR");
    }
}
```

### Global Exception Handler

```java
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(ex.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(ValidationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .join(", ");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneral(Exception ex) {
        log.error("Unexpected error occurred", ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Internal server error"));
    }
}
```

---

## Logging Pattern

### Structured Logging

```java
// Use structured logging with appropriate levels
@Slf4j
@Service
@RequiredArgsConstructor
public class ChallengeService {

    public Challenge findById(Long id) {
        log.info("Fetching challenge with id: {}", id);

        return challengeRepository.findById(id)
                .map(challenge -> {
                    log.debug("Challenge found: {}", challenge.getId());
                    return challenge;
                })
                .orElseThrow(() -> {
                    log.warn("Challenge not found: {}", id);
                    return new ResourceNotFoundException("Challenge", id);
                });
    }

    public Challenge create(CreateChallengeRequest request) {
        log.info("Creating new challenge: {}", request.getTitle());

        try {
            Challenge challenge = challengeRepository.save(challenge);
            log.info("Challenge created successfully with id: {}", challenge.getId());
            return challenge;
        } catch (Exception e) {
            log.error("Failed to create challenge: {}", request.getTitle(), e);
            throw e;
        }
    }
}
```

### Log Levels

| Level | Usage |
|-------|-------|
| `ERROR` | Exceptions, failures |
| `WARN` | Potential issues, expected errors |
| `INFO` | Important business events |
| `DEBUG` | Detailed debugging info |
| `TRACE` | Very detailed tracing |

### Frontend Logging

```typescript
// Use console with appropriate levels
const logger = {
  info: (message: string, data?: unknown) => {
    console.log(`[INFO] ${message}`, data);
  },
  warn: (message: string, data?: unknown) => {
    console.warn(`[WARN] ${message}`, data);
  },
  error: (message: string, error: unknown) => {
    console.error(`[ERROR] ${message}`, error);
    // Send to error tracking service (Sentry, etc.)
  },
  debug: (message: string, data?: unknown) => {
    if (process.env.NODE_ENV === 'development') {
      console.debug(`[DEBUG] ${message}`, data);
    }
  },
};
```

---

## API Versioning

### Version Strategy

- URL-based versioning: `/api/v1/...`
- Default to latest version
- Support previous versions for 6 months

### Version Header (Optional)

```
Accept: application/vnd.devarena.v1+json
```

### API Endpoints Structure

```
/api/v1/auth/...
/api/v1/users/...
/api/v1/challenges/...
/api/v1/submissions/...
/api/v1/missions/...
/api/v1/rankings/...
/api/v1/pvp/...
/api/v1/notifications/...
/api/v1/ai/...
```

---

## Naming Conventions

### HTTP Methods

| Method | Usage | Example |
|--------|-------|---------|
| `GET` | Retrieve | `GET /api/v1/users/123` |
| `POST` | Create | `POST /api/v1/challenges` |
| `PUT` | Full update | `PUT /api/v1/users/123` |
| `PATCH` | Partial update | `PATCH /api/v1/users/123` |
| `DELETE` | Delete | `DELETE /api/v1/challenges/123` |

### Status Codes

| Code | Usage |
|------|-------|
| `200` | Success (GET, PUT, PATCH) |
| `201` | Created (POST) |
| `204` | No Content (DELETE) |
| `400` | Bad Request |
| `401` | Unauthorized |
| `403` | Forbidden |
| `404` | Not Found |
| `409` | Conflict |
| `422` | Validation Error |
| `500` | Internal Server Error |

### Entity Naming

| Concept | Name |
|---------|------|
| Database table | `snake_case` (e.g., `user_challenges`) |
| Database column | `snake_case` (e.g., `created_at`) |
| JSON field | `camelCase` (e.g., `createdAt`) |
| Java field | `camelCase` (e.g., `createdAt`) |
| Java class | `PascalCase` (e.g., `UserChallenge`) |