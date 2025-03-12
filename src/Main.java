import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

 public static void calcularValores (){
     System.out.println("Bem vindo ao programa!");
     System.out.println("Insira o valor de FC");
     Scanner sc = new Scanner(System.in);
     double FC = sc.nextDouble();
     System.out.println("Insira o valor de Saturação");
     double Sat = sc.nextDouble();
     System.out.println("Insira o valor de temperatura");
     double Temp = sc.nextDouble();
 }
 public static void verificarDados(double FC, double Sat, double Temp){
        if (FC<60 || Sat<80 || Temp<34){ //Ana, por favor verifica estes dados
            System.out.println("Erro ao verificar dados");
        }
        if (FC>100 || Sat>100 || Temp>45){
            System.out.println("Erro ao verificar dados");
        }
 }
 public static float CalcularMedia (double FC, double Sat, double Temp){

 }
}