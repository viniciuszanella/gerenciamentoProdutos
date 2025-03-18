package cadastroprodutos;

// Importação de bibliotecas
import java.time.LocalDate; // ano-mês-dia
import java.util.ArrayList; // arraylist, armazenar dados
import java.util.Scanner; // ler dados

public class Principal {
    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Método Principal
    public static void main(String[] args) {
        int opcao;
        do {
            // Menu do programa Sistema de Gerenciamento de Produtos
            System.out.println("********* GERENCIAMENTO DE PRODUTOS ************");
            System.out.println("* 1 - Cadastrar 2 - Editar  *");
            System.out.println("* 3 - Excluir 4 - Listar   *");
            System.out.println("*          9 - Fim         *");
            System.out.println("****************************");
            System.out.println("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            // Estrutura switch para executar diferentes operações com base na opção escolhida pelo usuário
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
            // Loop para não finalizar programa
        } while (opcao != 9);
    }
    // Método para cadastrar o Produto
    private static void cadastrarProduto() {
        // Menu para escolher tipo de produto para ser cadastrado no arraylist
        System.out.println("\nEscolha o tipo de produto: ");
        System.out.println("1. Eletrônico");
        System.out.println("2. Roupa");
        System.out.println("3. Alimento");
        System.out.print("Opção: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        switch (tipo) {
            case 1: // Cadastrar um eletrônico
                System.out.print("Marca: ");
                String marca = sc.nextLine();
                System.out.print("Garantia (meses): ");
                int garantia = sc.nextInt();
                sc.nextLine();
                // Cadastra o produto no arraylist
                produtos.add(new Eletronico(codigo, nome, preco, marca, garantia));
                break;
            case 2: // Cadastrar uma roupa
                System.out.print("Tamanho: ");
                String tamanho = sc.nextLine();
                System.out.print("Material: ");
                String material = sc.nextLine();
                // Cadastra o produto no arraylist
                produtos.add(new Roupa(codigo, nome, preco, tamanho, material));
                break;
            case 3: // Cadastrar um alimento
                System.out.print("Data de validade (ANO-MÊS-DIA): ");
                LocalDate dataValidade = LocalDate.parse(sc.nextLine());
                System.out.print("Categoria: ");
                String categoria = sc.nextLine();
                // Cadastra o produto no arraylist
                produtos.add(new Alimento(codigo, nome, preco, dataValidade, categoria));
                break;
            default:
                System.out.println("Tipo inválido!");
        }
        System.out.println("Produto cadastrado com sucesso!");
    }
    // Método para exibir produtos listados no arraylist
    private static void listarProdutos() {
        // Verifica se o arraylist está vazio
        if (produtos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado!");
        } else {
            System.out.println("\nLista de Produtos:");
            // Exibe os produtos listados no arraylist
            for (Produto p : produtos) {
                p.exibir_informacoes();
                System.out.println("-----------------------------");
            }
        }
    }
    // Método para excluir produto do arraylist
    private static void excluirProduto() {
        System.out.print("\nDigite o código do produto a ser excluído: ");
        String codigo = sc.nextLine();

        for (Produto p : produtos) {
            // Informar o código do produto a ser removido do arraylist
            if (p.getCodigo().equals(codigo)) {
                produtos.remove(p);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
    // Método para editar produto do arraylist
    private static void editarProduto() {
        System.out.print("\nDigite o código do produto a ser editado: ");
        String codigo = sc.nextLine();
    // Inserir código do produto para editar
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                System.out.print("Novo Nome: ");
                p.setNome(sc.nextLine());
                System.out.print("Novo Preço: ");
                p.setPreco(sc.nextDouble());
                sc.nextLine();
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
}