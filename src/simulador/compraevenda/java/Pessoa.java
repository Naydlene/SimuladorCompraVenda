package simulador.compraevenda.java;

public class Pessoa {
	private Endereco endereco;
	private String nome;
	private String email;
	private String telefone;
	private String celular;
	private int id;
	
	
	public Pessoa(Endereco endereco, String nome, String email, String telefone, String celular) {
		this.endereco = endereco;
		this.telefone = telefone;
		this.celular = celular;
		this.nome = nome;
		this.email = email;
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
	


}
