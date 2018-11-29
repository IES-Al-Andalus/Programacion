package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilidades.Entrada;

public class CuentaVocales {

	private static final String ER_VOCALES = "[aeiouáéíóúü]";
	public static void main(String[] args) {
		String frase;
		Pattern patron;
		Matcher comparador;

		do {
			System.out.print("Introduce una frase: ");
			frase = Entrada.cadena();
		} while (frase.equals(""));
			
		patron = Pattern.compile(ER_VOCALES, Pattern.UNICODE_CASE + Pattern.CASE_INSENSITIVE);
		comparador = patron.matcher(frase);
		int numVocales = 0;
		while (comparador.find())
		{
			numVocales++;
		}
		
		System.out.printf("La frase contenía %d vocales.", numVocales);
	}

}
