# Semana 16 — Monetização SaaS

**Período:** 19/10/2026 a 23/10/2026  
**Entrega da semana:** Planos SaaS, limites, módulos pagos, dispositivos e bloqueio por inadimplência.

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
7. Registrar dúvidas e erros em `docs/diario/semana-16.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Planos SaaS, limites, módulos pagos, dispositivos e bloqueio por inadimplência.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- SuperAdmin controla o que cada barbearia pode usar.
- Plano limita quantidade de barbeiros/dispositivos/módulos.
- Recurso pago pode ser ativado/desativado.
- Sistema bloqueia uso acima do limite.
- Inadimplência pode limitar a barbearia.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Diferença entre plano, assinatura, recurso e limite.
- Feature flag.
- Quota de uso.
- Controle de dispositivos.
- Como aplicar limite sem espalhar if por todo o sistema.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar SaaSPlan.
2. Criar Feature.
3. Criar BarbershopSubscription.
4. Criar limite de barbeiros.
5. Criar limite de dispositivos.
6. Criar guard/check de recurso.
7. Criar painel simples do SuperAdmin.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Desenhar planos e recursos. |
| Terça | Modelar assinatura. |
| Quarta | Criar limites. |
| Quinta | Criar controle de dispositivos. |
| Sexta | Testar bloqueios e documentar monetização. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Security Authorization | <https://docs.spring.io/spring-security/reference/servlet/authorization/index.html> | Veja autorização por regra. |
| Spring Data JPA | <https://docs.spring.io/spring-data/jpa/reference/index.html> | Use relacionamentos entre plano e barbearia. |
| OWASP Access Control | <https://cheatsheetseries.owasp.org/cheatsheets/Authorization_Cheat_Sheet.html> | Evite bypass de autorização. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-16.md
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

## Modelo de plano

```java
@Entity
@Table(name = "saas_plans")
public class SaaSPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private BigDecimal monthlyPrice;
    private Integer maxBarbers;
    private Integer maxDevicesPerBarber;
    private boolean whatsappCrmEnabled;
    private boolean googleCalendarEnabled;
    private boolean advancedDashboardEnabled;
}
```

## Checagem de limite

```java
public void assertCanCreateBarber(UUID barbershopId) {
    int current = barberRepository.countByBarbershopId(barbershopId);
    SaaSPlan plan = subscriptionService.getActivePlan(barbershopId);

    if (current >= plan.getMaxBarbers()) {
        throw new BusinessException("Limite de barbeiros atingido para o plano atual");
    }
}
```

## Correção importante

Centralize regras de plano em um serviço, por exemplo `PlanGuardService`, para não espalhar regras em todos os Controllers.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 16"
```
