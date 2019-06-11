package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {
	private int id;
	private Endereco endereco;
	private String nome;
	private String email;
	private String telefone;
	private String celular;

	public Pessoa() {
	}

	public Pessoa(int id, Endereco endereco, String nome, String email, String telefone, String celular) {
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
			String StringQuery = "insert into pessoa values(" + id + ",'" + nome + "','" + email + "','" + telefone
					+ "','" + celular + "','" + endereco.getRua() + "','" + endereco.getCep() + "','"
					+ endereco.getBairro() + "'," + endereco.getNum() + ",'" + endereco.getComplemento() + "','"
					+ endereco.getCidade() + "','" + endereco.getEstado() + "')";
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
		}
	}

	public String dadosPessoa() {
		String retorno = "\nCódigo: " + this.id + "\nNome: " + this.nome + endereco.dadosEndereco() + "\nEmail: "
				+ this.email + "\nTelefone: " + this.telefone + "\nCelular: " + this.celular;
		return retorno;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
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
			String StringQuery = "UPDATE pessoa set  rua = '" + endereco.getRua() + "', cep ='" + endereco.getCep()
					+ "', bairro ='" + endereco.getBairro() + "', num = " + endereco.getNum() + ",complemento = '"
					+ endereco.getComplemento() + "',cidade = '" + endereco.getCidade() + "', estado ='"
					+ endereco.getEstado() + "' where id_pessoa = " + this.id;
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.endereco = endereco;
		}
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
			String StringQuery = "UPDATE pessoa SET nome = '" + nome + "' WHERE id_pessoa = " + this.id + ";";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.nome = nome;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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
			String StringQuery = "UPDATE pessoa SET email = '" + email + "' WHERE id_pessoa = " + this.id + ";";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.email = email;
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
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
			String StringQuery = "UPDATE pessoa SET telefone = '" + telefone + "' WHERE id_pessoa = " + this.id + ";";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.telefone = telefone;
		}
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
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
			String StringQuery = "UPDATE pessoa SET celular = '" + celular + "' WHERE id_pessoa = " + this.id + ";";
			stm.execute(StringQuery);
			con.close();
		} catch (Exception e) {
			tudoOk = false;
			e.printStackTrace();
		}

		if (tudoOk) {
			this.celular = celular;
		}
	}

}
