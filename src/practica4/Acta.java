package practica4;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Acta {
    // Atributos
    private String código;          // Código de la asignatura
    private int curso;              // Curso académico
    private NotaEstudiante[] notas; // Datos de los estudiantes que hay en el acta
                                    // (ordenados de menor a mayor por DNI)

    // Constructor
    public Acta(String código, int curso, NotaEstudiante[] notas) {
        this.código = código;
        this.curso = curso;
        this.notas = notas;
    }

    // Métodos
    public void calificar(String DNI, double nota) throws NoSuchElementException {
        int inicio = 0;
        int fin = notas.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (notas[medio].getDNI().compareTo(DNI) > 0) {
                fin = medio - 1;
            }
            else if (notas[medio].getDNI().compareTo(DNI) < 0)
                inicio = medio + 1;
            else if (notas[medio].getDNI().compareTo(DNI) == 0){
                notas[medio].setNota(nota);
                break;
            } else
                throw new NoSuchElementException();
        }
    }

    public void enviarSMS(String[] vectorDNI) {
        for (String dni : vectorDNI){
            if ()
        }
    }

    public Acta siguienteConvocatoria() {
        return null;
    }

    public String toString() {
        String resultado = String.format("%s -> %d%n", código, curso);
        for (NotaEstudiante n: notas)
            resultado += n;
        return resultado;
    }
}
