# Semana 15 — CRM, menu WhatsApp e Google

**Período:** 12/10/2026 a 16/10/2026  
**Entrega:** Menu WhatsApp, avaliação Google e lembrete de corte.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **CRM, menu WhatsApp e Google** sem pular o processo de entendimento.

## Critérios de aceite

- Cliente recebe mensagem pós-atendimento e pode interagir com menu.

## Tarefas da semana

- Criar menu WhatsApp.
- Criar mensagem para áudio/ligação.
- Criar link de avaliação Google.
- Criar lembrete de corte.
- Criar campanha para cliente inativo.
- Avaliar Google Agenda.

## O que você precisa aprender antes de implementar

- CRM operacional.
- Mensagem pós-atendimento.
- Campanha para cliente inativo.
- Menu com opções.
- Link de avaliação Google.
- Integração externa versus recurso interno.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Redis — Docs](https://redis.io/docs/latest/)
- [Next.js — Docs](https://nextjs.org/docs)

## Guia prático sem código

1. Escreva textos antes de automatizar.
2. Defina opções do menu.
3. Crie link de avaliação por barbearia.
4. Defina regra de lembrete de corte.
5. Documente Google Agenda como integração opcional.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-15.md
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
├── crm/
├── whatsapp/
└── google/
```

## Comandos de verificação

```bash
curl -X POST http://localhost:8080/crm/send-review-request   -H "Authorization: Bearer SEU_TOKEN"   -H "Content-Type: application/json"   -d '{"appointmentId":"ID"}' 
```

## Código ou trecho de referência para correção

```txt
String menu = """
Olá! Escolha uma opção:
1. Agendar corte
2. Cancelar horário
3. Reagendar
4. Ver pomadas
5. Ver planos
6. Falar com atendente
""";

String reviewMessage = "Obrigado por cortar com a gente, {{clientName}}! Sua avaliação ajuda muito: {{googleReviewUrl}}";
```

## Como validar a correção

- Mensagem usa link da barbearia.
- Menu é configurável.
- Cliente inativo pode entrar em campanha.
- Google Agenda está documentado como opcional.
