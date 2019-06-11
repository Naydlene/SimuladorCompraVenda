package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaJuridica extends Pessoa{

	private String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
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
			String StringQuery = "UPDATE pessoajuridica SET cnpj = "
					+ cnpj +  " WHERE id_pessoa = "
							+ super.getId() +";";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.cnpj = cnpj;
		}
	}

	public PessoaJuridica() {}
	
	public PessoaJuridica(int id,Endereco endereco, String nome, String email, String telefone, String celular, String cnpj) {
		super(id,endereco,nome, email, telefone, celular);
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
			String StringQuery = "insert into pessoajuridica values("+ id + ","+id+",'"+cnpj+"')";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.cnpj = cnpj;
		}
		
	}
	public String dadosPessoaJuridica() {
		String retorno = super.dadosPessoa() + "\nCNPJ: " + this.cnpj;
		return retorno;
	}
	public String dadosPessoaJuridica2() {
		String retorno = "\nCódigo: "  + super.getId() + "\nNome: " + super.getNome() + "\nCPF: " + this.cnpj;
		return retorno;
	}
	
}
