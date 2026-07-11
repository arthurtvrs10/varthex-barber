# Semana 13 — Fidelidade e planos

**Período:** 28/09/2026 a 02/10/2026  
**Entrega da semana:** Pontos, resgates, planos para clientes e controle de uso de plano.

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
7. Registrar dúvidas e erros em `docs/diario/semana-13.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Pontos, resgates, planos para clientes e controle de uso de plano.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Cliente acumula pontos e pode usar benefícios.
- Pontos têm histórico.
- Plano de cliente tem validade.
- Uso de plano é controlado.
- Admin consegue configurar regras simples.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Diferença entre saldo e livro razão/ledger.
- Por que não alterar pontos sem histórico.
- Plano mensal versus fidelidade por pontos.
- Validade e limite de uso.
- Como evitar benefício duplicado.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar LoyaltyTransaction.
2. Criar saldo de pontos por cliente.
3. Criar regra de acúmulo.
4. Criar resgate.
5. Criar ClientPlan.
6. Criar controle de uso do plano.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Desenhar regras de fidelidade. |
| Terça | Modelar pontos como histórico. |
| Quarta | Criar resgate. |
| Quinta | Modelar planos. |
| Sexta | Testar uso e validade. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Data JPA | <https://docs.spring.io/spring-data/jpa/reference/index.html> | Veja relacionamentos e repositories. |
| PostgreSQL Constraints | <https://www.postgresql.org/docs/current/ddl-constraints.html> | Use constraints para saldo e validade. |
| Java Time API | <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/package-summary.html> | Use datas de início e fim. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-13.md
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

## Modelo recomendado

Não salve apenas `points = 100`. Salve histórico.

```java
public enum LoyaltyTransactionType {
    EARN,
    REDEEM,
    EXPIRE,
    MANUAL_ADJUSTMENT
}
```

```java
@Entity
@Table(name = "loyalty_transactions")
public class LoyaltyTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    private Client client;

    private Integer points;

    @Enumerated(EnumType.STRING)
    private LoyaltyTransactionType type;

    private String reason;
    private LocalDateTime createdAt;
}
```

## Cálculo de saldo

Saldo = soma de `EARN` e ajustes positivos menos `REDEEM`, `EXPIRE` e ajustes negativos.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 13"
```
