Algoritmo MediaNumeros
	
	//Declaración
	num, suma, cantidadNumeros Son Enteros
	media Es Real
	
	//Incialización
	suma <- 0
	cantidadNumeros <- 0
	
	//Lectura y procesamiento
	Escribir Sin Saltar "Introduce un número: "
	Leer num
	Mientras (num <> 0) Hacer
		suma <- suma + num
		cantidadNumeros <- cantidadNumeros + 1
		Escribir Sin Saltar "Introduce un número: "
		Leer num
	FinMientras
	media <- suma / cantidadNumeros
	
	//Escritura
	Escribir "La media de los números introducidos es: " media
	
FinAlgoritmo
