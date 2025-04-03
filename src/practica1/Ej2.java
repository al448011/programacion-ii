package practica1;

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        int inicio;

        if (n % 2 == 0)
            inicio = 2;
        else
            inicio = 1;

        int factorial = 1;

        for (int i = inicio; i <= n; i+=2)
            factorial = i * factorial;

        System.out.print(n + "!! = " + factorial);
    }
}
