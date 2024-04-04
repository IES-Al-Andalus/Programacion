package org.iesalandalus.programacion.ficheros.file;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.File;

public class MostrarArbol {

	public static void main(String[] args) {
		System.out.print("Introduce la carpeta a mostrar: ");
		String nombreCarpeta = Entrada.cadena();
		File carpeta = new File(nombreCarpeta);
		if (!carpeta.exists()) {
			System.out.printf("%s NO existe.", nombreCarpeta);
		} else {
			imprimeArbol(carpeta, "");
		}
	}

	private static void imprimeArbol(File carpeta, String tabulador) {
		File[] contenido = carpeta.listFiles();
		if (contenido != null) {
            for (File file : contenido) {
				if (file.isDirectory()) {
					System.out.printf("%s|-%s%n", tabulador, file.getName());
					imprimeArbol(file, tabulador + "|  ");
				} else {
					System.out.printf("%s+-%s%n", tabulador, file.getName());
				}
			}
		}
	}

}
