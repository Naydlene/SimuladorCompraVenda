package simulador.compraevenda.java;

public class Pessoa {
	private int id;
	private Endereco endereco;
	private String nome;
	private String email;
	private String telefone;
	private String celular;

	
	
	public Pessoa( int id,Endereco endereco, String nome, String email, String telefone, String celular) {
		this.id = id;
		this.endereco = endereco;
		this.telefone = telefone;
		this.celular = celular;
		this.nome = nome;
		this.email = email;
		
	}
	public String dadosPessoa(){
		String retorno = "Código: " + id + " Nome: " + this.nome + endereco.dadosEndereco() + " Email: " + this.email + " Telefone: " + this.telefone + " Celular: " + this.celular; 
		return retorno;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
