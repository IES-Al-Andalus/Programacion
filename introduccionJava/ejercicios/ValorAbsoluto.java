import org.iesalandalus.programacion.utilidades.Entrada;

public class ValorAbsoluto {
	
	public static void main(String[] args) {
		int numero;
		System.out.print("Introduce un número: ");
		numero = Entrada.entero();
		int valorAbsoluto;
		valorAbsoluto = (numero < 0) ? -numero : numero;
		System.out.println("El valor absoluto de: " + numero + " es: " + valorAbsoluto);
	}

}
