# 13 — APIs e Contratos

## Padrão geral

A API deve usar REST inicialmente.

Formato padrão de resposta:

```json
{
  "data": {},
  "message": "Operação realizada com sucesso",
  "errors": []
}
```

Formato de erro:

```json
{
  "data": null,
  "message": "Erro ao processar solicitação",
  "errors": [
    {
      "field": "email",
      "message": "E-mail já cadastrado"
    }
  ]
}
```

---

# Auth

## POST /auth/login

Login do usuário.

### Body

```json
{
  "email": "admin@barbearia.com",
  "password": "123456"
}
```

### Resposta

```json
{
  "data": {
    "accessToken": "token",
    "refreshToken": "refresh",
    "user": {
      "id": "uuid",
      "name": "Admin",
      "role": "ADMIN"
    }
  }
}
```

---

# Barbearias

## POST /barbershops

Cria uma barbearia. Apenas SuperAdmin.

## GET /barbershops

Lista barbearias. Apenas SuperAdmin.

## GET /barbershops/:id

Detalha barbearia.

## PATCH /barbershops/:id

Atualiza dados.

## PATCH /barbershops/:id/block

Bloqueia barbearia.

## PATCH /barbershops/:id/unblock

Desbloqueia barbearia.

---

# Barbeiros

## POST /barbers

Cria barbeiro.

### Body

```json
{
  "name": "João",
  "email": "joao@email.com",
  "phone": "61999999999",
  "defaultCommissionType": "PERCENTAGE",
  "defaultCommissionValue": 50
}
```

## GET /barbers

Lista barbeiros da barbearia.

## PATCH /barbers/:id

Atualiza barbeiro.

## PATCH /barbers/:id/permissions

Atualiza permissões.

---

# Clientes

## POST /customers

Cadastra cliente.

## GET /customers

Lista clientes.

## GET /customers/:id

Detalha cliente.

## PATCH /customers/:id

Atualiza cliente.

## GET /customers/:id/history

Histórico de atendimentos.

---

# Serviços

## POST /services

Cria serviço.

## GET /services

Lista serviços.

## PATCH /services/:id

Atualiza serviço.

## DELETE /services/:id

Desativa serviço.

---

# Agenda

## GET /schedule/availability

Consulta horários disponíveis.

### Query params

```txt
barberId=uuid
serviceId=uuid
date=2026-07-06
```

## POST /schedule/blocks

Bloqueia horário.

## DELETE /schedule/blocks/:id

Remove bloqueio.

---

# Agendamentos

## POST /appointments

Cria agendamento.

### Body

```json
{
  "customerId": "uuid",
  "barberId": "uuid",
  "serviceId": "uuid",
  "startsAt": "2026-07-06T14:00:00-03:00"
}
```

## GET /appointments

Lista agendamentos.

### Filtros

```txt
startDate=2026-07-06
endDate=2026-07-13
barberId=uuid
status=CONFIRMED
```

## PATCH /appointments/:id/cancel

Cancela agendamento.

## PATCH /appointments/:id/reschedule

Reagenda.

## PATCH /appointments/:id/complete

Marca como concluído.

## PATCH /appointments/:id/no-show

Marca como não compareceu.

---

# Fila de espera

## POST /waiting-list

Cliente entra na fila.

## GET /waiting-list

Lista fila.

## PATCH /waiting-list/:id/offer

Oferece vaga.

## PATCH /waiting-list/:id/accept

Cliente aceita vaga.

## PATCH /waiting-list/:id/decline

Cliente recusa vaga.

---

# Estoque

## POST /products

Cria produto.

## GET /products

Lista produtos.

## PATCH /products/:id

Atualiza produto.

## POST /products/:id/stock-in

Entrada de estoque.

## POST /product-sales

Registra venda.

---

# Comissão

## GET /commissions

Lista comissões.

## PATCH /commissions/:id/adjust

Ajusta comissão.

## PATCH /commissions/:id/mark-paid

Marca como paga.

---

# Dashboard

## GET /dashboard/daily

Dados do dia.

## GET /dashboard/weekly

Dados da semana.

## GET /dashboard/monthly

Dados do mês.

## GET /dashboard/barbers/:id

Dados por barbeiro.

---

# WhatsApp CRM

## POST /whatsapp/send

Envia mensagem manual.

## GET /whatsapp/templates

Lista templates.

## POST /whatsapp/campaigns

Cria campanha.

## POST /whatsapp/menu

Configura menu.

---

# Planos SaaS

## POST /subscription-plans

Cria plano. Apenas SuperAdmin.

## GET /subscription-plans

Lista planos.

## PATCH /subscription-plans/:id

Atualiza plano.

---

# Dispositivos

## GET /devices

Lista dispositivos do usuário ou da barbearia.

## PATCH /devices/:id/block

Bloqueia dispositivo.

## DELETE /devices/:id

Remove dispositivo.
