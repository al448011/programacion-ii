package practica1;

import java.util.Scanner;

import static practica1.Ej7.esPrimo;

public class Ej8 {
    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        System.out.print("Los números primos menores que " + n + " son: ");

        for (int i = 1; i < n; i++){
            if (esPrimo(i))
                System.out.print(i + " ");
        }
    }
}
