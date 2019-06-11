package simulador.compraevenda.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe Conecta
public class ConectaBanco {

	static final String URL = "jdbc:postgresql://localhost:5432/projetojava";
	static final String USER = "postgres";
	static final String PASS = "123456";

	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection conecta = DriverManager.getConnection(URL, USER, PASS);
		if (conecta != null) {
			return conecta;
		}
		return null;
	}

}
