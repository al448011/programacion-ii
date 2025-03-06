package práctica1;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] v1 = {1, 3, 5, 7, 9};

        System.out.println("Contenido inicial de v1: " + Arrays.toString(v1));

        // Intento erróneo de redimensionar.
        System.out.println("\nSe ejecuta redimensionarIncorrecto(v1, v1.length * 2);");
        redimensionarIncorrecto(v1, v1.length * 2);
        System.out.println("Nuevo contenido de v1: " + Arrays.toString(v1));

        // Redimensionar el vector (reducir su longitud en 1).
        System.out.println("\nSe ejecuta v1 = redimensionar(v1, v1.length - 1);");
        v1 = redimensionar(v1, v1.length - 1);
        System.out.println("Nuevo contenido de v1: " + Arrays.toString(v1));

        // Redimensionar el vector (duplicar su longitud).
        System.out.println("\nSe ejecuta v1 = redimensionar(v1, v1.length * 2);");
        v1 = redimensionar(v1, v1.length * 2);
        System.out.println("Nuevo contenido de v1: " + Arrays.toString(v1));
    }

    // Intento erróneo de redimensionar un vector
    public static void redimensionarIncorrecto(int[] vector, int nuevaLongitud) {
        int[] nuevoVector = new int[nuevaLongitud];
        int longitudMínima = vector.length < nuevaLongitud ? vector.length : nuevaLongitud;
        for (int i = 0; i < longitudMínima; i++)
            nuevoVector[i] = vector[i];
        vector = nuevoVector;
    }

    // Devuelve un nuevo vector igual al dado, pero redimensionado a nuevaLongitud.
    // nuevaLongitud puede ser mayor, menor o igual que la longitud del vector dado.
    public static int[] redimensionar(int[] vector, int nuevaLongitud) {
        int[] nuevoVector = new int[nuevaLongitud];
        int longitudMínima = vector.length < nuevaLongitud ? vector.length : nuevaLongitud;
        for (int i = 0; i < longitudMínima; i++)
            nuevoVector[i] = vector[i];
        return nuevoVector;
    }
}
