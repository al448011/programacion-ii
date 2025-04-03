package practica1;

import java.util.Arrays;
import java.util.Objects;

public class Ej15 {
    public static boolean estáOrdenado(String[] vector){
        for (int i = 0; i < vector.length - 1; i++){
            if (vector[i].compareTo(vector[i+1]) > 0)
                return false;
        }

        return true;
    }

    //
    // Sección de pruebas
    //

    public static void main(String[] args) {
        prueba(new String[]{"alambre", "asiático", "balcón", "jamón"}, true);
        prueba(new String[]{"alambre", "julio", "zapato"}, true);
        prueba(new String[]{"ratón", "canto", "balcón", "adiós"}, false);
        prueba(new String[]{"alambre", "calibrar", "balcón", "jamón"}, false);
        prueba(new String[]{"alambre", "asiático", "balcón", "jamón", "oxidar"},true);
        prueba(new String[]{"alambre", "asiático", "balcón", "jamón", "camiseta"}, false);
    }

    public static void prueba(String[] vector, boolean esperado){
        boolean resultado = estáOrdenado(vector);
        System.out.format("Prueba con %s --> %s: ", Arrays.toString(vector), resultado);
        if (Objects.equals(resultado, esperado))
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }
}
