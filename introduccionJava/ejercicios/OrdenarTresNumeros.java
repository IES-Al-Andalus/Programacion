import utilidades.Entrada;

public class OrdenarTresNumeros {
	
	public static void main(String[] args) {
		float numero1, numero2, numero3, mayor, medio, menor;
		System.out.print("Introduce el primer número: ");
		numero1 = Entrada.real();
		System.out.print("Introduce el segundo número: ");
		numero2 = Entrada.real();
		System.out.print("Introduce el tercer número: ");
		numero3 = Entrada.real();
		if (numero1 >= numero2 && numero2 >= numero3) {
			mayor = numero1;
			medio = numero2;
			menor = numero3;
		} else if (numero1 >= numero3 && numero3 >= numero2){
			mayor = numero1;
			medio = numero3;
			menor = numero2;
		} else if (numero2 >= numero1 && numero1 >= numero3) {
			mayor = numero2;
			medio = numero1;
			menor = numero3;
		} else if (numero2 >= numero3 && numero3 >= numero1) {
			mayor = numero2;
			medio = numero3;
			menor = numero1;
		} else if (numero3 >= numero1 && numero1 >= numero2) {
			mayor = numero3;
			medio = numero1;
			menor = numero2;
		} else {
			mayor = numero3;
			medio = numero2;
			menor = numero1;
		}
		System.out.println("Los números ordenados de mayora a menor: " + mayor + ", " + medio + ", " + menor);
	}

}