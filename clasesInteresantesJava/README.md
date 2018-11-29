# Algunas clases interesantes en Java

En este apartado encontrarás una breve descripción sobre algunas clases interesantes en Java y cuya utilización te será de gran ayuda. Es esencial que conozcas estas clases y que domines su utilización.

Al igual que en otros apartados, el objetivo principal es que tengáis una amplía gama de ejercicios, con sus respectivas posibles soluciones.

**José Ramón Jiménez Reyes**

 > ![@JRJimenezReyes](../assets/images/github.png) @JRJimenezReyes

 > ![joseramon.jimenez@iesalandalus.org](../assets/images/mail.png) joseramon.jimenez@iesalandalus.org

### Contenidos
---
- [Arrays](#arrays)
- [Cadenas de caracteres](#cadenas-de-caracteres)
- [Expresiones regulares](#expresiones-regulares)
- [Fechas y horas](#fechas-y-horas)
- [Ejercicios](#ejercicios)

## Arrays

Un array en java no es más que una estructura de memoria capaz de almacenar objetos (llamados elementos cuando hablamos de arrays) del mismo tipo. Un array en sí es un objeto. A los elementos almacenados en un array se puede acceder mediante un índice que indica el desplazamiento desde el comienzo de dicho array. A la hora de crear un array se establece la longitud del mismo y ésta no se puede cambiar.

<div align="center">
<img alt="Array" src="imagenes/array.png"/>
</div>

Como he comentado, un array es un objeto en java. Por tanto, primero deberemos declarar una referencia a dicho array, después crear el array y posteriormente inicializar su contenido. Veamos cómo se lleva a cabo cada una de estas operaciones.

Para **declarar** una referencia a un array utilizaremos la siguiente nomenclatura: `tipo[] nombre`, donde `tipo` puede ser un tipo primitivo, una clase de la API de java o una clase definida por nosotros mismos. Los corchetes indican que estamos declarando un array. Y `nombre` será el identificador que le damos a nuestra referencia al array.

~~~java
	int[] miArray;
~~~

Con esto habremos declarado la referencia al array identificada por `miArray`. Pero, al igual que ocurría con los objetos, ahora mismo esa referencia es `null`. Por lo que deberemos crear el array y asignarlo a dicho identificador, para que la referencia apunte al array recién creado. Para **crear** el array se utiliza el operador `new` seguido por el tipo de objetos que va almacenar el array y entre corchetes la longitud que queremos asignar a dicho array. La longitud puede ser un valor constante o un valor calculado en tiempo de ejecución.

~~~java
	miArray = new int[15];
~~~

Ahora que ya tenemos creado el array deberemos **inicializar** su contenido. En un array recién creado, todos sus elementos tendrán los valores por defecto del tipo que almacena (en el ejemplo estará todo a 0 que es el valor por defecto para los enteros).

Para poder darle los valores deseados a cada uno de los elementos del array, deberemos acceder a cada elemento en particular y asignarle un valor. Para ello utilizaremos el identificador del array y entre corchetes el índice del elemento al que queremos acceder. Notar que el **primer índice de un array es el 0**.

~~~java
	miArray[0] = 2;
	miArray[1] = 4;
	miArray[2] = 6;
	System.out.println(miArray[2]);	//Muestra 6
	System.out.println(miArray[3]);	//Muestra 0 ya que aún no le hemos asignado ningún valor
~~~

Existe una sintaxis abreviada que nos permite declarar, crear e inicializar un array en una sola sentencia:

~~~java
	int[] miArray = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 };
~~~

En este caso la longitud del array se determina por el número de elementos específicados entre las llaves.

Los arrays, al tratarse de objetos, tienen algunos miembros que podemos utilizar. Uno de los más utilizados es el atributo `length` que nos devuelve la longitud de dicho array.

Para **recorrer** un array podemos utilizar un bucle. Es muy importante que controlemos que no nos salimos de los límites del array, tanto por abajo como por arriba (`0` ... `length - 1`), o de lo contrario nos saltará una excepción en tiempo de ejecución indicando que nos hemos salido de los límites del array (`IndexOutOfBoundsException`).

~~~java
	...
	for (int i = 0; i < miArray.length; i++) {
		System.out.println("Elemento en el índice: " + i + ", valor: " + miArray[i]);
	}
~~~

Pero java define otro tipo de bucles, que no habíamos comentado, que permite recorrer colecciones de objetos, entre ellas arrays, de una forma más cómoda y sencilla. Este tipo de bucles son los llamados `foreach`. La estructura de este array es la siguiente: `for (tipoBase identificador: coleccionTipoBase)`. `tipoBase` sería el tipo que almacena la colección, en este caso el array, `identificador` sería un identificador de dicho tipo y `coleccionTipoBase` sería la colección, en este caso array, a recorrer. Este tipo de bucle recorre la colección, en este caso el array, desde el principio al final y en cada iteración asigna el valor del elemento de la colección a la variable `identificador`.

~~~java
	int indice = 0;
	for (int elemento : miArray) {
		System.out.println("Elemento en el índice: " + indice++ + ", valor: " + elemento);
	}
~~~

###### Arrays multidimensionales

Los arrays multidimensionales son arrays de varias dimensiones, aunque pasar de tres dimensiones es complicado ya que su uso no es nada intuitivo.

Lo más normal es la utilización de arrays de dos dimensiones, también llamados matrices. Son arrays de arrays. Para declararlos utilizaremos tantos corchetes como dimensiones queramos declarar.

~~~java
	char[][] crucigrama;
~~~

Al igual que ocurría con los arrays unidimensionales de objetos, una vez declarada la referencia hay que crear los diferentes elementos del array que en este caso también son arrays. Esto podemos hacerlo directamente con el operador `new`.
~~~java
	crucigrama = new char[5][5];
~~~

<div align="center">
<img alt="Array multidimensional" src="imagenes/crucigrama.png"/>
</div>

La forma de representación anterior no sería la más correcta, ya que en verdad, en java un array multidimensional es un array de arrays, por lo que la representación correcta sería la siguiente (aunque por simplicidad utilizaremos la anterior).

<div align="center">
<img alt="Array multidimensional" src="imagenes/crucigrama1.png"/>
</div>

También es posible que un array multidimensional tuviese diferentes dimensiones en cada una de las posiciones;

~~~java
	int[][] escalon;
	escalon = new char[5][];
	for (int i = 0; i < escalon.length; i++) {
		escalon[i] = new int[i+1];
	}
~~~

<div align="center">
<img alt="Array multidimensional de diferentes longitudes" src="imagenes/escalon.png"/>
</div>

Esto simplemente os lo comento para que lo sepáis, aunque no es muy normal utilizarlo.

Para acceder a los elementos de un array multidimensional deberemos utilizar tantos índices como dimensiones tenga el array.
~~~java
	crucigrama[0][0] = 'a';
	crucigrama[0][1] = 'n';
	...
	crucigrama[1][0] = 'b';
	...
	crucigrama[4][4] = 'l';
~~~

Veamos cómo recorrer el array multidimensional primero para asignarle valores a sus elementos y luego para mostrarlos.

~~~java
	...
	char[][] crucigrama;
	crucigrama = new char[5][5];
	char letra = 'a';
	for (int i = 0; i < crucigrama.length; i++) {
		for (int j = 0; j < crucigrama[i].length; j++) {
			crucigrama[i][j] = letra++;
		}
	}
	for (int i = 0; i < crucigrama.length; i++) {
		for (int j = 0; j < crucigrama[i].length; j++) {
			System.out.println("Elemento [" + i + ", " + j + "] = " + crucigrama[i][j]);
		}
	}
~~~

###### Arrays de objetos

Hasta ahora hemos visto todos los ejemplos con arrays de tipos primitivos. Pero también comenté que los arrays podían almacenar cualquier objeto.

Tanto la declaración, como la creación se hacen exactamente igual, aunque en vez de utilizar como `tipo` un tipo primitivo, se utiliza la clase del objeto que queramos almacenar.

Lo que sí debemos tener en cuenta que una vez creado el array todos sus elementos están inicializados a los valores por defecto, que en el caso de referencias a objetos es `null`. Por lo que debemos crear cada objeto y asignarlo a ese elemento antes de poder acceder al mismo.

~~~java
package arrays;

class Punto {
	private int x;
	private int y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punto(Punto otro) {
		x = otro.x;
		y = otro.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

}

public class ArrayObjetos {


	public static void main(String[] args) {
		Punto[] cuadrado = new Punto[4];
		cuadrado[0] = new Punto(0, 0);
		cuadrado[1] = new Punto(10, 0);
		cuadrado[2] = new Punto(10, 10);
		cuadrado[3] = new Punto(0, 10);

		for (Punto punto: cuadrado) {
			System.out.println(punto);
		}

		System.out.println("El primer vértice del cuadrado, tiene la x=" +
				cuadrado[0].getX() + " y la y=" + cuadrado[0].getY());
	}
}
~~~

###### Copiando arrays

A la hora de copiar un array debemos tener cuidado con lo que de verdad pretendemos. Aunque voy a hablar de copiar, el caso sería el mismo para devolverlo por un método o asignarlo a un atributo.

La primera idea sería asignar un array a otro, pero como ya sabemos lo que en verdad sucede es que se están copiando las referencias, por lo que cualquier modificación que hagamos en cualquiera de los arrays afectaría al otro.

~~~java
	...
	Punto[] arrayOrigen = { new Punto(1, 1) };
	Punto[] arrayDestino = new Punto[1];
	arrayDestino = arrayOrigen;
	arrayOrigen[0].setX(2);

	System.out.println(arrayOrigen == arrayDestino);	//Muestra true
	System.out.println(arrayOrigen[0] + ", "
			+ arrayDestino[0]); //Muestra Punto[x=2, x=1], Punto[x=2, y=1]
~~~

Otra opción sería utilizar el método `clone` que se hereda de `Object`, pero esta opción tampoco es una solución adecuada, ya que utilizando este método se crea una nueva referencia del array pero para cada elemento se igualan las referencias.

~~~java
	...
	Punto[] arrayOrigen = { new Punto(1, 1) };
	Punto[] arrayDestino = new Punto[1];
	arrayDestino = arrayOrigen.clone();
	arrayOrigen[0].setX(2);

	System.out.println(arrayOrigen == arrayDestino);	//Muestra false
	System.out.println(arrayOrigen[0] + ", "
			+ arrayDestino[0]); //Muestra Punto[x=2, x=1], Punto[x=2, y=1]
~~~

Hay otros métodos que también permiten hacer una copia de un array como el método `arraycopy` de la clase `System` la cuál acepta como parámetros el array de origen, la posición de origen, el array de destino, la posición del destino en qué copiarlo y la longitud a copiar. Pero este método también se comporta como en el caso anterior.

~~~java
	...
	Punto[] arrayOrigen = { new Punto(1, 1) };
	Punto[] arrayDestino = new Punto[1];
	System.arraycopy(arrayOrigen, 0, arrayDestino, 0, 1);
	arrayOrigen[0].setX(2);

	System.out.println(arrayOrigen == arrayDestino);	//Muestra false
	System.out.println(arrayOrigen[0] + ", "
			+ arrayDestino[0]); //Muestra Punto[x=2, x=1], Punto[x=2, y=1]
~~~

Por último, existen dos métodos de la clase `java.util.Arrays` cuyos identificadores son: `copyOf` que acepta como parámetros el array de origen y la longitud a copiar y devuelve la copia de dicho fragmento del array copiado; y `copyOfRange` que acepta como parámetros el array origen, el índice desde el que va a copiar y el índice donde termina de copiar (sin incluirlo) y devuelve el fragmento de array copiado. Pero ambos métodos se comportan exactamente igual que en el caso anterior.

Podemos comprobar que las técnicas utilizadas para realizar una copia de un array, simplemente realizan una **copia superficial** del array (exceptuando el operador `=` que simplemente iguala las referencias).

Si lo que pretendemos es realizar una **copia profunda** del array, lo que deberemos hacer es: crear un constructor copia de la clase que almacena el array (y de sus clases cliente, es decir, que realice una copia profunda de dicha clase) y recorrer el array creando nuevas instancias de cada uno de los elementos.

~~~java
	...
	Punto[] arrayOrigen = { new Punto(1, 1) };
	Punto[] arrayDestino = new Punto[1];
	for (int i = 0; i < arrayOrigen.length; i++) {
		arrayDestino[i] = new Punto(arrayOrigen[i]);
	}
	arrayOrigen[0].setX(2);

	System.out.println(arrayOrigen == arrayDestino);	//Muestra false
	System.out.println(arrayOrigen[0] + ", "
			+ arrayDestino[0]); //Muestra Punto[x=2, x=1], Punto[x=1, y=1]
~~~

###### Algunos otros métodos interesantes

La clase `java.util.Arrays` nos ofrece algunos otros métodos (además de los vistos) que nos pueden servir de ayuda en algún momento. Veamos algunos de los métodos más interesantes:

- `fill`: acepta como parámetros el array y el valor a asignar a cada elemento y rellena cada elemento del array con dicho valor. Hay que tener cuidado ya que simplemente hace una asignación del valor, por lo que si es una referencia tendremos el problema del **aliasing** para cada elemento.
- `sort`: ordena el array en orden ascendente. Este método trabaja correctamente con tipos primitivos, pero si queremos ordenar un array de objetos, la clase de dicho objeto debe implementar la interfaz `Comparable` o que le pasemos el método para comparar (utilizando una expresión lambda, por ejemplo), pero esto lo dejamos para más adelante.
- `binarySearch`: utiliza el algoritmo de búsqueda binaria para buscar un elemento en el array y devuelve la posición + 1 (en negativo) de dicho elemento. El requisito para que este método funcione correctamente es que el array esté previamente ordenado. Al igual que en el caso anterior, este método funciona correctamente con tipos primitivos pero si hablamos de objetos, la clase debe implementar la interfaz `Comparator` o que le pasemos el método para comparar.

## Cadenas de caracteres

La clase `String` representa una cadena de caracteres. Internamente podríamos verla como un array de caracteres.

Dado que el uso de cadenas de caracteres es muy común en los lenguajes de programación, en java la clase `String` está a medio camino entre un tipo primitivo y una clase. Debido a su amplio uso, su declaración e inicialización se parecen más a un tipo primitivo que a un objeto de una clase. Además, es importante mencionar que es un **objeto inmutable**, es decir, que una vez creado no puede cambiar su contenido.

Para crear una cadena, podemos utilizar dos formas:
- **Implícita**: Asignamos la referencia al objeto `String` a un literal del tipo cadena que se delimita por `""`. `String nombre = "José Ramón";`.
- **Explícita**: Se crea como cualquier otra referencia a un objeto de una clase. `String nombre = new String("José Ramón");`.

La diferencia entre crear una cadena de una forma u otra es, en principio la sencillez y comodidad de utilizar la forma implícita. Pero, además, existe otra diferencia: por cuestiones de eficiencia, cuando creamos una cadena utilizando la forma implícita, java almacenará los literales en una zona especial e intentará reutilizar todos los literales iguales. Sin embargo, cuando utilizamos la forma explícita se comportará como con cualquier otro objeto y los almacenará en el heap de memoria.

~~~java
	String nombre1 = "José Ramón";
	String nombre2 = "José Ramón";
	String nombre3 = new String("José Ramón");
	String nombre4 = new String("José Ramón");
	System.out.println(nombre1 == nombre2);		//Muestra true
	System.out.println(nombre3 == nombre4);		//Muestra false
~~~

<div align="center">
<img alt="Cadenas" src="imagenes/string.png"/>
</div>

Como hemos comentado anteriormente, las cadenas son objetos inmutables, por lo que cualquier operación que hagamos sobre ella, que implique una modificación, lo que hará es crear una nueva cadena, ya que los objetos inmutables no se pueden modificar.

Debido al amplio uso de las cadenas, también existe un operador especial para concatenar cadenas: `+`.
~~~java
	String nombre = "José Ramón";
	System.out.println("Hola " + nombre);		//Muestra: Hola José Ramón
~~~

Vistas las peculiaridades de las cadenas, veamos los principales métodos que nos ofrece la clase `String` para su manipulación y uso.

|------|-----------|
|Método|Explicación|
|------|-----------|
|`char charAt(int index)`|Devuelve el carácter especificado por el índice. El índice debe estar entre `0` y `length() - 1` o de lo contrario lanzará la excepción `IndexOutOfBoundsException`.|
|`String concat(String str)`||
|`boolean contains(CharSequence s)`||
|`int compareTo()`|Compara la cadena actual con la pasada por parámetro y devuelve -1, 0 o 1, dependiendo de si la pasada es menor, igual o mayor.|
|`int compareToIgnoreCase()`|Igual que el anterior, pero ignorando mayúsculas y minúsculas.|
|`boolean endsWith(String suffix)`|Devuelve `true` si la cadena actual termina con el sufijo `suffix`.|
|`boolean equals(Object obj)`|Compara si el contenido de la cadena actual y la pasada por paŕametro es el mismo.|
|`boolean equalsIgnoreCase(String string)`|Compara si el contenido de la cadena actual y la pasada por paŕametro es el mismo, ignorando mayúsculas y minúsculas.|
|`static String format(String format, Object... args)`||
|`int indexOf(char ch)`|Devuelve el índice de la primera ocurrencia del carácter `ch` o -1 si no existe.|
|`int indexOf(char ch, int fromIndex)`|Igual que la anterior, pero comienza la búsqueda a partir del índice `fromIndex`.|
|`int indexOf(String str)`|Devuelve el índice de la primera ocurrencia de la subcadena `str`.|
|`boolean isEmpty()`||
|`int lastIndexOf(char ch)`||
|`int lastIndexOf(char ch, int fromIndex)`||
|`int lastIndexOf(String str)`||
|`int length()`||
|`boolean matches(String regex)`||
|`String replace(char oldChar, char newChar)`||
|`String replaceAll(String regex, String replacement)`||
|`String replaceFirst(String regex, String replacement)`||
|`String[] split(String regex)`||
|`boolean startsWith(String prefix, inf offset)`|Devuelve `true` si la cadena actual empieza por la cadena `prefix` en índice `offset`.|
|`boolean startsWith(String prefix)`|Devuelve `true` si la cadena actual comienza por la cadena `prefix`.|
|`String substring(int beginIndex)`||
|`String substring(int beginIndex, int endIndex)`||
|`String toUpperCase()`||
|`String toLowerCase()`||
|`String trim()`||
|`static String valueOf(...)`||

Para consultar la lista completa de métodos, os recomiendo consultar la [documentación de la API de java](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html).

## Expresiones regulares

## Fechas y horas

## Ejercicios

###### Arrays

- **Letra del DNI**

  Escribir un programa java que lea el número de tu DNI y te muestra la letra correspondiente al mismo. Las letras del DNI se calculan quedándonos con el resto del numero de DNI entre 23 y aplicando esta correspondencia:
	~~~
		 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22
		 T R W A G M Y F P D X  B  N  J  Z  S  Q  V  H  L  C  K  E
	~~~
	Para ello, inicializa un array con estos valores y calcula la letra de un dni dado.

  - Posible solución
		~~~java
		package arrays;

		import utilidades.Entrada;

		public class LetraDni {

			private static final char[] LETRAS_DNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

			public static void main(String[] args) {
				int dni;
				do {
					System.out.print("Dime el número de tu DNI: ");
					dni = Entrada.entero();
				} while (dni < 1 || dni > 99999999);
				System.out.println("La letra de tu DNI es: " + LETRAS_DNI[dni % 23]);
			}

		}
		~~~
		[Descargar posible solución para el programa **LetraDni**](ejercicios/arrays/LetraDni.java)

- **Mayor y menor**

	Escribir un programa en java que pida por teclado el número enteros a generar, que deberá ser al menos dos. Cree un array de enteros de ese tamaño y lo rellene con números aleatorios entre 0 y 1000. Finalmente nos mostrará cuál es el mayor, cuál es el menor y la posición que ocupan.

	- Posible solución
		~~~java
		package arrays;

		import utilidades.Entrada;

		public class MayorMenor {

			public static void main(String[] args) {
				int cantidadNumeros;
				do {
					System.out.print("Inroduce la cantidad de números a generar: ");
					cantidadNumeros = Entrada.entero();
				} while (cantidadNumeros < 2);
				int[] numeros = new int[cantidadNumeros];
				for (int i = 0; i < numeros.length; i++) {
					numeros[i] = (int) (Math.random() * 1000);
				}
				int mayor = 0;
				int menor = 1000;
				int posMayor = -1;
				int posMenor = -1;
				for (int i = 0; i < numeros.length; i++) {
					if (numeros[i] > mayor) {
						mayor = numeros[i];
						posMayor = i;
					}
					if (numeros[i] < menor) {
						menor = numeros[i];
						posMenor = i;
					}
				}
				System.out.printf("El número mayor es: %d y ocupa la posición: %d%n", mayor, posMayor);
				System.out.printf("El número menor es: %d y ocupa la posición: %d%n", menor, posMenor);
			}

		}
		~~~
		[Descargar posible solución para el programa **MayorMenor**](ejercicios/arrays/MayorMenor.java)

- **Media**

	Escribir un programa java que lea por teclado la cantidad de números a generar, que deberá ser al menos 3. Cree un array de dicho tamaño y los genere aleatoriamente entre 0 y 100. Debe calcular la media de los mismos como entero y contar la cantidad de números que hay por encima, por debajo y los que son iguales a la media. También debe anotar las posiciones en las que se encuentran los números iguales a la media. Para ello ve almacenando sus posiciones en un `StringBuffer` separados por comas y lo muestre sólo en el caso que haya números iguales. Si solo hay uno no debe mostrar la coma final.

	- Posible solución
		~~~java
		package arrays;

		import utilidades.Entrada;

		public class Media {

			public static void main(String[] args) {
				int cantidadNumeros;
				do {
					System.out.print("Introduce la cantidad de números a generar: ");
					cantidadNumeros = Entrada.entero();
				} while (cantidadNumeros < 3);
				int[] numeros =  new int[cantidadNumeros];
				for (int i = 0; i < numeros.length; i++) {
					numeros[i] = (int) (Math.random() * 100);
				}
				int suma = 0;
				for (int i = 0; i < numeros.length; i++) {
					suma += numeros[i];
				}
				int media = suma / cantidadNumeros;
				int encimaMedia = 0;
				int debajoMedia = 0;
				int igualesMedia = 0;
				StringBuilder posicionesIgualesMedia = new StringBuilder();
				for (int i = 0; i < numeros.length; i++) {
					if (numeros[i] > media)
						encimaMedia++;
					else if (numeros[i] < media)
						debajoMedia++;
					else {
						igualesMedia++;
						posicionesIgualesMedia.append(posicionesIgualesMedia.toString().equals("") ? "" : ", ");
						posicionesIgualesMedia.append(i);
					}
				}
				System.out.printf("La media de todos los números es: %d%n", media);
				System.out.printf("Hay %d números por encima.%n", encimaMedia);
				System.out.printf("Hay %d números por debajo.%n", debajoMedia);
				System.out.printf("Hay %d números iguales.%n", igualesMedia);
				if (posicionesIgualesMedia.length() > 0) {
					System.out.printf("Las posiciones que ocupaban los elementos iguales era: %s", posicionesIgualesMedia);
				}
			}

		}
		~~~
		[Descargar posible solución para el programa **Media**](ejercicios/arrays/Media.java)

- **Tablero de ajedrez**

	Escribir un programa en java que muestre por pantalla un tablero de ajedrez, en el que las casillas blancas estarán representadas por el caracter ' ' y las negras por el caracter 'X'. Para ello primero inicializará el tablero al declararlo y lo mostrará. Luego inicializará el tablero en tiempo de ejecución y lo mostrará.

	- Posible solución
		~~~java
		package arrays;

		public class Tablero {

			public static void main(String[] args) {
				char[][] tablero;

				tablero = inicializarTableroDeclaracion();
				imprimeTablero(tablero);
				System.out.println();
				tablero = inicializarTableroEjecucion();
				imprimeTablero(tablero);
			}

			private static char[][] inicializarTableroDeclaracion() {
				char[][] tablero = {
						{' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
						{'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '},
						{' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
						{'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '},
						{' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
						{'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '},
						{' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
						{'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '}};
				System.out.println("Tablero inicializado al declarlo");
				return tablero;
			}

			private static char[][] inicializarTableroEjecucion() {
				char[][] tablero;
				tablero = new char[8][8];
				for (int i = 0; i < tablero.length; i++) {
					for (int j = 0; j < tablero[i].length; j++) {
						if (i % 2 == 0) {
							tablero[i][j] = (j % 2 == 0) ? ' ' : 'X';
						} else {
							tablero[i][j] = (j % 2 != 0) ? ' ' : 'X';
						}
					}

				}
				System.out.println("Tablero inicializado en tiempo de ejecución");
				return tablero;
			}

			private static void imprimeTablero(char[][] tablero) {
				for (int i = 0; i < tablero.length; i++) {
					for (int j = 0; j < tablero[i].length; j++) {
						System.out.print(tablero[i][j]);
					}
					System.out.println();
				}
			}

		}
		~~~
		[Descargar posible solución para el programa **Tablero**](ejercicios/arrays/Tablero.java)

- **Estudio estadístico IMC**

	Escribir un programa java que lea el IMC de una cantidad mayor que 2 de sujetos y nos muestre la media del IMC de dichos sujetos, el nombre del sujeto (o de uno de los sujetos) con mayor IMC y con menor IMC, la cantidad de sujetos con IMC por encima de la media y por debajo. El IMC de un sujeto se calcula como la división de su peso en kg. entre el cuadrado de su altura en cm.

	- **Posible solución**:
		SujetoEstudio.java
		~~~java
		package clasesdominio;

		public class SujetoEstudio {
			private String nombre;
			private double peso;
			private double altura;

			public SujetoEstudio(String nombre, double peso, double altura) {
				setNombre(nombre);
				setPeso(peso);
				setAltura(altura);
			}

			public String getNombre() {
				return nombre;
			}

			private void setNombre(String nombre) {
				if (nombre == null) {
					throw new IllegalArgumentException("El nombre de un sujeto no puede ser nulo.");
				}
				if (nombre.equals("")) {
					throw new IllegalArgumentException("El nombre de un sujeto no puede estar vacío.");
				}
				this.nombre = nombre;
			}

			public double getPeso() {
				return peso;
			}

			private void setPeso(double peso) {
				if (peso <= 0) {
					throw new IllegalArgumentException("El peso del sujeto debe ser mayor que cero");
				}
				this.peso = peso;
			}

			public double getAltura() {
				return altura;
			}

			private void setAltura(double altura) {
				if (altura <= 0) {
					throw new IllegalArgumentException("La altura del sujeto debe ser mayor que cero");
				}
				this.altura = altura;
			}

			public double getIMC() {
				return peso / (altura*altura);
			}

		}
		~~~
		[Descargar clase **SujetoEstudio.java**](ejercicios/clasesdominio/SujetoEstudio.java)

		CalculoIMC.java

		~~~java
		package arrays;

		import clasesdominio.SujetoEstudio;
		import utilidades.Entrada;

		public class CalculoIMC {

			public static void main(String[] args) {

				double maximoImc = 0;
				double minimoImc = Double.MAX_VALUE;
				double sumaImcs = 0;
				double mediaImcs;
				int posicionMinimoImc = 0;
				int posicionMaximoImc = 0;
				int sujetosPorEncimaMedia = 0;
				int sujetosPorDebajoMedia = 0;

				int cantidadSujetos;
				do {
					System.out.print("Introduce la cantidad de sujetos a estudiar: ");
					cantidadSujetos = Entrada.entero();
				} while (cantidadSujetos < 3);

				SujetoEstudio[] sujetos = new SujetoEstudio[cantidadSujetos];
				double[] imcs = new double[cantidadSujetos];

				for (int i = 0; i < cantidadSujetos; i++) {
					sujetos[i] = leerSujeto(i + 1);
					imcs[i] = sujetos[i].getIMC();
					if (imcs[i] < minimoImc) {
						minimoImc = imcs[i];
						posicionMinimoImc = i;
					}
					if (imcs[i] > maximoImc) {
						maximoImc = imcs[i];
						posicionMaximoImc = i;
					}
					sumaImcs += imcs[i];
				}
				mediaImcs = sumaImcs / cantidadSujetos;

				for (int i = 0; i < imcs.length; i++) {
					if (imcs[i] < mediaImcs) sujetosPorEncimaMedia++;
					if (imcs[i] > mediaImcs) sujetosPorDebajoMedia++;
				}

				System.out.printf("%nResultados del estudio%n");
				System.out.printf("----------------------%n");
				System.out.printf("El sujeto con mayor IMC es: %s%n", sujetos[posicionMaximoImc].getNombre());
				System.out.printf("El sujeto con menor IMC es: %s%n", sujetos[posicionMinimoImc].getNombre());
				System.out.printf("La media de IMCs es: %f%n", mediaImcs);
				System.out.printf("Hay %d sujetos por encima de la media.%n", sujetosPorEncimaMedia);
				System.out.printf("Hay %d sujetos por debajo de la media.%n", sujetosPorDebajoMedia);
			}

			private static SujetoEstudio leerSujeto(int numero) {
				String nombre;
				do {
					System.out.printf("Introduce el nombre del sujeto nº %d: ", numero);
					nombre = Entrada.cadena();
				} while (nombre.equals(""));
				double peso;
				do {
					System.out.printf("Introduce el peso en kg. del sujeto nº %d: ", numero);
					peso = Entrada.realDoble();
				} while (peso <= 0);
				double altura;
				do {
					System.out.printf("Introduce la altura en cm. del sujeto nº %d: ", numero);
					altura = Entrada.realDoble();
				} while (altura <= 0);
				return new SujetoEstudio(nombre, peso, altura);
			}

		}

		~~~
		[Descargar clase **CalculoIMC.java**](ejercicios/arrays/CalculoIMC.java)

###### Expresiones regulares

- **Reconocimiento DNI**

	Escribir un programa que pida por teclado un DNI mientras éste no sea válido. Luego mostrará el número por un lado y la letra por otra. Todo ello lo debe hacer utilizando expresiones regulares y grupos en las mismas.

	- Posible solución
		~~~java
		package expresionesregulares;

		import java.util.regex.Matcher;
		import java.util.regex.Pattern;

		import utilidades.Entrada;

		public class ReconoceDni {

			private static final String ER_DNI = "([0-9]{8})([A-Za-z])";

			public static void main(String[] args) {
				String dni;
				Pattern patron;
				Matcher comparador;

				patron = Pattern.compile(ER_DNI);
				do {
					System.out.print("Introduce un DNI: ");
					dni = Entrada.cadena();
					comparador = patron.matcher(dni);
				} while (!comparador.matches());

				System.out.printf("Número: %s%n", comparador.group(1));
				System.out.printf("Letra NIF: %s%n", comparador.group(2));
			}

		}
		~~~
		[Descargar clase **ReconoceDni.java**](ejercicios/expresionesregulares/ReconoceDni.java)

- **Valida teléfono**

	Escribir un programa en java que valide un teléfono utilizando una expresión regular pero usada en métodos de la clase `String`.

	- Posible solución
		~~~java
		package expresionesregulares;

		import utilidades.Entrada;

		public class ValidaTelefono {

			private static final String ER_TELEFONO = "[96]?[0-9]{8}";

			public static void main(String[] args) {
				String telefono;

				do {
					System.out.print("Introduce un telefono: ");
					telefono = Entrada.cadena();
				} while (!telefono.matches(ER_TELEFONO));

				System.out.printf("Teléfono válido: %s%n", telefono);
			}

		}
		~~~
		[Descargar clase **ValidaTelefono.java**](ejercicios/expresionesregulares/ValidaTelefono.java)

- **Prefijos telefónicos**

	Escribir un programa java que valide si un teléfono introducido cumple el formato de un teléfono español. Puede llevar el prefijo internacional o no. Será válido si su prefijo provincial es de tres cifras y el número de teléfono de 6 cifras o el prefijo de capital es dos cifras y el número de teléfono de 7 cifras. Cada campo irá separado por espacios. Finalmente mostrará o el prefijo de provincia o el prefijo de capital.

	- Posible solución
		~~~java
		package expresionesregulares;

		import java.util.regex.Matcher;
		import java.util.regex.Pattern;

		import utilidades.Entrada;

		public class PrefijoTelefono {

			private static final String ER_TELEFONO = "(?:\\+34 )?(?:(?:(9\\d{2}) \\d{6})|(?:(9\\d) \\d{7}))";

			public static void main(String[] args) {
				Pattern patron;
				Matcher comparador;

				patron = Pattern.compile(ER_TELEFONO);
				String telefono;
				do {
					System.out.print("Introduce un teléfono español valido \n"
							+ "(separa el prefijo nacional -lo puedes obviar-, el provincial o de capital y el teléfono por espacios): ");
					telefono = Entrada.cadena();
					comparador = patron.matcher(telefono);
				} while (!comparador.matches());

				String prefijo = (comparador.group(1)!=null) ? comparador.group(1) : comparador.group(2);
				String nombrePrefijo = (comparador.group(1)!=null) ? "provincia" : "capital";
				System.out.printf("Teléfono fijo español válido y el prefijo de %s es: %s%n", nombrePrefijo, prefijo);
			}

		}
		~~~
		[Descargar clase **PrefijoTelefono.java**](ejercicios/expresionesregulares/PrefijoTelefono.java)

- **Reconocer correos en un texto**

	Escribir un programa en java que reconozca todos los correos electrónicos encontrados en un texto dado y muestre todos aquellos que haya reconocido.

	- Posible solución
		~~~java
		package expresionesregulares;

		import java.util.regex.Matcher;
		import java.util.regex.Pattern;

		public class ReconoceCorreos {

			private static final String ER_CORREO = "\\w+[\\.\\w]*@\\w+[\\.\\w]*\\.\\w{2,5}\\b\\s?";

			public static void main(String[] args) {
				Pattern patron;
				Matcher comparador;

				String posiblesCorreos = "Hola@mundo.ab miCorreo@gmail.com.mialias correoFalso95@yahoo.es "
						+ "jose.ramon@midominio.com JoSeRaMoN@miAarroba jose.ramon@kk.com";

				patron = Pattern.compile(ER_CORREO);
				comparador = patron.matcher(posiblesCorreos);

				while (comparador.find()) {
					System.out.printf("Correo reconocido: %s%n", comparador.group());
				}
			}

		}
		~~~
		[Descargar clase **ReconoceCorreos.java**](ejercicios/expresionesregulares/ReconoceCorreos.java)

- **Cuenta palabras**

	Escribir un programa en java que cuente las palabras que hay en una frase introducida por teclado.

	- Posible solución
		~~~java
		package expresionesregulares;

		import java.util.regex.Matcher;
		import java.util.regex.Pattern;

		import utilidades.Entrada;

		public class CuentaPalabras {

			public static final String ER_PALABRA = "[A-Za-záéíóúü]+";

			public static void main(String[] args) {
				String frase;
				Pattern patron;
				Matcher comparador;

				do {
					System.out.print("Introduce una frase: ");
					frase = Entrada.cadena();
				} while (frase.equals(""));

				patron = Pattern.compile(ER_PALABRA, Pattern.UNICODE_CASE + Pattern.CASE_INSENSITIVE);
				comparador = patron.matcher(frase);
				int numPalabras = 0;
				while (comparador.find())
				{
					System.out.println("Palabra encontrada:" + comparador.group());
					numPalabras++;
				}
				System.out.printf("La frase contenía %d palabras.", numPalabras);
			}

		}
		~~~
		[Descargar clase **CuentaPalabras.java**](ejercicios/expresionesregulares/CuentaPalabras.java)

- **Cuenta vocales**

	Escribir un programa java que cuente las vocales existentes en una frase introducida por teclado, ignorando mayúsculas y minúsculas.

	- Posible solución
		~~~java
		package expresionesregulares;

		import java.util.regex.Matcher;
		import java.util.regex.Pattern;

		import utilidades.Entrada;

		public class CuentaVocales {

			private static final String ER_VOCALES = "[aeiouáéíóúü]";
			public static void main(String[] args) {
				String frase;
				Pattern patron;
				Matcher comparador;

				do {
					System.out.print("Introduce una frase: ");
					frase = Entrada.cadena();
				} while (frase.equals(""));

				patron = Pattern.compile(ER_VOCALES, Pattern.UNICODE_CASE + Pattern.CASE_INSENSITIVE);
				comparador = patron.matcher(frase);
				int numVocales = 0;
				while (comparador.find())
				{
					numVocales++;
				}

				System.out.printf("La frase contenía %d vocales.", numVocales);
			}

		}
		~~~
		[Descargar clase **CuentaVocales.java**](ejercicios/expresionesregulares/CuentaVocales.java)
