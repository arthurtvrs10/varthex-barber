# 13 — APIs e Contratos

## Padrão de API

O backend Java deve expor uma API REST.

O frontend Next.js deve consumir essa API usando HTTP.

## Padrão de rotas sugerido

```txt
/api/auth
/api/users
/api/barbershops
/api/barbers
/api/clients
/api/services
/api/appointments
/api/schedule-blocks
/api/waitlist
/api/products
/api/commissions
/api/dashboard
/api/notifications
```

## Padrão de resposta

As respostas devem ser previsíveis.

Exemplo conceitual:

```txt
status: sucesso ou erro
mensagem: mensagem para o usuário
dados: conteúdo retornado
erros: lista de erros, quando existir
```

## Documentação com Swagger/OpenAPI

O projeto deve documentar os endpoints com OpenAPI/Swagger.

Isso permite:

- testar endpoints;
- visualizar payloads;
- entender contratos;
- facilitar integração com frontend;
- facilitar manutenção.

## Regras de contrato

- Endpoints protegidos exigem token.
- Endpoints administrativos exigem perfil correto.
- Dados de entrada devem ser validados.
- Erros devem retornar mensagem clara.
- A API não deve expor senha, hash ou dados sensíveis.

