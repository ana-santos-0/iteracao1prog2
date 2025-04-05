import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Interface que obriga à implementação de getData e getValor.
 */
public interface Medicao {
    Date getData();

    double getValor();}

/*
    public void valores() {
        System.out.print("\nData de início (dd/mm/yyyy): ");
        String[] partes = scanner.nextLine().split("/");
        Date dataInicio = new Date(Integer.parseInt(partes[2]) - 1900, Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[0]));

        System.out.print("Data de fim (dd/mm/yyyy): ");
        partes = scanner.nextLine().split("/");
        Date dataFim = new Date(Integer.parseInt(partes[2]) - 1900, Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[0]));

        System.out.print("Deseja filtrar por nomes? (sim/não): ");
        String resposta = scanner.nextLine();
        List<String> nomes = null;
        if (resposta.equalsIgnoreCase("sim")) {
            nomes = new ArrayList<>();
            System.out.println("Digite os nomes (um por linha, vazio para terminar): ");
            while (true) {
                String nome = scanner.nextLine();
                if (nome.isEmpty()) break;
                nomes.add(nome);
            }
        }

        System.out.print("Ordenar por (Ascendente-Name, Descendente-Name, Asc-Date, Desc-Date) ou enter para nenhum: ");
        String ordem = scanner.nextLine();
        if (ordem.isEmpty()) ordem = null;

        hospital.calcularDados(dataInicio, dataFim, nomes, ordem);
        break;
    }}*/