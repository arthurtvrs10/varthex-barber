# Semana 06 — Agendamento completo básico

**Período:** 10/08/2026 a 14/08/2026  
**Entrega:** Criar, listar, cancelar, reagendar e concluir atendimento.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Agendamento completo básico** sem pular o processo de entendimento.

## Critérios de aceite

- Admin consegue operar uma agenda real.

## Tarefas da semana

- Criar agendamento.
- Listar por data.
- Listar por barbeiro.
- Cancelar.
- Reagendar.
- Concluir.
- Marcar falta.
- Criar tela de agenda.

## O que você precisa aprender antes de implementar

- Status do agendamento.
- Conflito de horário.
- Transação de banco.
- Cancelar versus reagendar.
- Evitar dois clientes no mesmo horário.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)
- [Next.js — Docs](https://nextjs.org/docs)

## Guia prático sem código

1. Defina status antes de programar.
2. Escreva regras de conflito.
3. Defina quem pode criar agendamento.
4. Planeje mensagens de erro.
5. Depois conecte tela e backend.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-06.md
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
└── appointments/
    ├── Appointment.java
    ├── AppointmentStatus.java
    ├── AppointmentController.java
    ├── AppointmentService.java
    └── AppointmentRepository.java
```

## Comandos de verificação

```bash
curl -X POST http://localhost:8080/appointments   -H "Authorization: Bearer SEU_TOKEN"   -H "Content-Type: application/json"   -d '{"clientId":"ID","barberId":"ID","serviceId":"ID","startAt":"2026-08-10T14:00:00"}' 
```

## Código ou trecho de referência para correção

```txt
public enum AppointmentStatus {
    PENDING,
    CONFIRMED,
    CANCELED,
    RESCHEDULED,
    IN_PROGRESS,
    COMPLETED,
    NO_SHOW
}

boolean existsConflict = repository.existsConflict(
    barberId, startAt, endAt, List.of(CONFIRMED, PENDING, IN_PROGRESS)
);

if (existsConflict) {
    throw new BusinessException("Horário indisponível para este barbeiro.");
}
```

## Como validar a correção

- Agendamento aparece na agenda.
- Dois agendamentos não ocupam o mesmo horário.
- Cancelamento muda status.
- Concluir prepara comissão.
