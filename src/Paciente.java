import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//paciente tem como base a superclasse Pessoa
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
//adiciona o sinal vital ao arraylist
    public void adicionarSinalVital(SinalVital sinal){
        sinaisVitais.add(sinal);
    }
//retorna o sinal vital do arraylist
    public List<SinalVital> getSinaisVitais(){
        return sinaisVitais;
    }
//retorna o id
    public int getId() {
        return id;
    }
//retorna o nome
    public String getNome() {
        return nome;
    }
//retorna a DN
    public Date getDataNascimento() {
        return dataNascimento;
    }
//retorna a altura
    public double getAltura() {
        return altura;
    }
//retorna o peso
    public double getPeso() {
        return peso;
    }

// faz a "ficha" dos dados do paciente
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
