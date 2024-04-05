package org.iesalandalus.programacion.ficheros.secuencial.bytes.datosprimitivos;

import java.io.*;

public class EscribirFicheroDatos {

	private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroDatos.bin");

	public static void main(String[] args) {

		try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(FICHERO))) {
			escribirDatos(salida);
		} catch (FileNotFoundException e) {
			System.out.println("No se puede leer el fichero de salida");
		} catch (IOException e) {
			System.out.printf("No existe el fichero: %s%n", FICHERO);
		}
	}

	private static void escribirDatos(DataOutputStream salida) throws IOException {
		String datoString;
		int datoInt;
		double datoDouble;
		for (int i = 0; i < 10; i++) {
			datoString = "Cadena número: " + i;
			datoInt = 10 * i;
			datoDouble = datoInt / 100.0;
			salida.writeUTF(datoString);
			salida.writeInt(datoInt);
			salida.writeDouble(datoDouble);
		}
		System.out.println("Fichero creado satisfactoriamente");
	}

}
