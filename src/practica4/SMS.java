package practica4;

public class SMS {
    public static void enviar(String DNI, double nota){
        System.out.println(String.format("Se ha enviado un SMS al estudiante con DNI %s en el que se le comunica su calificación (%.2f)",DNI, nota));
    }

    public static void main(String[] args) {
        enviar("123", 0.5);
        enviar("234", 5);
        enviar("345", 9.3);
    }
}
