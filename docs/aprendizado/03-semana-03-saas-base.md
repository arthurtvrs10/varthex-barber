# Semana 03 — SaaS base

**Período:** 20/07/2026 a 24/07/2026  
**Entrega da semana:** SuperAdmin, barbearias, relação usuário/barbearia e isolamento de dados por barbearia.

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
7. Registrar dúvidas e erros em `docs/diario/semana-03.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **SuperAdmin, barbearias, relação usuário/barbearia e isolamento de dados por barbearia.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- SuperAdmin cria barbearia.
- Admin acessa apenas a própria barbearia.
- Consultas principais respeitam `barbershopId`.
- Usuário sem vínculo com a barbearia não acessa seus dados.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- O que é SaaS multi-tenant.
- Diferença entre plataforma e barbearia cliente.
- Por que todo dado operacional precisa estar ligado a uma barbearia.
- Como evitar vazamento de dados entre empresas.
- Como validar permissões por perfil e por barbearia.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Criar entidade `Barbershop`.
2. Criar relação entre usuário e barbearia.
3. Criar fluxo de criação de barbearia pelo SuperAdmin.
4. Criar contexto da barbearia atual.
5. Criar proteção para Admin enxergar apenas a própria barbearia.
6. Criar telas simples de listagem/criação de barbearia.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Estudar multi-tenant e desenhar isolamento por barbearia. |
| Terça | Modelar Barbershop e relação com Users. |
| Quarta | Criar endpoints do SuperAdmin. |
| Quinta | Criar regras de isolamento e testes manuais. |
| Sexta | Criar telas simples e atualizar documentação. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Data JPA | <https://docs.spring.io/spring-data/jpa/reference/index.html> | Leia entidades, repositories e query methods. |
| Spring Security Authorization | <https://docs.spring.io/spring-security/reference/servlet/authorization/index.html> | Veja regras de autorização. |
| PostgreSQL Foreign Keys | <https://www.postgresql.org/docs/current/tutorial-fk.html> | Entenda relacionamentos. |
| OWASP Access Control | <https://cheatsheetseries.owasp.org/cheatsheets/Authorization_Cheat_Sheet.html> | Use como referência de controle de acesso. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-03.md
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
├── barbershops/
│   ├── Barbershop.java
│   ├── BarbershopController.java
│   ├── BarbershopService.java
│   └── BarbershopRepository.java
└── common/security/
    └── CurrentUserService.java
```

## Entidade de referência

```java
@Entity
@Table(name = "barbershops")
public class Barbershop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    private String googleReviewUrl;

    @Enumerated(EnumType.STRING)
    private BarbershopStatus status = BarbershopStatus.ACTIVE;
}
```

## Regra de isolamento para conferir

```java
public Barbershop getMyBarbershop(UUID currentUserId) {
    User user = userRepository.findById(currentUserId)
        .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

    if (user.getRole() == UserRole.SUPER_ADMIN) {
        throw new BusinessException("SuperAdmin deve informar a barbearia alvo");
    }

    return user.getBarbershop();
}
```

## Validação manual

1. Crie duas barbearias.
2. Crie um admin para cada uma.
3. Faça login como Admin A.
4. Tente buscar dados da Barbearia B.
5. O backend deve negar ou retornar vazio.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 03"
```
