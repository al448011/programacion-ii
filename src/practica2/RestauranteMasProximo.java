package practica2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestauranteMasProximo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el nombre del fichero de restaurantes: ");
        String nombreFichero = "G:\\Mi unidad\\EI1008 - Programación II\\programacion-ii\\src\\practica2\\ficherosAuxiliares\\" + teclado.next();
        Restaurante[] restaurantes = Restaurante.leeRestaurantes(nombreFichero);

        System.out.println("Indique su posición actual");
        System.out.print("Coordenada X: ");
        double x = teclado.nextDouble();
        System.out.print("Coordenada Y: ");
        double y = teclado.nextDouble();

        Restaurante restaurante = restauranteMásPróximo(restaurantes, new Punto(x, y));
        System.out.print("El restaurante más cercano a su posición es " + restaurante.getNombre());
        System.out.println(", situado en el punto " + restaurante.getPosición());
    }

    private static Restaurante restauranteMásPróximo(Restaurante[] v, Punto p) {
        int másPróximo = 0;
        double menorDistancia = v[0].distancia(p);
        for (int i = 1; i < v.length; i++) {
            double distancia = v[i].distancia(p);
            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                másPróximo = i;
            }
        }
        return v[másPróximo];
    }
}
