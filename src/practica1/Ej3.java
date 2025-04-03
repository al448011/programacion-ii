package practica1;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        System.out.print("Introduce un número: ");

        Scanner entrada = new Scanner (System.in);
        int n = entrada.nextInt();

        int divisores = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                divisores += 1;
        }

        if (divisores == 2)
            System.out.println("Es primo");
        else
            System.out.println("No es primo");
    }
}
