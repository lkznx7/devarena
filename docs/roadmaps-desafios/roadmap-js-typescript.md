# 🟡→🔷 Roadmap JavaScript → TypeScript

> Da base do JS moderno até TypeScript avançado — o caminho completo para o ecossistema frontend/fullstack.

---

## 🗺️ Visão Geral

```
JS Core → Async JS → Módulos → TypeScript Core → Tipos Avançados
→ Padrões OOP/FP → Ecossistema → Node.js/Runtime → Arquitetura
```

---

# PARTE 1 — JavaScript Moderno (ES6+)

## Fase 1 — Fundamentos JS

### Tipos & Variáveis
- [ ] `var`, `let`, `const` — diferenças e hoisting
- [ ] Tipos primitivos: `string`, `number`, `bigint`, `boolean`, `undefined`, `null`, `symbol`
- [ ] `typeof`, `instanceof`
- [ ] Coerção implícita e explícita
- [ ] Template literals: `` `Hello, ${name}!` ``
- [ ] Tagged templates

### Funções
- [ ] Function declaration vs expression
- [ ] Arrow functions `() => {}`
- [ ] Default params, rest params `...args`
- [ ] Closures
- [ ] IIFE (Immediately Invoked Function Expression)
- [ ] `arguments` object vs rest params
- [ ] Funções como first-class citizens

### Objetos & Arrays
- [ ] Object literals, shorthand properties
- [ ] Computed property names `{ [key]: value }`
- [ ] Destructuring: objetos e arrays
- [ ] Spread `...` e rest
- [ ] Optional chaining `?.`
- [ ] Nullish coalescing `??`
- [ ] Logical assignment: `??=`, `||=`, `&&=`
- [ ] `Object.keys()`, `Object.values()`, `Object.entries()`, `Object.assign()`, `Object.freeze()`

### Controle de Fluxo
- [ ] `if/else`, ternário
- [ ] `switch` com fall-through
- [ ] `for`, `for...of`, `for...in`
- [ ] `Array.forEach()`, `map()`, `filter()`, `reduce()`, `find()`, `some()`, `every()`, `flat()`, `flatMap()`
- [ ] `while`, `do...while`
- [ ] Labels e `break/continue`

---

## Fase 2 — JavaScript Orientado a Objetos

### Prototype & Classes
- [ ] Prototype chain
- [ ] `Object.create()`
- [ ] `class`, `constructor`, `new`
- [ ] `extends`, `super()`
- [ ] `static` methods e properties
- [ ] Private fields `#`
- [ ] Getters e setters
- [ ] `instanceof` e verificação de tipo

### `this` keyword
- [ ] `this` em funções regulares vs arrow functions
- [ ] `bind()`, `call()`, `apply()`
- [ ] `this` em métodos de classe
- [ ] `this` em callbacks — armadilhas comuns

---

## Fase 3 — JavaScript Assíncrono

### Event Loop
- [ ] Call stack, Web APIs, Callback queue, Microtask queue
- [ ] Como o event loop funciona de verdade
- [ ] `setTimeout`, `setInterval`, `clearTimeout`
- [ ] `queueMicrotask()`

### Callbacks & Promises
- [ ] Callback pattern e callback hell
- [ ] `Promise` — `resolve`, `reject`
- [ ] `.then()`, `.catch()`, `.finally()`
- [ ] `Promise.all()`, `Promise.allSettled()`, `Promise.race()`, `Promise.any()`
- [ ] Criando Promises customizadas

### Async/Await
- [ ] `async function`, `await`
- [ ] Error handling com `try/catch`
- [ ] `await` em paralelo vs sequencial
- [ ] Top-level await (ESM)
- [ ] `for await...of` (async iterators)

---

## Fase 4 — Módulos & Tooling JS

### ES Modules
- [ ] `import`, `export`, `export default`
- [ ] Named vs default exports
- [ ] Re-exports: `export { x } from './module'`
- [ ] Dynamic imports: `import()`
- [ ] `import.meta`

