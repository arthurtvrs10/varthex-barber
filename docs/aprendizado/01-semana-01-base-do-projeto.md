# Semana 01 — Base do projeto

**Período:** 06/07/2026 a 10/07/2026  
**Entrega:** Repositório, documentação, ambiente local, backend Java/Spring Boot base, frontend Next.js base, PostgreSQL, Redis e Docker Compose.  
**Stack do projeto:** Java 21 + Spring Boot + Spring Security + Spring Data JPA + PostgreSQL + Redis + Next.js + Docker Compose.

---

## Como usar este arquivo

Este arquivo foi feito para você abrir **somente na semana correspondente**.

A ordem é obrigatória:

1. Leia a **Parte 1 — Guia prático sem código**.
2. Entenda o problema de negócio.
3. Faça a análise de requisitos.
4. Desenhe os fluxos e regras.
5. Consulte as documentações oficiais indicadas.
6. Tente implementar sozinho.
7. Só no final use a **Parte 2 — Correção com código/comandos**.

> A regra principal é: **não comece pelo código**. Primeiro entenda por que a funcionalidade existe e o que ela precisa resolver.

---

# PARTE 1 — Guia prático sem código

## 1. Objetivo da semana

Repositório, documentação, ambiente local, backend Java/Spring Boot base, frontend Next.js base, PostgreSQL, Redis e Docker Compose.

O objetivo não é apenas "fazer funcionar". O objetivo é entender **por que essa parte existe no software**, quais decisões precisam ser tomadas e como validar se a entrega está correta.

---

## 2. Por que esta semana é necessária?

Cria o chão técnico do produto. Não entrega agendamento ainda, mas prova que existe uma base confiável para evoluir o SaaS de barbearia.

### Problema de negócio

Antes de qualquer regra de negócio, o projeto precisa nascer organizado. Sem uma base clara, cada nova funcionalidade vira gambiarra: o backend não conversa com o banco, o frontend não sabe onde buscar dados e a documentação não explica como outra pessoa roda o sistema.

### Consequência de não fazer direito

Se esta semana for feita sem análise, o sistema pode ficar com regras confusas, dados duplicados, telas que não fecham o fluxo real da barbearia e código difícil de corrigir nas próximas semanas.

---

## 3. Quem usa ou é impactado?

- Desenvolvedor
- Futuro SuperAdmin
- Futuro Admin/Dono
- Futuro Barbeiro
- Futuro Cliente

Para cada ator, responda no seu diário:

- O que essa pessoa precisa fazer?
- O que essa pessoa não pode fazer?
- Qual erro prejudicaria mais essa pessoa?
- Qual informação precisa aparecer na tela?
- Qual informação precisa ser protegida?

---

## 4. Escopo da semana

### Entra no escopo

- Criar repositório no GitHub
- Criar documentação inicial
- Criar backend Spring Boot mínimo
- Criar frontend Next.js mínimo
- Configurar PostgreSQL e Redis no Docker
- Criar .env.example
- Criar README técnico

### Não entra no escopo agora

- Login real
- Agendamento
- Comissão
- WhatsApp
- Dashboard completo

Essa separação evita tentar fazer tudo ao mesmo tempo.

---

## 5. O que você precisa aprender antes de implementar

- Git, GitHub, commit e branch
- Backend, frontend, banco e cache
- Spring Boot e estrutura inicial
- Next.js e App Router
- Docker Compose
- PostgreSQL
- Redis
- Variáveis de ambiente

Explique cada item com suas palavras antes de codar. Se você não consegue explicar, ainda não está pronto para implementar.

---

## 6. Onde achar para conseguir aplicar

| O que preciso fazer | Onde achar | O que procurar |
|---|---|---|
| Java 21 | https://docs.oracle.com/en/java/javase/21/ | Tipos, records, enums, LocalDateTime, BigDecimal e UUID. |
| Spring Boot | https://docs.spring.io/spring-boot/documentation.html | Ler a seção relacionada e anotar como aplicar no projeto. |
| Next.js | https://nextjs.org/docs | App Router, páginas, componentes e consumo de API. |
| Docker Compose | https://docs.docker.com/compose/ | Services, env_file, ports, volumes e depends_on. |
| Compose File Reference | https://docs.docker.com/reference/compose-file/ | Ler a seção relacionada e anotar como aplicar no projeto. |
| PostgreSQL | https://www.postgresql.org/docs/ | Tabelas, constraints, tipos de dados e consultas SQL. |
| Redis | https://redis.io/docs/latest/ | Conexão, PING, cache, filas e estruturas básicas. |


