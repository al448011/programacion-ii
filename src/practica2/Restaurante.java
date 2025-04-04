package practica2;

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

    public static Restaurante[] leeRestaurantes(String nombreFichero){

        Scanner fichero = new Scanner(new File(nombreFichero));
        longitudVector = fichero.nextInt();

        Restaurante[] vectorRestaurantes = new vectorRestaurantes[longitudVector];
    }
}
