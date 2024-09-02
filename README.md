# 3SIPG CheckPoint 1 - API Web - MS_PROPOSTA  📋:
## API Microsservices

Desenvolvimento de microsserviço para gerenciamento de Proposta de Análise de Crédito.



## Integrantes 🧔:

- Gabriel Borba Pugliese Ribeiro - RM94677
- Pedro De Sousa Dutra - RM96167

## Observações 🖊️:

- User utiliza CPF único (Feito validação para cada usuário ser único a partir do CPF)
- É possível inserir uma proposta com um usuário já existente, utilizando o mesmo CPF do usuário já inserido (No JSON de inserção de uma proposta, no atributo CPF do usuário coloque o mesmo CPF do usuário já criado anteriormente, para assim a proposta ser atribuída a esse usuário)

## Ferramentas e especificações 🛠️:

- Java
- Maven
- Spring Boot
- Spring Boot Web
- Lombok
- Spring Boot Dev Tools
- Spring Data JPA
- H2 Database
- Validation
- Model Mapper