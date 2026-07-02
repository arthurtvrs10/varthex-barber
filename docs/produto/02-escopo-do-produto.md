# 02 — Escopo do Produto

## Módulos incluídos no escopo

O sistema deve ser dividido em módulos para facilitar desenvolvimento, manutenção e monetização.

---

# 1. Módulo de autenticação

Responsável por login, cadastro, sessões, permissões e controle de acesso.

## Deve conter

- Login com e-mail e senha.
- Cadastro de usuário.
- Recuperação de senha.
- Refresh token.
- Logout.
- Controle de perfil.
- Controle de dispositivos.
- Bloqueio de usuário.
- Ativação e desativação de conta.

---

# 2. Módulo de barbearias

Responsável por cadastrar e gerenciar cada barbearia cliente do SaaS.

## Deve conter

- Cadastro de barbearia.
- Nome fantasia.
- CPF ou CNPJ.
- Telefone.
- Endereço.
- Logo.
- Link de avaliação do Google.
- Plano contratado.
- Status da assinatura.
- Configurações de funcionamento.
- Configurações de cancelamento.
- Configurações de comissão.
- Configurações de WhatsApp.

---

# 3. Módulo de usuários

Responsável por gerenciar os usuários internos e externos da plataforma.

## Tipos de usuário

- SuperAdmin.
- Admin/Dono.
- Barbeiro.
- Cliente.
- Atendente, opcional para versão futura.

---

# 4. Módulo de serviços

Responsável pelos serviços vendidos pela barbearia.

## Exemplos

- Corte masculino.
- Barba.
- Corte + barba.
- Sobrancelha.
- Pigmentação.
- Luzes.
- Hidratação.
- Acabamento.

## Campos importantes

- Nome.
- Descrição.
- Duração.
- Preço.
- Status.
- Comissão padrão.
- Categoria.

---

# 5. Módulo de agenda

Responsável por controlar datas, horários, disponibilidade e conflitos.

## Deve conter

- Agenda geral da barbearia.
- Agenda individual por barbeiro.
- Visualização diária.
- Visualização semanal.
- Visualização mensal.
- Filtros por barbeiro.
- Filtros por status.
- Bloqueio de horários.
- Desbloqueio de horários.
- Horários especiais.
- Folgas.
- Intervalos.
- Feriados.

---

# 6. Módulo de agendamento

Responsável pelo processo de criar e gerenciar atendimentos.

## Deve conter

- Criar agendamento.
- Escolher cliente.
- Escolher barbeiro.
- Escolher serviço.
- Escolher data e horário.
- Cancelar.
- Reagendar.
- Confirmar.
- Marcar como concluído.
- Marcar como não compareceu.
- Registrar pagamento.
- Registrar observações.

---

# 7. Módulo de agendamento recorrente

Permite criar agendamentos automáticos em ciclos.

## Exemplos

- Toda sexta às 18h.
- A cada 15 dias.
- Todo sábado de manhã.
- Todo dia 5 do mês.

## Deve conter

- Frequência.
- Data inicial.
- Data final opcional.
- Serviço padrão.
- Barbeiro fixo.
- Cliente fixo.
- Verificação de conflito.
- Pausar recorrência.
- Cancelar recorrência.

---

# 8. Módulo de fila de espera

Usado quando não há horário disponível.

## Deve conter

- Cliente entra na fila.
- Escolhe data desejada.
- Escolhe barbeiro desejado.
- Escolhe período preferido.
- Sistema avisa quando surgir vaga.
- Admin pode chamar manualmente.
- Cliente pode aceitar ou recusar.
- Vaga passa para o próximo se não houver resposta.

---

# 9. Módulo de estoque

Responsável por produtos físicos vendidos ou usados pela barbearia.

## Deve conter

- Cadastro de produto.
- Categoria.
- Preço de custo.
- Preço de venda.
- Quantidade.
- Estoque mínimo.
- Entrada de estoque.
- Saída de estoque.
- Venda de produto.
- Alerta de estoque baixo.
- Relatório de produtos vendidos.

---

# 10. Módulo de comissão

Responsável por calcular ganhos dos barbeiros.

## Deve conter

- Comissão por barbeiro.
- Comissão por serviço.
- Comissão por produto.
- Comissão fixa.
- Comissão percentual.
- Ajuste manual.
- Histórico de ajustes.
- Status de comissão paga ou pendente.
- Relatório diário, semanal e mensal.

---

# 11. Módulo financeiro

Responsável por fechamento e visão de resultados.

## Deve conter

- Fechamento diário.
- Fechamento semanal.
- Fechamento mensal.
- Receita por serviço.
- Receita por produto.
- Receita por plano.
- Valor em dinheiro.
- Valor em Pix.
- Valor em cartão.
- Comissões.
- Ticket médio.
- Cancelamentos.
- Faltas.

---

# 12. Módulo de fidelidade

Responsável por criar benefícios para clientes recorrentes.

## Deve conter

- Pontos por atendimento.
- Pontos por valor gasto.
- Pontos por produto comprado.
- Pontos por indicação.
- Resgate de benefício.
- Histórico de pontos.
- Níveis de fidelidade.
- Campanhas.

---

# 13. Módulo de planos para clientes

Permite que a barbearia venda planos para seus clientes.

## Deve conter

- Cadastro de plano.
- Valor mensal.
- Serviços incluídos.
- Quantidade de usos.
- Validade.
- Benefícios.
- Controle de uso.
- Status de pagamento.
- Renovação manual ou automática.

---

# 14. Módulo de CRM WhatsApp

Responsável por mensagens automáticas e campanhas.

## Deve conter

- Confirmação de agendamento.
- Lembrete antes do atendimento.
- Mensagem para barbeiro.
- Mensagem para dono.
- Mensagem de cancelamento.
- Mensagem de reagendamento.
- Pós-atendimento.
- Link de avaliação do Google.
- Lembrete de retorno.
- Campanha para cliente inativo.
- Campanha de aniversário.
- Menu WhatsApp.

---

# 15. Módulo de notificações

Responsável por notificações internas e externas.

## Canais

- Sistema interno.
- WhatsApp.
- E-mail.
- Push, em versão futura.

---

# 16. Módulo SuperAdmin SaaS

Área para gerenciar todas as barbearias que usam a plataforma.

## Deve conter

- Lista de barbearias.
- Planos SaaS.
- Assinaturas.
- Módulos extras.
- Controle de dispositivos.
- Bloqueio de barbearia.
- Faturamento da plataforma.
- Logs globais.
- Suporte.
