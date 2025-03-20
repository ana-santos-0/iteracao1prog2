import java.util.Date;

public class SinalVital {
    private String tipo;
    private double valor;
    private Date data;


    public SinalVital(String tipo, double valor, Date data){
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor(){
        return valor;
    }

    public Date getData(){
        return data;
    }

    public String toString(){
        return tipo + ": " + valor + "Data: " + data.toString();
    }
}
