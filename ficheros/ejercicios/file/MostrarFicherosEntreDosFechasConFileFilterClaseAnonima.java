package org.iesalandalus.programacion.ficheros.file;

import java.io.File;
import java.io.FileFilter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MostrarFicherosEntreDosFechasConFileFilterClaseAnonima {
	
	private static final String STR_FORMATO_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(STR_FORMATO_FECHA);
	private static final String NOMBRE_CARPETA = ".";

	public static void main(String[] args) {
		
		LocalDate fechaInicio = leerFecha(String.format("Introduce la fecha de inicio (%s): ", STR_FORMATO_FECHA));
		LocalDate fechaFin = leerFecha(String.format("Introduce la fecha de fin (%s): ", STR_FORMATO_FECHA));

		File carpeta = new File(NOMBRE_CARPETA);
		File[] contenido = carpeta.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File fichero) {
				LocalDate fechaFichero = new Timestamp(fichero.lastModified()).toLocalDateTime().toLocalDate();
				return (fichero.isFile() && !fechaFichero.isBefore(fechaInicio)	&& !fechaFichero.isAfter(fechaFin));
			}

		});
		
		if (contenido != null) {
			for (File fichero : contenido) {
				System.out.printf("%s: %s%n", fichero.getName(), 
						new Timestamp(fichero.lastModified()).toLocalDateTime().toLocalDate().format(FORMATO_FECHA));
			}
		}
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
