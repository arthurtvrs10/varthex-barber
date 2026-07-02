# 06 — Requisitos Não Funcionais

## Segurança

- Senhas devem ser armazenadas com hash seguro.
- O sistema deve usar autenticação com token.
- O sistema deve ter controle de permissões por perfil.
- Dados de uma barbearia não podem vazar para outra.
- Rotas administrativas devem exigir permissão adequada.
- Ações críticas devem gerar logs.
- Tokens devem expirar.
- Refresh token deve ser protegido.
- Deve haver proteção contra força bruta no login.
- Deve haver controle de dispositivos.

---

## Performance

- A agenda do dia deve carregar rapidamente.
- Consultas de dashboard devem ser otimizadas.
- Relatórios pesados devem ser processados sob demanda ou com cache.
- Mensagens de WhatsApp devem ser enviadas por fila.
- Notificações não devem travar o fluxo principal do sistema.

---

## Escalabilidade

- O sistema deve suportar múltiplas barbearias.
- A arquitetura deve permitir crescimento por módulos.
- Deve ser possível adicionar novas integrações no futuro.
- Deve ser possível adicionar multiunidades.
- O banco de dados deve ter índices em campos de busca e agenda.

---

## Usabilidade

- O fluxo de agendamento deve ser simples.
- O Admin deve conseguir criar agendamento em poucos cliques.
- O barbeiro deve conseguir ver rapidamente sua agenda.
- O cliente deve conseguir agendar pelo celular.
- Cards do dashboard devem ser claros.
- Mensagens de erro devem explicar o problema.

---

## Disponibilidade

- O sistema deve ter backup automático.
- Deve possuir logs de erro.
- Deve ter monitoramento básico.
- Deve ser possível restaurar dados em caso de falha.

---

## Manutenibilidade

- Código organizado por módulos.
- Documentação de rotas.
- Documentação de banco.
- Testes para regras críticas.
- Uso de padrões de commits.
- Separação entre frontend, backend e documentação.

---

## Compatibilidade

- O sistema deve funcionar bem no celular.
- O sistema deve funcionar em navegadores modernos.
- A interface deve ser responsiva.
- Não deve depender de instalação local para o cliente final.

---

## Observabilidade

- Registrar erros de API.
- Registrar falhas de envio de WhatsApp.
- Registrar falhas de integração com Google Agenda.
- Registrar falhas de pagamento.
- Registrar ações críticas do usuário.
