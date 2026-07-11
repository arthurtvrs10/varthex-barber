# 06 — Requisitos Não Funcionais

## Segurança

- Senhas devem ser criptografadas.
- Rotas protegidas devem exigir autenticação.
- Permissões devem ser validadas no backend.
- Dados de uma barbearia não podem vazar para outra.

## Performance

- A agenda deve carregar rapidamente.
- Dashboards devem usar consultas otimizadas.
- Jobs demorados devem ir para fila.

## Escalabilidade

- O sistema deve suportar várias barbearias.
- O backend deve ser modular.
- Redis deve ser usado para filas e cache.

## Manutenibilidade

- Código futuro deve ser separado por módulos/domínios.
- Regras de negócio devem ficar em services.
- Controllers devem ser finos.
- DTOs devem validar entrada de dados.

## Observabilidade

- O sistema deve ter logs.
- Erros importantes devem ser registrados.
- No futuro, pode usar métricas e tracing.

