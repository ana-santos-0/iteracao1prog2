import java.util.Date;

public class TecnicoSaude extends Pessoa {
    private String categoriaProfissional;

    public TecnicoSaude (String nome, Date datanascimento, String categoriaProfissional){
        super(nome, datanascimento);
        this.categoriaProfissional = categoriaProfissional;
    }

    public String getCategoriaProfissional(){
        return categoriaProfissional;
    }

    public String toString(){
        return categoriaProfissional;
    }
}
