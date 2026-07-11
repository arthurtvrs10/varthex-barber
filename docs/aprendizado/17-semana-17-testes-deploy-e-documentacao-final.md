# Semana 17 — Testes, deploy e documentação final

**Período:** 26/10/2026 a 30/10/2026  
**Entrega da semana:** Correções, revisão, testes, deploy e documentação final de uso.

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
7. Registrar dúvidas e erros em `docs/diario/semana-17.md`.
8. Só no final abrir a **Parte 2 — Guia com código/comandos para correção**.

---

# Parte 1 — Guia prático sem código

## 1. Objetivo da semana

Nesta semana você deve entregar: **Correções, revisão, testes, deploy e documentação final de uso.**

O foco não é fazer bonito. O foco é entender o que está sendo construído, por que isso existe no produto e como validar que funcionou.

## 2. Critérios de aceite

Você só considera esta semana concluída quando conseguir provar:

- Sistema pronto para piloto.
- Fluxos principais foram testados.
- Permissões foram verificadas.
- Deploy está documentado.
- README e docs explicam uso, ambiente e próximas fases.

## 3. O que você precisa aprender antes de implementar

Antes de abrir o editor para codar, estude estes conceitos:

- Tipos de teste: unitário, integração e manual.
- Como testar API com Spring Boot Test.
- Como testar banco com Testcontainers ou banco de teste.
- Como criar checklist de release.
- Como documentar deploy e variáveis de ambiente.

## 4. O que fazer, em ordem, sem código

Siga esta ordem. Não pule etapas:

1. Testar login e permissões.
2. Testar agenda e conflitos.
3. Testar comissão e dashboard.
4. Testar fila e recorrência.
5. Corrigir bugs.
6. Criar documentação final de uso.
7. Criar guia de deploy.

## 5. Roteiro sugerido por dia

| Dia | Foco |
|---|---|
| Segunda | Montar plano de testes. |
| Terça | Testar backend. |
| Quarta | Testar frontend e fluxos. |
| Quinta | Preparar deploy e variáveis. |
| Sexta | Revisar documentação e fechar piloto. |

## 6. Onde achar para conseguir aplicar

Use esta seção como anexo de estudo. Não precisa ler a documentação inteira. Leia somente a parte indicada em cada linha.

| Tema | Link oficial | O que procurar |
|---|---|---|
| Spring Boot Testing | <https://docs.spring.io/spring-boot/reference/testing/index.html> | Veja testes no Spring Boot. |
| JUnit 5 User Guide | <https://junit.org/junit5/docs/current/user-guide/> | Veja estrutura de testes. |
| Testcontainers Java | <https://java.testcontainers.org/> | Use para testes com PostgreSQL/Redis. |
| Docker Compose | <https://docs.docker.com/compose/> | Veja execução e logs. |
| GitHub Actions | <https://docs.github.com/en/actions> | Veja CI/CD. |
| Next.js Deployment | <https://nextjs.org/docs/app/getting-started/deploying> | Veja deploy do frontend. |

## 7. Exercício antes de programar

Crie ou atualize este arquivo no seu repositório:

```txt
docs/diario/semana-17.md
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

## Teste unitário de referência

```java
@SpringBootTest
class HealthControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnHealthOk() {
        ResponseEntity<String> response = restTemplate.getForEntity("/health", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
```

## Checklist de release

```md
# Checklist de piloto

- [ ] Login testado
- [ ] Permissões testadas
- [ ] Agenda testada
- [ ] Conflito de horário testado
- [ ] Comissão testada
- [ ] Dashboard testado
- [ ] Fila de espera testada
- [ ] Backup documentado
- [ ] Variáveis de ambiente documentadas
- [ ] Deploy documentado
```

## GitHub Actions mínimo para correção

```yaml
name: CI

on:
  pull_request:
  push:
    branches: [main]

jobs:
  backend:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '21'
      - name: Test backend
        working-directory: backend
        run: ./mvnw test
```

---

# Commit sugerido da semana

```bash
git add .
git commit -m "docs: registra aprendizado da semana 17"
```
