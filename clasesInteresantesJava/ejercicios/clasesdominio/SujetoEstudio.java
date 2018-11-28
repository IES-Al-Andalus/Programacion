package clasesdominio;

public class SujetoEstudio {
	private String nombre;
	private double peso;
	private double altura;
	
	public SujetoEstudio(String nombre, double peso, double altura) {
		setNombre(nombre);
		setPeso(peso);
		setAltura(altura);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new IllegalArgumentException("El nombre de un sujeto no puede ser nulo.");
		}
		if (nombre.equals("")) {
			throw new IllegalArgumentException("El nombre de un sujeto no puede estar vacío.");
		}
		this.nombre = nombre;
	}
	
	public double getPeso() {
		return peso;
	}
	
	private void setPeso(double peso) {
		if (peso <= 0) {
			throw new IllegalArgumentException("El peso del sujeto debe ser mayor que cero");
		}
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}
	
	private void setAltura(double altura) {
		if (altura <= 0) {
			throw new IllegalArgumentException("La altura del sujeto debe ser mayor que cero");
		}
		this.altura = altura;
	}
	
	public double getIMC() {
		return peso / (altura*altura);
	}

}
