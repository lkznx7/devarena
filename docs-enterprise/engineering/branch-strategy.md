# Branch Strategy

## Naming Rules

- Lowercase letters
- Hyphens to separate words
- Include ticket number
- Max 50 characters
- Descriptive

## Examples

```
feature/123-user-auth
fix/456-login-error
hotfix/789-security-patch
docs/202-api-docs
refactor/101-cleanup
```

## Protection Rules

### develop
- Require PR
- Require 1 approval
- Status checks required
- No force push

### main
- Require PR
- Require 2 approvals
- Status checks required
- No direct commits