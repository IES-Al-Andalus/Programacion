# Introducción a la programación en Java

En este apartado encontrarás una **introducción a la programación en Java**. He pretendido hacer una introducción teórica que os ayude, a modo de resumen, a comprender los principales conceptos utilizados en Java. En este apartado no hablaremos de Programación Orientada a Objetos (todo esto en la medida de lo posible, pues Java es un lenguaje orientado a objetos y todo se basa en dichos conceptos), ya que dichos conceptos los veremos en otros apartados. El objetivo de este apartado es que creemos programas sencillos escritos en Java, utilizando sus características básicas.

Al igual que en otros apartados, el objetivo principal es que tengáis una amplía gama de ejercicios, con sus respectivas posibles soluciones, sobre la **introducción a la programación en Java**.

**José Ramón Jiménez Reyes**

 > ![@JRJimenezReyes](../assets/images/github.png) @JRJimenezReyes

 > ![joseramon.jimenez@iesalandalus.org](../assets/images/mail.png) joseramon.jimenez@iesalandalus.org

## Contenidos
- [¿Qué es Java?](#qu-es-java)
- [Primer programa en Java](#primer-programa-en-java)
- [Identificadores](#identificadores)
- [Tipos de datos](#tipos-de-datos)
- [Literales](#literales)
- [Variables](#variables)
- [Operadores](#operadores)
- [Comentarios](#comentarios)
- [Sentencias](#sentencia)
- [Ejercicios](#ejercicios)

## ¿Qué es Java?
Java es un lenguaje de programación creado a principios de los 80 por **James Gosling**, ingeniero de **Sun Microsystems**. Al principio lo llamó OAK, aunque luego le cambiaron el nombre a Java (cuenta la leyenda que le dieron este nombre ya que Java es un tipo de café asiático y precisamente el café que bebían en el desarrollo del mismo). Actualmente ha sido adquirido por la empresa **Oracle** y es un lenguaje que no para de evolucionar.

Las **características** que tuvieron en mente a la hora de crear Java fueron las siguientes:
- **Orientado a Objetos**: de todo esto hablaremos en mucha más profundidad en los siguientes apartados.
- **Simple**: aunque se basaron en lenguajes como C y C++, intentaron reducir la complejidad de los mismos en su diseño.
- **Distribuido**: proporcionando librerías para su fácil uso en aplicaciones en red.
- **Multihilo**: permitiendo la utilización de hebras, que son procesos mucho más ligeros que la creación de nuevos procesos, para la ejecución de varias tareas a la vez.
- **Seguro**: ya que es la JVM la encargada de gestionar toda la memoria y no el programador.
- **Multiplataforma**: fue uno de los principales objetivos en su diseño, ya que se crea un código intermedio que luego puede ser ejecutado en cualquier plataforma que tenga instalada una JVM. Este es el dicho "write once - run everywhere" (escríbelo una vez y ejecútalo donde sea).

Java no sólo es un lenguaje de programación, sino que también lo podríamos considerar como un conjunto de tecnologías, entre las que podemos destacar (podrás haber visto estas tecnologías escritas con un "2" entre medías, pero eso cambió como veremos posteriormente):
- **JSE**: Java Standard Edition, que es la tecnología en la que nos basaremos y que se dedica principalmente al desarrollo de aplicaciones de escritorio.
- **JEE**: Java Enterprise Edition, que es la utilizada para la creación de aplicaciones empresariales, servicos web, etc.
- **JME**: Java Micro Edition, que es la utilizada para el desarrollo de aplicaciones para dispositivos con menor capacidad de procesamiento y/o almacenamiento.

Desde que surgió Java hasta el día de hoy podemos encontrar diferentes versiones del lenguaje:
- **JDK 1.0**: Nacimiento de Java desde el proyecto OAK.
- **JDK 1.1**: Se añaden nuevas librerías como AWT, JDBC, etc.
- **J2SE 1.2**: Se incluye Swing.
- **J2SE 1.3**: Se mejora el rendimiento y se añade JNDI.
- **J2SE 1.4**: Se mejoran las expresiones regulares y se añaden assert.
- **J2SE 5**: Sufre cambios mayores por lo que se cambia la numeración. Se añade: autoboxing, generics, varargs, etc.
- **JSE 6**: Se elimina el 2 del nombre. Se da soporte para lenguajes de scripting, se vuelve a mejorar el rendimiento y se añade soporte para JDBC 4.0.
- **JSE 7**: Se añade soporte para múltiples lenguajes. Se añaden cambios en el lenguaje como el uso de String en la sentencia swicth, try with resouces, etc.
- **JSE 8**: Se añade el soporte de las funciones lambda (entre otras) para soportar la programación funcional.

Java es un lenguaje interpretado, o también llamado precompilado. Partiendo de un archivo fuente `.java`, lo compilamos para obtener un fichero `.class`, que es un archivo que aún no es ejecutable por el SO pero que sí entiende la Máquina Virtual de Java (JVM). Ese fichero `.class` ahora ya podemos ejecutarlo en cualquier SO o plataforma que tenga instalada una JVM, que será la que lea el fichero `.class` y lo vaya interpretando para ser ejecutado.

Para el desarrollo de aplicaciones en Java y su posterior ejecución disponemos de dos componentes principales:
- **JDK**: Es el kit de desarrollo y en el que podemos encontrar, entre otros, el compilador de java que se encarga de traducir el código fuente a un código intermedio que posteriormente podrá ser ejecutado por la JVM (máquina virtual de Java) que tengamos instalada en nuestro sistema.
- **JRE**: Es el entorno de ejecución de Java específico de cada plataforma y en el que simplemente vienen las librerías y la JVM para nuestra plataforma y que permite ejecutar las aplicaciones anteriormente compiladas con el kit de desarrollo (aunque el kit de desarrollo también contiene dicha JVM).

Para poder instalar correctamente el JSE en nuestro sistema (elegiremos la descarga del JDK ya que es el componente que necesitaremos para poder desarrollar aplicaciones Java), no voy a profundizar y, simplemente os remito a la web oficial de Oracle donde poder descargarlo para cada plataforma y en la que también podéis encontrar la documentación para realizar dicha instalación en cada una de ellas. La versión que utilizaremos es la versión JSE 8. [Descargar JSE](https://www.oracle.com/technetwork/java/javase/downloads/index.html).


## Primer programa en Java

Para realizar nuestro primer programa en java, necesitaremos tener instalado, correctamente configurado el JDK en nuestro SO y, por ahora, disponer de un editor de texto.

Cuando empezamos a familiarizarnos con cualquier lenguaje de programación, nuestro primer programa es el famoso **Hola Mundo**. En nuestro caso no iba a ser menos. Por tanto, abriremos un editor de texto y copiaremos el siguiente código y lo guardaremos en una carpeta con el nombre `HolaMundo.java`.
~~~java
public class HolaMundo {

	public static void main(String[] args) {
		System.out.println("Hola mundo!!!");
	}

}
~~~

Una vez guardado con el nombre `HolaMundo.java`, simplemente deberemos compilarlo mediante el comando `javac`, pasando como argumento el nombre del archivo, que nos generará el archivo `HolaMundo.class`. Este archivo corresponde con nuestro programa compilado pasado a bytecodes y será el archivo que podremos pasar a cualquier sistema que tenga instalada la JVM para poder ejecutarlo.

Para ejecutarlo, simplemente ejecutaremos el comando `java` pasando como argumento el nombre del archivo (sin la extensión `.class`).

En la siguiente imagen se muestra cómo comprobar la versión que tenemos instalada, tanto de `javac` como de `java` (que generalmente serán la misma). Luego se muestra el contenido del fichero. Se compila dicho fichero y se muestra cómo se genera el archivo `.class`. Y finalmente cómo se ejecuta el fichero generado y la salida que produce el mismo.

<div align="center">
<img alt="Compilación y ejecución de HolaMundo" src="imagenes/HolaMundo.png"/>
</div>

Puede ser que te haya resultado algo engorroso y que seguramente estés pensando que si siempre hay que hacerlo así, que cuando sea un programa más complejo eso es imposible, etc. Pero la buena noticia es que esto no es así ya que afortunadamente hoy existen los llamados Entornos de Desarrollo Integrados (IDE) que nos facilitan la tarea. Gracias a estos IDEs la escritura de un programa es muy sencilla ya que te van haciendo sugerencias a la hora de escribir, tiene atajos de teclado para sentencias muy comunes, la compilación es automática cada vez que se guarda, nos permite depurar nuestros programas mediante la ejecución paso a paso, permiten la refactorización del código, etc, etc.

Los entornos más populares para el desarrollo de aplicaciones java son:
- **Netbeans** desarrollado por Oracle, aunque actualmente pertenece a la Fundación Apache. [Descargar Netbeans](https://netbeans.org/).
- **Eclipse** desarrollado por la fundación Eclipse. [Descargar Eclipse](https://www.eclipse.org/).

Ambos entornos de desarrollo son multiplaforma por lo que podemos ejecutarlos en nuestro SO preferido y son muy parecidos. Las prestaciones de ambos son muy similares y ambos poseen una gran cantidad de añadidos que podemos utilizar. Yo, personalmente, prefiero Eclipse, pero para gustos colores.

Ambos IDEs permiten crear un proyecto Java nuevo, para luego añadir una nueva Clase en la que podemos marcar que añada el método `main` para que dicha clase podamos ejecutarla. Al hacerlos así, se nos creará un esqueleto con todo lo necesario para que podamos ir añadiendo sentencias entre las llaves que se abren y se cierran después de la definición del método `main`. Sé que esto es hacer un gran acto de fe, pero con estas simples acciones podremos ir creando nuestros pequeños programas Java que nos permitirán ir familiarizándonos con este lenguaje y para lo que te daré las pautas adecuadas en los siguientes apartados.

Por ahora, lo único importante que debes saber es que el nombre de la Clase (el nombre que va justo después de la palabra reservada `class`) debe coincidir con el nombre del archivo `.java`. Aunque cuando el IDE te pregunta por el nombre de la clase, eso ya lo hace por tí.

A continuación te muestro un vídeo de cómo crear el programa `HolaMundo` en **Eclipse**.

<div align="center">
<video width="600" controls="controls">
<source type="video/mp4" src="videos/HolaMundoEclipse.mp4"></source>
</video>
</div>

También te muestro un vídeo de cómo crear el programa `HolaMundo` en **Netbeans**.

<div align="center">
<video width="600" controls="controls">
<source type="video/mp4" src="videos/HolaMundoNetBeans.mp4"></source>
</video>
</div>

Como podéis apreciar, el proceso es muy sencillo y muy parecido en ambos IDEs. Ahora sólo nos queda empezar a programar!!!


## Identificadores

Los identificadores no son más que los nombres que les damos a algunos elementos de nuestro programa (variables, clases, métodos, etc) para poder referirnos a ellos fácilmente.

Para nombrar un identificador debemos seguir las siguientes reglas:
- No pueden ser una palabra reservada del lenguaje (que ahora veremos cuáles son).
- El primer carácter de un identificador debe ser una letra, un número o los símbolos `_` o `$`.
- Puede incluir números.
- Se distingue entre mayúsculas y minúsculas.
- Aunque no es obligatorio, no debemos utilizar tildes ni la `ñ`.

Veamos ahora la lista de **palabras reservadas** que no podemos utilizar como identificador para evitar ambigüedades:

|abstract|continue|for|new|swicth|
|assert|default|goto|package|synchronized|
|boolean|do|if|private|this|
|break|double|implements|protected|throw|
|byte|else|import|public|throws|
|case|enum|instanceof|return|transient|
|catch|extends|int|short|try|
|char|final|interface|static|void|
|class|finally|long|strictfp|volatile|
|const|float|native|super|while|

Anteriormente he mencionado las reglas para nombrar un identificador correctamente y que son de obligado cumplimiento. Sin embargo, en el mundo de java se sigue una convención para el nombrado de los diferentes elementos del lenguaje, que debemos seguir. Esta convención no es obligatoria pero sí es conveniente que la utilicemos y así con sólo ver un identificador sabremos a qué elemento se está refiriendo. En la siguiente tabla os muestro dicha convención para cada uno de los elementos (de los que hablaremos posteriormente).

|Tipo de identificador|Convención|Ejemplo|
|----------------------------------------|
|Clase|Empieza por una lerta mayúscula y cóntinua por minúsculas. Si es la concatenación de varias palabras, cada una de ellas empieza también por letra mayúscula.|`Hola`, `HolaMundo`|
|Variable o Método|Se nombra todo en minúsculas. Si es la concatenación de varias palabras, cada una de ellas empieza también por letra mayúscula.|`sueldo`, `numeroCaracteres`|
|Constante|Se nombra todo en mayúsculas. Si es la concatenación de varias palabras, éstas se separan por el símbolo `_`|`PI`, `CANTIDAD_MAXIMA`|

Ni que decir tiene que **los identificadores deben ser lo suficientemente significativos** para que nos transmitan el cometido de los mismos.

## Tipos de datos

En Java existen dos grandes categorías de tipos de datos:
- **primitivos**: Son los tipos de datos básicos en java y serán los que veamos en este apartado. Este tipo de datos vienen definidos de forma implícita en java.
- **referenciados**: Son los tipos de datos que refenrencian a un objeto y los arrays. A este tipo de datos nos referiremos en apartados posteriores.

Un tipo de dato primitivo indica la cantidad de memoria que deberá reservar el compilador para almacenar una variable de ese tipo. Java es un lenguaje fuertemente tipado por lo que es necesario definir el tipo de dato de cada una de las variables.

Los tipos de datos primitivos se pueden agrupar en: caracter, numérico, decimal y lógico. En la siguiente tabla se muestran los diferentes tipos de datos primitivos, su tamaño, rango y el valor por defecto de cada uno de ellos:

|Tipo de dato|Tamaño|Rango|Valor por defecto|
|-------------------------------------------|
|`char`|2 bytes|\u0000 a \uFFFF|\u0000|
|`byte`|1 byte|-128 a 127|0|
|`short`|2 bytes|-32768 a 32767|0|
|`int`|4 bytes|-2147483648 a 2147483647|0
|`long`|8 bytes|-9223372036854775808 a 9223372036854775807|0|
|`float`|4 bytes|<img src="https://latex.codecogs.com/svg.latex?\Large&space;\pm3.4*10^{-38}&space;a&space;\pm3.4*10^{38}"/>|0.0|
|`double`|8 bytes|<img src="https://latex.codecogs.com/svg.latex?\Large&space;\pm1.8*10^{-308}&space;a&space;\pm1.8*10^{308}"/>|0.0|
|`boolean`|1 byte|`true` o `false`|`false`|

Aunque `String` no es un tipo de dato primitivo ya que es una referencia a un objeto de la clase `String`, simplemente lo nombro ya que a veces lo utilizaremos.

## Literales

Los literales son valores constantes que podemos utilizar para asignar a una variable o como parte de una expresión. Cada tipo de dato tiene su forma para expresarlo. En la siguiente tabla muestro cómo expresar cada uno de ellos.

|Tipo de dato| Representación|
|----------------------------|
|`char`|Encerrados entre `''`|
|`byte`, `shor`, `int`|Se representan por los dígitos del número.|
|`long`|Como los anteriores pero terminados en `l` o `L`|
|`double`|Se representan por los dígitos del número. Para separar la parte entera de la decimal se utiliza el `.`. También se puede representar mediante su notación exponencial utilizando el símbolo `e`|
|`float`|Como los anteriores pero terminados en `f` o `F`|
|`boolean`|`true` o `false`|
|`String`|Encerrados entre `""`|

## Variables
Una variable en java es una posición de memoria en la que se almacenará un valor del tipo de dato de la misma. Se representa por su identificador y en el programa nos refererimos a ella mediante dicho identificador. El valor que contenga la variable podrá cambiar a lo largo de la vida del programa.

En java todas las variables deben ser declaradas antes de ser utilizadas. Para declarar una variable indicaremos su tipo y el identificador de la misma. También es posible declarar varias variables del mismo tipo en la misma sentencia, separando los identificadores de las mismas por coma. La declaración, al ser una sentencia como ya veremos, debe acabar con un `;`. Aquí muestro algunos ejemplos de declaración de variables.
~~~java
  int posicion;
  double precision;
  boolean esPrimo;
  float x, y, distancia;
~~~

Hasta que no declaramos una variable ésta no puede ser utilizada en nuestro programa. Al ser java un lenguaje fuertemente tipado no permite hacerlo y nos dará un error de compilación (o nos lo avisará nuestro IDE).

Justo después de declarar una variable, ésta toma el valor por defecto del tipo asociado, aunque no podremos utilizar la misma hasta que no le asignemos un valor. También es posible asignar un valor a la hora de declarar una variable por medio del operador `=`. Aquí muestro un ejemplo de ello.
~~~java
  int numeroCartasRestantes = 40;
  float irpf = 21f, retencion;
~~~

Cuando se declara una variable se reserva el espacio necesario para almacenar el tipo de dato de la misma y este espacio se libera cuando el programa sale del ámbito de la misma. Por ahora nuestros programas estarán todos contenidos dentro del método `main`. Por tanto, el ámbito de una variable será el bloque al que pertenece, es decir las llaves más cercanas entre las que está encerrada dicha variable. Esto quedará más claro cuando empecemos a hablar de sentencias, pero es importante que lo recordéis.

## Operadores
Un operador es un símbolo utilizado para componer una expresión, relacionando uno, dos o tres operandos (en el caso de java). Por tanto, una primera clasificación de los operadores podría ser: **unarios**, **binarios** y **ternarios**. Los operandos podrán ser variables o literales. La expresión evaluará a un valor dependiendo del tipo de dato de los operandos y del operador en cuestión.

Otra clasificación de los operadores en java es la siguiente (sólo mostraré los que utilizaremos por ahora, para no liar):

**Operadores relacionales**

Operador|Significado
------------|--------------
`>` | Mayor que
`<`| Menor que
`==`| Igual que
`<=`| Menor o igual que
`>=`| Mayor o igual que
`!=`| Distinto que

**Operadores lógicos**

Operador|Significado
------------|--------------
`&&` ó `&`| Conjunción (y)
`||` ó `|` | Disyunción (o)
`!` | Negación (no)

La diferencia entre el operador `&&` y el operador `&` es que el primero evalúa en cortocircuito y el segundo no. Por lo que si el operando izquierdo evalúa a `false` ya no continúa evaluando ya que la expresión evaluará a `false`, evalúe a lo que evalúe el operando derecho. El segundo evalúa ambos operandos.

La diferencia entre el operador `||` y el operador `|` es que el primero evalúa en cortocircuito y el segundo no. Por lo que si el operando izquierdo evalúa a `true` ya no continúa evaluando ya que la expresión evaluará a `true`, evalúe a lo que evalúe el operando derecho. El segundo evalúa ambos operandos.

**Operadores algebraicos**

Operador|Significado
------------|--------------
`+`| Suma
`-` |Resta
`*`|Multiplicación
`/`| División
`^`|Potenciación
`%`| Módulo (resto de la división entera)
`++`|Incrementar una unidad
`--`|Decrementar una unidad

La división realizará la división entera o real dependiendo del tipo de cada uno de los operandos. Para que realice la división entera ambos operandos deberán ser numéricos (`int` o `long`). Si uno de ellos no lo es realizará la división real.

Los operadores `++` y `--` pueden ser **prefijos** o **postfijos**. Esto quiere decir que realizará la operación de incremento o decremento antes de evaluar la expresión a la que pertenecen o después. Por ejemplo:
~~~java
  ...
  int x = 3;
  boolean resultado;
  resultado = ++x * 2 == 6  //resultado será false, x valdrá 4 después de la ejecución
  resultado = x++ * 2 == 8  //resultado será true, x valdará 5 después de la ejecución
  ...
~~~
En las expresiones aritméticas debemos tener en cuenta que el compilador siempre intentará hacer una conversión implícita de los tipos de datos de los operadores y los intentará convertir al de mayor precisión:
- Si hay un `double`, el otro lo convierte a `double`.
- Si no, pero hay un `float`, el otro lo convierte a `float`.
- Si no, pero hay un `long`, el otro lo convierte a `long`.
- En caso contrario los convierte a `int`.

También podemos hacer conversiones explícitas mediante el uso del **casting**, que no es más que anteponer al operando o expresión el tipo de dato al que queremos convertir encerrado entre paréntesis. Esta conversión explícita o **casting** puede conllevar pérdida de información si estamos intentado hacer la conversión de un tipo de dato de mayor precisión a uno de menor. Incluso algunas conversiones ni siquiera se podrán realizar y lanzarán un error.
~~~java
  ...
  int resultado, op1 = 2;
  float op2 = 5f;
  resultado = op1 / op2;  //Esta operación daría un error ya que no se puede llevar a cabo la conversión
  resultado = op1 / (int)op2; //resultado sería 0 ya que haría la división entera
  ...
~~~

**Operadores de asignación**

Operador|Significado
--------|-----------
`=`|Asignación
`+=`|Sumar el valor y asignar
`-=`|Restar el valor y asignar
`*=`|Multiplicar por el valor y asignar
`/=`|Dividir por el valor y asignar

Los operadores de asignación para que tengan sentido deben tener una variable como operando izquierdo y lo que hacen es cambiar el valor de dicha variable.

**Operador de concatenación de cadenas** `+`

**Precedencia de evaluación**

A la hora de evaluar una expresión debemos tener en cuenta:
- Lo que esté encerrado entre paréntesis es lo primero que se evalúa.
- Seguidamente evaluamos los operadores de mayor prioridad a menor prioridad.
- A igual prioridad los operadores se evalúan de izquierda a derecha.
- Los operadores de igualdad son los de menor prioridad.
- La prioridad de los demás operadores, de mayor a menor es la que sigue:
  - `++`, `--`, `!`, `+` (unario), `-` (unario)
  - `*`, `/`, `%`
  - `+`, `-`
  - `<`, `<=`, `>`, `>=`
  - `==`, `!=`
  - `&`
  - `^`
  - `|`
  - `&&`
  - `||`

## Comentarios

Los comentarios son anotaciones que se hacen en los programas para aclarar algún tipo de funcionalidad y que son ignorados por el compilador, pero que a veces vienen bien para explicar algún detalle. Es imprescindible **no abusar de los comentarios** ya que hacen el código difícil de leer. Es más, a veces ponemos comentarios para explicar qué hace un fragmento de código y eso nos está indicando que ese comentario sobra y que ese fragmento de código habría que sustituirlo por un método con un nombre explicativo de dicha función y con ello nuestro código queda **autodocumentado**. El mismo caso es cuando utilizamos nombres apropiados a nuestras variables; hacen que aumente la legibilidad del mismo y no es necesario acompañarla de un comentario para explicar dicho cometido.

En java existen tres tipos de comentarios:
- **De una sola línea**: El comentario se antecede de los caractes `//`.
- **De varias líneas**: El comentario se encierra entre los caracteres `/*` y `*/`.
- **Javadoc**: Son comentarios utilizados para generar documentación y el comentario se encierra entre los caracteres `/**` y `*/`. Por ahora, no utilizaremos este tipo de comentarios.

## Sentencias

En java, como en todos los lenguajes de programación, podemos encontrar tres grandes grupos de sentencias (esta clasificación es según mi parecer y para adecuarla a lo que hemos visto en el apartado sobre pseudocódigo, aunque otros programadores o programadoras hacen otras clasificaciones): **secuenciales**, **condicionales** y **repetitivas**. También hablaré escuentamente de las sentencias **que rompen el flujo de un programa**.

Todas las sentencias deben acabar con el símbolo `;`. Una sentencia no es más que una orden específica que da el programa para realizar una determinada acción.

Vamos a verlas una a una:

##### Sentencias secuenciales

Son las sentencias que se ejecutan una detrás de otra, secuencialmente. Por lo que el flujo del programa es lineal.

- **Asignación**: Como su nombre indica sirve para asignar valores a una variable. Utiliza cualquier operador de asignación de los vistos hasta el momento.

  Para realizar la asignación, primero se evalúa la expresión de la derecha y luego se asigna el resultado de dicha evaluación a la variable de la izquierda. La parte izquierda de la asignación debe ser una variable del mismo tipo de dato del resultante de la evaluación de la parte derecha.

- **Declaración**: Como ya hemos dicho, en java es necesario declarar cualquier variable que vayamos a utilizar. Ya hablamos de cómo se declaraban las variables. Simplemente comentar que una variable se puede declarar en cualquier punto del programa, pero que antes de utilizarla es necesario declararla.

- **Expresión**: Una expresión por si misma puede que no tenga sentido si no va ligada a una asignación. Pero hay casos en los que eso no es del todo cierto, ya que por ejemplo la sentencia `posicion++;` tiene un efecto sobre la variable `posicion`. Sin embargo, la sentencia, por poner un ejemplo, `posicion > 0;` por sí misma no tiene sentido, aunque es válida.

- **Bloque de sentencias**: Un bloque de sentencias es una agrupación de sentencias que se comportan como una unidad. Los bloques de sentencias se definen encerrando la sentencia o sentencias entre los caracteres `{` y `}`. Además los bloques de sentencias se pueden anidar uno dentro de otro, como se muestra en el siguiente ejemplo:
  ~~~java
	...
	{
		int numero = 5;
		...
		{
			int posicion = -1;
			...
		}
		...
	}
	...
  ~~~
  Como se puede apreciar hay un bloque dentro de otro. Si os acordáis, ya hablamos del ámbito de las variables. Pues en este ejemplo podemos apreciar que el ámbito de la variable `numero` es el bloque externo y el ámbito de la variable `posicion` es el bloque interno. Por lo que la variable `posicion` se creará al declararla en el bloque interno y se destruirá al salir de dicho bloque, por lo que fuera del mismo no nos podremos referir a ella. Sin embargo el ámbito de la variable `numero` es el bloque externo, por lo que dentro del bloque interno también podremos referirnos a ella ya que todavía sigue existiendo.

  En todo el programa es imprescindible respetar la indentación correcta, para que la legibilidad del código sea adecuada. Esto cobra vital importancia cuando hablamos de bloques y bloques anidadas, ya que si no nos será muy difícil distinguir qué sentencia pertenece a qué bloque.

- **Sentencia nula**: Aunque el caracter `;` es el terminador de sentencias, también se puede considerar como la sentencia nula, al igual que se podría considerar un bloque de sentencias vacío `{}`. Hay que tener cuidado con esto y, si se utiliza, hacerlo con cautela. En los ejercicios veremos algunos ejemplos del peligro que puede conllevar un mal uso de la misma.

- **Llamadas a métodos**: Una llamada a un método no es más que la instrucción que indica que se ejecute el código asociado a dicho método. No me quiero parar en esto ahora, pero ya hemos realizado una llamada a un método sin saberlo en nuestro primer programa: `System.out.println("Hola Mundo!!!")`. Como ya dije, esto es hacer un acto de fe, pero simplemente estamos ejecutando el método llamado `println`, perteneciente a la clase `System`, asociado a un miembro de dicha clase llamado `out`. Todo esto quedará más claro cuando hablemos de los conceptos relativos a la Orientación a Objetos.

  Dentro de esta categoría querría destacar los métodos encargados de la Entrada / Salida.

  - **Salida**: Para realizar una salida por consola podemos utilizar las siguientes sentencias (en otros apartados comprenderemos su significado):

      - `System.out.println(cadena)`: Imprime en la consola la cadena `cadena` y un salto de línea.
      - `System.out.print(cadena)`: Hace lo mismo pero no imprime el salto de línea.

    Como ya os comenté, en este apartado a veces nos va a hacer falta trabajar con cadenas (`String`), aunque no sean un tipo primitivo. Ya comentamos que los literales tipo cadena iban encerrados entre `""` y que podíamos concatenar (unir) cadenas mediante el operador `+`. Además, siempre que utilicemos el operador `+` con al menos un operando de tipo `String`, java convertirá el otro operando a otra cadena. Por lo que los siguientes ejemplos serían válidos:
    ~~~java
      ...
      int posicion = 0;
      String miCadena = "Hola";
      System.out.println(miCadena);     //Imprime el valor de la variable miCadena que es "Hola"
      System.out.println("Hola Mundo");  //Imprime el literal "Hola Mundo"
      System.out.println("La posición ocupada es: " + posicion) //Imprime "La posición ocupada es: 0"
      ...
    ~~~

  - **Lectura**: Para realizar la lectura desde teclado en java hay que tener conocimientos más avanzados y que ahora no vamos a detallar ya que podrían hacer perdernos en los detalles. Por ello he desarrollado una librería que os facilitará la vida y podréis llevarla a cabo por medio de una sola sentencia, evitando tener en cuenta todos los detalles asociados.

    La clase que he realizado se llama `Entrada` y la he metido dentro de un paquete llamado `utilidades`. Para poder utilizarla, simplemente tenéis que copiar el paquete (que para que nos entendamos, es un directorio) al directorio `src` de vuestro proyecto.

    En el siguiente vídeo podrás ver cómo integrar dicha clase en tu proyecto en **Eclipse**.

    <div align="center">
    <video width="600" controls="controls">
    <source type="video/mp4" src="videos/utilidadesEclipse.mp4"></source>
    </video>
    </div>

    En este otro hago lo mismo pero para **NetBeans**.

    <div align="center">
    <video width="600" controls="controls">
    <source type="video/mp4" src="videos/utilidadesNetBeans.mp4"></source>
    </video>
    </div>

    En el siguiente enlace adjunto el fichero `.zip` correspondiente al paquete `utilidades` que simplemente deberás descomprimir y copiar el directorio generado a tu IDE como ya hemos visto en los vídeos anteriores. [Descargar paquete utilidades](archivos/utilidades.zip)

    La clase `Entrada` nos ofrece los siguientes métodos para leer algunos de los tipos primitivos vistos en este apartado y que podemos utilizar de la siguiente forma (he mostrado la declaración y la asignación juntas para recalcar el tipo de dato al que podemos hacer la asignación, pero podría estar dividida en dos sentencias separadas):

    - `char caracter = Entrada.caracter();`
    - `String cadena = Entrada.cadena();`
    - `int entero = Entrada.entero();`
    - `long largo = Entrada.enteroLargo();`
    - `float real = Entrada.real();`
    - `double realDoble = Entrada.realDoble();`

##### Sentencias condicionales
Son sentencias que permiten alterar el flujo del programa y ejecutar unas sentencias u otras dependiendo del valor de una condición.

- **Condicional**: Permite evaluar una condición y ejecutar una serie de sentencias si dicha condición es verdadera u otras si es falsa.

  ~~~java
	if <condicion> {
		<sentenciasV>
	} else {
		<sentenciasF>
	}
  ~~~

  Evalúa la condición y si es verdadera ejecutará `<sentenciasV>` y si es falsa ejecuturá `<sentenciasF>`

  El bloque `else` no es obligatorio y en ese caso (la condición es falsa) no se ejecuta ninguna sentencia y se continúa por la sentencia después del bloque `if`.

  Si la condición es verdadera y en ese caso sólo queremos ejecutar una sóla sentencia, podríamos prescindir del bloque y eliminar los caracteres `{}`. Aunque esto no te lo aconsejo y es mejor que te acostumbres a poner las llaves. Esto también es aplicable a la parte `else`.

  Dentro de cada uno de los bloques, se podría utilizar otra sentencia `if` y es a lo que llamamos **if anidados**. Hay que tener en cuenta que cada `else` va asociado a su `if` más cercano que no tenga ya asociada una sentencia `if`.
  ~~~java
    ...
    if (numero > 0) {
	    if (numero % 2 == 0) {
	     	System.out.println("El número es par");
	    }
	    if (numero % 3 == 0) {   
	     	System.out.println("El número es divisible por 3");
	    } else {    //Este else va asociado al if (numero % 3 == 0)
	     	System.out.println("El número no es divisible por 3");
	    }
    }
    ...
  ~~~
  Otra construcción común es utilizar sentencias del tipo `if-else-if` como se puede ver en este otro ejemplo.
  ~~~java
    ...
    if (numero % 2 == 0) {
    	System.out.println("El número es par");
    } else if (numero % 3 == 0) {
    	System.out.println("El número no es par, pero es divisible por 3");
    } else {
    	System.out.println("El número no es par ni divisible por 3");
    }
    ...
  ~~~

- **Operador ternario**: Cuando hemos hablado de los operadores, no he querido hablaros del operador **ternario** para no liaros. Pero, llegados a este punto, toca hablar de él. Este operador ternario no es una sentencia de control de flujo como tal, pero evalúa a un determindo valor dependiendo de una condición. Se suele utilizar en las asignaciones, aunque también se puede utilizar en otras ocasiones que no me detendré ya que aún no hemos visto.

  La sintaxis es la siguiente: `<condicion> ? <expresionV> : <expresionF>`. Su funcionamiento es el siguiente:
    - Si la condición es verdadera, entonces evalúa a `expresionV`.
    - Si la condicion es falsa, entonces evalúa a `expresionF`

  ~~~java
    ...
    String mensaje;
    int numero;
    System.out.print("Introduce un número: ");
    numero = Entrada.entero();
    mensaje = (numero % 2 == 0) ? "El número es par" : "El número es impar";
    System.out.println(mensaje);
    ...
  ~~~

- **Selección múltiple**: En este caso se nos permite seleccionar las instrucciones a ejecutar dependiendo del valor de una expresión entera, caracter o cadena.

  ~~~java
	swicth (<expresion>) {
		case <valor1>:
			<sentencias1>
			break;
		case <valor2>, <valor3>:
			<sentencias23>
			break;
		<...>
		[ default:
			<otrasSentencias> ]
	}
  ~~~

  Al ejecutarse, se evalúa la expresión y se ejecuta la secuencia de instrucciones asociada con el valor correspondiente.

  Si una clausula `case` incluye varios valores, la secuencia de instrucciones asociada se debe ejecutar cuando la expresión evalúe a uno de esos valores.

  Opcionalmente, se puede agregar una opción final, denominada `default`, cuya secuencia de instrucciones asociada se ejecutará sólo si el valor almacenado en la variable no coincide con ninguna de las opciones anteriores. Esta clausula es opcional y se puede omitir.

  La sentencia `break` hace que no se siga haciendo comprobaciones.

  Para cada grupo de sentencias no es necesario utilizar los caracteres `{}` para delimitar los bloques de cada opción ya que en esta construcción cada bloque está perfectamente delimitado.

##### Sentencias repetitivas
Son sentencias que también alteran el flujo de un programa, permitiendo repetir una secuencia de instrucciones mientras se cumpla alguna condición. También son conocidas como bucles.

- **while**: Esta sentencia ejecuta otras sentencias mientras se cumpla una condición.

  ~~~java
	while <condicion> {
		<sentencias>
	}
  ~~~

  Se evalúa la condición y si es verdadera se ejecuta la secuencia de sentencias. En cada paso se vuelve a repetir el proceso.

  La secuencia de sentencias no tiene por qué ejecutarse ni una sola vez, si al principio la condición es falsa.

  Si la condición siempre es verdadera entraremos en un bucle infinito debido a que la secuencia de sentencias no hace que la condición llegue a ser falsa.

  ~~~java
    ...
    int numero;
    System.out.print("Introduce un número entre 0 y 10 (ambos inclusive): ");
    numero = Entrada.entero();
    while (numero < 0 || numero > 10) {
	    System.out.println("ERROR: El número debe estar comprendido entre 0 y 10 (ambos inclusive)");
	    System.out.print("Por favor vuelve a introducir un número válido: ");
	    numero = Entrada.entero();
    }
    System.out.println("El número introducido es: " + numero);
    ...
  ~~~

- **do-while**: Esta sentencia ejecuta un conjunto de sentencias también mientras una condición sea verdadera, pero esta condición se evalúa al final del bucle. Su sintaxis es la siguiente:

  ~~~java
	do {
		<sentencias>
	} while <condicion>;
  ~~~

  La secuencia de sentencias siempre se ejecuta al menos una vez, al contrario que en el bucle anterior. Notar que la condición termina con un ';'.

  También debemos modificar las variables que afectan a la condición en la secuencia de sentencias del cuerpo del bucle o de lo contrario se puede entrar en un bucle infinito.

  ~~~java
    ...
    int numero;
    do  {
	    System.out.print("Introduce un número entre 0 y 10 (ambos inclusive): ");
	    numero = Entrada.entero();
    } while (numero < 0 || numero > 10);
    System.out.println("El número introducido es: " + numero);
    ...
  ~~~

- **for**: Este tipo de bucle se utiliza para repetir una secuencia de sentencias un número determinado de veces, en su formato más general. Pero, como veremos, también se puede utilizar para otros menesteres, aunque para ello os aconsejo utilizar uno de los anteriores. Su sintaxis es:

  ~~~java
	for (<expresionInicializacion> ; <expresionCondicinal> ; <expresionIncremento>) {
		<sentencias>
	}
  ~~~

  Primero se evalúa `expresionInicializacion`. Esta expresión es opcional. En su formato más genérico, aquí inicializaremos la variable de control del bucle. También puede haber varias expresiones separadas por `,`.

  Luego se evalúa `expresionCondicinal` que debe ser una expresión lógica. Si evalúa a falso el bucle termina y en caso contrario se ejecutan la secuencia de sentencias. También es opcional y si no existiese sería como si evaluase a `true` y estaríamos hablando de un bucle infinito.

  Cuando se haya terminado de ejecutar la secuencia de sentencias, se evalúa `expresionIncremento` y se vuelve a evaluar `expresionCondicional` para volver a ejecutar o no la secuencia de sentencias. `expresionIncremento` también es opcional y también podría haber varias expresiones separadas por `,`.

  ~~~java
	...
	for (int i = 1; i <= 10; i++) {
		System.out.println("2 * " + i + " = " + 2 * i);
	}
	...
  ~~~

  ~~~java
    ...
    int numero;
    System.out.print("Introduce un número entre 0 y 10 (ambos inclusive): ");
    numero = Entrada.entero();
    for (; numero < 0 || numero > 10;) {
	    System.out.println("ERROR: El número debe estar comprendido entre 0 y 10 (ambos inclusive)");
	    System.out.print("Por favor vuelve a introducir un número válido: ");
	    numero = Entrada.entero();
    }
    System.out.println("El número introducido es: " + numero);
    ...
  ~~~

##### Sentencias que rompen el flujo del programa
  - `continue`, `break`, `goto`: Son sentencias que **no se deben utilizar** ya que rompen el flujo del programa de una forma inadecuada y que se pueden evitar mediante otros métodos más ortodoxos. La excepción a lo dicho, sería el uso de `break` en una sentencia `case`. Por tanto, no hablaré ni siquiera de ellas.

  - **Sentencias de control de errores**: Son sentencias que permiten controlar si se ha producido un error inesperado en el programa y actuar en consecuencia para que el programa no termine de forma inesperada. Es a lo que se llama **excepciones** en java y que veremos con detalle en otro apartado.

## Ejercicios

###### Sentencias secuenciales

- **Asignar valor a una variable y mostrarlo**

  Escribir un programa java que le asigne un valor cualquiera a una variable entera y lo muestre por pantalla.

  - Posible solución
    ~~~java
		public class AsignarValor {

			public static void main(String[] args) {
				int numero;
			    numero = 10;
			    System.out.println("El valor del número  es: " + numero);
			}

		}
    ~~~

    [Descargar posible solución para el programa **AsignarValor**](ejercicios/AsignarValor.java)

- **Lectura/Escritura de un número entero**

  Escribir un programa java que lea un número entero por teclado y nos lo muestre por pantalla.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class LecturaEscritura {

			public static void main(String[] args) {
				int numero;
				System.out.print("Introduce un número: ");
				numero = Entrada.entero();
				System.out.println("El número introducido es: " + numero);
			}

		}
    ~~~

    [Descargar posible solución para el programa **LecturaEscritura**](ejercicios/LecturaEscritura.java)

- **Mostrar el doble de un número real**

  Escribir un programa java que lea un número real por teclado y nos muestre por pantalla el doble del mismo.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class Doble {

			public static void main(String[] args) {
				float numero;
				System.out.print("Introduce un número real: ");
				numero = Entrada.real();
				System.out.println("El doble del número: " + numero + " es: " + 2 * numero);
			}

		}
    ~~~

    [Descargar posible solución para el programa **Doble**](ejercicios/Doble.java)

- **Mostrar el cuadrado de un número real doble**

  Escribir un programa java que lea un número real doble por teclado y nos muestre por pantalla el cuadrado del mismo.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class Cuadrado {

			public static void main(String[] args) {
				double numero;
				System.out.print("Introduce un número real doble: ");
				numero = Entrada.realDoble();
				System.out.println("El cuadrado del número: " + numero + " es: " + numero * numero);
			}

		}
    ~~~

    [Descargar posible solución para el programa **Cuadrado**](ejercicios/Cuadrado.java)

- **Hallar el perímetro de un rectángulo**

  Escribir un programa java que lea por teclado la base y la altura de un rectángulo y nos muestre por pantalla el perímetro del mismo.

  - Posible solución, aunque lo correcto hubiese sido validar que **la base y la altura fuesen mayores que cero**, pero eso lo veremos en ejercicios posteriores.
    ~~~java
		import utilidades.Entrada;

		public class PerimetroRectangulo {

			public static void main(String[] args) {
				float base, altura;
				System.out.print("Introduce la base del rectángulo: ");
				base = Entrada.real();
				System.out.print("Introduce la altura del rectángulo: ");
				altura = Entrada.real();
				float perimetro = 2 * base + 2 * altura;
				System.out.println("El perímetro del rectángulo es: " + perimetro);
			}

		}
    ~~~

    [Descargar posible solución para el programa **PerimetroRectangulo**](ejercicios/PerimetroRectangulo.java)

- **Calcular el área de un círculo**

  Escribir un programa java que lea por teclado el radio de un círculo y nos muestre por pantalla el área del mismo.

  - Posible solución, aunque lo correcto hubiese sido validar que el **radio fuese mayor que cero**, pero eso lo veremos en ejercicios posteriores.
    ~~~java
		import utilidades.Entrada;

		public class AreaCirculo {

			public static void main(String[] args) {
				double radio;
				System.out.print("Introduce el radio del círculo: ");
				radio = Entrada.realDoble();
				double area = Math.PI * radio * radio;
				System.out.println("El área del círculo es: " + area);
			}

		}
    ~~~

    [Descargar posible solución para el programa **AreaCirculo**](ejercicios/AreaCirculo.java)

###### Sentencias condicionales

- **Valor absoluto de un número**

  Escribir un programa java que lea por teclado un número y nos muestre por pantalla el valor absoluto del mismo.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class ValorAbsoluto {

			public static void main(String[] args) {
				int numero;
				System.out.print("Introduce un número: ");
				numero = Entrada.entero();
				int valorAbsoluto;
				valorAbsoluto = (numero < 0) ? -numero : numero;
				System.out.println("El valor absoluto de: " + numero + " es: " + valorAbsoluto);
			}

		}
    ~~~

    [Descargar posible solución para el programa **ValorAbsoluto**](ejercicios/ValorAbsoluto.java)

- **Número par o impar**

  Escribir un programa java que lea por teclado un número y nos indique por pantalla si es par o impar.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class ParImpar {

			public static void main(String[] args) {
				int numero;
				System.out.print("Introduce un número: ");
				numero = Entrada.entero();
				if (numero % 2 == 0) {
					System.out.println("El número: " + numero + " es par");
				} else {
					System.out.println("El número: " + numero + " es impar");
				}
			}

		}
    ~~~

    [Descargar posible solución para el programa **ParImpar**](ejercicios/ParImpar.java)

- **Número positivo o negativo**

  Escribir un programa java que lea por teclado un número y nos indique por pantalla si es positivo o negativo.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class PositivoNegativo {

			public static void main(String[] args) {
				int numero;
				System.out.print("Introduce un número: ");
				numero = Entrada.entero();
				if (numero >= 0) {
					System.out.println("El número: " + numero + " es positivo");
				} else {
					System.out.println("El número: " + numero + " es negativo");
				}
			}

		}
    ~~~

    [Descargar posible solución para el programa **PositivoNegativo**](ejercicios/PositivoNegativo.java)

- **Número entre 0 y 100**

  Escribir un programa java que lea por teclado un número real y nos indique por pantalla si éste se encuentra entre 0 y 100, ambos inclusive.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class CeroCien {

			public static void main(String[] args) {
				float numero;
				System.out.print("Introduce un número: ");
				numero = Entrada.real();
				if (numero >= 0 && numero <= 100) {
					System.out.println("El número: " + numero + " está comprendido entre 0 y 100");
				} else {
					System.out.println("El número: " + numero + " no está comprendido entre 0 y 100");
				}
			}

		}
    ~~~

    [Descargar posible solución para el programa **CeroCien**](ejercicios/CeroCien.java)

- **Calificación obtenida**

  Escribir un programa java que lea por teclado una calificación y nos indique si estamos aprobados o suspensos o si la calificación no es una calificación correcta.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class AprobadoSuspenso {

			public static void main(String[] args) {
				float calificacion;
				System.out.print("Introduce una calificación: ");
				calificacion = Entrada.real();
				if (calificacion < 0 || calificacion > 10) {
					System.out.println("La calificación introducida no es una calificación correcta.");
				} else if (calificacion >= 5) {
					System.out.println("Enhorabuena!!! Estás aprobado.");
				} else {
					System.out.println("Lo siento, pero estás suspenso.");
				}
			}

		}
    ~~~

    [Descargar posible solución para el programa **AprobadoSuspenso**](ejercicios/AprobadoSuspenso.java)

- **Números iguales**

  Escribir un programa java que lea por teclado dos números enteros y nos indique si son iguales o no.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class NumerosIguales {

			public static void main(String[] args) {
				int numero1, numero2;
				System.out.print("Introduce el primer número: ");
				numero1 = Entrada.entero();
				System.out.print("Introduce el segundo número: ");
				numero2 = Entrada.entero();
				if (numero1 == numero2) {
					System.out.println("Los números introducidos son iguales.");
				} else {
					System.out.println("Los números introducidos no son iguales.");
				}
			}

		}
    ~~~

    [Descargar posible solución para el programa **NumerosIguales**](ejercicios/NumerosIguales.java)

- **Ordenar dos números**

  Escribir un programa java que lea por teclado dos números reales y nos los muestre ordenados de mayor a menor.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class OrdenarDosNumeros {

			public static void main(String[] args) {
				float numero1, numero2;
				System.out.print("Introduce el primer número: ");
				numero1 = Entrada.real();
				System.out.print("Introduce el segundo número: ");
				numero2 = Entrada.real();
				if (numero1 >= numero2) {
					System.out.println("Los números ordenados de mayor a menor: " + numero1 + ", " + numero2);
				} else {
					System.out.println("Los números ordenados de mayor a menor: " + numero2 + ", " + numero1);
				}
			}

		}
    ~~~

    [Descargar posible solución para el programa **OrdenarDosNumeros**](ejercicios/OrdenarDosNumeros.java)

- **Ordenar tres números**

  Escribir un programa java que lea por teclado tres números reales y nos los muestre ordenados de mayor a menor.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class OrdenarTresNumeros {

			public static void main(String[] args) {
				float numero1, numero2, numero3, mayor, medio, menor;
				System.out.print("Introduce el primer número: ");
				numero1 = Entrada.real();
				System.out.print("Introduce el segundo número: ");
				numero2 = Entrada.real();
				System.out.print("Introduce el tercer número: ");
				numero3 = Entrada.real();
				if (numero1 >= numero2 && numero2 >= numero3) {
					mayor = numero1;
					medio = numero2;
					menor = numero3;
				} else if (numero1 >= numero3 && numero3 >= numero2){
					mayor = numero1;
					medio = numero3;
					menor = numero2;
				} else if (numero2 >= numero1 && numero1 >= numero3) {
					mayor = numero2;
					medio = numero1;
					menor = numero3;
				} else if (numero2 >= numero3 && numero3 >= numero1) {
					mayor = numero2;
					medio = numero3;
					menor = numero1;
				} else if (numero3 >= numero1 && numero1 >= numero2) {
					mayor = numero3;
					medio = numero1;
					menor = numero2;
				} else {
					mayor = numero3;
					medio = numero2;
					menor = numero1;
				}
				System.out.println("Los números ordenados de mayora a menor: " + mayor + ", " + medio + ", " + menor);
			}

		}
    ~~~

    [Descargar posible solución para el programa **OrdenarTresNumeros**](ejercicios/OrdenarTresNumeros.java)

###### Sentencias repetitivas

- **Tabla de multiplicar**

  Escribir un programa java que lea por teclado un número entero y nos muestre la tabla de multiplicar de dicho número.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class TablaMultiplicar {

			public static void main(String[] args) {
				int numero;
				System.out.print("Introduce un número: ");
				numero = Entrada.entero();
				for (int i = 1; i <= 10; i++) {
					System.out.println(numero + " * " + i + " = " + numero * i);
				}
			}

		}
    ~~~

    [Descargar posible solución para el programa **TablaMultiplicar**](ejercicios/TablaMultiplicar.java)

- **Numero positivo**

  Escribir un programa java que lea por teclado un número entero positivo y nos lo muestre.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class NumeroPositivo {

			public static void main(String[] args) {
				int numero;
				do {
					System.out.print("Introduce un número positivo: ");
					numero = Entrada.entero();
				} while (numero < 0);
				System.out.println("El número positivo introducido es: " + numero);
			}

		}
    ~~~

    [Descargar posible solución para el programa **NumeroPositivo**](ejercicios/NumeroPositivo.java)

- **Sumar números**

  Escribir un programa java que lea por teclado números enteros hasta que se introduzca un cero muestre por pantalla la suma de los mismos.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class SumaNumeros {

			public static void main(String[] args) {
				int numero, suma = 0;
				do {
					System.out.print("Introduce un número: ");
					numero = Entrada.entero();
					if (numero != 0) {
						suma += numero;
					}
				} while (numero != 0);
				System.out.println("La suma de los números introducidos es: " + suma);
			}

		}
    ~~~

    [Descargar posible solución para el programa **SumaNumeros**](ejercicios/SumaNumeros.java)

- **Media números**

  Escribir un programa java que lea por teclado números enteros hasta que se introduzca un cero muestre por pantalla la media de los mismos.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class MediaNumeros {

			public static void main(String[] args) {
				int numero, suma = 0, cantidadNumeros = 0;
				do {
					System.out.print("Introduce un número: ");
					numero = Entrada.entero();
					if (numero != 0) {
						suma += numero;
						cantidadNumeros++;
					}
				} while (numero != 0);
				if (cantidadNumeros < 0) {
					System.out.println("La media de los números introducidos es: " + (float)suma / cantidadNumeros);
				}
			}

		}
    ~~~

    [Descargar posible solución para el programa **MediaNumeros**](ejercicios/MediaNumeros.java)

###### Ejercicios variados

- **Número perfecto**

  Escribir un programa java que lea un número entero mayor que cero por teclado y nos informe si dicho número es perfecto o no. Un número es perfecto si es igual a la suma de sus divisores.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class NumeroPerfecto {

			public static void main(String[] args) {
				int numero, suma = 0;
				do {
					System.out.print("Introduce un número: ");
					numero = Entrada.entero();
				} while (numero <= 0);
				for (int i = 1; i < numero; i++) {
					if (numero % i == 0) {
						suma += i;
					}
				}
				String mensaje = (suma == numero) ? " SÍ" : " NO";
				System.out.println("El número: " + numero + mensaje + " es perfecto.");
			}

		}
    ~~~

    [Descargar posible solución para el programa **NumeroPerfecto**](ejercicios/NumeroPerfecto.java)

- **Número cifras**

  Escribir un programa java que lea un número entero mayor que cero por teclado y nos informe de la cantidad de cifras que posee dicho número. Para ello sólo debes utilizar operaciones aritméticas.

  - Posible solución
    ~~~java
		import utilidades.Entrada;

		public class NumCifras {

	    public static void main(String[] args) {
				int numero;
				do {
					System.out.print("Introduce un número entero: ");
					numero = Entrada.entero();
				} while (numero <= 0);
				int cifras = 0;
				//Si cambiamos el while por este comentado, podriamos evitar la sentencia numero /= 10 y así no modificar numero
				//while (numero / (int)Math.pow(10,cifras) != 0) {
				while (numero != 0) {
					numero /= 10;
					cifras++;
				}
				System.out.println("Tiene " + cifras + " cifras");
			}

		}
    ~~~

    [Descargar posible solución para el programa **NumCifras**](ejercicios/NumCifras.java)
