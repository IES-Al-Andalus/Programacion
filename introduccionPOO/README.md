# Introducción a la programación orientada a objetos en Java

En este apartado encontrarás una breve descripción sobre los conceptos en los que se sustenta la **programación orientada a objetos**. Seguidamente pasaré a mostrar cómo definir, declarar, utilizar, etc. clases y objetos.

Al igual que en otros apartados, el objetivo principal es que tengáis una amplía gama de ejercicios, con sus respectivas posibles soluciones.

**José Ramón Jiménez Reyes**

 > ![@JRJimenezReyes](../assets/images/github.png) @JRJimenezReyes

 > ![joseramon.jimenez@iesalandalus.org](../assets/images/mail.png) joseramon.jimenez@iesalandalus.org

### Contenidos
---
- [Programación orientada a objetos](#progrmacin-orientada-a-objetos)
- [Clases en Java](#clases-en-java)
- [Objetos en Java](#objetos-en-java)
- [Excepciones](#excepciones)
- [Paquetes](#paquetes)
- [Enumerados](#enumerados)
- [Ejercicios](#ejercicios)


## Programación orientada a objetos

La programación orientada a objetos es un paradigma de programación en el que un programa es un conjunto de objetos que se relacionan entre sí. Esta forma de resolver un problema se adecúa más a lo que nos encontramos en la vida real y por eso la abstracción es más fácil.

La programación orientada a objetos se basa en una serie de conceptos o características:

- **Abstracción**: permite centrarnos en las propiedades de los tipos de datos y no en su implementación.

- **Encapsulación**: permite agrupar en un mismo módulo el estado o estructura de un tipo de dato y su comportamiento.

- **Ocultación de la información**: permite indicar a qué propiedades de un tipo de dato tendremos acceso y a cuáles no.

- **Modularidad**: permite descomponer el problema en componentes que pueden ser combinados entre sí para llegar a la solución del mismo.

- **Polimorfismo**: permite que un tipo de dato pueda hacer referencia a diferentes tipos de dato.

- **Herencia**: permite definir tipos de dato a partir de otros ya definidos y que el comportamiento de éstos se base en los primeros.

## Clases en Java

Una clase es el molde que define cómo será el nuevo tipo de dato que se está creando. Además una clase también define el comportamiento que tendrán todos los objetos que pertenezcan a dicha clase.

Por tanto, una clase se podrá definir por su estado o estructura y por su comportamiento. El **estado** vendrá dado por los **atributos** de la clase y el **comportamiento** por los **métodos** de la misma. El comportamiento para todos los objetos de una clase es el mismo, lo que varía es el estado de cada objeto.


> Por ejemplo, imagina que vamos a crear un videojuego en el que nos cuentan que los personajes del juego tendrán un nombre, un nivel de energía y un color. Por ahora, nos comentan también que los personajes pueden chocar con otros personajes o con paredes y que eso les hará perder energía, pero que pueden charlar con otros personajes lo que les podrá hacer aumentar su energía. Por lo que se podría modelar un personaje con una clase como la que se muestra en el diagrama, en la que podemos distinguir su estado y su comportamiento.
> <div align="center">
> <img alt="Diagramas de clases del Personaje" src="imagenes/personaje.png"/>
> </div>
> Como se puede apreciar hay un apartado en el diagrama en el que se muestran los atributos y otro en el que se muestran los métodos (podrás apreciar que aparece un método adicional que se llama igual que la clase y en el que nos detendremos un poco más adelante).

En Java podemos definir una clase utilizando la siguiente sintaxis:
~~~java
	[modificadores] class NombreClase [herencia] [interfaces]{
		[atributos]
		[metodos]
	}
~~~

Aunque modificadores hay varios, por ahora simplemente nos quedaremos con `public`, que indica que la clase será visible desde todas las partes del código.

De la parte de la herencia e interfaces ya hablaremos en otro apartado más detenidamente.

Una clase debe tener un nombre significativo y debe ir almacenada en un fichero con extensión `.java` con el mismo nombre de la clase (esto es debido a que la clase es pública, más adelante veremos otros casos al respecto). Recuerda que para nombrar las clases utilizábamos identificadores cuya inicial fuese una mayúscula y si era la composición de varias palabras, cada una de ellas comenzaba en mayúscula.

> Por tanto, podremos definir en java nuestra clase del ejemplo, de la siguiente forma:

~~~java
	public class Personaje {

	}
~~~

###### Atributos

Los atributos definen la estructura de datos que formará la clase.

Para declarar los atributos utilizaremos la siguiente sintaxis:
~~~java
[modificadoresAcceso][modificadoresContenido] tipo nombre;
~~~

Los modificadores de acceso son los que permitirán indicar el nivel de ocultación de la información para dichos atributos. Podemos encontrarnos los siguientes:
- `public`: indica que cualquier clase tiene acceso a dicho atributo.
- `protected`: indica que cualquier subclase de ésta tendrá acceso a dicho atributo y también las clases que pertenezcan al mismo paquete que la clase que estamos definiendo.
- `private`: indica que el atributo sólo será accesible desde la clase que estamos definiendo.
- **por omisión**: si no indicamos ningún modificador de acceso, estaremos indicando que el nivel de acceso es a nivel de paquete y sólo podrán acceder a este atributo las clases que pertenezcan al mismo paquete que la clase que estamos definiendo.

En el siguiente diagrama de clases se muestra cómo se representa la visibilidad de cada atributo:
<div align="center">
<img alt="Visibilidad atributos" src="imagenes/atributos.png"/>
</div>

Los modificadores de contenido son aquellos que le dan un sentido especial al contenido de ese atributo. Podemos encontrar:
- `static`: indica que el atributo será de clase y no de instancia. Lo veremos más adelante.
- `final`: indica que el valor del atributo no se puede cambiar.

Existe algún modificador más que no me detendré ni a nombrar, por ahora.

> Ahora añadimos los atributos a la clase y quedaría así:

~~~java
public class Personaje {

	private String nombre;
	private int energia;
	private String color;

}
~~~

###### Métodos

Los métodos son los encargados de realizar operaciones que sean aplicables a los objetos de la clase. Además, para conservar el principio de ocultación, deberían ser los únicos que modificasen el valor de los atributos.

Los métodos contarán con una cabecera y un cuerpo. La cabecera será la declaración del método en sí, en la que indicaremos entre otros: el nivel de acceso, el valor devuelto, el nombre, la lista de parámetros. El cuerpo será el código que implemente dicho método.

Para declarar un método debemos utilizar la siguiente sintaxis:
~~~java
	[modificadoresAcceso][modificadoresContenido] valorDevuelto nombre([listaParametros])[excepciones]
~~~
Los modificadores de acceso son iguales que para los atributos y tienen el mismo significado.

Los modificadores de contenido son casi iguales que para los atributos pero su significado cambia:
- `static`: indica que el método es un método de clase y no de instancia. Lo veremos más adelante.
- `final`: indica que el método no puede ser sobreescrito en la cadena de herencia. Lo veremos en otro apartado.
- `abstract`: indica que es un método abstracto y que no tiene implementación. Lo veremos en otro apartado.

La lista de parámetros es una lista de declaraciones separadas por comas, es decir, de tipos de dato y nombre separados por coma. Un método también puede aceptar un número variable de parámetros del mismo tipo mediante la construcción `varargs` que tampoco me detendré a mencionar, ya que no es más que una forma transparente de pasar como parámetro un array.

Del apartado `[excepciones]` ya hablaremos algo más adelante.

Los métodos que devuelven algo distinto de `void` deben acabar con una sentencia `return valor` y devolverán un `valor` del mismo tipo del declarado.

Los métodos se pueden sobrecargar, es decir, definir varios métodos que tengan el mismo identificador pero con distinta lista de parámetros (sin tener en cuenta el valor devuelto). Un uso muy común de sobrecarga de métodos es en el caso de los constructores.

> En el siguiente código mostramos nuestra clase con dos primeras implementaciones de los métodos `chocar` y `charlar`:

~~~java
public class Personaje {

	private String nombre;
	private int energia;
	private String color;

	public void chocar(int posiblePerdida) {
		energia -= posiblePerdida;
	}

	public void charlar(int posibleGanancia) {
		energia += posibleGanancia;
	}

}
~~~

###### Constructores
Los constructores son un tipo de método especial que se llaman igual que la clase y los únicos que no devuelven ningún valor. Su modificador de acceso suele ser `public`. Estos métodos son los encargados de asignar valores iniciales a los atributos, es decir, de establecer el estado inicial del objeto.

Podemos distinguir tres:
- **Por defecto**: es aquel constructor que no acepta parámetros y que inicializará el valor de los atributos a un valor por defecto conveniente para la clase.
- **Con parámetros**: Son los que aceptan parámetros y dependiendo de estos parámetros los atributos tomarán unos valores u otros. Generalmente los parámetros suelen ser valores iniciales que queremos darle a alguno de los atributos.
- **Copia**: Es aquel constructor que es capaz de realizar una copia del objeto que se le pasa como parámetro, que será del mismo tipo que la clase que estamos definiendo. Cuando hablemos del problema de las referencias volveremos a hablar de este tipo de constructores y en qué consiste la **copia profunda** en contraposición con la **copia superficial**.

Si nosotros no definimos ningún constructor, el compilador generará uno por defecto por nosotros. Recuerda el método que aparecía en el diagrama de clases que se llamaba igual que la clase.

Un constructor puede llamar a otro constructor. Por ejemplo, un constructor con parámetros, primero podría querer llamar al constructor por defecto y luego realizar otras acciones. Para ello se utiliza la llamada a `this()` que llamaría al constructor por defecto o si indicamos los parámetros adecuados, a otro constructor. La llamada a `this()` debe ser la primera línea de la implementación del constructor.

En los constructores (y en muchos otros métodos) es típico que el parámetro del método se llame igual que el atributo cuyo valor queremos establecer. Con esto surge un problema ya que dentro del método cuando utilicemos dicho nombre, nos estaremos refiriendo al parámetro y no al atributo. Para eliminar la ambigüedad podemos utilizar la palabra clave `this` que se refiere a la clase en cuestión y mediante la utilización del operador `.` podremos acceder al atributo deseado:

> Si añadimos los constructores a nuestro ejemplo de `Personaje`, el código podría quedarnos así:

~~~java
public class Personaje {

	private String nombre;
	private int energia;
	private String color;

	public Personaje() {
		nombre = "Personaje";
		energia = 100;
		color = "Rojo";
	}

	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}

	public void chocar(int posiblePerdida) {
		energia -= posiblePerdida;
	}

	public void charlar(int posibleGanancia) {
		energia += posibleGanancia;
	}

}
~~~

###### Métodos de acceso y modificación
Son aquellos métodos que nos permiten consultar y/o establecer el valor de los atributos.

Los métodos de consulta se nombran como `getNombre` donde `Nombre` es el nombre del atributo que queremos consultar. En el caso de que sea un atributo de tipo `boolean` se utiliza `isNombre` para realizar la consulta.

Los métodos de modificación se nombran como `setNombre` donde `Nombre` es el nombre del atributo que queremos modificar.

Cierto es que estos métodos podrían tener el nombre que quisiéramos, pero por convención utilizaremos estos nombres.

Para cumplir con el principio de ocultación, la norma general es:
- Definiremos los atributos con una visibilidad `private`.
- Pensaremos qué atributos queremos que sean accesibles desde fuera y creamos métodos de consulta para los mismos con una visibilidad `public`. Generalmente, para todos los atributos querremos que se pueda consultar su valor.
- Pensaremos qué atributos queremos que se puedan modificar, pasándole un nuevo valor. Ten en cuenta que habrá atributos que no tenga mucho sentido que podamos cambiar a nuestro antojo ya que: no tiene sentido cambiar dicho atributo una vez creado el objeto, depende de otros atributos que se pueda modificar o no, al modificar este atributo también habría que modificar otros para que nuestra clase guarde la consistencia, etc. Una vez decididos qué atributos queremos que se puedan modificar crearemos sus métodos de modificación con una visibilidad `public`.
- Habrá atributos para los que no queramos crear métodos de modificación pero para los que tenemos que hacer ciertas validaciones antes de modificar el valor de dicho atributo. Para estos atributos es una buena práctica crear métodos de modificación con visibilidad `private` que usarán otros métodos, como pudiera ser el constructor, para que lleve a cabo dichas validaciones. Es una buena costumbre llamar a los métodos `set` para modificar el valor de los atributos.

De esta forma estamos aislando a los clientes de nuestra clase de los cambios en la estructura de la misma.

> Siguiendo con nuestro ejemplo del videojuego, debemos proporcionar a la clase de métodos de acceso para los atributos, pero sin embargo los métodos de modificación de los mismos no tienen sentido para todos los atributos, ya que no tiene sentido cambiar el nombre de un personaje una vez creado y tampoco tiene sentido modificar a nuestro antojo la energía de un personaje ya que se hará por medio de otros métodos. Por tanto, nuestro diagrama de clases queda como sigue:
> <div align="center">
> <img alt="Diagramas de clases del Personaje" src="imagenes/personaje1.png"/>
> </div>
> Y nuestra clase quedaría tal como sigue:

~~~java
public class Personaje {

	private String nombre;
	private int energia;
	private String color;

	public Personaje() {
		nombre = "Personaje";
		energia = 100;
		color = "Rojo";
	}

	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEnergia() {
		return energia;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void chocar(int posiblePerdida) {
		energia -= posiblePerdida;
	}

	public void charlar(int posibleGanancia) {
		energia += posibleGanancia;
	}

}
~~~

###### Miembros estáticos

Hasta ahora hemos visto los miembros (atributos y métodos) de instancia, es decir, los miembros particulares de cada uno de los objetos que se creen de dicha clase. Pero hay situaciones en las que debemos compartir información entre todos los objetos de una clase o que queremos utilizar algún método de la clase sin necesidad de tener que instanciar un objeto de la misma. Estos son los miembros de clase.

Los **atributos de clase** son atributos compartidos por todos los objetos de la clase y en su definición utilizamos el modificador `static`. Por ejemplo, imaginemos que queremos saber en cada momento cuántos objetos se han creado de una clase. Para ello definiremos un atributo de clase que en el constructor de la misma se irá incrementando. Para los atributos de clase podemos definir los métodos de acceso y/o modificación según convenga.

En java no existen las **constantes** como tal, pero podemos conseguir el mismo efecto declarando dicho atributo como `static final`. Por tanto, sería un atributo de clase que no se puede modificar. Estos atributos no tiene sentido que tengan métodos de acceso y mucho menos de modificación ya que no está permitida. Es normal utilizar las constantes para indicar los valores por defecto que utilizaremos en los constructores, entre otros usos. Este tipo de atributos hay que inicializarlos en la declaración o en el constructor y ya no se le podrá cambiar el valor.

Los **métodos de clase** son métodos que no se aplican sobre objetos, sino sobre la clase en sí. Para definir estos métodos debemos utilizar el modificador `static` en su declaración. Para invocar estos métodos no es necesario instanciar ningún objeto de la clase. Estos métodos se invocan sobre la clase (su nombre). Aunque no lo creas ya has utilizado métodos de clase sin saberlo: `Math.random()`, `Entrada.entero()`, etc. Otra aspecto importante sobre estos métodos es que en su cuerpo **sólo pueden hacer referencia a miembros de clase** y en ningún caso a miembros de instancia.

Es común declarar **clases de utilidades** que sólo tienen métodos de clase y atributos de clase. Por ejemplo, la clase `Math` o la clase `Entrada`. Dado que no vamos a instanciar objetos de dichas clases, debemos evitar que el compilador nos cree el constructor por defecto y para ello definiremos un **constructor privado** con un simple comentario en su cuerpo y así nos aseguramos que nadie va a instanciar un objeto de nuestra clase de utilidades. Esto puedes verlo en la implementación de la clase `Entrada` que os proporcioné en el apartado anterior para realizar la entrada por teclado.

> Supongamos que para nuestro videojuego queremos llevar la cuenta de los personajes que hemos ido creando y que podamos consultarlo. Además, en el constructor por defecto asignaremos un nombre que haga referencia al número de personaje. También queremos utilizar algunas constantes para los valores iniciales. Veamos cómo quedaría nuestro diagrama de clases y el código de nuestra clase. Podéis apreciar en el diagrama que los miembros estáticos aparecen subrayados (además, he hecho que se muestren con un color diferente ya que el subrayado no se aprecia lo suficiente).
> <div align="center">
> <img alt="Diagramas de clases del Personaje" src="imagenes/personaje2.png"/>
> </div>

~~~java
public class Personaje {

	private static final int ENERGIA_INICIAL = 100;
	private static final String COLOR_INICIAL = "Rojo";
	private static final String PREFIJO_NOMBRE = "Personaje";

	private static int numPersonajes = 0;

	private String nombre;
	private int energia;
	private String color;

	public Personaje() {
		numPersonajes++;
		nombre = PREFIJO_NOMBRE + numPersonajes;
		energia = ENERGIA_INICIAL;
		color = COLOR_INICIAL;
	}

	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEnergia() {
		return energia;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static int getNumPersonajes() {
		return numPersonajes;
	}

	public void chocar(int posiblePerdida) {
		energia -= posiblePerdida;
	}

	public void charlar(int posibleGanancia) {
		energia += posibleGanancia;
	}

}
~~~

##### Relación de clientela

Hasta ahora hemos declarado atributos de tipos primitivos o a lo sumo `String`. Pero una clase también puede tener atributos cuyo tipo es otra clase. Cuando una clase X declara atributos cuyo tipo es de otra clase Y, entonces se dice que **la clase X es cliente de la clase Y**.

A veces nos ponemos a diseñar una clase y vemos que tenemos demasiados atributos de tipos primitivo. Generalmente esto nos está indicando que deberíamos crear otra clase que contenga algunos de dichos atributos relacionados y así hacer la primera clase cliente de la segunda.

Cuando tenemos un atributo cuyo tipo es de otra clase debemos tener en cuenta que en el constructor habrá que crearlo o de lo contrario su valor será `null`.

Más adelante hablaremos del problema del **aliasing** que debemos tener muy en cuenta.

También hacer notar que en los diagramas de clase, estos atributos cuyo tipo son de otra clase no aparecen como tal en la lista de atributos. La relación de cliente se expresa en estos diagramas mediante una flecha desde una clase a la otra. La flecha se etiqueta con el nombre del atributo y la cardinalidad, que por ahora será `0..1` ya que se trata de un atributo simple y no es un array o una colección, en cuyo caso podría poner el límite superior del array o `*` si es que no tiene límite superior.

> Imaginemos que ahora nos dicen que nuestro personaje ocupará una posición dentro la pantalla, que podrá ir cambiando conforme se vaya moviendo. Podríamos añadir dos atributos nuevos a nuestra clase que indiquen la posición X e Y de nuestro personaje. Sin embargo, otra solución más acertada sería crear una clase llamada `Posicion` que contendrá como atributos la posición X e Y y luego hacer que nuestra clase `Personaje` sea cliente de la clase `Posicion`. Como queremos que nuestro personaje se pueda mover, permitiremos modificar la posición en X y en Y, por lo que haremos que los métodos de modificación sean públicos para poder modificar dichas coordenas desde fuera de la clase (además esto lo hacemos por motivos didácticos para luego ejemplificar algunos problemas que pueden surgir de este diseño). Para que nuestro personaje se pueda mover debemos implementar un método llamado `mover` que recibirá como parámetros el incremento en la coordenada X y el incremento en la coordenada Y, y que modifique la posición de nuestro personaje en consecuencia. Tendremos unas constantes que marcarán los límites de la coordenada X y la Y y si intentamos asignar un valor que no esté dentro de esos límites, no lo permitirá y le asignará el valor mínimo, aunque en principio no deberíamos dejar hacerlo, pero eso lo dejamos para corregirlo cuando veamos las excepciones. Veamos cómo quedaría el diagrama de clases y el código de ambas clases.
> <div align="center">
> <img alt="Diagramas de clases del Personaje" src="imagenes/personaje3.png"/>
> </div>

###### Posicion.java
~~~java
public class Posicion {

	private static final int MIN_X = 0;
	private static final int MAX_X = 100;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 100;

	private int x;
	private int y;

	public Posicion() {
		x = MIN_X;
		y = MIN_Y;
	}

	public Posicion(int x, int y) {
		setX(x);
		setY(y);
	}

	public Posicion(Posicion posicion) {
		setX(posicion.getX());
		setY(posicion.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < MIN_X || x> MAX_X) {
			this.x = MIN_X;
		} else {
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y < MIN_Y || y > MAX_Y) {
			this.y = MIN_Y;
		} else {
			this.y = y;
		}
	}

}
~~~

###### Personaje.java
~~~java
public class Personaje {

	private static final int ENERGIA_INICIAL = 100;
	private static final String COLOR_INICIAL = "Rojo";
	private static final String PREFIJO_NOMBRE = "Personaje";

	private static int numPersonajes = 0;

	private String nombre;
	private int energia;
	private String color;
	private Posicion posicion;

	public Personaje() {
		numPersonajes++;
		nombre = PREFIJO_NOMBRE + numPersonajes;
		energia = ENERGIA_INICIAL;
		color = COLOR_INICIAL;
		posicion = new Posicion();
	}

	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Personaje(String nombre, Posicion posicion) {
		this(nombre);
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEnergia() {
		return energia;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void chocar(int posiblePerdida) {
		energia -= posiblePerdida;
	}

	public void charlar(int posibleGanancia) {
		energia += posibleGanancia;
	}

	public void mover(int x, int y) {
		posicion.setX(posicion.getX() + x);
		posicion.setY(posicion.getY() + y);
	}

}
~~~

## Objetos en Java

Un objeto es una instancia particular de una clase que se crea en tiempo de ejecución. Podemos tener tantos objetos como sea necesario, ya sean de diferentes clases o de la misma. Dicha instancia del objeto es una representación en memoria del estado de dicho objeto, es decir, de los valores particulares de cada atributo de dicho objeto.

Lo primero que debemos hacer es **declarar el objeto**. Dicha declaración se hace de la misma manera que declarábamos cualquier otra variable de tipo primitivo, pero en vez del tipo primitivo utilizamos el nombre de la clase a la que pertenece dicho objeto.
~~~java
	Personaje miPersonaje;
~~~
Al declarar el objeto, lo que realmente estamos haciendo es indicar que dicho identificador será una referencia a un objeto de esa clase. En ese momento, dicha referencia tiene el valor `null`, es decir, aún no apunta a ninguna posición de memoria.

Seguidamente debemos **crear el objeto**. Para crear el objeto utilizaremos el operador `new` seguido por uno de los constructores de la clase.
~~~java
	miPersonaje = new Personaje("Calamardo");
~~~
Con la creación del objeto lo que estamos haciendo es reservar un espacio de memoria para albergar un objeto de dicha clase y hacer que la referencia a dicho objeto apunte a dicha posición de memoria. En la siguiente imagen lo puedes ver de forma gráfica.
<div align="center">
<img alt="Referencia a un objeto" src="imagenes/referenciaObjeto.png"/>
</div>

Una vez tenemos declarada la referencia y creado el objeto, ya podemos utilizar dicho objeto. Para acceder a los miembros para los que su visibilidad nos lo permita, utilizamos el identificador de la referencia, seguido de un `.` y seguido del miembro al que queremos acceder, que según hemos visto, deberían ser métodos ya que el acceso a los atributos no está indicando en la mayoría de los casos.
~~~java
	miPersonaje.chocar(20);
	int energiaAux = miPersonaje.getEnergia();
~~~

##### Mostrar el estado de un objeto

Si queremos mostrar el estado de un objeto podemos utilizar, por ejemplo, la sentencia `System.out.println` pasándole la referencia a dicho objeto. Sin embargo, si hacemos esto se nos mostrará información sobre la clase a la que pertenece el objeto y una referencia a su identificador.

Generalmente, nos convendrá que a la hora de realizar esta operación se muestre el estado del objeto, es decir, el valor de cada uno de sus atributos. Para ello, la clase simplemente debe sobreescribir el método `toString` heredado de `Object` para que dicha representación se adecúe a nuestras necesidades. Este método no recibe parámetros y devuelve una cadena con la representación del mismo.

> Ahora queremos que nuestra clase `Posicion` permita mostrar el estado de los objetos de la misma, informándonos del valor de `x` y de `y`. Para ello simplemente sobreescribiremos el método `toString` para que se adecúe a estas premisas.

~~~java
	...
	@Override
	public String toString() {
		return String.format("x=%s, y=%s", x, y);
	}
~~~

> Una vez hecho esto, ya podremos mostrar es estado de los objetos de la clase `Posicion`

~~~java
	...
	Posicion miPosicion = new Posicion();
	System.out.println(miPosicion);		//Muestra: x=0, y=0
~~~

##### Referencias

Cuando asignamos una referencia a otra, no estamos copiando el contenido de una en otra, simplemente estamos igualando ambas referencias al mismo objeto.

Por ejemplo, cuando nosotros ejecutamos el siguiente código:
~~~java
	...
	Posicion posicion1 = new Posicion();
	Posicion posicion2;
	posicion2 = posicion1;
~~~
Lo que realmente está ocurriendo es lo siguiente:
<div align="center">
<img alt="Diagramas de clases del Personaje" src="imagenes/igualandoReferencias.png"/>
</div>

Este uso de las referencias tienen algunas ventajas como la compartición o la posibilidad de crear estructuras recursivas, pero tiene un inconveniente: **el aliasing**.

Veamos en qué consiste este problema, analizando el siguiente código:
~~~java
	...
	Posicion posicion1 = new Posicion(10, 10);
	Posicion posicion2;
	posicion2 = posicion1;
	System.out.println(posicion1);		//Muestra: x=10, y=10
	posicion2.setX(20);
	System.out.println(posicion1);		//Muestra: x=20, y=10
~~~

Como se puede apreciar, simplemente hemos modificado la coordenada `x` de la referencia `posicion2`, pero dicha modificación también ha afectado a la referencia `posicion1`. Si lo pensamos, es normal ya que ambas referencias apuntan al mismo objeto y cualquier modificación afectará a ambas referencias.

El aliasing ocurre cuando estamos trabajando con clases mutables, es decir, se puede modificar su estado. Esto no ocurriría si la clase `Posicion` fuese inmutable y eso se podría conseguir haciendo que sus método `setX` no fuesen públicos (o no estuviesen implementados).

Dado que en nuestro ejemplo, la clase `Posicion` es mutable, debemos tenerlo muy en cuenta ya que a veces podemos tener efectos no deseados. Por ejemplo, en un método de acceso de una clase, que accede a un atributo que es una referencia a otro objeto, si devolvemos la referencia estaremos comprometiendo la integridad ya que desde fuera se podrían cambiar los valores del objeto al que apunta. Veámoslo con un ejemplo:
~~~java
	...
	Personaje miPersonaje = new Personaje("Calamardo");
	Posicion miPosicion = miPersonaje.getPosicion();
	System.out.println(miPersonaje.getPosicion());		//Muestra: x=0, y=0
	miPosicion.setX(10);
	System.out.println(miPersonaje.getPosicion());		//Muestra: x=10, y=0
~~~

Este mismo caso se puede dar cuando pasamos una referencia al constructor o a un método de modificación y simplemente igualamos la referencia.
~~~java
	...
	Posicion miPosicion = new Posicion(10, 10);
	Personaje miPersonaje = new Personaje("Calamardo", miPosicion);
	System.out.println(miPosicion);	//Muestra: x=10, y=10
	miPersonaje.mover(10, 0);
	System.out.println(miPosicion);	//Muestra: x=20, y=10
~~~

Por tanto, aunque depende del problema a resolver, lo normal es que creemos nuevas instancias partiendo de la pasada o que las devolvamos (esto siempre que las referencias no sean a objetos inmutables, como es el caso de la clase `String`). Para ello, es muy común utilizar el constructor copia de la clase, del que hemos hablado muy por encima.

El constructor copia lo que hará es crear un nuevo objeto con los valores de los atributos igualados a los de la referencia del objeto pasado como argumento. Si simplemente copiamos los valores, estaremos creando lo que se llama **copia superficial** y si la clase es cliente de otra clase mutable, podríamos encontrarnos con este problema.
~~~java
	public Personaje(Personaje personaje) {
		nombre = personaje.getNombre();
		energia = personaje.getEnergia();
		color = personaje.getColor();
		posicion = personaje.getPosicion();
	}
~~~
Como se puede ver, para el atributo `posicion` hemos igualado la referencia, ya que el método `getPosicion` devolvía dicha referencia.

Para solucionarlo, utilizaremos la **copia profunda** que en vez de igualar referencias, cree nuevos objetos e iguale a dichos objetos recién creados.
~~~java
	public Personaje(Personaje personaje) {
		nombre = personaje.getNombre();
		energia = personaje.getEnergia();
		color = personaje.getColor();
		posicion = new Posicion(personaje.posicion);
	}
~~~

Con esto habríamos solucionado el problema, pero seguimos devolviendo la referencia de la posición en el método de consulta y nos quedamos con la referencia en el metodo de establecimiento, y eso deberíamos arreglarlo.

Por todo lo comentado anteriormente, si nosotros utilizamos el operado `==` para comparar la igualdad de dos referencias, nos devolverá `true` si ambas apuntan al mismo objeto y `false` si apuntan a objetos diferentes aunque el estado de ambos sea idéntico.

Para solucionar este otro problema debemos utilizar el método `equals`. Lo normal es que para cada clase nosotros sobreescribamos este método. Por otro lado, para ser consecuentes, java internamente puede utilizar otro método llamado `hashCode` que devuelve un número único para cada objeto, y que para dos objetos con el mismo estado devolverá el mismo número y para dos objetos diferentes deberá devolver números diferentes. La documentacion de java dice que `equals` y `hashCode` deben comportarse de igual forma por consistencia, por lo que si sobreescribimos uno deberíamos sobreescribir el otro. Generalmente estos dos métodos los pueden generar los IDEs por nosotros.

Ahora os muestro el código de ambas clases con los problemas de **aliasing** corregidos y con la implementación de `equals` y `hashCode`.
###### Posicion.java
~~~java
import java.util.Objects;

public class Posicion {

	private static final int MIN_X = 0;
	private static final int MAX_X = 100;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 100;

	private int x;
	private int y;

	public Posicion() {
		x = MIN_X;
		y = MIN_Y;
	}

	public Posicion(int x, int y) {
		setX(x);
		setY(y);
	}

	public Posicion(Posicion posicion) {
		setX(posicion.getX());
		setY(posicion.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < MIN_X || x > MAX_X) {
			this.x = MIN_X;
		} else {
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y < MIN_Y || y > MAX_Y) {
			this.y = MIN_Y;
		} else {
			this.y = y;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Posicion)) {
			return false;
		}
		Posicion other = (Posicion) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return String.format("x=%s, y=%s", x, y);
	}

}
~~~
###### Personaje.java
~~~java
import java.util.Objects;

public class Personaje {

	private static final int ENERGIA_INICIAL = 100;
	private static final String COLOR_INICIAL = "Rojo";
	private static final String PREFIJO_NOMBRE = "Personaje";

	private static int numPersonajes = 0;

	private String nombre;
	private int energia;
	private String color;
	private Posicion posicion;

	public Personaje() {
		numPersonajes++;
		nombre = PREFIJO_NOMBRE + numPersonajes;
		energia = ENERGIA_INICIAL;
		color = COLOR_INICIAL;
		posicion = new Posicion();
	}

	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Personaje(String nombre, Posicion posicion) {
		this(nombre);
		setPosicion(posicion);
	}

	public Personaje(Personaje personaje) {
		nombre = personaje.getNombre();
		energia = personaje.getEnergia();
		color = personaje.getColor();
		posicion = new Posicion(personaje.posicion);
	}

	public String getNombre() {
		return nombre;
	}

	public int getEnergia() {
		return energia;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Posicion getPosicion() {
		return new Posicion(posicion);
	}

	private void setPosicion(Posicion posicion) {
		this.posicion = new Posicion(posicion);
	}

	public void chocar(int posiblePerdida) {
		energia -= posiblePerdida;
	}

	public void charlar(int posibleGanancia) {
		energia += posibleGanancia;
	}

	public void mover(int x, int y) {
		posicion.setX(posicion.getX() + x);
		posicion.setY(posicion.getY() + y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, energia, nombre, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(color, other.color) && energia == other.energia && Objects.equals(nombre, other.nombre)
				&& Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return String.format("nombre=%s, energia=%s, color=%s, posicion=(%s)", nombre, energia, color, posicion);
	}

}
~~~

## Excepciones

Una excepción no es más que un error o un problema que ocurre durante la ejecución de nuestro programa. Cuando se produce esta situación anómala el flujo normal del programa se interrumpe y el programa termina abruptamente. Nosotros, como buenos programadores, intentaremos por todos los medios que nuestro programa sea **robusto** y que, por tanto, sea capaz de reaccionar adecuadamente ante estas situaciones excepcionales.

Imaginaos, por ejemplo, que queremos transferir un archivo por la red y lo queremos guardar en un archivo que se encuentra en un pendrive. Veamos qué situaciones anómalas se pueden dar:
- Que el origen de donde leeremos el fichero está malformado o el fichero no existe.
- Que la conexión de red se pierda por algún motivo (alguién apaga la wifi, hay un problema en el router, etc.).
- Que el pendrive está lleno y no tiene espacio para almacenar dicho fichero.
- Que en medio de la escritura del fichero, alguien saca el pendrive.
- Que no tenemos permiso de escritura en el pendrive.
- Etc.

En java las excepciones están representadas por una clase. Las excepciones, al igual que toda clase, siguen una jerarquía de clases, que no voy a mostrar ya que ni siquiera hemos hablado de herencia, aún. Uno de los métodos más comunes de las excepciones es el método `getMessage` que devuelve una cadena con un mensaje explicativo sobre la causa de dicha excepción.

Dentro de estas situaciones anómalas podemos distinguir tres categorías:
- **Errores**: son situaciones ante las que nosotros poco podemos hacer. Este tipo de situaciones quedan fuera de nuestro alcance y terminarán el programa. Por ejemplo, que la JVM se queda sin memoria. Ante esto poco podemos hacer (además de revisar nuestro código para ver si podemos reducir el uso de memoria de alguna forma). Por ello, no se consideran excepciones propiamente dichas. Todos los errores heredan de la clase `Error`.
- **Excepciones comprobadas**: son situaciones que son típicas que ocurran al tratar con ciertos recursos como disco, red, etc. Estas excepciones debemos tratarlas para evitar que nuestro programa termine abruptamente. Además, estamos obligados a tratarlas ya que si no, tendremos un error en tiempo de compilación. Todas las excepciones comprobadas heredan de la clase `Exception`, pero no de `RuntimeException`. Este tipo de excepciones es obligatorio tratarlas.
- **Excepciones no comprobadas**: son situaciones que ocurren debido a errores que cometemos en la programación: intentar acceder a una posición de un array que no existe (`IndexOutOfBoundsException`), intentar trabajar con un objeto nulo (`NullPointerException`), pasar un argumento no válido a un método (`IllegalArgumentException`), etc. Todas estas excepciones heredan de
`RuntimeException`. Este tipo de excepciones podemos tratarlas o no, según sea la situación.

##### Tratamiento de una excepción
Cuando vamos a llamar a un método que pueda lanzar una excepción, encerraremos dicha llamada al método en un `try`. Seguida a este bloque, puede haber uno o varios bloques `catch`. Y podemos terminar con un bloque `finally`. Veamos que significa todo esto:
- En el bloque `try` se ejecuta la sentencia que puede lanzar una o varias excepciones. Si se lanza una excepción, el flujo se detendrá y pasaremos a los bloques `catch`.
- En cada uno de los bloques `catch` capturamos un tipo de excepción que se ha podido lanzar en el bloque `try` e indicamos cómo reaccionar ante dicha situación. Cada sentencia `catch` va seguida por el nombre de la excepción ante la que queremos reaccionar.
- El bloque `finally` es un bloque opcional que se ejecuta siempre, se haya producido alguna excepción o no. Se suele utilizar para cerrar recursos abiertos. A partir de java SE 7, este bloque perdió su sentido original debido a la introducción de la sentencia `try-with-resources` que ya veremos en otros apartados.

~~~java
	try {
		fichero = new FileInputStream(nombreArchivo);
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	}
~~~
Los bloques `try` se pueden anidar. Además en un bloque `catch` se pueden capturar varias excepciones separando sus nombre por medio del operador `|`.
~~~java
	try {
		fichero = new FileInputStream(nombreArchivo);
		aux = (byte) fichero.read();
	} catch (IOException | FileNotFoundException e) {
		System.out.println(e.getMessage());
	}
~~~

##### Propagación de las excepciones
Hay veces en las que no sabemos muy bien cómo tratar la excepción, no es el momento de tratarla, etc. En estos casos lo que podemos hacer es dejar escapar la excepción o, lo que es lo mismo, propagarla. Para ello en el método que no estemos tratando una excepción deberemos indicarle al compilador que ese método puede propagar la excepción y que sea el código que invoca dicho método el encargado de tratarla. Para ello se utiliza la expresión `throws` seguido por el nombre o nombres de las excepciones que dicho método puede propagar, en la cabecera del mismo.
~~~java
	public void leerFichero() throws IOException, FileNotFoundException
~~~
El tratamiento de las excepciones por tanto se puede delegar. Si una excepción se propaga desde el sitio donde se produjo y llega al método `main` y no es tratada, el programa terminará abruptamente imprimiendo la pila de llamadas a métodos, empezando donde se produjo y mostrando todos los métodos por donde ha ido pasando hasta llegar al método `main`. Esto es lo que siempre deberemos evitar.

Ni que decir tiene que todas las excepciones comprobadas deberemos o bien tratarlas o bien propagarlas.

##### Lanzamiento de excepciones
Nosotros podemos lanzar una excepción en el momento que deseemos. Esto generalmente se hace con las excepciones propias, es decir, con las que nosotros definimos (esto lo veremos cuando hablemos de la herencia). Pero también se puede hacer con cualquier otro tipo de excepción para indicar que ha ocurrido un error del tipo de dicha excepción. Por ejemplo, es muy común lanzar la excepción no comprobada `IllegalArgumentException` en nuestras clases, cuando pasamos parámetros con valores incorrectos a nuestros métodos.

Para lanzar una excepción, simplemente tendremos que crear un nuevo objeto del tipo de la excepción y notificarlo con la sentencia `throw`.
~~~java
	if (objeto == null) {
		throw new NullPointerException("El objeto pasado es nulo.");
	}
~~~

> Ahora que hemos visto el tratamiento de excepciones, queremos que nuestra clase Personaje pueda informar si se ha pasado algún valor incorrecto a los métodos. Además, como os comenté también utilizaré métodos modificadores privados que se encargarán de realizar la comprobación y que se llamarán en el constructor. Además queremos que el método `mover` lance una excepción comprobada `OperationNotSupportedException` cuando estemos intentando mover la posición de nuestro personaje y éste sobrepase los límites establecidos.
> <div align="center">
> <img alt="Diagramas de clases del Personaje" src="imagenes/personaje5.png"/>
> </div>

###### Posicion.java
~~~java
import java.util.Objects;

public class Posicion {

	private static final int MIN_X = 0;
	private static final int MAX_X = 100;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 100;

	private int x;
	private int y;

	public Posicion() {
		x = MIN_X;
		y = MIN_Y;
	}

	public Posicion(int x, int y) {
		setX(x);
		setY(y);
	}

	public Posicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("No puedo copiar una posición nula.");
		}
		setX(posicion.getX());
		setY(posicion.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < MIN_X) {
			throw new IllegalArgumentException("El valor de la x es menor que el mínimo permitido.");
		} else if (x > MAX_X) {
			throw new IllegalArgumentException("El valor de la x es mayor que el máximo permitido.");
		}
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y < MIN_Y) {
			throw new IllegalArgumentException("El valor de la y es menor que el mínimo permitido.");
		} else if (y > MAX_Y) {
			throw new IllegalArgumentException("El valor de la y es mayor que el máximo permitido.");
		}
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return String.format("x=%s, y=%s", x, y);
	}

}
~~~

###### Personaje.java
~~~java
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Personaje {

	private static final String PREFIJO_NOMBRE = "Personaje ";
	private static final int ENERGIA_INICIAL = 100;
	private static final String COLOR_INICIAL = "Rojo";
	private static final int MIN_ENERGIA = 0;
	private static final int MAX_ENERGIA = 100;

	private static int numPersonajes = 0;

	private String nombre;
	private int energia;
	private String color;
	private Posicion posicion;

	public Personaje() {
		numPersonajes++;
		nombre = PREFIJO_NOMBRE + numPersonajes;
		energia = ENERGIA_INICIAL;
		color = COLOR_INICIAL;
		posicion = new Posicion();
	}

	public Personaje(String nombre) {
		this();
		setNombre(nombre);
	}

	public Personaje(String nombre, int energia, String color, Posicion posicion) {
		this();
		setNombre(nombre);
		setEnergia(energia);
		setColor(color);
		setPosicion(posicion);
	}

	public Personaje(Personaje personaje) {
		this();
		if (personaje == null) {
			throw new NullPointerException("No puedo copiar un personaje nulo.");
		}
		nombre = personaje.getNombre();
		energia = personaje.getEnergia();
		color = personaje.getColor();
		posicion = new Posicion(personaje.posicion);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("El nombre del personaje no puede ser nulo.");
		}
		this.nombre = nombre;
	}

	public int getEnergia() {
		return energia;
	}

	private void setEnergia(int energia) {
		if (energia < MIN_ENERGIA) {
			throw new IllegalArgumentException("El valor de la energia no puede ser menor que el mínimo establecido.");
		} else if (energia > MAX_ENERGIA) {
			throw new IllegalArgumentException("El valor de la energia no puede ser mayor que el máximo establecido.");
		}
		this.energia = energia;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color == null) {
			throw new NullPointerException("El color del personaje no puede ser nulo.");
		}
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("La posición del personaje no puede ser nula.");
		}
		this.posicion = posicion;
	}

		public void chocar(int posiblePerdida) {
		setEnergia(energia - posiblePerdida);
	}

	public void charlar(int posibleGanancia) {
		setEnergia(energia + posibleGanancia);
	}

	public void mover(int x, int y) throws OperationNotSupportedException {
		try {
			posicion.setX(posicion.getX() + x);
			posicion.setY(posicion.getY() + y);
		} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException("Movimiento no válido: " + e.getMessage());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, energia, nombre, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(color, other.color) && energia == other.energia && Objects.equals(nombre, other.nombre)
				&& Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return String.format("nombre=%s, energia=%s, color=%s, posicion=(%s)", nombre, energia, color, posicion);
	}

}
~~~

## Paquetes

Hasta ahora, los programas que has realizado constaban de una sola clase o muy pocas. En este apartado hemos visto como poco a poco va creciendo el número de clases a utilizar por un programa. Por lo que se necesita una forma de estructurar nuestras clases.

Para ello existen los paquetes, que no son más que agrupaciones de clases relacionadas. Al fin y al cabo esto no es más que diferentes directorios con sus clases. Pero para que una clase pertenezca a un paquete no basta con colocarla en un determinado directorio, sino que la primera instrucción del fichero `.java` debe indicar el paquete al que pertenece.

Los paquetes se pueden anidar unos dentro de otros.

~~~java
package videojuego;
...
~~~

Para poder hacer referencia a una clase dentro de otra, debemos utilizar su nombre cualificado que es el nombre de la clase precedido por la ruta de los diferentes paquetes a los que pertenece (comenzamos en la raíz de la jerarquía y vamos descendiendo), separados por `.`.
~~~java
	...
	int i = org.iesalandalus.programacion.utilidades.Entrada.entero();
~~~

Pero esta nomenclatura es muy engorrosa. Además si tenemos muchos paquetes, unos dentro de otros y demás, como es el caso, por ejemplo, del API de java, esto es inviable. Para poder omitir esta ruta, se utiliza la sentencia `import` que irá justo después de la sentencia `package` y antes de la definición de la clase. Podemos utilizar tantas sentencias `import` como necesitemos (una debajo de otra). Además, podemos utilizar el comodín `*` para indicar que queremos importar todas las clases de un paquete. Con el uso del `*` importamos todas las clases de ese paquete, pero no las clases que hayan en sus subpaquetes, para ello deberíamos utilizar diferentes sentencias `import`. El uso del `*` no tiene ningún inconveniente y no hace que nuestra clase vaya a ocupar más o se ejecute más lenta, ni nada de eso. Es más, el uso del `*` está recomendado.
~~~java
	import org.iesalandalus.programacion.utilidades.*;
	...
	int i = Entrada.entero();
~~~

Pero para clases que contienen miembros estáticos, podemos utilizar la sentencia `import static` seguido por el nombre de los miembros que queremos importar o usando el `*` para importarlos todos y así evitar anteponer al miembro el nombre de la clase.
~~~java
	import static org.iesalandalus.programacion.utilidades.Entrada.*;
	import static java.lang.Math.*;
	...
	double radio = entero();
	double perimetro = 2 * PI * radio;
~~~

## Enumerados

Los enumerados son clases especiales cuyos objetos se definen en la definición del enumerado, es decir, son conocidos en tiempo de compilación. Para declararlos utilizamos la palabra reservada `enum` seguida del identifcador del enumerado y entre las llaves encerramos los objetos, separados por comas. En su forma más sencilla sería almacenar constantes relacionadas.

~~~java
	public enum Direccion {
		ARRIBA,
		ABAJO,
		DERECHA,
		IZQUIERDA;
	}
~~~

Su implementación utilizando una clase, podría ser como sigue (los enumerados existen a partir de la versión 5):
~~~java
	public class Direccion {
		public static final Direccion ARRIBA = new Direccion();
		public static final Direccion ABAJO = new Direccion();
		public static final Direccion DERECHA = new Direccion();
		public static final Direccion IZQUIERDA = new Direccion();

		private Direccion() {}
	}
~~~

Para cada valor del enumerado se le asigna una constante, llamada `ordinal` empezando en 0. También contiene métodos como: `values()` que devuelve todos los valores del enumerado, `valueOf(String)` que nos devuelve el valor del enumerado representado por dicha cadena y `toString` que nos devuelve la representación del valor. Los enumerados tamibén se pueden utilizar en sentencias `switch`.

Por ejemplo, el siguiente código recorrería los valores del enumerado y mostraría su ordinal y su representación como cadena. El bucle que hemos utilizado para recorrer los valores del ordinal es un bucle `for-each` que se utiliza para recorrer colecciones y en el que en cada iteración la variable toma un valor, pero que veremos más adelante cuando hablemos de colecciones.
~~~java
	...
	for (Direccion direccion : Direccion.values()) {
		System.out.println("Ordinal: " + direccion.ordinal() + ", nombre: " + direccion);
	}
	...
~~~

Su salida sería la que se muestra a continuación:
~~~
Ordinal: 0, nombre: ARRIBA
Ordinal: 1, nombre: ABAJO
Ordinal: 2, nombre: DERECHA
Ordinal: 3, nombre: IZQUIERDA
~~~

Los enumerados también pueden tener atributos, constructores que deben ser privados, métodos, etc.

Veamos un ejemplo de uso con su constructor y unos atributos.
~~~java
	public enum Mes {
		ENERO("Enero", 31),
		FEBRERO("Febrero", 28),
		MARZO("Marzo", 31),
		ABRIL("Abril", 30),
		MAYO("Mayo", 31),
		JUNIO("Junio", 30),
		JULIO("Julio", 31),
		AGOSTO("Agosto", 31),
		SEPTIEMBRE("Septiembre", 30),
		OCTUBRE("Octubre", 31),
		NOVIEMBRE("Noviembre", 30),
		DICIEMBRE("Diciembre", 31);

		private String cadenaAMostrar;
		private int numeroDias;

		private Mes(String cadenaAMostrar, int numeroDias) {
			this.cadenaAMostrar = cadenaAMostrar;
			this.numeroDias = numeroDias;
		}

		public int getNumeroDias() {
			return numeroDias;
		}

		@Override
		public String toString() {
			return cadenaAMostrar;
		}
	}
	...
	for (Mes mes : Mes.values()) {
		System.out.println(mes + " tiene " + mes.getNumeroDias() + " días.");
	}
~~~

Daría como salida:
~~~
Enero tiene 31 días.
Febrero tiene 28 días.
Marzo tiene 31 días.
Abril tiene 30 días.
Mayo tiene 31 días.
Junio tiene 30 días.
Julio tiene 31 días.
Agosto tiene 31 días.
Septiembre tiene 30 días.
Octubre tiene 31 días.
Noviembre tiene 30 días.
Diciembre tiene 31 días.
~~~

> Por último nos dicen que los personajes sólo aceptarán tres colores: rojo, verde y azul (queremos que su representación como cadena sea su nombre con la primera letra en mayúsculas y lo demás en minúsculas). Además nos comentan que quieren que nuestro personaje pueda moverse en una determinada dirección: arriba, abajo, derecha e izquierda, y un determinado número de pasos  (además de como se podía mover anteriormente). También nos comentan que quieren que metamos todo en un paquete llamado `videojuego`. Pues el resultado final de nuestro diagrama de clases y el código final de todas nuestras clases sería el siguiente (debemos tener en cuenta que el diagrama de clases no me permite mostrar sus atributos o métodos, por lo que para el enumerado `Color` lo anotado junto a su representación para que quede claro):
> <div align="center">
> <img alt="Diagramas de clases del Personaje" src="imagenes/personaje6.png"/>
> </div>

###### Direccion.java
~~~java
package videojuego;

public enum Direccion {
	ARRIBA,
	ABAJO,
	DERECHA,
	IZQUIERDA;
}
~~~
###### Color.java
~~~java
package videojuego;

public enum Color {
	ROJO("Rojo"),
	VERDE("Verde"),
	AZUL("Azul");

	private String cadenaAMostrar;

	private Color(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}

	@Override
	public String toString() {
		return cadenaAMostrar;
	}
}
~~~
###### Posicion.java
~~~java
package videojuego;

import java.util.Objects;

public class Posicion {

	private static final int MIN_X = 0;
	private static final int MAX_X = 100;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 100;

	private int x;
	private int y;

	public Posicion() {
		x = MIN_X;
		y = MIN_Y;
	}

	public Posicion(int x, int y) {
		setX(x);
		setY(y);
	}

	public Posicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("No puedo copiar una posición nula.");
		}
		setX(posicion.getX());
		setY(posicion.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < MIN_X) {
			throw new IllegalArgumentException("El valor de la x es menor que el mínimo permitido.");
		} else if (x > MAX_X) {
			throw new IllegalArgumentException("El valor de la x es mayor que el máximo permitido.");
		}
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y < MIN_Y) {
			throw new IllegalArgumentException("El valor de la y es menor que el mínimo permitido.");
		} else if (y > MAX_Y) {
			throw new IllegalArgumentException("El valor de la y es mayor que el máximo permitido.");
		}
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return String.format("x=%s, y=%s", x, y);
	}

}
~~~
###### Personaje.java
~~~java
package videojuego;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Personaje {

	private static final String PREFIJO_NOMBRE = "Personaje ";
	private static final int ENERGIA_INICIAL = 100;
	private static final Color COLOR_INICIAL = Color.ROJO;
	private static final int MIN_ENERGIA = 0;
	private static final int MAX_ENERGIA = 100;

	private static int numPersonajes = 0;

	private String nombre;
	private int energia;
	private Color color;
	private Posicion posicion;

	public Personaje() {
		numPersonajes++;
		nombre = PREFIJO_NOMBRE + numPersonajes;
		energia = ENERGIA_INICIAL;
		color = COLOR_INICIAL;
		posicion = new Posicion();
	}

	public Personaje(String nombre) {
		this();
		setNombre(nombre);
	}

	public Personaje(String nombre, int energia, Color color, Posicion posicion) {
		this();
		setNombre(nombre);
		setEnergia(energia);
		setColor(color);
		setPosicion(posicion);
	}

	public Personaje(Personaje personaje) {
		this();
		if (personaje == null) {
			throw new NullPointerException("No puedo copiar un personaje nulo.");
		}
		nombre = personaje.getNombre();
		energia = personaje.getEnergia();
		color = personaje.getColor();
		posicion = new Posicion(personaje.posicion);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("El nombre del personaje no puede ser nulo.");
		}
		this.nombre = nombre;
	}

	public int getEnergia() {
		return energia;
	}

	private void setEnergia(int energia) {
		if (energia < MIN_ENERGIA) {
			throw new IllegalArgumentException("El valor de la energia no puede ser menor que el mínimo establecido.");
		} else if (energia > MAX_ENERGIA) {
			throw new IllegalArgumentException("El valor de la energia no puede ser mayor que el máximo establecido.");
		}
		this.energia = energia;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		if (color == null) {
			throw new NullPointerException("El color del personaje no puede ser nulo.");
		}
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("La posición del personaje no puede ser nula.");
		}
		this.posicion = posicion;
	}

	public void chocar(int posiblePerdida) {
		setEnergia(energia - posiblePerdida);
	}

	public void charlar(int posibleGanancia) {
		setEnergia(energia + posibleGanancia);
	}

	public void mover(int x, int y) throws OperationNotSupportedException{
		try {
			posicion.setX(posicion.getX() + x);
			posicion.setY(posicion.getY() + y);
		} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException("Movimiento no válido: " + e.getMessage());
		}
	}

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new IllegalArgumentException("La dirección no puede ser nula.");
		}
		if (pasos <= 0) {
			throw new IllegalArgumentException("El número de pasos debe ser mayor que cero.");
		}
		String movimientoNoValido = "Movimiento no válido: ";
		switch (direccion) {
			case ARRIBA:
				try {
					posicion.setX(posicion.getY() + pasos);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(movimientoNoValido + e.getMessage());
				}
				break;
			case ABAJO:
				try {
					posicion.setX(posicion.getY() - pasos);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(movimientoNoValido + e.getMessage());
				}
				break;
			case DERECHA:
				try {
					posicion.setX(posicion.getX() + pasos);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(movimientoNoValido + e.getMessage());
				}
				break;
			case IZQUIERDA:
				try {
					posicion.setX(posicion.getX() - pasos);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(movimientoNoValido + e.getMessage());
				}
				break;
			default:
				break;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, energia, nombre, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(color, other.color) && energia == other.energia && Objects.equals(nombre, other.nombre)
				&& Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return String.format("nombre=%s, energia=%s, color=%s, posicion=(%s)", nombre, energia, color, posicion);
	}

}
~~~

