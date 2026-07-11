# Semana 16 — Monetização SaaS

**Período:** 19/10/2026 a 23/10/2026  
**Entrega:** Planos SaaS, limites, módulos pagos e dispositivos.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Monetização SaaS** sem pular o processo de entendimento.

## Critérios de aceite

- SuperAdmin controla o que cada barbearia pode usar.

## Tarefas da semana

- Criar planos SaaS.
- Criar limites por plano.
- Criar módulos pagos.
- Criar controle de dispositivos.
- Criar cobrança manual.
- Criar bloqueio por inadimplência.

## O que você precisa aprender antes de implementar

- Plano da plataforma versus plano do cliente final.
- Feature flag por plano.
- Limite de barbeiros/dispositivos.
- Módulo pago adicional.
- Inadimplência.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)

## Guia prático sem código

1. Liste planos SaaS.
2. Defina limites claros.
3. Separe módulos pagos.
4. Crie controle de dispositivos.
5. Comece com cobrança manual.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-16.md
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
├── saas/
├── subscriptions/
└── devices/
```

## Comandos de verificação

```bash
curl http://localhost:8080/saas/plans   -H "Authorization: Bearer TOKEN_SUPER_ADMIN"
```

## Código ou trecho de referência para correção

```txt
public record SaaSPlanResponse(
    String name,
    BigDecimal monthlyPrice,
    Integer maxBarbers,
    Integer maxDevicesPerBarber,
    boolean whatsappCrmEnabled
) {}

if (currentBarbers >= plan.getMaxBarbers()) {
    throw new BusinessException("Limite de barbeiros atingido para este plano.");
}
```

## Como validar a correção

- SuperAdmin cria plano.
- Barbearia respeita limite de barbeiros.
- Dispositivo extra é bloqueado.
- Módulo não contratado não aparece.
