package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Unidade {
	
	private int id;
	private String nome;
	
	public Unidade() {}
	public Unidade(int id, String nome){
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
		}while(!conectou);
		try {
			stm = con.createStatement();
			String StringQuery = "insert into categoria values("+id+",'"+nome+"')";
			stm.execute(StringQuery);	
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}
		
		if(tudoOk) {
			this.nome = nome;
			this.id = id;
		}
	}
	public String dadosUnidade() {
		String retorno = "Código: " + id +" Tipo de unidade: " + nome;
		return retorno;
	}

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

	
}