## Ejercicios

- **Persona**

  Debes implementar una clase `Persona`como muestra el diagrma de clases. Por simplificar considera todos los atributos como `String`. Controla las excepciones cuando se pasan valores nulos. Los métodos `setX`son públicos por motivos didácticos que veremos en el próximo ejercicio. Cuando la hayas implementado debes reflexionar sobre si crees que es un buen diseño o no (te puede servir de ayuda la advertencia que te muestra el plugins **Sonarlint**). Crea también una clase en la que puedas probar su creación con los diferentes constructores y su uso.

  <div align="center">
  <img alt="Diagrama de clase de la clase Persona" src="imagenes/persona.png"/>
  </div>

  - Posible solución

    Una posible solución podría ser la siguiente:

    ###### Persona.java
    ~~~java
    package relacionclientela;

	import java.util.Objects;

	public class Persona {

		private String nombre;
		private String dni;
		private String fechaNacimiento;
		private String email;
		private String telefono;
		private String direccion;
		private String codigoPostal;
		private String localidad;

		public Persona(String nombre, String dni, String fechaNacimiento, String email, String telefono, String direccion,
				String codigoPostal, String localidad) {
			setNombre(nombre);
			setDni(dni);
			setFechaNacimiento(fechaNacimiento);
			setEmail(email);
			setTelefono(telefono);
			setDireccion(direccion);
			setCodigoPostal(codigoPostal);
			setLocalidad(localidad);
		}

		public Persona(Persona persona) {
			if (nombre == null) {
				throw new NullPointerException("La persona no puede ser nula.");
			}
			setNombre(persona.nombre);
			setDni(persona.dni);
			setFechaNacimiento(persona.fechaNacimiento);
			setEmail(persona.email);
			setTelefono(persona.telefono);
			setDireccion(persona.direccion);
			setCodigoPostal(persona.codigoPostal);
			setLocalidad(persona.localidad);
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			if (nombre == null) {
				throw new NullPointerException("El nombre no puede ser nulo.");
			}
			this.nombre = nombre;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			if (dni == null) {
				throw new NullPointerException("El DNI no puede ser nulo.");
			}
			this.dni = dni;
		}

		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			if (fechaNacimiento == null) {
				throw new NullPointerException("La fecha de nacimiento no puede ser nula.");
			}
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			if (email == null) {
				throw new NullPointerException("El emial no puede ser nulo.");
			}
			this.email = email;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			if (telefono == null) {
				throw new NullPointerException("El teléfono no puede ser nulo.");
			}
			this.telefono = telefono;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			if (direccion == null) {
				throw new NullPointerException("La dirección no puede ser nula.");
			}
			this.direccion = direccion;
		}

		public String getCodigoPostal() {
			return codigoPostal;
		}

		public void setCodigoPostal(String codigoPostal) {
			if (codigoPostal == null) {
				throw new NullPointerException("El código postal no puede ser nulo.");
			}
			this.codigoPostal = codigoPostal;
		}

		public String getLocalidad() {
			return localidad;
		}

		public void setLocalidad(String localidad) {
			if (localidad == null) {
				throw new NullPointerException("La localidad no puede ser nula.");
			}
			this.localidad = localidad;
		}

		@Override
		public int hashCode() {
			return Objects.hash(codigoPostal, direccion, dni, email, fechaNacimiento, localidad, nombre, telefono);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Persona other = (Persona) obj;
			return Objects.equals(codigoPostal, other.codigoPostal) && Objects.equals(direccion, other.direccion)
					&& Objects.equals(dni, other.dni) && Objects.equals(email, other.email)
					&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(localidad, other.localidad)
					&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
		}

		@Override
		public String toString() {
			return String.format(
					"nombre=%s, dni=%s, fechaNacimiento=%s, email=%s, telefono=%s, direccion=%s, codigoPostal=%s, localidad=%s",
					nombre, dni, fechaNacimiento, email, telefono, direccion, codigoPostal, localidad);
		}

	}
    ~~~

    ###### PruebaPersona.java
    ~~~java
	public class PruebaPersona {

		public static void main(String[] args) {
			Persona persona;
			persona = new Persona("José Ramón", "11X",  "01/01/2000", "950112233", "jr@gmail.com", "C/JR 1", "04004", "Almería");
			System.out.println(persona);
		}

	}
    ~~~

