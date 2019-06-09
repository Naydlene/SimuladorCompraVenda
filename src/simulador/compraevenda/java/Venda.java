package simulador.compraevenda.java;

import java.util.ArrayList;

public class Venda{
	
	private double desconto;
	private int tipoComprador;
	private int idVenda;
	private String momentoCompra;
	ArrayList<ProdutoVendido> ListProdutosVendidos;
	
	public Venda(double desconto, int tipoComprador, int idVenda, String momentoCompra,ArrayList<ProdutoVendido>  ListProdutosVendidos) {
		this.desconto = desconto;
		this.tipoComprador = tipoComprador;
		this.idVenda = idVenda;
		this.momentoCompra = momentoCompra;
		this.ListProdutosVendidos = ListProdutosVendidos;
	}
	
	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public String getMomentoCompra() {
		return momentoCompra;
	}

	public void setMomentoCompra(String momentoCompra) {
		this.momentoCompra = momentoCompra;
	}

	public ArrayList<ProdutoVendido> getListProdutosVendidos() {
		return ListProdutosVendidos;
	}

	public void setListProdutosVendidos(ArrayList<ProdutoVendido> listProdutosVendidos) {
		ListProdutosVendidos = listProdutosVendidos;
	}

	public int getTipoComprador() {
		return tipoComprador;
	}

	public void setTipoComprador(int tipoComprador) {
		this.tipoComprador = tipoComprador;
	}



	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	

}
