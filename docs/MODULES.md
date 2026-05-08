# DevArena Backend - Relatório Detalhado de Módulos

## Módulo Auth (Autenticação)

### Descrição
Sistema completo de autenticação com JWT e suporte a OAuth2.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `AuthController.java` | Controller | Endpoints: login, register, refresh, logout |
| `AuthService.java` | Interface | Interface do serviço de autenticação |
| `AuthServiceImpl.java` | Service | Implementação do serviço |
| `UserRepository.java` | Repository | Repositório JPA para usuários |
| `OAuthAccountRepository.java` | Repository | Repositório para contas OAuth |
| `RefreshTokenRepository.java` | Repository | Repositório para refresh tokens |
| `User.java` | Entity | Entidade principal de usuário |
| `OAuthAccount.java` | Entity | Entidade para contas OAuth |
| `RefreshToken.java` | Entity | Entidade para tokens de refresh |
| `LoginRequest.java` | DTO | Request para login |
| `RegisterRequest.java` | DTO | Request para registro |
| `AuthResponse.java` | DTO | Response com tokens |
| `UserResponse.java` | DTO | Response com dados do usuário |
| `UserMapper.java` | Mapper | MapStruct para User -> UserResponse |
| `OAuthProvider.java` | Enum | GOOGLE, GITHUB, DISCORD |

### Endpoints

```
POST /api/v1/auth/login
POST /api/v1/auth/register
POST /api/v1/auth/refresh
POST /api/v1/auth/logout
```

---

## Módulo User (Usuários)

### Descrição
Gestão de perfis de usuário, estatísticas e sistema de seguidores.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `UserController.java` | Controller | Endpoints de perfil |
| `UserService.java` | Interface | Interface do serviço |
| `UserServiceImpl.java` | Service | Implementação do serviço |
| `UserStatsRepository.java` | Repository | Estatísticas do usuário |
| `XpTransactionRepository.java` | Repository | Transações de XP |
| `FollowRepository.java` | Repository | Sistema de seguidores |
| `UserStats.java` | Entity | Estatísticas (XP, level, rank) |
| `XpTransaction.java` | Entity | Histórico de XP |
| `Follow.java` | Entity | Relação de seguidores |
| `UserProfileResponse.java` | DTO | Response de perfil |
| `UserProfileMapper.java` | Mapper | Mapper para perfil |
| `Plan.java` | Enum | FREE, PRO, TEAM, ENTERPRISE |
| `UserRole.java` | Enum | USER, MODERATOR, ADMIN |

### Endpoints

```
GET    /api/v1/users/{userId}
GET    /api/v1/users/me
PUT    /api/v1/users/me
POST   /api/v1/users/{userId}/follow
DELETE /api/v1/users/{userId}/follow
```

---

## Módulo Challenge (Desafios)

### Descrição
Sistema completo de desafios de programação com temas, hints e test cases.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `ChallengeController.java` | Controller | Endpoints de desafios |
| `ChallengeService.java` | Interface | Interface do serviço |
| `ChallengeServiceImpl.java` | Service | Implementação do serviço |
| `TopicRepository.java` | Repository | Repositório de tópicos |
| `ChallengeRepository.java` | Repository | Repositório de desafios |
| `ChallengeHintRepository.java` | Repository | Hints dos desafios |
| `ChallengeTestCaseRepository.java` | Repository | Test cases |
| `UserChallengeProgressRepository.java` | Repository | Progresso do usuário |
| `Topic.java` | Entity | Tópico/categoria |
| `Challenge.java` | Entity | Desafio principal |
| `ChallengeHint.java` | Entity | Hint do desafio |
| `ChallengeTestCase.java` | Entity | Caso de teste |
| `UserChallengeProgress.java` | Entity | Progresso do usuário |
| `ChallengeListResponse.java` | DTO | Lista de desafios |
| `ChallengeDetailResponse.java` | DTO | Detalhe do desafio |
| `ChallengeMapper.java` | Mapper | Mapper de desafios |
| `Difficulty.java` | Enum | EASY, MEDIUM, HARD, EXPERT |
| `Language.java` | Enum | JAVASCRIPT, PYTHON, JAVA, etc |

