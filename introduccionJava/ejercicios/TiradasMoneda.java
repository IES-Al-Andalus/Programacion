import utilidades.Entrada;

public class TiradasMoneda {
    
	public static void main(String[] args) {

		int moneda1, moneda2;
		int contadorCaras = 0, contadorCruces = 0, numTiradas;
		int contadorCarasDoblesConsecutivas = 0, contadorCrucesDoblesConsecutivas = 0;
		int maximoCarasDoblesConsecutivas = 0, maximoCrucesDoblesConsecutivas = 0;
		boolean esCruzDoble = false, esCaraDoble = false;

		do {
			System.out.print("Introduce el número de veces que se van a lanzar las monedas (max 50): ");
			numTiradas = Entrada.entero();
		} while (numTiradas < 1 || numTiradas > 50);

		for (int i = 0; i < numTiradas; i++) {
			moneda1 = (int) (Math.random() * 2);
			moneda2 = (int) (Math.random() * 2);
			System.out.println("Moneda 1: " + moneda1 + ", Moneda 2: " + moneda2);
			if (moneda1 == 0) {
				contadorCaras++;
			} else {
				contadorCruces++;
			}
			if (moneda2 == 0) {
				contadorCaras++;
			} else {
				contadorCruces++;
			}

			if (moneda1 == moneda2) {
				if (moneda1 == 0) {
					esCaraDoble = true;
					esCruzDoble = false;
				} else {
					esCaraDoble = false;
					esCruzDoble = true;
				}
			} else {
				esCaraDoble = false;
				esCruzDoble = false;
			}

			if (esCaraDoble) {
				contadorCarasDoblesConsecutivas++;
				if (contadorCarasDoblesConsecutivas > maximoCarasDoblesConsecutivas) {
					maximoCarasDoblesConsecutivas = contadorCarasDoblesConsecutivas;
				}
			} else {
				contadorCarasDoblesConsecutivas = 0;
			}

			if (esCruzDoble) {
				contadorCrucesDoblesConsecutivas++;
				if (contadorCrucesDoblesConsecutivas > maximoCrucesDoblesConsecutivas) {
					maximoCrucesDoblesConsecutivas = contadorCrucesDoblesConsecutivas;
				}
			} else {
				contadorCrucesDoblesConsecutivas = 0;
			}
		}

		System.out.println("Caras: " + contadorCaras + ", Cruces: " + contadorCruces);
		System.out.println("Maximo de caras sobles consecutivas: " + maximoCarasDoblesConsecutivas);
		System.out.println("Maximo de cruces dobles consecutivas: " + maximoCrucesDoblesConsecutivas);
	}
}
