# Semana 01 — Base do projeto

**Período:** 06/07/2026 a 10/07/2026  
**Entrega:** Repositório, documentação, ambiente local, backend base, frontend base, PostgreSQL, Redis e Docker Compose.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Base do projeto** sem pular o processo de entendimento.

## Critérios de aceite

- Rodar frontend local.
- Rodar backend local.
- Banco PostgreSQL conectado.
- Redis conectado.
- Documentação no GitHub.

## Tarefas da semana

- Criar repositório no GitHub.
- Subir a documentação inicial.
- Criar estrutura do backend em Java + Spring Boot.
- Criar estrutura do frontend em Next.js + TypeScript.
- Configurar Docker Compose.
- Configurar PostgreSQL.
- Configurar Redis.
- Criar .env.example.
- Criar README técnico.

## O que você precisa aprender antes de implementar

- Git, GitHub, commit, branch e push.
- Diferença entre backend, frontend, banco e cache.
- Como Docker Compose sobe vários serviços.
- Como uma API Spring Boot inicia.
- Como uma aplicação Next.js inicia.
- Uso de variáveis de ambiente.

## Documentação oficial para consultar

- [Git — Pro Git Book](https://git-scm.com/book/en/v2)
- [GitHub Docs — Get started](https://docs.github.com/en/get-started)
- [Spring Boot — Documentation Overview](https://docs.spring.io/spring-boot/documentation.html)
- [Next.js — Docs](https://nextjs.org/docs)
- [Docker Compose — Docs](https://docs.docker.com/compose/)
- [Docker Compose File Reference](https://docs.docker.com/reference/compose-file/)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)
- [Redis — Docs](https://redis.io/docs/latest/)

## Guia prático sem código

1. Desenhe a arquitetura: navegador, frontend, backend, PostgreSQL e Redis.
2. Crie a estrutura do repositório antes de programar.
3. Valide cada serviço separadamente.
4. Documente no README como rodar o projeto.
5. Finalize somente quando conseguir desligar e ligar tudo do zero.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-01.md
```

Responda:

- O que esta semana entrega para o produto?
- Quais telas, entidades ou serviços serão impactados?
- Quais regras podem gerar erro?
- Quem pode usar essa funcionalidade?
- Como vou saber que terminei?

## Checklist de aprendizado

- [ ] Entendi o objetivo da semana.
- [ ] Consultei a documentação oficial.
- [ ] Consegui explicar a semana sem olhar código.
- [ ] Desenhei o fluxo principal.
- [ ] Tentei implementar antes de olhar a correção.
- [ ] Registrei meu aprendizado no GitHub.

## Erros comuns

- Começar copiando código sem entender o fluxo.
- Misturar responsabilidade de Controller, Service e Repository.
- Criar tela antes de validar regra no backend.
- Não testar o fluxo completo.
- Não atualizar a documentação.

## O que registrar no GitHub

Ao final, registre:

- resumo do que foi feito;
- decisões tomadas;
- dificuldades;
- comandos úteis;
- pendências para a próxima semana.

---

# Parte 2 — Guia com código para correção

> Use esta parte somente depois de tentar fazer a semana sozinho.

## Estrutura esperada

```txt
varthex-barber/
├── backend/
├── frontend/
├── docs/
│   └── aprendizado/
├── docker-compose.yml
├── .env.example
├── README.md
└── .gitignore
```

## Comandos de verificação

```bash
git init
git add .
git commit -m "docs: inicia documentação e base do projeto"

cp .env.example .env
docker compose up -d --build
docker compose ps
```

## Código ou trecho de referência para correção

```txt
# docker-compose.yml — referência mínima
services:
  postgres:
    image: postgres:16-alpine
    environment:
      POSTGRES_DB: ${POSTGRES_DB}
      POSTGRES_USER: ${POSTGRES_USER}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
    ports:
      - "5432:5432"

  redis:
    image: redis:7-alpine
    ports:
      - "6379:6379"

# .env.example — referência mínima
POSTGRES_DB=varthex_barber
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
DATABASE_URL=jdbc:postgresql://postgres:5432/varthex_barber
REDIS_HOST=redis
REDIS_PORT=6379
```

## Como validar a correção

- docker compose ps mostra postgres e redis rodando.
- Backend responde em /health.
- Frontend abre no navegador.
- README explica instalação e execução.
