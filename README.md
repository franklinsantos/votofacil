# VotoFacil

API REST para gerenciamento de sessões de votação.

## Funcionalidades

- Cadastrar uma nova pauta
- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default)
- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta)
- Contabilizar os votos e dar o resultado da votação na pauta

#### 1 - Integração com sistemas externos
    O serviço AssociadoService possui um método verificaSeAssociadoPodeVotar para autorizar a votação do associado consumindo uma API Rest;

#### 2 - Mensageria e filas
    Foram criados produtor e consumidor de resultados usando o servidor de messageria Kafka.

#### 4 - Versionamento da API
    Os controllers foram configurados para responder com o prefixo api/v1/<endpoint>. Para as próximas versões o prefixo será incrementado em cada controller.

## Ambiente / Bibliotecas

- Java 11
- Spring Boot 2.7.6
- Mysql 5.7
- Docker 20.10.21
- Maven 3.8.1
- MapStruct
- Kafka
- Swagger
- Log4j
- JUnit
- Mockito

## Executar o projeto

- mvn clean
- mvn package
- mvn spring-boot:build-image -Dspring-boot.build-image.imageName=fsantos/votofacil
- docker-compose up -d

## API

- http://localhost:8080/api/v1/pautas
- http://localhost:8080/api/v1/sessoes
- http://localhost:8080/api/v1/associados
- http://localhost:8080/api/v1/votos
- http://localhost:8080/api/v1/apuracao

## Documentação

- http://localhost:8080/api/v1/docs/ui
