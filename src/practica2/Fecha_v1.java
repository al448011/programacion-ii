package practica2;

import java.util.Calendar;

public class Fecha_v1 {
    // Atributos

    private int día;
    private int mes;
    private int año;

    // Constructores

    public Fecha_v1(int día, int mes, int año){
        this.día = día;
        this.mes = mes;
        this.año = año;
    }

    public Fecha_v1(Fecha_v1 otraFecha){
        this.día = otraFecha.día;
        this.mes = otraFecha.mes;
        this.año = otraFecha.año;
    }

    // Métodos

    public String toString(){
        return String.format("%d/%d/%d", this.día, this.mes, this.año);
    }

    public boolean equals(Object otroObjeto){
        if (this == otroObjeto) return true;
        if (!(otroObjeto instanceof Fecha_v1)) return false;

        Fecha_v1 otraFecha = (Fecha_v1) otroObjeto;

        return this.día == otraFecha.getDía() && this.mes == otraFecha.getMes() && this.año == otraFecha.getAño();
    }

    public int compareTo(Fecha_v1 otraFecha){
        if (this.año < otraFecha.getAño())
            return -1;
        else if (this.año > otraFecha.getAño())
            return 1;

        if (this.mes < otraFecha.getMes())
            return -1;
        else if (this.mes > otraFecha.getMes())
            return 1;

        if (this.día < otraFecha.getDía())
            return -1;
        else if (this.día > otraFecha.getDía())
            return 1;

        return 0;
    }

    public int getDía(){ return this.día; }
    public int getMes(){ return this.mes; }
    public int getAño(){ return this.año; }

    public static boolean esAñoBisiesto(int año){
        return (año % 4 == 0 && año % 100 != 0) || año % 400 == 0;
    }

    public static int díasMes(int mes, int año){
        if (esAñoBisiesto(año) && mes == 2) return 29;
        else if (mes == 2) return 28;

        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) return 31;
        else return 30;
    }

    public static Fecha_v1 hoy(){
        Calendar calendario = Calendar.getInstance();
        int día = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int año = calendario.get(Calendar.YEAR);

        return new Fecha_v1(día, mes, año);
    }

    public Fecha_v1 díaSiguiente(){

        int día = this.día;
        int mes = this.mes;
        int año = this.año;

        int díasDelMes = díasMes(mes, año);

        if (díasDelMes == día){
            día = 1;
            mes += 1;
            if (mes > 12) {
                año += 1;
                mes = 1;
            }
        } else día += 1;

        return new Fecha_v1(día, mes, año);
    }
}
