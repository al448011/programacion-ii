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
        if (primero != null){
            Nodo aux = primero;

            while (aux.sig != null){
                resultado += aux.trabajo + " -> ";
                aux = aux.sig;
            }
            resultado += último.trabajo;
        }
        resultado += "]";
        return resultado;
    }

    public void cancelar(String idUsuario){
        if (primero == null) return;

        while(primero != null && primero.trabajo.getIdUsuario().equals(idUsuario)){
            primero = primero.sig;
            talla--;

            if (primero == null){
                último = null;
                return;
            }
        }

        Nodo aux = primero;

        while (aux != null && aux.sig != null){
            if (aux.sig.trabajo.getIdUsuario().equals(idUsuario)){
                if (aux.sig == último)
                    último = aux;

                aux.sig = aux.sig.sig;
                talla--;
            } else {
                aux = aux.sig;
            }
        }
    }

    public void adelantar(int idTrabajo){
        if (primero == null || primero == último) return;

        if (primero.trabajo.getIdTrabajo() == idTrabajo) return;

        Nodo anterior = primero;
        Nodo actual = primero.sig;

        while (actual != null && actual.trabajo.getIdTrabajo() != idTrabajo) {
            anterior = actual;
            actual = actual.sig;
        }

        if (actual == null) return;

        anterior.sig = actual.sig;

        if (actual == último) {
            último = anterior;
        }

        actual.sig = primero;
        primero = actual;
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

        // NUEVAS PRUEBAS PARA LOS MÉTODOS CANCELAR Y ADELANTAR

        // Prueba del metodo cancelar
        System.out.println("\n=== PRUEBA DEL MÉTODO CANCELAR ===");
        // Insertar varios trabajos de diferentes usuarios
        cola.insertar(new TrabajoImpresora(3, "Usuario01"));
        cola.insertar(new TrabajoImpresora(4, "Usuario02"));
        cola.insertar(new TrabajoImpresora(5, "Usuario01"));
        cola.insertar(new TrabajoImpresora(6, "Usuario03"));
        cola.insertar(new TrabajoImpresora(7, "Usuario01"));
        System.out.println("Cola con varios trabajos: " + cola);
        System.out.println("Tamaño actual: " + cola.getTalla());

        // Cancelar trabajos de Usuario01
        System.out.println("\nCancelando trabajos de Usuario01...");
        cola.cancelar("Usuario01");
        System.out.println("Cola después de cancelar: " + cola);
        System.out.println("Tamaño actual: " + cola.getTalla());

        // Cancelar trabajos de un usuario que no existe
        System.out.println("\nCancelando trabajos de un usuario inexistente...");
        cola.cancelar("UsuarioInexistente");
        System.out.println("Cola después de intentar cancelar usuario inexistente: " + cola);
        System.out.println("Tamaño actual: " + cola.getTalla());

        // Cancelar todos los trabajos restantes
        System.out.println("\nCancelando todos los trabajos restantes...");
        cola.cancelar("Usuario02");
        cola.cancelar("Usuario03");
        System.out.println("Cola después de cancelar todos los trabajos: " + cola);
        System.out.println("¿Está vacía ahora? " + cola.esVacía());

        // Prueba del metodo adelantar
        System.out.println("\n=== PRUEBA DEL MÉTODO ADELANTAR ===");
        // Insertar varios trabajos
        cola.insertar(new TrabajoImpresora(8, "Usuario01"));
        cola.insertar(new TrabajoImpresora(9, "Usuario02"));
        cola.insertar(new TrabajoImpresora(10, "Usuario03"));
        cola.insertar(new TrabajoImpresora(11, "Usuario04"));
        System.out.println("Cola con varios trabajos: " + cola);

        // Adelantar un trabajo del medio
        System.out.println("\nAdelantando trabajo con ID 10...");
        cola.adelantar(10);
        System.out.println("Cola después de adelantar trabajo con ID 10: " + cola);

        // Adelantar un trabajo que ya está al principio
        System.out.println("\nAdelantando trabajo que ya está al principio (ID 10)...");
        cola.adelantar(10);
        System.out.println("Cola después de intentar adelantar trabajo ya al principio: " + cola);

        // Adelantar el último trabajo
        System.out.println("\nAdelantando el último trabajo (ID 11)...");
        cola.adelantar(11);
        System.out.println("Cola después de adelantar el último trabajo: " + cola);

        // Adelantar un trabajo que no existe
        System.out.println("\nAdelantando un trabajo inexistente (ID 99)...");
        cola.adelantar(99);
        System.out.println("Cola después de intentar adelantar trabajo inexistente: " + cola);

        // Prueba de casos especiales
        System.out.println("\n=== PRUEBA DE CASOS ESPECIALES ===");
        // Vaciar la cola
        while (!cola.esVacía()) {
            cola.extraerPrimero();
        }
        System.out.println("Cola vaciada. ¿Está vacía? " + cola.esVacía());

        // Intentar cancelar en cola vacía
        System.out.println("\nIntentando cancelar en cola vacía...");
        cola.cancelar("Usuario01");
        System.out.println("¿Sigue vacía? " + cola.esVacía());

        // Intentar adelantar en cola vacía
        System.out.println("\nIntentando adelantar en cola vacía...");
        cola.adelantar(10);
        System.out.println("¿Sigue vacía? " + cola.esVacía());

        // Cola con un solo elemento
        System.out.println("\nCreando cola con un solo elemento...");
        cola.insertar(new TrabajoImpresora(12, "Usuario01"));
        System.out.println("Cola con un elemento: " + cola);

        // Adelantar en cola con un solo elemento
        System.out.println("\nAdelantando en cola con un solo elemento...");
        cola.adelantar(12);
        System.out.println("Cola después de adelantar: " + cola);

        // Cancelar el único elemento
        System.out.println("\nCancelando el único elemento...");
        cola.cancelar("Usuario01");
        System.out.println("¿Está vacía ahora? " + cola.esVacía());
    }
}
