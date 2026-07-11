# 14 — Segurança com Java e Spring

## Ferramenta principal

A segurança do backend será feita com **Spring Security**.

## Requisitos de segurança

- Login com e-mail e senha.
- Senha criptografada.
- Autenticação com JWT.
- Proteção de rotas privadas.
- Controle de permissões por perfil.
- Isolamento por barbearia.
- Validação de dados.
- Tratamento padronizado de erros.
- Logs de ações importantes.

## Perfis

- SUPER_ADMIN
- ADMIN
- BARBER
- CLIENT

## Regras importantes

- O SuperAdmin pode acessar dados globais.
- O Admin só acessa sua barbearia.
- O Barbeiro só acessa sua agenda e dados permitidos.
- O Cliente só acessa seus próprios dados.

## Senhas

As senhas nunca devem ser salvas em texto puro.

O backend deve usar algoritmo seguro de hash, como BCrypt.

## JWT

O token JWT deve carregar informações mínimas:

- id do usuário;
- perfil;
- id da barbearia, quando aplicável;
- data de expiração.

## Cuidado importante

Nunca coloque segredos no GitHub.

Exemplos que não devem ir para o GitHub:

- senha do banco;
- chave JWT real;
- token do WhatsApp;
- credenciais Google;
- chaves de pagamento.

