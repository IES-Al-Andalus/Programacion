import org.iesalandalus.programacion.utilidades.Entrada;

public class NumeroPerfecto {

	public static void main(String[] args) {
		int numero, suma = 0;
		do {
			System.out.print("Introduce un número: ");
			numero = Entrada.entero();
		} while (numero <= 0);
		for (int i = 1; i < numero; i++) {
			if (numero % i == 0) {
				suma += i;
			}
		}
		String mensaje = (suma == numero) ? " SÍ" : " NO";
		System.out.println("El número: " + numero + mensaje + " es perfecto.");
	}

}
