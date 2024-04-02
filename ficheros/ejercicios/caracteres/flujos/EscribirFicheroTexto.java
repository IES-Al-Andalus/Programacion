package org.iesalandalus.programacion.ficheros.secuencial.caracteres.flujos;

import java.io.*;

public class EscribirFicheroTexto {
	
	private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "salidaFicheroTexto.txt");
    
	public static void main(String[] args) {
		try (FileWriter salida = new FileWriter(FICHERO);
			InputStreamReader entrada = new InputStreamReader(System.in)){
			int dato;
			while ((dato = entrada.read()) != '|') {
				salida.write((char)dato);
			}
		} catch (FileNotFoundException e) {
			System.out.printf("No existe el fichero de destino: %s%n", FICHERO);
		}
		catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida");
		}
	}

}
