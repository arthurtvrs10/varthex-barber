# 19 — WhatsApp CRM

## Objetivo

Usar WhatsApp para melhorar comunicação com cliente, barbeiro e dono da barbearia.

---

# Tipos de mensagens

## Mensagens transacionais

São mensagens ligadas a uma ação do sistema.

Exemplos:

- Confirmação de agendamento.
- Cancelamento.
- Reagendamento.
- Lembrete de horário.
- Confirmação de pagamento.
- Link de avaliação.

## Mensagens promocionais

São mensagens de marketing.

Exemplos:

- Promoção de pomada.
- Campanha de aniversário.
- Cliente inativo.
- Desconto de plano.
- Campanha de retorno.

Mensagens promocionais devem respeitar aceite do cliente.

---

# Mensagens para cliente

## Confirmação de agendamento

```txt
Olá, {{cliente_nome}}! Seu horário foi confirmado.

Serviço: {{servico}}
Barbeiro: {{barbeiro}}
Data: {{data}}
Horário: {{horario}}

Caso precise cancelar ou reagendar, acesse o link:
{{link_agendamento}}
```

## Lembrete de atendimento

```txt
Olá, {{cliente_nome}}! Passando para lembrar do seu horário hoje.

Serviço: {{servico}}
Horário: {{horario}}
Barbeiro: {{barbeiro}}

Esperamos você!
```

## Pós-atendimento com avaliação

```txt
Obrigado pela visita, {{cliente_nome}}!

Sua opinião ajuda muito nossa barbearia.
Avalie nosso atendimento no Google:
{{google_review_link}}
```

## Lembrete de corte

```txt
Olá, {{cliente_nome}}! Já faz um tempo desde seu último corte.

Quer agendar seu próximo horário?

1. Agendar corte
2. Ver horários
3. Falar com a barbearia
```

---

# Mensagens para barbeiro

## Novo agendamento

```txt
Novo agendamento para você.

Cliente: {{cliente_nome}}
Serviço: {{servico}}
Data: {{data}}
Horário: {{horario}}
```

## Cancelamento

```txt
Um horário foi cancelado.

Cliente: {{cliente_nome}}
Data: {{data}}
Horário: {{horario}}
```

## Comissão do dia

```txt
Resumo do dia:

Atendimentos: {{total_atendimentos}}
Faturamento gerado: {{faturamento}}
Comissão estimada: {{comissao}}
```

---

# Mensagens para dono

## Novo agendamento

```txt
Novo agendamento na barbearia.

Cliente: {{cliente_nome}}
Barbeiro: {{barbeiro}}
Serviço: {{servico}}
Data: {{data}}
Horário: {{horario}}
```

## Fechamento diário

```txt
Fechamento do dia:

Faturamento: {{faturamento}}
Atendimentos: {{atendimentos}}
Produtos vendidos: {{produtos}}
Comissões: {{comissoes}}
Cancelamentos: {{cancelamentos}}
```

---

# Menu WhatsApp

Mensagem inicial:

```txt
Olá! Bem-vindo à barbearia.

Escolha uma opção:

1. Agendar corte
2. Ver horários disponíveis
3. Cancelar agendamento
4. Reagendar atendimento
5. Pagar
6. Ver pomadas e produtos
7. Entrar na fila de espera
8. Falar com atendente
9. Ver planos
10. Ver meus pontos
```

---

# Mensagem para áudio e ligação

```txt
No momento não conseguimos atender chamadas ou ouvir áudios por aqui.

Para agilizar seu atendimento, escolha uma das opções:

1. Agendar corte
2. Cancelar horário
3. Reagendar
4. Ver produtos
5. Falar com atendente
```

---

# Observações técnicas

Dependendo da integração escolhida, algumas mensagens podem precisar de aprovação de template.

O sistema deve guardar histórico de envio:

- Destinatário.
- Tipo de mensagem.
- Conteúdo.
- Status.
- Data.
- Erro, se houver.

---

# Provedores possíveis

Opções a avaliar:

- WhatsApp Business Cloud API.
- Z-API.
- Evolution API.
- Twilio WhatsApp.
- WATI.
- Take Blip.

Para começar barato e testar, pode-se avaliar soluções mais simples, mas para produção profissional o ideal é usar API oficial ou provedor confiável.
