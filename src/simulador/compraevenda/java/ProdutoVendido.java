package simulador.compraevenda.java;

public class ProdutoVendido {
	private int idVenda, idProduto, idComprador;
	private double qtd;
	

	public ProdutoVendido(int idVenda, int idProduto, int idComprador, double qtd) {
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.idComprador = idComprador;
		this.qtd = qtd;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getIdComprador() {
		return idComprador;
	}
	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}
	
	public double getQtd() {
		return qtd;
	}
	public void setQtd(double qtd) {
		this.qtd = qtd;
	}
	
	
}
