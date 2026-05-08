# Git Workflow

## Branch Types

| Branch | Purpose |
|--------|---------|
| main | Production release |
| develop | Integration |
| release/X.Y.Z | Release prep |
| feature/* | New features |
| fix/* | Bug fixes |
| hotfix/* | Critical fixes |

## Process

1. Create branch from develop
2. Develop and commit
3. Rebase frequently
4. Create PR
5. Code review (1+ approval)
6. Squash merge to develop
7. Delete branch

## Commit Convention

```
<type>(<scope>): <subject>

[body]

[footer]
```

Types: feat, fix, docs, style, refactor, perf, test, chore, ci