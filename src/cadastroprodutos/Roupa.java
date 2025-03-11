package cadastroprodutos;

    public class Roupa extends Produto {
        // Declaração de variáveis
        private String tamanho;
        private String material;
        // Construtor da classe
        public Roupa(String codigo, String nome, double preco, String tamanho, String material) {
            super(codigo, nome, preco);
            this.tamanho = tamanho;
            this.material = material;
            {
            }
        }
        // Métodos getters e setters
        public String getTamanho() {
            return tamanho;
        }

        public void setTamanho(String tamanho) {
            this.tamanho = tamanho;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        // Método para exibir as informações do produto
        public void exibir_informacoes() {
            super.exibir_informacoes();
            System.out.println("Tamanho......:" + this.tamanho);
            System.out.println("Material.....:" + this.material);
        }
    }
