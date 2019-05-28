package simulador.compraevenda.java;

public class Endereco {
	private String rua;
	private String cep;
	private String bairro;
	private int num;
	private String complemento;
	private String cidade;
	private String estado;
	
	public Endereco(String rua,String cep, String bairro, int num, String complemento, String cidade, String estado) {
		this.rua = rua;
		this.cep = cep;
		this.bairro = bairro;
		this.num = num;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
