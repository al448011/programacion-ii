package practica1;

public class Ej11 {
    public static void main(String[] args) {
        prueba("r.j.", "verde", false);
        prueba("r.j.", "rojo", true);
        prueba("r.j.", "reja", true);
        prueba("r.j.", "reza", false);
        prueba("r.j.", "rrjj", false);
        prueba("r.j.", "puja", false);

    }

    public static boolean encaja(String patrón, String cadena){
        if (patrón.length() == cadena.length()){

            for (int i = 0; i < patrón.length(); i++){

                if (patrón.charAt(i) == '.'){
                    if (!esVocal(cadena.charAt(i)))
                        return false;

                } else if (patrón.charAt(i) != cadena.charAt(i)) {
                    return false;
                }
            }

            return true;
        } else
            return false;
    }

    public static boolean esVocal(char c) {
        return "AEIOUaeiou".indexOf(c) >= 0;
    }

    public static void prueba(String patrón, String cadena, boolean esperado) {
        boolean resultado = encaja(patrón, cadena);
        System.out.format("Prueba con %s y %s --> %s: ", patrón, cadena, resultado);
        if (resultado == esperado)
            System.out.println("ok");
        else
            System.out.format("error (se esperaba %s)%n", esperado);
    }
}
