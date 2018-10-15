import utilidades.Entrada;

public class SumaNumeros {

	public static void main(String[] args) {
		int numero, suma = 0;
		do {
			System.out.print("Introduce un número: ");
			numero = Entrada.entero();
			if (numero != 0) {
				suma += numero;
			}
		} while (numero != 0);
		System.out.println("La suma de los números introducidos es: " + suma);
	}

}
