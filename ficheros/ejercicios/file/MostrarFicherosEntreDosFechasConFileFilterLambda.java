package org.iesalandalus.programacion.ficheros.file;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MostrarFicherosEntreDosFechasConFileFilterLambda {
	
	private static final String STR_FORMATO_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(STR_FORMATO_FECHA);
	private static final String NOMBRE_CARPETA = ".";

	public static void main(String[] args) {
		
		LocalDate fechaInicio = leerFecha(String.format("Introduce la fecha de inicio (%s): ", STR_FORMATO_FECHA));
		LocalDate fechaFin = leerFecha(String.format("Introduce la fecha de fin (%s): ", STR_FORMATO_FECHA));

		File carpeta = new File(NOMBRE_CARPETA);
		File[] contenido = carpeta.listFiles(fichero -> {
			LocalDate fechaFichero = getUltimaModificacion(fichero);
			return (fichero.isFile() && !fechaFichero.isBefore(fechaInicio) && !fechaFichero.isAfter(fechaFin));
		});
		
		if (contenido != null) {
			for (File fichero : contenido) {
				System.out.printf("%s: %s%n", fichero.getName(), 
						getUltimaModificacion(fichero).format(FORMATO_FECHA));
			}
		}
	}

	private static LocalDate getUltimaModificacion(File fichero) {
		return new Timestamp(fichero.lastModified()).toLocalDateTime().toLocalDate();
	}

	private static LocalDate leerFecha(String mensaje) {
		LocalDate fecha = null;
		boolean fechaValida;
		do {
            try {
                System.out.printf("%s", mensaje);
                fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
                fechaValida = true;
            } catch (DateTimeParseException e) {
                fechaValida = false;
            }

        } while(!fechaValida);
		return fecha;
	}
}
