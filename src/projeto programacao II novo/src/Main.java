import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Criar pacientes
        Paciente paciente1 = new Paciente("João Silva", new Date(1990-1900, 5, 15), 1.75, 70);
        Paciente paciente2 = new Paciente("Maria Santos", new Date(1985-1900, 2, 10), 1.68, 65);
        Paciente paciente3 = new Paciente("Carlos Pereira", new Date(2000-1900, 7, 22), 1.80, 80);
        Paciente paciente4 = new Paciente("Ana Costa", new Date(1995-1900, 10, 5), 1.60, 55);

        // Criar técnico de saúde
        TecnicoSaude tecnico = new TecnicoSaude("Carlos Oliveira", new Date(1980-1900, 3, 20), 1.80, 80);

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
        tecnico.adicionarMedicao(paciente1, fc1);
        tecnico.adicionarMedicao(paciente1, temp1);
        tecnico.adicionarMedicao(paciente1, sat1);

        tecnico.adicionarMedicao(paciente2, fc2);
        tecnico.adicionarMedicao(paciente2, temp2);
        tecnico.adicionarMedicao(paciente2, sat2);

        tecnico.adicionarMedicao(paciente3, fc3);
        tecnico.adicionarMedicao(paciente3, temp3);
        tecnico.adicionarMedicao(paciente3, sat3);

        tecnico.adicionarMedicao(paciente4, fc4);
        tecnico.adicionarMedicao(paciente4, temp4);
        tecnico.adicionarMedicao(paciente4, sat4);

        // Criar Hospital e adicionar pacientes
        Hospital hospital = new Hospital();
        hospital.addPaciente(paciente1);
        hospital.addPaciente(paciente2);
        hospital.addPaciente(paciente3);
        hospital.addPaciente(paciente4);

        // Definir um intervalo de datas (exemplo: de 1 de março a 10 de março de 2025)
        Date dataInicio = criarData(2025, 3, 1); // 1 de março de 2025
        Date dataFim = criarData(2025, 3, 10); // 10 de março de 2025

        // Exemplo de lista de pacientes (filtro por nome)
        List<String> nomesFiltro = Arrays.asList("João Silva", "Carlos Pereira");

        // Exemplo 1: Calcular dados para todos os pacientes no intervalo de datas
        System.out.println("=== Exemplo 1: Cálculos para todos os pacientes ===");
        hospital.calcularDados(dataInicio, dataFim, null); // Não filtra por nome

        // Exemplo 2: Calcular dados apenas para um paciente específico
        System.out.println("\n=== Exemplo 2: Cálculos para um paciente específico (João Silva) ===");
        hospital.calcularDados(dataInicio, dataFim, Arrays.asList("João Silva")); // Filtro por nome

        // Exemplo 3: Calcular dados apenas para um conjunto de pacientes (João Silva e Carlos Pereira)
        System.out.println("\n=== Exemplo 3: Cálculos para pacientes João Silva e Carlos Pereira ===");
        hospital.calcularDados(dataInicio, dataFim, nomesFiltro); // Filtro por nome

        // Exemplo 4: Calcular dados para todos os pacientes, mas com outro intervalo de datas (1 a 5 de março)
        Date dataInicioOutro = criarData(2025, 3, 1); // 1 de março de 2025
        Date dataFimOutro = criarData(2025, 3, 5); // 5 de março de 2025
        System.out.println("\n=== Exemplo 4: Cálculos para todos os pacientes (intervalo de 1 a 5 de março) ===");
        hospital.calcularDados(dataInicioOutro, dataFimOutro, null); // Não filtra por nome

        // Exemplo 5: Calcular dados para um único paciente no intervalo de datas específico
        System.out.println("\n=== Exemplo 5: Cálculos para um único paciente (Maria Santos) ===");
        hospital.calcularDados(dataInicio, dataFim, Arrays.asList("Maria Santos")); // Filtro por nome
    }

    // Método para criar data
    private static Date criarData(int ano, int mes, int dia) {
        Calendar cal = Calendar.getInstance();
        cal.set(ano, mes - 1, dia, 0, 0, 0);  // Meses começam em 0, hora, minuto, segundo
        cal.set(Calendar.MILLISECOND, 0);  // Definir milissegundos para 0
        return cal.getTime();
    }
}
