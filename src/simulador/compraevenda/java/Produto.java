package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Produto {
	private Fornecedores fornecedores;
	private Categoria categoria;
	private int id;
	private String nome;
	private double precoVenda;
	private int qtde_estoque;
	private int qtd_produtos;
	private Unidade unidade;

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

	public int getQtde_estoque() {
		return qtde_estoque;
	}

	public void setQtde_estoque(int qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}

	public Produto() {
	}

	public Produto(Categoria categoria, int id, Fornecedores fornecedores, String nome, double precoVenda,
		int qtde_estoque, Unidade unidade) {
		boolean conectou = false;
		boolean tudoOk = true;
		Connection con = null;
		Statement stm;
		do {
			try {
				conectou = true;
				con = ConectaBanco.criarConexao();
			} catch (ClassNotFoundException e) {
				conectou = false;
				e.printStackTrace();
			} catch (SQLException e) {
				conectou = false;
				e.printStackTrace();
			}
		} while (!conectou);
		try {
			stm = con.createStatement();
			String StringQuery = "insert into produto values("
					+ id +","+fornecedores.getId()+","+
					categoria.getId()+","+unidade.getId()+",'"+
					nome+"',"+precoVenda+","+qtde_estoque+","+qtd_produtos+ ")";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.categoria = categoria;
			this.id = id;
			this.fornecedores = fornecedores;
			this.nome = nome;
			this.precoVenda = precoVenda;
			this.qtde_estoque = qtde_estoque;
			this.unidade = unidade;
		}
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQtd_produtos() {
		return qtd_produtos;
	}

	public void setQtd_produtos(int qtd_produtos) {
		this.qtd_produtos = qtd_produtos;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public String dadosProdutos() {
		String retorno = "\nCódigo do produto: " + this.id + "\nFornecedor: " + this.fornecedores.getNome()
				+ "\nCategoria: " + this.categoria.getDescricao() + "\nNome: " + this.nome + "\nPreco Venda: "
				+ this.precoVenda + "\nQuantidade de produtos: " + this.qtde_estoque + "\nUnidade: "
				+ this.unidade.getNome();
		return retorno;
	}

	public String dadosProdutos2() {
		String retorno = "\nCódigo do produto: " + this.id + "\nNome: " + this.nome + "\nCategoria: "
				+ this.categoria.getDescricao() + "\nPreco Venda: " + this.precoVenda + "\nQuantidade de produtos: "
				+ this.qtde_estoque;
		return retorno;
	}

}
