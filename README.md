Projeto lightmin: (https://github.com/tuxdevelop/spring-batch-lightmin)

# Exemplo de configurração do Spring Batch Lightmin Server
- Exemplo de configuração de batch lightmin server com duas aplicações cliente usando auto registro

## Passos:
- Baixe e instale o banco de dados H2: http://www.h2database.com/html/main.html
- Crie o banco de dados (Eu usei o caminho relativo do atual usuário do S.O. '~/data/batch-server-db' (Crie o banco no caminho para não precisa de mudanças)
- Crie as tabelas do batch lightmin. Use o script do link: https://htmlpreview.github.io/?https://github.com/tuxdevelop/spring-batch-lightmin/blob/2.1.x/spring-batch-lightmin-documentation/src/main/doc/spring_batch_lightmin.html#_jobconfiguration_repository
- Importe os projetos maven para sua IDE
- Execute o server e depois os clientes 1 e 2

## Lightmin Server 
- Acesso a página inicial do lightmin sever em: http://localhost:8080)

## Aplicações 1  e 2
- Quando as aplicações 1 e 2 são iniciadas elas tentam se registrar no lightmin server e executam os jobs automaticamente. Iisso permite que você acompanhe o registro do processamento dos jobs usando a interface visual do batch lightmin.

 


