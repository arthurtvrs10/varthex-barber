# 24 — Cronograma com Datas de Entrega

## Data de início

**06/07/2026**

O cronograma abaixo considera entregas semanais, começando na segunda-feira **06/07/2026**.

---

## Cronograma geral

| Semana | Período | Entrega principal | Resultado esperado |
|---:|---|---|---|
| 1 | 06/07/2026 a 10/07/2026 | Preparação do projeto | Repositório, documentação, ambiente, Docker, frontend e backend base |
| 2 | 13/07/2026 a 17/07/2026 | Autenticação | Login, JWT, refresh token, perfis e tela de login |
| 3 | 20/07/2026 a 24/07/2026 | SaaS base | SuperAdmin, barbearias e isolamento por barbearia |
| 4 | 27/07/2026 a 31/07/2026 | Cadastros principais | Barbeiros, clientes e serviços |
| 5 | 03/08/2026 a 07/08/2026 | Horários | Horários da barbearia, horários dos barbeiros e disponibilidade |
| 6 | 10/08/2026 a 14/08/2026 | Agendamento | Criar, listar, cancelar, reagendar e concluir atendimento |
| 7 | 17/08/2026 a 21/08/2026 | Bloqueios | Bloquear e desbloquear horários com motivo |
| 8 | 24/08/2026 a 28/08/2026 | Comissão e fechamento diário | Comissão simples, cards do dia e fechamento diário |
| 9 | 31/08/2026 a 04/09/2026 | Dashboard avançado | Cards semanais, mensais e por barbeiro |
| 10 | 07/09/2026 a 11/09/2026 | Fila de espera | Entrada na fila, oferta de vaga e aceite/recusa |
| 11 | 14/09/2026 a 18/09/2026 | Agendamento recorrente | Recorrência semanal, quinzenal e mensal |
| 12 | 21/09/2026 a 25/09/2026 | Estoque | Produtos, entrada, venda, alerta de estoque baixo |
| 13 | 28/09/2026 a 02/10/2026 | Fidelidade e planos | Pontos, resgates e planos para clientes |
| 14 | 05/10/2026 a 09/10/2026 | Notificações e WhatsApp básico | Notificações internas e mensagens de confirmação/lembrete |
| 15 | 12/10/2026 a 16/10/2026 | CRM e Google | Menu WhatsApp, avaliação Google e lembrete de corte |
| 16 | 19/10/2026 a 23/10/2026 | Monetização SaaS | Planos SaaS, limites, módulos pagos e dispositivos |
| 17 | 26/10/2026 a 30/10/2026 | Testes e deploy | Correções, revisão, deploy e documentação final |

---

# Detalhamento por semana

## Semana 1 — 06/07/2026 a 10/07/2026

## Entrega

Base do projeto.

## Tarefas

- Criar repositório no GitHub.
- Subir esta documentação.
- Criar estrutura do backend.
- Criar estrutura do frontend.
- Configurar Docker Compose.
- Configurar PostgreSQL.
- Configurar Redis.
- Criar `.env.example`.
- Criar README técnico.

## Critério de aceite

- Rodar frontend local.
- Rodar backend local.
- Banco conectado.
- Redis conectado.
- Documentação no GitHub.

---

## Semana 2 — 13/07/2026 a 17/07/2026

## Entrega

Autenticação.

## Tarefas

- Criar tabela de usuários.
- Criar login.
- Criar hash de senha.
- Criar JWT.
- Criar refresh token.
- Criar guards/middlewares.
- Criar tela de login.
- Criar proteção de rotas no frontend.

## Critério de aceite

- Usuário consegue logar.
- Usuário sem token não acessa área protegida.
- Perfil do usuário é identificado.

---

## Semana 3 — 20/07/2026 a 24/07/2026

## Entrega

SaaS base.

## Tarefas

- Criar tabela de barbearias.
- Criar relacionamento usuário/barbearia.
- Criar SuperAdmin.
- Criar Admin da barbearia.
- Criar isolamento por `barbershop_id`.
- Criar tela de listagem de barbearias.
- Criar tela de criação de barbearia.

## Critério de aceite

- SuperAdmin cria barbearia.
- Admin acessa apenas a própria barbearia.

---

## Semana 4 — 27/07/2026 a 31/07/2026

## Entrega

Cadastros principais.

## Tarefas

- CRUD de barbeiros.
- CRUD de clientes.
- CRUD de serviços.
- Tela de barbeiros.
- Tela de clientes.
- Tela de serviços.
- Validações básicas.

## Critério de aceite

- Admin cadastra barbeiro, cliente e serviço.

---

## Semana 5 — 03/08/2026 a 07/08/2026

## Entrega

Horários e disponibilidade.

## Tarefas

