package practica2;

public class UsaAgenda {
    public static void main(String[] args) {
        // Usamos el constructor
        Agenda agenda = new Agenda();

        // Usamos el método cantidad
        System.out.println("¿Agenda vacía? " + (agenda.cantidad() == 0));  // Debe ser true

        // Usamos el método añadir
        agenda.añadir(new Tarea(new Fecha(17, 3, 2025), "EI1010"));
        agenda.añadir(new Tarea(new Fecha(24, 2, 2025), "EI1007-C1"));
        agenda.añadir(new Tarea(new Fecha(28, 4, 2025), "EI1007-C2"));
        agenda.añadir(new Tarea(new Fecha(24, 2, 2025), "Recoger paquete"));
        agenda.añadir(new Tarea(new Fecha(10, 3, 2025), "EI1008-C1"));
        agenda.añadir(new Tarea(new Fecha(14, 4, 2025), "EI1008-C2"));
        agenda.añadir(new Tarea(new Fecha(24, 2, 2025), "Dentista"));

        // Usamos los métodos cantidad y toString
        System.out.println("\nLa agenda tiene " + agenda.cantidad() + " tareas:");
        System.out.println(agenda);  // Las tareas deben aparecer ordenadas por fecha

        // Usamos el método consultar
        Fecha fechaConsulta = new Fecha(24, 2, 2025);
        System.out.println("Tareas para el día " + fechaConsulta + ": ");
        for (Tarea t : agenda.consultar(fechaConsulta))
            System.out.println(t.getDescripción());

        // Usamos el método borrar con 1 parámetro
        Fecha[] fechasBorrar = {new Fecha(17, 2, 2025), new Fecha(17, 3, 2025), new Fecha(17, 5, 2025)};
        for (Fecha f : fechasBorrar) {
            System.out.println("\nBorrar tareas anteriores a " + f +"...");
            int cantidadPrevia = agenda.cantidad();
            agenda.borrarPasadas(f);
            if (cantidadPrevia == agenda.cantidad())
                System.out.println("La agenda queda igual");
            else if (agenda.cantidad() == 0)
                System.out.println("La agenda queda vacía");
            else {
                System.out.println("La agenda, tras borrar " + (cantidadPrevia - agenda.cantidad()) + " tareas, queda así:");
                System.out.print(agenda);
            }
        }
    }
}
