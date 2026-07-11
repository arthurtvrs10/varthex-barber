# 12 — Modelagem do Banco de Dados

## Banco definido

O banco principal será **PostgreSQL**.

## Entidades principais

### User

Representa um usuário do sistema.

Campos esperados:

- id;
- nome;
- e-mail;
- telefone;
- senha criptografada;
- perfil;
- status;
- data de criação.

### Barbershop

Representa uma barbearia dentro do SaaS.

Campos esperados:

- id;
- nome;
- documento;
- telefone;
- endereço;
- status;
- plano atual;
- link de avaliação Google.

### Barber

Representa um barbeiro.

Campos esperados:

- id;
- barbearia;
- usuário vinculado;
- comissão padrão;
- status;
- permissões.

### Client

Representa um cliente.

Campos esperados:

- id;
- barbearia;
- nome;
- telefone;
- e-mail;
- data de nascimento;
- observações;
- pontos de fidelidade;
- data do último corte.

### Service

Representa um serviço da barbearia.

Campos esperados:

- id;
- barbearia;
- nome;
- descrição;
- preço;
- duração;
- status.

### Appointment

Representa um agendamento.

Campos esperados:

- id;
- barbearia;
- cliente;
- barbeiro;
- serviço;
- data;
- horário inicial;
- horário final;
- status;
- valor;
- observações.

### ScheduleBlock

Representa bloqueio de horário.

Campos esperados:

- id;
- barbearia;
- barbeiro;
- data;
- horário inicial;
- horário final;
- motivo;
- criado por.

### Product

Representa produto de estoque.

Campos esperados:

- id;
- barbearia;
- nome;
- categoria;
- preço de custo;
- preço de venda;
- quantidade;
- estoque mínimo;
- status.

### Commission

Representa uma comissão.

Campos esperados:

- id;
- barbeiro;
- atendimento;
- valor bruto;
- percentual;
- valor da comissão;
- status de pagamento.

## Regra de isolamento SaaS

Todas as tabelas de negócio devem ter relação com a barbearia.

Isso evita que uma barbearia acesse dados de outra.

