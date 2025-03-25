package cadastroprodutos;

// Importação de bibliotecas

import java.time.LocalDate; // Manipular datas
import java.util.ArrayList; // Para armazenar os produtos
import java.util.Scanner; // Para ler entradas do usuário

public class Principal {
    // Lista para armazenar os produtos cadastrados
    private static ArrayList<Produto> produtos = new ArrayList<>();
    // Scanner para ler entradas do usuário
    private static Scanner sc = new Scanner(System.in);

    // Método principal do programa
    public static void main(String[] args) {
        int opcao;
        do {
            // Exibe o menu de opções
            System.out.println("********* GERENCIAMENTO DE PRODUTOS ************");
            System.out.println("* 1 - Cadastrar 2 - Editar  *");
            System.out.println("* 3 - Excluir 4 - Listar   *");
            System.out.println("*          9 - Fim         *");
            System.out.println("****************************");
            System.out.println("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            // Executa as ações conforme a opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    editarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    listarProdutos();
                    break;
            }
        } while (opcao != 9); // Continua até a opção 9 ser escolhida
        sc.close();
    }

    // Método para cadastrar um produto
    private static void cadastrarProduto() {
        // Menu para escolher o tipo de produto
        System.out.println("\nEscolha o tipo de produto: ");
        System.out.println("1. Eletrônico");
        System.out.println("2. Roupa");
        System.out.println("3. Alimento");
        System.out.print("Opção: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        // Solicita os dados do produto e cadastra conforme o tipo escolhido
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        switch (tipo) {
            case 1: // Eletrônico
                System.out.print("Marca: ");
                String marca = sc.nextLine();
                System.out.print("Garantia (meses): ");
                int garantia = sc.nextInt();
                produtos.add(new Eletronico(codigo, nome, preco, marca, garantia));
                break;
            case 2: // Roupa
                System.out.print("Tamanho: ");
                String tamanho = sc.nextLine();
                System.out.print("Material: ");
                String material = sc.nextLine();
                produtos.add(new Roupa(codigo, nome, preco, tamanho, material));
                break;
            case 3: // Alimento
                System.out.print("Data de validade (ANO-MÊS-DIA): ");
                LocalDate validade = LocalDate.parse(sc.nextLine());
                System.out.print("Categoria: ");
                String categoria = sc.nextLine();
                produtos.add(new Alimento(codigo, nome, preco, validade, categoria));
                break;
            default:
                System.out.println("Tipo inválido!");
        }
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Método para listar os produtos cadastrados
    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado!");
        } else {
            for (Produto p : produtos) {
                p.exibir_informacoes();
                System.out.println("-----------------------------");
            }
        }
    }

    // Método para excluir um produto pelo código
    private static void excluirProduto() {
        System.out.print("\nDigite o código do produto a ser excluído: ");
        String codigo = sc.nextLine();

        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                produtos.remove(p);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    // Método para editar um produto
    private static void editarProduto() {
        System.out.print("\nDigite o código do produto a ser editado: ");
        String codigo = sc.nextLine();

        // Busca o produto com o código fornecido
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                int opcaoEditar;
                do {
                    // Exibe um menu com as opções de edição
                    System.out.println("\nEscolha o que deseja editar:");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Preço");
                    if (p instanceof Eletronico) {
                        System.out.println("3 - Marca");
                        System.out.println("4 - Garantia");
                    } else if (p instanceof Roupa) {
                        System.out.println("3 - Tamanho");
                        System.out.println("4 - Material");
                    } else if (p instanceof Alimento) {
                        System.out.println("3 - Data de validade");
                        System.out.println("4 - Categoria");
                    }
                    System.out.println("0 - Voltar");
                    System.out.print("Opção: ");
                    opcaoEditar = sc.nextInt();
                    sc.nextLine();

                    // Edita conforme a escolha do usuário
                    switch (opcaoEditar) {
                        case 1: // Nome
                            System.out.print("Novo Nome: ");
                            p.setNome(sc.nextLine());
                            break;
                        case 2: // Preço
                            System.out.print("Novo Preço: ");
                            p.setPreco(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 3: // Editar Marca ou Tamanho ou Data de validade, dependendo do tipo de produto
                            if (p instanceof Eletronico) {
                                System.out.print("Nova Marca: ");
                                ((Eletronico) p).setMarca(sc.nextLine());
                            } else if (p instanceof Roupa) {
                                System.out.print("Novo Tamanho: ");
                                ((Roupa) p).setTamanho(sc.nextLine());
                            } else if (p instanceof Alimento) {
                                System.out.print("Nova Data de validade (ANO-MÊS-DIA): ");
                                ((Alimento) p).setData_validade(LocalDate.parse(sc.nextLine()));
                            }
                            break;
                        case 4: // Editar Garantia ou Material ou Categoria
                            if (p instanceof Eletronico) {
                                System.out.print("Nova Garantia (meses): ");
                                ((Eletronico) p).setGarantia_meses(sc.nextInt());
                                sc.nextLine();
                            } else if (p instanceof Roupa) {
                                System.out.print("Novo Material: ");
                                ((Roupa) p).setMaterial(sc.nextLine());
                            } else if (p instanceof Alimento) {
                                System.out.print("Nova Categoria: ");
                                ((Alimento) p).setCategoria(sc.nextLine());
                            }
                            break;
                        case 0: // Voltar
                            System.out.println("Voltando...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcaoEditar != 0); // Continua até o usuário escolher voltar

                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
}