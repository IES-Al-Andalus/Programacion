Algoritmo ContarVocales
	
	frase, vocales Son Caracter
	i, j, numVocales Son Entero
	
	// Entrada
	Escribir Sin Saltar "Introduce una frase: "
	Leer frase
	
	// Procesamiento
	frase <- Minusculas(frase)
	vocales <- "aeiouáéíóúü"
	numVocales <- 0
	
	Para i<-0 Hasta Longitud(frase) - 1 Hacer
		Para j<-0 Hasta Longitud(vocales) - 1 Hacer
			Si Subcadena(frase, i, i) = Subcadena(vocales, j, j) Entonces
				numVocales <- numVocales + 1
			FinSi
		FinPara
	FinPara
	
	// Salida
	Escribir 'La frase intrducida, pasada a minúsculas es: ' frase
	Escribir 'Dicha frase contiene ' numVocales ' vocales.'
	
FinAlgoritmo

