# 05 — Regras de Negócio

## Agenda

- Um barbeiro não pode ter dois atendimentos no mesmo horário.
- Um horário bloqueado não pode aparecer como disponível.
- A duração do serviço deve ser considerada ao gerar disponibilidade.
- Cancelamentos devem registrar motivo.
- Reagendamentos devem manter histórico.

## Comissão

- Comissão deve ser calculada quando o atendimento for concluído.
- Cada barbeiro pode ter uma comissão diferente.
- O Admin pode alterar comissão.
- Ajustes manuais devem registrar motivo.

## Fila de espera

- A fila deve respeitar ordem de entrada.
- Se uma vaga abrir, o cliente pode aceitar ou recusar.
- Se o cliente não responder, a vaga pode ir para o próximo.

## Estoque

- Venda reduz estoque.
- Entrada aumenta estoque.
- Produto abaixo do mínimo gera alerta.

## SaaS

- Cada barbearia deve acessar apenas seus próprios dados.
- Recursos podem ser bloqueados conforme plano.
- Dispositivos adicionais podem ser cobrados.

