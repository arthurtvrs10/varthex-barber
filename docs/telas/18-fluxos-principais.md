# 18 — Fluxos Principais

## Fluxo de agendamento

1. Cliente escolhe barbearia.
2. Cliente escolhe serviço.
3. Cliente escolhe barbeiro.
4. Sistema mostra horários disponíveis.
5. Cliente escolhe horário.
6. Sistema confirma o agendamento.
7. Cliente, barbeiro e dono podem receber notificação.

## Fluxo de bloqueio de horário

1. Admin escolhe barbeiro.
2. Admin escolhe data e horário.
3. Admin informa motivo.
4. Sistema cria bloqueio.
5. Horário deixa de aparecer como disponível.

## Fluxo de comissão

1. Atendimento é concluído.
2. Sistema identifica valor do serviço.
3. Sistema identifica regra de comissão.
4. Sistema calcula valor da comissão.
5. Comissão aparece no dashboard do Admin e do barbeiro.

## Fluxo de fila de espera

1. Cliente tenta agendar em data lotada.
2. Sistema oferece entrada na fila.
3. Cliente informa preferência.
4. Sistema registra posição.
5. Se uma vaga abrir, o cliente é chamado.

