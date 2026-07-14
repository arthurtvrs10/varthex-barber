# Semana 02 — Autenticação — Documento de Requisitos Sem Código

**Projeto:** Varthex Barber  
**Período da semana:** 13/07/2026 a 17/07/2026  
**Entrega da semana:** autenticação, usuários, perfis, sessão, refresh token e proteção inicial de rotas.  
**Stack planejada:** Java 21, Spring Boot, Spring Security, Spring Data JPA, PostgreSQL, Redis, Next.js e Docker Compose.  
**Tipo do documento:** análise de requisitos para orientar o desenvolvimento.  
**Regra deste documento:** não começar pelo código. Primeiro entender o problema, os dados, as regras e os fluxos.

---

## 1. Como usar este documento

Este documento foi feito para você usar como guia de trabalho da Semana 02.

A ordem recomendada é:

1. Ler o objetivo da semana.
2. Entender o problema de negócio.
3. Entender os atores impactados.
4. Ler o escopo: o que entra e o que não entra agora.
5. Estudar os conceitos necessários na documentação oficial.
6. Modelar as entidades conceituais.
7. Desenhar os fluxos principais e alternativos.
8. Definir critérios de aceite.
9. Validar manualmente o que foi feito.
10. Atualizar o diário de aprendizado e o GitHub.

Este documento não entrega código pronto. Ele entrega clareza para você conseguir implementar com consciência.

---

## 2. Objetivo da Semana 02

O objetivo da Semana 02 é criar a base de autenticação do Varthex Barber.

Isso significa permitir que uma pessoa acesse o sistema com e-mail e senha, que o sistema identifique quem ela é, qual perfil ela possui e quais áreas iniciais ela pode acessar.

A entrega não é apenas uma tela de login. A entrega real é a base de segurança que vai sustentar todas as próximas semanas.

Ao final da semana, o sistema deve estar preparado para responder perguntas como:

- Quem está tentando acessar?
- Esse usuário existe?
- A senha informada está correta?
- Esse usuário está ativo?
- Qual é o perfil desse usuário?
- Esse usuário pertence a qual barbearia?
- Esse usuário pode acessar esta rota?
- A sessão desse usuário ainda é válida?
- O token expirou?
- O usuário fez logout?

---

## 3. Por que autenticação é necessária no Varthex Barber?

O Varthex Barber será um sistema SaaS para barbearias.

Ele terá informações sensíveis como:

- dados de clientes;
- telefone de clientes;
- agenda de atendimentos;
- faturamento diário, semanal e mensal;
- comissão de barbeiros;
- histórico de serviços;
- produtos em estoque;
- planos pagos;
- mensagens de WhatsApp;
- dados de diferentes barbearias usando a mesma plataforma.

Sem autenticação, qualquer pessoa poderia acessar ou alterar dados importantes.

A autenticação é o primeiro bloqueio de segurança do sistema. Ela identifica o usuário e abre caminho para a autorização, que define o que esse usuário pode ou não pode fazer.

---

## 4. Diferença entre autenticação e autorização

### Autenticação

Autenticação responde à pergunta: **quem é você?**

Exemplo no Varthex Barber:

Um usuário informa e-mail e senha. O sistema verifica se aquele e-mail existe, se a senha confere e se o usuário está ativo.

### Autorização

Autorização responde à pergunta: **o que você pode acessar?**

Exemplo no Varthex Barber:

Um barbeiro pode acessar a própria agenda, mas não deve acessar o faturamento geral da barbearia. Um cliente pode ver os próprios agendamentos, mas não pode cadastrar outros barbeiros.

### Por que separar os dois conceitos?

Porque estar logado não significa poder acessar tudo.

No sistema, um usuário logado ainda precisa ser validado pelo perfil, pela barbearia e pelas regras de acesso.

---

## 5. Escopo da Semana 02

### 5.1 Entra no escopo

Nesta semana, você deve planejar e implementar apenas a base de autenticação.

Entram no escopo:

- usuário com e-mail e senha;
- senha armazenada de forma segura;
- perfis de acesso;
- status do usuário;
- login;
- geração de access token;
- geração de refresh token;
- renovação de sessão;
- logout;
- identificação do usuário logado;
- proteção inicial de rotas;
- tela de login no frontend;
- redirecionamento de usuário sem sessão;
- documentação da decisão técnica.

### 5.2 Não entra no escopo agora

Não tente fazer tudo nesta semana.

Ficam fora do escopo da Semana 02:

- recuperação de senha;
- autenticação em dois fatores;
- login com Google;
- login com WhatsApp;
- permissões granulares avançadas;
- cadastro completo de barbeiros;
- cadastro completo de clientes;
- planos SaaS;
- cobrança;
- bloqueio por inadimplência;
- auditoria completa;
- painel avançado de permissões.

Essas funções podem ser planejadas, mas não precisam ser implementadas agora.

---

## 6. Atores impactados

