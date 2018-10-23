import utilidades.Entrada;

public class Reverso {

	public static void main(String[] args) {
		int numero, reverso = 0;
		do {
			System.out.print("Introduce un número entero: ");
			numero = Entrada.entero();
		} while (numero <= 0);
		while (numero > 0) {
			reverso = reverso * 10 + numero % 10;
			numero /= 10;
		}
		System.out.println("El reverso es: " + reverso);
	}

}
