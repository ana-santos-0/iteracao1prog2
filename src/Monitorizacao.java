import java.util.*;
//interface
class Monitorizacao {
//opção para efetuar o cáluclo pedido
    public static void menuCalculoMedidas(SistemaUCI sistemaUCI, Scanner scanner) {
        boolean voltarAoMenuPrincipal = false;
        while (!voltarAoMenuPrincipal) {

            System.out.println("\nMenu - Cálculo de Medidas de Sumário:");
            System.out.println("1. Média");
            System.out.println("2. Desvio Padrão");
            System.out.println("3. Min/Máx");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
        if (escolha == 4) return;
            voltarAoMenuPrincipal = true;
                System.out.println("Voltando ao menu principal...");
                return;
            }
        
        System.out.println("\nCalcular para:");
            System.out.println("1. Um paciente específico");
            System.out.println("2. Um grupo de pacientes");
            System.out.println("3. Todos os pacientes");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();
        
//criaçao do arraylist
        List<Paciente> pacientesSelecionados = new ArrayList<>();
//escolha da opção pretendida
        switch (escolha) {
                case 1:
                    Paciente paciente = selecionarPaciente(sistemaUCI.getPacientes(), scanner);
                    if (paciente != null) pacientesSelecionados.add(paciente);
                    break;
                case 2:
                    pacientesSelecionados = selecionarGrupoPacientes(sistemaUCI.getPacientes(), scanner);
                    break;
                case 3:
                    pacientesSelecionados.addAll(sistemaUCI.getPacientes());
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
        }

            if (!pacientesSelecionados.isEmpty()) {
                calcularMedidas(escolha, pacientesSelecionados);
            } else {
                System.out.println("Nenhum paciente selecionado.");
            }
        }
    }
        
//????? VER
   private static Paciente selecionarPaciente(List<Paciente> pacientes, Scanner scanner) {
        System.out.println("\nLista de Pacientes:");
        for (Paciente p : pacientes) {
            System.out.println("ID: " + p.getId() + " - " + p);
        }
        System.out.print("Escolha o ID do paciente: ");
        int pacienteId = scanner.nextInt();
        return pacientes.stream().filter(p -> p.getId() == pacienteId).findFirst().orElse(null);
    
    }
//seleção dos pacientes para calculos
    private static List<Paciente> selecionarGrupoPacientes(List<Paciente> pacientes, Scanner scanner) {
        List<Paciente> selecionados = new ArrayList<>();

        System.out.print("\nQuantos pacientes deseja incluir? ");
        int numPacientes = scanner.nextInt();

        if (numPacientes < 2) {
            System.out.println("Erro: Deve selecionar pelo menos 2 pacientes!");
            return selecionados;
        }

        for (Paciente p : pacientes) {
            System.out.println("ID: " + p.getId() + " - " + p);
        }

       for (int i = 0; i < numPacientes; i++) {
            System.out.print("Escolha o ID do paciente: ");
            int pacienteId = scanner.nextInt();
            Paciente paciente = pacientes.stream().filter(p -> p.getId() == pacienteId).findFirst().orElse(null);

            if (paciente == null || selecionados.contains(paciente)) {
                System.out.println("Paciente inválido ou já selecionado!");
                i--;
            } else {
                selecionados.add(paciente);
            }
        }
        return selecionados;
    }


   public static void calcularMedidas(int escolha, List<Paciente> pacientes) {
        List<Double> fc = new ArrayList<>();
        List<Double> temp = new ArrayList<>();
        List<Double> sat = new ArrayList<>();

        for (Paciente p : pacientes) {
            for (SinalVital sv : p.getSinaisVitais()) {
                fc.add(sv.getFrequenciaCardiaca());
                temp.add(sv.getTemperaturaCorporal());
                sat.add(sv.getSaturacaoOxigenio());
            }
        }

//resultado consoante a escolha no menu anterior
       switch (escolha) {
            case 1: // Média
                System.out.println("Média da Frequência Cardíaca: " + calcularMedia(fc));
                System.out.println("Média da Temperatura: " + calcularMedia(temp));
                System.out.println("Média da Saturação: " + calcularMedia(sat));
                break;
            case 2: // Desvio Padrão
                System.out.println("Desvio Padrão da Frequência Cardíaca: " + calcularDesvioPadrao(fc));
                System.out.println("Desvio Padrão da Temperatura: " + calcularDesvioPadrao(temp));
                System.out.println("Desvio Padrão da Saturação: " + calcularDesvioPadrao(sat));
                break;
            case 3: // Min/Máx
                System.out.println("Frequência Cardíaca - Mínimo: " + Collections.min(fc) + ", Máximo: " + Collections.max(fc));
                System.out.println("Temperatura - Mínimo: " + Collections.min(temp) + ", Máximo: " + Collections.max(temp));
                System.out.println("Saturação - Mínimo: " + Collections.min(sat) + ", Máximo: " + Collections.max(sat));
                break;
        }
    }

    public static double calcularMedia(List<Double> valores) {
        return valores.stream().mapToDouble(v -> v).average().orElse(0.0);
    }

    public double calcularDesvioPadrao(List<Double> valores) {
        double media = calcularMedia(valores);
        return Math.sqrt(valores.stream().mapToDouble(v -> Math.pow(v - media, 2)).average().orElse(0.0));
    }
//classificar o paciente de acordo com os valores dados
      public static void classificarPacientes(SistemaUCI sistemaUCI) {
        List<Paciente> pacientes = sistemaUCI.getPacientes();
        Map<String, List<Paciente>> classificacoes = new HashMap<>();

        classificacoes.put("Normal", new ArrayList<>());
        classificacoes.put("Atenção", new ArrayList<>());
        classificacoes.put("Crítico", new ArrayList<>());

        for (Paciente paciente : pacientes) {
            if (paciente.getSinaisVitais().isEmpty()) {
                System.out.println("Paciente " + paciente.getNome() + " não possui sinais vitais registrados.");
                continue;

        for (Paciente paciente : pacientes) {
            double FC = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getFrequenciaCardiaca).toList());
            double temp = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getTemperaturaCorporal).toList());
            double sat = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getSaturacaoOxigenio).toList());

           }
            double FC = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getFrequenciaCardiaca).toList());
            double temp = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getTemperaturaCorporal).toList());
            double sat = calcularMedia(paciente.getSinaisVitais().stream().map(SinalVital::getSaturacaoOxigenio).toList());

            String classificacao;
            if (FC >= 60 && FC <= 100 && temp >= 36 && temp <= 37.5 && sat >= 95) {
                classificacao = "Normal";
            } else if ((FC > 100 && FC <= 120) || (temp > 37.5 && temp <= 38.5) || (sat >= 90 && sat < 95)) {
                classificacao = "Atenção";
            } else {
                classificacao = "Crítico";
            }
        }
//?????? VER
      classificacoes.get(classificacao).add(paciente);
        }

        System.out.println("\nClassificação dos Pacientes:");
        for (Map.Entry<String, List<Paciente>> entry : classificacoes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " pacientes");
            for (Paciente p : entry.getValue()) {
                System.out.println("- " + p);
            }
        }
    }
}

