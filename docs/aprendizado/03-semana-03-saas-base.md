# Semana 03 — SaaS base

**Período:** 20/07/2026 a 24/07/2026  
**Entrega:** SuperAdmin, barbearias e isolamento por barbearia.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **SaaS base** sem pular o processo de entendimento.

## Critérios de aceite

- SuperAdmin cria barbearia.
- Admin acessa apenas a própria barbearia.

## Tarefas da semana

- Criar tabela de barbearias.
- Criar relacionamento usuário/barbearia.
- Criar SuperAdmin.
- Criar Admin da barbearia.
- Aplicar isolamento por barbershopId.
- Criar tela de listagem de barbearias.
- Criar tela de criação de barbearia.

## O que você precisa aprender antes de implementar

- SaaS multiempresa.
- Isolamento por barbearia.
- Diferença entre SuperAdmin e Admin.
- Filtro por barbershopId.
- Evitar vazamento de dados.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)

## Guia prático sem código

1. Desenhe a relação plataforma → barbearias → usuários.
2. Defina ações do SuperAdmin e ações do Admin.
3. Liste consultas que precisam de barbershopId.
4. Planeje erro para acesso a outra barbearia.
5. Aplique isolamento antes de criar muitas telas.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-03.md
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
├── barbershops/
│   ├── Barbershop.java
│   ├── BarbershopController.java
│   ├── BarbershopService.java
│   └── BarbershopRepository.java
└── users/
```

## Comandos de verificação

```bash
curl -X GET http://localhost:8080/barbershops   -H "Authorization: Bearer SEU_TOKEN"
```

## Código ou trecho de referência para correção

```txt
@Entity
@Table(name = "barbershops")
public class Barbershop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean active = true;
}

// Todo repository operacional deve filtrar por barbershopId
List<Client> findByBarbershopId(UUID barbershopId);
```

## Como validar a correção

- SUPER_ADMIN lista todas as barbearias.
- ADMIN vê somente a própria barbearia.
- Cadastros operacionais possuem barbershopId.
