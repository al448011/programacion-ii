package practica4;

public class NotaEstudiante {
    private String DNI;
    private int convocatoria;
    private double nota;
    private boolean presentado;

    public NotaEstudiante(String DNI, int convocatoria) {
        this.DNI = DNI;
        this.convocatoria = convocatoria;
        this.presentado = false;
        this.nota = -1; // No se ha presentado. La nota no es válida.
    }

    public String getDNI() {
        return DNI;
    }

    public int getConvocatoria() {
        return convocatoria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
        this.presentado = true;
    }

    public boolean getPresentado() {
        return presentado;
    }

    public String toString() {
        return String.format("%s: ", DNI) + (this.presentado ? String.format("%4.2f", nota) : "NP") + String.format("%n");
    }
}
