import org.iesalandalus.programacion.utilidades.Entrada;

public class NumerosIguales {
	
	public static void main(String[] args) {
		int numero1, numero2;
		System.out.print("Introduce el primer número: ");
		numero1 = Entrada.entero();
		System.out.print("Introduce el segundo número: ");
		numero2 = Entrada.entero();
		if (numero1 == numero2) {
			System.out.println("Los números introducidos son iguales.");
		} else {
			System.out.println("Los números introducidos no son iguales.");
		}
	}

}
