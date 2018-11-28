package arrays;

import utilidades.Entrada;

public class MayorMenor {

	public static void main(String[] args) {
		int cantidadNumeros;
		do {
			System.out.print("Inroduce la cantidad de números a generar: ");
			cantidadNumeros = Entrada.entero();
		} while (cantidadNumeros < 2);
		int[] numeros = new int[cantidadNumeros];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 1000);
		}
		int mayor = 0;
		int menor = 1000;
		int posMayor = -1;
		int posMenor = -1;
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
				posMayor = i;
			}
			if (numeros[i] < menor) {
				menor = numeros[i];
				posMenor = i;
			}
		}
		System.out.printf("El número mayor es: %d y ocupa la posición: %d%n", mayor, posMayor);
		System.out.printf("El número menor es: %d y ocupa la posición: %d%n", menor, posMenor);
	}

}
