# DevArena - Estrutura de Gestão do Projeto

## Visão Geral

Este documento descreve a estrutura organizacional completa do projeto DevArena para desenvolvimento profissional.

---

## 1. Estrutura de Repositório

```
devarena/
├── .github/
│   ├── workflows/           # CI/CD pipelines
│   ├── ISSUE_TEMPLATE.md    # Templates de issue
│   └── PULL_REQUEST_TEMPLATE.md
├── frontend/                 # Next.js 15
├── backend/                 # Java 21 + Spring Boot
├── docker/                  # Configurações Docker
├── docs/                    # Documentação
│   ├── architecture.md
│   ├── conventions.md
│   ├── ROADMAP.md
│   └── backlog.md
├── .gitignore
├── README.md
├── LICENSE
├── CONTRIBUTING.md
├── CODE_OF_CONDUCT.md
└── CHANGELOG.md
```

---

## 2. Workflow de Desenvolvimento

### 2.1 Fluxo de Trabalho

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│   Create    │ ──► │   Develop   │ ──► │   Review    │ ──► │   Merge     │
│   Issue     │     │   Branch    │     │   PR        │     │   Develop   │
└─────────────┘     └─────────────┘     └─────────────┘     └─────────────┘
                                                                 │
                                                                 ▼
                                                        ┌─────────────┐
                                                        │   Deploy    │
                                                        │   Staging   │
                                                        └─────────────┘
                                                                 │
                                                                 ▼
                                                        ┌─────────────┐
                                                        │   Release   │
                                                        │   (main)    │
                                                        └─────────────┘
```

### 2.2 Processo de Desenvolvimento

1. **Criar Issue** - Descrever necessidade, acceptance criteria
2. **Assign** - Atribuir para desenvolvedor
3. **Criar Branch** - `feature/ISSUE-titulo-curto`
4. **Desenvolver** - Implementar com testes
5. **Code Review** - Pelo menos 1 aprovação
6. **CI Checks** - Build + testes passando
7. **Merge** - Squash para develop
8. **Deploy** - Automático para staging

---

## 3. Estrutura de Issues

### 3.1 Templates

Cada issue deve seguir este padrão:

```markdown
## Descrição
Breve descrição do que precisa ser feito

## Objetivo
Por que isso é necessário? Qual o resultado esperado?

## Checklist Técnico
- [ ] Item 1
- [ ] Item 2

## Critérios de Aceitação
- Criteria 1
- Criteria 2

## Labels
- backend, high-priority

## Prioridade
- critical / high / medium / low

