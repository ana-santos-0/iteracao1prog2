import java.util.Date;

public class TecnicoSaude extends Pessoa {

    public TecnicoSaude(String nome, Date dataNascimento, double altura, double peso) {
        super(nome, dataNascimento, altura, peso);
    }

    /**
     * Metodo para adicionar uma medição ao paciente.
     * @param paciente Paciente ao qual a medição será adicionada.
     * @param medicao Medição a ser adicionada.
     */
    public void adicionarMedicao(Paciente paciente, Medicao medicao) {
        paciente.addMedicao(medicao); // O metodo addMedicao ainda é chamado para adicionar a medição ao paciente
        System.out.println("Medição de tipo " + medicao.getClass().getSimpleName() + " foi adicionada ao paciente " + paciente.getNome());
    }
}
