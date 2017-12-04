Algoritmo AprobadoSuspenso
	
	//Declaración
	nota Es Real
	calificacion Es Caracter
	
	//Lectura
	Escribir Sin Saltar "Introduce tu nota: "
	Leer nota
	
	//Procesamiento
	Si (nota >= 5) Entonces
		calificacion = "aprobado"
	SiNo
		calificacion = "suspenso"
	FinSi
	
	//Escritura
	Escribir "Estás " calificacion
	
FinAlgoritmo
