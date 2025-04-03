package practica1;

import java.util.Scanner;

import static practica1.Ej7.esPrimo;

public class Ej9 {
    public static void main(String[] args) {
        System.out.print("Introduce un número: ");

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        int primorial = 1;

        for (int i = 1; i <= n; i++){
            if (esPrimo(i))
                primorial *= i;
        }

        System.out.print(n + "# = " + primorial);
    }
}
