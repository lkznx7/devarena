# 🐍 Roadmap Python 3

> Caminho completo para dominar Python 3 — da sintaxe ao desenvolvimento profissional.

---

## 🗺️ Visão Geral

```
Fundamentos → POO → Estruturas de Dados → Programação Funcional
→ Async/Await → Tipagem Estática → Ecossistema → Arquitetura
```

---

## Fase 1 — Fundamentos

### Sintaxe & Tipos Básicos
- [ ] Tipos: `int`, `float`, `complex`, `str`, `bool`, `bytes`
- [ ] Variáveis e atribuição múltipla
- [ ] Operadores aritméticos, lógicos, de comparação, bitwise
- [ ] `None` e falsy values
- [ ] f-strings, `.format()`, `%` formatting
- [ ] `type()`, `isinstance()`, `id()`

### Controle de Fluxo
- [ ] `if / elif / else`
- [ ] Operador ternário: `x if cond else y`
- [ ] `for` loop com `range()`, `enumerate()`, `zip()`
- [ ] `while` loop
- [ ] `break`, `continue`, `pass`
- [ ] `for...else`, `while...else`
- [ ] Walrus operator `:=` (Python 3.8+)

### Funções
- [ ] `def`, parâmetros posicionais, keyword args
- [ ] Valores padrão, `*args`, `**kwargs`
- [ ] Funções aninhadas e closures
- [ ] `lambda`
- [ ] Decorators básicos
- [ ] `functools.wraps`

### Strings
- [ ] Métodos: `split()`, `join()`, `strip()`, `replace()`, `find()`, `startswith()`
- [ ] Slicing: `s[start:end:step]`
- [ ] Multiline strings
- [ ] `re` — regex básico

---

## Fase 2 — Estruturas de Dados

### Built-ins
- [ ] **list**: mutável, ordenada — `append`, `extend`, `pop`, `sort`, `reverse`
- [ ] **tuple**: imutável — `named tuples`
- [ ] **dict**: chave-valor — `keys()`, `values()`, `items()`, `get()`, `setdefault()`
- [ ] **set**: sem duplicatas — `union`, `intersection`, `difference`
- [ ] **frozenset**

### Comprehensions
- [ ] List comprehension: `[x*2 for x in items if x > 0]`
- [ ] Dict comprehension: `{k: v for k, v in pairs}`
- [ ] Set comprehension
- [ ] Generator expression: `(x**2 for x in range(100))`

### Collections module
- [ ] `defaultdict`
- [ ] `Counter`
- [ ] `OrderedDict`
- [ ] `deque`
- [ ] `namedtuple`
- [ ] `ChainMap`

### heapq, bisect, array
- [ ] `heapq.heappush`, `heapq.heappop`
- [ ] `bisect.insort`, `bisect.bisect_left`

---

## Fase 3 — Orientação a Objetos

### Classes
- [ ] `class`, `__init__`, `self`
- [ ] Atributos de instância vs de classe
- [ ] `__str__`, `__repr__`, `__len__`, `__eq__`, `__hash__`
- [ ] `__slots__` para otimização de memória
- [ ] `@classmethod`, `@staticmethod`
- [ ] `@property`, `setter`, `deleter`

### Herança
- [ ] Herança simples e múltipla
- [ ] MRO (Method Resolution Order) — `__mro__`
- [ ] `super()`
- [ ] Mixins

### Dataclasses (Python 3.7+)
- [ ] `@dataclass`, `field()`
- [ ] `frozen=True` para imutabilidade
- [ ] `post_init`
- [ ] Comparação com `NamedTuple`

### Protocolos & ABCs
- [ ] `abc.ABC`, `@abstractmethod`
- [ ] `Protocol` (Python 3.8+) — duck typing estrutural
- [ ] `__iter__`, `__next__` — Iteradores customizados
- [ ] `__enter__`, `__exit__` — Context managers
- [ ] `contextlib.contextmanager`

---

## Fase 4 — Programação Funcional

- [ ] `map()`, `filter()`, `reduce()` (functools)
- [ ] `functools.partial`
- [ ] `functools.lru_cache`, `functools.cache`
- [ ] `itertools`: `chain`, `cycle`, `islice`, `groupby`, `product`, `combinations`, `permutations`
- [ ] `operator` module
- [ ] Imutabilidade e side effects

### Generators
- [ ] `yield`, `yield from`
- [ ] Generator functions vs expressions
- [ ] `send()`, `throw()`, `close()`
- [ ] Generators infinitos
- [ ] Pipeline de generators

---

## Fase 5 — Sistema de Tipos (Typing)

- [ ] `from typing import List, Dict, Tuple, Optional, Union`
- [ ] `Any`, `Callable`, `Type`, `ClassVar`
- [ ] `TypeVar`, `Generic`
- [ ] `TypedDict`
- [ ] `Literal`, `Final`
- [ ] `Protocol` com typing
- [ ] `overload`
- [ ] Python 3.10+: `X | Y` ao invés de `Union[X, Y]`
- [ ] Python 3.12+: `type` keyword
- [ ] **mypy** — verificação estática
- [ ] **pyright** — LSP da Microsoft

---

## Fase 6 — Exceções & Context Managers

