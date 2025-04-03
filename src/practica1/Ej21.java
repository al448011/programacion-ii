package practica1;

import java.util.Arrays;

public class Ej21 {
    public static boolean contiene(int[] vector, int n){
        for (int elemento : vector){
            if (elemento == n)
                return true;
        }

        return false;
    }

    public static boolean contiene(int[] vector1, int[] vector2){

        for (int elemento : vector2){
            if (!contiene(vector1, elemento))
                return false;
        }

        return true;
    }

    //
    //    Sección de pruebas
    //

    public static void prueba(int[] vector1, int[] vector2, boolean esperado){
        boolean resultado = contiene(vector1, vector2);
        System.out.format("Prueba con %s y %s --> %s: ", Arrays.toString(vector1), Arrays.toString(vector2), resultado);
        if (resultado == esperado)
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }

    public static void main(String[] args) {
        prueba(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4}, true);
        prueba(new int[]{1, 2, 3, 4, 5}, new int[]{2, 6}, false);
        prueba(new int[]{1, 2, 3, 4, 5}, new int[]{}, true);
        prueba(new int[]{}, new int[]{1, 2}, false);
        prueba(new int[]{}, new int[]{}, true);
        prueba(new int[]{10, 20, 30}, new int[]{40}, false);
        prueba(new int[]{10, 20, 30}, new int[]{20}, true);
    }
}
