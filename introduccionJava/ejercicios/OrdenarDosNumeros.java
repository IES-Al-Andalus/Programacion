import utilidades.Entrada;

public class OrdenarDosNumeros {
	
	public static void main(String[] args) {
		float numero1, numero2;
		System.out.print("Introduce el primer número: ");
		numero1 = Entrada.real();
		System.out.print("Introduce el segundo número: ");
		numero2 = Entrada.real();
		if (numero1 >= numero2) {
			System.out.println("Los números ordenados de mayor a menor: " + numero1 + ", " + numero2);
		} else {
			System.out.println("Los números ordenados de mayor a menor: " + numero2 + ", " + numero1);
		}
	}

}