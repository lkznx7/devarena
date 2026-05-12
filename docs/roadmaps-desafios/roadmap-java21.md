# ☕ Roadmap Java 21

> Caminho completo para dominar Java 21 — da fundação ao nível sênior/arquiteto.

---

## 🗺️ Visão Geral

```
Fundamentos → POO → Coleções & Generics → Concorrência → Streams & Lambdas
→ Virtual Threads → Pattern Matching → APIs Modernas → JVM & Performance → Arquitetura
```

---

## Fase 1 — Fundamentos da Linguagem

### Sintaxe & Tipos
- [ ] Tipos primitivos (`int`, `long`, `double`, `boolean`, `char`)
- [ ] Wrapper classes (`Integer`, `Long`, `Double`)
- [ ] `var` (inferência de tipo local)
- [ ] Operadores e expressões
- [ ] Controle de fluxo: `if/else`, `switch`, `for`, `while`, `do-while`
- [ ] Arrays uni e multidimensionais

### String & Text Blocks
- [ ] `String` imutável — métodos essenciais
- [ ] `StringBuilder` e `StringBuffer`
- [ ] Text Blocks (`"""..."""`) — Java 15+
- [ ] Formatted strings: `String.format()` e `formatted()`
- [ ] `String.strip()` vs `trim()`

### Métodos & Escopo
- [ ] Definição de métodos, parâmetros, retorno
- [ ] Sobrecarga (overloading)
- [ ] Varargs (`...`)
- [ ] Escopo de variáveis
- [ ] `static` vs instância

---

## Fase 2 — Orientação a Objetos

### Classes & Objetos
- [ ] Classes, atributos, construtores
- [ ] `this`, `super`
- [ ] Modificadores de acesso: `public`, `private`, `protected`, package-private
- [ ] Encapsulamento com getters/setters
- [ ] Objetos imutáveis

### Herança & Polimorfismo
- [ ] `extends`, `@Override`
- [ ] Polimorfismo e upcasting/downcasting
- [ ] `instanceof` (pattern matching — Java 16+)
- [ ] `final` em classes e métodos
- [ ] Classe `Object` — `equals()`, `hashCode()`, `toString()`

### Interfaces & Abstrações
- [ ] `interface` com `default` e `static` methods
- [ ] `abstract class`
- [ ] Quando usar interface vs classe abstrata
- [ ] Interfaces funcionais (`@FunctionalInterface`)

### Records (Java 16+)
- [ ] Declaração de `record`
- [ ] Campos compactos e construtores customizados
- [ ] Records como DTOs imutáveis

### Sealed Classes (Java 17+)
- [ ] `sealed`, `permits`, `non-sealed`
- [ ] Uso com pattern matching

### Enums
- [ ] Enums simples e com atributos/métodos
- [ ] `EnumSet`, `EnumMap`
- [ ] Uso de enum em `switch`

---

## Fase 3 — Coleções & Generics

### Java Collections Framework
- [ ] `List`: `ArrayList`, `LinkedList`
- [ ] `Set`: `HashSet`, `LinkedHashSet`, `TreeSet`
- [ ] `Map`: `HashMap`, `LinkedHashMap`, `TreeMap`
- [ ] `Queue` e `Deque`: `ArrayDeque`, `PriorityQueue`
- [ ] Imutáveis: `List.of()`, `Map.of()`, `Set.of()`
- [ ] `Collections` utility class

### Generics
- [ ] Classes e métodos genéricos (`<T>`)
- [ ] Wildcards: `<?>`, `<? extends T>`, `<? super T>`
- [ ] Type erasure
- [ ] Bounded type parameters

### Iteração
- [ ] Enhanced for-each
- [ ] `Iterator` e `ListIterator`
- [ ] `Iterable` customizado

---

## Fase 4 — Functional Java & Streams

### Lambdas & Method References
- [ ] Sintaxe lambda `(x) -> x * 2`
- [ ] Method references: `Class::method`, `instance::method`
- [ ] Interfaces funcionais do `java.util.function`: `Function`, `Predicate`, `Consumer`, `Supplier`, `BiFunction`

