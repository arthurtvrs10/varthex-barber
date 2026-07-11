# Semana 01 — Base do projeto

**Período:** 06/07/2026 a 10/07/2026  
**Entrega da semana:** Repositório, documentação, backend Spring Boot base, frontend Next.js base, Docker Compose, PostgreSQL, Redis e README técnico.

> Este arquivo é para você abrir somente na semana correspondente. A ideia é aprender antes de copiar. Primeiro leia a Parte 1 inteira, tente fazer sozinho e só depois use a Parte 2 como correção.

---

# Como usar este arquivo

A ordem correta é:

1. Ler o objetivo da semana.
2. Entender o problema de negócio.
3. Estudar os conceitos técnicos indicados.
4. Abrir as documentações oficiais indicadas em **Onde achar para aplicar**.
5. Desenhar o fluxo em papel, Excalidraw, Figma ou Markdown.
6. Tentar implementar sem olhar a correção.
7. Registrar dúvidas e erros em `docs/diario/semana-01.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Repositório, documentação, backend Spring Boot base, frontend Next.js base, Docker Compose, PostgreSQL, Redis e README técnico.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Frontend local rodando em `http://localhost:3000`.
- Backend local rodando em `http://localhost:8080/health`.
- PostgreSQL subindo pelo Docker e aceitando conexão.
- Redis subindo pelo Docker e respondendo `PONG`.
- Documentação inicial publicada no GitHub.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- O que é repositório Git e por que ele existe.
- Como organizar um projeto com `backend/`, `frontend/` e `docs/`.
- Diferença entre backend, frontend, banco de dados e cache.
- O que o Docker Compose faz no ambiente local.
- O que é variável de ambiente e por que `.env` não deve ser versionado.
- Como usar Java 21, Spring Boot e Next.js como base do sistema.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar ou organizar o repositório no GitHub.
2. Criar a pasta `docs/` e colocar a documentação inicial.
3. Criar a base do backend em Java 21 + Spring Boot.
4. Criar a base do frontend em Next.js + TypeScript.
5. Configurar Docker Compose com backend, frontend, PostgreSQL e Redis.
6. Criar `.env.example` com as variáveis necessárias.
7. Criar README técnico explicando como rodar e validar a Semana 1.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Entender Git, GitHub, README e organizar a documentação. |
| Terça | Entender Spring Boot e criar a base do backend. |
| Quarta | Entender Next.js e criar a base visual do frontend. |
| Quinta | Entender Docker Compose, PostgreSQL e Redis. |
| Sexta | Testar tudo, atualizar README e subir no GitHub. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Git Book | <https://git-scm.com/book/en/v2> | Leia Getting Started e Git Basics para entender versionamento. |
| GitHub Docs | <https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-new-repository> | Veja como criar e organizar um repositório. |
| Java 21 Docs | <https://docs.oracle.com/en/java/javase/21/> | Use como referência da linguagem e JDK. |
| Spring Initializr | <https://start.spring.io/> | Use para criar o backend base. |
| Spring Boot Reference | <https://docs.spring.io/spring-boot/reference/index.html> | Leia Getting Started e Web. |
| Next.js Installation | <https://nextjs.org/docs/app/getting-started/installation> | Use para criar o frontend. |
| Docker Compose | <https://docs.docker.com/compose/> | Entenda como subir múltiplos serviços. |
| PostgreSQL Tutorial | <https://www.postgresql.org/docs/current/tutorial.html> | Entenda banco relacional e SQL. |
| Redis Docs | <https://redis.io/docs/latest/> | Entenda Redis e comando PING. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-01.md
```

Responda antes de implementar:

1. O que esta semana entrega para o produto?
2. Quem usa essa funcionalidade?
3. Quais dados precisam existir?
4. Quais regras podem dar erro?
5. Como vou testar sem depender de tela bonita?
6. Que documentação oficial eu consultei?
7. Qual parte ainda ficou confusa?

## 8. Checklist sem código

Marque apenas quando você realmente entendeu ou fez:

- [ ] Entendi o objetivo da semana.
- [ ] Entendi o problema de negócio.
- [ ] Li pelo menos a documentação oficial principal da semana.
- [ ] Desenhei o fluxo antes de codar.
- [ ] Sei explicar quais dados serão criados ou alterados.
- [ ] Sei explicar quais endpoints/telas devem existir.
- [ ] Sei explicar o critério de aceite.
- [ ] Tentei implementar antes de abrir a correção.
- [ ] Registrei dúvidas e erros no diário da semana.

## 9. Erros comuns de iniciante nesta semana

- Começar pelo código sem entender a regra.
- Criar tela antes de validar o backend.
- Misturar regra de negócio dentro do Controller.
- Não validar dados de entrada.
- Não testar caso de erro.
- Não registrar decisões na documentação.
- Copiar a correção antes de tentar fazer sozinho.

## 10. O que registrar no GitHub ao finalizar

No final da semana, atualize o diário com:

- o que foi feito;
- o que funcionou;
- o que deu erro;
- como corrigiu;
- links de documentação usados;
- prints ou comandos de validação;
- pendências para a próxima semana.

---

# Parte 2 — Guia com código/comandos para correção

> Use esta parte somente depois de tentar fazer a semana sozinho. A correção não existe para você copiar no início; ela existe para comparar, corrigir e entender o que faltou.

## Estrutura esperada

```txt
varthex-barber/
├── backend/
├── frontend/
├── docs/
│   └── aprendizado/
├── docker-compose.yml
├── .env.example
├── .gitignore
└── README.md
```

## Comandos de criação para conferir

```bash
mkdir varthex-barber
cd varthex-barber
mkdir docs