- Criar horário da barbearia.
- Criar horário por barbeiro.
- Criar intervalos.
- Criar folgas.
- Criar endpoint de disponibilidade.
- Considerar duração do serviço.

## Critério de aceite

- Sistema mostra horários disponíveis corretamente.

---

## Semana 6 — 10/08/2026 a 14/08/2026

## Entrega

Agendamento completo básico.

## Tarefas

- Criar agendamento.
- Listar por data.
- Listar por barbeiro.
- Cancelar.
- Reagendar.
- Concluir.
- Marcar falta.
- Criar tela de agenda.

## Critério de aceite

- Admin consegue operar uma agenda real.

---

## Semana 7 — 17/08/2026 a 21/08/2026

## Entrega

Bloqueio e desbloqueio.

## Tarefas

- Criar bloqueio de horário.
- Criar bloqueio de dia inteiro.
- Criar desbloqueio.
- Registrar motivo.
- Mostrar bloqueio na agenda.

## Critério de aceite

- Horário bloqueado não aparece disponível.

---

## Semana 8 — 24/08/2026 a 28/08/2026

## Entrega

Comissão e fechamento diário.

## Tarefas

- Criar regra de comissão simples.
- Gerar comissão após conclusão.
- Criar tela de comissão.
- Criar fechamento diário.
- Criar cards do dia.

## Critério de aceite

- Atendimento concluído gera comissão.
- Dashboard mostra valores do dia.

---

## Semana 9 — 31/08/2026 a 04/09/2026

## Entrega

Dashboard avançado.

## Tarefas

- Criar cards semanais.
- Criar cards mensais.
- Criar cards por barbeiro.
- Criar ranking.
- Criar filtros por data.

## Critério de aceite

- Admin vê dia, semana e mês.

---

## Semana 10 — 07/09/2026 a 11/09/2026

## Entrega

Fila de espera.

## Tarefas

- Criar fila.
- Cliente entra na fila.
- Admin visualiza fila.
- Oferecer vaga.
- Aceitar vaga.
- Recusar vaga.
- Passar para próximo.

## Critério de aceite

- Vaga cancelada pode ser oferecida para cliente da fila.

---

## Semana 11 — 14/09/2026 a 18/09/2026

## Entrega

Agendamento recorrente.

## Tarefas

- Criar recorrência semanal.
- Criar recorrência quinzenal.
- Criar recorrência mensal.
- Criar geração dos horários futuros.
- Verificar conflito.
- Pausar e cancelar recorrência.

## Critério de aceite

- Cliente fixo pode ter horários recorrentes.

---

## Semana 12 — 21/09/2026 a 25/09/2026

## Entrega

Estoque.

## Tarefas

- CRUD de produtos.
- Entrada de estoque.
- Venda.
- Saída.
- Estoque mínimo.
- Alerta.
- Comissão sobre produto.

## Critério de aceite

- Venda reduz estoque e pode gerar alerta.

---

## Semana 13 — 28/09/2026 a 02/10/2026

## Entrega

Fidelidade e planos.

## Tarefas

- Criar pontos.
- Criar regras de acúmulo.
- Criar resgate.
- Criar planos para cliente.
- Controlar uso de plano.

## Critério de aceite

- Cliente acumula pontos e pode usar benefícios.

---

## Semana 14 — 05/10/2026 a 09/10/2026

## Entrega

Notificações e WhatsApp básico.

## Tarefas

- Criar notificações internas.
- Criar templates.
- Criar fila de mensagens.
- Enviar confirmação.
- Enviar cancelamento.
- Enviar lembrete.

## Critério de aceite

- Eventos importantes geram notificação.

---

## Semana 15 — 12/10/2026 a 16/10/2026

## Entrega

CRM, menu WhatsApp e Google.

## Tarefas

- Criar menu WhatsApp.
- Criar mensagem para áudio/ligação.
- Criar link de avaliação Google.
- Criar lembrete de corte.
- Criar campanha para cliente inativo.
- Avaliar Google Agenda.

## Critério de aceite

- Cliente recebe mensagem pós-atendimento e pode interagir com menu.

---

## Semana 16 — 19/10/2026 a 23/10/2026

## Entrega

Monetização SaaS.

## Tarefas

- Criar planos SaaS.
- Criar limites por plano.
- Criar módulos pagos.
- Criar controle de dispositivos.
- Criar cobrança manual.
- Criar bloqueio por inadimplência.

## Critério de aceite

- SuperAdmin controla o que cada barbearia pode usar.

---

## Semana 17 — 26/10/2026 a 30/10/2026

## Entrega

Testes e deploy.

## Tarefas

- Testar fluxos principais.
- Testar permissões.
- Testar agenda.
- Testar comissão.
- Testar fila.
- Corrigir bugs.
- Configurar deploy.
- Criar documentação final de uso.

## Critério de aceite

- Sistema pronto para piloto.
