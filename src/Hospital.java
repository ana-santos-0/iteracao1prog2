import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hospital {
    private List<Paciente> pacientes;

    public Hospital() {
        this.pacientes = new ArrayList<>();
    }

    // Adiciona um paciente à lista do hospital
    public void addPaciente(Paciente paciente) {
        if (paciente != null) {
            pacientes.add(paciente);
            System.out.println("Paciente " + paciente.getNome() + " adicionado com sucesso.");
        } else {
            System.out.println("Paciente inválido.");
        }
    }

    // Lista todos os pacientes
    public void listarPacientes() {
        for (Paciente p : pacientes) {
            System.out.println(p.getNome() + " - " + p.classificarPaciente());
        }
    }

    // Cálculos para um intervalo de datas e opcionalmente um filtro por nomes
    public void calcularDados(Date dataInicio, Date dataFim, List<String> nomes) {
        List<Paciente> pacientesSelecionados = new ArrayList<>();

        // Se a lista de nomes não estiver vazia, filtra os pacientes
        if (nomes != null && !nomes.isEmpty()) {
            for (Paciente paciente : pacientes) {
                if (nomes.contains(paciente.getNome())) {
                    pacientesSelecionados.add(paciente);
                }
            }
        } else {
            // Se a lista de nomes estiver vazia, considera todos os pacientes
            pacientesSelecionados = pacientes;
        }

        // Para cada paciente selecionado, calcular média, desvio padrão, min, max
        for (Paciente paciente : pacientesSelecionados) {
            System.out.println("Paciente: " + paciente.getNome());

            // Média, Desvio Padrão, Mínimo, Máximo de Frequência Cardíaca
            System.out.println("Média de Frequência Cardíaca: " + paciente.calcularMedia("Frequencia", dataInicio, dataFim));
            System.out.println("Desvio Padrão de Frequência Cardíaca: " + paciente.calcularDesvioPadrao("Frequencia", dataInicio, dataFim));
            System.out.println("Mínimo de Frequência Cardíaca: " + paciente.calcularMinimo("Frequencia", dataInicio, dataFim));
            System.out.println("Máximo de Frequência Cardíaca: " + paciente.calcularMaximo("Frequencia", dataInicio, dataFim));

            // Média, Desvio Padrão, Mínimo, Máximo de Temperatura
            System.out.println("Média de Temperatura: " + paciente.calcularMedia("Temperatura", dataInicio, dataFim));
            System.out.println("Desvio Padrão de Temperatura: " + paciente.calcularDesvioPadrao("Temperatura", dataInicio, dataFim));
            System.out.println("Mínimo de Temperatura: " + paciente.calcularMinimo("Temperatura", dataInicio, dataFim));
            System.out.println("Máximo de Temperatura: " + paciente.calcularMaximo("Temperatura", dataInicio, dataFim));

            // Média, Desvio Padrão, Mínimo, Máximo de Saturação de Oxigênio
            System.out.println("Média de Saturação de Oxigênio: " + paciente.calcularMedia("Saturacao", dataInicio, dataFim));
            System.out.println("Desvio Padrão de Saturação de Oxigênio: " + paciente.calcularDesvioPadrao("Saturacao", dataInicio, dataFim));
            System.out.println("Mínimo de Saturação de Oxigênio: " + paciente.calcularMinimo("Saturacao", dataInicio, dataFim));
            System.out.println("Máximo de Saturação de Oxigênio: " + paciente.calcularMaximo("Saturacao", dataInicio, dataFim));

            System.out.println("Classificação: " + paciente.classificarPaciente());
            System.out.println("----------------------------------");
        }
    }
}
