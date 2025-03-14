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

    public List<SinalVital> getSinaisVitais(){
        return sinaisVitais;
    }

    public class Main {
        public static void main(String[] args) {
Paciente paciente1 = new Paciente ("Ana Tavares", 1992-03-06, 1.70, 58);
paciente1.adicionarSinalVital(new SinalVital("FC", 85, 2025-03-14));
paciente1.adicionarSinalVital(new SinalVital("Temp", 37.2, 2025-03-18));
paciente1.adicionarSinalVital(new SinalVital("Sat", 98, 2025-03-05));
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

        public static void verificarErros(double FC, double Sat, double Temp) {
            if (FC < 60 || Sat < 89 || Temp < 35.9) { //Ana, por favor verifica estes dados
                System.out.println("Erro ao verificar dados");
            }
            if (FC > 121 || Sat > 101 || Temp > 39) {
                System.out.println("Erro ao verificar dados");
            }
        }

        public static void verificarValoresFC (double FC) {
            if (FC <= 100 && FC >= 60) {
                System.out.println("Frequência Cardíaca Normal");
            } else if (FC >= 120) {
                System.out.println("Atenção");
            } else if (FC < 60 || FC > 120){
                System.out.println("Crítico");
            }
        }

        public static void verificarValoresTemp (double Temp) {
            if (Temp >= 36 && Temp <= 37.5) {
                System.out.println("Frequência Cardíaca Normal");
            } else if (Temp <= 38.5) {
                System.out.println("Atenção");
            } else if (Temp < 36 || Temp > 38.5){
                System.out.println("Crítico");
            }
        }

        public static void verificarValoresSat (double Sat) {
            if (Sat >=95) {
                System.out.println("Frequência Cardíaca Normal");
            } else if (Sat >= 90) {
                System.out.println("Atenção");
            } else if (Sat < 90){
                System.out.println("Crítico");
            }
        }
        /*
        public static void Imprimir (double FC, double Sat, double Temp, Pessoa paciente1) {
            System.out.println("Paciente: " + paciente1.getNome());
            for (SinalVital : paciente1.getSinaisVitais()){
                System.out.println()
            }
        }

        public static float CalcularMedia(double FC, double Sat, double Temp) {
            return;
        }
        */
    }
}