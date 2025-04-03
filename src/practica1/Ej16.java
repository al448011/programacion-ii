package practica1;

import java.util.Arrays;
import java.util.Objects;

public class Ej16 {
    public static int contarOlasDeFrío(double[] vector, int n){

        boolean olaFrío = false;
        int contOlasFrío = 0;
        int díasConsecutivos = 0;

        for (int i = 0; i < vector.length; i++){
            if (vector[i] < 0){
                díasConsecutivos += 1;
                if (díasConsecutivos >= n)
                    olaFrío = true;
            } else if (olaFrío) {
                contOlasFrío += 1;
                díasConsecutivos = 0;
                olaFrío = false;
            } else {
                díasConsecutivos = 0;
            }

        }
        return contOlasFrío;
    }

    //
    // Sección de pruebas
    //

    public static void prueba(double[] vector, int n, int esperado){
        int resultado = contarOlasDeFrío(vector, n);
        System.out.format("Prueba con %s --> %s: ", Arrays.toString(vector), resultado);
        if (Objects.equals(resultado, esperado))
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }

    public static void main(String[] args) {
        prueba(new double[] {5.0, 7.5, 8.0, 10.0, 6.5, 4.0, 3.0, 2.5, 1.0, 0.5, -1.0, 2.0}, 2, 0);
        prueba(new double[] {5.0, -2.0, -3.0, -1.0, 4.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0}, 3, 1);
        prueba(new double[] {-1.0, -2.0, -3.0, 5.0, 6.0, -4.0, -5.0, -6.0, 7.0, 8.0, 9.0, 10.0}, 3, 2);
        prueba(new double[] {5.0, 6.0, 7.0, -1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, 8.0, 9.0}, 7, 1);
        prueba(new double[] {5.0, -1.0, 6.0, -2.0, 7.0, -3.0, 8.0, -4.0, 9.0, -5.0, 10.0, -6.0}, 2, 0);

    }
}
