import java.util.Date;

public class TecnicoSaude extends Pessoa {
    private String categoriaProfissional;

    public TecnicoSaude (String nome, Date dataNascimento, String categoriaProfissional){
        super(nome, dataNascimento);
        this.categoriaProfissional = categoriaProfissional;
    }

    public String getCategoriaProfissional(){
        return categoriaProfissional;
    }

    public String toString(){
        return categoriaProfissional;
    }
}
    public String toString(String categoriaProfissional) {
        return "TecnicoSaude{" +
                "nome='" + Pessoa.nome + '\'' +
                ", dataNascimento=" + Pessoa.dataNascimento +
                ", categoriaProfissional='" + categoriaProfissional + '\'' +
                '}';
    }