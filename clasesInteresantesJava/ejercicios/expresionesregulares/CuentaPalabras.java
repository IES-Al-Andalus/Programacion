package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilidades.Entrada;

public class CuentaPalabras {

	public static final String ER_PALABRA = "[A-Za-záéíóúü]+";
	
	public static void main(String[] args) {
		String frase;
		Pattern patron;
		Matcher comparador;
		
		do {
			System.out.print("Introduce una frase: ");
			frase = Entrada.cadena();
		} while (frase.equals(""));
			
		patron = Pattern.compile(ER_PALABRA, Pattern.UNICODE_CASE + Pattern.CASE_INSENSITIVE);
		comparador = patron.matcher(frase);
		int numPalabras = 0;
		while (comparador.find())
		{
			System.out.println("Palabra encontrada:" + comparador.group());
			numPalabras++;
		}
		System.out.printf("La frase contenía %d palabras.", numPalabras);
	}

}
