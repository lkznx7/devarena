# DevArena Backlog - MVP v1.0

## Prioridades de Implementação

### Fase 1: Foundation (Semanas 1-2)
Infraestrutura base para todo o projeto.

#### Infraestrutura
- [ ] **F1.1** - Configurar Docker Compose com PostgreSQL 16
- [ ] **F1.2** - Configurar Docker Compose com Redis 7
- [ ] **F1.3** - Criar Dockerfile para Backend (Java 21)
- [ ] **F1.4** - Criar Dockerfile para Frontend (Next.js 15)
- [ ] **F1.5** - Configurar Nginx como reverse proxy
- [ ] **F1.6** - Configurar rede Docker interna

#### Banco de Dados - Schema
- [ ] **F2.1** - Criar tabela users com campos completos
- [ ] **F2.2** - Criar tabela oauth_accounts
- [ ] **F2.3** - Criar tabela refresh_tokens
- [ ] **F2.4** - Criar tabela user_stats
- [ ] **F2.5** - Criar tabela xp_transactions
- [ ] **F2.6** - Criar índices para performance

#### Autenticação (Backend)
- [ ] **F3.1** - Implementar User entity e repository
- [ ] **F3.2** - Implementar JWT Token Provider
- [ ] **F3.3** - Implementar JwtAuthenticationFilter
- [ ] **F3.4** - Implementar UserDetailsService
- [ ] **F3.5** - Implementar AuthController (register, login, refresh, logout)
- [ ] **F3.6** - Configurar Spring Security
- [ ] **F3.7** - Implementar OAuth2 Google/GitHub

---

### Fase 2: User Core (Semanas 3-4)
Sistema de usuário e gamificação básica.

#### Perfil do Usuário
- [ ] **U1.1** - Implementar UserStats entity
- [ ] **U1.2** - Implementar GET /api/v1/users/me
- [ ] **U1.3** - Implementar PUT /api/v1/users/me (update perfil)
- [ ] **U1.4** - Implementar GET /api/v1/users/{username}
- [ ] **U1.5** - Implementar upload de avatar
- [ ] **U1.6** - Implementar campos: banner_url, bio, github_url

#### Sistema de XP
- [ ] **U2.1** - Implementar XpService com awardXp()
- [ ] **U2.2** - Implementar XpTransaction entity e repository
- [ ] **U2.3** - Criar job para cálculo de XP diário (login bonus)
- [ ] **U2.4** - Implementar sistema de níveis por tópico

#### Sistema de Streak
- [ ] **U3.1** - Implementar StreakService
- [ ] **U3.2** - Criar job diária para aplicar penalidades de streak
- [ ] **U3.3** - Implementar StreakFreeze para premium
- [ ] **U3.4** - Implementar streak no user stats

#### Missões Diárias/Semanais
- [ ] **U4.1** - Implementar Mission entity
- [ ] **U4.2** - Implementar UserMission entity
- [ ] **U4.3** - Implementar MissionService com assignDailyMissions()
- [ ] **U4.4** - Criar job para reset de missões diárias (00:00)
- [ ] **U4.5** - Criar job para reset de missões semanais (segunda 00:00)
- [ ] **U4.6** - Implementar progress tracking de missões

---

### Fase 3: Challenges System (Semanas 5-6)
Sistema de desafios e execução de código.

#### Topics e Challenges
- [ ] **C1.1** - Implementar Topic entity e repository
- [ ] **C1.2** - Implementar Challenge entity
- [ ] **C1.3** - Implementar ChallengeHint entity
- [ ] **C1.4** - Implementar ChallengeTestCase entity
- [ ] **C1.5** - Implementar GET /api/v1/topics
- [ ] **C1.6** - Implementar GET /api/v1/topics/{slug}/challenges
- [ ] **C1.7** - Implementar GET /api/v1/challenges/{slug}

#### Execução de Código
- [ ] **C2.1** - Integrar Piston API client
- [ ] **C2.2** - Implementar Submission entity
- [ ] **C2.3** - Implementar SubmissionService com submit()
- [ ] **C2.4** - Implementar POST /api/v1/submissions
- [ ] **C2.5** - Implementar rate limiting para submissions
- [ ] **C2.6** - Implementar timeout handling (10s)

