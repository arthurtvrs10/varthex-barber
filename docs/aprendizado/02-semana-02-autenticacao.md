# Semana 02 — Autenticação

**Período:** 13/07/2026 a 17/07/2026  
**Entrega da semana:** Login, senha criptografada, JWT, refresh token, perfis e tela de login.

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
7. Registrar dúvidas e erros em `docs/diario/semana-02.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Login, senha criptografada, JWT, refresh token, perfis e tela de login.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Usuário consegue fazer login com e-mail e senha.
- Senha é salva com hash, nunca em texto puro.
- Usuário sem token não acessa rotas protegidas.
- Backend identifica o perfil do usuário: `SUPER_ADMIN`, `ADMIN`, `BARBER`, `CLIENT`.
- Frontend protege rotas privadas e guarda o token com cuidado.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Diferença entre autenticação e autorização.
- Como funciona hash de senha com `BCryptPasswordEncoder`.
- O que é JWT e por que ele tem expiração.
- O que é refresh token e por que ele deve ser controlado.
- Como o Spring Security intercepta requisições.
- Como o frontend envia token no header `Authorization`.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Modelar usuário e perfil.
2. Criar endpoint de login.
3. Criar hash de senha.
4. Gerar JWT.
5. Criar filtro para validar JWT.
6. Proteger rotas privadas.
7. Criar tela de login no frontend.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Estudar autenticação, autorização, senha e JWT sem codar. |
| Terça | Modelar `User`, `Role` e pensar no fluxo de login. |
| Quarta | Implementar login e geração de token. |
| Quinta | Proteger rotas no backend e frontend. |
| Sexta | Testar login, erro de senha e acesso sem token. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Security Reference | <https://docs.spring.io/spring-security/reference/index.html> | Leia Getting Started e Architecture. |
| Spring Security Architecture | <https://docs.spring.io/spring-security/reference/servlet/architecture.html> | Entenda filtros e SecurityContext. |
| Spring Security Password Storage | <https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html> | Veja como armazenar senhas. |
| JWT Introduction | <https://jwt.io/introduction> | Entenda estrutura do token. |
| Next.js App Router | <https://nextjs.org/docs/app> | Veja rotas, layouts e componentes. |
| OWASP Authentication Cheat Sheet | <https://cheatsheetseries.owasp.org/cheatsheets/Authentication_Cheat_Sheet.html> | Use como referência de segurança. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-02.md
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
├── auth/
│   ├── AuthController.java
│   ├── AuthService.java
│   ├── JwtService.java
│   ├── JwtAuthenticationFilter.java
│   ├── dto/
│   └── config/
├── users/
│   ├── User.java
│   ├── UserRepository.java
│   └── UserRole.java
└── config/
    └── SecurityConfig.java
```

## Dependências esperadas no `pom.xml`

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-api</artifactId>
  <version>0.12.6</version>
</dependency>
```

## Enum de perfis

```java
public enum UserRole {
    SUPER_ADMIN,
    ADMIN,
    BARBER,
    CLIENT
}
```

## Exemplo de entidade `User`

```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
}
```

## PasswordEncoder de referência

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

## Teste manual esperado

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"admin@varthexbarber.com","password":"123456"}'
```

A resposta deve retornar token, tipo do token, expiração e dados básicos do usuário.

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 02"
```
