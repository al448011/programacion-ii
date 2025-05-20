package practica3;

import java.util.NoSuchElementException;

public class ColaTrabajosEnlaceSimple implements ColaTrabajos {

    private static class Nodo {
        // Atributos
        TrabajoImpresora trabajo;
        Nodo sig;

        Nodo(TrabajoImpresora trabajo, Nodo sig){
            this.trabajo = trabajo;
            this.sig = sig;
        }
    }

    private int talla;
    private Nodo primero;
    private Nodo último;

    // Constructor
    ColaTrabajosEnlaceSimple(){
        this.talla = 0;
        this.primero = null;
        this.último = null;
    }

    // Métodos
    public void insertar(TrabajoImpresora t) {
        Nodo nuevo = new Nodo(t, null);

        if (primero == null){
            primero = nuevo;
            último = nuevo;
        } else{
            último.sig = nuevo;
            último = nuevo;
        }
        talla++;
    }

    public TrabajoImpresora extraerPrimero() throws NoSuchElementException {
        if (talla == 0) throw new NoSuchElementException();

        Nodo aux = primero;

        if (talla == 1){
            primero = null;
            último = null;
        } else {
            primero = primero.sig;
        }

        talla--;
        return aux.trabajo;
    }

    public TrabajoImpresora consultarPrimero() throws NoSuchElementException{
        if (primero == null) throw new NoSuchElementException();

        return primero.trabajo;
    }

    public int getTalla() {
        return talla;
    }

    public boolean esVacía() {
        return talla == 0;
    }

    public String toString(){
        String resultado = "[";

        Nodo aux = primero;

        while (aux.sig != null){
            resultado += aux.trabajo + " -> ";
            aux = aux.sig;
        }
        resultado += último.trabajo + "]";
        return resultado;
    }

    public static void main(String[] args) {
        // Crear una nueva cola de trabajos
        ColaTrabajosEnlaceSimple cola = new ColaTrabajosEnlaceSimple();

        System.out.println("Cola creada. ¿Está vacía? " + cola.esVacía());
        System.out.println("Tamaño inicial: " + cola.getTalla());

        try {
            // Intentar extraer de una cola vacía
            System.out.println("Intentando extraer de cola vacía...");
            cola.extraerPrimero();
        } catch (NoSuchElementException e) {
            System.out.println("Error esperado: Cola vacía");
        }

        // Insertar trabajos
        System.out.println("\nInsertando trabajos...");
        cola.insertar(new TrabajoImpresora(0, "Usuario01"));
        cola.insertar(new TrabajoImpresora(1, "Usuario02"));
        cola.insertar(new TrabajoImpresora(2, "Usuario03"));

        System.out.println("Cola después de insertar: " + cola);
        System.out.println("Tamaño actual: " + cola.getTalla());
        System.out.println("¿Está vacía? " + cola.esVacía());

        // Consultar el primer trabajo
        System.out.println("\nPrimer trabajo: " + cola.consultarPrimero());

        // Extraer trabajos
        System.out.println("\nExtrayendo trabajos...");
        System.out.println("Extraído: " + cola.extraerPrimero());
        System.out.println("Cola después de extraer: " + cola);
        System.out.println("Tamaño actual: " + cola.getTalla());

        System.out.println("Extraído: " + cola.extraerPrimero());
        System.out.println("Cola después de extraer: " + cola);

        System.out.println("Extraído: " + cola.extraerPrimero());
        System.out.println("¿Está vacía ahora? " + cola.esVacía());

        try {
            // Intentar consultar en una cola vacía
            System.out.println("\nIntentando consultar en cola vacía...");
            cola.consultarPrimero();
        } catch (NoSuchElementException e) {
            System.out.println("Error esperado: Cola vacía");
        }
    }
}
