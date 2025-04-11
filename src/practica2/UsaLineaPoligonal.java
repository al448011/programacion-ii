package practica2;

import java.util.Locale;

public class UsaLineaPoligonal {
    public static void main(String[] args) {
        // Usamos el constructor
        System.out.println("Creamos una línea vacía");
        LineaPoligonal línea1 = new LineaPoligonal();

        // Usamos los métodos toString y longitud con una línea vacía
        System.out.println("  Línea = " + línea1);
        System.out.println("  Longitud = " + línea1.longitud());

        Punto[] v = {new Punto(200, 0), new Punto(400, 0), new Punto(219.81, -86.78), new Punto(344.5, 69.59),
                new Punto(300, -125.4), new Punto(255.5, 69.59), new Punto(380.19, -86.78), new Punto(200, 0)};
        for (Punto p : v) {
            // Usamos el método añadir
            System.out.println("\nAñadimos el punto " + p + ":");
            línea1.añadir(p);
            // Usamos los métodos toString y longitud con líneas con diferente número de puntos
            System.out.println("  Línea = " + línea1);
            System.out.printf(Locale.US, "  Longitud = %.2f%n", línea1.longitud());
        }

        // Usamos el método trasladar
        double valorX = 100, valorY = 200;
        System.out.println("\nTrasladamos la línea en " + valorX + " y " + valorY + ":");
        línea1.trasladar(valorX, valorY);
        System.out.println("  Línea = " + línea1);
        System.out.printf(Locale.US, "  Longitud = %.2f%n", línea1.longitud());  // Debe ser 1400

        // Usamos los métodos quitar(int) y quitar(Punto)
        System.out.println("\nQuitamos varios puntos:");
        System.out.println("  - Punto en posición 1");
        línea1.quitar(1);
        Punto unPunto = new Punto(300, 200);
        System.out.println("  - Punto " + unPunto);
        línea1.quitar(unPunto);
        System.out.println("  - Punto en posición 4");
        línea1.quitar(4);
        System.out.println("  - Punto " + unPunto);
        línea1.quitar(unPunto);
        System.out.println("\nTras quitar los puntos anteriores:");
        System.out.println("  Línea = " + línea1);
        System.out.printf(Locale.US, "  Longitud = %.2f%n", línea1.longitud());  // Debe ser 600

        // Creamos una línea larga (para redimensionar varias veces)
        System.out.println("\nCreamos otra línea:");
        Punto[] v2 = {new Punto(319.81, 113.22), new Punto(444.50, 269.59), new Punto(400.00, 74.60), new Punto(355.50, 269.59)};
        int n = 1000;
        System.out.println("  - Creamos una línea vacía");
        LineaPoligonal línea2 = new LineaPoligonal();
        System.out.println("  - Añadimos " + n + " puntos");
        for (int i = 1; i <= n; i++)
            línea2.añadir(new Punto(i, i));
        System.out.println("  - Añadimos " + v2.length + " puntos más");
        for (Punto p : v2)
            línea2.añadir(p);
        System.out.println("  - Borramos sus " + n + " primeros puntos");
        for (int i = 1; i <= n; i++)
            línea2.quitar(0);

        System.out.println("\nLa nueva línea, tras las operaciones anteriores:");
        System.out.println("  Línea = " + línea2);
        System.out.printf(Locale.US, "  Longitud = %.2f%n", línea2.longitud());  // Debe ser 600

        // Usamos el método equals
        if (línea1.equals(línea2))  // Debe ser true
            System.out.println("\nLas líneas contienen los mismos puntos");
        else {
            System.out.println("\nLa llamada línea1.equals(línea2) debería devolver true. Repasa:");
            System.out.println("  - el método equals de LineaPoligonal");
            System.out.println("  - el método equals de Punto (presta atención a la comparación de valores flotantes)");
        }
    }
}
