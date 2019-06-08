package simulador.compraevenda.java;

public class Compras {
		private Calendario calendario;
		private Produto produto;
		private Categoria categoria;
		private Fornecedores fornecedores;
		private int id;
		private double preco;
		//private int quantidadeProdutos;
		
		public Compras(int id, Produto produto, Categoria categoria,Fornecedores fornecedores,  double preco ){
			this.id = id;
			this.produto = produto;
			this.categoria = categoria;
			this.fornecedores = fornecedores;
			this.preco = preco;
		}
		public String dadosCompras(){
			String retorno = "Código:  ." + id + "\nCalendário:  ." + calendario + "\nProduto:  ." +  produto + "\nCategoria: " + categoria + "\nFornecedor: " + fornecedores + "\nPreço: "  + preco;
			return retorno;
		}
		public Calendario getCalendario() {
			return calendario;
		}
		public void setCalendario(Calendario calendario) {
			this.calendario = calendario;
		}
		public Produto getProduto() {
			return produto;
		}
		public void setProduto(Produto produto) {
			this.produto = produto;
		}
		public Fornecedores getFornecedores() {
			return fornecedores;
		}
		public void setFornecedores(Fornecedores fornecedores) {
			this.fornecedores = fornecedores;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		
		

}
