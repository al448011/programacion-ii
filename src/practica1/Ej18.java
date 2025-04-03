package practica1;

import java.util.Arrays;

import static practica1.Ej11.encaja;

public class Ej18 {
    public static String[] encajan(String patrón, String[] vector){

        String[] cadenasEncajan = new String[] {};

        for (String cadena : vector){
            if (encaja(patrón, cadena)){
                int nuevaLongitud = cadenasEncajan.length + 1;

                String[] nuevoCadenasEncajan = new String[nuevaLongitud];
                for (int i = 0; i < nuevaLongitud - 1; i++){
                    nuevoCadenasEncajan[i] = cadenasEncajan[i];
                }

                nuevoCadenasEncajan[nuevaLongitud - 1] = cadena;
                cadenasEncajan = nuevoCadenasEncajan;
            }
        }

        return cadenasEncajan;
    }

    //
    // Sección de pruebas
    //

    public static void prueba(String patrón, String[] vector, String[] esperado) {
        String[] resultado = encajan(patrón, vector);
        System.out.format("Prueba con %s --> %s: ", Arrays.toString(vector), Arrays.toString(resultado));
        if (Arrays.equals(resultado, esperado))
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", Arrays.toString(esperado));
    }

    public static void main(String[] args) {
        prueba("r.j.", new String[]{"rojo", "reja", "ruja", "raja", "rijo"}, new String[]{"rojo", "reja", "ruja", "raja", "rijo"});
        prueba("c.s.", new String[]{"casa", "cose", "cara", "cesa", "cisa"}, new String[]{"casa", "cose", "cesa", "cisa"});
        prueba("p.t.", new String[]{"pato", "pito", "plato", "pete", "poto"}, new String[]{"pato", "pito", "pete", "poto"});
        prueba("l.p.", new String[]{"lapa", "lepa", "lipa", "lupa", "lope"}, new String[]{"lapa", "lepa", "lipa", "lupa", "lope"});
        prueba("s.l.", new String[]{"sala", "sola", "saltando", "adiós", "sela"}, new String[]{"sala", "sola", "sela"});
    }
}
