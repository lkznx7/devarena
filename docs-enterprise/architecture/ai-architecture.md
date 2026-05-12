# Arquitetura do Sistema de IA - DevArena

## Visão Geral
A integração de Inteligência Artificial no **DevArena** é baseada em uma arquitetura de **Orquestrador e Agentes Especializados (Multi-Agent System)**. Esta abordagem permite que o sistema lide com tarefas complexas — como revisão de código, depuração de testes e mentoria — de forma granular, precisa e eficiente.

O sistema utiliza uma pilha tecnológica híbrida:
*   **Spring AI:** Gerencia a infraestrutura de conexão, configurações de modelos (ChatModels), observabilidade e integração nativa com o ecossistema Spring Boot.
*   **LangChain4j:** Utilizado para a definição dos Agentes, gerenciamento de memória de conversação, encadeamento de raciocínio (Chains) e execução de ferramentas (Function Calling).

---

## 1. O Orquestrador (Orchestrator)
O Orquestrador é o ponto de entrada de todas as requisições de IA. Ele atua como um roteador cognitivo.

*   **Responsabilidade:** Receber a entrada do usuário, identificar a intenção (Intent Recognition) e delegar a tarefa para o agente mais qualificado.
*   **Modelo Sugerido:** Um modelo de alta velocidade e baixo custo (ex: *Gemini 1.5 Flash* ou *GPT-4o-mini*) para manter a latência de triagem baixa.
*   **Processo:**
    1. O `AiController` recebe a requisição.
    2. O Orquestrador analisa o contexto (ex: "Meus testes falharam", "Como posso otimizar este loop?").
    3. O Orquestrador dispara o Agente correspondente.

---

## 2. Agentes Especializados (Workers)
Cada agente é configurado com uma "personalidade" (System Prompt) e um conjunto de ferramentas específicas.

### A. Code Reviewer Agent
*   **Foco:** Qualidade de código, padrões de projeto (SOLID, GoF), legibilidade e manutenibilidade.
*   **Saída:** Sugestões de refatoração e explicações sobre boas práticas.

### B. Test & Debug Agent
*   **Foco:** Analisar falhas de compilação e resultados de testes unitários (JUnit).
*   **Saída:** Explicação amigável do porquê o teste falhou e dicas de como corrigir a lógica.

### C. Security Agent
*   **Foco:** Identificação de vulnerabilidades comuns (OWASP Top 10) no código enviado.
*   **Saída:** Alertas de segurança e recomendações de correção.

### D. Mentor Agent
*   **Foco:** Auxílio didático.
*   **Regra de Ouro:** Nunca fornecer a solução completa. O objetivo é guiar o usuário através de perguntas e dicas progressivas (*Socratic Method*).

---

## 3. Ferramentas (Tools / Function Calling)
Os agentes podem interagir com o sistema através de métodos Java anotados como `@Tool` no LangChain4j:

*   **`ChallengeContextTool`:** Permite que a IA busque a descrição, regras e casos de teste de um desafio específico no banco de dados.
*   **`TestExecutionTool`:** Aciona a execução real dos testes no ambiente de sandbox e retorna os logs para a IA.
*   **`RAGDocumentationTool`:** Consulta uma base de dados vetorial para obter informações técnicas atualizadas sobre bibliotecas ou sintaxes específicas.

---

## 4. Fluxo de Execução Assíncrona
As chamadas de IA são inerentemente lentas. Para garantir uma boa experiência de usuário:

1.  **Requisição:** O cliente faz um POST para o endpoint de IA.
2.  **Aceite:** O servidor responde imediatamente com `202 Accepted` e um ID de rastreamento.
3.  **Processamento:** O Orquestrador inicia o processamento em uma thread separada (`@Async`).
4.  **Feedback:** O progresso e o resultado final são enviados ao frontend via **WebSocket** ou atualizando o status de uma entidade no banco de dados que o frontend monitora.

---

## 5. Próximos Passos de Implementação
1.  Configurar os beans do `ChatModel` via Spring AI.
2.  Definir as interfaces `@AiService` do LangChain4j para cada Agente.
3.  Implementar a classe `AiOrchestrator` para gerenciar o roteamento.
4.  Criar as ferramentas (Tools) para integração com o banco de dados e executor de testes.
