package simulador.compraevenda.java;

public class PessoaJuridica extends Pessoa{

	private String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public PessoaJuridica(int id,Endereco endereco, String nome, String email, String telefone, String celular, String cnpj) {
		super(id,endereco,nome, email, telefone, celular);
		this.cnpj = cnpj;
		
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
