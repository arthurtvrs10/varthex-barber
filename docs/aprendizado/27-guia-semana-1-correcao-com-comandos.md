# 27 — Guia Semana 1 de Correção com Comandos

Este arquivo serve para comparar com o que você fez.

Ele não entrega código de backend ou frontend pronto. Ele mostra apenas comandos e estrutura esperada para organizar o repositório.

---

## 1. Clonar o repositório

```bash
git clone https://github.com/arthurtvrs10/varthex-barber.git
cd varthex-barber
```

## 2. Criar uma branch para a atualização da documentação

```bash
git checkout -b docs/java-stack
```

## 3. Estrutura esperada da documentação

```txt
varthex-barber/
├── README.md
├── CONTRIBUTING.md
├── .gitignore
├── docs/
│   ├── 00-indice-geral.md
│   ├── produto/
│   ├── negocio/
│   ├── tecnico/
│   ├── telas/
│   ├── integracoes/
│   ├── roadmap/
│   └── aprendizado/
└── .github/
    └── ISSUE_TEMPLATE/
```

## 4. Atualizar documentação para Java

Garanta que os arquivos técnicos citem:

- Java 21;
- Spring Boot;
- Spring Security;
- JWT;
- PostgreSQL;
- Redis;
- Docker Compose;
- Next.js no frontend.

## 5. Conferir alterações

```bash
git status
```

## 6. Adicionar arquivos

```bash
git add README.md CONTRIBUTING.md .gitignore docs .github
```

## 7. Criar commit

```bash
git commit -m "docs: atualiza documentação para Java Spring Boot"
```

## 8. Enviar para o GitHub

```bash
git push -u origin docs/java-stack
```

## 9. Criar Pull Request

No GitHub, crie um Pull Request da branch:

```txt
docs/java-stack → main
```

Título sugerido:

```txt
docs: atualiza stack do projeto para Java Spring Boot
```

Descrição sugerida:

```txt
Esta atualização ajusta a documentação do Varthex Barber para definir Java + Spring Boot como backend oficial do projeto, mantendo Next.js no frontend, PostgreSQL como banco principal, Redis para cache/filas/jobs e Docker Compose para ambiente local.
```

