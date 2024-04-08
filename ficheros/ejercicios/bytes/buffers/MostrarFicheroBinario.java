package org.iesalandalus.programacion.ficheros.secuencial.bytes.buffers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MostrarFicheroBinario {

	public static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioPeque.bin");
    
	public static void main(String[] args) {
		try (BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(FICHERO))){
			mostrarFichero(entrada);
		} catch (FileNotFoundException e) {
			System.out.println("No se puede leer el fichero de entrada");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida");
		}
	}

	private static void mostrarFichero(BufferedInputStream entrada) throws IOException {
		int numBytes = 0;
		int desplazamiento = 0;
		StringBuilder lineaHexa = new StringBuilder();
		StringBuilder lineaChar = new StringBuilder();
		byte[] linea = new byte[16];
		while ((numBytes = entrada.read(linea)) != -1) {
			for (int i = 0; i < 16; i++) {
				if (i == 8)
					lineaHexa.append(" ");
				if (numBytes > i) {
					lineaHexa.append(String.format("%02x ", linea[i]));
					lineaChar.append((32 <= linea[i] && 126 >= linea[i]) ? (char)linea[i] : ".");
				} else {
					lineaHexa.append("   ");
					lineaChar.append(" ");
				}
			}
			System.out.printf("%08x %-48s |%-16s|%n",  desplazamiento, lineaHexa, lineaChar);
			desplazamiento += 16;
			lineaHexa.delete(0, lineaHexa.capacity());
			lineaChar.delete(0, lineaChar.capacity());
		}
	}

}
