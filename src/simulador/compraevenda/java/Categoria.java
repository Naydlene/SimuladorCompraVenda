package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Categoria {
	private int id;
	private String descricao;
	
	public Categoria() {
	}
	
	public Categoria(int id, String descricao) {
		boolean conectou = false;
		boolean tudoOk = true;
		Connection con = null;
		//classe que executa as acoes no banco.
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
		}while(!conectou);
		try {
			stm = con.createStatement();
			String StringQuery = "insert into categoria values("+id+",'"+descricao+"')";
			stm.execute(StringQuery);	
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}
		
		if(tudoOk) {
			this.id = id;
			this.descricao = descricao;
		}
		
		
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
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
			String StringQuery = "UPDATE categoria SET descricao = '"
					+ descricao +  "'	 WHERE id_categoria = "
							+ this.id +";";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.descricao = descricao;
		}
	}

	Categoria(String descricao, int id){
		this.descricao = descricao;
		this.id = id;		
	}

	public String dadosCategoria() {
		String retorno = "\nCódigo: " + this.id + "\nDesc: " + this.descricao;
		return retorno;
	}
}
