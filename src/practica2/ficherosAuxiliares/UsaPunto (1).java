package practica2;

import java.util.Arrays;

public class UsaPunto {
    public static void main(String[] args) {
        // Usamos el constructor sin parámetros
        Punto p = new Punto();
        // Usamos el constructor con 2 parámetros
        Punto q = new Punto(400, 300);

        // Usamos los getters
        System.out.println("La coordenada x de q es " + q.getX());  // Debe ser 400.0
        System.out.println("La coordenada y de q es " + q.getY());  // Debe ser 300.0

        // Usamos desplazar
        Punto r = p.desplazar(150, 200).desplazar(250, 100);

        // Usamos toString y distancia (p no debe haber cambiado)
        System.out.println("La distancia entre " + p + " y " + r + " es " + p.distancia(r));  // Debe ser 500.0

        System.out.println("¿q == r? " + (q == r));  // Debe ser false

        // Usamos equals
        System.out.println("¿q.equals(r)? " + q.equals(r));  // Debe ser true

        // Más pruebas con equals
        Punto[] v1 = {q};
        Punto[] v2 = {r};
        System.out.println("v1 es " + Arrays.toString(v1));
        System.out.println("v2 es " + Arrays.toString(v2));
        System.out.println("¿Arrays.equals(v1, v2)? " + Arrays.equals(v1, v2));  // Debe ser true
    }
}
