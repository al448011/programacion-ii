package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalabraMasFrecuente {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fichero = new Scanner(new File("G:\\Mi unidad\\EI1008 - Programación II\\programacion-ii\\src\\practica3\\ficherosAuxiliares\\datos\\DonQuijote.txt"));

        Diccionario palabrasDonQuijote = new Diccionario();

        while (fichero.hasNext()){
            String palabra = fichero.next();
            // System.out.println(palabra);
            palabrasDonQuijote.añadir(palabra,1);
        }

        String cadenaMasRepetida = palabrasDonQuijote.cadenaConMayorCantidad();
        int cantidadCadenaMasRepetida = palabrasDonQuijote.cantidad(cadenaMasRepetida);
        System.out.println("La palabra más frecuente en DonQuijote.txt es <<" + cadenaMasRepetida + ">> con " + cantidadCadenaMasRepetida + " aparicioines.");
    }
}