### Ferramentas
- [ ] **npm / pnpm / yarn** — gerenciamento de pacotes
- [ ] `package.json` — scripts, dependencies, devDependencies, peerDependencies
- [ ] **Vite** — bundler moderno (dev server + build)
- [ ] **esbuild** — bundler ultrarrápido
- [ ] **ESLint** — linting
- [ ] **Prettier** — formatting

---

## Fase 5 — JavaScript Avançado

### Iteradores & Generators
- [ ] `Symbol.iterator`, protocolo iterável
- [ ] Generator functions `function*`, `yield`
- [ ] `yield*`
- [ ] Async generators

### Proxy & Reflect
- [ ] `new Proxy(target, handler)`
- [ ] Traps: `get`, `set`, `has`, `deleteProperty`, `apply`
- [ ] `Reflect` API
- [ ] Casos de uso: validação, observabilidade, memoização

### WeakMap, WeakSet, WeakRef
- [ ] `WeakMap` e casos de uso (dados privados, cache sem leak)
- [ ] `WeakSet`
- [ ] `WeakRef` e `FinalizationRegistry`

### Symbols
- [ ] `Symbol()`, `Symbol.for()`
- [ ] Well-known symbols: `Symbol.iterator`, `Symbol.toPrimitive`, `Symbol.toStringTag`

### Intl API
- [ ] `Intl.NumberFormat`, `Intl.DateTimeFormat`
- [ ] `Intl.Collator`, `Intl.RelativeTimeFormat`
- [ ] `Intl.Segmenter`

---

# PARTE 2 — TypeScript

## Fase 6 — TypeScript Core

### Setup & Configuração
- [ ] Instalar TypeScript: `npm i -D typescript`
- [ ] `tsconfig.json` — opções essenciais
- [ ] `strict: true` e o que ativa (`strictNullChecks`, `noImplicitAny`, etc.)
- [ ] `target`, `module`, `outDir`, `rootDir`
- [ ] `paths` para aliases
- [ ] `declaration` e `.d.ts`
- [ ] **ts-node**, **tsx** — executar TS diretamente

### Tipos Básicos
- [ ] `string`, `number`, `boolean`, `null`, `undefined`, `any`, `unknown`, `never`, `void`
- [ ] Type annotations em variáveis, parâmetros, retorno
- [ ] Type inference — quando omitir anotações
- [ ] Literal types: `"admin" | "user"`
- [ ] Union types: `string | number`
- [ ] Intersection types: `A & B`
- [ ] Tuple types: `[string, number]`
- [ ] Array: `string[]` ou `Array<string>`
- [ ] `as const`, readonly arrays

### Interfaces & Type Aliases
- [ ] `interface` vs `type` — quando usar cada um
- [ ] Extending interfaces: `interface B extends A`
- [ ] Declaration merging (interfaces)
- [ ] Index signatures: `{ [key: string]: number }`
- [ ] Readonly properties
- [ ] Optional properties `?`

### Enums
- [ ] `enum`, `const enum`
- [ ] String enums
- [ ] Por que evitar enums numéricos em alguns casos

---

## Fase 7 — Tipos Avançados TypeScript

### Generics
- [ ] Funções genéricas `<T>`
- [ ] Interfaces e classes genéricas
- [ ] Constraints: `<T extends object>`
- [ ] Default type params: `<T = string>`
- [ ] Multiple type params: `<K, V>`
- [ ] Inferência com generics

### Utility Types
- [ ] `Partial<T>`, `Required<T>`, `Readonly<T>`
- [ ] `Pick<T, K>`, `Omit<T, K>`
- [ ] `Record<K, V>`
- [ ] `Exclude<T, U>`, `Extract<T, U>`
- [ ] `NonNullable<T>`
- [ ] `ReturnType<T>`, `Parameters<T>`, `ConstructorParameters<T>`
- [ ] `InstanceType<T>`
- [ ] `Awaited<T>`

### Mapped Types
- [ ] `{ [K in keyof T]: ... }`
- [ ] Modificadores: `+`, `-`, `readonly`, `?`
- [ ] Remapping com `as`

