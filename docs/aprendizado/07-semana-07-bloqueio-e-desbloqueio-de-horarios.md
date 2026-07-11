# Semana 07 — Bloqueio e desbloqueio de horários

**Período:** 17/08/2026 a 21/08/2026  
**Entrega da semana:** Bloquear/desbloquear horário ou dia inteiro com motivo e impacto na disponibilidade.

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
7. Registrar dúvidas e erros em `docs/diario/semana-07.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Bloquear/desbloquear horário ou dia inteiro com motivo e impacto na disponibilidade.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Horário bloqueado não aparece disponível.
- Bloqueio tem motivo e responsável.
- Admin consegue desbloquear.
- Bloqueio de dia inteiro remove todos os slots do dia.
- Sistema impede bloqueio conflitante sem tratamento.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Bloqueio manual versus indisponibilidade por agenda.
- Importância do motivo do bloqueio.
- Como registrar quem fez a ação.
- Como aplicar bloqueio na consulta de disponibilidade.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar entidade BlockedTime.
2. Criar endpoint de bloqueio.
3. Criar endpoint de desbloqueio.
4. Aplicar bloqueios no cálculo de disponibilidade.
5. Mostrar bloqueios na tela de agenda.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Desenhar casos de bloqueio. |
| Terça | Modelar BlockedTime. |
| Quarta | Criar endpoints. |
| Quinta | Integrar com disponibilidade. |
| Sexta | Testar bloqueio parcial e dia inteiro. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Data JPA | <https://docs.spring.io/spring-data/jpa/reference/index.html> | Veja queries por intervalo. |
| Java Time API | <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/package-summary.html> | Use LocalDateTime e LocalDate. |
| PostgreSQL Date/Time | <https://www.postgresql.org/docs/current/datatype-datetime.html> | Entenda armazenamento de datas. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-07.md
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

## Entidade de referência

```java
@Entity
@Table(name = "blocked_times")
public class BlockedTime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    private Barbershop barbershop;

    @ManyToOne
    private Barber barber;

    private LocalDateTime startsAt;
    private LocalDateTime endsAt;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private UUID createdBy;
}
```

## Regra esperada

```java
if (slotStart.isBefore(blockedEnd) && slotEnd.isAfter(blockedStart)) {
    // existe sobreposição
    removeSlot(slotStart);
}
```

## Validação manual

1. Bloqueie 14:00 às 15:00.
2. Consulte disponibilidade.
3. O horário 14:00 não deve aparecer.
4. Desbloqueie.
5. Consulte novamente.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 07"
```
