package practica2;

import java.util.Arrays;

public class UsaFecha {
    public static void main(String[] args) {
        // Usamos el constructor con 3 parámetros
        Fecha f1 = new Fecha(10, 3, 2025);

        // Usamos los getters
        System.out.println("\nf1.día es " + f1.getDía());
        System.out.println("f1.mes es " + f1.getMes());
        System.out.println("f1.año es " + f1.getAño());

        // Usamos el constructor con 1 parámetro
        Fecha f2 = new Fecha(f1);

        // Usamos el método toString
        System.out.println("\nf2 es " + f2);

        // Usamos el método equals
        System.out.println("\n¿f1 == f2? " + (f1 == f2));  // Debe ser false
        System.out.println("¿f1.equals(f2)? " + f1.equals(f2));  // Debe ser true

        // Usamos el método compareTo
        System.out.println("\n¿f1.compareTo(f2)? " + f1.compareTo(f2));  // Debe ser 0
        Fecha[] fechas = crearVector();
        System.out.println("¿Vector de fechas ordenado de menor a mayor? " + ordenado(fechas));  // Debe ser true
        System.out.print("¿Último elemento del vector mayor que el primero? ");
        System.out.println(fechas[fechas.length - 1].compareTo(fechas[0]) > 0);  // Debe ser true

        // Usamos el método estático hoy
        f1 = Fecha.hoy();

        // Usamos el método díaSiguiente
        f2 = f1.díaSiguiente().díaSiguiente();  // f1 no debe cambiar
        System.out.println("\nHoy es " + f1 + " y pasado mañana es " + f2);

        // Añade más usos del método compareTo

        // Usamos el método estático esBisiesto
        int[] años = {1900, 2000, 2024, 2025};
        System.out.println();
        for (int año : años)
            System.out.println("¿Bisiesto(" + año + ")? " + Fecha.esAñoBisiesto(año));

        // Usamos el método estático díasMes
        System.out.println("\nFebrero de 2024 tuvo " + Fecha.díasMes(2, 2024) + " días");
        int[] días = new int[12];
        for (int mes = 1; mes <= 12; mes++)
            días[mes - 1] = Fecha.díasMes(mes, 2025);  // Año no bisiesto
        System.out.println("Días de cada mes (año 2025): " + Arrays.toString(días));

    }

    private static boolean ordenado(Fecha[] v) {
        for (int i = 0; i < v.length - 1; i++)
            if (v[i].compareTo(v[i + 1]) > 0)
                return false;
        return true;
    }

    // Crea un vector de fechas ordenado de más antigua a más reciente
    private static Fecha[] crearVector() {
        return new Fecha[]{new Fecha(21, 10, 2024), new Fecha(4, 11, 2024), new Fecha(11, 11, 2024),
                new Fecha(11, 11, 2024), new Fecha(18, 11, 2024), new Fecha(25, 11, 2024),
                new Fecha(2, 12, 2024), new Fecha(9, 12, 2024), new Fecha(16, 12, 2024),
                new Fecha(16, 12, 2024), new Fecha(24, 2, 2025), new Fecha(3, 3, 2025),
                new Fecha(17, 3, 2025), new Fecha(31, 3, 2025), new Fecha(7, 4, 2025),
                new Fecha(14, 4, 2025), new Fecha(28, 4, 2025), new Fecha(5, 5, 2025)};
    }

}
