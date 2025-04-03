package practica1;

import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {

        System.out.print("Introduce un número entero: ");

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        int divisores;
        int primorial = 1;

        for (int i = 1; i <= n; i++){

            divisores = 0;

            for (int j = 1; j <= i; j++){
                if (i % j == 0)
                    divisores += 1;
            }

            if (divisores == 2)
                primorial *= i;
        }

        System.out.println(n + "# = " + primorial);
    }
}
