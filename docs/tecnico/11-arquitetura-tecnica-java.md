# 11 — Arquitetura Técnica com Java

## Decisão principal

O backend do Varthex Barber será desenvolvido em **Java + Spring Boot**.

O objetivo dessa decisão é aproximar o projeto de uma arquitetura usada em empresas, com organização por camadas, segurança forte, boas práticas, testes e separação clara de responsabilidades.

## Stack técnica

| Parte | Tecnologia |
|---|---|
| Backend | Java 21 + Spring Boot |
| Segurança | Spring Security + JWT |
| Banco | PostgreSQL |
| Cache / filas | Redis |
| Migrations | Flyway ou Liquibase |
| Documentação de API | OpenAPI / Swagger |
| Testes | JUnit, Mockito e Testcontainers |
| Frontend | Next.js + TypeScript |
| Infra local | Docker Compose |

## Arquitetura geral

```txt
Cliente / Navegador
        ↓
Frontend Next.js
        ↓ HTTP/REST
Backend Java Spring Boot
        ↓
PostgreSQL
        ↓
Redis para cache, filas e jobs
```

## Camadas do backend Java

O backend deve ser dividido em camadas:

```txt
Controller → Service → Repository → Database
```

### Controller

Recebe a requisição HTTP.

Responsabilidades:

- mapear endpoints;
- receber dados da requisição;
- chamar o service;
- retornar resposta.

### Service

Contém a regra de negócio.

Responsabilidades:

- validar regras importantes;
- impedir conflito de agendamento;
- calcular comissão;
- verificar permissões;
- organizar fluxos.

### Repository

Comunica com o banco.

Responsabilidades:

- buscar dados;
- salvar dados;
- consultar por filtros;
- trabalhar com entidades.

### DTO

Transporta dados entre API e backend.

Responsabilidades:

- definir entrada de dados;
- definir saída de dados;
- aplicar validações.

### Entity

Representa tabelas do banco.

Responsabilidades:

- mapear dados persistidos;
- definir relacionamentos.

## Organização por domínio

A organização deve ser feita por módulos de negócio:

```txt
backend/
└── src/main/java/com/varthex/barber/
    ├── auth/
    ├── users/
    ├── barbershops/
    ├── barbers/
    ├── clients/
    ├── services/
    ├── appointments/
    ├── schedules/
    ├── commissions/
    ├── products/
    ├── dashboard/
    ├── notifications/
    ├── common/
    └── config/
```

Esta estrutura é apenas referência documental. O código deve ser criado durante o desenvolvimento, etapa por etapa.

## Por que Java faz sentido neste projeto?

Java combina com esse sistema porque o projeto tem muitas regras de negócio:

- agenda;
- permissões;
- comissão;
- financeiro;
- recorrência;
- fila de espera;
- SaaS;
- integração;
- relatórios;
- segurança.

Essas partes exigem organização, tipagem, testes e arquitetura clara.