#### Sistema de Hints
- [ ] **C3.1** - Implementar hints progressivos
- [ ] **C3.2** - Implementar GET /api/v1/challenges/{slug}/hints
- [ ] **C3.3** - Implementar POST /api/v1/challenges/{slug}/hints/next

#### Progresso do Usuário
- [ ] **C4.1** - Implementar UserChallengeProgress entity
- [ ] **C4.2** - Implementar GET /api/v1/challenges/{slug}/my-progress
- [ ] **C4.3** - Tracking de tentativas e hints usados
- [ ] **C4.4** - Marcar desafio como solved

---

### Fase 4: PvP Arena (Semanas 7-8)
Sistema de PvP 1v1 com matchmaking.

#### Matchmaking
- [ ] **P1.1** - Implementar PvpQueue entity
- [ ] **P1.2** - Implementar PvpMatch entity
- [ ] **P1.3** - Implementar MatchmakingService
- [ ] **P1.4** - Criar job para matchmaking (a cada 5s)
- [ ] **P1.5** - Implementar POST /api/v1/pvp/queue/join
- [ ] **P1.6** - Implementar DELETE /api/v1/pvp/queue/leave

#### Partida PvP
- [ ] **P2.1** - Implementar WebSocket config (STOMP)
- [ ] **P2.2** - Implementar PvPWebSocketHandler
- [ ] **P2.3** - Implementar notificação de match found via WS
- [ ] **P2.4** - Implementar código submission dentro de PvP
- [ ] **P2.5** - Implementar resolução de partida (winner)
- [ ] **P2.6** - Implementar timer de 20 minutos

#### Sistema de MMR
- [ ] **P3.1** - Implementar MMR calculation (+/- 25 base)
- [ ] **P3.2** - Implementar RankTier enum (Bronze a Diamond)
- [ ] **P3.3** - Implementar seasonal reset
- [ ] **P3.4** - Implementar penalidade por desistência

---

### Fase 5: AI Mentor (Semanas 9)
Integração com Groq API para assistentes de IA.

#### Integração Groq
- [ ] **A1.1** - Implementar GroqClient
- [ ] **A1.2** - Implementar AIService
- [ ] **A1.3** - Implementar POST /api/v1/ai/chat
- [ ] **A1.4** - Implementar POST /api/v1/ai/explain-error
- [ ] **A1.5** - Implementar POST /api/v1/ai/review-code

#### Limites por Plano
- [ ] **A2.1** - Implementar contador de mensagens diário
- [ ] **A2.2** - Implementar limite 10 msg/dia para free
- [ ] **A2.3** - Criar job para reset diário de limite

#### Funcionalidades
- [ ] **A3.1** - Implementar sistema de hints via AI
- [ ] **A3.2** - Implementar roadmap automático
- [ ] **A3.3** - Implementar debugging assistido

---

### Fase 6: Ranking e Social (Semanas 10)
Sistema de rankings e notificações.

#### Rankings
- [ ] **R1.1** - Implementar Ranking entity
- [ ] **R1.2** - Implementar RankingService
- [ ] **R1.3** - Implementar GET /api/v1/rankings/global
- [ ] **R1.4** - Implementar GET /api/v1/rankings/weekly
- [ ] **R1.5** - Implementar GET /api/v1/rankings/me
- [ ] **R1.6** - Criar job para snapshot semanal

#### Notificações
- [ ] **N1.1** - Implementar Notification entity
- [ ] **N1.2** - Implementar NotificationService
- [ ] **N1.3** - Implementar WebSocket para notifications
- [ ] **N1.4** - Implementar GET /api/v1/notifications
- [ ] **N1.5** - Implementar PATCH /api/v1/notifications/{id}/read
- [ ] **N1.6** - Implementar PATCH /api/v1/notifications/read-all

