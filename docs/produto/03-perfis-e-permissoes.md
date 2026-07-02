# 03 — Perfis e Permissões

## Visão geral

O sistema terá permissões baseadas em perfis. Cada usuário deve acessar apenas aquilo que pertence ao seu nível e à sua barbearia.

---

# 1. SuperAdmin

Usuário responsável pela plataforma SaaS.

## Pode acessar

- Todas as barbearias.
- Todos os planos SaaS.
- Todos os módulos contratados.
- Financeiro da plataforma.
- Controle de dispositivos.
- Logs globais.
- Métricas gerais.

## Permissões

- Criar barbearia.
- Editar barbearia.
- Bloquear barbearia.
- Desbloquear barbearia.
- Criar plano SaaS.
- Editar plano SaaS.
- Definir limites de plano.
- Definir preço de módulos extras.
- Ver faturamento total.
- Ver inadimplência.
- Ativar ou desativar recursos.
- Acessar suporte.

---

# 2. Admin / Dono da Barbearia

Usuário responsável pela gestão completa da barbearia.

## Pode acessar

- Dashboard da própria barbearia.
- Agenda geral.
- Barbeiros.
- Clientes.
- Serviços.
- Estoque.
- Comissões.
- Financeiro.
- Fechamentos.
- CRM.
- Configurações.

## Permissões

- Cadastrar barbeiro.
- Cadastrar cliente.
- Criar serviço.
- Criar agendamento.
- Cancelar agendamento.
- Reagendar atendimento.
- Bloquear horário.
- Desbloquear horário.
- Ajustar comissão.
- Marcar comissão como paga.
- Controlar estoque.
- Vender produto.
- Ver relatórios.
- Criar planos para clientes.
- Criar campanhas.
- Configurar WhatsApp.
- Configurar Google Agenda.
- Configurar link de avaliação.

---

# 3. Barbeiro

Usuário responsável pelos próprios atendimentos.

## Pode acessar

- Minha agenda.
- Meus atendimentos.
- Meus clientes, dependendo da permissão.
- Minhas comissões.
- Produtos vendidos por ele.
- Notificações.

## Permissões configuráveis pelo Admin

O Admin pode decidir se o barbeiro pode:

- Criar agendamento.
- Cancelar agendamento.
- Reagendar atendimento.
- Bloquear horário.
- Ver comissão.
- Ver faturamento.
- Ver dados completos do cliente.
- Registrar venda de produto.
- Confirmar pagamento.
- Marcar atendimento como concluído.
- Marcar cliente como faltou.

---

# 4. Cliente

Usuário final que agenda serviços.

## Pode acessar

- Perfil próprio.
- Agendamentos próprios.
- Histórico próprio.
- Pontos próprios.
- Planos próprios.
- Produtos disponíveis.
- Fila de espera.

## Permissões

- Criar agendamento.
- Cancelar agendamento dentro da regra.
- Reagendar dentro da regra.
- Entrar na fila de espera.
- Ver histórico.
- Ver pontos.
- Comprar plano.
- Avaliar atendimento.

---

# 5. Matriz de permissões

| Funcionalidade | SuperAdmin | Admin | Barbeiro | Cliente |
|---|---:|---:|---:|---:|
| Gerenciar barbearias | Sim | Não | Não | Não |
| Gerenciar planos SaaS | Sim | Não | Não | Não |
| Gerenciar barbeiros | Não | Sim | Não | Não |
| Gerenciar clientes | Não | Sim | Parcial | Não |
| Criar agendamento | Não | Sim | Opcional | Sim |
| Cancelar agendamento | Não | Sim | Opcional | Próprio |
| Reagendar | Não | Sim | Opcional | Próprio |
| Bloquear horário | Não | Sim | Opcional | Não |
| Ver comissão | Não | Sim | Própria | Não |
| Ajustar comissão | Não | Sim | Não | Não |
| Gerenciar estoque | Não | Sim | Opcional | Não |
| Ver dashboard geral | Sim | Sim | Limitado | Não |
| Ver fechamento | Não | Sim | Limitado | Não |
| Configurar WhatsApp | Sim | Sim | Não | Não |
| Receber notificações | Sim | Sim | Sim | Sim |
| Ver programa de fidelidade | Não | Sim | Não | Próprio |
| Comprar plano da barbearia | Não | Não | Não | Sim |
