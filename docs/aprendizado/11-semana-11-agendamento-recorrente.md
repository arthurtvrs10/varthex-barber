# Semana 11 — Agendamento recorrente

**Período:** 14/09/2026 a 18/09/2026  
**Entrega da semana:** Recorrência semanal, quinzenal e mensal, geração de horários futuros, conflito, pausa e cancelamento.

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
7. Registrar dúvidas e erros em `docs/diario/semana-11.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Recorrência semanal, quinzenal e mensal, geração de horários futuros, conflito, pausa e cancelamento.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Cliente fixo pode ter horários recorrentes.
- Sistema gera próximos horários respeitando conflitos.
- Recorrência pode ser pausada.
- Recorrência pode ser cancelada.
- Conflitos são relatados para o Admin.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Diferença entre regra de recorrência e agendamento gerado.
- Recorrência semanal, quinzenal e mensal.
- Como tratar feriado, bloqueio e conflito.
- Como pausar sem apagar histórico.
- Como evitar geração duplicada.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar entidade RecurringAppointment.
2. Criar regras de frequência.
3. Criar geração de appointments futuros.
4. Criar validação de conflito.
5. Criar pausa/cancelamento.
6. Criar tela para clientes fixos.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Desenhar exemplos de recorrência. |
| Terça | Modelar regra. |
| Quarta | Criar gerador. |
| Quinta | Tratar conflito e pausa. |
| Sexta | Testar semanal, quinzenal e mensal. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Java Time API | <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/package-summary.html> | Use plusWeeks, plusMonths e DayOfWeek. |
| Spring Scheduling | <https://docs.spring.io/spring-framework/reference/integration/scheduling.html> | Veja jobs agendados, se quiser geração automática. |
| Spring Transactions | <https://docs.spring.io/spring-framework/reference/data-access/transaction/declarative.html> | Use transação ao gerar em lote. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-11.md
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

## Frequência de referência

```java
public enum RecurrenceFrequency {
    WEEKLY,
    BIWEEKLY,
    MONTHLY
}
```

## Geração simples

```java
public LocalDate nextDate(LocalDate current, RecurrenceFrequency frequency) {
    return switch (frequency) {
        case WEEKLY -> current.plusWeeks(1);
        case BIWEEKLY -> current.plusWeeks(2);
        case MONTHLY -> current.plusMonths(1);
    };
}
```

## Regra de correção

Não gere agendamentos se houver conflito. Registre o conflito para o Admin decidir manualmente.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 11"
```
