package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilidades.Entrada;

public class CuentaVocales {

	private static final String ER_VOCALES = "[aeiouáéíúüÁÉÍÓÚÜ]";
	public static void main(String[] args) {
		String frase;
		Pattern patron;
		Matcher emparejador;

		do {
			System.out.print("Introduce una frase: ");
			frase = Entrada.cadena();
		} while (frase.equals(""));
			
		patron = Pattern.compile(ER_VOCALES, Pattern.CASE_INSENSITIVE);
		emparejador = patron.matcher(frase);
		int numVocales = 0;
		while (emparejador.find())
		{
			numVocales++;
		}
		
		System.out.printf("La frase contenía %d vocales.", numVocales);
	}

}
