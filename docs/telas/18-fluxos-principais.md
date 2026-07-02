# 18 — Fluxos Principais

# 1. Fluxo de agendamento pelo cliente

```mermaid
flowchart TD
    A[Cliente acessa página] --> B[Escolhe serviço]
    B --> C[Escolhe barbeiro]
    C --> D[Escolhe data]
    D --> E[Sistema mostra horários disponíveis]
    E --> F[Cliente escolhe horário]
    F --> G[Confirma dados]
    G --> H[Sistema cria agendamento]
    H --> I[Notifica cliente]
    H --> J[Notifica barbeiro]
    H --> K[Notifica dono]
```

---

# 2. Fluxo de cancelamento

```mermaid
flowchart TD
    A[Usuário solicita cancelamento] --> B[Sistema verifica permissão]
    B --> C{Pode cancelar?}
    C -->|Sim| D[Atualiza status para cancelado]
    C -->|Não| E[Mostra erro]
    D --> F[Registra motivo]
    D --> G[Notifica envolvidos]
    D --> H[Verifica fila de espera]
```

---

# 3. Fluxo de fila de espera

```mermaid
flowchart TD
    A[Cliente não encontra horário] --> B[Entra na fila]
    B --> C[Sistema registra posição]
    C --> D[Um horário é cancelado]
    D --> E[Sistema procura fila compatível]
    E --> F[Oferece vaga ao primeiro cliente]
    F --> G{Cliente respondeu?}
    G -->|Aceitou| H[Cria agendamento]
    G -->|Recusou ou expirou| I[Chama próximo]
```

---

# 4. Fluxo de comissão

```mermaid
flowchart TD
    A[Atendimento concluído] --> B[Sistema identifica barbeiro]
    B --> C[Sistema identifica serviço]
    C --> D[Busca regra de comissão]
    D --> E[Calcula valor]
    E --> F[Cria comissão pendente]
    F --> G[Mostra no dashboard]
    G --> H[Admin marca como paga]
```

---

# 5. Fluxo de estoque

```mermaid
flowchart TD
    A[Produto vendido] --> B[Sistema reduz estoque]
    B --> C{Estoque abaixo do mínimo?}
    C -->|Sim| D[Notifica Admin]
    C -->|Não| E[Finaliza venda]
    D --> E
```

---

# 6. Fluxo de avaliação Google

```mermaid
flowchart TD
    A[Atendimento concluído] --> B[Job agenda mensagem]
    B --> C[Envia WhatsApp com link]
    C --> D[Registra envio]
```

---

# 7. Fluxo de lembrete de corte

```mermaid
flowchart TD
    A[Job diário roda] --> B[Busca clientes sem corte há X dias]
    B --> C[Verifica aceite de mensagem]
    C --> D[Envia convite para agendar]
    D --> E[Registra envio]
```

---

# 8. Fluxo de controle de dispositivos

```mermaid
flowchart TD
    A[Usuário faz login] --> B[Sistema identifica dispositivo]
    B --> C{Dispositivo já registrado?}
    C -->|Sim| D[Permite acesso]
    C -->|Não| E[Conta dispositivos ativos]
    E --> F{Limite atingido?}
    F -->|Não| G[Registra novo dispositivo]
    F -->|Sim| H[Bloqueia login ou pede remoção]
```
