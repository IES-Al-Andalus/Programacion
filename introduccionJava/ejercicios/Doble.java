import utilidades.Entrada;

public class Doble {

	public static void main(String[] args) {
		float numero;
		System.out.print("Introduce un número real: ");
		numero = Entrada.real();
		System.out.println("El doble del número: " + numero + " es: " + 2 * numero);
	}

}
