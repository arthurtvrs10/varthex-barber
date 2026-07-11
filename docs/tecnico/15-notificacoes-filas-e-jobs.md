# 15 — Notificações, Filas e Jobs

## Redis no projeto

O Redis será usado para:

- cache;
- filas de mensagens;
- jobs de lembrete;
- notificações assíncronas;
- controle temporário de sessões ou tokens;
- processamento de tarefas demoradas.

## Exemplos de jobs

- enviar lembrete antes do corte;
- enviar mensagem pós-atendimento;
- enviar link de avaliação Google;
- avisar barbeiro sobre novo agendamento;
- avisar dono sobre fechamento diário;
- alertar estoque baixo;
- lembrar cliente inativo.

## Por que usar fila?

Porque algumas ações não precisam travar a resposta do usuário.

Exemplo:

1. cliente agenda corte;
2. sistema salva o agendamento;
3. resposta volta rápido para o cliente;
4. mensagem WhatsApp entra na fila;
5. job envia a mensagem depois.

## Benefício

- sistema mais rápido;
- menos travamento;
- melhor organização;
- possibilidade de tentar reenviar mensagem se falhar.

