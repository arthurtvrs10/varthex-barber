# Semana 11 — Agendamento recorrente

**Período:** 14/09/2026 a 18/09/2026  
**Entrega:** Recorrência semanal, quinzenal e mensal.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Agendamento recorrente** sem pular o processo de entendimento.

## Critérios de aceite

- Cliente fixo pode ter horários recorrentes.

## Tarefas da semana

- Criar recorrência semanal.
- Criar recorrência quinzenal.
- Criar recorrência mensal.
- Criar geração dos horários futuros.
- Verificar conflito.
- Pausar e cancelar recorrência.

## O que você precisa aprender antes de implementar

- Regra de recorrência versus agendamentos gerados.
- Próximas datas.
- Conflito futuro.
- Pausar sem perder histórico.
- Evitar gerar muitos horários.

## Documentação oficial para consultar

- [Java 21 — JDK Documentation](https://docs.oracle.com/en/java/javase/21/)
- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)

## Guia prático sem código

1. Defina tipos de recorrência.
2. Decida quantos futuros gerar.
3. Considere feriados, bloqueios e folgas.
4. Crie pausar e cancelar.
5. Marque origem recorrente no agendamento.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-11.md
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
└── recurrence/
    ├── RecurringAppointment.java
    ├── RecurrenceType.java
    └── RecurrenceService.java
```

## Comandos de verificação

```bash
curl -X POST http://localhost:8080/recurrences   -H "Authorization: Bearer SEU_TOKEN"   -H "Content-Type: application/json"   -d '{"clientId":"ID","barberId":"ID","serviceId":"ID","startDate":"2026-09-14","time":"18:00","type":"BIWEEKLY"}' 
```

## Código ou trecho de referência para correção

```txt
public enum RecurrenceType {
    WEEKLY,
    BIWEEKLY,
    MONTHLY
}

LocalDate nextDate = switch (type) {
    case WEEKLY -> current.plusWeeks(1);
    case BIWEEKLY -> current.plusWeeks(2);
    case MONTHLY -> current.plusMonths(1);
};
```

## Como validar a correção

- Recorrência cria horários futuros.
- Conflitos são avisados.
- Pausar impede novas gerações.
- Cancelar não apaga histórico.
