package simulador.compraevenda.java;

public class PessoaJuridica extends Pessoa{

	private String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public PessoaJuridica(Endereco endereco, String nome, String email, String telefone, String celular, String cnpj) {
		super(endereco, nome, email, telefone, celular);
		this.cnpj = cnpj;
		
	}
	
	
}
