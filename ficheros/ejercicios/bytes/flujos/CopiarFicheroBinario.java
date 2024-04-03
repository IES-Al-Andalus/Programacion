package org.iesalandalus.programacion.ficheros.secuencial.bytes.flujos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarFicheroBinario {

	private static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioGrande.bin");
	private static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "SalidaFicheroBinarioGrande.bin");

	public static void main(String[] args) {
		try (FileInputStream entrada = new FileInputStream(FICHERO_ENTRADA); FileOutputStream salida = new FileOutputStream(FICHERO_SALIDA)) {
			copiarFichero(entrada, salida);
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

	private static void copiarFichero(FileInputStream entrada, FileOutputStream salida) {
		try {
			int dato;
			while ((dato = entrada.read()) != -1) {
				salida.write(dato);
			}
			System.out.println("Fichero copiado satisfactoriamente.");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		}
	}
}
