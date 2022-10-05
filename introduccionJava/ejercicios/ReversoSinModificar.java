import org.iesalandalus.programacion.utilidades.Entrada;

public class ReversoSinModificar {

	public static void main(String[] args) {
		int numero, reverso = 0, posicionCifra = 0;
		do {
			System.out.print("Introduce un número mayor que cero: ");
			numero = Entrada.entero();
		} while (numero <= 0);
		while (numero / (int) Math.pow(10, posicionCifra) > 0) {
			reverso = reverso * 10 + numero / (int) Math.pow(10, posicionCifra) % 10;
			posicionCifra++;
		}
		System.out.println("El reverso de " + numero + " es: " + reverso);
	}

}
