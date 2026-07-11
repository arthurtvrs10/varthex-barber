# Semana 17 — Testes, deploy e documentação final

**Período:** 26/10/2026 a 30/10/2026  
**Entrega:** Correções, revisão, deploy e documentação final de uso.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Testes, deploy e documentação final** sem pular o processo de entendimento.

## Critérios de aceite

- Sistema pronto para piloto.

## Tarefas da semana

- Testar fluxos principais.
- Testar permissões.
- Testar agenda.
- Testar comissão.
- Testar fila.
- Corrigir bugs.
- Configurar deploy.
- Criar documentação final de uso.

## O que você precisa aprender antes de implementar

- Teste unitário e integração.
- Local versus produção.
- Variáveis de ambiente.
- Logs.
- Checklist de piloto.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Docker Compose — Docs](https://docs.docker.com/compose/)
- [GitHub Docs — Get started](https://docs.github.com/en/get-started)
- [Next.js — Docs](https://nextjs.org/docs)

## Guia prático sem código

1. Liste fluxos críticos.
2. Teste perfis diferentes.
3. Crie checklist de bugs.
4. Documente como subir do zero.
5. Piloto só quando outra pessoa conseguir seguir o README.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-17.md
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
docs/
├── manual-do-usuario.md
├── guia-de-deploy.md
├── checklist-piloto.md
└── troubleshooting.md
```

## Comandos de verificação

```bash
docker compose down
docker compose up -d --build
docker compose logs -f backend

git status
git add .
git commit -m "docs: finaliza guia de piloto do sistema"
```

## Código ou trecho de referência para correção

```txt
@SpringBootTest
class HealthCheckTest {
    @Test
    void contextLoads() {
    }
}

# checklist-piloto.md
- [ ] Admin consegue logar
- [ ] Admin cria serviço
- [ ] Admin cria barbeiro
- [ ] Admin cria cliente
- [ ] Admin cria agendamento
- [ ] Atendimento concluído gera comissão
- [ ] Dashboard mostra fechamento do dia
```

## Como validar a correção

- Fluxos principais testados.
- README atualizado.
- Guia de deploy criado.
- Problemas conhecidos documentados.
- Versão de piloto marcada no GitHub.
