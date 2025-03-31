import java.util.Date;

public class TecnicoSaude extends Pessoa {
    private String categoriaProfissional;
//herda da superclasse o nome e DN
    public TecnicoSaude (String nome, Date dataNascimento, String categoriaProfissional){
        super(nome, dataNascimento);
        this.categoriaProfissional = categoriaProfissional;
    }
//obtenção do cargo para maior proteção dos dados
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