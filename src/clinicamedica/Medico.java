package clinicamedica;

import java.util.ArrayList;
import java.util.Scanner;

public class Medico extends Pessoa {
    private ArrayList<String> especializacoes;
    Scanner scan = new Scanner(System.in);

    public Medico() {
        especializacoes = new ArrayList();
    }

    public String getEspecializacoes() {
        String esp = "";
        for (String s : especializacoes) {
            esp += s + " ";
        }
        return esp + "\n";
    }

    public void setEspecializacoes(String especializacao) {
        this.especializacoes.add(especializacao);
    }

    public void imprimeDadosMedico() {
        System.out.println("-----MÉDICO-----");
        imprimeDados();
        System.out.print("ESPECIALIZAÇÕES: " + getEspecializacoes());
    }

    private void cadastrarDadosAdicionais(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        String nome, dado;
        int i = 0;
        boolean controle = false;
        System.out.println("-----CADASTRAR DADOS ADICIONAIS-----");
        System.out.print("NOME DO PACIENTE QUE DESEJA CADASTRAR DADOS ADICIONAIS: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == true) {
            System.out.print("BEBE? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setBebe(true);
            else
                p.dadosAdicionais.setBebe(false);

            System.out.print("FUMA? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setFuma(true);
            else
                p.dadosAdicionais.setFuma(false);

            System.out.print("COLESTEROL? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setColesterol(true);
            else
                p.dadosAdicionais.setColesterol(false);

            System.out.print("DIABETES? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setDiabete(true);
            else
                p.dadosAdicionais.setDiabete(false);

            System.out.print("DOENÇA CARDÍACA? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setDoencaCardiaca(true);
            else
                p.dadosAdicionais.setDoencaCardiaca(false);

            System.out.print("NÚMERO DE CIRURGIAS: ");
            i = Integer.parseInt(scan.nextLine());
            for (int j = 1; j < i; j++) {
                System.out.print("CIRURGIA " + j + ": ");
                p.dadosAdicionais.setCirurgias(scan.nextLine());
            }

            System.out.print("NÚMERO DE ALERGIAS: ");
            i = Integer.parseInt(scan.nextLine());
            for (int j = 1; j < i; j++) {
                System.out.print("ALERGIA " + j + ": ");
                p.dadosAdicionais.setAlegias(scan.nextLine());
            }

            System.out.println("DADOS ADICIONAIS CADASTRADOS");
        } else
            System.out.println("PACIENTE NÃO ENCONTRADO");
        menuMedico(paciente, consulta);

    }

    private void atualizarDadosAdicionais(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        String nome, dado;
        int i = 0;
        boolean controle = false;
        System.out.println("-----ALTERAR DADOS ADICIONAIS-----");
        System.out.print("NOME DO PACIENTE QUE DESEJA ALTERAR DADOS ADICIONAIS: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == true) {
            System.out.print("BEBE? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setBebe(true);
            else
                p.dadosAdicionais.setBebe(false);

            System.out.print("FUMA? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setFuma(true);
            else
                p.dadosAdicionais.setFuma(false);

            System.out.print("COLESTEROL? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setColesterol(true);
            else
                p.dadosAdicionais.setColesterol(false);

            System.out.print("DIABETES? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setDiabete(true);
            else
                p.dadosAdicionais.setDiabete(false);

            System.out.print("DOENÇA CARDÍACA? ");
            dado = scan.nextLine();
            if (dado.equalsIgnoreCase("TRUE") || dado.equalsIgnoreCase("SIM") || dado.equalsIgnoreCase("S"))
                p.dadosAdicionais.setDoencaCardiaca(true);
            else
                p.dadosAdicionais.setDoencaCardiaca(false);

            System.out.print("NÚMERO DE CIRURGIAS: ");
            i = Integer.parseInt(scan.nextLine());
            p.dadosAdicionais.removeCirurgias();
            for (int j = 1; j < i; j++) {
                System.out.print("CIRURGIA " + j + ": ");
                p.dadosAdicionais.setCirurgias(scan.nextLine());
            }

            System.out.print("NÚMERO DE ALERGIAS: ");
            i = Integer.parseInt(scan.nextLine());
            p.dadosAdicionais.removeAlergias();
            for (int j = 1; j < i; j++) {
                System.out.print("ALERGIA " + j + ": ");
                p.dadosAdicionais.setAlegias(scan.nextLine());
            }

            System.out.println("DADOS ADICIONAIS CADASTRADOS");
        } else
            System.out.println("PACIENTE NÃO ENCONTRADO");
        menuMedico(paciente, consulta);

    }

    private void removerDadosAdicionais(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        String nome;
        boolean controle = false;
        System.out.println("-----REMOVER DADOS ADICIONAIS-----");
        System.out.print("NOME DO PACIENTE QUE DESEJA REMOVER DADOS ADICIONAIS: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == true)
            p.dadosAdicionais = null;
        else
            System.out.println("PACIENTE NÃO ENCONTRADO");
        menuMedico(paciente, consulta);

    }

    private void cadastrarProntuarioMedico(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        String nome;
        boolean controle = false;
        System.out.println("-----CADASTRAR PRONTUÁRIO MÉDICO-----");
        System.out.print("NOME DO PACIENTE QUE DESEJA CADASTRAR PRONTUÁRIO MÉDICO: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == true) {
            System.out.print("SINTOMAS: ");
            p.prontuarioMedico.setSintomas(scan.nextLine());
            System.out.print("DIAGNÓSTICO: ");
            p.prontuarioMedico.setDiagnostico(scan.nextLine());
            System.out.print("PRESCRIÇÃO: ");
            p.prontuarioMedico.setPrescricao(scan.nextLine());
        } else
            System.out.println("PACIENTE NÃO ENCONTRADO");
        menuMedico(paciente, consulta);

    }

    private void atualizarProntuarioMedico(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        String nome;
        boolean controle = false;
        System.out.println("-----ATUALIZAR PRONTUÁRIO MÉDICO-----");
        System.out.print("NOME DO PACIENTE QUE DESEJA ATUALIZAR PRONTUÁRIO MÉDICO: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == true) {
            System.out.print("SINTOMAS: ");
            p.prontuarioMedico.setSintomas(scan.nextLine());
            System.out.print("DIAGNÓSTICO: ");
            p.prontuarioMedico.setDiagnostico(scan.nextLine());
            System.out.print("PRESCRIÇÃO: ");
            p.prontuarioMedico.setPrescricao(scan.nextLine());
        } else
            System.out.println("PACIENTE NÃO ENCONTRADO");
        menuMedico(paciente, consulta);

    }

    private void removerProntuarioMedico(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        String nome;
        boolean controle = false;
        System.out.println("-----REMOVER PRONTUÁRIO MÉDICO-----");
        System.out.print("NOME DO PACIENTE QUE DESEJA REMOVER PRONTUÁRIO MÉDICO: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == true) {
            p.prontuarioMedico = null;
        } else
            System.out.println("PACIENTE NÃO ENCONTRADO");
        menuMedico(paciente, consulta);

    }

    public int menuMedico(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
        int opcao = 0;
        while (opcao < 1 || opcao > 9) {
            System.out.println("\n-----MENU MÉDICO-----");
            System.out.println("1. CADASTRAR DADOS ADICIONAIS");
            System.out.println("2. ATUALIZAR DADOS ADICIONAIS");
            System.out.println("3. REMOVER DADOS ADICIONAIS");
            System.out.println("4. CADASTRAR PRONTUÁRIO DO PACIENTE");
            System.out.println("5. ATUALIZAR PRONTUÁRIO DO PACIENTE");
            System.out.println("6. REMOVER PRONTUÁRIO DO PACIENTE");
            System.out.println("7. GERAR RELATÓRIO MÉDICO");
            System.out.println("8. SAIR");
            System.out.print("ENTRE COM O NÚMERO DESEJADO: ");
            opcao = Integer.parseInt(scan.nextLine());
        }

        switch (opcao) {
        case 1:
            cadastrarDadosAdicionais(paciente, consulta);
            break;
        case 2:
            atualizarDadosAdicionais(paciente, consulta);
            break;
        case 3:
            removerDadosAdicionais(paciente, consulta);
            break;
        case 4:
            cadastrarProntuarioMedico(paciente, consulta);
            break;
        case 5:
            atualizarProntuarioMedico(paciente, consulta);
            break;
        case 6:
            removerProntuarioMedico(paciente, consulta);
            break;
        case 7:
            RelatorioMedico relatorio = new RelatorioMedico();
            relatorio.gerarRelatorioMedico(paciente, consulta);
            break;
        case 8:
            return 0;

        }
        return 1;
    }
}
