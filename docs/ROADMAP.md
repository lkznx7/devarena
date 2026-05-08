# DevArena Roadmap Técnico

## Visão Geral

Este documento define o roadmap técnico para desenvolvimento do DevArena MVP v1.0.

---

## Curto Prazo (Semanas 1-4)
**Foco: Foundation + Core**

### Semana 1: Infraestrutura Base
- [x] Repositório GitHub criado
- [x] README e documentação inicial
- [ ] Docker Compose PostgreSQL + Redis
- [ ] Dockerfiles Backend/Frontend
- [ ] Nginx setup

### Semana 2: Banco de Dados + Auth
- [ ] Schema completo (20+ tabelas)
- [ ] Índices e otimizações
- [ ] JWT authentication
- [ ] OAuth2 Google/GitHub

### Semana 3: Usuário Core
- [ ] Profile e stats
- [ ] Sistema XP completo
- [ ] Sistema de Streak
- [ ] Missões diárias/semanais

### Semana 4: Gamificação
- [ ] Badge system inicial
- [ ] Níveis por tópico
- [ ] Limites Free/Premium

---

## Médio Prazo (Semanas 5-8)
**Foco: Challenges + PvP**

### Semana 5: Challenges System
- [ ] Topics e Challenges CRUD
- [ ] Test cases e hints
- [ ] Code execution (Piston API)
- [ ] Submission validation

### Semana 6: Editor + Frontend Challenges
- [ ] Monaco Editor integration
- [ ] Challenge page completa
- [ ] Test results display
- [ ] Hint panel progressivo

### Semana 7: PvP Matchmaking
- [ ] PvpQueue e matching job
- [ ] MMR calculation
- [ ] Rank tiers (Bronze-Diamond)
- [ ] Partida creation flow

### Semana 8: PvP Realtime
- [ ] WebSocket STOMP setup
- [ ] Match found notifications
- [ ] Live opponent status
- [ ] Result resolution

---

## Longo Prazo (Semanas 9-12)
**Foco: AI + Polish**

### Semana 9: AI Mentor
- [ ] Groq API integration
- [ ] Chat contextual
- [ ] Explain error
- [ ] Code review
- [ ] Roadmap automático

### Semana 10: Social + Rankings
- [ ] Rankings global/semanal
- [ ] Notifications realtime
- [ ] Follows system
- [ ] Share cards

### Semana 11: Onboarding + Polish
- [ ] 4-step onboarding
- [ ] First challenge guided
- [ ] Celebration modals
- [ ] UI refinements

### Semana 12: Deploy + Finalização
- [ ] Production Docker setup
- [ ] SSL/TLS configuration
- [ ] Health checks
- [ ] Monitoring
- [ ] Documentation final

---

## Ordem de Implementação Técnica

### Phase 1: Backend Foundation
```
1. docker-compose.yml (postgres + redis)
2. Schema SQL com migrations
3. User entity + Auth module
4. JWT filter + Security config
5. OAuth2 client setup
```

### Phase 2: User Module
```
1. UserStats entity
2. XpTransaction entity
3. XpService + awardXp()
4. StreakService
5. MissionService + jobs
```

### Phase 3: Challenge Module
```
1. Topic + Challenge entities
2. TestCase + Hint entities
3. Submission entity + PistonClient
4. SubmissionService
5. REST endpoints
```

### Phase 4: PvP Module
```
1. PvpMatch + PvpQueue entities
2. MatchmakingService + Job
3. WebSocket config
4. PvP events
5. MMR calculation
```

### Phase 5: AI + Social
```
1. GroqClient
2. AIService endpoints
3. Notification entity
4. NotificationService + WS
5. BadgeService
```

### Phase 6: Frontend
```
1. Next.js setup + Tailwind
2. Auth pages + Zustand store
3. Dashboard components
4. Challenge page + Monaco
5. PvP arena pages
6. Profile + Ranking pages
```

---

## Dependências entre Módulos

### Backend Dependencies
```
auth ─────────► (nenhum - base)
  │
  ├─► user (depende de auth para security)
  │
  ├─► challenge (depende de user para ownership)
  │
  ├─► submission (depende de challenge + user)
  │
  ├─► mission (depende de user para progress)
  │
  ├─► pvp (depende de user + challenge + submission)
  │
  ├─► ranking (depende de user + xp_transactions)
  │
  ├─► notification (depende de user)
  │
  └─► ai (independente)
```

### Frontend Dependencies
```
auth (base)
  │
  ├─► layout (sidebar + providers)
  │
  ├─► dashboard (requer auth)
  │
  ├─► challenges (requer auth)
  │
  ├─► pvp (requer auth)
  │
  └─► profile (requer auth)
```

---

## Riscos Técnicos Identificados

### Alto Impacto
1. **Piston API timeout** - Implementar retry com backoff
2. **WebSocket connections** - Limitar conexões por usuário
3. **Database locks** - Usar transactions adequadamente
4. **MMR manipulation** - Validação server-side

### Médio Impacto
1. **Rate limiting** - Redis-based sliding window
2. **Caching** - Redis cache para rankings
3. **OAuth providers** - Fallback para login email

---

## Pontos de Escalabilidade

### Horizontal (futuro)
- Load balancer Nginx
- Multiple backend instances (stateless)
- Read replicas para PostgreSQL
- Redis cluster

### Vertical (atual)
- Connection pooling (HikariCP)
- Query optimization com índices
- Cache de entidades frequentes

---

## Critérios de Pronto (Definition of Done)

Cada feature deve ter:
- [ ] Código implementado
- [ ] Unit tests (>80% coverage)
- [ ] Integration tests (API endpoints)
- [ ] Code review aprovado
- [ ] Documentação atualizada
- [ ] Deploy para staging testado

---

## Métricas de Progresso

| Semana | Objetivo | Issues |
|--------|----------|--------|
| 1 | Infraestrutura | 1-2 |
| 2 | Auth completa | 3-4 |
| 3 | User core | 5-7 |
| 4 | Gamificação | 14, 17 |
| 5 | Challenges backend | 8-9 |
| 6 | Challenges frontend | 21 |
| 7-8 | PvP | 10-12, 22 |
| 9 | AI | 13 |
| 10 | Social | 15-16, 23 |
| 11 | Onboarding | 24 |
| 12 | Deploy | 25-26 |