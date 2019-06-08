package simulador.compraevenda.java;
import java.util.Calendar;
import java.util.Scanner;

public class Calendario {
		static public Scanner input  = new Scanner(System.in);
		public void calen(String[] args) {
			Calendar c = Calendar.getInstance();
			int ano = c.get(Calendar.YEAR);
			int mes = c.get(Calendar.MONTH);
			int dia = c.get(Calendar.DAY_OF_MONTH);
			int hora = c.get(Calendar.HOUR_OF_DAY);
			int minutos = c.get(Calendar.MINUTE);
			int segundos = c.get(Calendar.SECOND);
			
			System.out.printf("Hoje é: %02d/%02d/%d %02d:%02d:%02d", dia, (mes+1), ano, hora, minutos, segundos);

		}

	}


