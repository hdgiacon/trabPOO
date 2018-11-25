package clinicamedica;

import java.util.Scanner;
import java.util.ArrayList;

public class RelatorioMedico {
	private int dia;
	private int mes;
	private int ano;
	private int tempoLicenca;
	private String medicamento;
	private String frequenciaMedicamento;
	private String comentariosAdicionais;
	private String dataEmissao;
	private String motivoLicenca;
	private String acompanhante;
	private Paciente paciente;

	Scanner scan = new Scanner(System.in);

	public String getAcompanhante() {
		return this.acompanhante;
	}

	public void setAcompanhante(String acompanhante) {
		this.acompanhante = acompanhante;
	}

	public String getMotivoLicenca() {
		return this.motivoLicenca;
	}

	public void setMotivoLicenca(String motivoLicenca) {
		this.motivoLicenca = motivoLicenca;
	}

	public String getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getFrequenciaMedicamento() {
		return this.frequenciaMedicamento;
	}

	public void setFrequenciaMedicamento(String frequenciaMedicamento) {
		this.frequenciaMedicamento = frequenciaMedicamento;
	}

	public String getComentariosAdicionais() {
		return this.comentariosAdicionais;
	}

	public void setComentariosAdicionais(String comentariosAdicionais) {
		this.comentariosAdicionais = comentariosAdicionais;
	}

	public String getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public int getTempoLicenca() {
		return this.tempoLicenca;
	}

	public void setTempoLicenca(int tempoLicenca) {
		this.tempoLicenca = tempoLicenca;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setData(int dia, int mes, int ano) {
		if (!(dia < 1 || dia > 31 || mes < 1 || mes > 12)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
	}

	public String getData() {
		return (dia + "/" + mes + "/" + ano);
	}

	public void gerarReceita(Paciente paciente) {
		System.out.print("MEDICAMENTO INDICADO: ");
		setMedicamento(scan.nextLine());
		System.out.print("FREQUENCIA DE APLICACAO: ");
		setFrequenciaMedicamento(scan.nextLine());
		System.out.print("COMENTARIOS ADICIONAIS (OPCIONAL): ");
		setComentariosAdicionais(scan.nextLine());

		System.out.println("RECEITA GERADA, IMPRIMINDO");
	}

	public void gerarAtestado(Paciente paciente) {
		System.out.print("DATA DE EMISSAO (DD MM AAAA): ");
		setData(scan.nextInt(), scan.nextInt(), scan.nextInt());
		System.out.print("TEMPO DE LICENÇA (DIAS): ");
		setTempoLicenca(scan.nextInt());
		System.out.print("MOTIVO DE LICENÇA: ");
		setMotivoLicenca(scan.nextLine());
		System.out.print("COMENTARIOS ADICIONAIS (OPCIONAL): ");
		setComentariosAdicionais(scan.nextLine());

		System.out.println("ATESTADO GERADO, IMPRIMINDO");
	}

	public void gerarDeclaracaoAcompanhamento(Paciente paciente) {

		System.out.print("NOME DO ACOMPANHANTE: ");
		setAcompanhante(scan.nextLine());
		System.out.print("DATA DE EMISSAO (DD MM AAAA): ");
		setData(scan.nextInt(), scan.nextInt(), scan.nextInt());
		System.out.print("TEMPO DE LICENÇA (DIAS): ");
		setTempoLicenca(scan.nextInt());
		System.out.print("COMENTARIOS ADICIONAIS (OPCIONAL): ");
		setComentariosAdicionais(scan.nextLine());
		System.out.println("DECLARACAO DE ACOMPANHAMENTO GERADA, IMPRIMINDO");
	}

	public int getNumConsultasMensais(ArrayList<Consulta> consulta) {
		int count = 0;
		System.out.print("MÊS E ANO PARA CONSULTA: ");
		int month = scan.nextInt();
		int year = scan.nextInt();
		for (Consulta con : consulta) {
			if ((month == con.getMes()) && (year == con.getAno())) {
				count++;
			}
		}
		return count;
	}

	public void gerarRelatorioMedico(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
		int opcao;
		System.out.println("---GERAR RELATORIO MEDICO---");
		System.out.println("1. RECEITA");
		System.out.println("2. ATESTADO");
		System.out.println("3. DECLARAÇÂO DE ACOMPANHAMENTO");
		System.out.println("4. NUMERO DE CLIENTES ATENDIDOS NO MES");
		System.out.println("5. SAIR");
		System.out.print("ENTRE COM O NÚMERO DESEJADO: ");
		opcao = Integer.parseInt(scan.nextLine());

		Paciente p = null;

		if (opcao < 4) {
			System.out.print("NOME DO PACIENTE: ");
			String nome = scan.nextLine();
			for (Paciente pac : paciente) {
				if (nome.equalsIgnoreCase(pac.getNome())) {
					p = pac;
					break;
				}
			}
		}
		switch (opcao) {
		case 1:
			gerarReceita(p);
			break;
		case 2:
			gerarAtestado(p);
			break;
		case 3:
			gerarDeclaracaoAcompanhamento(p);
			break;
		case 4:
			getNumConsultasMensais(consulta);
			break;
		}
	}
}
