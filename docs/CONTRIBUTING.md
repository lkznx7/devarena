# Contributing to DevArena

First off, thank you for considering contributing to DevArena! We welcome contributions from the community and are excited to have you on board.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Workflow](#development-workflow)
- [Branch Strategy](#branch-strategy)
- [Commit Messages](#commit-messages)
- [Pull Request Process](#pull-request-process)
- [Coding Standards](#coding-standards)
- [Testing](#testing)
- [Documentation](#documentation)
- [Issue Reporting](#issue-reporting)

---

## Code of Conduct

Please read and follow our [Code of Conduct](CODE_OF_CONDUCT.md). We expect all contributors to adhere to the guidelines to maintain a welcoming and inclusive environment.

---

## Getting Started

### Prerequisites

- **Node.js** 18+ (for frontend)
- **Java 21** (for backend)
- **Docker** & **Docker Compose**
- **PostgreSQL 15+**
- **Redis 7+**

### Setup Development Environment

```bash
# 1. Fork the repository
# 2. Clone your fork
git clone https://github.com/YOUR_USERNAME/devarena.git
cd devarena

# 3. Add upstream remote
git remote add upstream https://github.com/lkznx7/devarena.git

# 4. Create development branch
git checkout -b develop

# 5. Install dependencies
# Frontend
cd frontend && npm install

# Backend
cd ../backend && ./mvnw clean install
```

### Environment Configuration

Create the following environment files:

**Frontend (`frontend/.env.local`)**
```env
NEXT_PUBLIC_API_URL=http://localhost:8080
NEXT_PUBLIC_WS_URL=ws://localhost:8080/ws
NEXT_PUBLIC_PISTON_API_URL=https://emkc.org/api/v2/piston
NEXT_PUBLIC_GROQ_API_KEY=your_groq_key
```

**Backend (`backend/src/main/resources/application.yml`)**
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/devarena
    username: devarena
    password: devarena_dev
  data:
    redis:
      host: localhost
      port: 6379
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false

jwt:
  secret: your-super-secret-jwt-key
  expiration: 86400000

piston:
  api-url: https://emkc.org/api/v2/piston

groq:
  api-key: your_groq_key
```

---

## Development Workflow

### 1. Create Issue

Before starting any work, create an issue with:
- Clear title
- Detailed description
- Labels (frontend/backend/infra/bug/enhancement)
- Priority (high/medium/low)

### 2. Pick Up Issue

- Assign yourself to the issue
- Move to "In Progress" column in project board

### 3. Create Feature Branch

```bash
# Update your develop branch
git checkout develop
git pull upstream develop

# Create feature branch
git checkout -b feature/ISSUE-TICKET-short-description
# or
git checkout -b fix/ISSUE-TICKET-short-description
```

### 4. Development

- Make your changes following our coding standards
- Write tests for new features
- Update documentation if needed

### 5. Commit Changes

Follow our commit message convention (see below)

### 6. Push & Create PR

```bash
git push origin feature/ISSUE-TICKET-short-description
```

Then create a Pull Request via GitHub.

---

## Branch Strategy

We follow Git Flow with some modifications:

```
main (production)
  ↑
release/X.Y.Z (release branches)
  ↑
develop (integration)
  ↑
feature/TICKET-description (feature branches)
  ↑
fix/TICKET-description (bug fix branches)
  ↑
hotfix/TICKET-description (production fixes)
```

### Branch Naming

| Type | Pattern | Example |
|------|---------|---------|
| Feature | `feature/TICKET-description` | `feature/123-user-authentication` |
| Bug Fix | `fix/TICKET-description` | `fix/456-login-redirect-error` |
| Hotfix | `hotfix/TICKET-description` | `hotfix/789-security-vulnerability` |
| Release | `release/X.Y.Z` | `release/1.0.0` |

### Branch Lifecycle

1. Branch off from `develop`
2. Make changes
3. Open PR to `develop`
4. After testing, merge to `develop`
5. When ready for release, create release branch
6. Merge release to `main` and `develop`

---

## Commit Messages

We follow [Conventional Commits](https://www.conventionalcommits.org/) specification:

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types

| Type | Description |
|------|-------------|
| `feat` | New feature |
| `fix` | Bug fix |
| `docs` | Documentation changes |
| `style` | Code style changes (formatting, semicolons) |
| `refactor` | Code refactoring |
| `perf` | Performance improvement |
| `test` | Adding/updating tests |
| `chore` | Build process, dependencies |
| `ci` | CI configuration |
| `revert` | Reverting a previous commit |

### Examples

```
feat(auth): add JWT refresh token mechanism
fix(submission): handle timeout in code execution
docs(api): update authentication endpoints documentation
refactor(challenge): extract difficulty calculation to service
test(pvp): add integration tests for arena matchmaking
```

---

## Pull Request Process

### PR Requirements

- [ ] All tests passing
- [ ] Code follows style guidelines
- [ ] Documentation updated (if applicable)
- [ ] No merge conflicts
- [ ] At least one approval
- [ ] All checks passed (CI/CD)

### PR Template

```markdown
## Description
Brief description of changes

## Related Issue
Closes #TICKET

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Testing
Describe testing performed

## Screenshots (if applicable)
Add screenshots or GIFs
```

### Review Process

1. **Auto Review** - Lint and build checks
2. **Code Review** - At least 1 maintainer approval
3. **CI Checks** - All tests passing
4. **Merge** - Squash and merge to develop

---

## Coding Standards

### Frontend (TypeScript/React)

- Use functional components with hooks
- Prefer `const` over `let`
- Use meaningful variable names
- Keep components small and focused
- Use TypeScript strict mode
- Follow ESLint and Prettier configuration

```typescript
// ✅ Good
const UserProfile: React.FC<Props> = ({ userId }) => {
  const { data: user, isLoading } = useUser(userId);

  if (isLoading) return <Skeleton />;

  return <ProfileCard user={user} />;
};

// ❌ Bad
function UserProfile(props) {
  let user = null;
  let loading = true;
  // ... code
}
```

### Backend (Java/Spring)

- Follow Java naming conventions
- Use meaningful class/method names
- Keep methods small (max 30 lines)
- Use dependency injection
- Add Javadoc for public APIs
- Handle exceptions properly

```java
// ✅ Good
@RestController
@RequestMapping("/api/v1/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @GetMapping("/{id}")
    public ResponseEntity<ChallengeResponse> getChallenge(@PathVariable Long id) {
        return ResponseEntity.ok(challengeService.findById(id));
    }
}
```

---

## Testing

### Frontend Testing

```bash
# Unit tests
npm run test

# E2E tests
npm run test:e2e

# Coverage
npm run test:coverage
```

### Backend Testing

```bash
# Unit tests
./mvnw test

# Integration tests
./mvnw verify

# Coverage
./mvnw jacoco:report
```

### Test Coverage Requirements

- Minimum 80% code coverage
- All critical paths must be tested
- Integration tests for API endpoints

---

## Documentation

### Code Documentation

- Use JSDoc for React components
- Use Javadoc for Java classes
- Document complex algorithms
- Document public APIs

### API Documentation

- OpenAPI/Swagger for REST APIs
- Document all endpoints
- Include examples
- Document error responses

### Project Documentation

- Architecture decisions (ADRs)
- Setup guides
- Contribution guidelines

---

## Issue Reporting

### Bug Reports

Include:
1. **Summary** - Brief description
2. **Steps to Reproduce** - Numbered steps
3. **Expected Behavior** - What should happen
4. **Actual Behavior** - What actually happened
5. **Screenshots/Logs** - Evidence
6. **Environment** - OS, versions
7. **Severity** - Critical/High/Medium/Low

### Feature Requests

Include:
1. **Summary** - Brief description
2. **Motivation** - Why is this needed?
3. **Proposed Solution** - How should it work?
4. **Alternatives** - Other solutions considered
5. **Additional Context** - Any other information

---

## Recognition

Thank you to all our contributors! See our [Contributors](https://github.com/lkznx7/devarena/graphs/contributors) page.

---

## Questions?

- Open an issue for bugs or feature requests
- Join our Discord community
- Email us at devarena@example.com

Happy coding! 🚀