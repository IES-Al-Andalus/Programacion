import utilidades.Entrada;

public class DescomponerCifrasReverso {

	public static void main(String[] args) {
		int numero;
		do {
			System.out.print("Introduce un número mayor que cero: ");
			numero = Entrada.entero();
		} while (numero <= 0);
		while (numero > 0) {
			System.out.println(numero % 10);
			numero /= 10;
		}
	}

}
