package clinicamedica;

public abstract class Pessoa {
    private String nome, telefone, endereco, cidade;
    private int dia, mes, ano; //DATA DE NASCIMENTO
    private char sexo;

    public Pessoa() {
        //CONSTRUTOR
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.toUpperCase();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.toUpperCase();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    public String getNascimento() {
        return (dia + "/" + mes + "/" + ano);
    }

    public void setNascimento(int dia, int mes, int ano) {
        if (!(dia < 1 || dia > 31 || mes < 1 || mes > 12)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }

    public String getSexo() {
        if (sexo == 'F')
            return "FEMININO";
        else
            return "MASCULINO";
    }

    public void setSexo(char sexo) {
        if (sexo == 'F' || sexo == 'M')
            this.sexo = sexo;
    }

    public void imprimeDados() {
        System.out.println("NOME: " + nome);
        System.out.println("TELEFONE: " + telefone);
        System.out.println("ENDEREÇO: " + endereco);
        System.out.println("CIDADE: " + cidade);
        System.out.println("DATA DE NASCIMENTO: " + getNascimento());
        System.out.println("SEXO: " + getSexo());
    }
}
