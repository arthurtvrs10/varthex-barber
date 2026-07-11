# Semana 05 — Horários e disponibilidade

**Período:** 03/08/2026 a 07/08/2026  
**Entrega:** Horários da barbearia, horários dos barbeiros e disponibilidade.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Horários e disponibilidade** sem pular o processo de entendimento.

## Critérios de aceite

- Sistema mostra horários disponíveis corretamente.

## Tarefas da semana

- Criar horário da barbearia.
- Criar horário por barbeiro.
- Criar intervalos.
- Criar folgas.
- Criar endpoint de disponibilidade.
- Considerar duração do serviço.

## O que você precisa aprender antes de implementar

- Horário de funcionamento versus disponibilidade real.
- Dias da semana.
- Intervalos de tempo.
- Duração do serviço.
- Folga e almoço.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)
- [Java 21 — JDK Documentation](https://docs.oracle.com/en/java/javase/21/)

## Guia prático sem código

1. Liste horários da barbearia por dia.
2. Liste horários de cada barbeiro.
3. Decida se barbeiro herda horário da barbearia.
4. Desenhe slots de 30, 40 e 60 minutos.
5. Crie regras antes do endpoint.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-05.md
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
├── schedules/
│   ├── BusinessHour.java
│   ├── BarberWorkingHour.java
│   ├── AvailabilityService.java
│   └── AvailabilityController.java
```

## Comandos de verificação

```bash
curl "http://localhost:8080/availability?barberId=ID&serviceId=ID&date=2026-08-05"   -H "Authorization: Bearer SEU_TOKEN"
```

## Código ou trecho de referência para correção

```txt
public record AvailabilitySlotResponse(
    LocalTime startTime,
    LocalTime endTime,
    boolean available
) {}

// Um slot só é disponível se:
// 1. Está dentro do horário da barbearia
// 2. Está dentro do horário do barbeiro
// 3. Não cai em intervalo ou folga
// 4. Não conflita com agendamento
// 5. Não conflita com bloqueio
```

## Como validar a correção

- Fora do expediente não aparece.
- Almoço não aparece.
- Duração do serviço é considerada.
- Barbeiro de folga não aparece disponível.
