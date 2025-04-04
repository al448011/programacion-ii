package practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Restaurante {
    // Atributos

    private String nombre;
    private Punto posición;
    private int valoración;

    // Constructores

    public Restaurante(String nombre, Punto posición, int valoración){
        nombre = this.nombre;
        posición = this.posición;
        valoración = this.valoración;
    }

    // Métodos

    public String getNombre(){ return this.nombre; }
    public Punto getPosición() { return this.posición; }
    public int getValoración() { return this.valoración; }

    public double distancia(Punto p){
        return this.posición.distancia(p);
    }

    public static Restaurante[] leeRestaurantes(String nombreFichero) throws FileNotFoundException {

        Scanner fichero = new Scanner(new File(nombreFichero));
        int longitudVector = fichero.nextInt();

        Restaurante[] vectorRestaurantes = new Restaurante[longitudVector];

        for (int i = 0; i < longitudVector; i++){
            Punto posición = new Punto(fichero.nextInt(),fichero.nextInt());
            int valoración = fichero.nextInt();
            String nombre = fichero.next();

            vectorRestaurantes[i] = new Restaurante(nombre, posición, valoración);
        }

        System.out.println(Arrays.toString(vectorRestaurantes));;

        return vectorRestaurantes;
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        String rutaFichero = "G:\\Mi unidad\\EI1008 - Programación II\\programacion-ii\\src\\practica2\\ficherosAuxiliares\\restaurantes.txt";
//        Restaurante[] restaurantes = Restaurante.leeRestaurantes(rutaFichero);
//    }

}
