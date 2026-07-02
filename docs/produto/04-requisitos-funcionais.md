# 04 — Requisitos Funcionais

## RF001 — Login

O sistema deve permitir que usuários façam login com e-mail e senha.

## RF002 — Cadastro de barbearia

O SuperAdmin deve conseguir cadastrar uma nova barbearia na plataforma.

## RF003 — Cadastro de Admin

Cada barbearia deve possuir pelo menos um Admin responsável.

## RF004 — Cadastro de barbeiros

O Admin deve poder cadastrar barbeiros vinculados à sua barbearia.

## RF005 — Cadastro de clientes

O Admin, barbeiro autorizado ou o próprio cliente deve poder cadastrar clientes.

## RF006 — Cadastro de serviços

O Admin deve cadastrar serviços, preços, duração e comissão.

## RF007 — Configuração de horário da barbearia

O Admin deve definir dias e horários de funcionamento.

## RF008 — Configuração de horário por barbeiro

O Admin deve definir horários individuais de cada barbeiro.

## RF009 — Criar agendamento

O sistema deve permitir criar agendamentos com cliente, serviço, barbeiro, data e horário.

## RF010 — Verificar disponibilidade

O sistema deve verificar se o horário está livre antes de criar o agendamento.

## RF011 — Impedir conflito de agenda

O sistema não deve permitir dois agendamentos no mesmo horário para o mesmo barbeiro.

## RF012 — Cancelar agendamento

O sistema deve permitir cancelamento de agendamento conforme regras da barbearia.

## RF013 — Reagendar atendimento

O sistema deve permitir alterar data e horário de um atendimento.

## RF014 — Marcar atendimento como concluído

O Admin ou barbeiro autorizado deve marcar atendimento como concluído.

## RF015 — Marcar cliente como faltou

O sistema deve permitir registrar não comparecimento.

## RF016 — Bloquear horário

O Admin ou barbeiro autorizado deve bloquear horários na agenda.

## RF017 — Desbloquear horário

O Admin deve desbloquear horários bloqueados.

## RF018 — Criar agendamento recorrente

O sistema deve permitir criar agendamentos recorrentes.

## RF019 — Pausar agendamento recorrente

O sistema deve permitir pausar uma recorrência.

## RF020 — Cancelar agendamento recorrente

O sistema deve permitir cancelar uma recorrência futura.

## RF021 — Fila de espera

O sistema deve permitir que clientes entrem em uma fila quando não houver horário disponível.

## RF022 — Chamar cliente da fila

O sistema deve notificar cliente da fila quando surgir uma vaga.

## RF023 — Cadastro de produto

O Admin deve cadastrar produtos no estoque.

## RF024 — Entrada de estoque

O Admin deve registrar entrada de produtos.

## RF025 — Venda de produto

O Admin ou barbeiro autorizado deve registrar venda de produtos.

## RF026 — Alerta de estoque baixo

O sistema deve notificar quando um produto estiver abaixo do estoque mínimo.

## RF027 — Comissão por barbeiro

O sistema deve calcular comissão conforme configuração do barbeiro.

## RF028 — Comissão por serviço

O sistema deve permitir comissão diferente por serviço.

## RF029 — Comissão por produto

O sistema deve permitir comissão sobre produto vendido.

## RF030 — Ajuste manual de comissão

O Admin deve poder ajustar comissão manualmente com motivo obrigatório.

## RF031 — Dashboard diário

O sistema deve mostrar faturamento, atendimentos, cancelamentos e comissões do dia.

## RF032 — Dashboard semanal

O sistema deve mostrar resultados acumulados da semana.

## RF033 — Dashboard mensal

O sistema deve mostrar resultados acumulados do mês.

## RF034 — Fechamento diário

O sistema deve gerar ou permitir registrar fechamento diário.

## RF035 — Fechamento semanal

O sistema deve gerar resumo semanal.

## RF036 — Fechamento mensal

O sistema deve gerar resumo mensal.

## RF037 — Programa de fidelidade

O sistema deve permitir pontos, benefícios e resgates.

## RF038 — Planos para clientes

O sistema deve permitir vender planos recorrentes ou manuais para clientes.

## RF039 — Notificações internas

O sistema deve mostrar notificações dentro da aplicação.

## RF040 — Notificações por WhatsApp

O sistema deve enviar mensagens via WhatsApp quando configurado.

## RF041 — Mensagem para barbeiro após agendamento

O barbeiro deve receber aviso quando um cliente agenda com ele.

## RF042 — Mensagem para cliente após agendamento

O cliente deve receber confirmação do agendamento.

## RF043 — Mensagem para dono após agendamento

O dono deve receber aviso de agendamentos importantes ou resumo.

## RF044 — Menu WhatsApp

O sistema deve permitir menu com opções como agendar, pagar, ver produtos, cancelar e falar com atendente.

## RF045 — Mensagem para áudio e ligação

O sistema deve responder com mensagem pré-definida quando o cliente enviar áudio ou tentar ligar, quando suportado pela integração.

## RF046 — Lembrete de corte

O sistema deve enviar lembrete para o cliente retornar após determinado período.

## RF047 — Link de avaliação do Google

O sistema deve enviar link de avaliação após atendimento concluído.

## RF048 — Integração com Google Agenda

O sistema deve permitir sincronizar agendamentos com Google Agenda.

## RF049 — Controle de dispositivos

O sistema deve limitar dispositivos por barbeiro conforme plano.

## RF050 — Monetização por módulos

O sistema deve permitir liberar ou bloquear recursos conforme plano SaaS.
