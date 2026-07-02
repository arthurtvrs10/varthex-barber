# 14 — Segurança

## Objetivo

Garantir que os dados da plataforma, das barbearias, dos barbeiros e dos clientes estejam protegidos.

---

## Autenticação

- Login com e-mail e senha.
- Senha armazenada com hash seguro.
- Access token com expiração curta.
- Refresh token com expiração maior.
- Logout deve invalidar refresh token.

---

## Autorização

A API deve validar permissões em todas as rotas protegidas.

Exemplos:

- Cliente só vê os próprios agendamentos.
- Barbeiro só vê agenda própria, salvo permissão extra.
- Admin só vê dados da própria barbearia.
- SuperAdmin vê dados globais.

---

## Multi-tenant seguro

Toda consulta de dados da barbearia deve filtrar por `barbershop_id`.

Erro comum que deve ser evitado:

- Buscar um agendamento apenas pelo `id` e esquecer de validar a barbearia.

Forma correta:

- Buscar pelo `id` e pelo `barbershop_id` do usuário autenticado.

---

## Controle de dispositivos

Cada login deve registrar ou validar o dispositivo.

Informações possíveis:

- Fingerprint.
- Nome do navegador.
- Sistema operacional.
- Último acesso.
- IP aproximado.

Regra inicial:

- Cada barbeiro pode usar 2 dispositivos.
- Dispositivo extra depende de plano ou pagamento adicional.

---

## Logs de auditoria

Registrar ações críticas:

- Login.
- Falha de login.
- Alteração de senha.
- Criação de barbeiro.
- Alteração de permissão.
- Cancelamento de agendamento.
- Reagendamento.
- Bloqueio de horário.
- Ajuste de comissão.
- Pagamento de comissão.
- Alteração de plano SaaS.
- Bloqueio de barbearia.

---

## Proteção contra abuso

- Limitar tentativas de login.
- Limitar envio de mensagens.
- Bloquear campanhas suspeitas.
- Validar permissões de WhatsApp.
- Evitar spam de notificações.

---

## Dados sensíveis

Dados que precisam de cuidado:

- Nome do cliente.
- Telefone.
- E-mail.
- Histórico de atendimento.
- Dados financeiros.
- Comissões.
- Assinaturas.

---

## Backups

- Backup diário do banco.
- Backup antes de grandes alterações.
- Teste de restauração periodicamente.

---

## Recomendações técnicas

- Usar HTTPS em produção.
- Nunca salvar senha pura.
- Nunca expor token em logs.
- Usar variáveis de ambiente.
- Usar validação de entrada com DTO/Zod/class-validator.
- Usar CORS restrito em produção.
- Usar rate limit em login e endpoints sensíveis.
