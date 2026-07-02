# Software SaaS para Barbearia

Documentação inicial de produto, negócio e tecnologia para criação de um sistema completo de barbearia em modelo SaaS.

O sistema contempla:

- Agendamento de cortes e serviços.
- Cadastro de clientes, barbeiros, donos/admins e superadmin.
- Horários de funcionamento.
- Bloqueio e desbloqueio de horários.
- Agendamento recorrente.
- Fila de espera para dias intensos.
- Estoque de produtos.
- Programa de fidelidade.
- Planos para clientes.
- CRM via WhatsApp.
- Menu automatizado no WhatsApp.
- Notificações internas e externas.
- Cálculo de comissão por barbeiro.
- Dashboard diário, semanal e mensal.
- Fechamento financeiro.
- Integração com Google Agenda.
- Envio de link de avaliação do Google.
- Lembretes de corte.
- Regras de monetização para vender o sistema.
- Controle de dispositivos por barbeiro.

---

## Estrutura da documentação

```txt
barbearia-saas-docs/
├── README.md
├── docs/
│   ├── 00-indice-geral.md
│   ├── produto/
│   │   ├── 01-visao-geral.md
│   │   ├── 02-escopo-do-produto.md
│   │   ├── 03-perfis-e-permissoes.md
│   │   ├── 04-requisitos-funcionais.md
│   │   ├── 05-regras-de-negocio.md
│   │   ├── 06-requisitos-nao-funcionais.md
│   │   └── 07-mvp-versoes.md
│   ├── negocio/
│   │   ├── 08-monetizacao-saas.md
│   │   ├── 09-planos-e-limites.md
│   │   └── 10-metricas-e-dashboards.md
│   ├── tecnico/
│   │   ├── 11-arquitetura-tecnica.md
│   │   ├── 12-modelagem-banco-de-dados.md
│   │   ├── 13-apis-e-contratos.md
│   │   ├── 14-seguranca.md
│   │   ├── 15-notificacoes-filas-e-jobs.md
│   │   └── 16-devops-deploy.md
│   ├── telas/
│   │   ├── 17-mapa-de-telas.md
│   │   └── 18-fluxos-principais.md
│   ├── integracoes/
│   │   ├── 19-whatsapp-crm.md
│   │   ├── 20-google-agenda.md
│   │   ├── 21-google-avaliacoes.md
│   │   └── 22-pagamentos.md
│   └── roadmap/
│       ├── 23-passo-a-passo-desenvolvimento.md
│       ├── 24-cronograma-com-datas.md
│       └── 25-checklist-entregas.md
└── .github/
    └── ISSUE_TEMPLATE/
        ├── bug_report.md
        ├── feature_request.md
        └── task.md
```

---

## Ordem recomendada de leitura

1. `docs/00-indice-geral.md`
2. `docs/produto/01-visao-geral.md`
3. `docs/produto/02-escopo-do-produto.md`
4. `docs/roadmap/23-passo-a-passo-desenvolvimento.md`
5. `docs/roadmap/24-cronograma-com-datas.md`
6. `docs/tecnico/11-arquitetura-tecnica.md`
7. `docs/tecnico/12-modelagem-banco-de-dados.md`
8. `docs/tecnico/13-apis-e-contratos.md`

---

## Data base do cronograma

O cronograma começa em **06/07/2026**.

A documentação foi organizada considerando um desenvolvimento por etapas, ideal para quem ainda está aprendendo e quer construir o sistema com segurança.
# varthex-barber
