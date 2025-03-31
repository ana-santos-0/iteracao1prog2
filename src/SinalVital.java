public class SinalVital {
    private double frequenciaCardiaca;
    private double temperaturaCorporal;
    private double saturacaoOxigenio;
    private String dataHora;

    public SinalVital(double frequenciaCardiaca, double temperaturaCorporal, double saturacaoOxigenio, String dataHora) {
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.temperaturaCorporal = temperaturaCorporal;
        this.saturacaoOxigenio = saturacaoOxigenio;
        this.dataHora = dataHora;
    }

    public double getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public double getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public double getSaturacaoOxigenio() {
        return saturacaoOxigenio;
    }

    public String getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        return "SinalVital{" +
                "frequenciaCardiaca=" + frequenciaCardiaca +
                ", temperaturaCorporal=" + temperaturaCorporal +
                ", saturacaoOxigenio=" + saturacaoOxigenio +
                ", dataHora='" + dataHora + '\'' +
                '}';
    }
}