| Ator | Impacto da autenticação | O que precisa acessar inicialmente | O que não pode acessar |
|---|---|---|---|
| SuperAdmin | Entra na plataforma para controlar o SaaS | Área global da plataforma | Dados privados sem regra clara ou ações sem auditoria |
| Admin/Dono | Entra para gerenciar a própria barbearia | Dashboard, barbeiros, clientes, agenda e financeiro da própria barbearia | Dados de outras barbearias |
| Barbeiro | Entra para visualizar agenda e informações próprias | Agenda própria, atendimentos e comissões próprias | Financeiro geral sem permissão |
| Cliente | Entra para agendar e acompanhar dados próprios | Próprios agendamentos, histórico e perfil | Dados de outros clientes ou da barbearia |

---

## 7. Perfis necessários

Os perfis iniciais do sistema devem ser:

| Perfil | Nome conceitual | Descrição |
|---|---|---|
| SUPER_ADMIN | Super administrador da plataforma | Gerencia o SaaS inteiro, barbearias, planos e recursos globais |
| ADMIN | Dono ou gerente da barbearia | Gerencia a própria barbearia, equipe, clientes, agenda e financeiro |
| BARBER | Barbeiro | Acessa agenda própria, atendimentos e comissões próprias |
| CLIENT | Cliente | Agenda horários, vê histórico e acompanha informações pessoais |

### Observação importante

Nesta semana, você não precisa criar todas as telas de cada perfil. Mas precisa salvar o perfil do usuário e conseguir identificar esse perfil depois do login.

---

## 8. Entidades necessárias para autenticação

Para a autenticação funcionar de forma organizada, o sistema precisa de algumas entidades conceituais.

As entidades mínimas são:

- User;
- Role;
- UserStatus;
- RefreshToken;
- Barbershop, de forma inicial ou preparada para a próxima semana.

Também é recomendado documentar, para o futuro:

- AuthLog;
- PasswordResetToken.

---

## 9. Entidade User

### 9.1 O que é

User representa qualquer pessoa que consegue acessar o sistema.

Um User pode ser SuperAdmin, Admin, Barbeiro ou Cliente.

### 9.2 Por que é necessária

Sem uma entidade de usuário, o sistema não consegue saber quem está logado, qual perfil ele possui, se a conta está ativa e a qual barbearia pertence.

### 9.3 Campos conceituais necessários

| Campo | Obrigatório? | Descrição | Observação |
|---|---|---|---|
| id | Sim | Identificador único do usuário | Deve ser único e não depender do e-mail |
| name | Sim | Nome do usuário | Usado para exibição na interface |
| email | Sim | E-mail usado no login | Deve ser único |
| passwordHash | Sim | Senha transformada em hash | Nunca salvar senha pura |
| role | Sim | Perfil do usuário | SUPER_ADMIN, ADMIN, BARBER ou CLIENT |
| status | Sim | Situação da conta | ACTIVE, INACTIVE, BLOCKED ou PENDING |
| barbershopId | Depende | Barbearia vinculada ao usuário | Obrigatório para Admin, Barbeiro e Cliente; opcional para SuperAdmin |
| createdAt | Sim | Data de criação | Ajuda em auditoria e histórico |
| updatedAt | Sim | Última atualização | Ajuda a entender alterações |
| lastLoginAt | Não | Último login realizado | Útil para segurança e gestão |

### 9.4 Regras da entidade User

| Código | Regra |
|---|---|
| USR-RN01 | O e-mail deve ser único no sistema ou único dentro da estratégia definida para o SaaS. |
| USR-RN02 | A senha nunca deve ser armazenada em texto puro. |
| USR-RN03 | A senha nunca deve aparecer em resposta da API, log, tela ou mensagem de erro. |
| USR-RN04 | Usuário inativo não pode logar. |
| USR-RN05 | Usuário bloqueado não pode logar. |
| USR-RN06 | Usuário com perfil ADMIN, BARBER ou CLIENT deve estar ligado a uma barbearia. |
| USR-RN07 | SuperAdmin pode existir sem vínculo direto com uma barbearia. |
| USR-RN08 | Exclusão física de usuário deve ser evitada no começo; prefira inativação. |

### 9.5 Perguntas que você deve responder antes de implementar

- O e-mail será único globalmente ou único por barbearia?
- Um cliente pode usar o mesmo e-mail em mais de uma barbearia?
- O SuperAdmin terá barbershopId vazio?
- Quem poderá criar o primeiro Admin?
- Quem poderá bloquear um usuário?
- Um Barbeiro também pode ser Admin?

Para a Semana 02, você pode simplificar: e-mail único globalmente e um perfil por usuário.

---

## 10. Entidade Role

### 10.1 O que é

Role representa o perfil do usuário.

Ela define a base da autorização.

### 10.2 Opções iniciais

| Role | Descrição |
|---|---|
| SUPER_ADMIN | Acesso global da plataforma |
| ADMIN | Acesso administrativo da própria barbearia |
| BARBER | Acesso operacional do barbeiro |
| CLIENT | Acesso do cliente final |

### 10.3 Regras da Role

