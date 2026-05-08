# Entidades e Atributos - DevArena Backend

Total: 20 Entidades

---

## 1. User (Auth Module)
**Tabela:** `users`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | UUID | Chave primária |
| email | String | Email do usuário |
| password | String | Senha criptografada |
| displayName | String | Nome de exibição |
| avatarUrl | String | URL do avatar |
| bio | String | Biografia |
| xp | Integer | Pontos de experiência |
| level | Integer | Nível do usuário |
| plan | String | Plano de assinatura |
| role | String | Função do usuário |
| isActive | Boolean | Status da conta |
| createdAt | LocalDateTime | Data de criação |
| updatedAt | LocalDateTime | Data de atualização |

---

## 2. RefreshToken (Auth Module)
**Tabela:** `refresh_tokens`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| token | String | Token JWT de refresh |
| isRevoked | Boolean | Status de revogação |

---

## 3. OAuthAccount (Auth Module)
**Tabela:** `oauth_accounts`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| provider | String | Provider OAuth (Google, GitHub, etc) |
| providerId | String | ID do usuário no provider |
| accessToken | String | Token de acesso OAuth |
| refreshToken | String | Token de refresh OAuth |

---

## 4. Notification (Notification Module)
**Tabela:** `notifications`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | ID do usuário destinatário |
| type | String | Tipo de notificação |
| title | String | Título da notificação |
| message | String | Mensagem da notificação |
| isRead | Boolean | Status de leitura |
| relatedId | Long | ID da entidade relacionada |
| relatedType | String | Tipo da entidade relacionada |

---

## 5. Mission (Mission Module)
**Tabela:** `missions`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| title | String | Título da missão |
| description | String | Descrição da missão |
| type | String | Tipo da missão |
| goalType | String | Tipo do objetivo |
| goalValue | Integer | Valor alvo do objetivo |
| xpReward | Integer | Recompensa de XP |
| isActive | Boolean | Status ativo |

---

## 6. UserMission (Mission Module)
**Tabela:** `user_missions`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| missionId | Long | Referência ao Mission |
| progress | Integer | Progresso atual |
| status | String | Status da missão |

---

## 7. Ranking (Ranking Module)
**Tabela:** `rankings`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| userDisplayName | String | Nome de exibição do usuário |
| userAvatarUrl | String | URL do avatar do usuário |
| score | Integer | Pontuação |
| rank | Integer | Rank atual |
| type | String | Tipo de ranking |
| period | String | Período do ranking |

---

## 8. Submission (Submission Module)
**Tabela:** `submissions`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| challengeId | Long | Referência ao Challenge |
| code | String | Código submetido |
| language | String | Linguagem de programação |
| status | String | Status da submissão |
| errorMessage | String | Mensagem de erro se falhou |
| executionTime | Integer | Tempo de execução (ms) |
| memoryUsed | Integer | Memória usada (KB) |

---

## 9. Follow (User Module)
**Tabela:** `follows`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| followerId | Long | Usuário que segue |
| followingId | Long | Usuário sendo seguido |

---

## 10. XpTransaction (User Module)
**Tabela:** `xp_transactions`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| amount | Integer | Quantidade de XP (+/-) |
| reason | String | Motivo da transação |

---

## 11. UserStats (User Module)
**Tabela:** `user_stats`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| totalXp | Integer | XP total acumulado |
| challengesCompleted | Integer | Quantidade de desafios completados |
| submissionsMade | Integer | Total de submissões |
| pvpWins | Integer | Vitórias PvP |
| pvpLosses | Integer | Derrotas PvP |
| currentStreak | Integer | Sequência atual de vitórias |
| longestStreak | Integer | Maior sequência de vitórias |
| rankScore | Integer | Pontuação de rank |

---

## 12. PvpMatch (PvP Module)
**Tabela:** `pvp_matches`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| player1Id | Long | ID do primeiro jogador |
| player2Id | Long | ID do segundo jogador |
| mode | String | Modo da partida |
| status | String | Status da partida |
| winnerId | Long | ID do vencedor |
| player1Score | Integer | Pontuação do jogador 1 |
| player2Score | Integer | Pontuação do jogador 2 |
| challengeId | Long | Desafio usado na partida |

