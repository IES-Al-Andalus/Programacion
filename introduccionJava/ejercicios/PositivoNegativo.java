import org.iesalandalus.programacion.utilidades.Entrada;

public class PositivoNegativo {
	
	public static void main(String[] args) {
		int numero;
		System.out.print("Introduce un número: ");
		numero = Entrada.entero();
		if (numero >= 0) {
			System.out.println("El número: " + numero + " es positivo");
		} else {
			System.out.println("El número: " + numero + " es negativo");
		}
	}

}
