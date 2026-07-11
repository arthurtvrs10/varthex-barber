# Semana 12 — Estoque

**Período:** 21/09/2026 a 25/09/2026  
**Entrega:** Produtos, entrada, venda e alerta de estoque baixo.

## Como usar este arquivo

Este arquivo foi feito para ser aberto somente na semana correspondente. A ordem é obrigatória:

1. Leia o **guia prático sem código**.
2. Tente fazer sozinho.
3. Registre dúvidas e erros.
4. Só no final use o **guia com código para correção**.

---

# Parte 1 — Guia prático sem código

## Objetivo da semana

Entregar **Estoque** sem pular o processo de entendimento.

## Critérios de aceite

- Venda reduz estoque e pode gerar alerta.

## Tarefas da semana

- CRUD de produtos.
- Entrada de estoque.
- Venda.
- Saída.
- Estoque mínimo.
- Alerta.
- Comissão sobre produto.

## O que você precisa aprender antes de implementar

- Estoque atual e movimentações.
- Entrada, saída e venda.
- Preço de custo, venda e lucro.
- Estoque mínimo.
- Comissão sobre produto.

## Documentação oficial para consultar

- [Spring Boot — Reference](https://docs.spring.io/spring-boot/reference/index.html)
- [Spring Data JPA — Reference](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [PostgreSQL — Documentation](https://www.postgresql.org/docs/)

## Guia prático sem código

1. Registre movimentações, não só quantidade.
2. Separe produto e venda.
3. Defina regra para estoque negativo.
4. Crie alerta de estoque baixo.
5. Associe venda a cliente/barbeiro quando existir.

## Exercício antes de programar

Crie ou atualize um arquivo de diário, por exemplo:

```txt
docs/diario/semana-12.md
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
backend/src/main/java/com/varthex/barber/
├── products/
├── inventory/
└── productSales/
```

## Comandos de verificação

```bash
curl -X POST http://localhost:8080/products   -H "Authorization: Bearer SEU_TOKEN"   -H "Content-Type: application/json"   -d '{"name":"Pomada modeladora","costPrice":18.00,"salePrice":35.00,"stock":10,"minimumStock":3}' 
```

## Código ou trecho de referência para correção

```txt
public enum InventoryMovementType {
    IN,
    OUT,
    SALE,
    ADJUSTMENT
}

if (product.getStock() < quantity) {
    throw new BusinessException("Estoque insuficiente.");
}
product.decreaseStock(quantity);
```

## Como validar a correção

- Produto é criado.
- Entrada aumenta estoque.
- Venda reduz estoque.
- Estoque baixo gera alerta.