| Código | Regra |
|---|---|
| ROLE-RN01 | Todo usuário precisa ter um perfil. |
| ROLE-RN02 | O perfil deve ser usado para proteger rotas. |
| ROLE-RN03 | O perfil deve ser retornado no login, mas sem expor dados sensíveis. |
| ROLE-RN04 | Alterar perfil de usuário deve ser uma ação restrita. |

### 10.4 Decisão recomendada para início

No começo, use perfis simples.

Não comece com uma tabela complexa de permissões granulares. Primeiro faça o sistema reconhecer os quatro perfis principais.

Permissões avançadas podem vir depois.

---

## 11. Entidade UserStatus

### 11.1 O que é

UserStatus indica se a conta pode ou não acessar o sistema.

### 11.2 Status iniciais

| Status | Significado | Pode logar? |
|---|---|---|
| ACTIVE | Usuário ativo | Sim |
| INACTIVE | Usuário desativado | Não |
| BLOCKED | Usuário bloqueado | Não |
| PENDING | Usuário pendente de ativação | Não, salvo se você decidir o contrário |

### 11.3 Regras do status

| Código | Regra |
|---|---|
| STATUS-RN01 | Somente usuário ACTIVE pode fazer login. |
| STATUS-RN02 | Usuário BLOCKED deve receber mensagem genérica de acesso negado. |
| STATUS-RN03 | Usuário INACTIVE não deve ser apagado automaticamente. |
| STATUS-RN04 | Alteração de status deve ser registrada futuramente em log. |

---

## 12. Entidade RefreshToken

### 12.1 O que é

RefreshToken representa uma sessão renovável do usuário.

O access token é usado para acessar rotas protegidas. O refresh token é usado para gerar um novo access token quando a sessão curta expira.

### 12.2 Por que é necessário

Sem refresh token, o usuário teria que fazer login com frequência. Com refresh token, o sistema mantém a experiência melhor sem deixar o access token durar tempo demais.

### 12.3 Campos conceituais necessários

| Campo | Obrigatório? | Descrição |
|---|---|---|
| id | Sim | Identificador único do refresh token |
| token | Sim | Valor do refresh token ou sua versão segura |
| userId | Sim | Usuário dono do token |
| expiresAt | Sim | Data de expiração |
| revokedAt | Não | Data de revogação |
| createdAt | Sim | Data de criação |
| deviceInfo | Não | Identificação aproximada do dispositivo |
| ipAddress | Não | IP de origem do login |

### 12.4 Regras do RefreshToken

| Código | Regra |
|---|---|
| RT-RN01 | Todo refresh token deve pertencer a um usuário. |
| RT-RN02 | Refresh token vencido não pode gerar novo access token. |
| RT-RN03 | Refresh token revogado não pode ser reutilizado. |
| RT-RN04 | Logout deve revogar o refresh token atual. |
| RT-RN05 | Cada login pode gerar um novo refresh token. |
| RT-RN06 | Refresh token ajuda futuramente no controle de dispositivos. |

### 12.5 Decisão para estudante

Para começar, você pode salvar um refresh token por login.

Depois, quando o sistema evoluir, você pode limitar quantidade de dispositivos por usuário ou por barbeiro.

---

## 13. Entidade Barbershop no contexto da autenticação

### 13.1 O que é

Barbershop representa uma barbearia cliente da plataforma.

### 13.2 Por que aparece na autenticação

O Varthex Barber é SaaS. Isso significa que várias barbearias podem usar o mesmo sistema.

Então, o usuário não deve ser identificado apenas pelo e-mail. O sistema também precisa saber a qual barbearia aquele usuário pertence.

### 13.3 Campos mínimos para esta etapa

| Campo | Obrigatório? | Descrição |
|---|---|---|
| id | Sim | Identificador único da barbearia |
| name | Sim | Nome da barbearia |
| status | Sim | Status da barbearia |
| createdAt | Sim | Data de criação |
| updatedAt | Sim | Data de atualização |

### 13.4 Regras relacionadas à autenticação

| Código | Regra |
|---|---|
| BARB-RN01 | Usuários operacionais pertencem a uma barbearia. |
| BARB-RN02 | SuperAdmin pode não pertencer a nenhuma barbearia específica. |
| BARB-RN03 | Usuário de uma barbearia não deve acessar dados de outra barbearia. |
| BARB-RN04 | Barbearia inativa pode impedir login dos usuários operacionais. |

### 13.5 Observação sobre a Semana 03

A Semana 03 vai aprofundar SaaS base, SuperAdmin, barbearias e isolamento por barbearia.

Na Semana 02, basta deixar a autenticação preparada para carregar ou considerar o vínculo com a barbearia.

---

## 14. Entidade AuthLog para evolução profissional

### 14.1 O que é

AuthLog representa o registro de eventos de autenticação.

Essa entidade não precisa ser obrigatória na Semana 02, mas é recomendada como evolução profissional.

### 14.2 Por que é útil

Ela ajuda a entender:

- quem tentou logar;
- quando tentou;
- se a tentativa deu certo;
- se a senha estava errada;
- se o usuário estava bloqueado;
- de qual IP veio a tentativa;
- se existem muitas tentativas suspeitas.

