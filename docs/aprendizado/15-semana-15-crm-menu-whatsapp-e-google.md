# Semana 15 — CRM, menu WhatsApp e Google

**Período:** 12/10/2026 a 16/10/2026  
**Entrega da semana:** Menu WhatsApp, mensagem para áudio/ligação, link de avaliação Google, lembrete de corte, campanha para cliente inativo e avaliação do Google Agenda.

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
7. Registrar dúvidas e erros em `docs/diario/semana-15.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Menu WhatsApp, mensagem para áudio/ligação, link de avaliação Google, lembrete de corte, campanha para cliente inativo e avaliação do Google Agenda.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Cliente recebe mensagem pós-atendimento e pode interagir com menu.
- Menu tem opções configuráveis.
- Link de avaliação Google é salvo por barbearia.
- Cliente inativo pode entrar em campanha.
- Google Agenda é avaliado como integração opcional.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- CRM não é só enviar mensagem; é relacionamento.
- Diferença entre mensagem transacional e promocional.
- Menu conversacional simples.
- Consentimento para mensagens promocionais.
- Integração externa opcional versus regra interna obrigatória.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar configuração de menu WhatsApp por barbearia.
2. Criar templates para áudio/ligação.
3. Criar link de avaliação Google por barbearia.
4. Criar lembrete de corte por último atendimento.
5. Criar campanha para clientes inativos.
6. Documentar Google Agenda como opcional.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Escrever textos e fluxos antes de automatizar. |
| Terça | Modelar menu e templates. |
| Quarta | Criar avaliação Google e pós-atendimento. |
| Quinta | Criar lembrete de corte e cliente inativo. |
| Sexta | Documentar integração Google Agenda. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| WhatsApp Business Platform Docs | <https://developers.facebook.com/docs/whatsapp> | Veja requisitos, templates e envio. |
| Google Calendar API | <https://developers.google.com/calendar/api/guides/overview> | Avalie integração com agenda. |
| Google Business Profile Help | <https://support.google.com/business/> | Referência para avaliação/Perfil da Empresa. |
| Spring Scheduling | <https://docs.spring.io/spring-framework/reference/integration/scheduling.html> | Use jobs para lembretes. |
| OWASP Privacy | <https://cheatsheetseries.owasp.org/cheatsheets/Privacy_Cheat_Sheet.html> | Pense em consentimento e dados pessoais. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-15.md
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

## Menu de referência

```java
String menu = """
Olá! Seja bem-vindo à barbearia.
Escolha uma opção:
1. Agendar corte
2. Cancelar horário
3. Reagendar atendimento
4. Ver pomadas e produtos
5. Ver planos
6. Falar com atendente
""";
```

## Template de avaliação

```java
String reviewMessage = "Obrigado por cortar com a gente, {{clientName}}! "
    + "Sua avaliação ajuda muito: {{googleReviewUrl}}";
```

## Regra para cliente inativo

```java
LocalDate limit = LocalDate.now().minusDays(30);
List<Client> inactiveClients = clientRepository.findClientsWithoutAppointmentSince(limit);
```

## Correção importante

Não envie mensagem promocional para cliente sem consentimento. Separe mensagens transacionais de campanhas.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 15"
```
