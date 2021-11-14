# projeto-spring

### Requisitos
    Java 11
    Docker

### Docker
O projeto possui um docker-compose para inicar o banco de dados MySQL, rodar o comando ``docker-compose up -d`` na raiz do projeto e aguardar ele subir, o arquivo ``application.yml`` ja vai estar configurado para o docker

### Spring
Recomendado utilizar o inteliJ para rodar esse projeto, quando configurar o gradle e quando todas as dependencias estiverem sincronizadas dar play na aplicação  ``ProjetoSpringApplication`` por padrão a aplicação vai estar rodando na porta ``:8081``

### How to use
Para utilizar a aplicação é recomendado o uso do Postman mas fica a seu critério, para acessar a documentação das API's ir em ``http://localhost:8081/swagger-ui/#/``

## Ferramentas e tecnologias usadas
Foi utilizado o ``MySQL`` como banco de dados por ele ser gratuito e de comum conhecimento dentro do grupo, fora a comunidade e facil configuração

Utilizamos o ``docker-composer``, pois facilita a configuração do ambiente exigindo menos do usuário que baixe diversos recursos, correndo risco de baixar uma versão diferente. 

## Relatório de usuário (RF4)
O usuário pode gerar um extrato dê suas transações a partir da rota: http://localhost:8081/swagger-ui/#/users/getTransactionsByUserIdUsingGET

Basta informar o id do usuário e clicar em Execute. O response body será preenchido com o resultado da solicitação, disponibilizando também a opção de baixar o relatório do cliente no botão "Download".
