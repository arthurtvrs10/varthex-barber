# Semana 04 — Cadastros principais

**Período:** 27/07/2026 a 31/07/2026  
**Entrega da semana:** CRUD de barbeiros, clientes e serviços com validações básicas.

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
7. Registrar dúvidas e erros em `docs/diario/semana-04.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **CRUD de barbeiros, clientes e serviços com validações básicas.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Admin cadastra barbeiro, cliente e serviço.
- Campos obrigatórios são validados.
- E-mail/telefone duplicado é tratado.
- Listagens respeitam a barbearia do usuário logado.
- Frontend possui telas simples e funcionais para cadastro/listagem.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- O que é CRUD.
- Diferença entre Entity, DTO, Controller, Service e Repository.
- Como validar entrada com Bean Validation.
- Como separar regra de negócio da camada HTTP.
- Como relacionar barbeiro/cliente/serviço com barbearia.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar CRUD de serviços.
2. Criar CRUD de barbeiros.
3. Criar CRUD de clientes.
4. Criar DTOs de request/response.
5. Criar validações obrigatórias.
6. Criar telas de cadastro simples.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Estudar CRUD, DTO e validação. |
| Terça | Fazer Serviços. |
| Quarta | Fazer Barbeiros. |
| Quinta | Fazer Clientes. |
| Sexta | Testar tudo no frontend e documentar. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Web MVC | <https://docs.spring.io/spring-framework/reference/web/webmvc.html> | Veja controllers REST. |
| Spring Data JPA Repositories | <https://docs.spring.io/spring-data/jpa/reference/repositories/core-concepts.html> | Veja repositories. |
| Bean Validation | <https://hibernate.org/validator/documentation/> | Veja anotações como NotBlank, Email, Positive. |
| Next.js Forms | <https://nextjs.org/docs/app/building-your-application/data-fetching/server-actions-and-mutations> | Veja opções para formulários/mutations. |
| PostgreSQL Constraints | <https://www.postgresql.org/docs/current/ddl-constraints.html> | Entenda unique e not null. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-04.md
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

## Estrutura esperada

```txt
backend/src/main/java/com/varthex/barber/
├── barbers/
├── clients/
└── services/
```

## DTO de criação de serviço

```java
public record CreateServiceRequest(
    @NotBlank String name,
    @NotNull @Positive BigDecimal price,
    @NotNull @Positive Integer durationMinutes
) {}
```

## Controller de referência

```java
@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceCatalogService service;

    public ServiceController(ServiceCatalogService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceResponse create(@Valid @RequestBody CreateServiceRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ServiceResponse> list() {
        return service.listFromCurrentBarbershop();
    }
}
```

## Regra de ouro para correção

O Controller não deve fazer regra de negócio. Ele recebe HTTP, valida entrada e chama Service.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 04"
```
