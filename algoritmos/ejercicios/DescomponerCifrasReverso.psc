Algoritmo DescomponerCifrasReverso
	num, pos Es Entero
	
	//Lectura y validación
	Repetir
		Escribir Sin Saltar "Introduce un número entero mayor que cero: "
		Leer num
	Mientras Que (num <= 0)
	
	pos <- 0
	
	//Procesamiento y salida
	Mientras (num > 0)
		Escribir "El dígito que ocupa la posición " pos " es " num MOD 10
		pos <- pos + 1
		num <- trunc(num/10)
	FinMientras
	
FinAlgoritmo
