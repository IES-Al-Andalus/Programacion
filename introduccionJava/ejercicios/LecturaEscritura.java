import org.iesalandalus.programacion.utilidades.Entrada;

public class LecturaEscritura {
	
	public static void main(String[] args) {
		int numero;
		System.out.print("Introduce un número: ");
		numero = Entrada.entero();
		System.out.println("El número introducido es: " + numero);
	}

}