### 14.3 Campos conceituais

| Campo | Obrigatório? | Descrição |
|---|---|---|
| id | Sim | Identificador do log |
| email | Sim | E-mail informado na tentativa |
| userId | Não | Usuário encontrado, se existir |
| success | Sim | Indica se a tentativa deu certo |
| reason | Sim | Motivo do sucesso ou falha |
| ipAddress | Não | IP de origem |
| userAgent | Não | Navegador ou dispositivo |
| createdAt | Sim | Data da tentativa |

### 14.4 Motivos possíveis

| Motivo | Significado |
|---|---|
| LOGIN_SUCCESS | Login realizado com sucesso |
| USER_NOT_FOUND | E-mail não encontrado |
| INVALID_PASSWORD | Senha incorreta |
| USER_INACTIVE | Usuário inativo |
| USER_BLOCKED | Usuário bloqueado |
| TOKEN_EXPIRED | Token expirado |
| REFRESH_TOKEN_REVOKED | Refresh token revogado |

---

## 15. PasswordResetToken para evolução futura

### 15.1 O que é

PasswordResetToken representa um token temporário para recuperação de senha.

### 15.2 Por que não entra agora

Recuperação de senha exige fluxo de e-mail, expiração, validação e proteção contra abuso.

Como a Semana 02 já envolve login, hash, JWT, refresh token e proteção de rotas, recuperação de senha deve ficar para depois.

### 15.3 Campos futuros

| Campo | Descrição |
|---|---|
| id | Identificador único |
| token | Token de recuperação |
| userId | Usuário dono do pedido |
| expiresAt | Data de expiração |
| usedAt | Data em que foi usado |
| createdAt | Data de criação |

---

## 16. Relacionamentos conceituais

### 16.1 Barbershop e User

Uma barbearia pode ter vários usuários.

Um usuário operacional pertence a uma barbearia.

Relação conceitual:

Barbershop tem muitos Users.

User pertence a uma Barbershop, exceto SuperAdmin.

### 16.2 User e RefreshToken

Um usuário pode ter vários refresh tokens.

Um refresh token pertence a um usuário.

Isso permite que o mesmo usuário esteja logado em mais de um dispositivo, se a regra do plano permitir no futuro.

### 16.3 User e AuthLog

Um usuário pode ter vários logs de autenticação.

Um log pode ou não ter usuário vinculado, porque uma tentativa com e-mail inexistente não encontra usuário.

---

## 17. Dados que não devem ser expostos

A autenticação deve tomar cuidado com dados sensíveis.

Nunca retornar:

- senha pura;
- hash da senha;
- segredo JWT;
- token interno usado pelo backend;
- informações de erro muito específicas;
- dados de outra barbearia;
- dados pessoais desnecessários.

### Mensagens seguras

Em caso de erro de login, prefira uma mensagem genérica:

Credenciais inválidas.

Evite mensagens como:

- e-mail não existe;
- senha errada;
- esse e-mail pertence a outra barbearia.

Mensagens específicas podem ajudar atacantes a descobrir usuários válidos.

---

## 18. Requisitos funcionais

| Código | Requisito |
|---|---|
| RF-AUTH-01 | O sistema deve permitir login com e-mail e senha. |
| RF-AUTH-02 | O sistema deve identificar o usuário autenticado. |
| RF-AUTH-03 | O sistema deve armazenar senha apenas em formato seguro. |
| RF-AUTH-04 | O sistema deve retornar um access token em caso de login válido. |
| RF-AUTH-05 | O sistema deve retornar um refresh token em caso de login válido. |
| RF-AUTH-06 | O sistema deve permitir renovar sessão usando refresh token válido. |
| RF-AUTH-07 | O sistema deve permitir logout. |
| RF-AUTH-08 | O logout deve invalidar o refresh token usado. |
| RF-AUTH-09 | O sistema deve permitir consultar os dados seguros do usuário logado. |
| RF-AUTH-10 | O sistema deve bloquear acesso a rotas protegidas sem token válido. |
| RF-AUTH-11 | O sistema deve identificar o perfil do usuário logado. |
| RF-AUTH-12 | O frontend deve ter uma tela de login. |
| RF-AUTH-13 | O frontend deve redirecionar usuário sem sessão para o login. |
| RF-AUTH-14 | O frontend deve exibir mensagem clara quando o login falhar. |
| RF-AUTH-15 | O sistema deve preparar a autenticação para isolamento por barbearia. |

---

## 19. Requisitos não funcionais

| Código | Requisito |
|---|---|
| RNF-AUTH-01 | A autenticação deve ser simples de entender e manter por um estudante. |
| RNF-AUTH-02 | A senha não deve ser recuperável depois de salva. |
| RNF-AUTH-03 | O access token deve ter tempo de expiração. |
| RNF-AUTH-04 | O refresh token deve ter tempo de expiração. |
| RNF-AUTH-05 | Dados sensíveis não devem aparecer em logs ou respostas. |
| RNF-AUTH-06 | Erros devem ser claros para o usuário, mas não devem revelar detalhes sensíveis. |
| RNF-AUTH-07 | O sistema deve respeitar isolamento por barbearia. |
| RNF-AUTH-08 | A autenticação deve funcionar localmente com Docker, PostgreSQL e backend Java. |
| RNF-AUTH-09 | A documentação deve ser atualizada junto com a entrega. |
| RNF-AUTH-10 | O fluxo deve ser validado manualmente antes de avançar para a Semana 03. |

