	public static void main(String[] args) throws FileNotFoundException {
		String[] dnisCenso = crearVectorDni("datos/dniCenso.txt");
		String[] dnisClientes = crearVectorDni("datos/dniClientes.txt");

		long tiempoInicio = System.currentTimeMillis();
		int coincidencias = contarCoincidencias(dnisCenso, dnisClientes);
		long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;

		System.out.println("He encontrado " + coincidencias
				+ " coincidencias (empleando " + tiempoTranscurrido
				+ " milisegundos)");

	}
