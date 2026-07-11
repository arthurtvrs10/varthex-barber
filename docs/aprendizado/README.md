# Aprendizado semanal — Varthex Barber

Esta pasta contém um arquivo Markdown por semana do projeto **Varthex Barber**.

A stack do projeto está definida como:

- Backend: **Java 21 + Spring Boot**
- Frontend: **Next.js + TypeScript**
- Banco: **PostgreSQL**
- Cache/filas/jobs: **Redis**
- Ambiente local: **Docker Compose**
- Segurança: **Spring Security + JWT**
- Migrations: **Flyway ou migrations SQL controladas**

## Como usar

Abra somente o arquivo da semana que você está fazendo.

Cada arquivo segue a mesma ordem:

1. Guia prático sem código.
2. O que estudar.
3. Onde achar na documentação oficial.
4. O que fazer em ordem.
5. Checklist.
6. Erros comuns.
7. Correção com código/comandos somente no final.

## Regra principal

> Primeiro entender. Depois tentar fazer. Só depois olhar a correção.

## Arquivos

- [01-semana-01-base-do-projeto.md](./01-semana-01-base-do-projeto.md) — Base do projeto
- [02-semana-02-autenticacao.md](./02-semana-02-autenticacao.md) — Autenticação
- [03-semana-03-saas-base.md](./03-semana-03-saas-base.md) — SaaS base
- [04-semana-04-cadastros-principais.md](./04-semana-04-cadastros-principais.md) — Cadastros principais
- [05-semana-05-horarios-e-disponibilidade.md](./05-semana-05-horarios-e-disponibilidade.md) — Horários e disponibilidade
- [06-semana-06-agendamento-completo-basico.md](./06-semana-06-agendamento-completo-basico.md) — Agendamento completo básico
- [07-semana-07-bloqueio-e-desbloqueio-de-horarios.md](./07-semana-07-bloqueio-e-desbloqueio-de-horarios.md) — Bloqueio e desbloqueio de horários
- [08-semana-08-comissao-e-fechamento-diario.md](./08-semana-08-comissao-e-fechamento-diario.md) — Comissão e fechamento diário
- [09-semana-09-dashboard-avancado.md](./09-semana-09-dashboard-avancado.md) — Dashboard avançado
- [10-semana-10-fila-de-espera.md](./10-semana-10-fila-de-espera.md) — Fila de espera
- [11-semana-11-agendamento-recorrente.md](./11-semana-11-agendamento-recorrente.md) — Agendamento recorrente
- [12-semana-12-estoque.md](./12-semana-12-estoque.md) — Estoque
- [13-semana-13-fidelidade-e-planos.md](./13-semana-13-fidelidade-e-planos.md) — Fidelidade e planos
- [14-semana-14-notificacoes-e-whatsapp-basico.md](./14-semana-14-notificacoes-e-whatsapp-basico.md) — Notificações e WhatsApp básico
- [15-semana-15-crm-menu-whatsapp-e-google.md](./15-semana-15-crm-menu-whatsapp-e-google.md) — CRM, menu WhatsApp e Google
- [16-semana-16-monetizacao-saas.md](./16-semana-16-monetizacao-saas.md) — Monetização SaaS
- [17-semana-17-testes-deploy-e-documentacao-final.md](./17-semana-17-testes-deploy-e-documentacao-final.md) — Testes, deploy e documentação final

## Diário de aprendizado

Para cada semana, crie um arquivo em:

```txt
docs/diario/semana-XX.md
```

Use esse diário para registrar:

- dúvidas;
- erros;
- decisões;
- links consultados;
- prints/comandos de teste;
- resumo do que aprendeu.

## Commit sugerido ao adicionar estes arquivos

```bash
git add docs/aprendizado
git commit -m "docs: expande guias semanais de aprendizado"
```
