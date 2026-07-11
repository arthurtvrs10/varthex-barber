# Semana 09 — Dashboard avançado

**Período:** 31/08/2026 a 04/09/2026  
**Entrega:** Cards semanais, mensais e por barbeiro.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Dashboard avançado** sem pular o processo de entendimento.

## Critérios de aceite

- Admin vê dia, semana e mês.

## Tarefas da semana

- Criar cards semanais.
- Criar cards mensais.
- Criar cards por barbeiro.
- Criar ranking.
- Criar filtros por data.

## O que você precisa aprender antes de implementar

- Agrupar por período.
- Filtros por data.
- Ranking.
- Consulta operacional versus analítica.
- Cache com Redis.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)
- [Redis — Docs](https://redis.io/docs/latest/)
- [Next.js — Docs](https://nextjs.org/docs)

## Guia prático sem código

1. Defina métricas do dashboard.
2. Separe dia, semana e mês.
3. Crie filtros claros.
4. Pense em cache para dados pesados.
5. Não misture regra de comissão com dashboard.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-09.md
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
backend/src/main/java/com/varthex/barber/
└── dashboard/
    ├── DashboardController.java
    ├── DashboardService.java
    └── dto/
```

## Comandos de verificação

```bash
curl "http://localhost:8080/dashboard/summary?from=2026-08-31&to=2026-09-04"   -H "Authorization: Bearer SEU_TOKEN"
```

## Código ou trecho de referência para correção

```txt
public record BarberPerformanceResponse(
    UUID barberId,
    String barberName,
    Long totalAppointments,
    BigDecimal revenue,
    BigDecimal commission
) {}

String cacheKey = "dashboard:summary:" + barbershopId + ":" + from + ":" + to;
```

## Como validar a correção

- Dia, semana e mês retornam dados coerentes.
- Ranking ordena barbeiros.
- Filtros alteram resultados.
- Admin não vê outra barbearia.
