package org.iesalandalus.programacion.ficheros.secuencial.caracteres.buffers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarFicheroTexto {

	private static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroTextoGrande.txt");
	private static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "salidaFicheroTexto.txt");
    
	public static void main(String[] args) {
		try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO_ENTRADA)); BufferedWriter salida = new BufferedWriter(new FileWriter(FICHERO_SALIDA))){
			String linea;
			while ((linea = entrada.readLine()) != null) {
				salida.write(linea);
				salida.newLine();
			}
			System.out.println("Fichero copiado satisfactoriamente.");
		} catch (FileNotFoundException e) {
			if (e.getMessage().startsWith(FICHERO_ENTRADA)) {
				System.out.printf("No existe el fichero de origen: %s%n", FICHERO_ENTRADA);
			} else {
				System.out.printf("No existe el directorio de destino o no tengo permiso de escritura: %s%n", FICHERO_SALIDA);
			}
		} catch (IOException e) {	
			System.out.println("Error inesperado de Entrada/Salida.");
		} 
	}

}
