import org.iesalandalus.programacion.utilidades.Entrada;

public class MediaNumeros {

	public static void main(String[] args) {
		int numero, suma = 0, cantidadNumeros = 0;
		do {
			System.out.print("Introduce un número: ");
			numero = Entrada.entero();
			if (numero != 0) {
				suma += numero;
				cantidadNumeros++;
			}
		} while (numero != 0);
		if (cantidadNumeros < 0) {
			System.out.println("La media de los números introducidos es: " + (float)suma / cantidadNumeros);
		}
	}

}
