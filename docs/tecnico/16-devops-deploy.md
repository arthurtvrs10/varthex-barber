# 16 — DevOps e Deploy

## Ambientes

O projeto deve ter pelo menos três ambientes.

## Desenvolvimento

Ambiente local do desenvolvedor.

Inclui:

- Backend local.
- Frontend local.
- PostgreSQL via Docker.
- Redis via Docker.

## Homologação

Ambiente de testes antes da produção.

Inclui:

- Dados de teste.
- Testes de fluxo.
- Testes de integração.

## Produção

Ambiente usado pelas barbearias reais.

Inclui:

- HTTPS.
- Banco com backup.
- Logs.
- Monitoramento.
- Variáveis seguras.

---

## Docker Compose local

Serviços sugeridos:

```yaml
services:
  postgres:
    image: postgres:16
    environment:
      POSTGRES_USER: barber
      POSTGRES_PASSWORD: barber
      POSTGRES_DB: barber_saas
    ports:
      - "5432:5432"

  redis:
    image: redis:7
    ports:
      - "6379:6379"
```

---

## CI/CD

Pipeline sugerido:

1. Instalar dependências.
2. Rodar lint.
3. Rodar testes.
4. Validar build.
5. Gerar artefato.
6. Fazer deploy.

---

## Variáveis de ambiente

Exemplos:

```env
DATABASE_URL=
REDIS_URL=
JWT_SECRET=
JWT_REFRESH_SECRET=
WHATSAPP_PROVIDER_TOKEN=
GOOGLE_CLIENT_ID=
GOOGLE_CLIENT_SECRET=
PAYMENT_PROVIDER_SECRET=
```

---

## Deploy inicial recomendado

Para começar barato:

- Frontend: Vercel ou VPS.
- Backend: VPS com Docker.
- Banco: PostgreSQL na VPS ou serviço gerenciado.
- Redis: VPS ou serviço gerenciado.

Para produção mais profissional:

- Backend em cloud.
- Banco gerenciado.
- Redis gerenciado.
- Monitoramento.
- Backup automático.

---

## Backup

Política inicial:

- Backup diário do PostgreSQL.
- Manter pelo menos 7 backups recentes.
- Backup antes de migrações grandes.
- Testar restauração mensalmente.

---

## Monitoramento

Monitorar:

- Erros 500.
- Lentidão da API.
- Falhas de envio de WhatsApp.
- Falhas de login.
- Uso de disco.
- Uso de CPU.
- Uso de memória.
- Status do banco.
- Status do Redis.
