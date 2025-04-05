import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Criar pacientes e técnicos
        Paciente paciente1 = new Paciente("João Silva", new Date(1990 - 1900, 5, 15), 1.75, 70);
        Paciente paciente2 = new Paciente("Maria Santos", new Date(1985 - 1900, 2, 10), 1.68, 65);
        Paciente paciente3 = new Paciente("Carlos Oliveira", new Date(1980 - 1900, 3, 20), 1.80, 80);
        Paciente paciente4 = new Paciente("Ana Costa", new Date(1995 - 1900, 10, 5), 1.60, 55);

        TecnicoSaude tecnico1 = new TecnicoSaude("Rui Oliveira", new Date(1980 - 1900, 3, 20), 1.80, 80);
        TecnicoSaude tecnico2 = new TecnicoSaude("Ana Silva", new Date(1985 - 1900, 11, 15), 1.65, 60);

        Hospital hospital = new Hospital();
        hospital.addPaciente(paciente1);
        hospital.addPaciente(paciente2);
        hospital.addPaciente(paciente3);
        hospital.addPaciente(paciente4);
        hospital.addTecnicoSaude(tecnico1);
        hospital.addTecnicoSaude(tecnico2);

        // Criar medições e atribuir
        tecnico1.adicionarMedicao(paciente1, new FrequenciaCardiaca(criarData(2025, 3, 1), 85));
        tecnico1.adicionarMedicao(paciente1, new Temperatura(criarData(2025, 3, 1), 37.0));
        tecnico1.adicionarMedicao(paciente1, new SaturacaoOxigenio(criarData(2025, 3, 1), 97.0));

        tecnico1.adicionarMedicao(paciente2, new FrequenciaCardiaca(criarData(2025, 3, 8), 90));
        tecnico1.adicionarMedicao(paciente2, new Temperatura(criarData(2025, 3, 8), 37.5));
        tecnico1.adicionarMedicao(paciente2, new SaturacaoOxigenio(criarData(2025, 3, 8), 95.0));

        tecnico1.adicionarMedicao(paciente3, new FrequenciaCardiaca(criarData(2025, 3, 3), 92));
        tecnico1.adicionarMedicao(paciente3, new Temperatura(criarData(2025, 3, 3), 37.2));
        tecnico1.adicionarMedicao(paciente3, new SaturacaoOxigenio(criarData(2025, 3, 3), 98.0));

        tecnico1.adicionarMedicao(paciente4, new FrequenciaCardiaca(criarData(2025, 3, 5), 80));
        tecnico1.adicionarMedicao(paciente4, new Temperatura(criarData(2025, 3, 5), 36.8));
        tecnico1.adicionarMedicao(paciente4, new SaturacaoOxigenio(criarData(2025, 3, 5), 96.0));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Sistema de Monitorização Hospitalar ===");
            System.out.println("1. Listar Técnicos de Saúde");
            System.out.println("2. Adicionar Paciente");
            System.out.println("3. Adicionar Técnico de Saúde");
            System.out.println("4. Calcular Dados para Intervalo de Datas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("\n=== Técnicos de Saúde ===");
                    hospital.listarTecnicos();
                    break;

                case 2:
                    Paciente.infoPaciente();
                    hospital.addPaciente(Paciente.novoPaciente);
                    break;

                case 3:
                    TecnicoSaude.infoTecnicoSaude();
                    hospital.addTecnicoSaude(TecnicoSaude.novoTecnicoSaude);
                    break;

                case 4:
                    System.out.print("\nData de início (dd/mm/yyyy): ");
                    String[] partes = scanner.nextLine().split("/");
                    Date dataInicio = new Date(Integer.parseInt(partes[2]) - 1900, Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[0]));

                    System.out.print("Data de fim (dd/mm/yyyy): ");
                    partes = scanner.nextLine().split("/");
                    Date dataFim = new Date(Integer.parseInt(partes[2]) - 1900, Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[0]));

                    System.out.print("Deseja filtrar por nomes? (sim/não): ");
                    String resposta = scanner.nextLine();
                    List<String> nomes = null;
                    if (resposta.equalsIgnoreCase("sim")) {
                        nomes = new ArrayList<>();
                        System.out.println("Digite os nomes (um por linha, vazio para terminar): ");
                        while (true) {
                            String nome = scanner.nextLine();
                            if (nome.isEmpty()) break;
                            nomes.add(nome);
                        }
                    }

                    System.out.print("Ordenar por (Ascendente-Name, Descendente-Name, Asc-Date, Desc-Date) ou enter para nenhum: ");
                    String ordem = scanner.nextLine();
                    if (ordem.isEmpty()) ordem = null;

                    hospital.calcularDados(dataInicio, dataFim, nomes, ordem);
                    break;

                case 5:
                    exit = true;
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    // Corrigido: agora cria a data corretamente
    private static Date criarData(int ano, int mes, int dia) {
        return new Date(ano - 1900, mes - 1, dia);
    }
}
