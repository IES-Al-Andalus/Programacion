package org.iesalandalus.programacion.csv;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;

public class ConvertirFicheroObjetosACSV {
	
	private static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
	private static final String FICHERO_CSV = String.format("%s%s%s", "ficheros",  File.separator, "personas.csv");
	
	private static final String SEPARADOR = ",";

	public static void main(String[] args) {
		List<Persona> personas = leerFicheroObjetos();
		escribirFicheroCSV(personas);
	}
	
	private static List<Persona> leerFicheroObjetos() {
		List<Persona> personas = new ArrayList<>();
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO_OBJETOS))){
			Persona persona;
			while ((persona = (Persona) entrada.readObject()) != null) {
				personas.add(persona);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.printf("No se puede leer el fichero de entrada: %s.%n", FICHERO_OBJETOS);
		} catch (ClassNotFoundException cnfee) {
			System.out.println("No puedo encontrar la clase que tengo que leer.");
		} catch (EOFException eo) {
			System.out.println("Fichero de objetos leído satisfactoriamente.");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		}
		return personas;
	}
	
	private static void escribirFicheroCSV(List<Persona> personas) {
		try (BufferedWriter salida = new BufferedWriter(new FileWriter(FICHERO_CSV))){
			for (Persona persona : personas) {
				salida.write(String.format("%s%s%d%n", persona.getNombre(), SEPARADOR, persona.getEdad()));
			}
			System.out.println("Fichero CSV escrito satisfactoriamente.");
		} catch (FileNotFoundException fnfe) {
			System.out.printf("No se puede leer el fichero de salida: %s.%n", FICHERO_CSV);
		} catch (IOException e) {
			System.out.printf("No se ha podido escribir el fichero %s.%n", FICHERO_CSV);
		}
	}

}
