package org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos;

import java.io.*;

public class LeerObjetos {
	
	private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
	
	public static void main(String[] args) {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO))) {
			Persona persona;
			while ((persona = (Persona) entrada.readObject()) != null) {
				System.out.printf("Nombre: %s, edad: %d%n", persona.getNombre(), persona.getEdad());
			}
		} catch (FileNotFoundException e) {
			System.out.println("No puedo crear el fichero de entrada.");
		} catch (EOFException eo) {
			System.out.println("Fichero leído satisfactoriamente.");
		} catch (ClassNotFoundException e) {
			System.out.println("No puedo encontrar la clase que tengo que leer.");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		}
	}

}