- **Persona refactorizado**

  Después de analizar los problemas del diseño anteriorte sugiero que implementes la clase `Persona` de la siguiente manera. Al igual que en el ejemplo anterior he dejado todos los métodos `setX` públicos para hacer que las clase sean mutables (aunque en la realidad eso no sería lo más adecuado) y te propongo que en la implementación evites el problema del aliasing que pudiese surgir. Crea también una clase en la que puedas probar su creación con los diferentes constructores y su uso, y analiza las diferencias con la solución anterior.

  <div align="center">
  <img alt="Diagrama de clase de la clase Persona" src="imagenes/persona1.png"/>
  </div>

  - Posible solución

    Una posible solución podría ser la siguiente:

    ###### DireccionPostal.java
    ~~~java
    import java.util.Objects;

	public class DireccionPostal {

		private String direccion;
		private String codigoPostal;
		private String localidad;

		public DireccionPostal(String direccion, String codigoPostal, String localidad) {
			setDireccion(direccion);
			setCodigoPostal(codigoPostal);
			setLocalidad(localidad);
		}

		public DireccionPostal(DireccionPostal direccionPostal) {
			if (direccionPostal == null) {
				throw new NullPointerException("La direción postal no puede ser nula.");
			}
			setDireccion(direccionPostal.direccion);
			setCodigoPostal(direccionPostal.codigoPostal);
			setLocalidad(direccionPostal.localidad);
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			if (direccion == null) {
				throw new NullPointerException("La direción no puede ser nula.");
			}
			this.direccion = direccion;
		}

		public String getCodigoPostal() {
			return codigoPostal;
		}

		public void setCodigoPostal(String codigoPostal) {
			if (codigoPostal == null) {
				throw new NullPointerException("El código postal no puede ser nulo.");
			}
			this.codigoPostal = codigoPostal;
		}

		public String getLocalidad() {
			return localidad;
		}

		public void setLocalidad(String localidad) {
			if (localidad== null) {
				throw new NullPointerException("La localidad no puede ser nula.");
			}
			this.localidad = localidad;
		}

		@Override
		public int hashCode() {
			return Objects.hash(codigoPostal, direccion, localidad);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DireccionPostal other = (DireccionPostal) obj;
			return Objects.equals(codigoPostal, other.codigoPostal) && Objects.equals(direccion, other.direccion)
					&& Objects.equals(localidad, other.localidad);
		}

		@Override
		public String toString() {
			return String.format("direccion=%s, codigoPostal=%s, localidad=%s", direccion, codigoPostal, localidad);
		}

	}
    ~~~

    ###### DatosContaco.java
    ~~~java
    import java.util.Objects;

	public class DatosContacto {
		private String telefono;
		private String email;
		private DireccionPostal direccionPostal;

		public DatosContacto(String telefono, String email, DireccionPostal direccionPostal) {
			setTelefono(telefono);
			setEmail(email);
			setDireccionPostal(direccionPostal);
		}

		public DatosContacto(DatosContacto datosContacto) {
			if (datosContacto == null) {
				throw new NullPointerException("Los datos de contacto no pueden ser nulos.");
			}
			setTelefono(datosContacto.telefono);
			setEmail(datosContacto.email);
			setDireccionPostal(datosContacto.direccionPostal);
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			if (telefono == null) {
				throw new NullPointerException("El teléfono no puede ser nulo.");
			}
			this.telefono = telefono;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			if (email == null) {
				throw new NullPointerException("El email no puede ser nulo.");
			}
			this.email = email;
		}

		public DireccionPostal getDireccionPostal() {
			return new DireccionPostal(direccionPostal);
		}

		public void setDireccionPostal(DireccionPostal direccionPostal) {
			if (direccionPostal == null) {
				throw new NullPointerException("La dirección postal no puede ser nula.");
			}
			this.direccionPostal = new DireccionPostal(direccionPostal);
		}

		@Override
		public int hashCode() {
			return Objects.hash(direccionPostal, email, telefono);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DatosContacto other = (DatosContacto) obj;
			return Objects.equals(direccionPostal, other.direccionPostal) && Objects.equals(email, other.email)
					&& Objects.equals(telefono, other.telefono);
		}

		@Override
		public String toString() {
			return String.format("telefono=%s, email=%s, direccionPostal=(%s)", telefono, email, direccionPostal);
		}

	}
    ~~~

    ###### DatosPersonales.java
    ~~~java
    import java.util.Objects;

	public class DatosPersonales {
		private String nombre;
		private String dni;
		private String fechaNacimiento;

		public DatosPersonales(String nombre, String dni, String fechaNacimiento) {
			setNombre(nombre);
			setDni(dni);
			setFechaNacimiento(fechaNacimiento);
		}

		public DatosPersonales(DatosPersonales datosPersonales) {
			if (datosPersonales == null) {
				throw new NullPointerException("Los datos personales no pueden ser nulos.");
			}
			setNombre(datosPersonales.nombre);
			setDni(datosPersonales.dni);
			setFechaNacimiento(datosPersonales.fechaNacimiento);
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			if (nombre == null) {
				throw new NullPointerException("El nombre no puede ser nulo.");
			}
			this.nombre = nombre;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			if (dni == null) {
				throw new NullPointerException("El DNI no puede ser nulo.");
			}
			this.dni = dni;
		}

		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			if (fechaNacimiento == null) {
				throw new NullPointerException("La fecha de nacimiento no puede ser nula.");
			}
			this.fechaNacimiento = fechaNacimiento;
		}

		@Override
		public int hashCode() {
			return Objects.hash(dni, fechaNacimiento, nombre);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DatosPersonales other = (DatosPersonales) obj;
			return Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
					&& Objects.equals(nombre, other.nombre);
		}

		@Override
		public String toString() {
			return String.format("nombre=%s, dni=%s, fechaNacimiento=%s", nombre, dni, fechaNacimiento);
		}

	}
    ~~~

    ###### Persona.java
    ~~~java
    import java.util.Objects;

	public class Persona {

		private DatosPersonales datosPersonales;
		private DatosContacto datosContacto;

		public Persona(DatosPersonales datosPersonales, DatosContacto datosContacto) {
			setDatosPersonales(datosPersonales);
			setDatosContacto(datosContacto);
		}

		public Persona(Persona persona) {
			if (persona == null) {
				throw new NullPointerException("La persona no puede ser nula.");
			}
			setDatosPersonales(datosPersonales);
			setDatosContacto(datosContacto);
		}

		public DatosPersonales getDatosPersonales() {
			return new DatosPersonales(datosPersonales);
		}

		public void setDatosPersonales(DatosPersonales datosPersonales) {
			if (datosPersonales == null) {
				throw new NullPointerException("Los datos personales no pueden ser nulos.");
			}
			this.datosPersonales = new DatosPersonales(datosPersonales);
		}
		public DatosContacto getDatosContacto() {
			return new DatosContacto(datosContacto);
		}

		public void setDatosContacto(DatosContacto datosContacto) {
			if (datosContacto == null) {
				throw new NullPointerException("Los datos de contacto no pueden ser nulos.");
			}
			this.datosContacto = new DatosContacto(datosContacto);
		}

		@Override
		public int hashCode() {
			return Objects.hash(datosContacto, datosPersonales);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Persona other = (Persona) obj;
			return Objects.equals(datosContacto, other.datosContacto)
					&& Objects.equals(datosPersonales, other.datosPersonales);
		}

		@Override
		public String toString() {
			return String.format("datosPersonales=(%s), datosContacto=(%s)", datosPersonales, datosContacto);
		}

	}
    ~~~

    ###### PruebaPersona.java
    ~~~java
    public class PruebaPersona {

		public static void main(String[] args) {
			Persona persona;
			DireccionPostal direccionPostal = new DireccionPostal("C/JR 1", "04004", "Almería");
			DatosContacto datosContacto = new DatosContacto("950112233", "jr@gmail.com", direccionPostal);
			DatosPersonales datosPersonales = new DatosPersonales("José Ramón", "11X",  "01/01/2000");
			persona = new Persona(datosPersonales, datosContacto);
			System.out.println(persona);
		}

	}
    ~~~
