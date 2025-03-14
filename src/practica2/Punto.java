package practica2;

import java.util.Locale;

public class Punto {
    // Atributos

    private double x;
    private double y;

    // Constructores

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Punto(){
        this.x = 0;
        this.y = 0;
    }

    // Métodos

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public Punto desplazar(double desplazamientoX, double desplazamientoY){

        double nuevaX = this.x + desplazamientoX;
        double nuevaY = this.y + desplazamientoY;

        return new Punto(nuevaX, nuevaY);

//        Otra manera de hacerlo sería poniendo únicamente:
//            return new Punto(this.x + desplazamientoX, this.y + desplazamientoY);

    }

    public double distancia(Punto otroPunto){

         return Math.sqrt(
                Math.pow((this.x + this.y),2)
                        +
                Math.pow((otroPunto.getX() + otroPunto.getY()),2)
        );
    }

    public String toString(){
        return String.format(Locale.US, "(%.2f, %.2f)", this.x, this.y);
    }

    public boolean equals(Object otroObjeto){
        if (this == otroObjeto) return true;
        if (!(otroObjeto instanceof Punto)) return false;

        Punto otroPunto = (Punto) otroObjeto;

        return this.x == otroPunto.getX() && this.y == otroPunto.getY();
    }

    public static void main(String[] args) {
        Punto y = new Punto(2.45,2.34);
        System.out.println(y.toString());

    }
}
