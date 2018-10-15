import utilidades.Entrada;

public class NumeroPositivo {
	
	public static void main(String[] args) {
		int numero;
		do {
			System.out.print("Introduce un número positivo: ");
			numero = Entrada.entero();
		} while (numero < 0);
		System.out.println("El número positivo introducido es: " + numero);
	}

}
