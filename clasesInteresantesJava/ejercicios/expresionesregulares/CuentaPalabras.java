package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilidades.Entrada;

public class CuentaPalabras {

	public static final String ER_PALABRA = "[A-Za-zÁÉÍÓÚáéíóúüÜ]+";
	
	public static void main(String[] args) {
		String frase;
		Pattern patron;
		Matcher emparejador;
		
		do {
			System.out.print("Introduce una frase: ");
			frase = Entrada.cadena();
		} while (frase.equals(""));
			
		patron = Pattern.compile(ER_PALABRA);
		emparejador = patron.matcher(frase);
		int numPalabras = 0;
		while (emparejador.find())
		{
			System.out.println("Palabra encontrada:" + emparejador.group());
			numPalabras++;
		}
		System.out.printf("La frase contenía %d palabras.", numPalabras);
	}

}
