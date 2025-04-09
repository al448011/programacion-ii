package practica2;

public class Agenda {
    // Atributos

    private Tarea[] vectorTareas;

    // Constructores

    public Agenda(){
        this.vectorTareas = new Tarea[0];
    }

    // Métodos

    private int posiciónInserción(Tarea tarea){
        for (int i = 0; i < vectorTareas.length; i++){
            if (vectorTareas[i].getFecha().compareTo(tarea.getFecha()) > 0)
                return i;
        }
        return vectorTareas.length;
    }

    public void añadir(Tarea tarea){
        Tarea[] nuevoVectorTareas = new Tarea[vectorTareas.length + 1];
        int inserción = posiciónInserción(tarea);

        for (int i = 0; i < nuevoVectorTareas.length; i++){
            if (i == inserción)
                nuevoVectorTareas[i] = tarea;
            else
                if (i < inserción)
                    nuevoVectorTareas[i] = vectorTareas[i];
                else
                    nuevoVectorTareas[i] = vectorTareas[i-1];
        }
        vectorTareas = nuevoVectorTareas;
    }

    public int cantidad(){ return vectorTareas.length; }

    public Tarea[] consultar(Fecha fecha){
        int númeroTareas = 0;

        for (int i = 0; i < vectorTareas.length; i++){
            if (fecha.equals(vectorTareas[i].getFecha())) {
                númeroTareas++;
            }
        }

        Tarea[] vectorConsultas = new Tarea[númeroTareas];

        int posiciónConsulta = 0;
        for (Tarea vectorTarea : vectorTareas) {
            if (fecha.equals(vectorTarea.getFecha())) {
                vectorConsultas[posiciónConsulta] = vectorTarea;
                posiciónConsulta++;
            }
        }
        return  vectorConsultas;
    }

    public void borrarPasadas(Fecha fecha){
        int cantidadPasadas = 0;

        for (Tarea elementoTarea : vectorTareas){
            if (elementoTarea.getFecha().compareTo(fecha) < 0)
                cantidadPasadas++;
        }

        Tarea[] nuevoVectorTareas = new Tarea[vectorTareas.length - cantidadPasadas];

        for (int i = 0; i < vectorTareas.length; i++){
            if(vectorTareas[i].getFecha().compareTo(fecha) >= 0)
                nuevoVectorTareas[i] = vectorTareas[i];
        }

        vectorTareas = nuevoVectorTareas;
    }

    public void borrar(){
        Fecha hoy = Fecha.hoy();
        borrarPasadas(hoy);
    }

    public String toString(){
        for (Tarea elementoTarea : vectorTareas){
            return elementoTarea.toString();
        }
    }
}
