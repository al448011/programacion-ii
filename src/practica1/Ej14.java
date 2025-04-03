package practica1;

import java.util.Arrays;
import java.util.Objects;

public class Ej14 {
    public static int últimaPosición(int[] vector, int n){

        int posición = vector.length;

        // recorro el vector
        for (int i = 0; i < vector.length; i++){

            // si el elemento es igual a n posición toma el valor del indice
            if (vector[i] == n)
                posición = i;

        }
            if (posición == vector.length)
                return -1;
            else
                return posición;
    }

    //
    // Sección de pruebas
    //

    public static void main(String[] args) {
        prueba(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},1,1);
        prueba(new int[]{0, 1, 2, 2, 4, 5, 3, 7, 8, 2},2,9);
        prueba(new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 4},10,-1);
        prueba(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 7, 7},7,9);
        prueba(new int[]{0, 0, 2, 3, 4, 5, 6, 0, 2, 3},0,7);
        prueba(new int[]{9, 8, 7, 6, 5, 4, 3, 5, 6, 1},10,-1);

    }

    public static void prueba(int[] vector, int n, int esperado){
        int resultado = últimaPosición(vector, n);
        System.out.format("Prueba con %s --> %s: ", Arrays.toString(vector), resultado);
        if (Objects.equals(resultado, esperado))
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }
}
