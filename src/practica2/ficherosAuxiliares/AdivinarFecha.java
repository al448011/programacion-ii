package practica2;

import java.util.Random;
import java.util.Scanner;

public class AdivinarFecha {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Fecha secreta = generarFecha(Fecha.PRIMER_AÑO, Fecha.ÚLTIMO_AÑO);

        System.out.format("Intenta adivinar una fecha secreta comprendida entre los días 1/1/%d y 31/12/%d%n",
                Fecha.PRIMER_AÑO, Fecha.ÚLTIMO_AÑO);
        int intentos = 1;  // Solo tendremos en cuenta los intentos correspondientes a fechas correctas
        Fecha fecha = leerFecha(teclado);
        while (!fecha.equals(secreta)) {
            intentos++;
            System.out.println("La fecha secreta es " + (fecha.compareTo(secreta) < 0 ? "posterior" : "anterior"));
            fecha = leerFecha(teclado);
        }
        System.out.println("¡Enhorabuena!. Has adivinado la fecha secreta en " + intentos + " intentos");
    }

    private static Fecha leerFecha(Scanner entrada) {
        Fecha fecha = null;
        do {
            System.out.println("\nIntroduce una fecha:");
            System.out.print("  Día: ");  int día = entrada.nextInt();
            System.out.print("  Mes: ");  int mes = entrada.nextInt();
            System.out.print("  Año: ");  int año = entrada.nextInt();
            try {
                fecha = new Fecha(día, mes, año);
            } catch (ExcepcionFechaNoValida e) {
                System.out.println("Los valores no representan una fecha. Inténtalo de nuevo\n");
            }
        } while (fecha == null);
        return fecha;
    }

    private static Fecha generarFecha(int añoInicial, int añoFinal) {
        int año = rand.nextInt(añoFinal - añoInicial + 1) + añoInicial;
        int mes = rand.nextInt(12) + 1;
        int día = rand.nextInt(Fecha.díasMes(mes, año)) + 1;
        return new Fecha(día, mes, año);
    }

}
