# Semana 10 — Fila de espera

**Período:** 07/09/2026 a 11/09/2026  
**Entrega da semana:** Entrada na fila, visualização pelo Admin, oferta de vaga, aceite, recusa e passagem para o próximo.

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
7. Registrar dúvidas e erros em `docs/diario/semana-10.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Entrada na fila, visualização pelo Admin, oferta de vaga, aceite, recusa e passagem para o próximo.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Vaga cancelada pode ser oferecida para cliente da fila.
- Fila respeita ordem de entrada, salvo prioridade manual do Admin.
- Cliente pode aceitar ou recusar vaga.
- Vaga oferecida tem prazo de resposta.
- Dois clientes não conseguem aceitar a mesma vaga.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Como fila funciona em negócio real.
- Status de fila.
- Prioridade versus ordem.
- Concorrência na aceitação da vaga.
- Como notificar sem duplicar.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar entidade WaitlistEntry.
2. Criar entrada na fila.
3. Criar listagem por data/barbeiro/serviço.
4. Criar oferta de vaga.
5. Criar aceite/recusa.
6. Integrar com cancelamento de agendamento.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Desenhar fluxo da fila. |
| Terça | Modelar entidade e status. |
| Quarta | Criar endpoints. |
| Quinta | Integrar com cancelamento e notificação. |
| Sexta | Testar concorrência e prioridade. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Transactions | <https://docs.spring.io/spring-framework/reference/data-access/transaction/declarative.html> | Use transação no aceite. |
| PostgreSQL Locks | <https://www.postgresql.org/docs/current/explicit-locking.html> | Entenda controle de concorrência. |
| Spring Data Redis | <https://docs.spring.io/spring-data/redis/reference/> | Opcional para expiração de oferta. |
| Redis Expiration | <https://redis.io/docs/latest/commands/expire/> | Veja TTL para oferta temporária. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-10.md
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

## Status da fila

```java
public enum WaitlistStatus {
    WAITING,
    OFFERED,
    ACCEPTED,
    DECLINED,
    EXPIRED,
    CANCELLED
}
```

## Entidade de referência

```java
@Entity
@Table(name = "waitlist_entries")
public class WaitlistEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    private Client client;

    @ManyToOne(optional = false)
    private Barbershop barbershop;

    private UUID preferredBarberId;
    private UUID preferredServiceId;
    private LocalDate desiredDate;
    private String preferredPeriod;

    @Enumerated(EnumType.STRING)
    private WaitlistStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime offeredUntil;
}
```

## Regra de aceite

No aceite, revalide se o horário ainda está disponível antes de criar agendamento.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 10"
```
