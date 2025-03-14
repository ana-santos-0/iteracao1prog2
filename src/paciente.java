import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {
    //private String nome;
    //private String dataNascimento;
    private double altura;
    private double peso;
    private List<SinalVital> sinalVitais;

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
    //get
    /*public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
*/
    public double getAltura() {
        return altura;
    }

    public double getPeso(){
        return peso;
    }

    
    //Set
    /*public void setNome(String nome){
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
*/
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }

     public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}