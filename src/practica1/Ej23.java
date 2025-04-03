package practica1;

import java.util.Arrays;

import static practica1.Ej16.contarOlasDeFrío;

public class Ej23 {
    public static int másOlasDeFrío(double[][] matriz, int n){
        int añoInicial = 1900;
        int máxOlasFrío = 0;
        int añoMásReciente = 0;

        for (int i = 0; i < matriz.length; i++){
            int númOlasFrío = contarOlasDeFrío(matriz[i],n);

            if (númOlasFrío >= máxOlasFrío){
                máxOlasFrío = númOlasFrío;
                añoMásReciente = añoInicial + i;
            }
        }

        return (máxOlasFrío > 0) ? añoMásReciente : -1;
    }

    //
    // Sección de pruebas
    //

    public static void prueba(double[][] matriz, int n, int esperado){
        int resultado = másOlasDeFrío(matriz, n);
        System.out.format("Prueba con %s y %s --> %s: ", Arrays.deepToString(matriz), n, resultado);
        if (resultado == esperado)
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }

    public static void main(String[] args) {
        double[][] temperaturas = {
                {-1, -2, -3, 5, -1, -2, -3, -4}, // Año 1900: 1 ola de frío (días 0-2 y 4-7)
                {-1, -2, -3, -4, -5, -6, 7, 8},   // Año 1901: 1 ola de frío (días 0-5)
                {1, 2, 3, 4, 5, 6, 7, 8},         // Año 1902: 0 olas de frío
                {-1, -2, -3, -4, 5, -1, -2, -3},  // Año 1903: 2 olas de frío (días 0-3 y 5-7)
                {-1, -2, -3, -4, -5, -6, -7, -8}  // Año 1904: 1 ola de frío (días 0-7)
        };

        prueba(temperaturas, 3, 1903);
        prueba(temperaturas, 5, 1901);
        prueba(temperaturas, 0, 1903);
        prueba(temperaturas, 1, 1903);

        double[][] temperaturasVacías = {};

        prueba(temperaturasVacías, 3, -1);

        double[][] temperaturasEmpate = {
                {-1, -2, -3, 5, -1, -2, -3, -4}, // Año 1900: 1 ola de frío
                {-1, -2, -3, -4, -5, -6, 7, 8},   // Año 1901: 1 ola de frío
                {1, 2, 3, 4, 5, 6, 7, 8},         // Año 1902: 0 olas de frío
                {-1, -2, -3, -4, 5, -1, -2, -3},  // Año 1903: 2 olas de frío
                {-1, -2, -3, -4, -5, -6, -7, -8}  // Año 1904: 1 ola de frío
        };

        prueba(temperaturasEmpate, 3, 1903);

        double[][] temperaturasMismoNúmero = {
                {-1, -2, -3, 5, -1, -2, -3, -4}, // Año 1900: 2 ola de frío
                {-1, -2, -3, -4, -5, -6, 7, 8},   // Año 1901: 1 ola de frío
                {-1, -2, -3, -4, 5, -1, -2, -3},  // Año 1902: 2 ola de frío
                {-1, -2, -3, -4, -5, -6, -7, -8}  // Año 1903: 1 ola de frío
        };

        prueba(temperaturasMismoNúmero, 3, 1902);
    }
}
