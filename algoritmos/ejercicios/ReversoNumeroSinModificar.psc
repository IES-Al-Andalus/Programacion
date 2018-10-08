Algoritmo ReversoNumeroSinModificar
	num, reves, posicion Son Enteros
	
	//Lectura y validación
	Repetir
		Escribir Sin Saltar "Introduce un número entero mayor que cero: "
		Leer num
	Mientras Que (num <= 0)
	
	reves <- 0
	posicion <- 0
	
	//Procesamiento
	Mientras (trunc(num / 10 ^ posicion) > 0)
		reves <- reves * 10 + trunc(num / 10 ^ posicion) MOD 10
		posicion <- posicion + 1
	FinMientras
	
	//Salida
	Escribir "El reverso de : " num " es: " reves
	
FinAlgoritmo