### Stream API
- [ ] Criação: `stream()`, `Stream.of()`, `Stream.generate()`
- [ ] Operações intermediárias: `filter`, `map`, `flatMap`, `distinct`, `sorted`, `peek`, `limit`, `skip`
- [ ] Operações terminais: `collect`, `forEach`, `reduce`, `count`, `findFirst`, `anyMatch`
- [ ] `Collectors`: `toList()`, `toMap()`, `groupingBy()`, `joining()`
- [ ] Streams paralelos
- [ ] `IntStream`, `LongStream`, `DoubleStream`

### Optional
- [ ] `Optional.of()`, `ofNullable()`, `empty()`
- [ ] `map()`, `flatMap()`, `filter()`, `orElse()`, `orElseGet()`, `orElseThrow()`
- [ ] Anti-padrões com Optional

---

## Fase 5 — Pattern Matching (Java 21)

### Switch Expressions & Statements
- [ ] `switch` como expressão (Java 14+)
- [ ] Arrow labels (`->`)
- [ ] `yield`

### Pattern Matching
- [ ] `instanceof` com binding variable
- [ ] Pattern matching no `switch` (Java 21)
- [ ] Guarded patterns (`when`)
- [ ] Record patterns

---

## Fase 6 — Concorrência & Virtual Threads

### Concorrência Clássica
- [ ] `Thread`, `Runnable`
- [ ] `synchronized`, `volatile`
- [ ] `wait()`, `notify()`, `notifyAll()`
- [ ] `ThreadLocal`

### Executor Framework
- [ ] `ExecutorService`, `Executors`
- [ ] `Future`, `Callable`
- [ ] `CompletableFuture` — `thenApply`, `thenCompose`, `thenCombine`, `exceptionally`, `allOf`
- [ ] `ScheduledExecutorService`

### Virtual Threads (Java 21 — Project Loom)
- [ ] O que são Virtual Threads e por que importam
- [ ] `Thread.ofVirtual().start()`
- [ ] `Executors.newVirtualThreadPerTaskExecutor()`
- [ ] Structured Concurrency (`StructuredTaskScope`)
- [ ] Scoped Values (`ScopedValue`)
- [ ] Diferença: platform threads vs virtual threads
- [ ] Pinning e quando evitar

### java.util.concurrent
- [ ] `ReentrantLock`, `ReadWriteLock`
- [ ] `Semaphore`, `CountDownLatch`, `CyclicBarrier`
- [ ] `ConcurrentHashMap`, `CopyOnWriteArrayList`
- [ ] `BlockingQueue`: `LinkedBlockingQueue`, `ArrayBlockingQueue`
- [ ] `AtomicInteger`, `AtomicReference`, `LongAdder`

---

## Fase 7 — I/O, Serialização & NIO

### Java I/O Clássico
- [ ] `InputStream`, `OutputStream`
- [ ] `Reader`, `Writer`
- [ ] `BufferedReader`, `BufferedWriter`
- [ ] `FileInputStream`, `FileOutputStream`

### NIO.2 (Recomendado)
- [ ] `Path`, `Paths`, `Files`
- [ ] `Files.readAllLines()`, `Files.write()`, `Files.copy()`
- [ ] `DirectoryStream`, `WatchService`
- [ ] `FileChannel`, `ByteBuffer`

### Serialização
- [ ] `Serializable`, `serialVersionUID`
- [ ] `ObjectInputStream`, `ObjectOutputStream`
- [ ] Alternativas: JSON (Jackson/Gson), Protobuf

---

## Fase 8 — Tratamento de Erros

- [ ] Hierarquia: `Throwable` → `Error` / `Exception`
- [ ] Checked vs Unchecked exceptions
- [ ] `try-catch-finally`
- [ ] Try-with-resources (`AutoCloseable`)
- [ ] Multi-catch (`catch (A | B e)`)
- [ ] Criar exceções customizadas
- [ ] Boas práticas: nunca engolir exceções, logar adequadamente

---

## Fase 9 — Módulos & Build