---

## 20. Regras de negócio da autenticação

| Código | Regra |
|---|---|
| RN-AUTH-01 | Usuário inexistente não pode logar. |
| RN-AUTH-02 | Usuário com senha incorreta não pode logar. |
| RN-AUTH-03 | Usuário inativo não pode logar. |
| RN-AUTH-04 | Usuário bloqueado não pode logar. |
| RN-AUTH-05 | Usuário pendente não deve logar até ativação, salvo decisão contrária. |
| RN-AUTH-06 | E-mail deve ser único conforme decisão inicial do projeto. |
| RN-AUTH-07 | Senha deve ser transformada em hash antes de ser salva. |
| RN-AUTH-08 | Senha não pode ser devolvida em nenhuma resposta. |
| RN-AUTH-09 | Access token deve expirar. |
| RN-AUTH-10 | Refresh token deve expirar. |
| RN-AUTH-11 | Refresh token revogado não pode ser reutilizado. |
| RN-AUTH-12 | Logout revoga refresh token. |
| RN-AUTH-13 | Rota protegida exige token válido. |
| RN-AUTH-14 | Rotas públicas não devem exigir token. |
| RN-AUTH-15 | Dados do usuário logado devem respeitar a barbearia vinculada. |
| RN-AUTH-16 | SuperAdmin pode ter escopo global. |
| RN-AUTH-17 | Admin, Barbeiro e Cliente devem ter escopo de barbearia. |

---

## 21. Rotas conceituais da autenticação

Nesta seção, as rotas são apenas contrato de produto. Não são implementação.

| Método | Rota | Pública? | Finalidade |
|---|---|---|---|
| POST | /auth/login | Sim | Entrar com e-mail e senha |
| POST | /auth/refresh | Sim, com refresh token válido | Renovar access token |
| POST | /auth/logout | Não | Encerrar sessão do usuário logado |
| GET | /auth/me | Não | Consultar dados seguros do usuário logado |

### Dados esperados no login

O login precisa receber:

- e-mail;
- senha.

### Dados esperados na resposta segura

A resposta segura do login deve retornar:

- access token;
- refresh token;
- tipo do token;
- tempo de expiração;
- dados seguros do usuário.

### Dados seguros do usuário

Os dados seguros podem conter:

- id;
- nome;
- e-mail;
- perfil;
- status;
- barbearia vinculada, quando existir.

Nunca retornar senha ou hash da senha.

---

## 22. Rotas públicas e protegidas

### 22.1 Rotas públicas

Rotas públicas são rotas que podem ser acessadas sem usuário logado.

Na Semana 02, as rotas públicas são:

| Rota | Motivo |
|---|---|
| /auth/login | O usuário ainda não está logado |
| /auth/refresh | Usada para renovar sessão com refresh token |
| /health | Usada para verificar se a API está funcionando |

### 22.2 Rotas protegidas

Rotas protegidas exigem token válido.

Na Semana 02, as rotas protegidas são:

| Rota | Motivo |
|---|---|
| /auth/me | Precisa saber quem é o usuário logado |
| /auth/logout | Precisa encerrar a sessão do usuário atual |
| /dashboard | Área interna do sistema |

---

## 23. Fluxo principal de login

### 23.1 Caminho feliz

1. Usuário abre a tela de login.
2. Usuário informa e-mail e senha.
3. Frontend envia as credenciais para o backend.
4. Backend verifica se o e-mail existe.
5. Backend verifica se o usuário está ativo.
6. Backend compara a senha informada com a senha armazenada de forma segura.
7. Backend gera access token.
8. Backend gera refresh token.
9. Backend registra ou atualiza o refresh token.
10. Backend retorna tokens e dados seguros do usuário.
11. Frontend salva a sessão conforme decisão técnica.
12. Frontend redireciona o usuário para a área interna.
13. Área interna consulta dados do usuário logado.

### 23.2 Resultado esperado

O usuário autenticado consegue acessar uma página protegida.

---

## 24. Fluxos alternativos

### 24.1 E-mail não encontrado

1. Usuário informa um e-mail inexistente.
2. Backend não encontra usuário.
3. Backend retorna erro genérico de credenciais inválidas.
4. Frontend mostra mensagem clara sem revelar se o e-mail existe.

### 24.2 Senha incorreta

1. Usuário informa e-mail válido e senha incorreta.
2. Backend encontra o usuário.
3. Backend identifica que a senha não confere.
4. Backend retorna erro genérico de credenciais inválidas.
5. Frontend mostra mensagem de erro.

### 24.3 Usuário inativo

