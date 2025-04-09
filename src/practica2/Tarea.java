package practica2;

public class Tarea {
    // Atributos

    private Fecha fecha;
    private String descripción;

    // Constructores

    Tarea(Fecha fecha, String descripción){
        this.fecha = fecha;
        this.descripción = descripción;
    }

    // Métodos

    public Fecha getFecha(){ return this.fecha; }
    public String getDescripción(){ return this.descripción; }

    public String toString(){
        return String.format("%s: %s", fecha.toString(), this.descripción);
    }
}
