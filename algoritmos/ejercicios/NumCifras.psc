Algoritmo NumCifras
	
	num, cifras Son Enteros
	
	//Entrada y validación
	Repetir
		Escribir Sin Saltar "Introduce un número entero mayor que cero: "
		Leer num
	Mientras Que (num <= 0)
	
	cifras <- 0
	
	//Procesamiento
	Mientras (num > 0)
		num <- trunc(num/10)
		cifras <- cifras + 1
	FinMientras
	
	//Salida
	Escribir "El número tenía " cifras " cifras"
	
FinAlgoritmo
