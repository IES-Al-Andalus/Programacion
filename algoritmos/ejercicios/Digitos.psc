Algoritmo Digitos
	num, numCifras, i, digito es entero
	
	Repetir 
		Escribir Sin Saltar "Dime un n�mero mayor que cero: "
		Leer num
	Mientras que (num <= 0)
	
	numCifras <- trunc(ln(num) / ln(10)) + 1
	Escribir "El n�mero de cifras de ", num, " es ", numCifras
	Escribir "-----------------------"
	
	Escribir "D�gitos de derecha a izquierda"
	Para i <- 0 hasta numCifras - 1 Hacer
		digito <- trunc(num / 10 ^ i) % 10
		Escribir digito
	FinPara
	Escribir "-----------------------"
	
	Escribir "D�gitos de izquierda a derecha"
	Para i <- numCifras - 1 hasta 0 Con Paso -1 Hacer
		digito <- trunc(num / 10 ^ i) % 10
		Escribir digito	
	FinPara
FinAlgoritmo
