package practica3;

import java.util.Objects;

public class Diccionario {
    // Clase privada nodo
    private static class Nodo{
        String cadena;
        int cantidad;
        Nodo sig;

        Nodo(String cadena, int cantidad, Nodo sig){
            this.cadena = cadena;
            this.cantidad = cantidad;
            this.sig = sig;
        }
    }

    // Atributos

    private Nodo primero;

    // Constructor (por defecto)

    // Métodos
    public void añadir(String unaCadena, int unaCantidad){
        if (primero == null)
            primero = new Nodo(unaCadena, unaCantidad, null);

        else if (primero.cadena.equals(unaCadena))
            primero.cantidad += unaCantidad;

        else if (unaCadena.compareTo(primero.cadena) < 0)
            primero = new Nodo(unaCadena, unaCantidad, primero);

        else {
            Nodo aux = primero;

        }



    }

    public String toString() {
        String resultado = "{";

        Nodo aux = primero;

        while (aux.sig != null){
            resultado += aux.cadena + "-->" + aux.cantidad + ", ";
        }
        resultado += aux.cadena + "-->" + aux.cantidad + "}";

        return resultado;
    }

    public static void main(String[] args) {
        Diccionario dic = new Diccionario();

        // probando metodo añadir(String unaCadena, int unaCantidad)
        dic.añadir("manzana", 2);
        dic.añadir("pera", 1);
        dic.añadir("platano", 3);

        dic.añadir("manzana", 4);
        dic.añadir("cereza", 5);

        System.out.println(dic);
    }
}
