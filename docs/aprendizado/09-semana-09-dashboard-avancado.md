# Semana 09 — Dashboard avançado

**Período:** 31/08/2026 a 04/09/2026  
**Entrega da semana:** Cards semanais, mensais, por barbeiro, ranking e filtros por data.

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
7. Registrar dúvidas e erros em `docs/diario/semana-09.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Cards semanais, mensais, por barbeiro, ranking e filtros por data.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Admin vê dia, semana e mês.
- Cards por barbeiro funcionam.
- Ranking usa dados reais.
- Filtros por data alteram os resultados.
- Consultas respeitam a barbearia atual.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Como agregar dados no banco.
- Diferença entre métrica operacional e financeira.
- Como calcular início/fim de semana e mês.
- Por que dashboards precisam de queries otimizadas.
- Quando usar cache com Redis.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar endpoint `/dashboard/daily`.
2. Criar endpoint `/dashboard/weekly`.
3. Criar endpoint `/dashboard/monthly`.
4. Criar cards por barbeiro.
5. Criar ranking simples.
6. Criar filtros por data no frontend.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Definir métricas. |
| Terça | Criar queries diárias. |
| Quarta | Criar queries semanais/mensais. |
| Quinta | Criar frontend de cards. |
| Sexta | Testar com dados diferentes. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Data JPA Queries | <https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html> | Veja query methods e @Query. |
| PostgreSQL Aggregate Functions | <https://www.postgresql.org/docs/current/functions-aggregate.html> | Use sum, count, avg. |
| PostgreSQL Indexes | <https://www.postgresql.org/docs/current/indexes.html> | Entenda índices para dashboard. |
| Spring Data Redis | <https://docs.spring.io/spring-data/redis/reference/> | Veja cache opcional com Redis. |
| Next.js Data Fetching | <https://nextjs.org/docs/app/getting-started/fetching-data> | Veja como buscar dados para cards. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-09.md
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

## DTO de resposta esperado

```java
public record DashboardSummaryResponse(
    BigDecimal revenue,
    long appointments,
    long cancellations,
    BigDecimal totalCommissions,
    BigDecimal averageTicket
) {}
```

## Query de referência

```java
@Query("""
    select coalesce(sum(a.price), 0)
    from Appointment a
    where a.barbershop.id = :barbershopId
      and a.status = 'COMPLETED'
      and a.startsAt between :start and :end
""")
BigDecimal sumRevenue(UUID barbershopId, LocalDateTime start, LocalDateTime end);
```

## Cálculo de período

```java
LocalDate today = LocalDate.now();
LocalDateTime start = today.atStartOfDay();
LocalDateTime end = today.plusDays(1).atStartOfDay().minusNanos(1);
```

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 09"
```
