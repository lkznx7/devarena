# 🏆 Checklist DevArena: Rumo aos 100% (Backlog MVP)

Este documento detalha todas as tarefas pendentes para transformar o DevArena de um esqueleto de código em uma plataforma de desafios de programação funcional e profissional.

---

## 🏗️ 1. Módulo de Desafios (Core) - PRIORIDADE ATUAL
*Onde a trilha de roadmaps ganha vida.*

- [ ] **Refatoração de Tipagem**: Mudar `difficulty` e `language` para Enums.
- [ ] **Adaptação JPA**: Adicionar `@Column(columnDefinition = "TEXT")` para suportar blocos de código e Markdown.
- [ ] **CRUD de Tópicos**: Implementar criação e listagem das "Fases" dos roadmaps.
- [ ] **CRUD de Desafios**: Implementar lógica de criação com geração automática de `slug`.
- [ ] **Listagem Paginada**: Endpoint `/challenges` com filtros por linguagem, tópico e dificuldade.
- [ ] **Padrão de Resposta**: Garantir que nenhum endpoint de listagem vaze a `solution` do desafio.

## ⚙️ 2. Módulo de Submissão (O Motor)
*Onde o código do usuário é avaliado.*

- [ ] **Integração com Executor**: Integrar com a **Piston API** (ou similar) para rodar código de forma segura.
- [ ] **Validador de Testes**: Lógica que percorre os `ChallengeTestCase` e compara o `output` real com o esperado.
- [ ] **Status de Submissão**: Implementar os retornos: `ACCEPTED`, `WRONG_ANSWER`, `RUNTIME_ERROR`, `TIME_LIMIT_EXCEEDED`.
- [ ] **Histórico**: Listar as submissões anteriores do usuário para cada desafio.

## 🎮 3. Módulo de Gamificação (XP & Stats)
*O que torna a plataforma viciante.*

- [ ] **Motor de XP**: Lógica que calcula e atribui XP ao usuário ao resolver um desafio (baseado na dificuldade).
- [ ] **Sistema de Níveis**: Definir a curva de XP necessária para subir de nível (Level 1, 2, 3...).
- [ ] **Estatísticas em Tempo Real**: Atualizar o `UserStats` (total de desafios resolvidos, linguagem favorita, streak).
- [ ] **Sistema de Badges**: Lógica para "conquistar" medalhas (ex: "Primeiro Script em Python", "Mestre do Java").

## 🧠 4. Módulo de IA (Mentor & Review)
*O diferencial competitivo.*

- [ ] **Orquestrador (LangChain4j)**: Implementar o roteador que entende a dúvida do usuário.
- [ ] **Agentes Especializados**:
    - [ ] `Code Reviewer`: Sugestões de Clean Code após o `ACCEPTED`.
    - [ ] `Mentor Agent`: Fornecer *hints* progressivos sem dar a resposta.
- [ ] **Integração de Ferramentas (Tools)**: Permitir que a IA leia os testes que falharam.

## ⚔️ 5. Módulo PvP (Arena 1v1)
*O desafio em tempo real.*

- [ ] **WebSockets (STOMP)**: Configurar a comunicação bidirecional para partidas em tempo real.
- [ ] **Matchmaking**: Lógica de fila para encontrar oponentes com MMR (Ranking) similar.
- [ ] **Sincronização de Arena**: Garantir que ambos os jogadores recebam o mesmo desafio simultaneamente.
- [ ] **Resolução de Partida**: Definir o vencedor por tempo ou por precisão dos testes.

## 📣 6. Módulo Social e Notificações
*Engajamento da comunidade.*

- [ ] **Sistema de Follow**: Permitir que usuários sigam uns aos outros.
- [ ] **Feed de Atividade**: Mostrar conquistas dos amigos.
- [ ] **Notificações**:
    - [ ] In-app (WebSockets).
    - [ ] Push/Email (para convites de PvP ou novos desafios).

## 🛡️ 7. Segurança e Qualidade (Production Ready)
*Protegendo a casa.*

- [ ] **Rate Limiting**: Evitar abuso nos endpoints de IA e Submissão (Prevenir custos e spam).
- [ ] **Validação de Entrada**: Bean Validation em todos os DTOs.
- [ ] **Logs Estruturados**: Configurar logs para auditoria de erros.
- [ ] **CORS**: Configurar para aceitar apenas o domínio oficial do Frontend.

## 🚀 8. Infraestrutura e Deploy
*Colocando no ar.*

- [ ] **Configuração do Redis**: Cache de rankings e sessões WebSocket.
- [ ] **CI/CD Pipeline**: Configurar GitHub Actions para rodar testes e fazer deploy automático.
- [ ] **Monitoramento**: Configurar Spring Boot Actuator + Prometheus/Grafana.

---

### ✅ O que já está 100%:
1. **Estrutura de Pastas e Modularização.**
2. **Auth (Login, Register, Verify Email, Refresh Token, Logout, OAuth2 Google).**
3. **Padronização ApiResponse<T> e Global Error Handling.**
4. **Remoção total de dependência do Lombok.**
5. **Roadmaps de Conteúdo (Java, Python, JS, etc).**

---
*Documento gerado em 12/05/2026 - Sprint: MVP Foundation*
