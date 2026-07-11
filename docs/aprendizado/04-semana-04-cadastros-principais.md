# Semana 04 — Cadastros principais

**Período:** 27/07/2026 a 31/07/2026  
**Entrega:** CRUD de barbeiros, clientes e serviços.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Cadastros principais** sem pular o processo de entendimento.

## Critérios de aceite

- Admin cadastra barbeiro, cliente e serviço.

## Tarefas da semana

- CRUD de barbeiros.
- CRUD de clientes.
- CRUD de serviços.
- Tela de barbeiros.
- Tela de clientes.
- Tela de serviços.
- Validações básicas.

## O que você precisa aprender antes de implementar

- CRUD.
- Entidade, DTO, Controller, Service e Repository.
- Validação.
- Relacionamentos básicos.
- Evitar duplicidade.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [Next.js — Docs](https://nextjs.org/docs)

## Guia prático sem código

1. Comece por serviços.
2. Depois modele barbeiros.
3. Depois modele clientes.
4. Defina campos obrigatórios.
5. Faça telas simples e funcionais.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-04.md
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
├── barbers/
├── clients/
└── services/
```

## Comandos de verificação

```bash
curl -X POST http://localhost:8080/services   -H "Authorization: Bearer SEU_TOKEN"   -H "Content-Type: application/json"   -d '{"name":"Corte masculino","price":45.00,"durationMinutes":40}' 
```

## Código ou trecho de referência para correção

```txt
public record CreateServiceRequest(
    String name,
    BigDecimal price,
    Integer durationMinutes
) {}

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateServiceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
}
```

## Como validar a correção

- CRUD de barbeiro funciona.
- CRUD de cliente funciona.
- CRUD de serviço funciona.
- Preço negativo e duração vazia são bloqueados.
