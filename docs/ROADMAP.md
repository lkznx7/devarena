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
- [ ] Configurar JWT
- [ ] Criar filtro JWT
- [X] Criar autenticação via Spring Security
- [X] Configurar roles/permissões
- [X] Configurar criptografia de senha (`BCrypt`)

### Endpoints
- [ ] `POST /auth/register`
- [ ] `POST /auth/login`
- [ ] `POST /auth/refresh`
- [ ] `POST /auth/logout`

### Regras
- [ ] Validação de email único
- [ ] Validação de senha
- [ ] Logout invalidando refresh token
- [ ] Sistema de refresh token funcional

### Resultado Esperado
- [ ] Login funcionando
- [ ] Registro funcionando
- [ ] Refresh token funcionando
- [ ] Logout funcionando
- [ ] Roles funcionando

---

# ✅ Fase 2 — Core do Produto
> Aqui o DevArena começa a existir de verdade.

---

## Challenge Module

### Ordem de Construção
- [X] Criar `Challenge`
- [ ] Criar `ChallengeTestCase`
- [ ] Criar `ChallengeHint`
- [ ] Criar `Topic`
- [ ] Criar `UserChallengeProgress`

### Funcionalidades
- [X] CRUD de desafios
- [ ] CRUD de tópicos
- [X] Sistema de dificuldade
- [X] Sistema de tags
- [X] Listagem paginada
- [X] Busca de desafios
- [X] Relacionamento desafio ↔ tópicos

### Endpoints
- [X] `GET /challenges`
- [X] `GET /challenges/{id}`
- [X] `POST /challenges`
- [X] `PUT /challenges/{id}`
- [X] `DELETE /challenges/{id}`

---

## Submission Module

### Entidades
- [X] Criar `Submission`

### Funcionalidades
- [X] Salvar código enviado
- [X] Validar submissão
- [ ] Simular execução
- [X] Gerar status:
   - [X] `ACCEPTED`
   - [X] `WRONG_ANSWER`
   - [X] `ERROR`

### Endpoints
- [X] `POST /submissions`
- [X] `GET /submissions/{id}`
- [X] `GET /users/{id}/submissions`

### Resultado Esperado
- [X] Resolver desafios
- [X] Salvar progresso
- [X] Sistema de submissões funcional

---

# ✅ Fase 3 — Gamificação
> Deixa o sistema viciante.

---

## XP Module

### Entidades
- [X] Criar `XpTransaction`
- [X] Criar `UserStats`

### Funcionalidades
- [X] Ganho de XP
- [X] Sistema de level
- [X] Histórico de XP
- [X] Atualização automática de stats

### Fluxo
- [X] Completar desafio → ganhar XP
- [X] Atualizar stats automaticamente

---

## Badge Module

### Entidades
- [ ] Criar `Badge`
- [ ] Criar `UserBadge`

### Funcionalidades
- [ ] Sistema de conquistas
- [ ] Desbloqueio automático
- [ ] Associação usuário ↔ badge

---

## Mission Module

### Entidades
- [X] Criar `Mission`
- [X] Criar `UserMission`

### Funcionalidades
- [X] Missões diárias
- [X] Missões semanais
- [X] Controle de progresso
- [X] Recompensas

### Resultado Esperado
- [X] XP funcional
- [X] Sistema de levels
- [X] Badges desbloqueáveis
- [X] Missões funcionando

---

# ✅ Fase 4 — Social / Comunidade
> O produto vira rede social.

---

## Social Layer

### Entidades
- [X] Criar `Follow`
- [ ] Criar `Notification`

### Funcionalidades
- [X] Seguir usuários
- [X] Deixar de seguir usuários
- [ ] Feed de notificações
- [ ] Notificações em tempo real

### Endpoints
- [X] `POST /follow/{id}`
- [X] `DELETE /follow/{id}`
- [ ] `GET /notifications`

---

## Ranking Module

### Entidades
- [ ] Criar `Ranking`

### Funcionalidades
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

### Ordem de Construção
- [X] Criar `PvpQueue`
- [X] Criar `PvpMatch`

### Funcionalidades
- [X] Entrar na fila
- [X] Matchmaking automático
- [X] Seleção automática de desafio
- [X] Tempo da partida
- [X] Sistema de vencedor
- [X] Recompensa de XP

### Fluxo
- [X] Usuário entra na fila
- [X] Matchmaking encontra oponente
- [X] Partida inicia
- [X] Jogadores resolvem desafio
- [X] Sistema define vencedor
- [X] XP é distribuído

### Resultado Esperado
- [X] Matchmaking funcional
- [X] PvP funcional em tempo real

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

- [ ] Fase 1 → Base/Auth
- [ ] Fase 2 → Challenges/Submissions
- [ ] Fase 3 → Gamificação
- [ ] Fase 4 → Social
- [ ] Fase 5 → PvP
- [ ] Fase 6 → Infra/Segurança/Deploy