# 🗺️ DevArena Backend — Roadmap de Construção

---

# ✅ Fase 1 — Base do Sistema
> Fundação obrigatória. Sem isso, nada existe.

## Setup do Projeto
- [X] Configurar PostgreSQL
- [X] Configurar JPA/Hibernate
- [X] Adicionar Lombok
- [X] Configurar Spring Security base
- [X] Configurar Docker
- [X] Criar estrutura modular do backend
- [X] Configurar variáveis de ambiente
- [X] Configurar profiles (`dev`, `prod`)
- [X] Configurar tratamento global de exceções
- [X] Configurar padronização de respostas da API

---

## Auth Module

### Entidades
- [X] Criar `User`
- [X] Criar `RefreshToken`
- [X] Criar `OAuthAccount`

### Segurança
- [X] Configurar JWT
- [X] Criar filtro JWT
- [X] Criar autenticação via Spring Security
- [X] Configurar roles/permissões
- [X] Configurar criptografia de senha (`BCrypt`)

### Endpoints (estrutura)
- [X] `POST /auth/register`
- [X] `POST /auth/login`
- [X] `POST /auth/forgot-password`
- [X] `PATCH /auth/reset-password`
- [X] `GET /auth/verify-email`
- [X] `POST /auth/onboarding`
- [ ] `POST /auth/refresh`
- [ ] `POST /auth/logout`

### Regras (lógica)
- [ ] Validação de email único
- [ ] Validação de senha
- [ ] Logout invalidando refresh token
- [ ] Sistema de refresh token funcional

### Resultado Esperado
- [X] Login funcionando (estrutura base)
- [X] Registro funcionando (estrutura base)
- [ ] Refresh token funcionando (lógica)
- [ ] Logout funcionando (lógica)
- [X] Roles funcionando

---

# ✅ Fase 2 — Core do Produto
> Aqui o DevArena começa a existir de verdade.

---

## Challenge Module

### Entidades (estrutura)
- [X] Criar `Challenge`
- [X] Criar `ChallengeTestCase`
- [X] Criar `ChallengeHint`
- [X] Criar `Topic`
- [X] Criar `UserChallengeProgress`

### Funcionalidades (lógica)
- [ ] CRUD de desafios
- [ ] CRUD de tópicos
- [ ] Sistema de dificuldade
- [ ] Sistema de tags
- [ ] Listagem paginada
- [ ] Busca de desafios
- [ ] Relacionamento desafio ↔ tópicos

### Endpoints
- [ ] `GET /challenges`
- [ ] `GET /challenges/{id}`
- [ ] `POST /challenges`
- [ ] `PUT /challenges/{id}`
- [ ] `DELETE /challenges/{id}`

---

## Submission Module

### Entidades (estrutura)
- [X] Criar `Submission`

### Funcionalidades (lógica)
- [ ] Salvar código enviado
- [ ] Validar submissão
- [ ] Simular execução
- [ ] Gerar status (`ACCEPTED`, `WRONG_ANSWER`, `ERROR`)

### Endpoints
- [ ] `POST /submissions`
- [ ] `GET /submissions/{id}`
- [ ] `GET /users/{id}/submissions`

### Resultado Esperado
- [ ] Resolver desafios
- [ ] Salvar progresso
- [ ] Sistema de submissões funcional

---

# ✅ Fase 3 — Gamificação
> Deixa o sistema viciante.

---

## XP Module

### Entidades (estrutura)
- [X] Criar `XpTransaction`
- [X] Criar `UserStats`

### Funcionalidades (lógica)
- [ ] Ganho de XP
- [ ] Sistema de level
- [ ] Histórico de XP
- [ ] Atualização automática de stats

### Fluxo
- [ ] Completar desafio → ganhar XP
- [ ] Atualizar stats automaticamente

---

## Badge Module

### Entidades (estrutura)
- [X] Criar `Badge`
- [X] Criar `UserBadge`

### Funcionalidades (lógica)
- [ ] Sistema de conquistas
- [ ] Desbloqueio automático
- [ ] Associação usuário ↔ badge

---

## Mission Module

### Entidades (estrutura)
- [X] Criar `Mission`
- [X] Criar `UserMission`

### Funcionalidades (lógica)
- [ ] Missões diárias
- [ ] Missões semanais
- [ ] Controle de progresso
- [ ] Recompensas

### Resultado Esperado
- [ ] XP funcional
- [ ] Sistema de levels
- [ ] Badges desbloqueáveis
- [ ] Missões funcionando

