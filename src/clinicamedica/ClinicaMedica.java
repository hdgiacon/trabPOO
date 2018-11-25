package clinicamedica;

import java.util.ArrayList;
import java.util.Scanner;

public class ClinicaMedica {

    public static void imprimePacientes(ArrayList<Paciente> paciente) {
        for (Paciente a : paciente)
            a.imprimeDadosPaciente();
    }

    public static void main(String[] args) {
        ArrayList<Paciente> paciente = new ArrayList();
        ArrayList<Medico> medico = new ArrayList();
        ArrayList<Consulta> consulta = new ArrayList();

        Paciente paciente1 = new Paciente();
        Paciente paciente2 = new Paciente();
        Secretaria secretaria1 = new Secretaria();
        Medico medico1 = new Medico();
        Medico medico2 = new Medico();
        Consulta consulta1 = new Consulta();

        int opcao = 0;
        Scanner scan = new Scanner(System.in);

        paciente1.setNome("Fernando Silva Silvério");
        paciente1.setTelefone("(14) 99628-3857");
        paciente1.setEndereco("Avenida Mario Clapier Urbinati");
        paciente1.setCidade("Maringá");
        paciente1.setNascimento(10, 2, 1997);
        paciente1.setSexo('M');
        paciente1.setConvenio("Santa Rita");
        paciente1.setEmail("fernandosilverio@gmail.com");
        paciente1.dadosAdicionais.setBebe(true);
        paciente1.dadosAdicionais.setDoencaCardiaca(true);
        paciente.add(paciente1);

        paciente2.setNome("Gustavo Belançon Mendes");
        paciente2.setTelefone("(44) 99935-0978");
        paciente2.setEndereco("Avenida Mario Clapier Urbinati");
        paciente2.setCidade("Maringá");
        paciente2.setNascimento(3, 5, 1998);
        paciente2.setSexo('M');
        paciente2.setConvenio("Unimed");
        paciente2.setEmail("mendesbgu@gmail.com");
        paciente2.dadosAdicionais.setFuma(true);
        paciente.add(paciente2);

        secretaria1.setNome("Bruna Reis Maia");
        secretaria1.setTelefone("(11) 99133-6553");
        secretaria1.setEndereco("Barra da Tijuca");
        secretaria1.setCidade("Rio de Janeiro");
        secretaria1.setNascimento(4, 8, 1995);
        secretaria1.setSexo('F');
        secretaria1.setSalario(1274);
        secretaria1.setCargaHoraria(44);
        //secretaria1.imprimeDadosSecretaria();

        medico1.setNome("Daniel Augusto Correia Gilberto");
        medico1.setTelefone("(44) 99910-1467");
        medico1.setEndereco("Rua Marquês de Abrantes");
        medico1.setCidade("Maringá");
        medico1.setNascimento(14, 9, 1998);
        medico1.setSexo('M');
        medico1.setEspecializacoes("Clínico Geral");
        medico1.setEspecializacoes("Ortopedista");
        medico1.setEspecializacoes("Pediatra");
        medico.add(medico1);

        medico2.setNome("Alan Lopes de Sousa Freitas");
        medico2.setTelefone("(44) 99815-3671");
        medico2.setEndereco("Avenida Morangueira");
        medico2.setCidade("Maringá");
        medico2.setNascimento(14, 10, 1998);
        medico2.setSexo('M');
        medico2.setEspecializacoes("Ginecologista");
        medico2.setEspecializacoes("Proctologista");
        medico.add(medico2);

        consulta1.setHorario("12:45");
        consulta1.setTipo("Retorno");
        consulta1.setData(28, 8, 2018);
        consulta1.setMedico(medico1);
        consulta1.setPaciente(paciente1);
        consulta.add(consulta1);
        System.out.println(consulta1.getData());

        while (true) {
            System.out.println("-------MENU-------");
            System.out.println("1. MENU MÉDICO");
            System.out.println("2. MENU SECRETÁRIA");
            System.out.println("3. MENSAGENS");
            System.out.println("4. SAIR");
            System.out.print("DIGITE A OPCAO DESEJADA: ");
            opcao = Integer.parseInt(scan.nextLine());
            System.out.println(opcao);
            while ((opcao != 1) && (opcao != 2) && (opcao != 3) && (opcao != 4)) {
                System.out.println("DIGITE UMA OPCAO VALIDA!!");
                System.out.print("DIGITE A OPÇÃO DESEJADA: ");
                opcao = Integer.parseInt(scan.nextLine());
            }
            switch (opcao) {
            case 1:
                medico1.menuMedico(paciente, consulta);
                break;
            case 2:
                secretaria1.menuSecretaria(paciente, medico, consulta);
                break;
            case 3:
                GerenciadorMensagens gerencMensag = new GerenciadorMensagens(consulta);
                gerencMensag.enviarMensagem();
                break;
            case 4:
                return;
            }
        }
    }

}
