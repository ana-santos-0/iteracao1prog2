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
}

//representar um sinal vital

class SinalVital {
    private String tipo;
    private double valor;
    private Date data;

public SinalVital(String tipo, double valor, Date data){
    this.tipo = tipo;
    this.valor = valor;
    this.data = data;
}
public String getTipo(){
    return tipo;
}

public double getValor(){
    return valor;
}
}