### Java Module System (JPMS)
- [ ] `module-info.java`
- [ ] `requires`, `exports`, `opens`
- [ ] Módulos não nomeados vs automáticos

### Build Tools
- [ ] **Maven**: `pom.xml`, lifecycle, plugins, repositórios
- [ ] **Gradle**: `build.gradle`, tasks, Kotlin DSL
- [ ] Gerenciamento de dependências
- [ ] Perfis e ambientes

---

## Fase 10 — APIs Modernas & Ecossistema

### Date & Time API (java.time)
- [ ] `LocalDate`, `LocalTime`, `LocalDateTime`
- [ ] `ZonedDateTime`, `ZoneId`
- [ ] `Instant`, `Duration`, `Period`
- [ ] `DateTimeFormatter`

### Reflection & Annotations
- [ ] `Class<?>`, `Field`, `Method`, `Constructor`
- [ ] Annotations built-in: `@Override`, `@Deprecated`, `@SuppressWarnings`
- [ ] Criar annotations customizadas com `@Retention`, `@Target`
- [ ] Uso de reflection com frameworks (Spring, Hibernate)

### Logging
- [ ] `java.util.logging` (básico)
- [ ] SLF4J + Logback (padrão de mercado)
- [ ] Níveis: TRACE, DEBUG, INFO, WARN, ERROR
- [ ] MDC (Mapped Diagnostic Context)

---

## Fase 11 — JVM, Performance & Observabilidade

### JVM Internals
- [ ] ClassLoader hierarchy
- [ ] Bytecode e JIT compilation
- [ ] Heap, Stack, Metaspace
- [ ] Garbage Collectors: G1GC, ZGC, Shenandoah
- [ ] Tuning de GC: `-Xms`, `-Xmx`, `-XX:+UseZGC`

### Profiling & Diagnóstico
- [ ] `jcmd`, `jstack`, `jmap`, `jstat`
- [ ] JFR (Java Flight Recorder)
- [ ] JMC (Java Mission Control)
- [ ] Heap dumps e análise de memory leaks
- [ ] VisualVM

### Performance
- [ ] Benchmarking com JMH
- [ ] Entender o custo de autoboxing
- [ ] StringBuilder vs String concatenation
- [ ] Lazy initialization
- [ ] Caching com `Map.computeIfAbsent()`

---

## Fase 12 — Testes

- [ ] **JUnit 5**: `@Test`, `@BeforeEach`, `@AfterEach`, `@ParameterizedTest`, `@Nested`
- [ ] **Mockito**: `@Mock`, `@InjectMocks`, `when().thenReturn()`, `verify()`
- [ ] **AssertJ**: assertions fluentes
- [ ] **Testcontainers**: banco real em testes de integração
- [ ] Cobertura com JaCoCo
- [ ] TDD na prática

---

## Fase 13 — Arquitetura & Design Patterns

### SOLID
- [ ] Single Responsibility
- [ ] Open/Closed
- [ ] Liskov Substitution
- [ ] Interface Segregation
- [ ] Dependency Inversion

### Design Patterns (GoF)
- [ ] **Criacionais**: Builder, Factory Method, Abstract Factory, Singleton, Prototype
- [ ] **Estruturais**: Adapter, Decorator, Facade, Proxy, Composite
- [ ] **Comportamentais**: Strategy, Observer, Command, Chain of Responsibility, Template Method, Iterator

### Arquitetura
- [ ] Layered Architecture (Controller → Service → Repository)
- [ ] Hexagonal Architecture (Ports & Adapters)
- [ ] Clean Architecture
- [ ] DDD: Entities, Value Objects, Aggregates, Domain Services, Repositories

---

## Recursos Recomendados

| Recurso | Tipo |
|---|---|
| Effective Java (Joshua Bloch) | 📖 Livro |
| Java: The Complete Reference | 📖 Livro |
| [dev.java](https://dev.java) | 🌐 Docs oficiais |
| Inside Java Podcast | 🎙️ Podcast |
| JEPs (JDK Enhancement Proposals) | 📄 Specs |
| Baeldung.com | 🌐 Tutoriais |

---

*Última atualização: 2025 — baseado no Java 21 LTS*
