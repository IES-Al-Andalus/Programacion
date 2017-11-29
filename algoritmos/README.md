# Resolución de problemas mediante algoritmos

En este apartado encontrarás la teoría y diferentes ejercicios con sus respectivas posibles soluciones sobre la **resolución de problemas mediante algoritmos**.

A la hora de escribir los algoritmos utilizaré la sintaxis propuesta en el programa [PSeInt](http://pseint.sourceforge.net/).

**José Ramón Jiménez Reyes** @JRJimenezReyes - IES Al-Ándalus

## Contenidos
- [Algoritmo](#algoritmo)
- [Estructura de un algoritmo en pseudocódigo](#estructura-de-un-algoritmo-en-pseudocódigo)
- [Variables](#variables)
- [Tipos de datos](#tipos-de-datos)
- [Operadores](#operadores)
- [Sentencias secuenciales](#sentencias-secuenciales)
- [Sentencias condicionales](#sentencias-condicionales)
- [Sentencias repetitivas](#sentencias-repetitivas)
- [Ejercicios](#ejercicios)

## Algoritmo
Un algoritmo no es más que un conjunto finito de instrucciones, expresado en un lenguaje bien definido que nos permite llegar a la solución de un problema dado.

Para expresar un algoritmo podemos utilizar diferentes lenguajes o gráficos. Nosotros nos centraremos en la sintaxis del pseudocódigo utilizado por el programa didáctico [PSeInt](http://pseint.sourceforge.net/) que además también permite ver el diagrama de flujo para un algoritmo escrito utilizando su sintaxis.

Dicho programa permite expresar un algoritmo en pseudocódigo utilizando diferentes variantes dependiendo de la sintaxis escogida, aunque nosotros utilizaremos su configuración por defecto y siempre intentaremos asemejar la sintaxis de nuestros algoritmos a la utilizada por java, en la medida de lo posible.

## Estructura de un algoritmo en pseudocódigo

Todo algoritmo en pseudocódigo tiene la siguiente estructura general:
~~~
     Algoritmo SinTitulo
          instruccion 1;
          insturccion 1;
               .
               .
               .
          instruccion n;
     FinAlgoritmo
~~~
- El algoritmo comienza con la palabra clave `Algoritmo` seguida del nombre del mismo.
- Le sigue una secuencia de instrucciones.
- Finaliza con la palabra `FinAlgoritmo`.

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

## Tipos de datos

 Nosotros utilizaremos tres tipos de datos básicos (aunque en PSeInt y en cualquier lenguaje de programación existen más):

 - **Numérico**: números, tanto enteros como reales. Para separar decimales se utiliza el punto. Ejemplos: `21` `453` `0` `-3.6` `3.14`
 - **Lógico**: solo puede tomar dos valores: `VERDADERO` o `FALSO`.
 - **Carácter**: caracteres o cadenas de caracteres encerrados entre comillas (pueden ser dobles o simples, aunque nos acostumbraremos a utilizar las dobles por su semejanza con java). Ejemplos `"hola"` `"hola mundo"` `"José Ramón"`

## Operadores

El lenguaje utilizado por PSeInt dispone de un conjunto básico de operadores que pueden ser utilizados para la construcción de expresiones más o menos complejas los cuáles se muestran en las siguientes tablas:

**Operadores relacionales**

Operador|Significado|Ejemplo
------------|--------------|------------
\> | Mayor que|3>2
<| Menor que |'Hola'<'hola'
=| Igual que|4=3
<=| Menor o igual que| 2<=2
\>=| Mayor o igual que|  4>=5
<>| Distinto que| 7<>8

**Operadores Lógicos**

Operador|Significado|Ejemplo
------------|--------------|------------
& ó Y| Conjunción (y) |(8>5) & (5=3) //falso
\| ó O | Disyunción (o)| (8>5 \| 5=3) //verdadero
~ ó NO| Negación (no)| 	  ~(8>5) //verdadero

**Operadores Algebraicos**

Operador|Significado|Ejemplo
------------|--------------|------------
\+| Suma| suma <- op1 + op2
\- |Resta| dif <- op1 - op2
*|Multiplicación|mult <- numero * 5
/| División|porc <- 100 * parte / total  
^|Potenciación| sup <- 3.41 * radio ^ 2
% ó MOD| Módulo (resto de la división entera) | resto <- num MOD div

   La precedencia de los operadores matemáticos es igual a la del álgebra, aunque puede alterarse mediante el uso de paréntesis.

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
Son secuencias que también alteran el flujo del algoritmo, permitiendo repetir una secuencia de instrucciones mientras se de alguna condición. También son conocidas como bucles.

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

## Ejercicios
- **Número par o impar**
	Diseñar un algoritmo que lea un número por teclado y nos indique si es par o impar.

	[Posible solución para el algoritmo ParImpar](ejercicios/ParImpar.psc)

- **Otro mas**
