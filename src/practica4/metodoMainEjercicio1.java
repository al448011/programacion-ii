package practica4;

import java.io.FileNotFoundException;

import static practica4.Ej1.*;

public class metodoMainEjercicio1 {
	public static void main(String[] args) throws FileNotFoundException {
		String[] dnisCenso = crearVectorDni("src/practica4/datos/dniCensoOrdenado.txt");
		String[] dnisClientes = crearVectorDni("src/practica4/datos/dniClientesOrdenado.txt");

		long tiempoInicio = System.currentTimeMillis();
			int coincidencias = contarCoincidenciasv2(dnisCenso, dnisClientes);
		long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;

		System.out.println("He encontrado " + coincidencias
				+ " coincidencias (empleando " + tiempoTranscurrido
				+ " milisegundos)");
	}
}