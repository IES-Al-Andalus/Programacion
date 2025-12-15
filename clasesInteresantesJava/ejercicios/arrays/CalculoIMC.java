package arrays;

import clasesdominio.SujetoEstudio;
import utilidades.Entrada;

public class CalculoIMC {

	public static void main(String[] args) {

		double maximoImc = 0;
		double minimoImc = Double.MAX_VALUE;
		double sumaImcs = 0;
		double mediaImcs;
		int posicionMinimoImc = 0;
		int posicionMaximoImc = 0;
		int sujetosPorEncimaMedia = 0;
		int sujetosPorDebajoMedia = 0;
		
		int cantidadSujetos;
		do {
			System.out.print("Introduce la cantidad de sujetos a estudiar: ");
			cantidadSujetos = Entrada.entero();
		} while (cantidadSujetos < 3);
		
		SujetoEstudio[] sujetos = new SujetoEstudio[cantidadSujetos];

		for (int i = 0; i < cantidadSujetos; i++) {
			sujetos[i] = leerSujeto(i + 1);
			double imc = sujetos[i].getIMC();
			if (imc < minimoImc) {
				minimoImc = imc;
				posicionMinimoImc = i;
			}
			if (imc > maximoImc) {
				maximoImc = imc;
				posicionMaximoImc = i;
			}
			sumaImcs += imc;
		}
		mediaImcs = sumaImcs / cantidadSujetos;

        for (SujetoEstudio sujeto : sujetos) {
            double imc = sujeto.getIMC();
            if (imc < mediaImcs) sujetosPorEncimaMedia++;
            if (imc > mediaImcs) sujetosPorDebajoMedia++;
        }
		
		System.out.printf("%nResultados del estudio%n");
		System.out.printf("----------------------%n");
		System.out.printf("El sujeto con mayor IMC es: %s%n", sujetos[posicionMaximoImc].getNombre());
		System.out.printf("El sujeto con menor IMC es: %s%n", sujetos[posicionMinimoImc].getNombre());
		System.out.printf("La media de IMCs es: %f%n", mediaImcs);
		System.out.printf("Hay %d sujetos por encima de la media.%n", sujetosPorEncimaMedia);
		System.out.printf("Hay %d sujetos por debajo de la media.%n", sujetosPorDebajoMedia);
	}
	
	private static SujetoEstudio leerSujeto(int numero) {
		String nombre;
		do {
			System.out.printf("Introduce el nombre del sujeto n.º %d: ", numero);
			nombre = Entrada.cadena();
		} while (nombre.equals(""));
		double peso;
		do {
			System.out.printf("Introduce el peso en kg. del sujeto n.º %d: ", numero);
			peso = Entrada.realDoble();
		} while (peso <= 0);
		double altura;
		do {
			System.out.printf("Introduce la altura en cm. del sujeto n.º %d: ", numero);
			altura = Entrada.realDoble();
		} while (altura <= 0);
		return new SujetoEstudio(nombre, peso, altura);
	}

}
