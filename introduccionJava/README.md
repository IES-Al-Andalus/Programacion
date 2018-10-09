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
- [Funciones](#funciones)
- [Sentencias secuenciales](#sentencias-secuenciales)
- [Sentencias condicionales](#sentencias-condicionales)
- [Sentencias repetitivas](#sentencias-repetitivas)
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
- **referenciados**: Son los tipos de datos que refenrencia a un objeto y los arrays. A este tipo de datos nos referiremos en apartados posteriores.

Un tipo de dato primitivo indica la cantidad de memoria que deberá reservar el compilador para almacenar una variable de ese tipo. Java es un lenguaje fuertemente tipado por lo que es necesario definir el tipo de dato de cada una de las variables.

Los tipos de datos primitivos se pueden agrupar en: caracter, numérico, decimal y lógico. En la siguiente tabla se muestran los diferentes tipos de datos primitivos, su tamaño, rango y el valor por defecto de cada uno de ellos:

|Tipo de dato|Tamaño|Rango|Valor por defecto|
|-------------------------------------------|
|`char`|2 bytes|\u0000 a \uFFFF|\u0000|
|`byte`|1 byte|-128 a 127|0|
|`short`|2 bytes|-32768 a 32767|0|
|`int`|4 bytes|-2147483648 a -2147483647|0
|`long`|8 bytes|-9223372036854775808 a -9223372036854775807|0|
|`float`|4 bytes|<img src="https://latex.codecogs.com/svg.latex?\Large&space;\pm3.4*10^{-38}&space;a&space;\pm3.4*10^{38}"/>|0.0|
|`double`|8 bytes|<img src="https://latex.codecogs.com/svg.latex?\Large&space;\pm1.8*10^{-308}&space;a&space;\pm1.8*10^{308}"/>|0.0|
|'boolean'|1 byte|`true` o `false`|`false`|

Aunque `String` no es un tipo de dato primitivo ya que es referenciado a un objeto de la clase `String`, simplemente lo nombro ya que a veces lo utilizaremos.

## Literales

Los literales son valores constantes que podemos utilizar para asignar a una variable. Cada tipo de dato tiene su forma para expresarlo. En la siguiente tabla muestro cómo expresar cada uno de ellos.

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
Una variable en un algoritmo es un identificador en el que podemos almacenar información. El valor almacenado en una variable puede ir variando a medida que el algoritmo avanza.

El nombre o identificador de la variable debe comenzar con letras, y puede contener solo letras, números y el guión bajo.

- Para acostumbrarnos, debe empezar en minúscula y si queremos utilizar varias palabras para nombrarla, las pondremos juntas y la segunda y restantes comenzarán en mayúscula: `numero`, `numCifras`, `fechaNacimiento`...
- No debe coincidir con una palabra reservada o función del lenguaje, para no generar ambigüedad.
- El nombre de una variable debe ser lo más explicativo posible y así nos ayudará a comprender su cometido.
- Toda variable tiene un tipo de dato asociado y sólo podrá contener datos de ese tipo (aunque en algunos lenguajes de programación esta afirmación no es cierta).
- Aunque en PSeInt no es obligatorio, debemos acostumbrarnos a definir la variable antes de utilizarla:

  `numero Es Entero`

  `numero, numCifra Son Enteros`

## Operadores

El lenguaje utilizado por PSeInt dispone de un conjunto básico de operadores que pueden ser utilizados para la construcción de expresiones más o menos complejas los cuáles se muestran en las siguientes tablas:

**Operadores relacionales**

Operador|Significado|Ejemplo
------------|--------------|------------
`>` | Mayor que|3>2
`<`| Menor que |'Hola'<'hola'
`=`| Igual que|4=3
`<=`| Menor o igual que| 2<=2
`>=`| Mayor o igual que|  4>=5
`<>`| Distinto que| 7<>8

**Operadores Lógicos**

Operador|Significado|Ejemplo
------------|--------------|------------
`&` ó `Y`| Conjunción (y) |(8>5) & (5=3) //falso
`|` ó `O` | Disyunción (o)| (8>5 \| 5=3) //verdadero
`~` ó `NO`| Negación (no)| 	  ~(8>5) //verdadero

**Operadores Algebraicos**

Operador|Significado|Ejemplo
------------|--------------|------------
`+`| Suma| suma <- op1 + op2
`-` |Resta| dif <- op1 - op2
`*`|Multiplicación|mult <- numero * 5
`/`| División|porc <- 100 * parte / total  
`^`|Potenciación| sup <- 3.41 * radio ^ 2
`%` ó `MOD`| Módulo (resto de la división entera) | resto <- num MOD div

   La precedencia de los operadores matemáticos es igual a la del álgebra, aunque puede alterarse mediante el uso de paréntesis.

## Funciones

Las funciones en pseudocódigo son parecidas a las que se utilizan en el álgebra, por ejemplo para hallar el seno de un ángulo, aunque su sintaxis es algo diferente ya que los parámetros se encierran entre paréntesis. Se coloca su nombre seguido de los argumentos para la misma encerrados entre paréntesis (por ejemplo `sen(x)`). Se pueden utilizar dentro de cualquier expresión, y cuando se evalúe la misma, se reemplazará por el resultado correspondiente. Actualmente, todas la funciones disponibles en **PSeInt** son matemáticas o de cadena. A continuación se listan las funciones integradas en **PSeInt** disponibles:


Función|Significado
-------|-----------
`RAIZ(X)`|Raíz Cuadrada de X
`ABS(X)`|Valor Absoluto de X
`LN(X)`|Logaritmo Natural de X
`EXP(X)`|Función Exponencial de X
`SEN(X)`|Seno de X
`COS(X)`|Coseno de X
`TAN(X)`|Tangente de X
`ASEN(X)`|Arcoseno de X
`ACOS(X)`|Arcocoseno de X
`ATAN(X)`|Arcotangente de X
`TRUNC(X)`|Parte entera de X
`REDON(X)`|Entero más cercano a X
`AZAR(X)`|Entero aleatorio en el rango [0;x-1]
`ALEATORIO(A,B)`|Entero aleatorio en el rango [A;B]
`LONGITUD(S)`|Cantidad de caracteres de la cadena S
`MAYUSCULAS(S)`|Devuelve una copia de la cadena S con todos sus caracteres en mayúsculas
`MINUSCULAS(S)`|Devuelve una copia de la cadena S con todos sus caracteres en minúsculas
`SUBCADENA(S,X,Y)`|Devuelve una nueva cadena que consiste en la parte de la cadena S que va desde la posición X hasta la posición Y (incluyendo ambos extremos). Las posiciones utilizan la misma base que los arreglos, por lo que la primer letra será la 0 o la 1 de acuerdo al perfil del lenguaje utilizado.
`CONCATENAR(S1,S2)`|Devuelve una nueva cadena resultado de unir las cadenas S1 y S2.
`CONVERTIRANUMERO(X)`|Recibe una cadena de caracteres que contiene un número y devuelve una variable numérica con el mismo.
`CONVERTIRATEXTO(S)`|Recibe un real y devuelve una variable numérica con la representación como cadena de caracteres de dicho real.

## Sentencias secuenciales

En PSeInt podemos encontrarnos con 3 tipos de sentencias secuenciales (que se ejecutan una detrás de otra):

- **Asignación**: Como su nombre indica sirve para asignar valores a una variable. Utiliza el operador de asignación, que en PSeInt es el símbolo `<-` (aunque también permite otros, nosotros nos quedaremos con este).

  Para realizar la asignación, primero se evalua la expresión de la derecha y luego se asigna el resultado.

  Nos debemos acostrumbrar a utilizar variables que ya estén definidas.

  `num <- 10`

  `suma <- operador1 + operador2`

- **Lectura** Esta sentencia permite leer valores por teclado y asignarlos a variables.

  `Leer num`

  `Leer operador1, operador2`

- **Escritura** Sentencia que muestra información por pantalla al usuario.

  `Escribir "La suma es: ", suma`

  `Escribir Sin Saltar "Introduce un número: "`

## Sentencias condicionales
Son sentencias que permiten alterar el flujo del algoritmo y ejecutar unas sentencias u otras dependiendo del valor de una condición.

- **Condicional** Permite evaluar una condición y ejecutar una serie de sentencias si dicha condición es verdadera u otras si es falsa.

  ~~~
  Si <condicion> Entonces
    <instruccionesV>
  SiNo
    <instruccionesF>
  FinSi
  ~~~

  Evalúa la condición y si es verdadera ejecutará `<sentenciasV>` y si es falsa ejecuturá `<sentenciasF>`

  El bloque `SiNo` no es obligatorio y en ese caso (la condición es falsa) no se ejecuta ninguna sentencia y se continúa por la sentencia después del `FinSi`

- **Selección múltiple** En este caso nos permite seleccionar las instrucciones a ejecutar dependiendo del valor de una variable numérica.

  ~~~
  Segun <variable> Hacer
    <número1>:
      <instrucciones1>
    <número2>,<número3>:
      <instrucciones23>
    <...>
    De Otro Modo:
      <instrucciones>
  FinSegun
  ~~~

  Al ejecutarse, se evalúa el contenido de la variable y se ejecuta la secuencia de instrucciones asociada con dicho valor.

  Si una opción incluye varios números, la secuencia de instrucciones asociada se debe ejecutar cuando el valor de la variable es uno de esos números.

  Opcionalmente, se puede agregar una opción final, denominada `De Otro Modo`, cuya secuencia de instrucciones asociada se ejecutará sólo si el valor almacenado en la variable no coincide con ninguna de las opciones anteriores.

## Sentencias repetitivas
Son sentencias que también alteran el flujo del algoritmo, permitiendo repetir una secuencia de instrucciones mientras se de alguna condición. También son conocidas como bucles.

- **Mientras** Esta instrucción ejecuta una secuencia de instrucciones mientras se cumpla una condición.

  ~~~
  Mientras <condicion> Hacer
    <instrucciones>
  FinMientras
  ~~~

  Se evalúa la condición y si es verdadera se ejecuta la secuencia de sentencias. En cada paso se vuelve a repetir el proceso.

  La secuencia de instrucciones no tiene por qué ejecutarse ni una sola vez, si al principio la condición es falsa.

  Si la condición siempre es verdadera entraremos en un bucle infinito debido a que la secuencia de instrucciones no hace que la condición llegue a ser falsa.

- **Repetir** Esta sentencia ejecuta un conjunto de instrucciones también mientras una condición sea verdadera, pero esta condición se evalúa al final del bucle. PSeInt tiene otras sentencias `Repetir` pero nosotros utilizaremos la siguiente por su similitud con java.

  ~~~
  Repetir
    <instrucciones>
  Mientras Que <condicion>
  ~~~

  La secuencia de instrucciones siempre se ejecuta al menos una vez, al contrario que en el bucle anterior.

  También debemos modificar las variables que afectan a la condición en la secuencia de instrucciones del cuerpo del bucle o de lo contrario se puede entrar en un bucle infinito.

- **Para** Este tipo de bucles se utiliza para repetir una secuencia de instrucciones un número determinado de veces.

  ~~~
  Para <variable> <- <inicial> Hasta <final> Con Paso <paso> Hacer
    <instrucciones>
  FinPara
  ~~~

  La variable toma el valor `<inicial>` y se ejecuta la secuencia de intrucciones. Se incrementa la variable el valor de `<paso>` y se comprueba si la variable ha superado el valor `<final>`. Si no lo ha superado, se vuelve a ejecutar la secuencia de sentencias y se repite el proceso hasta que la variable supera el valor `<final>`.

  La claúsula `Con Paso` se puede obviar, en cuyo caso el incremento será de 1.

## Personalización del lenguaje

Para que todos y todas utilicemos la misma sintaxis del lenguaje utilizado por PSeInt y que éste se asemeje lo máximo posible a como luego se comportará Java, hemos utilizado la siguiente personalización del lenguaje, por lo que os ruego que todos configuremos el programa PSeInt con dicha personalización.

![Personalización del lenguaje](imagenes/personalizacionLenguaje.png)

## Ejercicios

###### Sentencias secuenciales

- **Asignar valor a una variable y mostrarlo**

  Diseñar un algoritmo que le asigne un valor cualquiera a una variable entera y lo muestre por pantalla.

  - ![Diagrama de flujo para el algoritmo AsignarValor](ejercicios/diagramas/AsignarValor.png)
    ~~~
    Algoritmo AsignarValor

    	//Declaración
    	num Es Entero

    	//Asignación
    	num <- 5

    	//Escritura
    	Escribir "El valor de num es: ", num

    FinAlgoritmo 
    ~~~

    [Descargar posible solución para el algoritmo **AsignarValor**](ejercicios/AsignarValor.psc)
