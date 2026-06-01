# Cliente API

API REST simples feita com Java Spring Boot para gerenciar clientes de uma loja.

Este projeto usa uma lista em memória para simular um banco de dados, seguindo a separação em camadas:

- `model`: classe `Cliente`
- `service`: regras e manipulação da lista em memória
- `controller`: rotas HTTP da API

## Tecnologias

- Java 17
- Spring Boot
- Maven
- Spring Web

## Como executar

No terminal, dentro da pasta do projeto, rode:

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080/clientes
```

## Endpoints

### Listar clientes

```http
GET /clientes
```

Exemplo usando curl:

```bash
curl -X GET http://localhost:8080/clientes
```

### Criar cliente

```http
POST /clientes
```

Body JSON:

```json
{
  "nome": "Lucas",
  "email": "lucas@email.com",
  "idade": 20
}
```

Exemplo usando curl:

```bash
curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{"nome":"Lucas","email":"lucas@email.com","idade":20}'
```

Retorna `201 Created`.

### Atualizar cliente

```http
PUT /clientes/{id}
```

Body JSON:

```json
{
  "nome": "Lucas Coelho",
  "email": "lucas.coelho@email.com",
  "idade": 21
}
```

Exemplo usando curl:

```bash
curl -X PUT http://localhost:8080/clientes/1 \
  -H "Content-Type: application/json" \
  -d '{"nome":"Lucas Coelho","email":"lucas.coelho@email.com","idade":21}'
```

Se o ID não existir, retorna `404 Not Found`.

### Remover cliente

```http
DELETE /clientes/{id}
```

Exemplo usando curl:

```bash
curl -X DELETE http://localhost:8080/clientes/1
```

Se remover com sucesso, retorna `204 No Content`.
Se o ID não existir, retorna `404 Not Found`.

## Observação sobre testes

O navegador executa requisições `GET` facilmente, mas para testar `POST`, `PUT` e `DELETE`, use ferramentas como Postman ou Insomnia.
