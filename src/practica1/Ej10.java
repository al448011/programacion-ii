package practica1;

import java.util.Scanner;

public class Ej10 {
    public static int contarDivisores(int n){

        int divisores = 0;

        for (int i = 1; i <= n; i++){
            if (n % i == 0)
                divisores += 1;
        }

        return divisores;
    }

    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        int divisores;
        int max_divisores = 0;
        int max_num = 0;

        for (int i = 1; i <= n; i++){
            divisores = contarDivisores(i);

            if (max_divisores <= divisores){
                max_num = i;
                max_divisores = divisores;
            }
        }

        System.out.print("El número con más divisores es " + max_num + " (" + max_divisores + ")");
    }
}
