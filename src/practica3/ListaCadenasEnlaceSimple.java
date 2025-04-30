package practica3;

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
            for (int j = 0; j < i - 1; j++){
                aux = aux.sig;
            }
        }
    }

    public void clear() {

    }

    public String get(int i) {
        return "";
    }

    public int indexOf(String s) {
        return 0;
    }

    public int lastIndexOf(String s) {
        return 0;
    }

    public boolean isEmpty() {
        return false;
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
        return 0;
    }
}
