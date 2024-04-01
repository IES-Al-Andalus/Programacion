package org.iesalandalus.programacion.ficheros.file;

import java.io.File;

public class MostrarArbol {

	public static void main(String[] args) {
		File carpeta = new File(".");
		if (!carpeta.exists()) 
			System.out.println(args[0] + " NO existe.");
		else
			imprimeArbol(carpeta, "");
	}

	private static void imprimeArbol(File carpeta, String tabulador) {
		File[] contenido = carpeta.listFiles();
		if (contenido != null) {
            for (File file : contenido)
                if (file.isDirectory()) {
                    System.out.println(tabulador + "|-" + file.getName());
                    imprimeArbol(file, tabulador + "|  ");
                } else {
                    System.out.println(tabulador + "+-" + file.getName());
                }
		}
	}

}
