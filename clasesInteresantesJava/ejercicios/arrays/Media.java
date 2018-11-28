package arrays;

import utilidades.Entrada;

public class Media {

	public static void main(String[] args) {
		int cantidadNumeros;
		do {
			System.out.print("Introduce la cantidad de números a generar: ");
			cantidadNumeros = Entrada.entero();
		} while (cantidadNumeros < 3);
		int[] numeros =  new int[cantidadNumeros];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 100);
		}
		int suma = 0;
		for (int i = 0; i < numeros.length; i++) {
			suma += numeros[i]; 
		}
		int media = suma / cantidadNumeros;
		int encimaMedia = 0;
		int debajoMedia = 0;
		int igualesMedia = 0;
		StringBuilder posicionesIgualesMedia = new StringBuilder();
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > media)
				encimaMedia++;
			else if (numeros[i] < media)
				debajoMedia++;
			else {
				igualesMedia++;
				posicionesIgualesMedia.append(posicionesIgualesMedia.toString().equals("") ? "" : ", ");
				posicionesIgualesMedia.append(i);
			}
		}
		System.out.printf("La media de todos los números es: %d%n", media);
		System.out.printf("Hay %d números por encima.%n", encimaMedia);
		System.out.printf("Hay %d números por debajo.%n", debajoMedia);
		System.out.printf("Hay %d números iguales.%n", igualesMedia);
		if (posicionesIgualesMedia.length() > 0) {
			System.out.printf("Las posiciones que ocupaban los elementos iguales era: %s", posicionesIgualesMedia);
		}
	}

}
