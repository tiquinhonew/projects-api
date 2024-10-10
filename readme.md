# Projeto Java com Spring Boot e MySQL

Este projeto é uma aplicação desenvolvida em Java utilizando o framework Spring Boot, com uma integração de banco de dados MySQL. A aplicação usa Docker para subir as dependências de forma rápida e fácil, facilitando o desenvolvimento e a implantação.

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente:

- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) ou versão compatível
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Estrutura do Projeto

- **src/**: Contém o código-fonte da aplicação.
- **docker/**: Contém os arquivos Docker necessários para configurar o ambiente de banco de dados.
  - `docker-compose-dependencies.yml`: Arquivo Docker Compose que define os serviços necessários para a aplicação, como o banco MySQL.

## Configuração do Banco de Dados

A aplicação utiliza MySQL como banco de dados. A configuração do MySQL está definida no arquivo `docker/docker-compose-dependencies.yml`, que inclui:

- Um contêiner MySQL com as variáveis de ambiente padrão, como `MYSQL_ROOT_PASSWORD`, `MYSQL_DATABASE`, etc.

Para iniciar o banco de dados, execute o seguinte comando:

```bash
docker-compose -f docker/docker-compose-dependencies.yml up -d
```

Para parar o banco de dados, execute o seguinte comando:

```bash
docker-compose -f docker/docker-compose-dependencies.yml down
```

## Executando a Aplicação

Para executar a aplicação, execute o seguinte comando:

```bash
./mvnw spring-boot:run
```

### Utilizando Docker
É possível executar a aplicação utilizando Docker com o seguinte comando:

```bash
docker-compose -f docker/docker-compose.yml up
```

A aplicação estará disponível em `http://localhost:8080`.

## Documentação da API

A documentação da API está disponível em `http://localhost:8080/swagger-ui/index.html`.

## Licença

Este projeto é distribuído sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter mais informações.
