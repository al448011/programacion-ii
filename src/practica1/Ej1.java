package practica1;

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
//      Si se hace println te hace el salto de línea
//      Se se hace print no te hace el salto de línea
        System.out.print("Introduce un número entero: ");

        Scanner entrada = new Scanner(System.in);
        int numero = entrada.nextInt();

        int factorial = 1;

        for (int i = 1 ; i <= numero; i++)
            factorial = i * factorial;

        System.out.println(numero + "! = " + factorial);
    }
}
