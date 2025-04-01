import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main extends Monitorizacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        Monitorizacao monitorizacao = new Monitorizacao();
        boolean exit = false;

        //criação de um login de forma a facilitar e proteger os dados dos utentes
        System.out.println("login:");
        Scanner sc = new Scanner(System.in);

//menu inicial
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Criar Paciente");
            System.out.println("2. Inserir Valores de Sinais Vitais");
            System.out.println("3. Calcular Médias de Pacientes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
//escolha da opção
            switch (opcao) {
                case 1:
                    Paciente novoPaciente = criarPaciente();
                    if (novoPaciente != null) {
                        pacientes.add(novoPaciente);
                        System.out.println("Paciente criado com sucesso!");
                    } else {
                        System.out.println("Erro ao criar o paciente.");
                    }
                    break;

                case 2:
                    if (!pacientes.isEmpty()) {
                        pedirValores(pacientes);
                    } else {
                        System.out.println("Não há pacientes registados.");
                    }
                    break;

                case 3:
                    if (!pacientes.isEmpty()) {
                        Monitorizacao.calcularMediasPacientes(pacientes, monitorizacao);
                    } else {
                        System.out.println("Não há pacientes registados.");
                    }
                    break;

                case 4:
                    exit = true;
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
//criação de um paciente com os respetivos dados acoplados
    public static Paciente criarPaciente(){
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento (YYYY-MM-DD): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento;
        try {
            dataNascimento = dateFormat.parse(dataNascimentoStr);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Data de nascimento inválida. Use o formato YYYY-MM-DD.");
            return null;
        }

        System.out.print("Altura (em centimetros): ");
        double altura = scanner.nextDouble();

        System.out.print("Peso (em kg): ");
        double peso = scanner.nextDouble();

        return new Paciente(nome, dataNascimento, altura, peso);
    }

    public static void pedirValores(List<Paciente> pacientes) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }

        System.out.print("Escolha o ID do paciente para inserir os valores de sinais vitais: ");
        int pacienteId = sc.nextInt();

        Paciente pacienteEscolhido = pacientes.stream()
                .filter(p -> p.getId() == pacienteId)
                .findFirst()
                .orElse(null);

        if (pacienteEscolhido == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }
//verificação do valor de FC
        boolean inserirMais = true;
        while (inserirMais) {
            double FC;
            while (true) {
                System.out.print("Insira o valor de FC: ");
                FC = sc.nextDouble();
                if (Verificacoes.verificarValoresFC(FC)) break;
                System.out.println("Valor de Frequência Cardíaca Inválido.!");
            }
//verificação do valor de Sat
            double Sat;
            while (true) {
                System.out.print("Insira o valor de Saturação: ");
                Sat = sc.nextDouble();
                if (Verificacoes.verificarValoresSat(Sat)) break;
                System.out.println("Valor de Saturação inválido.");
            }
//verfificação do valor de Temp
            double Temp;
            while (true) {
                System.out.print("Insira o valor de temperatura: ");
                Temp = sc.nextDouble();
                if (Verificacoes.verificarValoresTemp(Temp)) break;
                System.out.println("Valor de Temperatura inválido.");
            }
//incrição de data e hora nos sinais
            SinalVital sinalVital = new SinalVital(FC, Temp, Sat, "2025-03-22 10:00:00");

            pacienteEscolhido.adicionarSinalVital(sinalVital);
            System.out.println("Sinal Vital adicionado com sucesso!");

            // Perguntar se deseja inserir mais sinais vitais
            System.out.print("Deseja inserir mais sinais vitais para este paciente? (s/n): ");
            String resposta = sc.next();
            if (!resposta.equalsIgnoreCase("s")) {
                inserirMais = false;
            }
        }

        // Exibir todos os sinais vitais do paciente
        System.out.println("Sinais Vitais do Paciente " + pacienteEscolhido.getNome() + ":");
        for (SinalVital sv : pacienteEscolhido.getSinaisVitais()) {
            System.out.println(sv);
        }
    }

}
