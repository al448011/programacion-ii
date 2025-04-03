package practica1;

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        System.out.print("Los números primos menores que " + n + ": ");

        int divisores;

        for (int i = 1; i < n; i++){

            divisores = 0;

            for (int j = 1; j <= i; j++){
                if (i % j == 0)
                    divisores += 1;
            }

            if (divisores == 2)
                System.out.print(i + " ");
        }
    }
}
