package simulador.compraevenda.java;

public class Produto {
	private Categoria categoria;
	private int id;
	private String nome;
	private double precoVenda;
	private double qtde_estoque;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public double getQtde_estoque() {
		return qtde_estoque;
	}
	public void setQtde_estoque(double qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}
	//construtor
	Produto(Categoria categoria, int id, String nome, double precoVenda, double qtde_estoque){
		this.categoria = categoria;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.qtde_estoque = qtde_estoque;
	}
	public Produto(String codCategoria, String nome2, double preco, double qtde_estoque2) {
		// TODO Auto-generated constructor stub
	}
	public String dadosProdutos(){
		String retorno = "Categoria: " + this.categoria + "Nome: " + this.nome + "Preco Venda: " + this.precoVenda + "Quantidade no estoque: " + this.qtde_estoque;
		return retorno;
	}

	

}
