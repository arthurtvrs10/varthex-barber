# 22 — Pagamentos

## Escopo inicial

Na primeira versão, o pagamento pode ser registrado manualmente.

Formas:

- Dinheiro.
- Pix.
- Cartão.
- Online.

---

## Pagamento de atendimento

O Admin ou barbeiro autorizado pode marcar o agendamento como pago.

Campos:

- Forma de pagamento.
- Valor pago.
- Desconto.
- Observação.
- Data de pagamento.

---

## Pagamento de produtos

A venda de produto deve registrar:

- Produto.
- Quantidade.
- Valor total.
- Cliente, se houver.
- Barbeiro vendedor, se houver.
- Forma de pagamento.

---

## Pagamento de planos para clientes

Planos podem ser cobrados:

- Manualmente no início.
- Com integração de pagamento futuramente.

---

## Pagamento SaaS das barbearias

O SuperAdmin deve controlar assinatura da barbearia.

No início:

- Registrar pagamento manual.
- Definir vencimento.
- Bloquear se vencido.

Futuramente:

- Integração com gateway de pagamento.
- Cobrança automática.
- Webhooks.

---

## Gateways possíveis

- Mercado Pago.
- Asaas.
- Stripe.
- PagSeguro.
- Pagar.me.

---

## Recomendação de MVP

Não começar com pagamento automático.

Começar com:

- Registro manual de pagamento.
- Status pago/pendente.
- Forma de pagamento.
- Dashboard financeiro.

Depois integrar gateway.
