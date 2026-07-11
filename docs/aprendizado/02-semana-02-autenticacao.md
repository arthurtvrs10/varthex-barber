# Semana 02 — Autenticação

**Período:** 13/07/2026 a 17/07/2026  
**Entrega:** Login, senha segura, JWT, refresh token, perfis e proteção de rotas.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Autenticação** sem pular o processo de entendimento.

## Critérios de aceite

- Usuário consegue logar.
- Usuário sem token não acessa área protegida.
- Perfil do usuário é identificado.

## Tarefas da semana

- Criar tabela de usuários.
- Criar hash de senha.
- Criar login.
- Criar JWT.
- Criar refresh token.
- Criar guards/filtros de autenticação.
- Criar tela de login.
- Criar proteção de rotas no frontend.

## O que você precisa aprender antes de implementar

- Autenticação versus autorização.
- Hash de senha.
- JWT e refresh token.
- Spring Security.
- Perfis SUPER_ADMIN, ADMIN, BARBER e CLIENT.

## Documentação oficial para consultar

- [Spring Security — Reference](https://docs.spring.io/spring-security/reference/index.html)
- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Next.js — Docs](https://nextjs.org/docs)

## Guia prático sem código

1. Modele o fluxo de login antes de codar.
2. Defina rotas públicas e rotas protegidas.
3. Defina papéis de usuário.
4. Planeje erros de login inválido e token ausente.
5. Só depois implemente tela e endpoints.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-02.md
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
├── auth/
│   ├── AuthController.java
│   ├── AuthService.java
│   ├── JwtService.java
│   └── dto/
├── users/
└── config/security/
```

## Comandos de verificação

```bash
./mvnw test
./mvnw spring-boot:run

curl -X POST http://localhost:8080/auth/login   -H "Content-Type: application/json"   -d '{"email":"admin@varthexbarber.com","password":"123456"}' 
```

## Código ou trecho de referência para correção

```txt
public enum Role {
    SUPER_ADMIN,
    ADMIN,
    BARBER,
    CLIENT
}

public record LoginRequest(String email, String password) {}

public record LoginResponse(
    String accessToken,
    String refreshToken,
    String role
) {}
```

## Como validar a correção

- Login válido retorna accessToken.
- Senha errada retorna 401.
- Rota protegida sem token retorna 401.
- Frontend redireciona sem sessão para login.
