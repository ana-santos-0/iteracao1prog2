import java.util.Scanner;
import java.util.*;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            GestorUCI gestor = new GestorUCI();
            List<Paciente> pacientes = new ArrayList<>();


        Paciente paciente1 = new Paciente ("Ana Tavares", 1992-03-06, 1.70, 58);
        paciente1.adicionarSinalVital(new SinalVital("Frequência Cardíaca", 85, 2025-03-14));
        paciente1.adicionarSinalVital(new SinalVital("Temperatura", 37.2, 2025-03-18));
        paciente1.adicionarSinalVital(new SinalVital("Saturação", 98, 2025-03-05));

        pacientes.add(paciente1);

        System.out.println("Paciente: " + paciente1);
        System.out.println("Classificação: " + gestor.classificarPaciente(paciente1));
        }
/*
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