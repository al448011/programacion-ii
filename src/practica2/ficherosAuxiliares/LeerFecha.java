package practica2;

import java.util.Scanner;

public class LeerFecha {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Fecha fecha = null;
        do {
            System.out.format("Introduce una fecha (año entre %d y %d):%n", Fecha.PRIMER_AÑO, Fecha.ÚLTIMO_AÑO);
            System.out.print("  Día: ");  int día = teclado.nextInt();
            System.out.print("  Mes: ");  int mes = teclado.nextInt();
            System.out.print("  Año: ");  int año = teclado.nextInt();
            try {
                fecha = new Fecha(día, mes, año);
            } catch (ExcepcionFechaNoValida e) {
                System.out.println("Los valores no representan una fecha. Inténtalo de nuevo\n");
            }
        } while (fecha == null);

        System.out.println("\nLa fecha leída es " + fecha);
    }
}
