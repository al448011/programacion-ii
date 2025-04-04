package practica2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestauranteMejorValorado {
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

        System.out.print("Distancia máxima que quiere caminar: ");
        int distancia = teclado.nextInt();


        Restaurante restaurante = restauranteMejorValorado(restaurantes, new Punto(x, y), distancia);

        if (restaurante != null){
            System.out.print("El restaurante más cercano a su posición es " + restaurante.getNombre());
            System.out.println(", situado en el punto " + restaurante.getPosición());
        } else {
            System.out.println("No hay restaurantes dentro de la distancia máxima especificada");
        }
    }

    private static Restaurante restauranteMejorValorado(Restaurante[] v, Punto p, double d) {
        int másPróximo = 0;
        double distancia = 0;
        double menorDistancia = v[0].distancia(p);
        int mejorValoración = v[0].getValoración();

        for (int i = 1; i < v.length; i++) {
            distancia = v[i].distancia(p);
            int valoración = v[i].getValoración();
            if (distancia < menorDistancia && valoración >= mejorValoración) {
                menorDistancia = distancia;
                másPróximo = i;
            }
        }

        return distancia <= d ? v[másPróximo] : null;
    }
}
