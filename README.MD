# dio-product-catalog

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

A aplicação shopping-cart possui um banco de dados H2, então não é necessário iniciar o mesmo separadamente.

### Rodando as aplicações principais

O projeto é composto por vários microsserviços.

- **product-catalog**: uma API REST que manipula produtos, consumindo um banco de dados Elastic Search.
  Rodando por padrão em `8081`.
- **shopping-cart**: uma API REST que manipula carrinhos de compra.
  Rodando por padrão em `8082`.
- **config-server**: aplicação que fornece as configurações para as demais APIs.
  Rodando por padrão em `8888`.

Para rodar cada um dos serviços, é necessário acessar o projeto referente a cada um e utilizar o comando:

```bash
gradle bootRun
```
