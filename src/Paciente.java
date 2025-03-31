import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Paciente extends Pessoa {
    private static int idCounter = 0;
    private int id;
    private double altura;
    private double peso;
    private List<SinalVital> sinaisVitais;

    public Paciente(String nome, Date dataNascimento, double altura, double peso) {
        super(nome, dataNascimento);
        this.id = ++idCounter;
        this.altura = altura;
        this.peso = peso;
        this.sinaisVitais = new ArrayList<>();
    }

    public void adicionarSinalVital(SinalVital sinal){
        sinaisVitais.add(sinal);
    }

    public List<SinalVital> getSinaisVitais(){
        return sinaisVitais;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }


}
