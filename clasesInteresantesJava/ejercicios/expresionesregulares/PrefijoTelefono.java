package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilidades.Entrada;

public class PrefijoTelefono {

	private static final String ER_TELEFONO = "(?:\\+34 )?(?:(?:(9\\d{2}) \\d{6})|(?:(9\\d) \\d{7}))";
	
	public static void main(String[] args) {
		Pattern patron;
		Matcher comparador;
		
		patron = Pattern.compile(ER_TELEFONO);
		String telefono;
		do {
			System.out.print("Introduce un teléfono español valido \n"
					+ "(separa el prefijo nacional -lo puedes obviar-, el provincial o de capital y el teléfono por espacios): ");
			telefono = Entrada.cadena();
			comparador = patron.matcher(telefono);
		} while (!comparador.matches());

		String prefijo = (comparador.group(1)!=null) ? comparador.group(1) : comparador.group(2);
		String nombrePrefijo = (comparador.group(1)!=null) ? "provincia" : "capital";
		System.out.printf("Teléfono fijo español válido y el prefijo de %s es: %s%n", nombrePrefijo, prefijo);
	}

}
