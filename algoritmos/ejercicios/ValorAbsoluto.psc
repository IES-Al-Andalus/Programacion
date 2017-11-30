Algoritmo ValorAbsoluto
	
	//Declaración
	num, valorAbs Son Enteros
	
	//Lectura
	Escribir Sin Saltar "Introduce un número: "
	Leer num
	
	//Procesamiento
	valorAbs <- num
	Si (num < 0) Entonces
		valorAbs <- -1 * num
	FinSi
	
	//Salida
	Escribir "El valor absoluto de " num " es: " valorAbs
	
FinAlgoritmo