### Endpoints

```
GET /api/v1/challenges
GET /api/v1/challenges/{id}
GET /api/v1/challenges/slug/{slug}
```

---

## Módulo Submission (Submissões)

### Descrição
Sistema de execução de código e verificação de resultados.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `SubmissionController.java` | Controller | Endpoints de submissão |
| `SubmissionService.java` | Interface | Interface do serviço |
| `SubmissionServiceImpl.java` | Service | Implementação do serviço |
| `SubmissionRepository.java` | Repository | Repositório de submissões |
| `Submission.java` | Entity | Entidade de submissão |
| `SubmissionRequest.java` | DTO | Request de submissão |
| `SubmissionResponse.java` | DTO | Response de submissão |
| `SubmissionMapper.java` | Mapper | Mapper de submissão |
| `SubmissionStatus.java` | Enum | PENDING, ACCEPTED, WRONG_ANSWER, etc |

### Endpoints

```
POST /api/v1/submissions
GET /api/v1/submissions/{id}
GET /api/v1/submissions/user/{userId}
GET /api/v1/submissions/challenge/{challengeId}
```

---

## Módulo Mission (Missões)

### Descrição
Sistema de missões diárias, semanais e mensais com recompensas.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `MissionController.java` | Controller | Endpoints de missões |
| `MissionService.java` | Interface | Interface do serviço |
| `MissionServiceImpl.java` | Service | Implementação do serviço |
| `MissionRepository.java` | Repository | Repositório de missões |
| `UserMissionRepository.java` | Repository | Progresso do usuário |
| `Mission.java` | Entity | Entidade de missão |
| `UserMission.java` | Entity | Progresso do usuário |
| `MissionResponse.java` | DTO | Response de missão |
| `MissionMapper.java` | Mapper | Mapper de missão |
| `MissionType.java` | Enum | DAILY, WEEKLY, MONTHLY, EVENT |
| `GoalType.java` | Enum | CHALLENGES_COMPLETED, PVP_WINS, etc |

### Endpoints

```
GET /api/v1/missions
GET /api/v1/missions/my
```

---

## Módulo Badge (Conquistas)

### Descrição
Sistema de conquistas e badges com raridade.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `BadgeController.java` | Controller | Endpoints de badges |
| `BadgeService.java` | Interface | Interface do serviço |
| `BadgeServiceImpl.java` | Service | Implementação do serviço |
| `BadgeRepository.java` | Repository | Repositório de badges |
| `UserBadgeRepository.java` | Repository | Badges do usuário |
| `Badge.java` | Entity | Entidade de badge |
| `UserBadge.java` | Entity | Badge conquistado |
| `BadgeResponse.java` | DTO | Response de badge |
| `BadgeMapper.java` | Mapper | Mapper de badge |
| `Rarity.java` | Enum | COMMON, UNCOMMON, RARE, EPIC, LEGENDARY |
| `BadgeCategory.java` | Enum | CHALLENGES, PVP, STREAK, SOCIAL, XP, SPECIAL |

### Endpoints

```
GET /api/v1/badges
GET /api/v1/badges/user/{userId}
```

---

## Módulo Ranking (Rankings)

### Descrição
Sistema de rankings global, semanal e por tipo.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `RankingController.java` | Controller | Endpoints de ranking |
| `RankingService.java` | Interface | Interface do serviço |
| `RankingServiceImpl.java` | Service | Implementação do serviço |
| `RankingRepository.java` | Repository | Repositório de ranking |
| `Ranking.java` | Entity | Entidade de ranking |
| `RankingResponse.java` | DTO | Response de ranking |
| `RankingMapper.java` | Mapper | Mapper de ranking |
| `RankingType.java` | Enum | GLOBAL, WEEKLY, MONTHLY, PVP, CHALLENGES |

### Endpoints

```
GET /api/v1/rankings
GET /api/v1/rankings/{type}
GET /api/v1/rankings/user/{userId}
```

