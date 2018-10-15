import utilidades.Entrada;

public class AreaCirculo {

	public static void main(String[] args) {
		double radio;
		System.out.print("Introduce el radio del círculo: ");
		radio = Entrada.realDoble();
		double area = Math.PI * radio * radio;
		System.out.println("El área del círculo es: " + area);
	}

}
