import utilidades.Entrada;

public class PerimetroRectangulo {

	public static void main(String[] args) {
		float base, altura;
		System.out.print("Introduce la base del rectángulo: ");
		base = Entrada.real();
		System.out.print("Introduce la altura del rectángulo: ");
		altura = Entrada.real();
		float perimetro = 2 * base + 2 * altura;
		System.out.println("El perímetro del rectángulo es: " + perimetro);
	}

}
