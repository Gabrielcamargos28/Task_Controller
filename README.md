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

## Como Executar

- Clonar repositório git:
```
git clone https:[//github.com/Gabrielcamargos28/Api_Deploy.git](https://github.com/Gabrielcamargos28/Task_Controller)
```

- Executar:
```
java -jar ..\target\TaskController-0.0.1-SNAPSHOT.jar
```

## Testando

```
[Railway] https://taskcontroller-dev.up.railway.app/swagger-ui/index.html#/
[localhost] http://localhost:8080/swagger-ui/index.html
```

## Branches

Este repositório contém três branches principais:

- **main**: A branch principal contém a versão mais estável do projeto.

- **dev**: A branch de desenvolvimento é usada para implementações e testes em desenvolvimento.
- Acesse a implantação da branch `dev` em: [TaskController no Railway](https://taskcontroller-dev.up.railway.app/swagger-ui/index.html/)


- **prod**: A branch de produção é usada para implantações em ambientes de produção. 
## Documentação

A documentação da API pode ser acessada na URL da implantação principal: [Documentação da API](https://taskcontroller-dev.up.railway.app/swagger-ui/index.html/)

## Autor

Este projeto foi desenvolvido por Gabriel Camargos como parte do TCD.

---

Este README serve como um guia básico para o projeto. Para informações mais detalhadas e instruções sobre como configurar e executar o projeto localmente, consulte a documentação ou entre em contato:

Linkedin: [https://www.linkedin.com/in/gabriel-camargos-dev/].

##Diagrama de Classes

![Diagrama de classes](https://github.com/Gabrielcamargos28/Task_Controller/blob/main/Diagrama%20de%20classes.png)
