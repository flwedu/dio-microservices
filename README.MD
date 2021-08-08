# dio-microservices

Um simples projeto de um sistema de catálogo de produtos utilizando uma arquitetura distribuída em microsserviços.
Criado durante o **Santander Bootcamp | Fullstack Developer**, em parceria com a [Digital Innovation One](https://web.digitalinnovation.one/) em 2021.

## Tecnologias utilizadas

Para criação do projeto foram utilizadas várias tecnologias. Dentre elas as principais:

- Java 11
- SpringBoot
- Gradle
- Docker
- ElasticSearch
- Banco de dados em memória H2
- Netflix Eureka service registry

## Descrição de cada aplicação

O projeto é composto por vários microsserviços.

- **product-catalog**: uma API REST que manipula produtos, consumindo um banco de dados Elastic Search.
  Ouvindo por padrão em `8081`.
- **shopping-cart**: uma API REST que manipula carrinhos de compra.
  Ouvindo por padrão em `8082`.
- **config-server**: aplicação que fornece as configurações para as demais APIs.
  Ouvindo por padrão em `8888`. As configurações servidas às demais aplicações estão armazenadas no repositório [dio-microservices-configurations](https://github.com/flwedu/dio-microservices-configuration).
- **service-discovery**: aplicação que exibe todos os que estão rodando e pertencem a um sistema. Ouvindo por padrão em `9000`.
- **gateway**: aplicação que ouve todas as requisições para `8080`e às redireciona para a porta correspondente de acordo com a URL da requisição.
  - Requisições para `http://localhost:8080/product/` são redirecionadas para a porta do `product-catalog` (8081).
  - Requisições para `http://localhost:8080/cart/` são redirecionadas para a porta do `shopping-cart` (8082).

## Testando a aplicação

### Rodando banco de dados

Essa aplicação consome um banco de dados elasticsearch rodando em containers Docker.
Para rodar, é necessário antes instalar essas imagens:

```bash
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.13.4
```

Para rodar nas portas 9200 e 9300, esse é o comando:

```bash
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.13.4
```

![image](https://user-images.githubusercontent.com/55285816/128581861-14c7c0ee-c578-42c6-983f-30e7a9cfa924.png)

A aplicação shopping-cart possui um banco de dados H2, então não é necessário iniciar o mesmo separadamente.

### Rodando as aplicações

Para rodar cada uma das aplicações, é necessário acessar o projeto referente a cada um e utilizar o comando:

```bash
gradle bootRun
```

### Verificando lista de serviços em execução

Após o boot de cada uma das aplicações, uma lista de cada um dos endpoints disponíveis pode ser exibida em `http://localhost:9000`.

![image](https://user-images.githubusercontent.com/55285816/128581758-94107360-a492-405c-8a9f-7c2be2b978b8.png)

### Inserindo e consultando dados

A fim de testes, primeiro é necessário inserir alguns produtos.
Basta disparar uma requisição POST para `http://localhost:8080/product/` com um body JSON como no exemplo:

```json
{
  "name": "TV", // Nome do produto
  "amount": 1 // Quantidade
}
```

Uma requisição GET pode ser realizada para `http://localhost:8080/product/` afim de se obter uma lista com todos os produtos cadastrados, ou para `http://localhost:8080/product/{id}` para consultar apenas o produto com o `{id}`informado.

Depois pode se criar um novo carrinho de compras, fazendo uma requisição POST para `http://localhost:8080/cart/{id}` (será criado um carrinho com o número de Id informado em `{id}`). No body da requisição devem estar os dados do produto:

```json
{
  "id": {
    // o Id é uma PK composta
    "productId": 1,
    "cartId": 1 // deve ser o mesmo número de ID da URL
  },
  "name": "TV",
  "amount": 5
}
```

Para verificar o resultado, pode-se enviar uma requisição GET para `http://localhost:8080/cart/1`. Essa será a resposta esperada:

```json
{
  "id": 1,
  "products": [
    {
      "id": {
        "productId": 1,
        "cartId": 1
      },
      "name": "TV",
      "amount": 40
    }
  ]
}
```