### Como estudar a documentação

Não tente ler tudo. Abra a documentação, procure o tópico indicado e anote:

- o nome do conceito;
- para que serve;
- onde ele entra no projeto;
- um exemplo pequeno;
- uma dúvida que ficou.

---

## 7. Ordem prática sem código

Siga esta ordem antes de implementar:

1. Desenhar a arquitetura: navegador, frontend, backend, PostgreSQL e Redis.
2. Criar o repositório vazio e o README antes do código.
3. Criar pasta docs e registrar o objetivo da Semana 1.
4. Criar backend Spring Boot mínimo.
5. Criar frontend Next.js mínimo.
6. Configurar Docker Compose com PostgreSQL e Redis.
7. Criar .env.example.
8. Testar cada serviço separadamente.
9. Atualizar README com comandos reais.
10. Fazer commit e push.

---

## 8. Requisitos funcionais

Requisitos funcionais descrevem **o que o sistema deve fazer**.

| Código | Descrição |
|---|---|
| RF01 | O repositório deve possuir pastas backend, frontend e docs. |
| RF02 | O backend deve iniciar localmente e responder uma rota de saúde. |
| RF03 | O frontend deve iniciar localmente e exibir uma página inicial. |
| RF04 | Docker Compose deve subir PostgreSQL e Redis. |
| RF05 | README deve explicar como rodar do zero. |


---

## 9. Requisitos não funcionais

Requisitos não funcionais descrevem **como o sistema deve se comportar**.

| Código | Descrição |
|---|---|
| RNF01 | A funcionalidade deve respeitar isolamento por barbearia. |
| RNF02 | Os erros devem ser claros para o usuário. |
| RNF03 | A implementação deve ser simples o suficiente para manutenção por estudante. |
| RNF04 | A documentação deve ser atualizada junto com a implementação. |


---

## 10. Regras de negócio

Regras de negócio descrevem **condições reais da barbearia/plataforma** que o sistema precisa respeitar.

| Código | Descrição |
|---|---|
| RN01 | .env não deve ir para o GitHub; somente .env.example. |
| RN02 | Backend e frontend devem ficar separados. |
| RN03 | A documentação deve ficar em docs. |
| RN04 | A base deve rodar após desligar e ligar de novo. |


Antes de programar, escolha 3 regras acima e escreva exemplos:

- Exemplo correto;
- Exemplo errado;
- Mensagem de erro esperada.

---

## 11. Entidades conceituais da semana

Estas são as entidades ou conceitos que provavelmente aparecerão no banco, no backend ou no frontend:

- SystemHealth
- EnvironmentConfig

Para cada entidade, escreva:

- Quais campos ela precisa ter?
- Quem pode criar?
- Quem pode editar?
- Quem pode visualizar?
- Ela deve ser apagada ou apenas inativada?
- Ela pertence a uma barbearia específica?

---

## 12. Fluxo principal da semana

1. Usuário inicia o fluxo principal da semana.
2. Frontend envia dados para o backend.
3. Controller recebe a requisição.
4. Service aplica regras de negócio.
5. Repository consulta ou persiste dados.
6. Backend retorna sucesso ou erro.
7. Frontend exibe resultado claro para o usuário.

Agora desenhe esse fluxo em `docs/fluxos/semana-01.md`.

---

## 13. Telas, rotas e endpoints esperados

### Telas ou áreas do frontend

- Tela principal de base do projeto.
- Página de listagem.
- Formulário simples.
- Mensagens de erro e sucesso.

### Endpoints prováveis

| Método | Rota provável | Finalidade |
|---|---|---|
| GET | /health | Consultar/listar dados principais da semana |
| POST | /health | Criar registro ou iniciar ação principal |
| PATCH | /health/{id} | Atualizar status ou dados |
| DELETE | /health/{id} | Cancelar, remover ou inativar conforme regra |


> As rotas acima são referência de planejamento. Você pode ajustar os nomes, mas precisa manter consistência e documentar sua decisão.

---

## 14. Critérios de aceite

Você só pode considerar a semana concluída quando conseguir provar que:

- [ ] RF01: O repositório deve possuir pastas backend, frontend e docs.
- [ ] RF02: O backend deve iniciar localmente e responder uma rota de saúde.
- [ ] RF03: O frontend deve iniciar localmente e exibir uma página inicial.
- [ ] RF04: Docker Compose deve subir PostgreSQL e Redis.
- [ ] RF05: README deve explicar como rodar do zero.
- [ ] A documentação da semana foi atualizada.
- [ ] O README principal continua coerente.
- [ ] O código novo não quebrou a Semana 1.
- [ ] Você consegue explicar o fluxo sem abrir o código.

