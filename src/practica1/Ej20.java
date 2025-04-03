package practica1;

import java.util.Arrays;

public class Ej20 {
    public static int[] eliminarValor(int[] vector, int n){
        int contN = 0;
        for (int elemento : vector){
            if (elemento == n)
                contN += 1;
        }

        int[] nuevoVector = new int[vector.length - contN];

        int i = 0;
        for (int elemento : vector){
            if (elemento != n) {
                nuevoVector[i] = elemento;
                i += 1;
            }
        }

        return nuevoVector;
    }

    //
    // Sección de pruebas
    //

    public static void prueba(int[] vector, int n, int[] esperado){
        int[] resultado = eliminarValor(vector, n);
        System.out.format("Prueba con %s --> %s: ", Arrays.toString(vector), Arrays.toString(resultado));
        if (Arrays.equals(resultado, esperado))
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", Arrays.toString(esperado));
    }

    public static void main(String[] args) {
        prueba(new int[]{1, 2, 3, 4, 5}, 3, new int[]{1, 2, 4, 5});
        prueba(new int[]{10, 20, 10, 30, 10}, 10, new int[]{20, 30});
        prueba(new int[]{5, 10, 15, 20}, 25, new int[]{5, 10, 15, 20});
        prueba(new int[]{}, 5, new int[]{});
        prueba(new int[]{100}, 100, new int[]{});
        prueba(new int[]{7, 8, 9, 10}, 7, new int[]{8, 9, 10});
        prueba(new int[]{11, 12, 13, 14}, 14, new int[]{11, 12, 13});
        prueba(new int[]{6, 6, 6, 6}, 6, new int[]{});
    }
}
