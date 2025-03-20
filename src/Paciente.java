import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {
    private double altura;
    private double peso;
    private List<SinalVital> sinaisVitais;

    public Paciente(String nome, Date dataNascimento, double altura, double peso) {
        super(nome, dataNascimento);
        this.altura = altura;
        this.sinaisVitais = new ArrayList<>();
        this.peso = peso;
    }

    public void adicionarSinalVital(SinalVital sinal){
        sinaisVitais.add(sinal);
    }

    public List<SinalVital> getSinaisVitais(){
        return sinaisVitais;
    }


    @Override
     public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", altura=" + altura + " m" +
                ", peso=" + peso + " kg" +
                '}';
    }
}
