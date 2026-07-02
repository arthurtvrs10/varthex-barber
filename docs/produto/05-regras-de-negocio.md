# 05 — Regras de Negócio

## RN001 — Isolamento por barbearia

Cada barbearia deve acessar somente seus próprios dados.

Nenhum Admin, barbeiro ou cliente pode visualizar dados de outra barbearia.

---

## RN002 — Horário único por barbeiro

Um barbeiro não pode ter dois agendamentos no mesmo horário.

---

## RN003 — Duração do serviço

A disponibilidade deve considerar a duração do serviço.

Exemplo:

Se o corte dura 40 minutos e começa às 14h, o horário do barbeiro fica ocupado até 14h40.

---

## RN004 — Intervalo entre atendimentos

A barbearia pode definir intervalo entre atendimentos.

Exemplo:

- Corte: 40 minutos.
- Intervalo: 10 minutos.
- Bloqueio total: 50 minutos.

---

## RN005 — Bloqueio de horário

Horários bloqueados não podem ser agendados.

---

## RN006 — Desbloqueio

Somente Admin ou usuário autorizado pode desbloquear horário.

---

## RN007 — Cancelamento pelo cliente

O cliente só pode cancelar dentro do prazo configurado pela barbearia.

Exemplo:

- Cancelamento permitido até 2 horas antes.
- Depois disso, apenas Admin cancela.

---

## RN008 — Reagendamento

Reagendamento deve respeitar disponibilidade da agenda e prazo mínimo.

---

## RN009 — Cliente que faltou

Quando um cliente não comparece, o sistema deve permitir marcar como `não compareceu`.

Esse dado pode ser usado futuramente para bloqueios ou regras de sinal.

---

## RN010 — Fila de espera

A fila deve respeitar ordem de entrada, salvo alteração manual do Admin.

---

## RN011 — Tempo de resposta da fila

Quando uma vaga abrir, o cliente chamado deve ter um tempo limite para responder.

Se não responder, a vaga passa para o próximo.

---

## RN012 — Comissão após conclusão

A comissão só deve ser gerada quando o atendimento for concluído.

---

## RN013 — Comissão ajustada manualmente

Todo ajuste manual de comissão deve exigir motivo.

---

## RN014 — Comissão paga

Após a comissão ser marcada como paga, alterações devem ser restritas ou registradas em log.

---

## RN015 — Estoque baixo

Quando o estoque do produto for menor ou igual ao estoque mínimo, o sistema deve gerar alerta.

---

## RN016 — Venda reduz estoque

Toda venda de produto deve reduzir quantidade em estoque.

---

## RN017 — Produto zerado

Produto com estoque zerado não deve aparecer como disponível para venda.

---

## RN018 — Pontos de fidelidade

Pontos devem ser gerados somente após atendimento concluído ou compra confirmada.

---

## RN019 — Resgate de pontos

O cliente só pode resgatar benefício se tiver saldo suficiente.

---

## RN020 — Plano de cliente

Benefícios de plano só podem ser usados se o plano estiver ativo.

---

## RN021 — Plano vencido

Plano vencido deve bloquear benefícios automaticamente.

---

## RN022 — WhatsApp promocional

Mensagens promocionais só devem ser enviadas para clientes que autorizaram contato.

---

## RN023 — WhatsApp transacional

Mensagens de confirmação, cancelamento e lembrete são operacionais e podem ser tratadas separadamente das promocionais.

---

## RN024 — Mensagem duplicada

O sistema deve evitar envio duplicado para o mesmo evento.

---

## RN025 — Avaliação Google

O link de avaliação só deve ser enviado após atendimento concluído.

---

## RN026 — Controle de dispositivos

Cada barbeiro pode usar até 2 dispositivos por padrão.

Dispositivo adicional pode ser cobrado.

---

## RN027 — Limites por plano SaaS

Cada barbearia terá recursos conforme o plano contratado.

---

## RN028 — Inadimplência

Barbearia inadimplente pode ter recursos bloqueados, conforme política definida pelo SuperAdmin.

---

## RN029 — Logs obrigatórios

Ações críticas devem gerar logs.

Exemplos:

- Cancelamento.
- Reagendamento.
- Ajuste de comissão.
- Alteração de plano.
- Bloqueio de horário.
- Pagamento de comissão.
- Alteração de permissões.

---

## RN030 — Agenda interna é a fonte oficial

Mesmo com Google Agenda, a agenda interna do sistema deve ser a fonte principal da verdade.
