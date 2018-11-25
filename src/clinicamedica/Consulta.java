package clinicamedica;

public class Consulta {
    private int dia, mes, ano; //DATA DA CONSULTA
    private int hora, minuto; //HORÁRIO DA CONSULTA
    private String tipo; //NORMAL (1 HORA) OU RETORNO (30 MINUTOS)
    private Medico medico;
    private Paciente paciente;

    public Consulta() {
        medico = new Medico();
        paciente = new Paciente();
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getData() {
        return (dia + "/" + mes + "/" + ano);
    }

    public void setData(int dia, int mes, int ano) {
        if (!(dia < 1 || dia > 31 || mes < 1 || mes > 12)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    public String getHorario() {
        return (hora + ":" + minuto);
    }

    public void setHorario(String horario) {
        int h = Integer.parseInt(horario.substring(0, 2));
        int m = Integer.parseInt(horario.substring(3, 5));
        if (!(h < 7 || h > 19 || m < 0 || m > 59) && horario.charAt(2) == ':' && horario.length() == 5) {
            this.hora = h;
            this.minuto = m;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if ("RETORNO".equals(tipo.toUpperCase()))
            this.tipo = "RETORNO";
        else
            this.tipo = "NORMAL";
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void imprimeConsulta() {
        System.out.println("-----CONSULTA-----");
        System.out.println("DATA: " + this.getData());
        System.out.println("HORA: " + getHorario());
        System.out.println("TIPO: " + getTipo());
        System.out.println("MÉDICO: " + medico.getNome());
        System.out.println("PACIENTE: " + paciente.getNome());
        System.out.println("\n");
    }
}
