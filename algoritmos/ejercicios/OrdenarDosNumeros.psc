Algoritmo OrdenarDosNumeros
	
	//Declaración
	num1, num2 Son Enteros
	
	//Lectura
	Escribir Sin Saltar "Introduce un número: "
	Leer num1
	Escribir Sin Saltar "Introduce otro número: "
	Leer num2
	
	//Procesamiento y escritura
	Si (num1 < num2) Entonces
		Escribir "Ordenados de menor a mayor serían: " num1 ", " num2
	SiNo
		Escribir "Ordenados de menor a mayor serían: " num2 ", " num1
	FinSi
	
FinAlgoritmo
