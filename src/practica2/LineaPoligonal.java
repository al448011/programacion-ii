package practica2;

public class LineaPoligonal {
    // Atributos

    private Punto[] vectorPuntos;
    private int cantidadPuntos;

    // Constructores

    public LineaPoligonal(){
        vectorPuntos = new Punto[10];
        cantidadPuntos = 0;
    }

    // Métodos

    public void añadir(Punto punto){
        // si la talla es igual a la cantidad de puntos
        if (vectorPuntos.length == cantidadPuntos){
            // creo un nuevo vector del doble de talla
            Punto[] nuevoVectorPuntos = new Punto[vectorPuntos.length * 2];
            // copio lo que tenía en el vector lleno al nuevo vector del doble de talla
            for (int i = 0; i < vectorPuntos.length; i++){
                nuevoVectorPuntos[i] = vectorPuntos[i];
            }
        } else {
            // si la talla no es igual a la cantidad de puntos
            int j = 0;
            // recorro el vector hasta que haya un espacio libre
            while (vectorPuntos[j] != null)
                j++;
            // en esta nueva posición que hay libre pongo el punto
            punto = vectorPuntos[j];
        }
        // como estamos añadiendo sumamos uno a la cantidad de puntos
        cantidadPuntos++;
    }

    public void quitar(int posición){
        if (posición >= 0 && posición < cantidadPuntos){
            for (int i = 0; i < vectorPuntos.length; i++){
                if (i >= posición)
                    vectorPuntos[i] = vectorPuntos[i + 1];
            }
        }
        cantidadPuntos--;
    }

    public void quitar(Punto punto){
        int aparece = 0;

        for (int i = 0; i < vectorPuntos.length; i++){
            if (punto.equals(vectorPuntos[i]) && aparece == 0){
                quitar(i);
                aparece++;
            }
        }
    }

    public void trasladar(double desplazamientoX, double desplazamientoY){
        for (Punto punto : vectorPuntos)
            punto.desplazar(desplazamientoX, desplazamientoY);
    }

    public double longitud(){
        if (cantidadPuntos >= 2){
            double longitud = 0;

            for (int i = 1; i <= cantidadPuntos; i++){
                longitud += vectorPuntos[i].distancia(vectorPuntos[i-1]);
            }

            return longitud;
        }else
            return 0;
    }

    public String toString(){
        String resultado = "";

        for (int i = 0; i <= cantidadPuntos; i++){
            if (i == 0)
                resultado += vectorPuntos[i];
            else
                resultado += "--" + vectorPuntos[i];
        }

        return resultado;
    }

    public boolean equals(Object otroObjeto){
        if (this == otroObjeto) return true;
        if (!(otroObjeto instanceof Punto)) return false;

        Punto[] otroVectorPuntos = (Punto[]) otroObjeto;

        if (vectorPuntos.length == otroVectorPuntos.length){
            for (int i = 0; i < vectorPuntos.length; i++){
                if (!vectorPuntos[i].equals(otroVectorPuntos[i]))
                    return false;
            }

            return true;
        } else
            return false;
    }
}