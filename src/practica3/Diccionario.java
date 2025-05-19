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
            if (primero.sig == null){
                primero.sig = new Nodo(unaCadena,unaCantidad,null);
                return;
            }

            Nodo actual = primero.sig;
            Nodo anterior = primero;

            while (actual.sig != null) {
                if (actual.cadena.equals(unaCadena)){
                    actual.cantidad += unaCantidad;
                    return;
                } else if (unaCadena.compareTo(actual.cadena) < 0){
                    anterior.sig = new Nodo(unaCadena, unaCantidad, actual);
                    return;
                }
                actual = actual.sig;
                anterior = actual;
            }
            actual.sig = new Nodo(unaCadena,unaCantidad,null);
        }
    }

    public String toString() {
        String resultado = "{";

        Nodo aux = primero;

        while (aux.sig != null){
            resultado += aux.cadena + "-->" + aux.cantidad + ", ";
            aux = aux.sig;
        }
        resultado += aux.cadena + "-->" + aux.cantidad + "}";

        return resultado;
    }

    public int cantidad(String unaCadena){
        if (primero == null) return 0;

        Nodo aux = primero;

        while (aux != null){
            if (unaCadena.equals(aux.cadena)) return aux.cantidad;
            aux = aux.sig;
        }

        return 0;
    }

    public String cadenaConMayorCantidad(){

        if (primero == null) return null;
        if (primero.sig == null) return primero.cadena;
        else {
            Nodo mayorCantidad = primero;
            Nodo aux = primero;

            while (aux != null){
                if (aux.cantidad > mayorCantidad.cantidad){
                    mayorCantidad = aux;
                }
                aux = aux.sig;
            }

            return mayorCantidad.cadena;
        }
    }

//    public static void main(String[] args) {
//        Diccionario dic = new Diccionario();
//
//        // probando metodo añadir(String unaCadena, int unaCantidad)
//        dic.añadir("manzana", 2);
//        dic.añadir("pera", 1);
//        dic.añadir("platano", 3);
//
//        dic.añadir("manzana", 4);
//        dic.añadir("cereza", 5);
//
//        System.out.println(dic);
//        System.out.println();
//
//        // probando metodo cadenaConMayorCantidad()
//        System.out.println("La cadena con mayor cantidad es: " + dic.cadenaConMayorCantidad());
//
//        Diccionario dicVacio = new Diccionario();
//        System.out.println("Diccionario vacío: " + dicVacio.cadenaConMayorCantidad());
//
//        Diccionario dicUnico = new Diccionario();
//        dicUnico.añadir("única", 10);
//        System.out.println("Diccionario con un elemento: " + dicUnico.cadenaConMayorCantidad());
//
//        Diccionario dicNegativos = new Diccionario();
//        dicNegativos.añadir("positivo", 5);
//        dicNegativos.añadir("negativo", -3);
//        System.out.println("Diccionario con negativos: " + dicNegativos.cadenaConMayorCantidad());
//
//        Diccionario dicEmpate = new Diccionario();
//        dicEmpate.añadir("primero", 7);
//        dicEmpate.añadir("segundo", 7);
//        dicEmpate.añadir("tercero", 3);
//        System.out.println("Diccionario con empate: " + dicEmpate.cadenaConMayorCantidad());
//
//        System.out.println();
//
//        // probando metodo cantidad(String unaCadena)
//        System.out.println(dic);
//
//        System.out.println("Cantidad de 'manzana': " + dic.cantidad("manzana"));
//        System.out.println("Cantidad de 'cereza': " + dic.cantidad("cereza"));
//        System.out.println("Cantidad de 'pera': " + dic.cantidad("pera"));
//        System.out.println("Cantidad de 'platano': " + dic.cantidad("platano"));
//
//        System.out.println("Cantidad de 'naranja': " + dic.cantidad("naranja"));
//
//        System.out.println("Diccionario vacío, cantidad de 'algo': " + dicVacio.cantidad("algo"));
//
//        System.out.println("Cantidad de cadena vacía: " + dic.cantidad(""));
//
//        dic.añadir("kiwi", 8);
//        System.out.println("Después de añadir 'kiwi', cantidad: " + dic.cantidad("kiwi"));
//
//        dic.añadir("pera", 4);
//        System.out.println("Después de añadir 4 más a 'pera', cantidad: " + dic.cantidad("pera"));
//    }
}
