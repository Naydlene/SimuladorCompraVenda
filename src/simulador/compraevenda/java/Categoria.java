package simulador.compraevenda.java;

public class Categoria {
	private int id;
	private String descricao;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	Categoria(String descricao, int id){
		this.descricao = descricao;
		this.id = id;		
	}

	public String dadosCategoria() {
		String retorno = "\n ID: " + this.id + "\nDesc: " + this.descricao;
		return retorno;
	}
}
