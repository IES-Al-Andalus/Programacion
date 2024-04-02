package org.iesalandalus.programacion.ficheros.secuencial.caracteres.buffers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MostrarFicheroTexto {
	
	private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroTexto.txt");
    
	public static void main(String[] args) {
		try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO))){
			String linea;
			while ((linea = entrada.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se puede leer el fichero de entrada.");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		}
	}
}
