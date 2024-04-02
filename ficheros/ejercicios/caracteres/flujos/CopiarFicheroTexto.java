package org.iesalandalus.programacion.ficheros.secuencial.caracteres.flujos;

import java.io.*;

public class CopiarFicheroTexto {
	
	private static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroTextoGrande.txt");
	private static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "salidaFicheroTexto.txt");
    
	public static void main(String[] args) {
		try (FileReader entrada = new FileReader(FICHERO_ENTRADA); FileWriter salida = new FileWriter(FICHERO_SALIDA)){
			int dato;
			while ((dato = entrada.read()) != -1) {
				salida.write((char)dato);
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
