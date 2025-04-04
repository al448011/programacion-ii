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

    public double getX() { return this.x; }

    public double getY() { return this.y; }

    public Punto desplazar(double desplazamientoX, double desplazamientoY){

        double nuevaX = this.x + desplazamientoX;
        double nuevaY = this.y + desplazamientoY;

        return new Punto(nuevaX,nuevaY);

        // Otra manera podría haber sido:
        //      return new Punto(this.x + desplazamientoX, this.y + desplazamientoY);
    }

    public double distancia(Punto otroPunto){
        return Math.sqrt(
                Math.pow((otroPunto.getX() - this.x),2)
                +
                Math.pow((otroPunto.getY() - this.y),2)
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
}
