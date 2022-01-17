## sistema-reserva-sala
Projeto desenvolvido em Java, utilizando Spring Boot Framework

# Sistema de gerenciamento financeiro PubFuture

## Descrição
O sistema de gerenciamento financeiro foi criado para facilitar os processos de gestão financeira pessoal ou de uma instituição. O sistema tem funções de cadastro de conta, receita e despesa, e também filtros de busca.

## Requisitos para compilar o projeto
- JDK e JRE 1.8 ou superior
- Banco de dados MySQL(recomendado Workbench 8)
- IDE Spring Tools Suite 4. [Esta vídeo aula de 6 minutos mostra passo a passo da instalação](https://www.youtube.com/watch?v=x9sGfYTNRf4) 

## Executando a compilação
- Realize o clone do repositório dentro da pasta do Workspace do Spring Tools. *git clone https://github.com/jbside/desafiopubfuture.git*
- Após realizar o clone, importe o projeto MAVEM para seu Workspace. [Neste tutorial mostra passo a passo como realizar a importação, considere a pasta do projeto](https://medium.com/@alex.girao/importar-um-projeto-maven-spring-boot-ea10078b2bde)
- Configure o acesso do JDBC ao seu banco de dados no arquivo src/main/resources/application.propietes:

*spring.datasource.url= jdbc:mysql://localhost:3306/pubfuture?useTimezone=true&serverTimezone=UTC&createDatabaseIfNotExist=true*

*spring.datasource.username=* **USUARIO**

*spring.datasource.password=* **SENHA**

- Após salvar, execulte o servidor, no canto inferior esquerdo, no pubfurue clique com o botao direito e depois em (Re)Start, o console terá que ficar desta forma:

![](https://i.ibb.co/72wms2C/server.png)

- Pronto, a aplicação está rodando no servidor, você pode acessa-la no endereço http://localhost:8080/

## Utilizando o sistema

O sistema tem uma tela intuitiva, e simples de usar, através da navegação lateral você pode acessar as páginas:

![](https://i.ibb.co/93LZV6x/telainicial.png)

- Para cada categoria o sistema tem duas páginas, a de cadastro e a página com a listagem dos dados cadastrados

![](https://i.ibb.co/5hmhV2s/cadastro-conta.png)

![](https://i.ibb.co/48X5JXF/cadastro-despesa.png)

![](https://i.ibb.co/Jq9Y28w/cadastro-receita.png)

1. As paginas de cadastro não podem ser salvar com campo vazio
2. Após o cadastro realizado o item será persistido no banco, e irá ser impresso na lista

![](https://i.ibb.co/djrqgtv/lista-contas.png)

## Utilizando o filtro de busca

O filtro de busca do sistema  é feito **nas páginas de listagem de receita e despeas**

![](https://i.ibb.co/KctTtBJ/filtro-busca.png)

Após o filtro ser informado, a lista será atualizada de acordo com a consulta

## Exclusão e edição de dados

Tanto a exclusão quando a edição dos dados, podem ser acessadas pela página de listagem
 
![](https://i.ibb.co/3svBbKL/exclusao-edicao.png)

## Funções implementadas

1. Foi implentada a funcionalidade de transferir valor do saldo e uma conta para a outra

![](https://i.ibb.co/GM35kD4/tranferencia.png)



# Explorando um pouco do código

Para o desenvolvimento do projeto foi escolhido o padrão MVC, nativo do Spring. Todas funcionalidades foram organizadas em seus respectivos pacotes 

## VIEW
A parte da view está em src/resources/templates, todo o Front End está renderizado através do Thymeleaft

## MODEL
O model da aplicação está nos pacotes **BEANS, DAO E SERVICE**

- No pacote beans está contido separado por classes, a geração dos objetos Conta,Receita e Despesa. O Spring se utiliza da notação *@Table* para através do bean solicitar ao hibernate para criar as tabelas no banco
- O pacote dao estão as regras de negocio das funções de CRUD da aplicação
- No pacote service estão implementadas as regras de negocio usadas pelo controller para implementar as funções do sistema

**Todas as classes da camada MODEL tem como parametrizador dos métodos INTERFACES criadas para regrar as classes**

## CONTROLLER
A camada controller se encontra no pacote controller

Todas as funções e implementações são administradas pelo controller, que chama as classes do MODEL e realiza comunicação com o VIEW da aplicação

![](https://i.ibb.co/rFj5NcN/controller.png)

Temos como exemplo esse metodo, que se processa os dados informados pelo usuario, condicionalmente realiza a persistência dos mesmo no banco, e envia uma resposta para
o front end


# Autor
Jesiel Borges

Email: jesyborges@gmail.com