# backend Java Spring Boot: gere no Spring Initializr ou pela IDE
# Configuração recomendada no Spring Initializr:
# Project: Maven
# Language: Java
# Spring Boot: versão estável
# Java: 21
# Dependencies: Spring Web, Spring Data JPA, PostgreSQL Driver, Validation, Spring Boot Actuator, Spring Data Redis

# frontend
npx create-next-app@latest frontend --ts --eslint --app --src-dir --tailwind --import-alias "@/*"
```

## `.env.example` de referência

```env
POSTGRES_DB=varthex_barber
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_PORT=5432

SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/varthex_barber
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres

REDIS_HOST=redis
REDIS_PORT=6379

BACKEND_PORT=8080
FRONTEND_PORT=3000
NEXT_PUBLIC_API_URL=http://localhost:8080
```

## `docker-compose.yml` mínimo para correção

```yaml
services:
  postgres:
    image: postgres:16
    container_name: varthex-barber-postgres
    restart: unless-stopped
    env_file:
      - .env
    ports:
      - "5432:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data

  redis:
    image: redis:7
    container_name: varthex-barber-redis
    restart: unless-stopped
    ports:
      - "6379:6379"

  backend:
    build:
      context: ./backend
    container_name: varthex-barber-backend
    restart: unless-stopped
    env_file:
      - .env
    ports:
      - "8080:8080"
    depends_on:
      - postgres
      - redis

  frontend:
    build:
      context: ./frontend
    container_name: varthex-barber-frontend
    restart: unless-stopped
    env_file:
      - .env
    ports:
      - "3000:3000"
    depends_on:
      - backend

volumes:
  postgres-data:
```

## Health check simples em Java para conferir

```java
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public Map<String, Object> health() {
        return Map.of(
            "app", "Varthex Barber API",
            "status", "ok",
            "stack", "Java 21 + Spring Boot"
        );
    }
}
```

## Comandos de validação

```bash
cp .env.example .env
docker compose up -d --build
docker compose ps
curl http://localhost:8080/health
```

Resultado esperado: containers ligados, backend respondendo e frontend abrindo no navegador.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 01"
```