### Conditional Types
- [ ] `T extends U ? X : Y`
- [ ] `infer` keyword
- [ ] Distributive conditional types
- [ ] Casos de uso avançados

### Template Literal Types
- [ ] `` `${string}Event` ``
- [ ] Combinações com `Uppercase`, `Lowercase`, `Capitalize`, `Uncapitalize`
- [ ] Key remapping com template literals

### Discriminated Unions
- [ ] Union com discriminant property
- [ ] Exhaustiveness checking com `never`

---

## Fase 8 — TypeScript OOP & Patterns

### Classes em TypeScript
- [ ] `public`, `private`, `protected`, `readonly`
- [ ] Parameter properties: `constructor(private name: string)`
- [ ] `abstract` classes e métodos
- [ ] Implements múltiplos: `class A implements B, C`
- [ ] Override methods

### Decorators (Stage 3)
- [ ] Class decorators
- [ ] Method decorators
- [ ] Property decorators
- [ ] Parameter decorators
- [ ] Metadata reflection

### Module Augmentation
- [ ] Declaration merging para libs externas
- [ ] Augmenting global types

---

## Fase 9 — Node.js & Runtime

### Node.js Core
- [ ] `fs` module (sync, async, streams)
- [ ] `path` module
- [ ] `os` module
- [ ] `crypto` module
- [ ] `http`/`https` modules
- [ ] `EventEmitter`
- [ ] Streams: `Readable`, `Writable`, `Transform`, `pipeline`
- [ ] `Buffer`
- [ ] `process` — env, args, exit, signals
- [ ] Worker Threads

### Node.js com TypeScript
- [ ] `@types/node`
- [ ] `tsx` ou `ts-node` para desenvolvimento
- [ ] Bundling para produção

### Runtimes Alternativos
- [ ] **Deno** — seguro por padrão, TS nativo
- [ ] **Bun** — ultrarrápido, compatível com npm

---

## Fase 10 — Testes

- [ ] **Vitest** — ultrarrápido, compatível com Jest API
- [ ] **Jest** + `ts-jest`
- [ ] **Testing Library** — testes de UI
- [ ] **Playwright** / **Cypress** — e2e
- [ ] **MSW (Mock Service Worker)** — mock de APIs
- [ ] `vi.mock()`, `vi.spyOn()`
- [ ] Type testing com `expectTypeOf`

---

## Fase 11 — Ecossistema Frontend

### Frameworks
- [ ] **React** com TypeScript — props, state, hooks tipados
- [ ] **Next.js 15** — App Router, Server Components
- [ ] **Vue 3** com `<script setup lang="ts">`
- [ ] **Nuxt 3**
- [ ] **Svelte 5** / **SvelteKit**

### Validação & Schemas
- [ ] **Zod** — validação runtime + inferência de tipos
- [ ] **Valibot** — alternativa leve
- [ ] **Yup**

### State Management
- [ ] **Zustand** — simples e tipado
- [ ] **Jotai** — atomic
- [ ] **TanStack Query** — server state
- [ ] **Redux Toolkit** com TypeScript

---

## Fase 12 — Qualidade & DX

- [ ] **ESLint** com `@typescript-eslint`
- [ ] **Prettier**
- [ ] **Husky** + lint-staged
- [ ] **Changesets** — gerenciamento de versões
- [ ] **typedoc** — documentação automática
- [ ] **tsd** — type testing
- [ ] **publint** — validação de pacotes npm

---

## Recursos Recomendados

| Recurso | Tipo |
|---|---|
| JavaScript: The Good Parts | 📖 Livro |
| You Don't Know JS (série) | 📖 Livro |
| TypeScript Deep Dive (Basarat) | 📖 Livro online |
| [typescriptlang.org/docs](https://www.typescriptlang.org/docs/) | 🌐 Docs oficiais |
| [tc39.es](https://tc39.es) | 📄 Propostas JS |
| Matt Pocock (Total TypeScript) | 🎥 Cursos |
| executeprogram.com | 🌐 Prática interativa |

---

*Última atualização: 2025 — ES2024 + TypeScript 5.x*
