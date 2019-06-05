package simulador.compraevenda.java;

public class Produto {
	private Fornecedores fornecedores;
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
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
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
	public Produto( Categoria categoria, int id, Fornecedores fornecedores, String nome, double precoVenda, double qtde_estoque){
		this.fornecedores = fornecedores;
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.qtde_estoque = qtde_estoque;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String dadosProdutos(){
		String retorno = "Código do produto: " + this.id + " Fornecedor: " +fornecedores.getNome() + " Categoria: " + this.categoria.getDescricao() + " Nome: " + this.nome + " Preco Venda: " + this.precoVenda + " Quantidade no estoque: " + this.qtde_estoque;
		return retorno;
	}

	

}
