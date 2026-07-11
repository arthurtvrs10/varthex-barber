# Semana 14 — Notificações e WhatsApp básico

**Período:** 05/10/2026 a 09/10/2026  
**Entrega:** Notificações internas e mensagens de confirmação/lembrete.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Notificações e WhatsApp básico** sem pular o processo de entendimento.

## Critérios de aceite

- Eventos importantes geram notificação.

## Tarefas da semana

- Criar notificações internas.
- Criar templates.
- Criar fila de mensagens.
- Enviar confirmação.
- Enviar cancelamento.
- Enviar lembrete.

## O que você precisa aprender antes de implementar

- Evento de domínio.
- Template de mensagem.
- Fila assíncrona.
- Notificação interna versus WhatsApp real.
- Evitar envio duplicado.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Redis — Docs](https://redis.io/docs/latest/)

## Guia prático sem código

1. Comece por notificações internas.
2. Defina templates.
3. Crie registro de mensagem com status.
4. Use fila para não travar agendamento.
5. Deixe WhatsApp real para quando tiver provedor/token.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-14.md
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
├── notifications/
└── messaging/
```

## Comandos de verificação

```bash
curl http://localhost:8080/notifications   -H "Authorization: Bearer SEU_TOKEN"
```

## Código ou trecho de referência para correção

```txt
public enum MessageStatus {
    PENDING,
    SENT,
    FAILED,
    CANCELED
}

String template = "Olá, {{clientName}}! Seu horário com {{barberName}} foi confirmado para {{date}} às {{time}}.";
```

## Como validar a correção

- Criar agendamento gera notificação.
- Cancelar gera notificação.
- Lembrete pode ser agendado.
- Falha fica registrada.
