# Semana 07 — Bloqueio e desbloqueio de horários

**Período:** 17/08/2026 a 21/08/2026  
**Entrega:** Bloquear e desbloquear horários com motivo.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Bloqueio e desbloqueio de horários** sem pular o processo de entendimento.

## Critérios de aceite

- Horário bloqueado não aparece disponível.

## Tarefas da semana

- Criar bloqueio de horário.
- Criar bloqueio de dia inteiro.
- Criar desbloqueio.
- Registrar motivo.
- Mostrar bloqueio na agenda.

## O que você precisa aprender antes de implementar

- Agendamento versus bloqueio.
- Bloqueio parcial e dia inteiro.
- Motivo para auditoria.
- Bloqueio afeta disponibilidade.
- Permissão para bloquear.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)

## Guia prático sem código

1. Liste motivos possíveis.
2. Defina quem pode bloquear.
3. Trate conflito com agendamento existente.
4. Decida se desbloquear apaga ou inativa.
5. Atualize disponibilidade.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-07.md
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
└── blocks/
    ├── TimeBlock.java
    ├── TimeBlockController.java
    ├── TimeBlockService.java
    └── TimeBlockRepository.java
```

## Comandos de verificação

```bash
curl -X POST http://localhost:8080/time-blocks   -H "Authorization: Bearer SEU_TOKEN"   -H "Content-Type: application/json"   -d '{"barberId":"ID","startAt":"2026-08-17T12:00:00","endAt":"2026-08-17T13:00:00","reason":"Almoço"}' 
```

## Código ou trecho de referência para correção

```txt
@Entity
@Table(name = "time_blocks")
public class TimeBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID barberId;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String reason;
    private Boolean active = true;
}
```

## Como validar a correção

- Bloqueio aparece na agenda.
- Horário bloqueado some da disponibilidade.
- Desbloqueio libera horário se não houver conflito.
- Motivo fica registrado.
