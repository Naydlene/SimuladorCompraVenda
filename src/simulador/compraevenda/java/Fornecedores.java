package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Fornecedores {

	private String cpfCnpj;
	private Endereco endereco;
	private String nome;
	private String email;
	private String telefone;
	private String celular;
	private int id;

	public Fornecedores() {
	}

	public Fornecedores(int id, Endereco endereco, String cpfCnpj, String nome, String email, String telefone,
			String celular) {
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
			String StringQuery = "insert into fornecedores values(" +
			id + ",'" + nome +"','" + email + "','" + telefone + "','" + celular +"','" + cpfCnpj + "','" +
			endereco.getRua() + "','" + endereco.getCep()+ "','" + endereco.getBairro() + "'," +
			endereco.getNum() + ",'" + endereco.getComplemento() + "','" + endereco.getCidade() + "','" +
			endereco.getEstado() +"')";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.id = id;
			this.endereco = endereco;
			this.telefone = telefone;
			this.celular = celular;
			this.nome = nome;
			this.email = email;
			this.cpfCnpj = cpfCnpj;
		}
	}

	public String dadosFornecedores() {
		String retorno = "Código: " + id + "\nNome: " + nome + "\nCPF ou CNPJ: " + cpfCnpj + endereco.dadosEndereco()
				+ "\nEmail: " + email + "\nCelular: " + celular + "\nTelefone: " + telefone;
		return retorno;
	}

	public String dadosFornecedores2() {
		String retorno = "Código: " + id + "\nNome: " + nome;
		return retorno;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
