package clinicamedica;

import java.util.ArrayList;

public class DadosAdicionais {
    private boolean fuma, bebe, colesterol, diabete, doencaCardiaca;
    private ArrayList<String> cirurgias;
    private ArrayList<String> alergias;

    public DadosAdicionais() {
        cirurgias = new ArrayList();
        alergias = new ArrayList();
    }

    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public boolean isBebe() {
        return bebe;
    }

    public void setBebe(boolean bebe) {
        this.bebe = bebe;
    }

    public boolean isColesterol() {
        return colesterol;
    }

    public void setColesterol(boolean colesterol) {
        this.colesterol = colesterol;
    }

    public boolean isDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean isDoencaCardiaca() {
        return doencaCardiaca;
    }

    public void setDoencaCardiaca(boolean doencaCardiaca) {
        this.doencaCardiaca = doencaCardiaca;
    }

    public String getCirurgias() {
        String esp = "";
        for (String s : cirurgias) {
            esp += s + " ";
        }
        return esp + "\n";
    }

    public void setCirurgias(String cirurgia) {
        this.cirurgias.add(cirurgia);
    }

    public void removeCirurgias() {
        this.cirurgias.clear();
    }

    public String getAlergias() {
        String esp = "";
        for (String s : alergias) {
            esp += s + " ";
        }
        return esp + "\n";
    }

    public void setAlegias(String alergia) {
        this.alergias.add(alergia);
    }

    public void removeAlergias() {
        this.alergias.clear();
    }

    public void imprimeDadosAdicionais() {
        System.out.print("DADOS ADICIONAIS: ");
        if (isFuma())
            System.out.print("FUMA");

        if (isFuma() && isBebe())
            System.out.print(", ");
        if (isBebe())
            System.out.print("BEBE");

        if ((isFuma() || isBebe()) && isColesterol())
            System.out.print(", ");
        if (isColesterol())
            System.out.print("COLESTEROL");

        if ((isFuma() || isBebe() || isColesterol()) && isDiabete())
            System.out.print(", ");
        if (isDiabete())
            System.out.print("DIABETE");

        if ((isFuma() || isBebe() || isColesterol() || isDiabete()) && isDoencaCardiaca())
            System.out.print(", ");
        if (isDoencaCardiaca())
            System.out.print("DOENÇA CARDÍACA");
    }

}
