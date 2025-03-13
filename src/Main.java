import java.util.Scanner;
import java.util.*;

abstract class Pessoa{
    protected String nome;
    protected Date dataNascimento;

    public Pessoa (String nome, Date dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return nome;
    }

    public Date getDataNascimento(){
        return dataNascimento;
    }
}

class Paciente extends Pessoa {
    private double altura;
    private double peso;
    public List<SinalVital> sinaisVitais;

    public Paciente(String nome, Date dataNascimento, double altura, double peso) {
        super(nome, dataNascimento);
        this.altura = altura;
        this.peso = peso;
        this.sinaisVitais = new ArrayList<>();
    }

    public void adicionarSinalVital(SinalVital sinal) {
        sinaisVitais.add(sinal);
    }

    public class Main {
        public static void main(String[] args) {

        }

        public static void calcularValores() {
            System.out.println("Bem vindo ao programa!");
            System.out.println("Insira o valor de FC");
            Scanner sc = new Scanner(System.in);
            double FC = sc.nextDouble();
            System.out.println("Insira o valor de Saturação");
            double Sat = sc.nextDouble();
            System.out.println("Insira o valor de temperatura");
            double Temp = sc.nextDouble();
        }

        public static void verificarDados(double FC, double Sat, double Temp) {
            if (FC < 60 || Sat < 80 || Temp < 34) { //Ana, por favor verifica estes dados
                System.out.println("Erro ao verificar dados");
            }
            if (FC > 100 || Sat > 100 || Temp > 45) {
                System.out.println("Erro ao verificar dados");
            }
        }

        /*public static float CalcularMedia(double FC, double Sat, double Temp) {
            return;
        }
        */
         */
    }
}