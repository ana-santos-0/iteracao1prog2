import java.util.Date;
import java.util.Scanner;

public class TecnicoSaude extends Pessoa {
    public static TecnicoSaude novoTecnicoSaude;

    public TecnicoSaude(String nome, Date dataNascimento, double altura, double peso) {
        super(nome, dataNascimento, altura, peso);
    }

    /**
     * Metodo para adicionar uma medição ao paciente.
     *
     * @param paciente Paciente ao qual a medição será adicionada.
     * @param medicao  Medição a ser adicionada.
     */
    public void adicionarMedicao(Paciente paciente, Medicao medicao) {
        paciente.addMedicao(medicao); // O metodo addMedicao ainda é chamado para adicionar a medição ao paciente
        System.out.println("Medição de tipo " + medicao.getClass().getSimpleName() + " foi adicionada ao paciente " + paciente.getNome());
    }

    public static void infoTecnicoSaude() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nNome do técnico: ");
        String nomeTec = scanner.nextLine();
        System.out.print("Insira a data de nascimento (dd/mm/yyyy): ");
        String[] partes = scanner.nextLine().split("/");
        Date dataTec = new Date(Integer.parseInt(partes[2]) - 1900, Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[0]));
        System.out.print("Insira a altura: ");
        double altTec = scanner.nextDouble();
        System.out.print("Insira o peso: ");
        double pesTec = scanner.nextDouble();
        scanner.nextLine();
        Paciente novoTecnico = new Paciente(nomeTec, dataTec, altTec, pesTec);
        System.out.println("Técnico adicionado com sucesso!");
        return;
    }
}