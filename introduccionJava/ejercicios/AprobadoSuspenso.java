import utilidades.Entrada;

public class AprobadoSuspenso {
	
	public static void main(String[] args) {
		float calificacion;
		System.out.print("Introduce una calificación: ");
		calificacion = Entrada.real();
		if (calificacion < 0 || calificacion > 10) {
			System.out.println("La calificación introducida no es una calificación correcta.");
		} else if (calificacion >= 5) {
			System.out.println("Enhorabuena!!! Estás aprobado.");
		} else {
			System.out.println("Lo siento, pero estás suspenso.");
		}
	}

}