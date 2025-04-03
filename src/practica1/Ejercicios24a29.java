package practica1; // Indica aquí el nombre del paquete que estás utilizando

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios24a29 {

    public static void main(String[] args) throws FileNotFoundException {
        String[] elementos10 = {"tierra", "fuego", "lava", "aire", "piedra", "agua", "arena", "desierto", "cristal", "reloj_de_arena"};
        String nombre10 = "datos/alquimia10.txt";
        int[][] matriz10 = leerMatrizResultado("datos/matriz10.bin");

        String[] elementos380 = leerElementos("datos/elementos380.txt");
        String nombre380 = "datos/alquimia380.txt";
        int[][] matriz380 = leerMatrizResultado("datos/matriz380.bin");

        System.out.println("*** PROBANDO CON LOS ARCHIVOS DE 10 ELEMENTOS ***");
        prueba(elementos10, nombre10, matriz10, new String[]{null, "desierto", "reloj_de_arena", null},
                new String[]{"arena"},
                2, "arena", 1);

        System.out.println("\n******************************\n");

        System.out.println("*** PROBANDO CON LOS ARCHIVOS DE 380 ELEMENTOS ***");
        prueba(elementos380, nombre380, matriz380, new String[]{"viento", "desierto", "reloj_de_arena", null},
                new String[]{"agua", "aire", "árbol", "arboleda", "arena", "ciudad", "continente", "cuchillo", "escarabajo", "libro", "país", "rascacielos", "rueda", "tierra", "transistor", "tumba"},
                154,"fuego", 0);
    }

    public static void prueba(String[] elementos, String nFichComb, int[][] matRes,
                              String[] elemEsperados, String[] combConsigoEsperado,
                              int nTerminalesEsperados, String másCombinableEsperado,
                              int nMúltiplesCombEsperado) throws FileNotFoundException {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println("CREANDO LA MATRIZ DE COMBINACIONES");
        int[][] m = crearMatrizCombinaciones(elementos, nFichComb);
        if (Arrays.deepEquals(m, matRes)){
            System.out.println(ANSI_GREEN + "La matriz construida es correcta");
            System.out.println(Arrays.deepToString(m));
        } else
            System.out.println(ANSI_RED + "La matriz obtenida no coincide con la esperada");
        System.out.print(ANSI_RESET);
        /* ----------------------------- */
        System.out.println("PROBANDO El MÉTODO ELEMENTO_GENERADO");
        String[][] combo = {{"aire", "aire"}, {"arena", "arena"}, {"arena", "cristal"}, {"aire", "xyz012"}};
        for (int i = 0; i < elemEsperados.length; i++) {
            String elem1 = combo[i][0];
            String elem2 = combo[i][1];
            String elementoObtenido = elementoGenerado(m, elementos, elem1, elem2);
            System.out.format("Al combinar %s y %s se produce %s", elem1, elem2, elementoObtenido);
            if (elementoObtenido == elemEsperados[i] || (elementoObtenido != null && elementoObtenido.equals(elemEsperados[i])))
                System.out.println(" --> " + ANSI_GREEN + "OK" + ANSI_RESET);
            else
                System.out.println(" --> " + ANSI_RED + "Error. Se esperaba: " + elemEsperados[i] + ANSI_RESET);
        }
        /* ----------------------------- */
        System.out.println("PROBANDO EL MÉTODO COMBINABLES_CONSIGO");
        String[] resCombConsigo = combinablesConsigo(m, elementos);
        System.out.format("Se obtiene(n) %d elemento(s) combinable(s) consigo: %s%n ", resCombConsigo.length, Arrays.toString(resCombConsigo));
        if (Arrays.equals(resCombConsigo, combConsigoEsperado))
            System.out.println("\t--> " + ANSI_GREEN + "OK" + ANSI_RESET);
        else
            System.out.println("\t--> " + ANSI_RED + "Error. Se esperaba: " + Arrays.toString(combConsigoEsperado) + ANSI_RESET);
        /* ----------------------------- */
        System.out.println("PROBANDO EL MÉTODO CONTAR_TERMINALES");
        int nTerminales = contarTerminales(m);
        System.out.format("Se obtienen %d elementos terminales", nTerminales);
        if (nTerminales == nTerminalesEsperados)
            System.out.println(" --> " + ANSI_GREEN + "OK" + ANSI_RESET);
        else
            System.out.println(" --> " + ANSI_RED + "Error. Se esperaban: " + nTerminalesEsperados + ANSI_RESET);
        /* ----------------------------- */
        System.out.println("PROBANDO EL MÉTODO ELEMENTO_MÁS_COMBINABLE");
        String másCombinable = elementoMásCombinable(m, elementos);
        System.out.format("Se obtiene %s como elemento más combinable", másCombinable);
        if (másCombinable.equals(másCombinableEsperado))
            System.out.println(" --> " + ANSI_GREEN + "OK" + ANSI_RESET);
        else
            System.out.println(" --> " + ANSI_RED + "Error. Se esperaba: " + másCombinableEsperado + ANSI_RESET);
        /* ----------------------------- */
        System.out.println("PROBANDO EL MÉTODO MÚLTIPLES_COMBINACIONES");
        int nMúltiplesComb = múltiplesCombinaciones(m);
        System.out.format("%d elemento(s) se puede(n) obtener con múltiples combinaciones", nMúltiplesComb);
        if (nMúltiplesComb == nMúltiplesCombEsperado)
            System.out.println(" --> " + ANSI_GREEN + "OK" + ANSI_RESET);
        else
            System.out.println(" --> " + ANSI_RED + "Error. Se esperaban: " + nMúltiplesCombEsperado + ANSI_RESET);

    }

    public static String[] leerElementos(String nFich) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File(nFich));
        int nElem = entrada.nextInt();
        String[] vector = new String[nElem]; // Al comienzo del fichero se indica la cantidad de elementos
        for (int i = 0; i < nElem; i++)
            vector[i] = entrada.next();
        entrada.close();
        return vector;
    }

    public static int[][] leerMatrizResultado(String nFich) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nFich));
            int[][] m = (int[][]) in.readObject();
            in.close();
            return m;
        } catch (Exception e) {
            System.out.println("Algo ha ido mal al leer el fichero --> " + e.getMessage());
            System.exit(-1);
        }
        return null;
    }

    public static int[][] crearMatrizCombinaciones(String[] elementos, String nFich) throws FileNotFoundException {
        // Escribe aquí tu código para el ejercicio 24

        int n = elementos.length;
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                matriz[i][j] = -1;
        }

        Scanner fichero = new Scanner(new File(nFich));
        while (fichero.hasNext()){
            String elemento1 = fichero.next();
            String elemento2 = fichero.next();
            String combinación = fichero.next();

            int i = -1;
            int j = -1;
            int k = -1;

            for (int x = 0; x < n; x++){
                if (elementos[x].equals(elemento1))
                    i = x;
                if (elementos[x].equals(elemento2))
                    j = x;
                if (elementos[x].equals(combinación))
                    k = x;
            }

            if (i != -1 && j != -1 && k != -1){
                matriz[i][j] = k;
                matriz[j][i] = k;
            }
        }
        fichero.close();

        return matriz;
    }

    public static String elementoGenerado(int[][] m, String[] elementos, String e1, String e2) {
        // Escribe aquí tu código para el ejercicio 25

        int i = -1;
        int j = -1;

        for (int x = 0; x < elementos.length; x++){
            if (elementos[x].equals(e1)) i = x;
            if (elementos[x].equals(e2)) j = x;
        }

        if (i != -1 && j != -1){
            int k = m[i][j];
            if (k != -1)
                return elementos[k];
        }

        return null;
    }

    public static String[] combinablesConsigo(int[][] m, String[] elementos) {
        // Escribe aquí tu código para el ejercicio 26

        int contador = 0;

        for (int i = 0; i < elementos.length; i++){
            if (m[i][i] != -1)
                contador += 1;
        }

        String[] combinables = new String[contador];
        int i = 0;

        for (int j = 0; j < elementos.length; j++){
            if (m[i][i] != -1){
                combinables[i] = elementos[j];
                i += 1;
            }
        }

        return combinables;
    }

    public static int contarTerminales(int[][] m) {
        // Escribe aquí tu código para el ejercicio 27
        return -1; // Devuelve el resultado adecuado
    }

    public static String elementoMásCombinable(int[][] m, String[] elementos) {
        // Escribe aquí tu código para el ejercicio 28
        return "--"; // Devuelve el resultado adecuado
    }

    public static int múltiplesCombinaciones(int[][] m) {
        // Escribe aquí tu código para el ejercicio 29
        return -1; // Devuelve el resultado adecuado
    }
}
