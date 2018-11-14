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

Como he comentado, un array es un objeto en java. Por tanto, primeros deberemos declarar una referencia a dicho array, después crear el array y posteriormente inicializar su contenido. Veamos cómo se lleva a cabo cada una de estas operaciones.

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

Para **recorrer** un array podemos utilizar un bucle. Es muy importante que controlemos que no nos salimos de los límites del array, tanto por abajo como por arriba (`0` ... `length - 1`), o de lo contrario nos saltará una excepción en tiempo de ejecución indicando que nos hemos salido de los límites del array (`ArrayIndexOutOfBound`).

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
	char[][] cruzigrama;
~~~

Al igual que ocurría con los arrays unidimensionales de objetos, una vez declarada la referencia hay que crear los diferentes elementos del array que en este caso también son arrays. Esto podemos hacerlo directamente con el operador `new`.
~~~java
	cruzigrama = new char[5][5];
~~~

<div align="center">
<img alt="Array multidimensional" src="imagenes/cruzigrama.png"/>
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
	cruzigrama[0][0] = 'a';
	cruzigrama[0][1] = 'n';
	...
	cruzigrama[1][0] = 'b';
	...
	cruzigrama[4][4] = 'l';
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

A la hora de copiar un array debemos tener cuidado con lo que de verdad pretendemos.

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

Por último, existen dos métodos de la clase `java.util.Arrays` cuyo identificadores son: `copyOf` que acepta como parámetros el array de origen y la longitud a copiar y devuelve la copia de dicho fragmento del array copiado; y `copyOfRange` que acepta como parámetros el array origen, el índice desde el que va a copiar y el índice donde termina la copiar (sin incluirlo) y devuelve el fragmento de array copiado. Pero ambos métodos se comportan exactamente igual que en el caso anterior.

Podemos comprobar que las técnicas utilizadas para realizar una copia de un array, simplemente realizan una **copia superficial** del array (exceptuando `clone` que simplemente iguala las referencias).

Si lo que pretendemos es realizar una **copia profunda** del array lo que deberemos hacer es: crear un constructor copia de la clase que almacena el array (y de sus clases cliente, es decir, que realice una copia profunda de dicha clase) y recorrer el array creando nuevas instancias de cada uno de los elementos.

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

## Expresiones regulares

## Fechas y horas

## Ejercicios
