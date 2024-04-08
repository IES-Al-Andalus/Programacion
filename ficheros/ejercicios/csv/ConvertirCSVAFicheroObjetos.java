package org.iesalandalus.programacion.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;

public class ConvertirCSVAFicheroObjetos {
	
	private static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
	private static final String FICHERO_CSV = String.format("%s%s%s", "ficheros", File.separator, "personas.csv");
	
	private static final String SEPARADOR = ",";
	
	public static void main(String[] args) {
		List<Persona> personas = leerCSV();
		escribirFicheroObjetos(personas);
	}
	
	private static List<Persona> leerCSV() {
		List<Persona> personas = new ArrayList<>();
		try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO_CSV))){
			String linea;
			while ((linea = entrada.readLine()) != null) {
				String[] campos = linea.split(SEPARADOR);
				personas.add(new Persona(campos[0], Integer.parseInt(campos[1])));
			}
			System.out.println("Fichero CSV leído correctamente.");
		} catch (FileNotFoundException e) {
			System.out.printf("No se puede leer el fichero de entrada: %s.%n", FICHERO_CSV);
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		}
		return personas;
	}
	
	private static void escribirFicheroObjetos(List<Persona> personas) {
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_OBJETOS))){
			for (Persona persona : personas) {
				salida.writeObject(persona);
			}
			System.out.println("Fichero de objetos escrito correctamente.");
		} catch (FileNotFoundException e) {
			System.out.printf("No existe el directorio de destino o no tengo permiso de escritura: %s.%n", FICHERO_OBJETOS);
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		}
	}
}
