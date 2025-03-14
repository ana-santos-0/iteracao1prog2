import java.util.Date;

public class Pessoa {
    private String nome;
    private Date dataNascimento;

    public Pessoa(String nome, Date dataNascimento){
        this.nome=nome;
        this.dataNascimento=dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Date getDateNascimento() {
        return dataNascimento;
    }

    public String toString(){
        return nome + ("Data de Nascimento: " + dataNascimento);
    }
}
