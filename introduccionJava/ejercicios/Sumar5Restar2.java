import org.iesalandalus.programacion.utilidades.Entrada;

public class Sumar5Restar2 {
	public static void main(String[] args) {
		int numero1, numero2, aux;
		do {
			System.out.print("Introduce el primer numero entre 0 y 50: ");
			numero1 = Entrada.entero();
		} while (numero1 < 0 || numero1 > 50);
		do {
			System.out.print("Introduce el segundo número entre 0 y 50: ");
			numero2 = Entrada.entero();
		} while (numero2 < 0 || numero2 > 50);
		if (numero1 > numero2) {
			aux = numero1;
			numero1 = numero2;
			numero2 = aux;
		}
		while (numero1 < numero2) {
			System.out.println("N1: " + numero1 + ", N2: " + numero2);
			numero1 += 5;
			numero2 -= 2;
		}
	}
}
