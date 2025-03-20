import java.util.List;

public interface Monitorizacao {
    double calcularMedia(List<Double> valores);
    double calcularDesvioPadrao (List <Double> valores);
    double calcularMinimo (List <Double> valores);
    double calcularMaximo (List <Double> valores);
    String classificarPaciente (Paciente paciente);
}
