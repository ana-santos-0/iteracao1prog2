import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Criar pacientes e técnicos
        Paciente paciente1 = new Paciente("João Silva", new Date(1990-1900, 5, 15), 1.75, 70);
        Paciente paciente2 = new Paciente("Maria Santos", new Date(1985-1900, 2, 10), 1.68, 65);
        Paciente paciente3 = new Paciente("Carlos Oliveira", new Date(1980-1900, 3, 20), 1.80, 80);
        Paciente paciente4 = new Paciente("Ana Costa", new Date(1995-1900, 10, 5), 1.60, 55);

        TecnicoSaude tecnico1 = new TecnicoSaude("Carlos Oliveira", new Date(1980-1900, 3, 20), 1.80, 80);
        TecnicoSaude tecnico2 = new TecnicoSaude("Ana Silva", new Date(1985-1900, 11, 15), 1.65, 60);

        Hospital hospital = new Hospital();
        hospital.addPaciente(paciente1);
        hospital.addPaciente(paciente2);
        hospital.addPaciente(paciente3);
        hospital.addPaciente(paciente4);
        hospital.addTecnicoSaude(tecnico1);
        hospital.addTecnicoSaude(tecnico2);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Menu
            System.out.println("=== Sistema de Monitorização Hospitalar ===");
            System.out.println("1. Listar Técnicos de Saúde");
            System.out.println("2. Adicionar Paciente");
            System.out.println("3. Adicionar Técnico de Saúde");
            System.out.println("4. Calcular Dados para Intervalo de Datas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

                    switch (escolha) {
                        case 1:
                            // Listar técnicos de saúde
                            System.out.println("\n=== Técnicos de Saúde ===");
                            hospital.listarTecnicos();
                            break;

                        case 2:
                            // Adicionar paciente
                            System.out.print("\nDigite o nome do paciente: ");
                            String nomePaciente = scanner.nextLine();
                            System.out.print("Digite a data de nascimento (dd/mm/yyyy): ");
                            String dataNascimento = scanner.nextLine();
                            String[] partes = dataNascimento.split("/");
                            Date data = new Date(Integer.parseInt(partes[2])-1900, Integer.parseInt(partes[1])-1, Integer.parseInt(partes[0]));
                            System.out.print("Digite a altura do paciente: ");
                            double altura = scanner.nextDouble();
                            System.out.print("Digite o peso do paciente: ");
                            double peso = scanner.nextDouble();
                            Paciente paciente = new Paciente(nomePaciente, data, altura, peso);
                            hospital.addPaciente(paciente);
                            System.out.println("Paciente adicionado com sucesso!");
                            break;

                        case 3:
                            // Adicionar técnico de saúde
                            System.out.print("\nDigite o nome do técnico de saúde: ");
                            String nomeTecnico = scanner.nextLine();
                            System.out.print("Digite a data de nascimento do técnico (dd/mm/yyyy): ");
                            String dataNascimentoTecnico = scanner.nextLine();
                            partes = dataNascimentoTecnico.split("/");
                            Date dataTecnico = new Date(Integer.parseInt(partes[2])-1900, Integer.parseInt(partes[1])-1, Integer.parseInt(partes[0]));
                            System.out.print("Digite a altura do técnico de saúde: ");
                            double alturaTecnico = scanner.nextDouble();
                            System.out.print("Digite o peso do técnico de saúde: ");
                            double pesoTecnico = scanner.nextDouble();
                            TecnicoSaude tecnico = new TecnicoSaude(nomeTecnico, dataTecnico, alturaTecnico, pesoTecnico);
                            hospital.addTecnicoSaude(tecnico);
                            System.out.println("Técnico de saúde adicionado com sucesso!");
                            break;

                        case 4:
                            // Calcular dados para intervalo de datas
                            System.out.print("\nDigite a data de início (dd/mm/yyyy): ");
                            String dataInicioStr = scanner.nextLine();
                            partes = dataInicioStr.split("/");
                            Date dataInicio = new Date(Integer.parseInt(partes[2])-1900, Integer.parseInt(partes[1])-1, Integer.parseInt(partes[0]));

                            System.out.print("Digite a data de fim (dd/mm/yyyy): ");
                            String dataFimStr = scanner.nextLine();
                            partes = dataFimStr.split("/");
                            Date dataFim = new Date(Integer.parseInt(partes[2])-1900, Integer.parseInt(partes[1])-1, Integer.parseInt(partes[0]));

                            hospital.calcularDados(dataInicio, dataFim, null, null); // Sem filtro
                            break;

                        case 5:
                            // Sair
                            exit = true;
                            System.out.println("Saindo...");
                            break;

                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                    }
                }

                scanner.close();


        // Criar medições com diferentes datas
        FrequenciaCardiaca fc1 = new FrequenciaCardiaca(criarData(2025, 3, 1), 85); // 1 de março de 2025
        Temperatura temp1 = new Temperatura(criarData(2025, 3, 1), 37.0); // 1 de março de 2025
        SaturacaoOxigenio sat1 = new SaturacaoOxigenio(criarData(2025, 3, 1), 97.0); // 1 de março de 2025

        FrequenciaCardiaca fc2 = new FrequenciaCardiaca(criarData(2025, 3, 8), 90); // 10 de março de 2025
        Temperatura temp2 = new Temperatura(criarData(2025, 3, 8), 37.5); // 10 de março de 2025
        SaturacaoOxigenio sat2 = new SaturacaoOxigenio(criarData(2025, 3, 8), 95.0); // 10 de março de 2025

        FrequenciaCardiaca fc3 = new FrequenciaCardiaca(criarData(2025, 3, 3), 92); // 3 de março de 2025
        Temperatura temp3 = new Temperatura(criarData(2025, 3, 3), 37.2); // 3 de março de 2025
        SaturacaoOxigenio sat3 = new SaturacaoOxigenio(criarData(2025, 3, 3), 98.0); // 3 de março de 2025

        FrequenciaCardiaca fc4 = new FrequenciaCardiaca(criarData(2025, 3, 5), 80); // 5 de março de 2025
        Temperatura temp4 = new Temperatura(criarData(2025, 3, 5), 36.8); // 5 de março de 2025
        SaturacaoOxigenio sat4 = new SaturacaoOxigenio(criarData(2025, 3, 5), 96.0); // 5 de março de 2025

        // O técnico de saúde adiciona as medições aos pacientes
        tecnico1.adicionarMedicao(paciente1, fc1);
        tecnico1.adicionarMedicao(paciente1, temp1);
        tecnico1.adicionarMedicao(paciente1, sat1);

        tecnico1.adicionarMedicao(paciente2, fc2);
        tecnico1.adicionarMedicao(paciente2, temp2);
        tecnico1.adicionarMedicao(paciente2, sat2);

        tecnico1.adicionarMedicao(paciente3, fc3);
        tecnico1.adicionarMedicao(paciente3, temp3);
        tecnico1.adicionarMedicao(paciente3, sat3);

        tecnico1.adicionarMedicao(paciente4, fc4);
        tecnico1.adicionarMedicao(paciente4, temp4);
        tecnico1.adicionarMedicao(paciente4, sat4);


        // Listar técnicos de saúde
        System.out.println("=== Técnicos de Saúde no Hospital ===");
        hospital.listarTecnicos();

        // Definir um intervalo de datas (exemplo: de 1 de março a 10 de março de 2025)
        Date dataInicio = criarData(2025, 3, 1); // 1 de março de 2025
        Date dataFim = criarData(2025, 3, 10); // 10 de março de 2025

        // Exemplo 1: Calcular dados para todos os pacientes no intervalo de datas
        System.out.println("=== Exemplo 1: Cálculos para todos os pacientes ===");
        hospital.calcularDados(dataInicio, dataFim, null, null); // Não filtra por nome

        // Exemplo 2: Calcular dados apenas para um paciente específico
        System.out.println("\n=== Exemplo 2: Cálculos para um paciente específico (João Silva) ===");
        hospital.calcularDados(dataInicio, dataFim, Arrays.asList("João Silva"), null); // Filtro por nome

        // Exemplo 3: Calcular dados apenas para um conjunto de pacientes (João Silva e Carlos Pereira)
        System.out.println("\n=== Exemplo 3: Cálculos para pacientes João Silva e Carlos Pereira ===");
        List<String> nomesFiltro = Arrays.asList("João Silva", "Carlos Pereira");
        hospital.calcularDados(dataInicio, dataFim, nomesFiltro, null); // Filtro por nome

        // Exemplo 4: Calcular dados para todos os pacientes, mas com outro intervalo de datas (1 a 5 de março)
        Date dataInicioOutro = criarData(2025, 3, 1); // 1 de março de 2025
        Date dataFimOutro = criarData(2025, 3, 5); // 5 de março de 2025
        System.out.println("\n=== Exemplo 4: Cálculos para todos os pacientes (intervalo de 1 a 5 de março) ===");
        hospital.calcularDados(dataInicioOutro, dataFimOutro, null, null); // Não filtra por nome

        // Exemplo 5: Calcular dados para um único paciente no intervalo de datas específico
        System.out.println("\n=== Exemplo 5: Cálculos para um único paciente (Maria Santos) ===");
        hospital.calcularDados(dataInicio, dataFim, Arrays.asList("Maria Santos"), null); // Filtro por nome

        // Exemplo 6: Calcular dados com ordenação por nome ascendente
        System.out.println("\n=== Exemplo 6: Cálculos com ordenação por nome ascendente ===");
        hospital.calcularDados(dataInicio, dataFim, null, "Asc-Name");

        // Exemplo 7: Calcular dados com ordenação por nome descendente
        System.out.println("\n=== Exemplo 7: Cálculos com ordenação por nome descendente ===");
        hospital.calcularDados(dataInicio, dataFim, null, "Desc-Name");

        // Exemplo 8: Calcular dados com ordenação por data ascendente
        System.out.println("\n=== Exemplo 8: Cálculos com ordenação por data ascendente ===");
        hospital.calcularDados(dataInicio, dataFim, null, "Asc-Date");

        // Exemplo 9: Calcular dados com ordenação por data descendente
        System.out.println("\n=== Exemplo 9: Cálculos com ordenação por data descendente ===");
        hospital.calcularDados(dataInicio, dataFim, null, "Desc-Date");

        //Exemplo 10: Listar Tecnicos
        System.out.println("\n=== Exemplo 9: Listar tecnicos ===");
        hospital.listarTecnicos();
    }
    // Metodo para criar data
    private static Date criarData(int ano, int mes, int dia) {
        return new Date(2025, 03, 03);
    }
}
