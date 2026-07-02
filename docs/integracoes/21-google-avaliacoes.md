# 21 — Google Avaliações

## Objetivo

Aumentar a quantidade de avaliações da barbearia no Google.

---

## Funcionamento

1. Admin cadastra link de avaliação do Google.
2. Cliente realiza atendimento.
3. Barbeiro ou Admin marca atendimento como concluído.
4. Sistema agenda envio da mensagem.
5. Cliente recebe WhatsApp com o link.

---

## Configurações

O Admin deve conseguir configurar:

- Link de avaliação.
- Tempo após atendimento para envio.
- Texto da mensagem.
- Ativar/desativar envio automático.
- Evitar enviar para o mesmo cliente várias vezes em pouco tempo.

---

## Exemplo de mensagem

```txt
Obrigado pela visita, {{cliente_nome}}!

Sua opinião ajuda muito nossa barbearia.
Se puder, deixe uma avaliação rápida no Google:

{{google_review_link}}
```

---

## Regras

- Enviar somente após atendimento concluído.
- Não enviar se o agendamento foi cancelado.
- Não enviar se o cliente faltou.
- Registrar histórico de envio.
- Evitar duplicidade.

---

## Métricas úteis

- Quantidade de links enviados.
- Quantidade de clientes que receberam.
- Quantidade de clientes que clicaram, se houver rastreamento.
- Média de avaliações pode ser acompanhada manualmente ou via integração futura.
