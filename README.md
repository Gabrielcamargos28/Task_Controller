# TCD - Trabalho de Conclusão de Disciplina

## Descrição do Projeto

Este repositório contém um projeto desenvolvido como parte de um Trabalho de Conclusão de Disciplina (TCD). O projeto é uma API com backend desenvolvido em Spring Boot e foi criado para atender às necessidades de controle de tarefas em uma empresa. O sistema permite a realização de operações básicas de CRUD em entidades como funcionários, clientes e tarefas. Para realizar testes na API, é necessário realizar login usando um token Bearer.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Boot Validation
- Spring Boot Security
- Spring Boot Data JPA
- Spring Boot Web
- SpringFox Swagger 2
- SpringFox Swagger UI
- Springdoc OpenAPI
- Java-JWT
- H2 Database
- Project Lombok
- PostgreSQL
- Docker

## Como Executar

- Clonar repositório git:
```
git clone https:[//github.com/Gabrielcamargos28/Task_Controller.git](https://github.com/Gabrielcamargos28/Task_Controller)
```

# Executar .jar:
```
java -jar ..\target\TaskController-0.0.1-SNAPSHOT.jar
```
# Executando a Aplicação com Docker

## Pré-requisitos
### Apenas branch DigitalOcean

- Docker instalado na sua máquina. Você pode baixá-lo [aqui](https://www.docker.com/get-started).

- Dentro do diretorio execute os comandos para iniciar os contêineres com o Docker Compose

 ```
  docker-compose up
 ```

- Dentro do diretorio execute os comandos para remover os contêineres com o Docker Compose

```
  docker-compose down
```
  
## Testando

```
[Railway] https://taskcontroller-dev.up.railway.app/swagger-ui/index.html#/
[localhost] http://localhost:8080/swagger-ui/index.html
```

## Branches

Este repositório contém quatro branches principais:

- **main**: A branch principal contém a versão mais estável do projeto.

- **dev**: A branch de desenvolvimento é usada para implementações e testes em desenvolvimento.
- Acesse a implantação da branch `dev` em: [TaskController no Railway](https://taskcontroller-dev.up.railway.app/swagger-ui/index.html/)


- **prod**: A branch de produção é usada para implantações em ambientes de produção.
-  **digitalOcean**: A branch de é usada para implantações de containers e configurações.
  
## Documentação

A documentação da API pode ser acessada na URL da implantação principal: [Documentação da API](https://taskcontroller-dev.up.railway.app/swagger-ui/index.html/)

## Autor

Este projeto foi desenvolvido por Gabriel Camargos como parte do TCD.

---

Este README serve como um guia básico para o projeto. Para informações mais detalhadas e instruções sobre como configurar e executar o projeto localmente, consulte a documentação ou entre em contato:

Linkedin: [https://www.linkedin.com/in/gabriel-camargos-dev/].

##Diagrama de Classes

![Diagrama de classes](https://github.com/Gabrielcamargos28/Task_Controller/blob/main/Diagrama%20de%20classes.png)
