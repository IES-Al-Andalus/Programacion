package org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirObjetos {
	
	private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");

	public static void main(String[] args) {
		Persona persona;
		String[] nombres = { "Juan", "Alfonso", "Araceli", "Manolo", "Rubén", "Elvira", "Inés", "José Ramón" };
		int[] edades = { 31, 35, 25, 40, 37, 18, 20, 22 };
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO))){
			for (int i = 0; i < edades.length; i++) {
				persona = new Persona(nombres[i], edades[i]);
				salida.writeObject(persona);
			}
			System.out.println("Fichero escrito satisfactoriamente.");
		} catch (FileNotFoundException e) {
			System.out.println("No puedo crear el fichero de salida.");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		}
	}

}
