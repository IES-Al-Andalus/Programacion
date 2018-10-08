Algoritmo NumPerfecto
	num, suma, i Son Enteros
	
	//Entrada y validación
	Repetir
		Escribir Sin Saltar 'Introduce un número entero mayor que cero: ' 
		Leer num
	Mientras Que (num < 1)
	
	//Procesamiento
	suma <- 0
	Para i <- 1 Hasta num - 1 Hacer
		Si (num MOD i = 0) Entonces
			suma <- suma + i
		FinSi
	FinPara
	
	//Salida
	Si (suma = num) Entonces
		Escribir 'El número ',num,' es perfecto'
	SiNo
		Escribir 'El número ',num,' NO es perfecto'
	FinSi
FinAlgoritmo

