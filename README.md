# Workshop backend

## Acessar backend
https://workshop-springboot3-jpa-postgresql.onrender.com/

## Acessar frontend
https://vitor-pereira-workshop-spring-boot.com/

## Sobre o projeto

O workshop foi um projeto fullstack desenvolvido com o intuíto de aprender novas tecnologias, como Springboot, PostgreSQL, Maven, além de aperfeiçoar minhas habilidades em Orientação a Objetos e fazer um projeto para meu portfolio.

Esse repositório é apenas para o backend onde são feitas as APIs, onde são aplicadas as regras de negócio e onde o sistema se conecta ao banco de dados.

O projeto consiste em criar pedidos, que contêm produtos, e os pedidos são feitos por usuários.

O projeto foi colocado em produção, utilizando o heroku como host.

## Tecnologias usadas:

### Backend
- Java
- Springboot
- Maven
- JPA / Hibernate

### Banco de dados (Database)
- PostgreSQL
- H2-database (banco de dados de teste, criado apenas com o programa em execução)

## API sendo executada a partir do Postman: 
### GET user by id:
![Get User By Id](https://github.com/vitorpereira26r/workshop-springboot3-jpa/blob/main/assets/API_users_execucao.png)

### POST create user
![create user](https://github.com/vitorpereira26r/workshop-springboot3-jpa/blob/main/assets/API_users_create.png)

### GET order by id
![Get order By id](https://github.com/vitorpereira26r/workshop-springboot3-jpa/blob/main/assets/API_orders.png)

### POST add item(Product) to order
![Add item to order](https://github.com/vitorpereira26r/workshop-springboot3-jpa/blob/main/assets/API_orders_add_item.png)

### POST change order status
![change order status](https://github.com/vitorpereira26r/workshop-springboot3-jpa/blob/main/assets/API_orders_change_status.png)
