package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilidades.Entrada;

public class ReconoceDni {
	
	private static final String ER_DNI = "([0-9]{8})([A-Za-z])";

	public static void main(String[] args) {
		String dni;
		Pattern patron;
		Matcher emparejador;
		
		patron = Pattern.compile(ER_DNI);
		do {
			System.out.print("Introduce un DNI: ");
			dni = Entrada.cadena();
			emparejador = patron.matcher(dni);
		} while (!emparejador.matches());
		
		System.out.printf("Número: %s%n", emparejador.group(1));
		System.out.printf("Letra NIF: %s%n", emparejador.group(2));
	}

}
