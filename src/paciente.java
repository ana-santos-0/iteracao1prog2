public class Paciente {
    private int frequenciaCardiaca;
    private double temperatura;
    private int saturacao;

    public Paciente(int frequenciaCardiaca, double temperatura, int saturacao) {
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.temperatura = temperatura;
        this.saturacao = saturacao;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getSaturacao() {
        return saturacao;
    }
}
