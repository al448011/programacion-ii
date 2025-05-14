package practica4;

import java.util.NoSuchElementException;

public class PruebaActa {

    public static void main(String[] args) {

        NotaEstudiante[] alumnos = {  // El vector debe estar ordenado por DNI
                new NotaEstudiante("012A", 1),
                new NotaEstudiante("123B", 1),
                new NotaEstudiante("234C", 2),
                new NotaEstudiante("345D", 1),
                new NotaEstudiante("456E", 1),
                new NotaEstudiante("567F", 1),
                new NotaEstudiante("678G", 2),
                new NotaEstudiante("789H", 1),
                new NotaEstudiante("890I", 4),
                new NotaEstudiante("901J", 1)
        };

        String[] suscritos = {"000X", "123B", "345D", "567F", "666X", "789H", "901J", "999X"};
        // Vector ordenado. Los DNI que acaban en X son estudiantes de la titulación que no están matriculados en esta asignatura.

        Acta eimt1008 = new Acta("EIMT1008", 2022, alumnos);

        System.out.println("Acta vacía");
        System.out.println(eimt1008);


        System.out.println("Calificando alumnos...");
        eimt1008.calificar("012A", 9);
        eimt1008.calificar("123B", 8);
        eimt1008.calificar("234C", 7);
        eimt1008.calificar("345D", 6);
        eimt1008.calificar("456E", 5);
        eimt1008.calificar("567F", 4);
        eimt1008.calificar("678G", 3);
        try {
            eimt1008.calificar("000X", 1);
        } catch (NoSuchElementException e) {
            System.out.println("No se puede calificar a un alumno que no está en la asignatura. OK1");
        }
        try {
            eimt1008.calificar("666X", 1);
        } catch (NoSuchElementException e) {
            System.out.println("No se puede calificar a un alumno que no está en la asignatura. OK2");
        }
        try {
            eimt1008.calificar("999X", 1);
        } catch (NoSuchElementException e) {
            System.out.println("No se puede calificar a un alumno que no está en la asignatura. OK3");
        }

        System.out.println();
        System.out.println("Acta tras calificar (debe haber 7 notas decrecientes)");
        System.out.println(eimt1008);

        System.out.println();
        System.out.println("Enviando SMS (Se deben enviar 3 mensajes - a 123B, 345D y 567F");
        eimt1008.enviarSMS(suscritos);

        System.out.println();
        System.out.println("Acta de la siguiente convocatoria (debe tener los 5 últimos sin calificar)");
        Acta nueva = eimt1008.siguienteConvocatoria();
        System.out.println(nueva);
    }
}