package practica1;

import java.util.Scanner;

public class Ej7 {
    public static boolean esPrimo(int n){

        boolean esPrimo = false;

        int divisores = 0;

        for (int i = 1; i <= n; i++){
            if (n % i == 0)
                divisores += 1;

        }

        if (divisores == 2)
            esPrimo = true;

        return esPrimo;
    }

    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        if (esPrimo(n))
            System.out.println("Es primo");
        else
            System.out.println("No es primo");
    }
}
