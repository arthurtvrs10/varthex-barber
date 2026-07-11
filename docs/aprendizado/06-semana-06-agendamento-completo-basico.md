# Semana 06 — Agendamento completo básico

**Período:** 10/08/2026 a 14/08/2026  
**Entrega da semana:** Criar, listar, cancelar, reagendar, concluir e marcar falta em atendimentos.

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
7. Registrar dúvidas e erros em `docs/diario/semana-06.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Criar, listar, cancelar, reagendar, concluir e marcar falta em atendimentos.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Admin consegue operar uma agenda real.
- Sistema impede dois agendamentos no mesmo horário/barbeiro.
- Cancelamento muda status e libera horário.
- Reagendamento valida disponibilidade.
- Conclusão prepara dados para comissão futura.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Ciclo de vida de um agendamento.
- Status de negócio.
- Conflito de horário.
- Transação no banco.
- Idempotência básica em operações sensíveis.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar entidade Appointment.
2. Criar status de agendamento.
3. Criar endpoint de criação.
4. Criar listagem por data e barbeiro.
5. Criar cancelamento, reagendamento e conclusão.
6. Criar tela de agenda funcional.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Mapear status e fluxo. |
| Terça | Modelar Appointment. |
| Quarta | Criar criação/listagem. |
| Quinta | Criar cancelamento/reagendamento/conclusão. |
| Sexta | Testar conflitos e tela de agenda. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Transactions | <https://docs.spring.io/spring-framework/reference/data-access/transaction/declarative.html> | Veja @Transactional. |
| Spring Data JPA Query Methods | <https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html> | Veja consultas por período. |
| PostgreSQL Constraints | <https://www.postgresql.org/docs/current/ddl-constraints.html> | Entenda constraints para evitar inconsistência. |
| Java Time API | <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/package-summary.html> | Use LocalDateTime corretamente. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-06.md
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

## Status esperados

```java
public enum AppointmentStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    RESCHEDULED,
    IN_PROGRESS,
    COMPLETED,
    NO_SHOW
}
```

## Entidade de referência

```java
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    private Barbershop barbershop;

    @ManyToOne(optional = false)
    private Client client;

    @ManyToOne(optional = false)
    private Barber barber;

    @ManyToOne(optional = false)
    private BarberService service;

    private LocalDateTime startsAt;
    private LocalDateTime endsAt;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
}
```

## Regra de conflito

```java
boolean hasConflict = appointmentRepository.existsConflict(
    barberId,
    startsAt,
    endsAt,
    List.of(AppointmentStatus.CONFIRMED, AppointmentStatus.PENDING)
);

if (hasConflict) {
    throw new BusinessException("Horário indisponível para este barbeiro");
}
```

## Validação manual

Tente criar dois agendamentos para o mesmo barbeiro, mesmo dia e horário. O segundo deve falhar.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 06"
```
