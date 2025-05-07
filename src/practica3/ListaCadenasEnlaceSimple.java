package practica3;

import java.util.List;
import java.util.Objects;

public class ListaCadenasEnlaceSimple implements ListaCadenas {

    // Clase anidada

    // Nodo con enlace simple
    private static class Nodo{
        String dato;
        Nodo sig;

        Nodo(String dato, Nodo sig){
            this.dato = dato;
            this.sig = sig;
        }
    }

    private int talla;
    private Nodo primero;

    // Constructor (por defecto)

    // Métodos
    public boolean add(String s){
        Nodo nuevo = new Nodo(s, null);

        if (primero == null)
            primero = nuevo;
        else{
            Nodo aux = primero;
            while (aux.sig != null)
                aux = aux.sig;
            aux.sig = nuevo;
        }
        talla++;
        return true;
    }

    public void add(int i, String s) throws IndexOutOfBoundsException{
        if (i < 0 || i > size()) throw new IndexOutOfBoundsException();

        Nodo aux = primero;

        if (i == talla)
            add(s);
        else if (i == 0) {
            primero = new Nodo(s, primero);
            for (int j = 1; j < talla; j++)
                aux = aux.sig;
            talla++;
        } else {
            for (int j = 0; j < i; j++)
                aux = aux.sig;
            aux = new Nodo(s, aux.sig);
            for (int j = i; j < talla; j++)
                aux = aux.sig;
            talla++;
        }

    }

    public void clear() {
        primero = null;
        talla = 0;
    }

    public String get(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();

        Nodo aux = primero;

        for (int j = 0; j < i; j++)
            aux = aux.sig;

        return aux.dato;
    }

    public int indexOf(String s) {
        Nodo aux = primero;

        for (int i = 0; i < talla; i++){
            if (Objects.equals(s, aux.dato)) return i;
            aux = aux.sig;
        }

        return -1;
    }

    public int lastIndexOf(String s) {

        Nodo aux = primero;
        int ultimaCoincidencia = -1;

        for (int i = 0; i < talla; i++){
            if (Objects.equals(s, aux.dato)) ultimaCoincidencia = i;
            aux = aux.sig;
        }
        return ultimaCoincidencia;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public String remove(int i) {
        return "";
    }

    public boolean remove(String s) {
        return false;
    }

    public String set(int i, String s) {
        return "";
    }

    public int size() {
        return talla;
    }

    public String toString(){

        if (talla == 0) return "[]";

        Nodo aux = primero;
        String resultado = "[";

        for (int i = 0; i < talla - 1; i++){
            resultado += aux.dato + ", ";
            aux = aux.sig;
        }
        return resultado + aux.dato + "]";
    }

    // Programa principal

    public static void main(String[] args) {
        ListaCadenas lista = new ListaCadenasEnlaceSimple();

        // probando add(String s)
        System.out.println("Probando método add(String s):");
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");
        System.out.println(lista);
        System.out.println();

        // probando add(int i, String s)
        System.out.println("Probando método add(int i, String s):");
        lista.add(0, "cero");
        lista.add(4, "cuatro");
        // lista.add(6, "seis");
        System.out.println(lista);

        System.out.println();

        // probando clear()
        System.out.println("Probando método clear():");
        lista.clear();
        System.out.println(lista);

        System.out.println();

        // probando get(int i)
        lista.add("cero");
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");
        lista.add("cuatro");

        System.out.println("Probando método get(int i):");
        System.out.println(lista.get(4));
        System.out.println(lista.get(0));
        System.out.println(lista.get(3));

        System.out.println();

        // probando indexOf(String s)
        System.out.println("Probando método indexOf(String s):");
        System.out.println(lista.indexOf("cero"));
        System.out.println(lista.indexOf("dos"));
        System.out.println(lista.indexOf("cinco"));

        System.out.println();

        // probando lastIndexOf(String s)
        lista.add("cero");
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");
        lista.add("cuatro");

        System.out.println("Probando método indexOf(String s):");
        System.out.println(lista);
        System.out.println(lista.lastIndexOf("cero"));
        System.out.println(lista.lastIndexOf("dos"));
        System.out.println(lista.lastIndexOf("cinco"));

        System.out.println();

        // probando isEmpty()

        System.out.println("Probando método isEmpty():");

        for (int i = 0; i < 2; i++){
            if (lista.isEmpty()) {
                System.out.println(lista);
                System.out.println("La lista está vacía.");
            } else {
                System.out.println(lista);
                System.out.println("La lista NO está vacía.");
                lista.clear();
            }
        }
    }
}
