package practica1;

import java.util.Arrays;

public class Ej19 {
    public static int[] eliminarPosición(int[] vector, int posición){
        if (posición >= vector.length || posición < 0){
            return vector;
        } else {
            int[] nuevoVector = new int[vector.length - 1];

            for (int i = 0; i < vector.length - 1; i++){
                if (i != posición && i <= posición)
                    nuevoVector[i] = vector[i];
                else
                    nuevoVector[i] = vector[i+1];

            }

            return nuevoVector;
        }
    }

    //
    // Sección de pruebas
    //

    public static void prueba(int[] vector, int posición, int[] esperado){
        int[] resultado = eliminarPosición(vector, posición);
        System.out.format("Prueba con %s --> %s: ", Arrays.toString(vector), Arrays.toString(resultado));
        if (Arrays.equals(resultado, esperado))
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", Arrays.toString(esperado));
    }

    public static void main(String[] args) {
        prueba(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 4, 5});
        prueba(new int[]{10, 20, 30, 40}, 0, new int[]{20, 30, 40});
        prueba(new int[]{5, 10, 15, 20}, 3, new int[]{5, 10, 15});
        prueba(new int[]{1, 2, 3, 4}, -1, new int[]{1, 2, 3, 4});
        prueba(new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4});
        prueba(new int[]{}, 0, new int[]{});
        prueba(new int[]{100}, 0, new int[]{});
    }
}
