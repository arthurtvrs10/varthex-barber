# Semana 10 — Fila de espera

**Período:** 07/09/2026 a 11/09/2026  
**Entrega:** Entrada na fila, oferta de vaga e aceite/recusa.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Fila de espera** sem pular o processo de entendimento.

## Critérios de aceite

- Vaga cancelada pode ser oferecida para cliente da fila.

## Tarefas da semana

- Criar fila.
- Cliente entra na fila.
- Admin visualiza fila.
- Oferecer vaga.
- Aceitar vaga.
- Recusar vaga.
- Passar para próximo.

## O que você precisa aprender antes de implementar

- Ordem de entrada.
- Preferência de barbeiro/serviço/período.
- Tempo limite.
- Evitar duplo aceite.
- Status da fila.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)
- [Redis — Docs](https://redis.io/docs/latest/)

## Guia prático sem código

1. Desenhe o fluxo da fila.
2. Defina status.
3. Comece manual antes de automático.
4. Evite complexidade antes da fila funcionar.
5. Registre ofertas.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-10.md
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
└── waitlist/
    ├── WaitlistEntry.java
    ├── WaitlistStatus.java
    ├── WaitlistController.java
    └── WaitlistService.java
```

## Comandos de verificação

```bash
curl -X POST http://localhost:8080/waitlist   -H "Authorization: Bearer SEU_TOKEN"   -H "Content-Type: application/json"   -d '{"clientId":"ID","barberId":"ID","serviceId":"ID","desiredDate":"2026-09-07","preferredPeriod":"AFTERNOON"}' 
```

## Código ou trecho de referência para correção

```txt
public enum WaitlistStatus {
    WAITING,
    OFFERED,
    ACCEPTED,
    DECLINED,
    EXPIRED,
    CANCELED
}

// Ao aceitar vaga:
// 1. Verificar se horário ainda está disponível
// 2. Criar agendamento
// 3. Marcar entrada como ACCEPTED
// 4. Expirar outras ofertas do mesmo horário
```

## Como validar a correção

- Cliente entra na fila.
- Admin vê posição.
- Vaga cancelada pode ser oferecida.
- Só um cliente aceita a vaga.
