public class Paciente {
    private String nome;
    private String dataNascimento;
    private double altura;
    private double peso;

    public Paciente(String nome, String dataNascimento, double altura, double peso) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
    }

    //get
    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura;
    }
    public double getPeso(){
        return peso
    }

    
    //Set
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

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






    
