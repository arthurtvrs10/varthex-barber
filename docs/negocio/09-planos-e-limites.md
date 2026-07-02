# 09 — Planos e Limites

## Tabela sugerida de planos

| Recurso | Inicial | Profissional | Premium |
|---|---:|---:|---:|
| Unidades | 1 | 1 | 2 ou mais |
| Barbeiros | 2 | 5 | 10+ |
| Dispositivos por barbeiro | 2 | 2 | 3 |
| Agenda | Básica | Completa | Completa |
| Bloqueio de horário | Sim | Sim | Sim |
| Fila de espera | Não | Sim | Sim |
| Agendamento recorrente | Não | Sim | Sim |
| Estoque | Não | Sim | Sim |
| Comissão simples | Sim | Sim | Sim |
| Comissão avançada | Não | Sim | Sim |
| Dashboard diário | Sim | Sim | Sim |
| Dashboard semanal | Não | Sim | Sim |
| Dashboard mensal | Não | Sim | Sim |
| WhatsApp confirmação | Não | Opcional | Sim |
| WhatsApp CRM | Não | Opcional | Sim |
| Menu WhatsApp | Não | Opcional | Sim |
| Fidelidade | Não | Opcional | Sim |
| Planos para clientes | Não | Opcional | Sim |
| Google Agenda | Não | Opcional | Sim |
| Avaliação Google | Não | Sim | Sim |
| Relatórios avançados | Não | Não | Sim |
| Suporte prioritário | Não | Não | Sim |

---

## Limites configuráveis pelo SuperAdmin

Cada plano deve permitir configurar:

- Quantidade de barbeiros.
- Quantidade de clientes.
- Quantidade de agendamentos por mês.
- Quantidade de dispositivos por barbeiro.
- Quantidade de mensagens WhatsApp.
- Quantidade de unidades.
- Módulos disponíveis.
- Permissão para exportar relatórios.

---

## Recursos adicionais pagos

| Recurso extra | Regra sugerida |
|---|---|
| Barbeiro adicional | Cobrança mensal por barbeiro |
| Dispositivo adicional | Cobrança mensal por dispositivo |
| Unidade adicional | Cobrança mensal por unidade |
| WhatsApp CRM | Cobrança mensal fixa |
| Mensagens extras | Cobrança por pacote |
| Menu WhatsApp | Cobrança mensal fixa |
| Google Agenda | Cobrança mensal ou incluso no Premium |
| Fidelidade | Módulo pago |
| Relatórios avançados | Módulo pago |

---

## Regras técnicas de bloqueio

O backend deve validar os limites antes de liberar ações.

Exemplos:

- Antes de cadastrar barbeiro, verificar limite do plano.
- Antes de registrar novo dispositivo, verificar limite do usuário.
- Antes de enviar WhatsApp, verificar se o módulo está ativo.
- Antes de criar campanha, verificar se o plano permite CRM.
- Antes de cadastrar nova unidade, verificar limite de unidades.