---

## 15. Casos de teste manuais

Antes de usar testes automatizados, valide manualmente:

| Caso | Entrada | Resultado esperado |
|---|---|---|
| Caminho feliz | Dados válidos | Operação concluída com sucesso |
| Dados obrigatórios faltando | Campo obrigatório vazio | Erro claro de validação |
| Usuário sem permissão | Perfil não autorizado | Acesso negado |
| Dados de outra barbearia | `barbershopId` diferente | Sistema bloqueia ou não retorna dados |
| Repetição indevida | Tentar duplicar operação | Sistema impede ou trata corretamente |

---

## 16. Erros comuns de iniciante

| Erro | Por que acontece | Como evitar |
|---|---|---|
| Começar pela tela | Parece mais fácil ver algo visual | Primeiro defina regra e dados |
| Criar entidade sem regra | Pressa para codar | Escreva regras antes da classe |
| Misturar Controller e regra de negócio | Falta de separação | Controller recebe requisição; Service decide |
| Esquecer `barbershopId` | Pensar como sistema de uma única barbearia | Todo dado operacional precisa pertencer a uma barbearia |
| Não testar erro | Testar só o caminho feliz | Crie casos inválidos |
| Copiar código sem entender | Atalho perigoso | Use a Parte 2 apenas como correção |

---

## 17. Diário de aprendizado da semana

Crie ou atualize:

```txt
docs/diario/semana-01.md
```

Responda:

1. O que esta semana entrega para o produto?
2. Por que essa entrega é necessária?
3. Quais atores usam ou são impactados?
4. Quais regras de negócio foram identificadas?
5. Quais entidades parecem necessárias?
6. Quais endpoints ou telas serão criados?
7. Qual documentação oficial eu consultei?
8. Quais dúvidas ainda ficaram?
9. O que eu tentaria fazer diferente depois?
10. Qual commit fecha esta semana?

---

## 18. Checklist antes de olhar a correção

- [ ] Li a Parte 1 completa.
- [ ] Entendi o problema de negócio.
- [ ] Escrevi os requisitos com minhas palavras.
- [ ] Desenhei o fluxo principal.
- [ ] Listei entidades e campos.
- [ ] Consultei a documentação oficial.
- [ ] Tentei implementar sem copiar a correção.
- [ ] Testei pelo menos um caminho feliz.
- [ ] Testei pelo menos um erro.
- [ ] Atualizei o diário da semana.

---

# PARTE 2 — Guia com código/comandos para correção

> Use esta parte somente depois de tentar fazer sozinho.  
> Ela não é para copiar no começo. Ela serve para comparar, corrigir e entender o que faltou.

## 19. Estrutura esperada

```txt
varthex-barber/
├── backend/
├── frontend/
├── docs/
│   └── aprendizado/
├── docker-compose.yml
├── .env.example
├── .gitignore
└── README.md
```

---

## 20. Comandos de verificação

```bash
cp .env.example .env
docker compose up -d --build
docker compose ps
curl http://localhost:8080/health
```

---

## 21. Trecho de referência para correção

```java
// HealthController.java
@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping
    public Map<String, String> health() {
        return Map.of("status", "ok", "app", "Varthex Barber API");
    }
}

// .env.example
POSTGRES_DB=varthex_barber
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
DATABASE_URL=jdbc:postgresql://postgres:5432/varthex_barber
REDIS_HOST=redis
REDIS_PORT=6379
```

---

## 22. Como validar a correção

- [ ] Fluxo principal funciona do início ao fim.
- [ ] Permissões básicas são respeitadas.
- [ ] Erros comuns foram tratados.
- [ ] Documentação da semana foi atualizada.
- [ ] Você consegue explicar o que fez sem olhar código.

---

## 23. Commit sugerido

```bash
git add .
git commit -m "feat: conclui semana 01 - base-do-projeto"
```

Se a semana alterou apenas documentação:

```bash
git add docs
git commit -m "docs: detalha aprendizado da semana 01"
```

---

## 24. Resultado esperado ao final

Ao final da Semana 01, você deve conseguir explicar:

- qual problema real foi resolvido;
- quais requisitos foram atendidos;
- quais regras de negócio foram implementadas;
- quais entidades foram criadas ou impactadas;
- quais endpoints/telas foram necessários;
- como validar manualmente a entrega;
- onde consultar a documentação oficial para revisar o assunto.
