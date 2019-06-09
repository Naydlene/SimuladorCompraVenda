package simulador.compraevenda.java;

public class PessoaFisica extends Pessoa{
	
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PessoaFisica(int id,Endereco endereco, String nome, String email, String telefone, String celular, String cpf) {
		super(id,endereco,nome, email, telefone, celular);
		this.cpf = cpf;
		
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
