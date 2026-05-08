# Coding Standards

## General Rules

### Backend (Java)
- Constructor injection
- Small methods (<30 lines)
- Meaningful names
- Javadoc for public APIs
- Proper exception handling

### Frontend (TypeScript)
- Functional components with hooks
- Use const over let
- Destructure props
- Early returns

## Naming

| Element | Convention | Example |
|---------|------------|---------|
| Classes | PascalCase | UserService |
| Methods | camelCase | findById |
| Variables | camelCase | userId |
| Constants | UPPER_SNAKE | MAX_SIZE |
| Files | kebab-case | user-service.ts |

## Code Review Checklist

- [ ] ESLint passing
- [ ] TypeScript strict
- [ ] Tests included
- [ ] No security issues
- [ ] Documentation updated