Algoritmo OrdenarTresNumeros
	
	//Declaración
	num1, num2, num3 Son Enteros
	
	//Lectura
	Escribir Sin Saltar "Introduce el primer número: "
	Leer num1
	Escribir Sin Saltar "Introduce el segundo número: "
	Leer num2
	Escribir Sin Saltar "Introduce el tercer número: "
	Leer num3
	
	//Procesamiento y escritura
	Si (num1 < num2 Y num2 < num3) Entonces
		Escribir "Ordenados de menor a mayor serían: " num1 ", " num2 ", " num3
	SiNo
		Si (num1 < num3 Y num3 < num2) Entonces
			Escribir "Ordenados de menos a mayor serían: " num1 ", " num3 ", " num2
		SiNo
			Si (num2 < num1 Y num1 < num3) Entonces
				Escribir "Ordenados de menos a mayor serían: " num2 ", " num1 ", " num3
			SiNo
				Si (num2 < num3 Y num3 < num1) Entonces
					Escribir "Ordenados de menos a mayor serían: " num2 ", " num3 ", " num1
				SiNo
					Si (num3 < num1 Y num1 < num2) Entonces
						Escribir "Ordenados de menos a mayor serían: " num3 ", " num1 ", " num2
					SiNo
						Escribir "Ordenados de menos a mayor serían: " num3 ", " num2 ", " num1
					FinSi
				FinSi
			FinSi
		FinSi
	FinSi
	
FinAlgoritmo
