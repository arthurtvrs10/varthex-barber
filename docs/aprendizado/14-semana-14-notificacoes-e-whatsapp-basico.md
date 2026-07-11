# Semana 14 — Notificações e WhatsApp básico

**Período:** 05/10/2026 a 09/10/2026  
**Entrega da semana:** Notificações internas, templates, fila de mensagens, confirmação, cancelamento e lembrete.

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
7. Registrar dúvidas e erros em `docs/diario/semana-14.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Notificações internas, templates, fila de mensagens, confirmação, cancelamento e lembrete.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Eventos importantes geram notificação.
- Mensagem usa template.
- Envio externo fica desacoplado da regra principal.
- Sistema evita envio duplicado.
- Lembrete pode ser processado em segundo plano.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Diferença entre notificação interna e externa.
- Outbox pattern.
- Template de mensagem.
- Fila/job assíncrono.
- Por que não chamar WhatsApp direto dentro da criação do agendamento.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar Notification.
2. Criar MessageTemplate.
3. Criar NotificationOutbox.
4. Gerar notificação ao criar/cancelar agendamento.
5. Criar job de lembrete.
6. Deixar WhatsApp como integração preparada, sem depender de token real.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Desenhar eventos que disparam mensagens. |
| Terça | Modelar templates. |
| Quarta | Criar outbox. |
| Quinta | Criar job/processamento. |
| Sexta | Testar sem WhatsApp real. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Scheduling | <https://docs.spring.io/spring-framework/reference/integration/scheduling.html> | Veja @Scheduled. |
| Spring Data Redis | <https://docs.spring.io/spring-data/redis/reference/> | Use Redis para fila/cache se necessário. |
| Redis Docs | <https://redis.io/docs/latest/> | Entenda filas e estruturas. |
| WhatsApp Business Platform Docs | <https://developers.facebook.com/docs/whatsapp> | Documentação oficial para integração futura. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-14.md
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

## Outbox de referência

```java
public enum NotificationStatus {
    PENDING,
    SENT,
    FAILED,
    CANCELLED
}
```

```java
@Entity
@Table(name = "notification_outbox")
public class NotificationOutbox {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String channel; // INTERNAL, WHATSAPP, EMAIL
    private String recipient;
    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    private LocalDateTime scheduledTo;
    private LocalDateTime sentAt;
}
```

## Job de correção

```java
@Scheduled(fixedDelay = 30000)
public void processPendingNotifications() {
    // buscar pendentes
    // enviar ou simular envio
    // marcar como SENT ou FAILED
}
```

Regra: primeiro salvar o agendamento, depois criar mensagem pendente. Não misture os dois fluxos.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 14"
```