1. Usuário informa credenciais válidas.
2. Backend encontra o usuário.
3. Backend identifica status INACTIVE.
4. Backend bloqueia login.
5. Frontend mostra mensagem de acesso negado ou conta inativa.

### 24.4 Usuário bloqueado

1. Usuário informa credenciais válidas.
2. Backend encontra status BLOCKED.
3. Backend bloqueia login.
4. Sistema pode registrar tentativa no futuro.
5. Frontend exibe mensagem controlada.

### 24.5 Access token expirado

1. Usuário tenta acessar rota protegida com access token expirado.
2. Backend rejeita a requisição.
3. Frontend tenta renovar com refresh token, se existir.
4. Se o refresh token for válido, recebe novo access token.
5. Se o refresh token for inválido, usuário volta para o login.

### 24.6 Refresh token revogado

1. Usuário tenta renovar sessão com refresh token revogado.
2. Backend rejeita a renovação.
3. Frontend remove sessão local.
4. Usuário volta para a tela de login.

---

## 25. Requisitos para o backend

O backend deve ser responsável por:

- receber credenciais;
- validar dados obrigatórios;
- buscar usuário por e-mail;
- validar status do usuário;
- comparar senha de forma segura;
- gerar tokens;
- salvar refresh token;
- revogar refresh token no logout;
- identificar usuário logado em rotas protegidas;
- impedir acesso sem token;
- impedir acesso com token inválido;
- impedir acesso com token expirado;
- retornar respostas sem dados sensíveis.

### Componentes conceituais do backend

| Componente | Responsabilidade |
|---|---|
| AuthController | Receber requisições de autenticação |
| AuthService | Aplicar regras de login, refresh e logout |
| JwtService | Criar e validar tokens |
| UserService | Buscar e validar usuário |
| UserRepository | Consultar dados do usuário no banco |
| RefreshTokenService | Criar, validar e revogar refresh tokens |
| SecurityConfig | Definir rotas públicas e protegidas |
| AuthenticationFilter | Ler token da requisição e identificar usuário |

Esta tabela é conceitual. Ela serve para você organizar responsabilidades sem começar pelo código.

---

## 26. Requisitos para o frontend

O frontend deve ser responsável por:

- mostrar tela de login;
- validar campos obrigatórios antes de enviar;
- enviar e-mail e senha para o backend;
- mostrar mensagem de erro quando login falhar;
- salvar estado de sessão conforme decisão técnica;
- redirecionar usuário autenticado para área interna;
- impedir acesso visual a páginas protegidas sem sessão;
- chamar rota de usuário logado para confirmar sessão;
- permitir logout;
- limpar sessão no logout.

### Telas necessárias na Semana 02

| Tela | Obrigatória? | Objetivo |
|---|---|---|
| Login | Sim | Permitir entrada no sistema |
| Dashboard simples protegido | Sim | Provar que a proteção de rota funciona |
| Tela ou mensagem de erro | Sim | Mostrar falha de autenticação |

### O que não precisa no frontend agora

- dashboard completo;
- cadastro completo de usuário;
- layout final;
- controle avançado de permissões;
- menu lateral completo;
- recuperação de senha.

---

## 27. Validações necessárias

### 27.1 Validações no login

| Campo | Validação |
|---|---|
| E-mail | Obrigatório, formato de e-mail, sem espaços desnecessários |
| Senha | Obrigatória, não vazia |

### 27.2 Validações no backend

| Situação | Comportamento esperado |
|---|---|
| E-mail vazio | Retornar erro de validação |
| Senha vazia | Retornar erro de validação |
| E-mail inexistente | Retornar erro genérico de credenciais inválidas |
| Senha errada | Retornar erro genérico de credenciais inválidas |
| Usuário inativo | Bloquear login |
| Usuário bloqueado | Bloquear login |
| Token ausente | Bloquear rota protegida |
| Token inválido | Bloquear rota protegida |
| Token expirado | Bloquear rota protegida ou acionar renovação pelo frontend |

---

## 28. Mensagens de erro recomendadas

| Situação | Mensagem para o usuário | Observação |
|---|---|---|
| Login inválido | E-mail ou senha inválidos. | Não revelar qual campo está errado |
| Conta inativa | Sua conta não está ativa. Procure o responsável pela barbearia. | Pode ser útil para suporte |
| Conta bloqueada | Acesso bloqueado. Procure o administrador. | Mensagem controlada |
| Token ausente | Sessão não encontrada. Faça login novamente. | Usada no frontend |
| Token expirado | Sua sessão expirou. Faça login novamente. | Simples para o usuário |
| Erro interno | Não foi possível concluir o login agora. Tente novamente. | Evitar detalhes técnicos |

---

## 29. Segurança mínima esperada

A autenticação deve respeitar algumas decisões mínimas de segurança.

| Tema | Decisão esperada |
|---|---|
| Senha | Salvar somente hash |
| Resposta da API | Nunca retornar passwordHash |
| Logs | Nunca registrar senha |
| Token | Definir expiração |
| Refresh token | Salvar e permitir revogação |
| Erro de login | Usar mensagem genérica |
| Rotas | Separar públicas e protegidas |
| Perfil | Carregar role do usuário logado |
| Barbearia | Preparar isolamento por barbershopId |