#### Sistema de Badges
- [ ] **B1.1** - Implementar Badge entity
- [ ] **B1.2** - Implementar UserBadge entity
- [ ] **B1.3** - Implementar BadgeService
- [ ] **B1.4** - Implementar badge evaluation em eventos
- [ ] **B1.5** - Criar badges iniciais (streak, challenges, pvp)

---

### Fase 7: Frontend MVP (Semanas 1-10)
Desenvolvimento do frontend paralelo ao backend.

#### Setup e Configuração
- [ ] **FE1.1** - Criar projeto Next.js 15 com TypeScript
- [ ] **FE1.2** - Configurar Tailwind CSS com design system
- [ ] **FE1.3** - Configurar Shadcn/UI
- [ ] **FE1.4** - Configurar Framer Motion
- [ ] **FE1.5** - Configurar Zustand para state management
- [ ] **FE1.6** - Configurar TanStack Query

#### Autenticação
- [ ] **FE2.1** - Implementar página de login
- [ ] **FE2.2** - Implementar página de registro
- [ ] **FE2.3** - Implementar OAuth login (Google/GitHub)
- [ ] **FE2.4** - Implementar logout
- [ ] **FE2.5** - Implementar token refresh automático

#### Dashboard
- [ ] **FE3.1** - Implementar layout autenticado (sidebar)
- [ ] **FE3.2** - Implementar XpBar component
- [ ] **FE3.3** - Implementar StreakCard component
- [ ] **FE3.4** - Implementar MissionList component
- [ ] **FE3.5** - Implementar desafios recomendados
- [ ] **FE3.6** - Implementar posição no ranking

#### Desafios
- [ ] **FE4.1** - Implementar listagem de topics/challenges
- [ ] **FE4.2** - Implementar página de desafio com editor
- [ ] **FE4.3** - Integrar Monaco Editor
- [ ] **FE4.4** - Implementar CodeEditor component
- [ ] **FE4.5** - Implementar TestResults component
- [ ] **FE4.6** - Implementar HintPanel
- [ ] **FE4.7** - Implementar AI Mentor Chat

#### PvP Arena
- [ ] **FE5.1** - Implementar lobby PvP
- [ ] **FE5.2** - Implementar matchmaking modal
- [ ] **FE5.3** - Implementar MatchArena page
- [ ] **FE5.4** - Implementar opponent status realtime
- [ ] **FE5.5** - Implementar resultado da partida

#### Perfil e Ranking
- [ ] **FE6.1** - Implementar página de perfil
- [ ] **FE6.2** - Implementar BadgeShowcase
- [ ] **FE6.3** - Implementar StatsGrid
- [ ] **FE6.4** - Implementar LeaderboardTable
- [ ] **FE6.5** - Implementar cards de compartilhamento

---

### Fase 8: Polish (Semanas 11-12)
Refinamentos finais para MVP.

#### Sistema Freemium
- [ ] **PM1.1** - Implementar limit: 5 desafios/dia (free)
- [ ] **PM1.2** - Implementar limit: 3 PvP ranked/dia (free)
- [ ] **PM1.3** - Implementar limit: 10 msg AI/dia (free)
- [ ] **PM1.4** - Implementar toggle de premium

#### Onboarding
- [ ] **O1.1** - Implementar teste de nível (5-8 questões)
- [ ] **O1.2** - Implementar escolha de trilha
- [ ] **O1.3** - Implementar primeiro desafio guiado
- [ ] **O1.4** - Implementar primeira recompensa (XP + badge)

#### Finalização
- [ ] **FNL1** - Testes de integração completos
- [ ] **FNL2** - Documentação de API (OpenAPI/Swagger)
- [ ] **FNL3** - Deploy em produção (VPS/Cloud)
- [ ] **FNL4** - Monitoramento e logs
- [ ] **FNL5** - Testes de carga básicos

---

## Nice to Have (Post-MVP)
- [ ] Guildas (criação, membros, guerras)
- [ ] Battle Pass
- [ ] Loja de cosméticos
- [ ] Perfil público compartilhável
- [ ] Mobile app
- [ ] Hackathons e torneios
- [ ] Marketplace de freelancers