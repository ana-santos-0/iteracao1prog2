import java.util.Date;

/**
 * Classe base que representa uma pessoa.
 */
public class Pessoa {
    private String nome;
    private Date dataNascimento;
    private double altura;
    private double peso;

    public Pessoa(String nome, Date dataNascimento, double altura, double peso) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
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
}
