import java.util.Date;
//superclasse de paciente e tecnico de saude
public class Pessoa {
    private String nome;
    private Date dataNascimento;
//por serem variaveis private
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
//retorna a data de nascimento para o ecrã
    public String toString(){
        return nome + ("Data de Nascimento: " + dataNascimento);
    }
}
