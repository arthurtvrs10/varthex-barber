# Semana 08 — Comissão e fechamento diário

**Período:** 24/08/2026 a 28/08/2026  
**Entrega da semana:** Regra de comissão simples, geração após atendimento concluído, cards do dia e fechamento diário.

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
7. Registrar dúvidas e erros em `docs/diario/semana-08.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Regra de comissão simples, geração após atendimento concluído, cards do dia e fechamento diário.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Atendimento concluído gera comissão.
- Dashboard mostra valores do dia.
- Comissão pode variar por barbeiro.
- Fechamento diário soma serviços e produtos quando existirem.
- Comissão não é duplicada se concluir o mesmo atendimento duas vezes.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Diferença entre faturamento bruto, comissão e líquido estimado.
- Percentual versus valor fixo.
- Quando gerar comissão.
- Como evitar duplicidade.
- Como calcular período diário.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Adicionar comissão padrão por barbeiro.
2. Criar entidade Commission.
3. Gerar comissão ao concluir atendimento.
4. Criar endpoint de fechamento diário.
5. Criar cards simples no frontend.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Estudar regra de comissão. |
| Terça | Modelar Commission. |
| Quarta | Integrar com conclusão de atendimento. |
| Quinta | Criar fechamento diário. |
| Sexta | Testar valores e documentar exemplos. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| BigDecimal Java | <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigDecimal.html> | Use BigDecimal para dinheiro. |
| Spring Transactions | <https://docs.spring.io/spring-framework/reference/data-access/transaction/declarative.html> | Use @Transactional ao concluir atendimento. |
| PostgreSQL Aggregate Functions | <https://www.postgresql.org/docs/current/functions-aggregate.html> | Veja sum, count e group by. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-08.md
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

## Entidade Commission

```java
@Entity
@Table(name = "commissions")
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(optional = false)
    private Appointment appointment;

    @ManyToOne(optional = false)
    private Barber barber;

    private BigDecimal grossAmount;
    private BigDecimal percentage;
    private BigDecimal commissionAmount;
    private boolean paid;
}
```

## Cálculo de referência

```java
BigDecimal commission = grossAmount
    .multiply(percentage)
    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
```

## Correção importante

Antes de gerar comissão, confira se já existe comissão para o appointment.

```java
if (commissionRepository.existsByAppointmentId(appointmentId)) {
    return;
}
```

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 08"
```
