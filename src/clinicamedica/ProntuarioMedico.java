package clinicamedica;

public class ProntuarioMedico {
    private String sintomas, diagnostico, prescricao;
    
    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
    
    public void imprimeProntuarioMedico() {
        System.out.println("-----PRONTUÁRIO MÉDICO-----");
        System.out.println("SINTOMAS: " + sintomas);
        System.out.println("DIAGNÓSTICO: " + diagnostico);
        System.out.println("PRESCRIÇÃO: " + prescricao);
    }
    
}
