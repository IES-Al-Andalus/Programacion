package expresionesregulares;

import utilidades.Entrada;

public class ValidaTelefono {
	
	private static final String ER_TELEFONO = "[96]?[0-9]{8}";

	public static void main(String[] args) {
		String telefono;

		do {
			System.out.print("Introduce un telefono: ");
			telefono = Entrada.cadena();
		} while (!telefono.matches(ER_TELEFONO));
		
		System.out.printf("Teléfono válido: %s%n", telefono);
	}

}
