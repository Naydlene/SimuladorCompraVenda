package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaFisica extends Pessoa{
	
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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
			String StringQuery = "UPDATE pessoafisica SET cpf = "
					+ cpf +  " WHERE id_pessoa = "
							+ super.getId() +";";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.cpf = cpf;
		}
	}
	
	public PessoaFisica() {}
	
	public PessoaFisica(int id,Endereco endereco, String nome, String email, String telefone, String celular, String cpf) {
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
			String StringQuery = "insert into pessoafisica values("+ id + ","+id+",'"+cpf+"')";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.cpf = cpf;
		}
		
	}

	public String dadosPessoaFisica() {
		String retorno = super.dadosPessoa() + "\nCPF: " + this.cpf;
		return retorno;
	}
	public String dadosPessoaFisica2() {
		String retorno = "\nCódigo: " + super.getId() + "\nNome: " + super.getNome() + "\nCPF: " + this.cpf;
		return retorno;
	}
	
	
}
