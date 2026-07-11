# Semana 08 — Comissão e fechamento diário

**Período:** 24/08/2026 a 28/08/2026  
**Entrega:** Comissão simples, cards do dia e fechamento diário.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Comissão e fechamento diário** sem pular o processo de entendimento.

## Critérios de aceite

- Atendimento concluído gera comissão.
- Dashboard mostra valores do dia.

## Tarefas da semana

- Criar regra de comissão simples.
- Gerar comissão após conclusão.
- Criar tela de comissão.
- Criar fechamento diário.
- Criar cards do dia.

## O que você precisa aprender antes de implementar

- Faturamento bruto e comissão.
- Comissão percentual e fixa.
- Momento de gerar comissão.
- Fechamento diário.
- Evitar comissão duplicada.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)

## Guia prático sem código

1. Defina comissão padrão por barbeiro.
2. Decida se comissão usa valor do serviço ou pago.
3. Gere comissão apenas ao concluir atendimento.
4. Planeje cards do dia.
5. Separe comissão de dashboard.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-08.md
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
├── commissions/
└── dashboard/
```

## Comandos de verificação

```bash
curl http://localhost:8080/dashboard/daily?date=2026-08-24   -H "Authorization: Bearer SEU_TOKEN"
```

## Código ou trecho de referência para correção

```txt
BigDecimal commissionValue = servicePrice
    .multiply(commissionPercentage)
    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

public record DailyDashboardResponse(
    BigDecimal grossRevenue,
    BigDecimal totalCommissions,
    Long completedAppointments,
    BigDecimal averageTicket
) {}
```

## Como validar a correção

- Concluir atendimento gera comissão.
- Não duplica comissão.
- Dashboard soma somente o dia.
- Comissão aparece por barbeiro.