- [ ] Hierarquia: `BaseException` → `Exception`
- [ ] `try / except / else / finally`
- [ ] `raise`, `raise ... from`
- [ ] Exceções customizadas
- [ ] `ExceptionGroup` (Python 3.11+)
- [ ] `contextlib.suppress`
- [ ] `contextlib.ExitStack`

---

## Fase 7 — Módulos, Pacotes & Ambiente

### Módulos
- [ ] `import`, `from ... import`, `as`
- [ ] `__name__ == "__main__"`
- [ ] `__all__`
- [ ] Pacotes com `__init__.py`
- [ ] Importações relativas

### Ambiente
- [ ] `venv`, `virtualenv`
- [ ] `pip`, `pip-tools`
- [ ] **Poetry** — gerenciamento moderno
- [ ] **uv** — gerenciador ultrarrápido (Rust)
- [ ] `pyproject.toml`
- [ ] `.env` com `python-dotenv`

---

## Fase 8 — I/O, Arquivos & Serialização

- [ ] `open()`, `read()`, `write()`, `readline()`
- [ ] Context manager com `with open(...)`
- [ ] `pathlib.Path` — API moderna de caminhos
- [ ] `shutil` — operações de arquivos
- [ ] `json` — `dumps`, `loads`, `dump`, `load`
- [ ] `csv` module
- [ ] `pickle` (cuidado com segurança)
- [ ] `tomllib` (Python 3.11+)
- [ ] `struct` — dados binários

---

## Fase 9 — Concorrência & Async

### Threading & Multiprocessing
- [ ] `threading.Thread`, `Lock`, `RLock`, `Event`, `Semaphore`
- [ ] `concurrent.futures.ThreadPoolExecutor`
- [ ] GIL — o que é e implicações
- [ ] `multiprocessing.Process`, `Pool`
- [ ] `concurrent.futures.ProcessPoolExecutor`
- [ ] `multiprocessing.Queue`, `Pipe`, `shared_memory`

### Async/Await (asyncio)
- [ ] `async def`, `await`
- [ ] `asyncio.run()`
- [ ] `asyncio.create_task()`, `asyncio.gather()`
- [ ] `asyncio.Queue`, `asyncio.Lock`
- [ ] `async for`, `async with`
- [ ] `asyncio.timeout()` (Python 3.11+)
- [ ] `TaskGroup` (Python 3.11+)
- [ ] Event loop internals

### Async Ecosystem
- [ ] **aiohttp** — HTTP assíncrono
- [ ] **httpx** — HTTP sync/async
- [ ] **aiofiles** — I/O assíncrono

---

## Fase 10 — Testes

- [ ] **pytest** — fixtures, parametrize, markers
- [ ] `unittest.mock` — `Mock`, `MagicMock`, `patch`
- [ ] **pytest-mock**
- [ ] **pytest-asyncio** — testes async
- [ ] **Hypothesis** — property-based testing
- [ ] **coverage.py** e pytest-cov
- [ ] **tox** — múltiplos ambientes
- [ ] Factory Boy para fixtures de dados

---

## Fase 11 — Qualidade de Código

- [ ] **Ruff** — linter + formatter ultrarrápido
- [ ] **Black** — formatter opinionado
- [ ] **isort** — ordenação de imports
- [ ] **pylint**, **flake8**
- [ ] **pre-commit** hooks
- [ ] **Bandit** — segurança
- [ ] `pyproject.toml` centralizado

---

## Fase 12 — Ecossistema por Domínio

### Web
- [ ] **FastAPI** — async, OpenAPI, Pydantic
- [ ] **Django** — batteries included, ORM, admin
- [ ] **Flask** — microframework

### Data & ML
- [ ] **NumPy** — arrays n-dimensionais
- [ ] **Pandas** — DataFrames
- [ ] **Polars** — DataFrames modernos e rápidos
- [ ] **Matplotlib**, **Seaborn**, **Plotly**
- [ ] **Scikit-learn**
- [ ] **PyTorch**, **TensorFlow**

### DevOps & Automação
- [ ] **Fabric**, **Invoke** — automação de tarefas
- [ ] **Click**, **Typer** — CLIs
- [ ] **Rich** — terminal bonito
- [ ] **Celery** — task queue
- [ ] **Pydantic** — validação de dados

---

## Fase 13 — Performance & Internals

- [ ] `cProfile`, `profile`, `line_profiler`
- [ ] `memory_profiler`
- [ ] **CPython** bytecode (`dis` module)
- [ ] **Cython** — extensões C
- [ ] **Numba** — JIT para arrays
- [ ] **PyPy** — JIT runtime
- [ ] C extensions com `ctypes`, `cffi`
- [ ] `__slots__` e otimização de memória

---

## Recursos Recomendados

| Recurso | Tipo |
|---|---|
| Fluent Python (Luciano Ramalho) | 📖 Livro |
| Python Cookbook (Beazley & Jones) | 📖 Livro |
| [docs.python.org](https://docs.python.org/3/) | 🌐 Docs oficiais |
| Real Python | 🌐 Tutoriais |
| Talk Python To Me | 🎙️ Podcast |
| PyCon Talk recordings | 🎥 Vídeos |

---

*Última atualização: 2025 — baseado no Python 3.12/3.13*
