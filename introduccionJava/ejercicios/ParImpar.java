import utilidades.Entrada;

public class ParImpar {
	
	public static void main(String[] args) {
		int numero;
		System.out.print("Introduce un número: ");
		numero = Entrada.entero();
		if (numero % 2 == 0) {
			System.out.println("El número: " + numero + " es par");
		} else {
			System.out.println("El número: " + numero + " es impar");
		}
	}

}