---

## 13. PvpQueue (PvP Module)
**Tabela:** `pvp_queues`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Usuário na fila |
| mode | String | Modo da fila |
| status | String | Status da fila |

---

## 14. Badge (Badge Module)
**Tabela:** `badges`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| name | String | Nome da badge |
| description | String | Descrição da badge |
| iconUrl | String | URL do ícone |
| rarity | String | Nível de raridade |
| category | String | Categoria da badge |
| xpReward | Integer | Recompensa de XP |
| requirementType | String | Tipo de requisito |
| requirementValue | Integer | Valor do requisito |
| isActive | Boolean | Status ativo |

---

## 15. UserBadge (Badge Module)
**Tabela:** `user_badges`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| badgeId | Long | Referência ao Badge |

---

## 16. Challenge (Challenge Module)
**Tabela:** `challenges`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| title | String | Título do desafio |
| slug | String | Slug amigável para URL |
| description | String | Descrição do desafio |
| difficulty | String | Nível de dificuldade |
| category | String | Categoria do desafio |
| defaultCode | String | Código inicial padrão |
| solution | String | Código da solução |
| language | String | Linguagem de programação |
| defaultTestCode | String | Código de teste padrão |
| xpReward | Integer | Recompensa de XP |
| timeLimit | Integer | Limite de tempo (ms) |
| memoryLimit | Integer | Limite de memória (MB) |
| isActive | Boolean | Status ativo |

---

## 17. ChallengeHint (Challenge Module)
**Tabela:** `challenge_hints`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| challengeId | Long | Referência ao Challenge |
| content | String | Conteúdo da dica |
| orderIndex | Integer | Ordem da dica |
| xpPenalty | Integer | Penalidade de XP por usar |

---

## 18. ChallengeTestCase (Challenge Module)
**Tabela:** `challenge_test_cases`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| challengeId | Long | Referência ao Challenge |
| input | String | Input do teste |
| expectedOutput | String | Output esperado |
| isHidden | Boolean | Caso de teste oculto |
| orderIndex | Integer | Ordem do caso de teste |

---

## 19. UserChallengeProgress (Challenge Module)
**Tabela:** `user_challenge_progress`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| userId | Long | Referência ao User |
| challengeId | Long | Referência ao Challenge |
| status | String | Status do progresso |
| currentCode | String | Código atual salvo |
| attempts | Integer | Contagem de tentativas |
| bestTime | Integer | Melhor tempo de conclusão |

---

## 20. Topic (Challenge Module)
**Tabela:** `topics`

| Campo | Tipo | Descrição |
|-------|------|-------------|
| id | Long | Chave primária |
| name | String | Nome do tópico |
| slug | String | Slug amigável para URL |
| description | String | Descrição do tópico |
| iconUrl | String | URL do ícone |
| color | String | Cor do tópico |
| isActive | Boolean | Status ativo |

---

## Relacionamentos entre Entidades

| Entidade Origem | Entidade Destino | Relacionamento |
|-----------------|------------------|----------------|
| RefreshToken | User | userId -> User.id |
| OAuthAccount | User | userId -> User.id |
| Notification | User | userId -> User.id |
| UserMission | User | userId -> User.id |
| UserMission | Mission | missionId -> Mission.id |
| Ranking | User | userId -> User.id |
| Submission | User | userId -> User.id |
| Submission | Challenge | challengeId -> Challenge.id |
| Follow | User | followerId, followingId -> User.id |
| XpTransaction | User | userId -> User.id |
| UserStats | User | userId -> User.id |
| PvpMatch | User | player1Id, player2Id, winnerId -> User.id |
| PvpMatch | Challenge | challengeId -> Challenge.id |
| PvpQueue | User | userId -> User.id |
| UserBadge | User | userId -> User.id |
| UserBadge | Badge | badgeId -> Badge.id |
| UserChallengeProgress | User | userId -> User.id |
| UserChallengeProgress | Challenge | challengeId -> Challenge.id |
| ChallengeHint | Challenge | challengeId -> Challenge.id |
| ChallengeTestCase | Challenge | challengeId -> Challenge.id |