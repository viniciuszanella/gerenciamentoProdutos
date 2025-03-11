package cadastroprodutos;

// Importação biblioteca data local (ano/mês/dia)
import java.time.LocalDate;

public class Alimento extends Produto{
    // Declaração de variáveis
    private LocalDate data_validade;
    private String categoria;

    // Construtor da classe Alimento
    public Alimento(String codigo, String nome, double preco, LocalDate data_validade, String categoria) {
        super(codigo, nome, preco);
        this.data_validade = data_validade;
        this.categoria = categoria;
        {
        }
    }
    // Métodos getters e setters
    public LocalDate getData_validade() {
        return data_validade;
    }

    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método para exibir as informações do produto
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("Data Validade......:" + this.data_validade);
        System.out.println("Categoria.....:" + this.categoria);
    }
}
