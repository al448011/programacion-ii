package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GanadorLiga {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fichero = new Scanner(new File("G:\\Mi unidad\\EI1008 - Programación II\\programacion-ii\\src\\practica3\\ficherosAuxiliares\\datos\\liga2023-2024.txt"));

        Diccionario clasificación = new Diccionario();

        while (fichero.hasNext()){
            String equipoLocal = fichero.next();
            int golesLocal = fichero.nextInt();
            String equipoVisitante = fichero.next();
            int golesVisitante = fichero.nextInt();

            if (golesLocal > golesVisitante)
                clasificación.añadir(equipoLocal,3);
            else if (golesLocal < golesVisitante)
                clasificación.añadir(equipoVisitante, 3);
            else {
                clasificación.añadir(equipoLocal, 1);
                clasificación.añadir(equipoVisitante, 1);
            }
        }

        String ganadorLiga = clasificación.cadenaConMayorCantidad();
        int puntosGanador = clasificación.cantidad(ganadorLiga);

        System.out.println("Ganador liga 2023-2024: <<" + ganadorLiga + ">> con " + puntosGanador + " puntos.");
    }
}