---

## 30. Decisões que você deve registrar no GitHub

Crie ou atualize um arquivo de decisão técnica, por exemplo:

`docs/decisoes/semana-02-autenticacao.md`

Registre:

- quais perfis existem;
- se o e-mail será único globalmente ou por barbearia;
- como usuário será vinculado à barbearia;
- quais rotas são públicas;
- quais rotas são protegidas;
- qual tempo inicial de expiração do access token;
- qual tempo inicial de expiração do refresh token;
- onde o frontend vai guardar a sessão;
- como o logout deve funcionar;
- o que fica fora do escopo.

---

## 31. Ordem prática de trabalho sem código

Siga esta ordem antes de implementar:

1. Ler este documento inteiro.
2. Criar ou atualizar o diário da Semana 02.
3. Desenhar o fluxo de login no papel ou em Markdown.
4. Definir os perfis de usuário.
5. Definir os status de usuário.
6. Definir os campos da entidade User.
7. Definir os campos da entidade RefreshToken.
8. Definir como User se relaciona com Barbershop.
9. Definir rotas públicas e protegidas.
10. Definir mensagens de erro.
11. Definir casos de teste manuais.
12. Consultar documentação oficial.
13. Só então começar a implementação.

---

## 32. Documentações oficiais: onde achar para conseguir aplicar

| Necessidade | Documentação | O que procurar |
|---|---|---|
| Entender Spring Security | https://docs.spring.io/spring-security/reference/index.html | Visão geral, authentication, authorization e filtros |
| Começar com Spring Security no Spring Boot | https://docs.spring.io/spring-security/reference/servlet/getting-started.html | Configuração inicial e funcionamento padrão |
| Entender login com usuário e senha | https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html | Username/password authentication |
| Entender armazenamento seguro de senha | https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html | PasswordEncoder e armazenamento seguro |
| Entender JWT no Spring Security | https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html | JWT, bearer token e validação |
| Entender conceitos gerais do Spring Boot | https://docs.spring.io/spring-boot/documentation.html | Web, data, security e configuração |
| Entender repositórios com JPA | https://docs.spring.io/spring-data/jpa/reference/index.html | Entities, repositories e consultas |
| Entender authentication no Next.js | https://nextjs.org/docs/app/guides/authentication | Login, sessão, proteção de rotas e server/client components |
| Boas práticas de autenticação | https://cheatsheetseries.owasp.org/cheatsheets/Authentication_Cheat_Sheet.html | Segurança, mensagens de erro, senhas e sessão |

### Como estudar cada documentação

Não leia tudo de uma vez.

Para cada link, faça este exercício:

1. Abra a documentação.
2. Leia o título e a introdução.
3. Procure o tópico indicado na tabela.
4. Anote o conceito principal.
5. Escreva onde esse conceito entra no Varthex Barber.
6. Anote uma dúvida.
7. Volte para o projeto e tente aplicar.

---

## 33. Casos de teste manuais

Antes de considerar a Semana 02 pronta, teste manualmente.

| Código | Caso | Entrada | Resultado esperado |
|---|---|---|---|
| CT-AUTH-01 | Login válido | E-mail e senha corretos | Sistema retorna sessão válida |
| CT-AUTH-02 | Senha errada | E-mail correto e senha errada | Sistema nega login com mensagem genérica |
| CT-AUTH-03 | E-mail inexistente | E-mail não cadastrado | Sistema nega login com mensagem genérica |
| CT-AUTH-04 | Usuário inativo | Credenciais de usuário inativo | Sistema bloqueia login |
| CT-AUTH-05 | Usuário bloqueado | Credenciais de usuário bloqueado | Sistema bloqueia login |
| CT-AUTH-06 | Rota protegida sem token | Nenhum token enviado | Sistema nega acesso |
| CT-AUTH-07 | Rota protegida com token válido | Token válido | Sistema permite acesso |
| CT-AUTH-08 | Token expirado | Token vencido | Sistema nega ou força renovação |
| CT-AUTH-09 | Refresh token válido | Refresh token válido | Sistema gera nova sessão curta |
| CT-AUTH-10 | Refresh token revogado | Refresh token revogado | Sistema nega renovação |
| CT-AUTH-11 | Logout | Usuário logado solicita logout | Sistema encerra sessão |
| CT-AUTH-12 | Acesso de perfil errado | Usuário tenta acessar área não permitida | Sistema nega acesso |

---

## 34. Critérios de aceite da Semana 02

A Semana 02 só deve ser considerada concluída quando todos estes itens forem verdadeiros:

| Item | Critério | Status |
|---|---|---|
| CA-AUTH-01 | Usuário consegue fazer login com e-mail e senha válidos | Pendente |
| CA-AUTH-02 | Senha é armazenada de forma segura | Pendente |
| CA-AUTH-03 | Senha não aparece em resposta nem log | Pendente |
| CA-AUTH-04 | Login válido retorna access token | Pendente |
| CA-AUTH-05 | Login válido retorna refresh token | Pendente |
| CA-AUTH-06 | Refresh token permite renovar sessão | Pendente |
| CA-AUTH-07 | Logout revoga sessão | Pendente |
| CA-AUTH-08 | Rota protegida bloqueia usuário sem token | Pendente |
| CA-AUTH-09 | Rota protegida aceita usuário com token válido | Pendente |
| CA-AUTH-10 | Perfil do usuário é identificado | Pendente |
| CA-AUTH-11 | Usuário inativo não consegue logar | Pendente |
| CA-AUTH-12 | Frontend tem tela de login funcional | Pendente |
| CA-AUTH-13 | Frontend redireciona usuário sem sessão | Pendente |
| CA-AUTH-14 | Documentação foi atualizada | Pendente |
| CA-AUTH-15 | Você consegue explicar o fluxo sem abrir o código | Pendente |

---

## 35. Checklist de aprendizado antes de implementar

Marque apenas quando você realmente conseguir explicar com suas palavras.

| Item | Status |
|---|---|
| Sei explicar autenticação | Pendente |
| Sei explicar autorização | Pendente |
| Sei explicar access token | Pendente |
| Sei explicar refresh token | Pendente |
| Sei explicar por que senha precisa de hash | Pendente |
| Sei explicar por que não retornar senha | Pendente |
| Sei diferenciar rotas públicas e protegidas | Pendente |
| Sei listar os perfis do sistema | Pendente |
| Sei explicar User, Role, UserStatus e RefreshToken | Pendente |
| Sei explicar vínculo entre User e Barbershop | Pendente |
| Sei explicar o fluxo de login | Pendente |
| Sei explicar o fluxo de logout | Pendente |
| Sei explicar o fluxo de renovação de sessão | Pendente |
| Consultei a documentação oficial | Pendente |
| Atualizei o diário da semana | Pendente |

---

## 36. Erros comuns de iniciante

| Erro | Por que acontece | Como evitar |
|---|---|---|
| Começar pela tela de login | A tela parece mais fácil e visual | Primeiro entenda usuário, regra, token e sessão |
| Salvar senha pura | Falta de conhecimento de segurança | Estude Password Storage no Spring Security |
| Retornar passwordHash na API | Falta de cuidado com DTO/resposta | Defina quais dados são seguros antes de implementar |
| Misturar autenticação com cadastro completo | Escopo grande demais | Nesta semana foque em login e sessão |
| Não pensar em barbearia | Pensar como sistema de usuário único | Lembre que o produto é SaaS |
| Não separar role e status | Confundir perfil com situação da conta | Role define permissão; status define se pode acessar |
| Token sem expiração | Parece simples no começo | Todo token precisa ter tempo de vida |
| Logout sem revogar refresh token | Pensar que apagar no frontend basta | Logout também precisa invalidar no backend |
| Mensagem de erro específica demais | Tentar ajudar o usuário, mas expõe dados | Use mensagens genéricas para login inválido |
| Não testar erro | Testar apenas caminho feliz | Teste senha errada, usuário inativo e token ausente |

---

## 37. Diário da Semana 02

Crie ou atualize o arquivo:

`docs/diario/semana-02.md`

Responda:

1. O que a autenticação entrega para o produto?
2. Por que autenticação é necessária no Varthex Barber?
3. Qual é a diferença entre autenticação e autorização?
4. Quais perfis existem no sistema?
5. Quais status de usuário existem?
6. Quais campos a entidade User precisa ter?
7. Por que RefreshToken é necessário?
8. Qual é a regra para usuário inativo?
9. Quais rotas são públicas?
10. Quais rotas são protegidas?
11. Como o frontend deve se comportar quando não há sessão?
12. Quais documentações oficiais eu consultei?
13. Quais dúvidas ainda ficaram?
14. O que eu faria diferente em uma próxima versão?

---

## 38. Entrega esperada para o GitHub

Ao final da Semana 02, o repositório deve ter:

- documentação da Semana 02 atualizada;
- diário da Semana 02;
- decisões técnicas da autenticação;
- README coerente com o avanço do projeto;
- implementação validada manualmente;
- commit claro fechando a semana.

### Sugestão de commit para documentação

Mensagem sugerida:

`docs: detalha requisitos de autenticacao da semana 02`

### Sugestão de commit para implementação futura

Mensagem sugerida:

`feat: implementa base de autenticacao`

---

## 39. Resultado esperado ao final

Ao final desta semana, você deve conseguir explicar:

- o que é autenticação;
- o que é autorização;
- por que senha não pode ser salva pura;
- quais entidades sustentam login;
- como o usuário se relaciona com a barbearia;
- o que é access token;
- o que é refresh token;
- como logout deve funcionar;
- quais rotas são públicas;
- quais rotas são protegidas;
- como validar manualmente a entrega;
- onde consultar a documentação oficial para corrigir dúvidas.

Se você consegue explicar isso sem olhar código, você está pronto para implementar a autenticação com muito mais segurança.