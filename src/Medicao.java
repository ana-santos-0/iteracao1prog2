import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Interface que obriga à implementação de getData e getValor.
 */
public interface Medicao {
    Date getData();
    double getValor();
    String getTipo();
}

