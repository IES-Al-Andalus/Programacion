import utilidades.Entrada;

public class CeroCien {
	
	public static void main(String[] args) {
		float numero;
		System.out.print("Introduce un número: ");
		numero = Entrada.real();
		if (numero >= 0 && numero <= 100) {
			System.out.println("El número: " + numero + " está comprendido entre 0 y 100");
		} else {
			System.out.println("El número: " + numero + " no está comprendido entre 0 y 100");
		}
	}

}
