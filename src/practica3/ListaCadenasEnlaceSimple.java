package practica3;

import java.util.Objects;

public class ListaCadenasEnlaceSimple implements ListaCadenas {

    // Clase anidada
    // Nodo con enlace simple
    private static class Nodo {
        String dato;
        Nodo sig;

        Nodo(String dato, Nodo sig) {
            this.dato = dato;
            this.sig = sig;
        }
    }

    private int talla;
    private Nodo primero;

    // Constructor (por defecto)

    // Métodos
    public boolean add(String s) {
        Nodo nuevo = new Nodo(s, null);
        if (primero == null)
            primero = nuevo;
        else{
            Nodo aux = primero;
            for (int i = 0; i < talla - 1; i++)
                aux = aux.sig;
            aux.sig = nuevo;
        }
        talla++;
        return true;
    }

    public void add(int i, String s) throws IndexOutOfBoundsException {
        if (i < 0 || i > size()) throw new IndexOutOfBoundsException();

        if (i == talla)
            add(s);
        else {
            Nodo aux = primero;
            for (int j = 0; j < i - 1; j++)
                aux = aux.sig;

            Nodo nuevo = new Nodo(s,aux);

            talla++;
        }
    }

    public void clear() {
        primero = null;
        talla = 0;
    }

    public String get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();

        Nodo aux = primero;
        for (int j = 0; j != i; j++)
            aux = aux.sig;

        return aux.dato;
    }

    public int indexOf(String s) {
        Nodo aux = primero;
        for (int i = 0; i < talla - 1; i++){
            if (Objects.equals(s, aux.dato))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(String s) {
        Nodo aux = primero;
        int últimaOcurrencia = -1;

        for (int i = 0; i < talla - 1; i++){
            if (Objects.equals(s, aux.dato))
                últimaOcurrencia = i;
        }

        return últimaOcurrencia;
    }

    public boolean isEmpty() {
        talla = 0;
        return primero != null;
    }

    public String remove(int i) throws IndexOutOfBoundsException{

        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();

        Nodo auxAnterior = primero;
        Nodo auxActual = auxAnterior.sig;

        for (int j = 0; j != i; j++){
            auxAnterior = auxActual;
            auxActual = auxActual.sig;
        }

        auxActual.sig = auxAnterior;
        return auxActual.dato;
    }

    public boolean remove(String s) {

        Nodo auxAnterior = primero;
        Nodo auxActual = primero.sig;

        for (int i = 1; i < talla - 1; i++){
            if (Objects.equals(auxAnterior.dato,s)){
                for (int j = i; i < talla - 1; j++){
                    auxAnterior = auxActual.sig;
                }
                return true;
            } else {
                auxAnterior = auxActual;
                auxActual = auxActual.sig;
            }
        }
        return false;
    }

    public String set(int i, String s) throws IndexOutOfBoundsException {

        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();

        Nodo auxPrimera = primero;
        Nodo auxSegunda = primero.sig;

        for (int j = 0; j < i; j++){
            auxPrimera = auxSegunda;
            auxSegunda = auxSegunda.sig;
        }

        auxSegunda.dato = s;
        return auxPrimera.dato;
    }

    public int size() {

        Nodo aux = primero;
        int size = 0;

        while (aux.sig != null)
            size++;

        return size;
    }

    public String toString(){

        Nodo aux = primero;
        String string = "[";

        for (int i = 0; i < talla - 2; i++){
            string += aux.dato + ", ";
            aux = primero.sig;
        }
        return string + aux.dato + "]";
    }
}
