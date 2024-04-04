package org.iesalandalus.programacion.ficheros.file;

import java.io.File;
import java.util.Date;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MostrarPropiedades {

	public static void main(String[] args) {

		mostrarPropiedadesSistema();
		System.out.print("Escribe el nombre del fichero: ");
		String nombreFichero = Entrada.cadena();
		while(!nombreFichero.equals("FIN")) {
			File fichero = new File(nombreFichero);
			if (fichero.exists()) {
				mostrarPropiedadesFichero(fichero);
			} else {
				System.out.printf("El fichero: %s No existe.%n", nombreFichero);
			}
			
			System.out.print("Escribe el nombre del fichero: ");
			nombreFichero = Entrada.cadena();
		}

	}

	private static void mostrarPropiedadesSistema() {
		System.out.println("Propiedades del sistema");
		System.out.println("=======================");
		System.out.printf("Separador del sistema: %s%n", File.separator);
		System.out.printf("Directorio de trabajo: %s%n", new File("").getAbsolutePath());
		System.out.printf("Directorio de trabajo (user.dir): %s%n%n", System.getProperty("user.dir"));
	}

	private static void mostrarPropiedadesFichero(File fichero) {
		System.out.printf("Fecha última modificación: %s%n", new Date(fichero.lastModified()));
		System.out.printf("Directorio? %s%n", fichero.isDirectory());
		System.out.printf("Fichero? %s%n", fichero.isFile());
		System.out.printf("Se puede escribir? %s%n", fichero.canWrite());
		System.out.printf("Se puede leer? %s%n", fichero.canRead());
		System.out.printf("Se puede ejecutar? %s%n", fichero.canExecute());
		System.out.printf("Camino absoluto: %s%n", fichero.getAbsolutePath());
		System.out.printf("Tamaño: %d%n", fichero.length());
		
		if (fichero.isDirectory()) {
			System.out.println();
			System.out.println("Contenido del directorio");
			System.out.println("========================");
			File[] ficheros = fichero.listFiles();
			if (ficheros != null) {
				for (File file : ficheros) {
					if (file.isDirectory()) {
						System.out.printf("D-> %s%n", file);
					} else {
						System.out.printf("A-> %s%n", file);
					}
				}
			}
		}
		System.out.printf("---------------------------%n%n");
	}

}
