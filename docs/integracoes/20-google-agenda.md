# 20 — Google Agenda

## Recomendação principal

A agenda interna do sistema deve ser a fonte oficial.

O Google Agenda deve ser usado como integração complementar.

---

## Por que não depender somente do Google Agenda?

Porque o sistema precisa de regras específicas:

- Comissão.
- Fila de espera.
- Bloqueios.
- Recorrência.
- Status de pagamento.
- Status do atendimento.
- Controle por barbeiro.
- Relatórios financeiros.
- Regras por plano SaaS.

Essas regras não existem naturalmente no Google Agenda.

---

## O que sincronizar

- Agendamentos confirmados.
- Cancelamentos.
- Reagendamentos.
- Bloqueios importantes.

---

## Como deve funcionar

## Criar agendamento

1. Sistema cria agendamento interno.
2. Sistema coloca job na fila.
3. Worker envia para Google Agenda.
4. Sistema salva `google_event_id`.

## Cancelar agendamento

1. Sistema cancela internamente.
2. Job remove ou atualiza evento no Google.

## Reagendar

1. Sistema muda data/hora internamente.
2. Job atualiza Google Agenda.

---

## Campos importantes

Na tabela de agendamentos, adicionar:

- `google_event_id`.
- `google_calendar_sync_status`.
- `google_calendar_last_sync_at`.
- `google_calendar_error`.

---

## Problemas a tratar

- Usuário edita evento direto no Google Agenda.
- Usuário apaga evento no Google Agenda.
- Token Google expira.
- Falha na API do Google.
- Conflito de horários.

---

## Regra recomendada

Se houver conflito entre sistema interno e Google Agenda, o sistema interno vence.

---

## Permissões

O Admin ou barbeiro deve autorizar a integração com a conta Google.

Opções:

- Uma agenda Google da barbearia.
- Uma agenda Google por barbeiro.

Para começar, é mais simples usar uma agenda da barbearia.
