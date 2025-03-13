## Descrição

Este projeto é uma aplicação Java que implementa um **Sistema de Gerenciamento de Produtos**. O sistema permite o cadastro, alteração, exclusão e listagem de produtos de três categorias diferentes: **Alimentos**, **Roupas** e **Eletrônicos**. Utilizando um **ArrayList**, o sistema organiza os produtos de forma eficiente e permite que o usuário gerencie o estoque de maneira simples e rápida.

## Funcionalidades

- **Cadastrar Produto**: O usuário pode adicionar novos produtos, escolhendo entre as categorias disponíveis (Eletrônico, Roupa ou Alimento). Cada tipo de produto possui características específicas a serem informadas no momento do cadastro.
- **Exibir Produtos**: O sistema permite visualizar todos os produtos cadastrados, com a opção de listar as informações detalhadas, como preço, código e atributos específicos de cada tipo.
- **Excluir Produto**: Produtos podem ser removidos com base no código de identificação fornecido.
- **Editar Produto**: O usuário pode editar as informações de um produto existente, como nome e preço.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal utilizada para o desenvolvimento da aplicação.
- **Collections (ArrayList)**: Utilizado para armazenar os produtos de forma dinâmica e permitir operações como adicionar, editar, excluir e listar produtos.
- **Manipulação de Datas (LocalDate, DateTimeFormatter)**: Usado para lidar com informações relacionadas à validade dos alimentos.
- **Enumerações (Enum)**: Embora o código atual não tenha implementado uma enumeração específica, a ideia de adicionar tipos de produtos através de enumerações pode ser uma melhoria futura.

### Detalhes do Código

O código é estruturado em quatro principais classes de produto:

1. **Produto**: Classe base para os produtos, contendo atributos comuns como código, nome e preço.
2. **Eletrônico**: Extende a classe `Produto` e adiciona atributos específicos, como marca e garantia.
3. **Roupa**: Também extende `Produto` e inclui atributos como tamanho e material.
4. **Alimento**: Herda de `Produto` e inclui atributos como data de validade e categoria de alimento.

A classe `Principal` contém o método `main`, que é responsável por apresentar o menu e executar as opções de cadastro, edição, exclusão e listagem de produtos.

### Exemplos de Funcionamento

- **Cadastrar um Eletrônico**: O usuário escolhe a opção "Eletrônico", insere os dados como código, nome, preço, marca e garantia, e o produto é adicionado ao sistema.
- **Cadastrar uma Roupa**: O processo é semelhante, mas o usuário informa o tamanho e o material da roupa.
- **Cadastrar um Alimento**: Além das informações básicas, o alimento exige a data de validade e categoria específica.

## Autor

Desenvolvido por [viniciuszanella](https://github.com/viniciuszanella)
