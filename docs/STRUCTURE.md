# DevArena Backend - Estrutura do Projeto

## Visão Geral

| Item | Valor |
|------|-------|
| **Grupo** | com.devarena |
| **Artefato** | DevArenaBackend |
| **Versão** | 0.0.1-SNAPSHOT |
| **Java** | 21 |
| **Spring Boot** | 3.4.1 |
| **Total Arquivos** | 155+ |

---

## Arquitetura

```
src/main/java/com/devarena/
├── DevArenaApplication.java
├── config/           (6 arquivos)
├── security/          (5 arquivos)
├── shared/            (8 arquivos)
└── modules/           (90+ arquivos)
    ├── auth/
    ├── user/
    ├── challenge/
    ├── submission/
    ├── mission/
    ├── badge/
    ├── ranking/
    ├── pvp/
    ├── notification/
    └── ai/
```

---

## Contagem por Tipo

| Tipo | Quantidade |
|------|-------------|
| Entities | 19 |
| Repositories | 18 |
| Services | 16 |
| Controllers | 10 |
| DTOs | 13 |
| Enums | 14 |
| Mappers | 9 |
| Configs | 6 |
| Security | 5 |
| Shared | 8 |

---

## Dependências Principais

- **Web**: spring-boot-starter-web
- **JPA**: spring-boot-starter-data-jpa
- **Security**: spring-boot-starter-security
- **OAuth2**: spring-boot-starter-oauth2-client
- **Validation**: spring-boot-starter-validation
- **WebSocket**: spring-boot-starter-websocket
- **Swagger**: springdoc-openapi-starter-webmvc-ui
- **PostgreSQL**: postgresql
- **JWT**: jjwt (0.12.6)
- **Lombok**: projectlombok (1.18.38)
- **MapStruct**: mapstruct (1.6.3)

---

## Como Executar

```bash
# Subir PostgreSQL
docker-compose up -d

# Compilar
./mvnw clean install

# Executar
./mvnw spring-boot:run
```

## URLs

- **API**: http://localhost:8080
- **Swagger**: http://localhost:8080/swagger-ui.html
- **Actuator**: http://localhost:8080/actuator

---

## Status: ✅ COMPILANDO