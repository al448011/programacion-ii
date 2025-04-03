package practica1;

import java.util.Arrays;

public class Ej22 {
    public static int posiciónInserción(int[] vector, int n){
        for (int i = 0; i < vector.length; i++){
            if (n == vector[i])
                return i;
            else if (n < vector[i])
                return i;
        }
        return vector.length;
    }

//
//    Sección de pruebas
//

    public static void prueba(int[] vector, int n, int esperado){
        int resultado = posiciónInserción(vector, n);
        System.out.format("Prueba con %s y %s --> %s: ", Arrays.toString(vector), n, resultado);
        if (resultado == esperado)
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }

    public static void main(String[] args) {
        prueba(new int[]{}, 5, 0);
        prueba(new int[]{10, 20, 30, 40}, 5, 0);
        prueba(new int[]{10, 20, 30, 40}, 50, 4);
        prueba(new int[]{10, 20, 30, 40}, 25, 2);
        prueba(new int[]{10, 20, 20, 30, 40}, 20, 1);
        prueba(new int[]{10, 20, 30, 40}, 10, 0);
        prueba(new int[]{10, 20, 30, 40}, 40, 3);
        prueba(new int[]{10}, 20, 1);
        prueba(new int[]{30}, 20, 0);
        prueba(new int[]{10, 10, 20, 20, 30}, 20, 2);
    }
}
