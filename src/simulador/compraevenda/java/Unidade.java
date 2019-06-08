package simulador.compraevenda.java;

public class Unidade {
	
	private int id;
	private String nome;
	
	public Unidade(int id, String nome){
		this.nome = nome;
		this.id = id;
		
	}
	public String dadosUnidade() {
		String retorno = "Código: " + id +" Tipo de unidade: " + nome;
		return retorno;
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

	
}
