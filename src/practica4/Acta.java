package practica4;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Acta {
    // Atributos
    private String código; // Código de la asignatura
    private int curso; // Curso académico
    private NotaEstudiante[] notas; // Datos de los estudiantes que hay en el acta
                                    // (ordenados de menor a mayor por DNI)

    // Constructor
    public Acta(String código, int curso, NotaEstudiante[] notas) {
        this.código = código;
        this.curso = curso;
        this.notas = notas;
    }

    // Métodos
    public void calificar(String DNI, double nota) {
        // Completar
    }

    public void enviarSMS(String[] vectorDNI) {
        // Completar
    }

    public Acta siguienteConvocatoria() {
        return null; // Completar
    }

    public String toString() {
        String resultado = String.format("%s -> %d%n", código, curso);
        for (NotaEstudiante n: notas)
            resultado += n;
        return resultado;
    }
}
