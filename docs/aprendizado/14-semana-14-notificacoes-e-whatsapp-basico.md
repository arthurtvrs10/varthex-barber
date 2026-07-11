# Semana 14 — Notificações e WhatsApp básico

**Período:** 05/10/2026 a 09/10/2026  
**Entrega:** Notificações internas e mensagens de confirmação/lembrete.  
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

Notificações internas e mensagens de confirmação/lembrete.

O objetivo não é apenas "fazer funcionar". O objetivo é entender **por que essa parte existe no software**, quais decisões precisam ser tomadas e como validar se a entrega está correta.

---

## 2. Por que esta semana é necessária?

Prepara o sistema para mensagens internas e integração futura com WhatsApp.

### Problema de negócio

Comunicação reduz faltas, melhora organização do barbeiro e dá controle ao dono.

### Consequência de não fazer direito

Se esta semana for feita sem análise, o sistema pode ficar com regras confusas, dados duplicados, telas que não fecham o fluxo real da barbearia e código difícil de corrigir nas próximas semanas.

---

## 3. Quem usa ou é impactado?

- Cliente
- Barbeiro
- Admin/Dono

Para cada ator, responda no seu diário:

- O que essa pessoa precisa fazer?
- O que essa pessoa não pode fazer?
- Qual erro prejudicaria mais essa pessoa?
- Qual informação precisa aparecer na tela?
- Qual informação precisa ser protegida?

---

## 4. Escopo da semana

### Entra no escopo

- Criar notificações internas.
- Criar templates.
- Criar fila de mensagens.
- Registrar status de envio.
- Simular confirmação/lembrete.

### Não entra no escopo agora

- Refinamentos visuais avançados
- Otimizações profundas
- Integrações pagas reais antes do fluxo local
- Automações fora do escopo da semana

Essa separação evita tentar fazer tudo ao mesmo tempo.

---

## 5. O que você precisa aprender antes de implementar

- Começar por notificação interna.
- Criar templates.
- Criar outbox.
- Controller
- Service
- Repository
- DTO
- validação
- teste manual

Explique cada item com suas palavras antes de codar. Se você não consegue explicar, ainda não está pronto para implementar.

---

## 6. Onde achar para conseguir aplicar

| O que preciso fazer | Onde achar | O que procurar |
|---|---|---|
| Spring Boot | https://docs.spring.io/spring-boot/documentation.html | Ler a seção relacionada e anotar como aplicar no projeto. |
| Redis | https://redis.io/docs/latest/ | Conexão, PING, cache, filas e estruturas básicas. |
| WhatsApp Cloud API | https://developers.facebook.com/docs/whatsapp/cloud-api | Ler a seção relacionada e anotar como aplicar no projeto. |
| Next.js | https://nextjs.org/docs | Criar páginas, rotas e consumir o backend. |


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

1. Começar por notificação interna.
2. Criar templates.
3. Criar outbox.
4. Usar Redis para fila/cache.
5. Simular envio antes do provedor real.

---

## 8. Requisitos funcionais

Requisitos funcionais descrevem **o que o sistema deve fazer**.

| Código | Descrição |
|---|---|
| RF01 | Criar notificações internas. |
| RF02 | Criar templates. |
| RF03 | Criar fila de mensagens. |
| RF04 | Registrar status de envio. |
| RF05 | Simular confirmação/lembrete. |


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
| RN01 | Envio deve ser assíncrono. |
| RN02 | Mensagem duplicada deve ser evitada. |
| RN03 | WhatsApp real depende de provedor/token. |


Antes de programar, escolha 3 regras acima e escreva exemplos:

- Exemplo correto;
- Exemplo errado;
- Mensagem de erro esperada.

---

## 11. Entidades conceituais da semana

Estas são as entidades ou conceitos que provavelmente aparecerão no banco, no backend ou no frontend:

- Notification
- MessageTemplate
- MessageOutbox

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

Agora desenhe esse fluxo em `docs/fluxos/semana-14.md`.

---

## 13. Telas, rotas e endpoints esperados

### Telas ou áreas do frontend

- Tela principal de notificações e whatsapp básico.
- Página de listagem.
- Formulário simples.
- Mensagens de erro e sucesso.

### Endpoints prováveis

| Método | Rota provável | Finalidade |
|---|---|---|
| GET | /notificacoes-e-whatsapp-basico | Consultar/listar dados principais da semana |
| POST | /notificacoes-e-whatsapp-basico | Criar registro ou iniciar ação principal |
| PATCH | /notificacoes-e-whatsapp-basico/{id} | Atualizar status ou dados |
| DELETE | /notificacoes-e-whatsapp-basico/{id} | Cancelar, remover ou inativar conforme regra |


> As rotas acima são referência de planejamento. Você pode ajustar os nomes, mas precisa manter consistência e documentar sua decisão.

---

## 14. Critérios de aceite

Você só pode considerar a semana concluída quando conseguir provar que:

- [ ] RF01: Criar notificações internas.
- [ ] RF02: Criar templates.
- [ ] RF03: Criar fila de mensagens.
- [ ] RF04: Registrar status de envio.
- [ ] RF05: Simular confirmação/lembrete.
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
docs/diario/semana-14.md
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
backend/src/main/java/com/varthex/barber/
└── notificacoesewhatsappbasico/
    ├── controller/
    ├── service/
    ├── repository/
    ├── dto/
    └── model/

frontend/src/app/
└── notificacoes-e-whatsapp-basico/
```

---

## 20. Comandos de verificação

```bash
cd backend
./mvnw spring-boot:run

cd ../frontend
npm run dev

# Verificar status
git status
curl http://localhost:8080/health
```

---

## 21. Trecho de referência para correção

```java
public enum MessageStatus { PENDING, SENT, FAILED, CANCELED }

public record MessageJob(UUID messageId, String channel) {}
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
git commit -m "feat: conclui semana 14 - notificacoes-e-whatsapp-basico"
```

Se a semana alterou apenas documentação:

```bash
git add docs
git commit -m "docs: detalha aprendizado da semana 14"
```

---

## 24. Resultado esperado ao final

Ao final da Semana 14, você deve conseguir explicar:

- qual problema real foi resolvido;
- quais requisitos foram atendidos;
- quais regras de negócio foram implementadas;
- quais entidades foram criadas ou impactadas;
- quais endpoints/telas foram necessários;
- como validar manualmente a entrega;
- onde consultar a documentação oficial para revisar o assunto.
