package arrays;

import utilidades.Entrada;

public class LetraDni {

	private static final char[] LETRAS_DNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

	public static void main(String[] args) {
		int dni;
		do {
			System.out.print("Dime el número de tu DNI: ");
			dni = Entrada.entero();
		} while (dni < 1 || dni > 99999999);
		System.out.println("La letra de tu DNI es: " + LETRAS_DNI[dni % 23]);
	}

}
