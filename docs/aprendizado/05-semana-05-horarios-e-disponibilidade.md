# Semana 05 — Horários e disponibilidade

**Período:** 03/08/2026 a 07/08/2026  
**Entrega da semana:** Horários da barbearia, horários dos barbeiros, intervalos, folgas e endpoint de disponibilidade.

> Este arquivo é para você abrir somente na semana correspondente. A ideia é aprender antes de copiar. Primeiro leia a Parte 1 inteira, tente fazer sozinho e só depois use a Parte 2 como correção.

---

# Como usar este arquivo

A ordem correta é:

1. Ler o objetivo da semana.
2. Entender o problema de negócio.
3. Estudar os conceitos técnicos indicados.
4. Abrir as documentações oficiais indicadas em **Onde achar para aplicar**.
5. Desenhar o fluxo em papel, Excalidraw, Figma ou Markdown.
6. Tentar implementar sem olhar a correção.
7. Registrar dúvidas e erros em `docs/diario/semana-05.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Horários da barbearia, horários dos barbeiros, intervalos, folgas e endpoint de disponibilidade.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Sistema mostra horários disponíveis corretamente.
- Horário respeita funcionamento da barbearia.
- Horário respeita agenda individual do barbeiro.
- Intervalos e folgas não aparecem disponíveis.
- Duração do serviço é considerada.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Diferença entre horário de funcionamento e disponibilidade real.
- Como representar dias da semana no banco.
- Como lidar com intervalos de tempo.
- Como gerar slots de atendimento.
- Como considerar duração do serviço.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Modelar horário de funcionamento da barbearia.
2. Modelar horário individual do barbeiro.
3. Modelar intervalos e folgas.
4. Criar endpoint para consultar disponibilidade.
5. Criar tela simples para ver horários livres.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Desenhar regras de disponibilidade. |
| Terça | Modelar horários da barbearia. |
| Quarta | Modelar horários dos barbeiros. |
| Quinta | Criar algoritmo de slots. |
| Sexta | Testar horários reais e documentar conflitos. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Java Time API | <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/package-summary.html> | Estude LocalDate, LocalTime, LocalDateTime e DayOfWeek. |
| Spring Data JPA | <https://docs.spring.io/spring-data/jpa/reference/index.html> | Veja query methods por data e relacionamento. |
| PostgreSQL Date/Time | <https://www.postgresql.org/docs/current/datatype-datetime.html> | Veja tipos de data/hora. |
| Next.js App Router | <https://nextjs.org/docs/app> | Veja criação de páginas de consulta. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-05.md
```

Responda antes de implementar:

1. O que esta semana entrega para o produto?
2. Quem usa essa funcionalidade?
3. Quais dados precisam existir?
4. Quais regras podem dar erro?
5. Como vou testar sem depender de tela bonita?
6. Que documentação oficial eu consultei?
7. Qual parte ainda ficou confusa?

## 8. Checklist sem código

Marque apenas quando você realmente entendeu ou fez:

- [ ] Entendi o objetivo da semana.
- [ ] Entendi o problema de negócio.
- [ ] Li pelo menos a documentação oficial principal da semana.
- [ ] Desenhei o fluxo antes de codar.
- [ ] Sei explicar quais dados serão criados ou alterados.
- [ ] Sei explicar quais endpoints/telas devem existir.
- [ ] Sei explicar o critério de aceite.
- [ ] Tentei implementar antes de abrir a correção.
- [ ] Registrei dúvidas e erros no diário da semana.

## 9. Erros comuns de iniciante nesta semana

- Começar pelo código sem entender a regra.
- Criar tela antes de validar o backend.
- Misturar regra de negócio dentro do Controller.
- Não validar dados de entrada.
- Não testar caso de erro.
- Não registrar decisões na documentação.
- Copiar a correção antes de tentar fazer sozinho.

## 10. O que registrar no GitHub ao finalizar

No final da semana, atualize o diário com:

- o que foi feito;
- o que funcionou;
- o que deu erro;
- como corrigiu;
- links de documentação usados;
- prints ou comandos de validação;
- pendências para a próxima semana.

---

# Parte 2 — Guia com código/comandos para correção

> Use esta parte somente depois de tentar fazer a semana sozinho. A correção não existe para você copiar no início; ela existe para comparar, corrigir e entender o que faltou.

## Entidades esperadas

```txt
BusinessHour
BarberWorkingHour
BarberDayOff
BreakTime
```

## Exemplo de regra de slot

```java
public List<LocalTime> generateSlots(LocalTime start, LocalTime end, int serviceDuration) {
    List<LocalTime> slots = new ArrayList<>();
    LocalTime current = start;

    while (!current.plusMinutes(serviceDuration).isAfter(end)) {
        slots.add(current);
        current = current.plusMinutes(30);
    }

    return slots;
}
```

## Validação esperada

```bash
curl "http://localhost:8080/availability?barberId=ID&serviceId=ID&date=2026-08-03"
```

O retorno deve listar somente horários possíveis, sem almoço, folga, horários fora do expediente ou slots menores que a duração do serviço.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 05"
```
