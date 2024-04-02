package org.iesalandalus.programacion.ficheros.secuencial.caracteres.flujos;

import java.io.*;

public class MostrarFicheroTexto {

	private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroTexto.txt");
    
	public static void main(String[] args) {
		try (FileReader entrada = new FileReader(FICHERO)){
			int dato;
			while ((dato = entrada.read()) != -1) {
				System.out.print((char) dato);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se puede leer el fichero de entrada");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida");
		}
	}

}
