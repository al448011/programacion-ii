package practica1;

import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        int max_divisores = 0;
        int max_num = 0;

        for (int i = 1; i <= n; i++) {
            int divisores = 0;

            for (int j = 1; j <= i; j ++){
                if (i % j == 0)
                    divisores += 1;

            }

            if (max_divisores <= divisores){
                max_divisores = divisores;
                max_num = i;
            }
        }

        System.out.print("El número con más divisores es " + max_num + " (" + max_divisores + ")");
    }
}
