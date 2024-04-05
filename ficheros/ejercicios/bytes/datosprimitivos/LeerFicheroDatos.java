package org.iesalandalus.programacion.ficheros.secuencial.bytes.datosprimitivos;

import java.io.*;

public class LeerFicheroDatos {
	
	private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroDatos.bin");
    
	public static void main(String[] args) {		
		try (DataInputStream entrada = new DataInputStream(new FileInputStream(FICHERO))){
			mostrarDatos(entrada);
		} catch (FileNotFoundException e) {
			System.out.println("No se puede leer el fichero de entrada");
		} catch (IOException e) {
			System.out.printf("No existe el fichero de origen: %s%n", FICHERO);
		}
	}

	private static void mostrarDatos(DataInputStream entrada) throws IOException {
		try {
			String datoString = "";
			int datoInt;
			double datoDouble;
			while (datoString != null) { //Esta condición siempre será verdadera
				datoString = entrada.readUTF();
				datoInt = entrada.readInt();
				datoDouble = entrada.readDouble();
				System.out.printf("Cadena: %s\tEntero: %s\tDoble: %s%n", datoString, datoInt, datoDouble);
			}
		} catch (EOFException e) {
			System.out.println("Fichero leído satisfactoriamente.");
		}
	}

}
