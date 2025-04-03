package practica1;

import java.util.Objects;

public class Ej13 {
    public static String obtenerPalabra(String cadena, int posicion_palabra) {

        boolean esPalabra = false;
        int cont_palabra = 0;
        int ini_palabra = 0;
        int fin_palabra = 0;

        for (int i = 0; i < cadena.length(); i++){

            if (cadena.charAt(i) != ' '){
                if (!esPalabra){
                    cont_palabra += 1;
                    esPalabra = true;

                    if (cont_palabra == posicion_palabra)
                        ini_palabra = i;

                } else if (cont_palabra == posicion_palabra && cadena.length() == i+1) {
                    fin_palabra = i+1;
                }


            } else {
                esPalabra = false;

                if (cont_palabra == posicion_palabra && cadena.charAt(i - 1) != ' ')
                    fin_palabra = i;
            }
        }

        if (cont_palabra < posicion_palabra)
            return null;
        else
            return cadena.substring(ini_palabra, fin_palabra);
    }

    //
    // Sección de pruebas
    //

    public static void main(String[] args) {
        prueba("   Hola que tal   estamos", 1, "Hola");
        prueba("   Hola que tal   estamos", 2, "que");
        prueba("   Hola que tal   estamos", 3, "tal");
        prueba("   Hola que tal   estamos", 4, "estamos");
        prueba("   Hola que tal   estamos     ", 4, "estamos");
        prueba("   Hola que tal   estamos", 5, null);
    }

    public static void prueba(String cadena, int i, String esperado) {
        String resultado = obtenerPalabra(cadena,i);
        System.out.format("Prueba con %s --> %s: ", cadena, resultado);
        if (Objects.equals(resultado, esperado))
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }
}