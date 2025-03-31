
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Monitorizacao {

    public static void calcularMediasPacientes(List<Paciente> pacientes, Monitorizacao monitorizacao) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos pacientes deseja incluir no cálculo da média? ");
        int numPacientes = sc.nextInt();

        List<Paciente> pacientesSelecionados = new ArrayList<>();

        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + " - " + paciente);
        }

        for (int i = 0; i < numPacientes; i++) {
            System.out.print("Escolha o ID do paciente: ");
            int pacienteId = sc.nextInt();

            Paciente pacienteSelecionado = pacientes.stream()
                    .filter(p -> p.getId() == pacienteId)
                    .findFirst()
                    .orElse(null);

            if (pacienteSelecionado == null) {
                System.out.println("Paciente não encontrado! Tente novamente.");
                i--; // Decrementa para que o usuário possa inserir um ID válido
            } else if (pacientesSelecionados.contains(pacienteSelecionado)) {
                System.out.println("Este paciente já foi selecionado! Escolha outro.");
                i--; // Decrementa para evitar contagem errada
            } else {
                pacientesSelecionados.add(pacienteSelecionado);
            }
        }

        List<Double> mediasFC = new ArrayList<>();
        List<Double> mediasTemp = new ArrayList<>();
        List<Double> mediasSat = new ArrayList<>();

        for (Paciente paciente : pacientesSelecionados) {
            for (SinalVital sv : paciente.getSinaisVitais()) {
                mediasFC.add(sv.getFrequenciaCardiaca());
                mediasTemp.add(sv.getTemperaturaCorporal());
                mediasSat.add(sv.getSaturacaoOxigenio());
            }
        }

        System.out.println("Média da Frequência Cardíaca: " + monitorizacao.calcularMedia(mediasFC));
        System.out.println("Média da Temperatura: " + monitorizacao.calcularMedia(mediasTemp));
        System.out.println("Média da Saturação: " + monitorizacao.calcularMedia(mediasSat));
    }

    public double calcularMedia(List<Double> valores) {
        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }
        return soma / valores.size();
    }

    public double calcularDesvioPadrao(List<Double> valores) {
        double media = calcularMedia(valores);
        double soma = 0;
        for (double valor : valores) {
            soma += Math.pow(valor - media, 2);
        }
        return Math.sqrt(soma / valores.size());
    }

    public double calcularMinimo(List<Double> valores) {
        double min = Double.MAX_VALUE;
        for (double valor : valores) {
            if (valor < min) {
                min = valor;
            }
        }
        return min;
    }

    public double calcularMaximo(List<Double> valores) {
        double max = Double.MIN_VALUE;
        for (double valor : valores) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }

    public String classificarPaciente(Paciente paciente) {
        double FC = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getFrequenciaCardiaca).toList());
        double temp = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getTemperaturaCorporal).toList());
        double sat = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getSaturacaoOxigenio).toList());

        if (FC >= 60 && FC <= 100 && temp >= 36 && temp <= 37.5 && sat >= 95) {
            return "Normal";
        } else if ((FC > 100 && FC <= 120) || (temp > 37.5 && temp <= 38.5) || (sat >= 90 && sat < 95)) {
            return "Atenção";
        } else {
            return "Crítico";
        }
    }

}