## Estimativa
- Xh ou X days
```

### 3.2 Prefixos de Issue

| Prefixo | Uso | Exemplo |
|---------|-----|---------|
| `[Backend]` | Issues de backend | `[Backend] Implementar autenticação` |
| `[Frontend]` | Issues de frontend | `[Frontend] Criar página de login` |
| `[Infra]` | Issues de infraestrutura | `[Infra] Configurar Docker` |
| `[Database]` | Issues de banco | `[Database] Criar índices` |
| `[Bug]` | Bugs a corrigir | `[Bug] Login não redireciona` |
| `[Docs]` | Documentação | `[Docs] Atualizar API spec` |

---

## 4. Priorização

### 4.1 Matriz de Priorização

| Prioridade | Descrição |Timeline |
|------------|-----------|---------|
| **Critical** |Blocking features, security |1-2 dias |
| **High** |MVP features principais |1 semana |
| **Medium** |Features importantes |2 semanas |
| **Low** |Nice to have |Backlog |

### 4.2 Prioridades Técnicas

**Must Have (MVP):**
1. Autenticação (JWT + OAuth)
2. Sistema de desafios
3. Execução de código (Piston)
4. PvP 1v1 básico
5. XP/Gamificação
6. Dashboard
7. Rankings

**Should Have:**
1. AI Mentor (limitado)
2. Notifications
3. Badges básicos

**Nice to Have:**
1. Battle Pass
2. Guildas
3. Cosméticos

---

## 5. Estimativas e Planejamento

### 5.1 Tamanho de Tarefas

| Tamanho | Descrição | Estimativa |
|---------|-----------|-------------|
| **XS** |Quick fix |1-2h |
| **S** |Pequena feature |2-4h |
| **M** |Feature normal |4-8h |
| **L** |Feature grande |1-2 dias |
| **XL** |Epic |2-5 dias |

### 5.2 Sprint Planning

- **Sprint Duration**: 1 semana
- **Capacity**: 20-30h por desenvolvedor
- **Velocity Target**: 15-20 pontos por sprint

---

## 6. Critérios de Qualidade

### 6.1 Código

- [ ] ESLint passing
- [ ] TypeScript strict mode
- [ ] Coverage >80%
- [ ] No security warnings
- [ ] Code review aprovado

### 6.2 Testes

- [ ] Unit tests para lógica de negócio
- [ ] Integration tests para APIs
- [ ] E2E tests para fluxos críticos
- [ ] Performance tests básicos

### 6.3 Documentação

- [ ] JSDoc/Javadoc atualizado
- [ ] README de setup
- [ ] API documentation (Swagger)
- [ ] Architecture decision records (ADR)

---

## 7. Riscos e Mitigações

### 7.1 Riscos Técnicos

| Risco | Probabilidade | Impacto | Mitigação |
|-------|--------------|---------|-----------|
| Piston API timeout | Alta | Médio | Retry + fallback |
| WebSocket disconnect | Média | Médio | Auto-reconnect |
| Database locks | Baixa | Alto | Transactions adequadas |
| OAuth provider down | Baixa | Médio | Email fallback |

### 7.2 Riscos de Projeto

| Risco | Probabilidade | Impacto | Mitigação |
|-------|--------------|---------|-----------|
| Escopo creep | Alta | Alto | Strict MVP definition |
| Technical debt | Média | Médio | Refactor sprints |
| Team availability | Média | Alto | Buffer em estimates |

---

## 8. Comunicação

### 8.1 Canais

- **GitHub Issues**: Task tracking
- **GitHub PRs**: Code review
- **Discord**: Comunicação rápida

### 8.2 Daily Standups

- O que fez ontem?
- O que vai fazer hoje?
- Algum blocker?

### 8.3 Retrospectivas

- Sprint review (quarta)
- Retrospectiva (sexta)

---

## 9. Release Management

### 9.1 Versioning

```
MAJOR.MINOR.PATCH
  │    │    └─ Bug fixes
  │    └─────── Features (MVP = 1.0)
  └───────────── Breaking changes
```

### 9.2 Release Checklist

- [ ] Todos os testes passando
- [ ] QA aprovado
- [ ] Documentação atualizada
- [ ] Changelog atualizado
- [ ] Tag criada
- [ ] Deploy verificado

---

## 10. Métricas de Projeto

### 10.1 Métricas de Desenvolvimento

| Métrica | Target |
|---------|--------|
| Lead time | < 2 dias |
| Cycle time | < 1 semana |
| Pass rate | > 95% |
| Bug escape | < 5% |

### 10.2 Métricas de Produto (GDD)

| Métrica | MVP Target |
|---------|------------|
| D1 Retention | > 40% |
| D7 Retention | > 20% |
| Streak média | > 5 dias |
| Sessões/semana | > 4 |

---

## 11. Recursos

### 11.1 Links Úteis

- [GitHub Repository](https://github.com/lkznx7/devarena)
- [Figma Design](link)
- [API Documentation](link)
- [Monitoring](link)

### 11.2 Ferramentas

| Uso | Ferramenta |
|-----|------------|
| IDE Backend | IntelliJ / VS Code |
| IDE Frontend | VS Code |
| Database | DBeaver / DataGrip |
| API Client | Postman / Insomnia |
| CI/CD | GitHub Actions |
| Deploy | Docker / Railway / VPS |