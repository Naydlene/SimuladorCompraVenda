package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Venda{

	private double precoLiquido;
	private double precototal;
	private double descPorc;
	private int idComprador;
	private int idVenda;
	private String momentoCompra;
	
	ArrayList<ProdutoVendido> ListProdutosVendidos;
	
	public Venda() {
		
	}
	
	public Venda(double precototal, double precoLiquido, double descPorc, int idComprador, int idVenda, String momentoCompra,ArrayList<ProdutoVendido>  ListProdutosVendidos) {
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
			String StringQuery = "insert into venda values("
					+ idVenda +"," + precototal + "," +precoLiquido + "," + descPorc + "," + idComprador + ", DEFAULT)";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.precototal = precototal;
			this.precoLiquido = precoLiquido;
			this.descPorc = descPorc;
			this.idComprador = idComprador;
			this.idVenda = idVenda;
			this.momentoCompra = momentoCompra;
			this.ListProdutosVendidos = ListProdutosVendidos;
		}
	}
	public double getPrecototal() {
		return precototal;
	}

	public void setPrecototal(double precototal) {
		this.precototal = precototal;
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

	public int getiIdComprador() {
		return idComprador;
	}

	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}



	public double getDescPorc() {
		return descPorc;
	}

	public void setDescPorc(double desconto) {
		this.descPorc = desconto;
	}

	public double getPrecoLiquido() {
		return precoLiquido;
	}

	public void setPrecoLiquido(double precoLiquido) {
		this.precoLiquido = precoLiquido;
	}

	public int getIdComprador() {
		return idComprador;
	}
	
	

}
