package practica1;

import java.util.Arrays;
import java.util.Objects;

public class Ej17 {
    public static boolean hayRepetidos(int[] vector){
        for (int i = 0; i < vector.length; i++){
            for (int j = i+1; j < vector.length; j++){
                if (vector[i] == vector[j])
                    return true;
            }
        }

        return false;
    }

    //
    // Sección de pruebas
    //

    public static void prueba(int[] vector, boolean esperado){
        boolean resultado = hayRepetidos(vector);
        System.out.format("Prueba con %s --> %s: ", Arrays.toString(vector), resultado);
        if (Objects.equals(resultado, esperado))
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }

    public static void main(String[] args) {
        prueba(new int[] {1, 2, 3, 4, 5}, false);
        prueba(new int[] {1, 2, 3, 2, 4}, true);
        prueba(new int[] {7, 7, 7, 7, 7}, true);
        prueba(new int[] {}, false);
        prueba(new int[] {10}, false);

    }
}
