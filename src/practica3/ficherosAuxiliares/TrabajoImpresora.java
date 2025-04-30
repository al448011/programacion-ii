package practica3;  // Indica aquí el nombre del paquete que utilizas.

public class TrabajoImpresora {
    // Atributos:
    private int idTrabajo;
    private String idUsuario;

    // Métodos:
    public TrabajoImpresora(int idTrabajo, String idUsuario) {
        this.idTrabajo = idTrabajo;
        this.idUsuario = idUsuario;
    }

    public int getIdTrabajo() {
        return this.idTrabajo;
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public String toString() {
        return this.idTrabajo + "/" + this.idUsuario;
    }
}
