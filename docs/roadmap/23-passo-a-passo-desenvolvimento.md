# 23 — Passo a Passo de Desenvolvimento

## Data inicial

O desenvolvimento começa em **06/07/2026**.

Este roteiro foi criado para desenvolvimento progressivo, evitando tentar construir tudo de uma vez.

---

# Etapa 1 — Preparação do projeto

## Objetivo

Criar a base do repositório, ambiente e arquitetura.

## Fazer

- Criar repositório no GitHub.
- Criar estrutura de pastas.
- Criar backend.
- Criar frontend.
- Configurar Docker.
- Configurar PostgreSQL.
- Configurar Redis.
- Configurar variáveis de ambiente.
- Criar README principal.
- Criar padrão de commits.

## Entrega esperada

Projeto rodando localmente com frontend, backend, banco e Redis.

---

# Etapa 2 — Autenticação e usuários

## Objetivo

Permitir login e controle de perfil.

## Fazer

- Criar tabela de usuários.
- Criar login.
- Criar cadastro inicial.
- Criar JWT.
- Criar refresh token.
- Criar permissões por perfil.
- Criar middleware/guard de autenticação.
- Criar tela de login.

## Entrega esperada

Usuário consegue entrar no sistema e acessar área conforme perfil.

---

# Etapa 3 — SaaS base e barbearia

## Objetivo

Permitir que o sistema suporte múltiplas barbearias.

## Fazer

- Criar tabela de barbearias.
- Relacionar usuário com barbearia.
- Criar SuperAdmin.
- Criar Admin da barbearia.
- Criar isolamento por `barbershop_id`.
- Criar tela de cadastro de barbearia.
- Criar tela de listagem para SuperAdmin.

## Entrega esperada

SuperAdmin consegue criar uma barbearia e Admin consegue acessar somente os dados dela.

---

# Etapa 4 — Barbeiros, clientes e serviços

## Objetivo

Cadastrar os dados necessários para agendar.

## Fazer

- CRUD de barbeiros.
- CRUD de clientes.
- CRUD de serviços.
- Definir duração do serviço.
- Definir preço.
- Definir comissão inicial.
- Criar telas correspondentes.

## Entrega esperada

Admin consegue cadastrar barbeiros, clientes e serviços.

---

# Etapa 5 — Horários e disponibilidade

## Objetivo

Criar a lógica de horários livres.

## Fazer

- Configurar horário da barbearia.
- Configurar horário por barbeiro.
- Criar folgas.
- Criar intervalos.
- Criar função de disponibilidade.
- Considerar duração do serviço.
- Impedir conflitos.

## Entrega esperada

Sistema consegue mostrar horários disponíveis para um serviço e barbeiro.

---

# Etapa 6 — Agendamento

## Objetivo

Criar o fluxo principal do sistema.

## Fazer

- Criar agendamento.
- Listar agendamentos.
- Cancelar.
- Reagendar.
- Confirmar.
- Concluir atendimento.
- Marcar falta.
- Criar agenda visual.

## Entrega esperada

Sistema permite operar a agenda real da barbearia.

---

# Etapa 7 — Bloqueio e desbloqueio de horários

## Objetivo

Permitir controle de indisponibilidade.

## Fazer

- Criar bloqueio por barbeiro.
- Criar bloqueio geral.
- Bloquear dia inteiro.
- Desbloquear horário.
- Registrar motivo.
- Mostrar bloqueios na agenda.

## Entrega esperada

Admin consegue bloquear e desbloquear horários.

---

# Etapa 8 — Comissão e fechamento diário

## Objetivo

Calcular ganhos dos barbeiros e fechamento básico.

## Fazer

- Calcular comissão após atendimento concluído.
- Criar comissão por barbeiro.
- Criar comissão percentual.
- Criar comissão fixa.
- Criar tela de comissões.
- Criar fechamento diário.
- Criar cards do dia.

## Entrega esperada

Admin vê faturamento e comissão do dia.

---

# Etapa 9 — Dashboard semanal e mensal

## Objetivo

Dar visão gerencial ao dono.

## Fazer

- Criar cards semanais.
- Criar cards mensais.
- Criar ranking de barbeiros.
- Criar serviços mais vendidos.
- Criar produtos mais vendidos futuramente.
- Criar filtros por data.

## Entrega esperada

Dono acompanha desempenho da barbearia.

---

# Etapa 10 — Fila de espera

## Objetivo

Gerenciar dias intensos.

## Fazer

- Cliente entra na fila.
- Admin vê fila.
- Sistema chama cliente quando vaga abre.
- Cliente aceita ou recusa.
- Sistema passa para o próximo.

## Entrega esperada

Fila de espera funcional.

---

# Etapa 11 — Agendamento recorrente

## Objetivo

Automatizar clientes fixos.

## Fazer

- Criar recorrência semanal.
- Criar recorrência quinzenal.
- Criar recorrência mensal.
- Verificar conflitos.
- Pausar recorrência.
- Cancelar recorrência.

## Entrega esperada

Admin consegue criar clientes recorrentes.

---

# Etapa 12 — Estoque

## Objetivo

Controlar produtos da barbearia.

## Fazer

- CRUD de produtos.
- Entrada de estoque.
- Venda de produto.
- Estoque mínimo.
- Alerta de estoque baixo.
- Comissão por produto.

## Entrega esperada

Estoque básico funcionando.

---

# Etapa 13 — Fidelidade e planos para clientes

## Objetivo

Aumentar retenção de clientes.

## Fazer

- Criar pontos.
- Criar regras de pontos.
- Criar resgate.
- Criar planos mensais.
- Controlar uso de plano.
- Mostrar pontos para cliente.

## Entrega esperada

Clientes acumulam pontos e podem ter planos.

---

# Etapa 14 — Notificações e WhatsApp básico

## Objetivo

Automatizar comunicação inicial.

## Fazer

- Criar sistema de notificações internas.
- Criar templates de WhatsApp.
- Enviar confirmação de agendamento.
- Enviar cancelamento.
- Enviar reagendamento.
- Enviar lembrete básico.

## Entrega esperada

Cliente, barbeiro e dono recebem mensagens importantes.

---

# Etapa 15 — CRM, menu WhatsApp e Google avaliações

## Objetivo

Criar automações comerciais.

## Fazer

- Menu WhatsApp.
- Mensagem para áudio/ligação.
- Campanhas.
- Lembrete de corte.
- Link de avaliação Google.
- Cliente inativo.

## Entrega esperada

Sistema começa a funcionar como CRM.

---

# Etapa 16 — Monetização SaaS e controle de dispositivos

## Objetivo

Preparar o produto para venda.

## Fazer

- Criar planos SaaS.
- Criar limites por plano.
- Criar módulos pagos.
- Criar controle de dispositivos.
- Criar bloqueio por inadimplência.
- Criar tela do SuperAdmin.

## Entrega esperada

Sistema pode ser vendido para barbearias.

---

# Etapa 17 — Testes, revisão e deploy

## Objetivo

Preparar para produção.

## Fazer

- Testar todos os fluxos.
- Corrigir bugs.
- Revisar permissões.
- Revisar segurança.
- Criar backup.
- Configurar deploy.
- Criar documentação de instalação.
- Criar documentação de uso.

## Entrega esperada

Primeira versão pronta para uso real ou piloto.
