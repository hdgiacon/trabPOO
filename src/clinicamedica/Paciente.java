package clinicamedica;

public class Paciente extends Pessoa {
    private String convenio;
    private String email;
    DadosAdicionais dadosAdicionais;
    ProntuarioMedico prontuarioMedico;
    
    public Paciente() {
        dadosAdicionais = new DadosAdicionais();
        prontuarioMedico = new ProntuarioMedico();
    }
    
    public void imprimeDadosPaciente() {
        System.out.println("-----PACIENTE-----");
        imprimeDados();
        System.out.println("CONVÊNIO: " + convenio);
        System.out.println("EMAIL: " + email);
        dadosAdicionais.imprimeDadosAdicionais();
        System.out.println("\n");
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }
    
}
