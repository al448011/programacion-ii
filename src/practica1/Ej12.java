package practica1;

public class Ej12 {

    public static int contarPalabras(String cadena){

        boolean esPalabra = false;
        int cont_palabras = 0;

        for (int i = 0; i < cadena.length(); i++){

            if (cadena.charAt(i) != ' '){
                if (!esPalabra){
                    cont_palabras += 1;
                    esPalabra = true;
                }
            } else
                esPalabra = false;
        }

        return cont_palabras;

    }

    //
    // Sección de pruebas
    //

    public static void main(String[] args) {
        prueba("   Hola  que tal   3e ",4 );
        prueba("Adios esp e  hola",4 );
        prueba("esto es una   prueba  ",4 );
        prueba(" otra   prueba   siuu  ",3 );
        prueba("    y por  que no otra",5 );

    }

    public static void prueba(String cadena, int esperado) {
        int resultado = contarPalabras(cadena);
        System.out.format("Prueba con %s --> %s: ", cadena, resultado);
        if (resultado == esperado)
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }
}
