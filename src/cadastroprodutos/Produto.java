package cadastroprodutos;

public class Produto {
    // Declaração de variáveis
    private String codigo;
    private String nome;
    private double preco;
    // Construtor da classe
    public Produto(String codigo, String nome, double preco) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
    // Métodos getters e setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método para exibir as informações do produto
    public void exibir_informacoes() {
        System.out.println("Código...: " + this.codigo);
        System.out.println("Nome.....: " + this.nome);
        System.out.println("Preço....: " + this.preco);



    }

}
