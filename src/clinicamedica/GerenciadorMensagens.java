package clinicamedica;

import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorMensagens {
	private ArrayList<Consulta> consulta = new ArrayList();

	Scanner scan = new Scanner(System.in);

	public GerenciadorMensagens(ArrayList<Consulta> consulta) {
		this.consulta = consulta;
	}

	public void enviarMensagem() {
		System.out.print("DIA: ");
		int day = Integer.parseInt(scan.nextLine());
		System.out.print("MÊS: ");
		int month = Integer.parseInt(scan.nextLine());
		System.out.print("ANO: ");
		int year = Integer.parseInt(scan.nextLine());

		if ((day < 1 || day > 31 || month < 1 || month > 12)) {
			System.out.println("DATA INVÁLIDA");
			return;
		}
		if (day == 31) {
			day = 1;
			if (month == 12) {
				month = 1;
				year++;
			} else
				month++;

		} else
			day++;
		String data = day + "/" + month + "/" + year;
		for (Consulta con : consulta) {
			if (data.equals(con.getData())) {
				System.out.println("MENSAGEM ENVIADA PARA: " + con.getPaciente().getNome());
				System.out.println("TELEFONE(SMS): " + con.getPaciente().getTelefone());
				System.out.println("EMAIL: " + con.getPaciente().getEmail());
				System.out.println("MENSAGEM: Você tem uma consulta marcada para amanha (Dia " + day + ") às " + con.getHorario() + ".");
			}
		}
	}
}