---

# ✅ Fase 4 — Social / Comunidade
> O produto vira rede social.

---

## Social Layer

### Entidades (estrutura)
- [X] Criar `Follow`
- [X] Criar `Notification`

### Funcionalidades (lógica)
- [ ] Seguir usuários
- [ ] Deixar de seguir usuários
- [ ] Feed de notificações
- [ ] Notificações em tempo real

### Endpoints
- [ ] `POST /follow/{id}`
- [ ] `DELETE /follow/{id}`
- [ ] `GET /notifications`

---

## Ranking Module

### Entidades (estrutura)
- [X] Criar `Ranking`

### Funcionalidades (lógica)
- [ ] Ranking global
- [ ] Ranking semanal
- [ ] Ranking mensal
- [ ] Top usuários por XP

### Dependências
- [ ] XP
- [ ] UserStats
- [ ] Submissions

### Resultado Esperado
- [ ] Sistema social funcional
- [ ] Ranking funcional
- [ ] Notificações funcionando

---

# ✅ Fase 5 — PvP System
> A parte mais complexa do sistema.

---

## PvP Module

### Entidades (estrutura)
- [X] Criar `PvpQueue`
- [X] Criar `PvpMatch`

### Funcionalidades (lógica)
- [ ] Entrar na fila
- [ ] Matchmaking automático
- [ ] Seleção automática de desafio
- [ ] Tempo da partida
- [ ] Sistema de vencedor
- [ ] Recompensa de XP

### Fluxo
- [ ] Usuário entra na fila
- [ ] Matchmaking encontra oponente
- [ ] Partida inicia
- [ ] Jogadores resolvem desafio
- [ ] Sistema define vencedor
- [ ] XP é distribuído

### Resultado Esperado
- [ ] Matchmaking funcional
- [ ] PvP funcional em tempo real
- [ ] Ranking de PvP
- [ ] Estatísticas de PvP

---

# ✅ Fase 6 — Finalização e Polimento
> Production-ready.

---

## Segurança
- [ ] Implementar OAuth Google
- [ ] Implementar OAuth GitHub
- [ ] Rate limiting
- [ ] Auditoria de ações
- [ ] Logs de segurança
- [ ] Proteção contra brute force

---

## Infraestrutura
- [ ] Configurar Redis
- [ ] Configurar cache
- [ ] Configurar logs estruturados
- [ ] Configurar monitoramento
- [ ] Configurar observabilidade
- [ ] Configurar métricas
- [ ] Configurar reverse proxy
- [ ] Configurar NGINX
- [ ] Configurar Kubernetes
- [ ] Configurar CI/CD

---

## Performance
- [ ] Cache de rankings
- [ ] Cache de desafios
- [ ] Queries otimizadas
- [ ] Paginação otimizada

---

## Deploy
- [ ] Docker Compose
- [ ] Ambiente de staging
- [ ] Ambiente de produção
- [ ] Backup automático
- [ ] SSL/HTTPS

---

## Resultado Esperado Final
- [ ] Sistema seguro
- [ ] Sistema escalável
- [ ] Sistema performático
- [ ] Sistema production-ready

---

# 🧩 Mapa de Dependências

| Módulo | Depende de |
|--------|-------------|
| Auth | — |
| Challenge | Auth |
| Submission | Auth + Challenge |
| XP / Stats | Auth + Submission |
| Badge / Mission | Auth + XP |
| Social / Ranking | Auth + XP + Stats |
| PvP | Auth + Challenge + XP |
| Finalização | Todos os módulos |

---

# 🎯 Ordem Ideal de Desenvolvimento

- [X] Fase 1 → Base/Auth (estrutura)
- [ ] Fase 1 → Auth (lógica completa)
- [ ] Fase 2 → Challenges/Submissions
- [ ] Fase 3 → Gamificação
- [ ] Fase 4 → Social
- [ ] Fase 5 → PvP
- [ ] Fase 6 → Infra/Segurança/Deploy

---

# 📊 Status Real do Projeto

| Categoria | Feito | Total | Porcentagem |
|-----------|-------|-------|-------------|
| Entidades/Models | 18 | 18 | 100% |
| Services (lógica) | 0 | ~15 | 0% |
| Controllers | 1 | ~15 | ~7% |
| Endpoints funcionais | 6 | ~40 | ~15% |

**Resumo:** A estrutura do banco está montada (todas as entidades existem), mas a lógica de negócio está quase toda por implementar. Os `Services` estão vazios e os `Controllers` estão incompletos.