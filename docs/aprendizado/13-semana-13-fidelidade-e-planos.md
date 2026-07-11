# Semana 13 — Fidelidade e planos

**Período:** 28/09/2026 a 02/10/2026  
**Entrega:** Pontos, resgates e planos para clientes.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Fidelidade e planos** sem pular o processo de entendimento.

## Critérios de aceite

- Cliente acumula pontos e pode usar benefícios.

## Tarefas da semana

- Criar pontos.
- Criar regras de acúmulo.
- Criar resgate.
- Criar planos para cliente.
- Controlar uso de plano.

## O que você precisa aprender antes de implementar

- Fidelidade versus assinatura.
- Pontos ganhos e resgatados.
- Benefícios.
- Plano mensal com limite.
- Validade de pontos/plano.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)

## Guia prático sem código

1. Comece com regra simples de pontos.
2. Crie histórico de pontos.
3. Defina benefícios resgatáveis.
4. Separe plano do cliente de plano SaaS.
5. Registre uso de plano por atendimento.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-13.md
```

Responda:

- O que esta semana entrega para o produto?
- Quais telas, entidades ou serviços serão impactados?
- Quais regras podem gerar erro?
- Quem pode usar essa funcionalidade?
- Como vou saber que terminei?

## Checklist de aprendizado

- [ ] Entendi o objetivo da semana.
- [ ] Consultei a documentação oficial.
- [ ] Consegui explicar a semana sem olhar código.
- [ ] Desenhei o fluxo principal.
- [ ] Tentei implementar antes de olhar a correção.
- [ ] Registrei meu aprendizado no GitHub.

## Erros comuns

- Começar copiando código sem entender o fluxo.
- Misturar responsabilidade de Controller, Service e Repository.
- Criar tela antes de validar regra no backend.
- Não testar o fluxo completo.
- Não atualizar a documentação.

## O que registrar no GitHub

Ao final, registre:

- resumo do que foi feito;
- decisões tomadas;
- dificuldades;
- comandos úteis;
- pendências para a próxima semana.

---

# Parte 2 — Guia com código para correção

> Use esta parte somente depois de tentar fazer a semana sozinho.

## Estrutura esperada

```txt
backend/src/main/java/com/varthex/barber/
├── loyalty/
└── customerPlans/
```

## Comandos de verificação

```bash
curl http://localhost:8080/clients/ID/loyalty   -H "Authorization: Bearer SEU_TOKEN"
```

## Código ou trecho de referência para correção

```txt
public enum LoyaltyMovementType {
    EARNED,
    REDEEMED,
    EXPIRED,
    MANUAL_ADJUSTMENT
}

public record CustomerPlanResponse(
    String name,
    BigDecimal monthlyPrice,
    Integer includedAppointments,
    Integer usedAppointments
) {}
```

## Como validar a correção

- Atendimento pode gerar pontos.
- Resgate reduz saldo.
- Plano controla uso.
- Histórico não é apagado.
