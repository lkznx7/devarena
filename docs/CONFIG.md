# DevArena Backend - Configurações e Tecnologias

## Tecnologias

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| Java | 21 | Linguagem de programação |
| Spring Boot | 3.4.1 | Framework principal |
| Spring Security | 6.x | Segurança |
| JPA/Hibernate | 6.x | ORM |
| PostgreSQL | 16 | Banco de dados |
| Maven | 3.x | Gerenciador de dependências |
| Lombok | 1.18.38 | Redução de boilerplate |
| MapStruct | 1.6.3 | Mapeamento de objetos |
| JWT | 0.12.6 | Autenticação stateless |
| WebSocket | Spring | Comunicação temps real |
| Swagger | 2.6.0 | Documentação API |

---

## application.yml

```yaml
spring:
  application:
    name: DevArenaBackend

  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/devarena}
    username: ${DB_USER:postgres}
    password: ${DB_PASSWORD:postgres}
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true

  jackson:
    serialization:
      write-dates-as-timestamps: false
    time-zone: UTC

server:
  port: ${APP_PORT:8080}

jwt:
  secret: ${JWT_SECRET:your-256-bit-secret-key-for-jwt-signing-minimum-32-chars}
  expiration: 3600000
  refresh-expiration: 86400000

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    enabled: true

logging:
  level:
    com.devarena: DEBUG
    org.springframework.security: DEBUG
```

---

## SecurityConfig

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api-docs/**", "/swagger-ui/**", "/actuator/**").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
```

**Configurações:**
- CSRF desabilitado (API stateless)
- Sessão Stateless
- Endpoints públicos: /api-docs, /swagger-ui, /actuator

---

## WebSocketConfig

```java
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }
}
```

**Endpoints WebSocket:**
- STOMP endpoint: `/ws`
- Prefixo de destino: `/app`
- Broker: `/topic`, `/queue`

---

## OpenApiConfig

```java
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("DevArena API")
                .description("API da plataforma DevArena")
                .version("1.0.0"))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")));
    }
}
```

---

## JwtTokenProvider

```java
@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    @Value("${jwt.refresh-expiration}")
    private long refreshExpiration;

    // Métodos:
    // - generateToken(String username)
    // - generateRefreshToken(String username)
    // - getUsernameFromToken(String token)
    // - validateToken(String token)
}
```

**Configurações JWT:**
- Secret: 256 bits mínimo
- Expiração access token: 1 hora (3600000ms)
- Expiração refresh token: 24 horas (86400000ms)

---

## CorsConfig

```java
@Configuration
public class CorsConfig {
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("Authorization"));
        // ...
    }
}
```

---

## JacksonConfig

```java
@Configuration
public class JacksonConfig {
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }
}
```

**Configurações:**
- JavaTimeModule para datas
- Dates como timestamps desabilitado
- Timezone UTC

---

## Docker Compose

```yaml
services:
  postgres:
    image: postgres:16-alpine
    container_name: devarena-postgres
    environment:
      POSTGRES_DB: devarena
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U postgres"]
      interval: 10s
      timeout: 5s
      retries: 5

volumes:
  postgres_data:
```

---

## Variáveis de Ambiente

| Variável | Padrão | Descrição |
|----------|--------|-----------|
| `DB_URL` | jdbc:postgresql://localhost:5432/devarena | URL do banco |
| `DB_USER` | postgres | Usuário do banco |
| `DB_PASSWORD` | postgres | Senha do banco |
| `APP_PORT` | 8080 | Porta da aplicação |
| `JWT_SECRET` | (configurado) | Secret para JWT |

---

## Maven Dependencies

```xml
<!-- Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- OAuth2 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>

<!-- Validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- WebSocket -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>

<!-- Swagger -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.6.0</version>
</dependency>

<!-- PostgreSQL -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- JWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.6</version>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- MapStruct -->
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.6.3</version>
</dependency>
```

---

## URLs da Aplicação

| URL | Descrição |
|-----|-----------|
| http://localhost:8080 | API REST |
| http://localhost:8080/swagger-ui.html | Swagger UI |
| http://localhost:8080/api-docs | OpenAPI JSON |
| http://localhost:8080/actuator | Spring Actuator |
| ws://localhost:8080/ws | WebSocket STOMP |