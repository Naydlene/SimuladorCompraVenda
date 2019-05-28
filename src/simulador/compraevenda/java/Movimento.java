package simulador.compraevenda.java;
import java.util.ArrayList;


public class Movimento {
	ArrayList<ItemMovimento> ListItemMovimento = new ArrayList<>();
	//private ItemMovimento itemMovimento; é p ser array list
	private Usuario usuario;
	private int id;
	private String data;
	private double total;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
