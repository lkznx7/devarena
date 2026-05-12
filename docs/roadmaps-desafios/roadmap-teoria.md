# Engenharia de Software, Arquitetura e Sistemas — Guia Completo

---

# 1. Engenharia de Software e Princípios de Código

## SOLID

### S — Single Responsibility Principle (SRP)
Uma classe deve ter apenas uma responsabilidade.

### O — Open/Closed Principle (OCP)
Software deve estar aberto para extensão e fechado para modificação.

### L — Liskov Substitution Principle (LSP)
Subclasses devem poder substituir suas classes base sem quebrar o sistema.

### I — Interface Segregation Principle (ISP)
Interfaces devem ser específicas e pequenas.

### D — Dependency Inversion Principle (DIP)
Dependa de abstrações e não de implementações concretas.

---

## DRY — Don't Repeat Yourself
Evite duplicação de lógica.

## KISS — Keep It Simple, Stupid
Soluções simples são mais fáceis de manter.

## YAGNI — You Aren’t Gonna Need It
Não implemente funcionalidades antes da necessidade real.

---

## Injeção de Dependência (DI)
Objetos recebem suas dependências externamente.

## Inversão de Controle (IoC)
O framework controla o ciclo de vida dos objetos.

---

# Design Patterns (GoF)

## Criacionais
- Singleton
- Factory Method
- Abstract Factory
- Builder
- Prototype

## Estruturais
- Adapter
- Decorator
- Facade
- Proxy
- Composite
- Bridge
- Flyweight

## Comportamentais
- Strategy
- Observer
- Command
- State
- Chain of Responsibility
- Mediator
- Template Method
- Iterator
- Visitor
- Memento

---

# 2. Modelagem de Domínio e Arquitetura de Software

## DDD Estratégico
- Bounded Context
- Linguagem Ubíqua
- Context Mapping
- Anti-Corruption Layer (ACL)

## DDD Tático
- Entidades
- Value Objects
- Aggregates
- Aggregate Root
- Repositórios
- Serviços de Domínio
- Domain Events

## Arquiteturas
- Monólito Modular
- Clean Architecture
- Hexagonal Architecture
- Onion Architecture
- Microservices
- Event-Driven Architecture
- CQRS
- Event Sourcing
- API Gateway
- Backend for Frontend (BFF)

---

# 3. Persistência de Dados e Bancos

## ACID
- Atomicidade
- Consistência
- Isolamento
- Durabilidade

## CAP Theorem
- Consistency
- Availability
- Partition Tolerance

## Normalização
- 1NF
- 2NF
- 3NF

## ORM
- Active Record
- Data Mapper

## Hibernate/JPA
- Persistence Context
- Dirty Checking
- Lazy Loading
- Eager Loading

## Estratégias de Banco
- Indexação B-Tree
- Hash Index
- Full-Text Search
- Sharding
- Replicação
- Cache com Redis

---

# 4. Comunicação e Sistemas Distribuídos

## APIs
- REST
- GraphQL
- gRPC
- Protobuf

## Comunicação em Tempo Real
- WebSockets
- SSE

## Mensageria
- RabbitMQ
- Kafka
- ActiveMQ

## Padrões
- Pub/Sub
- Point-to-Point
- DLQ
- Retry Queue
- Saga Pattern
- Circuit Breaker

---

# 5. Segurança, Autenticação e Autorização

## Autenticação
- Stateful
- Stateless

## JWT
- Header
- Payload
- Signature

## OAuth2 e OpenID Connect

## Controle de Acesso
- RBAC
- ABAC

## OWASP
- SQL Injection
- XSS
- CSRF
- Broken Authentication

## Criptografia
- BCrypt
- AES
- RSA

---

# 6. Engenharia de Frontend e UI

## Renderização
- CSR
- SSR
- SSG
- ISR
- Server Components

## Estado
- Local
- Global
- Estado do Servidor

## UI/UX
- Hydration
- Virtual DOM
- Reconciliation
- Design Systems
- Atomic Design
- Acessibilidade
- Responsividade

---

# 7. Integrações, Automação e IA

## Integrações
- Webhooks
- Polling
- OAuth2
- ETL

## IA
- RAG
- Embeddings
- Bancos Vetoriais
- Similaridade Cosseno
- Fine-Tuning
- Prompt Engineering
- Tool Calling
- AI Agents
- Multi-Agent Systems
- MCP

---

# 8. DevOps e SRE

## CI/CD
- Continuous Integration
- Continuous Delivery
- Continuous Deployment

## Docker e Kubernetes
- Containers
- Pods
- Deployments
- Services
- Ingress

## Infraestrutura como Código
- Terraform
- Ansible

## Observabilidade
- Logs
- Métricas
- Tracing
- Prometheus
- Grafana
- ELK Stack
- OpenTelemetry

## Deploy
- Blue/Green
- Canary Release
- Rolling Update

## Resiliência
- Retry
- Timeout
- Bulkhead

## Engenharia de Confiabilidade
- SLA
- SLI
- SLO
- Chaos Engineering
- Feature Flags

---

# Conceitos Extras

## Testes
- Unitários
- Integração
- E2E
- TDD
- BDD

## Escalabilidade
- Vertical
- Horizontal

## Concorrência
- Threads
- Async/Await
- Event Loop

## Runtime
- JVM
- JIT Compiler
- Garbage Collection

## Redes
- TCP/IP
- DNS
- HTTPS/TLS
- CDN

## Engenharia de Produto
- MVP
- Product-Market Fit
- Escalabilidade Organizacional
