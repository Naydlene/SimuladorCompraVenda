package simulador.compraevenda.java;

public class PessoaFisica extends Pessoa{
	
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PessoaFisica(Endereco endereco, String nome, String email, String telefone, String celular, String cpf) {
		super(endereco, nome, email, telefone, celular);
		this.cpf = cpf;
		
	}
	/*this.endereco = endereco;
	this.telefone = telefone;
	this.celular = celular;this.
	this.nome = nome;
	this.email = email;*/
	public String dadosPessoaFisica() {
		String retorno = super.dadosPessoa() + " CPF: " + this.cpf;
		return retorno;
	}
	
	
}
