# Varthex Barber — Documentação do Produto

Documentação inicial do **Varthex Barber**, um sistema SaaS para gestão de barbearias.

> Esta versão é **somente documentação**. Não contém backend pronto, frontend pronto nem código de implementação. O objetivo é orientar o desenvolvimento do projeto usando **Java + Spring Boot no backend**, **Next.js no frontend**, **PostgreSQL**, **Redis** e **Docker Compose**.

---

## Objetivo do projeto

Criar uma plataforma SaaS para barbearias com:

- agendamento de cortes e serviços;
- cadastro de clientes, barbeiros, admins e superadmin;
- controle de horários, bloqueios e disponibilidade;
- agendamento recorrente;
- fila de espera;
- estoque de produtos;
- programa de fidelidade;
- planos para clientes;
- CRM via WhatsApp;
- notificações;
- cálculo de comissão;
- dashboard diário, semanal e mensal;
- integração futura com Google Agenda;
- envio de link para avaliação no Google;
- regras de monetização do SaaS;
- controle de dispositivos por barbeiro.

---

## Stack definida

| Camada | Tecnologia |
|---|---|
| Backend | Java 21 + Spring Boot |
| Frontend | Next.js + TypeScript |
| Banco de dados | PostgreSQL |
| Cache / filas | Redis |
| DevOps local | Docker Compose |
| Documentação de API | OpenAPI / Swagger |
| Segurança | Spring Security + JWT |
| Migrations | Flyway ou Liquibase |
| Testes backend | JUnit + Mockito + Testcontainers |
| Testes frontend | Vitest / React Testing Library / Playwright futuramente |

---

## Estrutura da documentação

```txt
varthex-barber/
├── README.md
├── CONTRIBUTING.md
├── docs/
│   ├── 00-indice-geral.md
│   ├── produto/
│   ├── negocio/
│   ├── tecnico/
│   ├── telas/
│   ├── integracoes/
│   ├── roadmap/
│   └── aprendizado/
└── .github/
    └── ISSUE_TEMPLATE/
```

---

## Ordem recomendada de leitura

1. `docs/00-indice-geral.md`
2. `docs/produto/01-visao-geral.md`
3. `docs/produto/02-escopo-do-produto.md`
4. `docs/tecnico/11-arquitetura-tecnica-java.md`
5. `docs/aprendizado/26-guia-semana-1-sem-codigo.md`
6. `docs/aprendizado/27-guia-semana-1-correcao-com-comandos.md`
7. `docs/roadmap/24-cronograma-com-datas.md`

---

## Regra importante deste repositório

Primeiro o projeto será desenvolvido com foco em aprendizado:

1. entender o que será feito;
2. estudar a documentação oficial;
3. montar a estrutura sozinho;
4. só depois comparar com o guia de correção.

Por isso, a documentação da Semana 1 tem duas partes:

- **guia sem código**, para estudar e tentar fazer sozinho;
- **guia de correção**, com comandos e estrutura esperada.

---

## Data base do cronograma

O cronograma começa em **06/07/2026**.
