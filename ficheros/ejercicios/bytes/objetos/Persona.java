package org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {
	
	private String nombre;
	private int edad;

	public Persona(String nombre, int edad) {
		setNombre(nombre);
		setEdad(edad);
	}

	public void setNombre(String nombre) {
		this.nombre = Objects.requireNonNull(nombre, "El nombre de una persona no puede ser nulo.");
		if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre de una persona no puede estar vacío.");
		}
	}

	public void setEdad(int edad) {
		if (edad <= 0) {
			throw new IllegalArgumentException("La edad de una persona no puede ser menor o igual a cero.");
		}
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Persona persona)) return false;
		return Objects.equals(nombre, persona.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public String toString() {
		return String.format("Persona [nombre=%s, edad=%s]", nombre, edad);
	}
	
}