---

## Módulo PvP (Batalha)

### Descrição
Sistema de batalhas em tempo real com filas e partidas.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `PvpController.java` | Controller | Endpoints de PvP |
| `PvpService.java` | Interface | Interface do serviço |
| `PvpServiceImpl.java` | Service | Implementação do serviço |
| `PvpMatchRepository.java` | Repository | Repositório de partidas |
| `PvpQueueRepository.java` | Repository | Repositório de fila |
| `PvpMatch.java` | Entity | Entidade de partida |
| `PvpQueue.java` | Entity | Entidade de fila |
| `QueueResponse.java` | DTO | Response de fila |
| `PvpMatchResponse.java` | DTO | Response de partida |
| `PvpMatchMapper.java` | Mapper | Mapper de partida |
| `MatchMode.java` | Enum | RANKED, CASUAL, BLITZ |
| `MatchStatus.java` | Enum | WAITING, IN_PROGRESS, COMPLETED, CANCELLED |

### Endpoints

```
POST /api/v1/pvp/queue
DELETE /api/v1/pvp/queue
GET /api/v1/pvp/match/{matchId}
GET /api/v1/pvp/matches
```

---

## Módulo Notification (Notificações)

### Descrição
Sistema de notificações em tempo real via WebSocket.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `NotificationController.java` | Controller | Endpoints de notificações |
| `NotificationService.java` | Interface | Interface do serviço |
| `NotificationServiceImpl.java` | Service | Implementação do serviço |
| `NotificationRepository.java` | Repository | Repositório de notificações |
| `Notification.java` | Entity | Entidade de notificação |
| `NotificationResponse.java` | DTO | Response de notificação |
| `NotificationMapper.java` | Mapper | Mapper de notificação |
| `NotificationType.java` | Enum | ACHIEVEMENT, CHALLENGE, PVP, MISSION, BADGE, SYSTEM |

### Endpoints

```
GET /api/v1/notifications
GET /api/v1/notifications/unread-count
PUT /api/v1/notifications/{id}/read
PUT /api/v1/notifications/read-all
```

---

## Módulo AI (Inteligência Artificial)

### Descrição
Integração com serviços de IA para hints e execução de código.

### Arquivos

| Arquivo | Tipo | Descrição |
|---------|------|-----------|
| `AiController.java` | Controller | Endpoints de IA |
| `AiService.java` | Service | Serviço de IA |
| `CodeExecutionClient.java` | Client | Cliente de execução de código |

### Endpoints

```
POST /api/v1/ai/hint
```

---

## Configurações

| Arquivo | Descrição |
|---------|-----------|
| `SecurityConfig.java` | Configuração de segurança Spring |
| `WebSocketConfig.java` | Configuração STOMP WebSocket |
| `OpenApiConfig.java` | Configuração Swagger/OpenAPI |
| `CorsConfig.java` | Configuração de CORS |
| `CacheConfig.java` | Configuração de cache |
| `JacksonConfig.java` | Configuração de serialização JSON |

---

## Security

| Arquivo | Descrição |
|---------|-----------|
| `JwtTokenProvider.java` | Provedor de tokens JWT |
| `JwtAuthenticationFilter.java` | Filtro de autenticação JWT |
| `OAuthConfig.java` | Configuração OAuth2 |
| `JwtAuthenticationEntryPoint.java` | Handler de acesso negado |
| `CustomUserDetailsService.java` | Serviço de usuários para Spring Security |

---

## Shared

| Arquivo | Descrição |
|---------|-----------|
| `BusinessException.java` | Exceção de negócio |
| `ResourceNotFoundException.java` | Exceção de recurso não encontrado |
| `UnauthorizedException.java` | Exceção de acesso não autorizado |
| `ApiResponse.java` | Response padrão da API |
| `AppConstants.java` | Constantes da aplicação |
| `IdGenerator.java` | Gerador de IDs |
| `GlobalMapper.java` | Mapper global |
| `Status.java` | Enum de status |
| `OAuthProvider.java` | Enum de provedores OAuth |