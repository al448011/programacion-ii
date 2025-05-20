package practica4;

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
        int inicio = 0;
        int fin = notas.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (notas[medio].getDNI().compareTo(DNI) < 0) //Como el DNI es un String tenemos que pasarlo a Unicode decimal, restarlo con el que encontramos y ver si es positivo (DNI encontrado - DNI), si es negativo esta en la mitad derecha y si es positivo en la mitad izquierda
                inicio = medio + 1; //Nos vamos a comprobar la mitad derecha porque en la izq no esta porque es más pequeño
            else if (notas[medio].getDNI().compareTo(DNI) > 0) //Si (DNI encontrado - DNI) es negativo esta en la mitad derecha y si es positivo en la mitad izquierda
                fin = medio - 1; //Nos vamos a comprobar la mitad izquierda porque en la drch no esta porque es más grande
            else if (notas[medio].getDNI().compareTo(DNI) == 0) { //Encontrado
                notas[medio].setNota(nota);
                return;
                }
        }
        // Si llegamos aquí, no se encontró el DNI
        throw new NoSuchElementException();
    }

    public void enviarSMS(String[] vectorDNI) {
        int i = 0; // Índice para vectorDNI
        int j = 0; // Índice para notas

        // Mientras no hayamos llegado al final de ninguno de los vectores
        while (i < vectorDNI.length && j < notas.length) {
            int comparacion = notas[j].getDNI().compareTo(vectorDNI[i]);

            if (comparacion < 0) {
                // El DNI en notas es menor, avanzamos en notas
                j++;
            } else if (comparacion > 0) {
                // El DNI en vectorDNI es menor, avanzamos en vectorDNI
                i++;
            } else {
                // Los DNI coinciden
                if (notas[j].getPresentado()) {
                    SMS.enviar(notas[j].getDNI(), notas[j].getNota());
                }
                // Avanzamos en ambos vectores
                i++;
                j++;
            }
        }
    }

    public Acta siguienteConvocatoria() {

        int cantidadRepetidores = 0;
        for (NotaEstudiante estudiante : notas) //Primer for para ver cuantos elementos tendrá el nuevo vector de notas porque java es un xacas y lo necesita ya
            if (estudiante.getNota() < 5) cantidadRepetidores++;

        NotaEstudiante[] nuevasNotas = new NotaEstudiante[cantidadRepetidores];

        int i = 0;
        for (NotaEstudiante estudiante : notas) {
            if (estudiante.getNota() < 0) {
                nuevasNotas[i] = new NotaEstudiante(estudiante.getDNI(), estudiante.getConvocatoria());
            i++;
            }
            else if (estudiante.getNota() < 5) {
                nuevasNotas[i] = new NotaEstudiante(estudiante.getDNI(), estudiante.getConvocatoria() + 1);
                i++;
            }



        }
        return new Acta(código, curso, nuevasNotas);
    }

    public String toString() {
        String resultado = String.format("%s -> %d%n", código, curso);
        for (NotaEstudiante n: notas)
            resultado += n;
        return resultado;
    }
}
