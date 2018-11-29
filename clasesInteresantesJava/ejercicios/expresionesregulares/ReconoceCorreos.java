package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReconoceCorreos {

	private static final String ER_CORREO = "\\w+[\\.\\w]*@\\w+[\\.\\w]*\\.\\w{2,5}\\b\\s?";
	
	public static void main(String[] args) {
		Pattern patron;
		Matcher comparador;
		
		String posiblesCorreos = "Hola@mundo.ab miCorreo@gmail.com.mialias correoFalso95@yahoo.es "
				+ "jose.ramon@midominio.com JoSeRaMoN@miAarroba jose.ramon@kk.com";

		patron = Pattern.compile(ER_CORREO);
		comparador = patron.matcher(posiblesCorreos);

		while (comparador.find()) {
			System.out.printf("Correo reconocido: %s%n", comparador.group());
		}
	}

}
