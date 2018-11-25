package clinicamedica;

import java.util.ArrayList;
import java.util.Scanner;

//nao precisa cadastrar secretaria

public class Secretaria extends Pessoa {
    private double salario;
    private int cargaHoraria; //CARGA HORÁRIA SEMANAL
    Scanner scan = new Scanner(System.in);

    public Secretaria() {
        //CONSTRUTOR
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria > 0)
            this.cargaHoraria = cargaHoraria;
    }

    public void imprimeDadosSecretaria() {
        System.out.println("-----SECRETARIA-----");
        imprimeDados();
        System.out.println("SALÁRIO: " + salario);
        System.out.println("CARGA HORÁRIA: " + cargaHoraria + " HORAS SEMANAIS");
        System.out.println();
    }

    private void cadastrarPaciente(ArrayList<Paciente> paciente) {
        Paciente p = new Paciente();
        System.out.println("-----CADASTRO DE PACIENTE-----");
        System.out.print("NOME DO PACIENTE: ");
        p.setNome(scan.nextLine());
        System.out.print("TELEFONE DO PACIENTE: ");
        p.setTelefone(scan.nextLine());
        System.out.print("ENDEREÇO DO PACIENTE: ");
        p.setEndereco(scan.nextLine());
        System.out.print("CIDADE DO PACIENTE: ");
        p.setCidade(scan.nextLine());
        System.out.print("SEXO DO PACIENTE: ");
        p.setSexo(scan.nextLine().charAt(0));
        while ("0/0/0".equals(p.getNascimento())) {
            System.out.print("DIA DO ANIVERSÁRIO DO PACIENTE: ");
            int dia = Integer.parseInt(scan.nextLine());
            System.out.print("MÊS DO ANIVERSÁRIO DO PACIENTE: ");
            int mes = Integer.parseInt(scan.nextLine());
            System.out.print("ANO DO ANIVERSÁRIO DO PACIENTE: ");
            int ano = Integer.parseInt(scan.nextLine());
            p.setNascimento(dia, mes, ano);
        }
        System.out.print("CONVÊNIO DO PACIENTE: ");
        p.setConvenio(scan.nextLine());
        System.out.print("E-MAIL DO PACIENTE: ");
        p.setEmail(scan.nextLine());
        paciente.add(p);
        System.out.println("PACIENTE CADASTRADO");
    }

    private void atualizarPaciente(ArrayList<Paciente> paciente) {
        Paciente p = new Paciente();
        String nome;
        boolean controle = false;
        System.out.println("-----ALTERAÇÃO DE PACIENTE-----");
        System.out.print("NOME DO PACIENTE QUE DESEJA ALTERAR: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }

        if (controle == true) {
            System.out.print("NOME DO PACIENTE: ");
            p.setNome(scan.nextLine());
            System.out.print("TELEFONE DO PACIENTE: ");
            p.setTelefone(scan.nextLine());
            System.out.print("ENDEREÇO DO PACIENTE: ");
            p.setEndereco(scan.nextLine());
            System.out.print("CIDADE DO PACIENTE: ");
            p.setCidade(scan.nextLine());
            System.out.print("SEXO DO PACIENTE: ");
            p.setSexo(scan.nextLine().charAt(0));
            do {
                System.out.print("DIA DO ANIVERSÁRIO DO PACIENTE: ");
                int dia = Integer.parseInt(scan.nextLine());
                System.out.print("MÊS DO ANIVERSÁRIO DO PACIENTE: ");
                int mes = Integer.parseInt(scan.nextLine());
                System.out.print("ANO DO ANIVERSÁRIO DO PACIENTE: ");
                int ano = Integer.parseInt(scan.nextLine());
                p.setNascimento(dia, mes, ano);
            } while ("0/0/0".equals(p.getNascimento()));
            System.out.print("CONVÊNIO DO PACIENTE: ");
            p.setConvenio(scan.nextLine());
            System.out.print("E-MAIL DO PACIENTE: ");
            p.setEmail(scan.nextLine());

            System.out.println("PACIENTE ATUALIZADO");
        } else
            System.out.println("PACIENTE NÃO ENCONTRADO");
    }

    private void removerPaciente(ArrayList<Paciente> paciente, ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        Consulta c = new Consulta();
        String nome;
        boolean controle = false;
        System.out.println("-----REMOÇÃO DE PACIENTE-----");
        System.out.print("NOME DO PACIENTE QUE DESEJA REMOVER: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }

        if (controle == true) {
            for (Consulta con : consulta) {
                if (con.getPaciente().equals(p)) {
                    c = con;
                    consulta.remove(c);
                    break;
                }
            }
            paciente.remove(p);
            System.out.println("PACIENTE REMOVIDO");
        } else
            System.out.println("PACIENTE NÃO ENCONTRADO");
    }

    private void cadastrarConsulta(ArrayList<Paciente> paciente, ArrayList<Medico> medico,
            ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        Medico m = new Medico();
        Consulta c = new Consulta();
        boolean controle = false;
        String nome;

        System.out.println("-----CADASTRO DE CONSULTA-----");
        System.out.print("NOME DO PACIENTE: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == false) {
            System.out.println("PACIENTE NÃO ENCONTRADO");
            return;
        }
        c.setPaciente(p);

        System.out.print("NOME DO MÉDICO: ");
        nome = scan.nextLine();
        for (Medico med : medico) {
            if (nome.equalsIgnoreCase(med.getNome())) {
                controle = true;
                m = med;
                break;
            }
        }
        if (controle == false) {
            System.out.println("MÉDICO NÃO ENCONTRADO");
            return;
        }
        c.setMedico(m);

        System.out.print("DIA DA CONSULTA: ");
        int d = Integer.parseInt(scan.nextLine());
        System.out.print("MÊS DA CONSULTA: ");
        int ms = Integer.parseInt(scan.nextLine());
        System.out.print("ANO DA CONSULTA: ");
        int a = Integer.parseInt(scan.nextLine());
        c.setData(d, ms, a);
        String dat = d + "/" + ms + "/" + a;
        System.out.print("HORA DA CONSULTA: ");
        String hr = scan.nextLine();
        c.setHorario(hr);
        if ("0:0".equals(hr)) {
            System.out.println("HORA INVÁLIDA");
            return;
        }
        for (Consulta con : consulta) {
            if ((!dat.equals(con.getData()) || (!hr.equals(con.getHorario())))) {
                controle = true;
                c = con;
                break;
            }
        }
        if (controle == false) {
            System.out.println("JÁ POSSUI UMA CONSULTA AGENDADA PARA ESSE DIA E HORA");
            return;
        }
        c.setData(d, ms, a);
        c.setHorario(hr);

        System.out.print("TIPO DA CONSULTA: ");
        c.setTipo(scan.nextLine());

        consulta.add(c);
        System.out.println("CONSULTA AGENDADA");

    }

    private void atualizarConsulta(ArrayList<Paciente> paciente, ArrayList<Medico> medico,
            ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        Medico m = new Medico();
        Consulta c = new Consulta();
        boolean controle = false;
        String nome;

        System.out.println("-----ATUALIZAÇÃO DE CONSULTA-----");
        System.out.print("NOME DO PACIENTE: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == false) {
            System.out.println("PACIENTE NÃO ENCONTRADO");
            return;
        }

        System.out.print("NOME DO MÉDICO: ");
        nome = scan.nextLine();
        for (Medico med : medico) {
            if (nome.equalsIgnoreCase(med.getNome())) {
                controle = true;
                m = med;
                break;
            }
        }
        if (controle == false) {
            System.out.println("MÉDICO NÃO ENCONTRADO");
            return;
        }

        System.out.print("DIA DA CONSULTA: ");
        int d = Integer.parseInt(scan.nextLine());
        System.out.print("MÊS DA CONSULTA: ");
        int ms = Integer.parseInt(scan.nextLine());
        System.out.print("ANO DA CONSULTA: ");
        int a = Integer.parseInt(scan.nextLine());
        c.setData(d, ms, a);
        String dat = d + "/" + ms + "/" + a;
        System.out.print("HORA DA CONSULTA: ");
        String hr = scan.nextLine();
        c.setHorario(hr);
        if ("0:0".equals(hr)) {
            System.out.println("HORA INVÁLIDA");
            return;
        }
        for (Consulta con : consulta) {
            if ((!dat.equals(con.getData()) || (!hr.equals(con.getHorario())))) {
                controle = true;
                c = con;
                break;
            }
        }
        if (controle == false) {
            System.out.println("JÁ POSSUI UMA CONSULTA AGENDADA PARA ESSE DIA E HORA");
            return;
        }

        System.out.print("TIPO DA CONSULTA: ");
        String consult = scan.nextLine();

        for (Consulta con1 : consulta) {
            if ((con1.getPaciente().equals(p)) && (con1.getMedico().equals(m))) {
                c = con1;
                break;
            }
        }
        c.setHorario(hr);
        c.setData(a, ms, a);
        c.setTipo(consult);
        System.out.println("CONSULTA ATUALIZADA");
    }

    private void removerConsulta(ArrayList<Paciente> paciente, ArrayList<Medico> medico, ArrayList<Consulta> consulta) {
        Paciente p = new Paciente();
        Medico m = new Medico();
        Consulta c = new Consulta();
        boolean controle = false;
        String nome;

        System.out.println("-----REMOÇÃO DE CONSULTA-----");
        System.out.print("NOME DO PACIENTE: ");
        nome = scan.nextLine();
        for (Paciente pac : paciente) {
            if (nome.equalsIgnoreCase(pac.getNome())) {
                controle = true;
                p = pac;
                break;
            }
        }
        if (controle == false) {
            System.out.println("PACIENTE NÃO ENCONTRADO");
            return;
        }

        System.out.print("NOME DO MÉDICO: ");
        nome = scan.nextLine();
        for (Medico med : medico) {
            if (nome.equalsIgnoreCase(med.getNome())) {
                controle = true;
                m = med;
                break;
            }
        }
        if (controle == false) {
            System.out.println("MÉDICO NÃO ENCONTRADO");
            return;
        }

        for (Consulta con : consulta) {
            if ((con.getPaciente().equals(p)) && (con.getMedico().equals(m))) {
                c = con;
                break;
            }
        }
        consulta.remove(c);
        System.out.println("CONSULTA REMOVIDA");
    }

    public void gerarRelatorioDeConsulta(ArrayList<Consulta> consulta) {
        int day, month, year;
        System.out.println("-----GERAR RELATÓRIO DE CONSULTA----");
        System.out.print("DIA: ");
        day = Integer.parseInt(scan.nextLine());
        System.out.print("MÊS: ");
        month = Integer.parseInt(scan.nextLine());
        System.out.print("ANO: ");
        year = Integer.parseInt(scan.nextLine());

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
        System.out.println("CONSULTAS DO DIA: " + data);

        for (Consulta con : consulta) {
            if (data.equals(con.getData())) {
                System.out.println("PACIENTE: " + con.getPaciente().getNome());
                System.out.println("MÉDICO: " + con.getMedico().getNome());
                System.out.println("HORÁRIO: " + con.getHorario() + "\n");
            }
        }
    }

    public int menuSecretaria(ArrayList<Paciente> paciente, ArrayList<Medico> medico, ArrayList<Consulta> consulta) {
        int opcao = 0;
        while (opcao < 1 || opcao > 9) {
            System.out.println("\n-----MENU SECRETÁRIA----");
            System.out.println("1. CADASTRAR PACIENTE");
            System.out.println("2. ATUALIZAR PACIENTE");
            System.out.println("3. REMOVER PACIENTE");
            System.out.println("4. CADASTRAR CONSULTA");
            System.out.println("5. ATUALIZAR CONSULTA");
            System.out.println("6. REMOVER CONSULTA");
            System.out.println("7. GERAR RELATÓRIO DE CONSULTA");
            System.out.println("8. SAIR");
            System.out.print("ENTRE COM O NÚMERO DESEJADO: ");
            opcao = Integer.parseInt(scan.nextLine());
        }

        switch (opcao) {
        case 1:
            cadastrarPaciente(paciente);
            menuSecretaria(paciente, medico, consulta);
            break;
        case 2:
            atualizarPaciente(paciente);
            menuSecretaria(paciente, medico, consulta);
            break;
        case 3:
            removerPaciente(paciente, consulta);
            menuSecretaria(paciente, medico, consulta);
            break;
        case 4:
            cadastrarConsulta(paciente, medico, consulta);
            menuSecretaria(paciente, medico, consulta);
            break;
        case 5:
            atualizarConsulta(paciente, medico, consulta);
            menuSecretaria(paciente, medico, consulta);
            break;
        case 6:
            removerConsulta(paciente, medico, consulta);
            menuSecretaria(paciente, medico, consulta);
            break;
        case 7:
            gerarRelatorioDeConsulta(consulta);
            menuSecretaria(paciente, medico, consulta);
            break;
        case 8:
            return 0;

        }
        return 1;
    }
}
