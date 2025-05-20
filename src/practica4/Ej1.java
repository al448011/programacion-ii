package practica4;

import practica2.Punto;
import practica2.Restaurante;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej1 {
    public static String[] crearVectorDni(String nombreFichero) throws FileNotFoundException {
        Scanner fichero = new Scanner(new File(nombreFichero));
        int longitudVector = fichero.nextInt(); //Leemos la primera linea que va a ser la longitud del vector

        String[] vectorDni = new String[longitudVector];

        for (int i = 0; i < longitudVector; i++)
            vectorDni[i] = fichero.next();

        return vectorDni;
    }

    public static boolean buscarDni(String dni, String[] vectorDni) {
        for (String dniEnVector : vectorDni)
            if (dniEnVector.compareTo(dni) == 0) return true;
        return false;
    }

    public static boolean buscarDniv2(String dni, String[] vectorDni) {
        int inicio = 0;
        int fin = vectorDni.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (vectorDni[medio].compareTo(dni) < 0)
                inicio = medio + 1;
            else if (vectorDni[medio].compareTo(dni) > 0)
                fin = medio - 1;
            else //Encontrado
                return true;
        }
        return false;
    }

    public static int contarCoincidencias(String[] vectorDni1, String[] vectorDni2) {
        int contador = 0;
        for (String dniEnVector : vectorDni1)
            if (buscarDniv2(dniEnVector, vectorDni2)) contador++;
        return contador;
    }

    public static int contarCoincidenciasv2(String[] vectorDni1, String[] vectorDni2) { //Usando mergesort
        int contador = 0;
        int i = 0; // Índice para vectorDni1
        int j = 0; // Índice para vectorDni2

        // Mientras no hayamos llegado al final de ninguno de los vectores
        while (i < vectorDni1.length && j < vectorDni2.length) {

            if (vectorDni1[i].compareTo(vectorDni2[j]) < 0)
                // El DNI en vectorDni1 es menor, avanzamos en vectorDni2
                i++;
            else if (vectorDni1[i].compareTo(vectorDni2[j]) > 0)
                // El DNI en vectorDni1 es mayor, avanzamos en vectorDni2
                j++;
            else {
                contador++;
                // Avanzamos en ambos vectores
                i++;
                j++;
            }
        }
        return contador;
    }
}
