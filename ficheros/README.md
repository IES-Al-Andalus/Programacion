# Ficheros en java

En este apartado veremos cómo trabajar con **ficheros en java**. Para ello primero haremos una introducción, para posteriormente ver cómo trabajar con los tipos de ficheros más comunes.

Al igual que en otros apartados, el objetivo principal es que tengáis una amplía gama de ejercicios, con sus respectivas posibles soluciones, sobre **ficheros en java**.

**José Ramón Jiménez Reyes**

 > ![@JRJimenezReyes](../assets/images/github.png) @JRJimenezReyes

 > ![joseramon.jimenez@iesalandalus.org](../assets/images/mail.png) joseramon.jimenez@iesalandalus.org

### Contenidos
---
- [Introducción](#introduccin)
- [El sistema de archivos](#el-sistema-de-archivos)
- [Ficheros de texto](#ficheros-de-texto)
- [Ficheros binarios](#ficheros-binarios)
- [Ficheros especiales](#ficheros-especiales)
- [Ejercicios](#ejercicios)


## Introducción

En java ya sabemos cómo interactuar con el usuario, leyendo datos de la consola o mostrandolos. Es la forma en la que nuestro programa se comunica con el exterior. Este tipo de comunicación es a lo que se llama **operaciones de E/S (Entrada/Salida) estándar**.

Todo lo que hacíamos lo almacenábamos en estructuras de datos alojadas en memoria, que al terminar nuestro programa se perdían. Sería deseable que hubiese persistencia para los datos y así que no se perdiesen al finalizar. Y es aquí donde entran en juego otro tipo de operaciones de E/S como son las **operaciones de E/S a través de ficheros**.

Pero, ¿qué es un fichero o archivo? De forma escueta, podríamos decir que son una serie de datos almacenados en algún dispositivo de almacenamiento. Como ya sabemos se identifican por su **nombre** (en el que a veces queremos distinguir su **extensión**) y están almacenados en una **ruta**. La ruta indica el camino a seguir, dentro de la estrctura de carpetas, hasta llegar al archivo. Existen dos tipos de rutas:
- **Ruta absoluta**: Indica el camino completo desde la raíz del sistema de archivos. Para separar los directorios se utiliza la barra (`/`en Linux y Mac y `\` en windows), además en windows comienzan con la letra de la unidad. Por ejemplo: `/home/profesor/programacion/leeme.txt` en Linux, o `E:\datos\programacion\leeme.txt` en Windows.
- **Ruta relativa**: Indica el camino relativo a partir de una carpeta dada y comienzan por un nombre de carpeta, por ejemplo: `programacion/leeme.txt`. Cuando utilizamos rutas relativas debemos tener en cuenta que al ejecutarlo desde el IDE la ruta relativa comienza a partir de la raíz del proyecto. Cuando lo ejecutamos desde la línea de comandos, por ejemplo, la ruta relativa comienza a partir del directorio en el que nos encontramos.

Todos los ficheros almacenan una cantidad de bytes determinada por su tamaño, pero dependiendo de la **interpretación** que hagamos de ese conjunto de bytes, podemos distinguir:
- **Ficheros binarios**: No se hace ningún tipo de interpretación de los bytes almacenados en los mismos. Se suele decir que la información se almacena en crudo. Ejemplos de estos tipos son los ficheros ejecutables, los ficheros de imágenes, los ficheros de música, etc.
- **Ficheros de texto**: Cada dos bytes representa un caracter unicode y, por lo tanto, son entendibles por nosotros y fácilmente modificables. Ejemplos de estos tipos son los archivos fuente, los archivos de configuración, etc.

Si nos atenemos a cómo accedemos a los ficheros podemos distinguir dos modos de acceso:
- **Acceso secuencial**: Para acceder a un determinado byte debemos pasar por todos los bytes anteriores. Un simil podría ser las antiguas cintas de casette, en las que para escuchar una canción debíamos pasar por todas las anteriores.
- **Acceso aleatorio**: Podemos acceder a cualquier byte que deseemos. Un simil podría ser los CD de música, en los que podemos escuchar la canción que deseemos.

En java todas las operaciones de E/S se encuentran en el paquete `java.io` y es lo que veremos en los siguientes apartados. Antes de continuar, sería conveniente mencionar que en java existen un par de abstracciones relacionadas con los ficheros:
- **Flujo de datos** también conocido como `Stream`, es una abstracción que se asocia al fichero físico, aunque podría ser cualquier otro como la memoría, la red, el teclado, etc., y que es tratada por la máquina virtual. Toda operación de E/S se hará a través de un flujo de datos, por lo que nosotros trabajaremos de la misma forma sea cual sea el dispositivo al que esté asociado el flujo.
- **Buffer de datos** es una abstracción que se asocia a un flujo y actúa de intermediario entre nuestro programa y el flujo, haciendo más eficientes las lecturas y escrituras. Se comporta como una memoria intermedia que almacena una cantidad de bytes definida, de forma que las lecturas se realizan desde esta memoria intermedia y cuando se lee por completo se carga otro bloque en la misma. Para las escrituras actúa de forma similiar, escribimos en la memoria intermedia y cuando se llena, se vuelca al flujo y se vacía.

Cuando trabajamos con ficheros, debemos crear la asociación, bien sea mediante un flujo o mediante un buffer. A esto es a lo que se conoce como **abrir el fichero**. Leeremos o escribiremos los datos y finalmente eliminaremos la asociación para liberar el recurso. A esto es a lo que se llama **cerrar el fichero**. Es importante cerrar los ficheros. 

También debemos tener en cuenta que es posible que se produzcan situaciones anómalas: el fichero no existe y no se puede abrir, no tenemos permisos para abrir el archivo, el sistema de archivos está lleno y no se puede escribir, etc. Las excepciones más comunes que pueden saltar al trabajar con ficheros son:
- `FileNotFoundException`: Cuando no se puede abrir el fichero.
- `EOFException`: Cuando se llega al final del archivo. Esta excepción salta al leer ficheros de objetos.
- `IOException`: Excepción general que indica que ha sucedido algo no esperado al trabajar con ficheros; no existe, no se tienen permisos, sistema de archivos lleno, etc. Es la clase padre de las anteriores y de cualquier excepción que puede saltar al trabajar con ficheros.

Teniendo en mente que es posible que salte alguna excepción y que es muy importante cerrar los ficheros, debemos capturar las excepciones para evitar estas situaciones inesperadas y posibilitar cerrar los ficheros. Para facilitar esta tarea, a partir de java 7, existe la construcción `try-with-resources`. Esta construcción es como un `try-catch` normal en la que se indica el o los recursos que se van a abrir y es la máquina virtual la que se encarga de cerrar el o los recursos, bien al capturar alguna excepción o bien al finalizar. Veamos un ejemplo para clarificar:

~~~java
    try (FileInputStream entrada = new FileInputStream(ficheroEntrada)){
        //Procesar fichero
    } catch (FileNotFoundException e) {
        System.out.println("No se puede leer el fichero de entrada");
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida");
    }
~~~

Como se puede apreciar, en el try se abre el fichero, pero nunca se cierra, ya que es la máquina virtual la encargada por el hecho de utilizar esta construcción.

Ahora que ya conocemos todos estos, es la hora de que pasemos a ver las posibilidades que nos ofrece el paquete `java.io` para trabajar con ficheros. Ante cualquier duda siempre puedes consultar la [documentación de la API de `java.io`](https://docs.oracle.com/javase/8/docs/api/java/io/package-summary.html)

## El sistema de archivos

Para trabajar con el sistema de ficheros nos vamos a centrar en las siguientes clases o interfaces:
- `File`: Clase que nos ofrece una representación abstracta de un fichero y que nos permite realizar con él las operaciones más comunes: creación, borrado, consultar propiedades, etc.
- `FileFilter` y`FilenameFilter`: Interfaces que determinan el comportamiento que deben tener las clases que vayamos a utilizar para filtrar el listado de archivos de una carpeta.

### File

Esta clase pertenece al paquete `java.io` y hereda directamente de `Object`. Es una representación abstracta del fichero, pero no es el fichero en sí mismo. Es más, podría ser la representación abstracta de un fichero que ni siquiera existe, por ejemplo porque vamos a crearlo.

Con esta clase podemos hacer todas las operaciones a realizar con un fichero o carpeta. 

Para crear objetos de tipo `File` se nos ofrecen varios constructores, aunque los más comunes son los siguientes:

|Constructor|Descripción|
|-----------------------|
|`File(String nombre)`|Crea un objeto del tipo `File` en la localización asociada al nombre que se le pasa, que puede ser una ruta absoluta o relativa (es recomendable utilizar las rutas relativas en la medida de lo posible). Si el nombre termina en un separador nos estaremos refiriendo a una carpeta.|
|`File(String ruta, String nombre)`|Igual que el anterior, aunque ahora la ruta y el nombre se indican por separado.|
|`File(Uri uri)`|Crea un objeto del tipo `File` asociado a la URI indicada.| 

Para construir las rutas, debemos utilizar el separador del sistema, para que nuestra aplicación sea portable de un SO a otro. Para ello la clase `File` tiene la constante `separator` que nos devuelve dicho separador dependiente de la plataforma.


Veamos los métodos más comunes de su API:

|Método|Descripción|
|------------------|
|`boolean canExecute()`|Comprueba si el archivo es ejecutable.|
|`boolean canRead()`|Comprueba si tenemos permisos de lectura.|
|`boolean canWrite()`|Comprueba si tenemos permisos de escritura.|
|`boolean createNewFile()`|Crea un nuevo fichero vacío si es que no existe.|
|`boolean delete()`|Borra el fichero.|
|`boolean exist()`|Comprueba si existe el fichero.|
|`String getParent()`|Devuelve la cadena asociada al camino.|
|`String getName()`|Devuelve la cadena asociada al nombre.|
|`boolean isDirectory()`|Comprueba si es una carpeta.|
|`boolean isFile()`|Comprueba si es un fichero regular.|
|`boolean isHidden()`|Comprueba si es un fichero oculto.|
|`long length()`|Devuelve el tamaño del fichero.|
|`long lastModified()`|Devuelve la fecha, medida en milisegundos que han trasncurrido desde el 01/01/1970, de la última modificación.|
|`String[] list()`|Devuelve un array con los nombres de los ficheros y directorios contenidos en el mismo.|
|`String[] list(FilenameFilter filtro)`|Devuelve un array con los nombre de los ficheros y directorios aplicando el filtro.|
|`File[] lisFiles()`|Devuelve un array con los ficheros y directorios contenidos en el mismo.|
|`File[] listFiles(FileFilter filtro)`|Devuelve un array con los ficheros y directorios aplicando el filtro.|
|`File[] listFiles(FilenameFilter filtro)`|Devuelve un array con los ficheros y directorios aplicando el filtro.|
|`boolean mkdir()`|Crea la carpeta.|
|`boolean renameTo(File nombre)`|Renombra el fichero al indicado por el fichero que se le pasa.|
|`boolean setExecutable(boolean ejecutable)`|Establece el permiso de ejecucion al indicado.|
|`boolean setLastModified(long tiempo)`|Establece la fecha de la última modificación a la indicada.|
|`boolean setReadable(boolean leible)`|Establece el permiso de lectura al indicado.|
|`boolean setWritable(boolean escribible)`|Establece el permiso de escritura al indicado.|

En el apartado de [ejercicios](#ejercicios) tienes algunos ejemplos sobre el uso de la clase `File`.

### Filtros

Hemos visto que con el método `list` podemos listar todos los archivos de una carpeta dada. Pero a veces no queremos listar todos los archivos sino solo aquellos que cumplan con cierto criterio. Por ello dicho método está sobrecargado para establecer el criterio de filtrado. 

Para ello tenemos las siguientes interfaces que determinan el comportamiento de las clases capaces de realizar este tipo de filtrado:

- `FileFilter`: Para filtrar basándonos en el fichero (sus características). Obliga a implementar el método `boolean accept(File fichero)`.
- `FilenameFilter`: Para filtrar basándonos en el nombre del fichero. Obliga a implementar el método `boolen accept(File padre, String nombre)`.

Recordad que podemos utilizar una clase anónima para este cometido o, dado que ambas son interfaces funcionales, podemos utilizar funciones lambda.

Por ejemplo, podemos filtrar por extensión de la siguiente forma:
~~~java
    ...
    File[] contenido = carpeta.listFiles(new FileFilter() {
			
        @Override
        public boolean accept(File padre, String nombre) {
            return nombre.endsWith(".java");
        }

    });
    ...
~~~

También podemos utilizar una función lambda para realizar el mismo filtrado:
~~~java
    ...
    File[] contenido = carpeta.listFiles((padre, nombre) -> nombre.endsWith(".java"));
    ...
~~~

## Ficheros de texto

Para trabajar con ficheros de texto tenemos las siguientes clases, que podemos ver en este diagrama de clases muy simplificado. Estos son las principales, aunque hay más.

![jerarquia de caracteres](imagenes/jerarquiaCaracteres.png)

### Flujos de caracteres

Para trabajar con **flujos de caracteres** utilizaremos las clases, `FileReader` y `FileWriter` que crearán un flujo de entrada o salida sobre el fichero que pasemos en el constructor. Podemos pasarle un objeto de la clase `File` o una cadena con la ruta del fichero. Al crear el flujo puede lanzar la excepción `FileNotFoundException` si el fichero no existe, o existe y es un directorío, para el caso de las lecturas y si el fichero existe y es un directorio, o no se puede escribir en la ruta indicada, para el caso de las escrituras. Para la clase `FileWriter` también podemos pasar en el constructor un parámetro lógico inicando si vamos a añadir o vamos a machacar (por defecto sobrescribe).

Las clases `InputStreamReader` y `OutputStreamWriter` son las encargadas de realizar las conversiones entre codificaciones y las anteriores heredan de ellas. 

~~~java
    ...
    private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroTexto.txt");
    ...
    try (FileReader entrada = new FileReader(FICHERO)){
        int dato;
        while ((dato = entrada.read()) != -1) {
            //Procesamiento
        }
    } catch (FileNotFoundException e) {
        System.out.println("No se puede leer el fichero de entrada");
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida");
    }
    ...
~~~

Para **leer de un flujo de entrada de caracteres**, mediante objetos de la clase `FileReader`, utilizaremos los métodos:
- `int read()`: lee un solo caracter y devuelve el carácter leído o -1 si llegó al final. Debemos hacer un casting del entero leído a un `char`.
- `int read(char[] caracteres, int desplazamiento, int cantidad)`: lee hasta la cantidad de caracteres indicados por `cantidad` y los almacena en el array `caracteres` comenzando desde la posición indicada por `desplazamiento`. Deveulve la cantidad de caracteres leídos o -1 si llegó al final.

Para **escribir en un flujo de salida de caracteres**, mediante objetos de la clase `FileWriter` utilizaremos los siguientes métodos:
- `void append(char caracter)`: Añade el caracter indicado al final del flujo.
- `void write(char caracter)`: Escribe el caracter indicado en el flujo.
- `void write(char[] caracteres, int desplazamiento, int cantidad)`: Escribe hasta la cantidad de caracteres indicados por `cantidad` comenzando en `desplazamiento` del array `caracteres`.
- `void write(String cadena)`: Escribe la cadena de caracteres en el flujo.

Para escribir en un flujo de caracteres, también podemos utilizar la clase `PrintWriter` que nos ofrece métodos como `print`, `println`, `printf`, etc. que de sobra conocemos.

En java también tenemos algunos flujos predefinidos como son:
- `System.in`: Objeto de la clase `InputStreamReader` que está asociado a la entrada estándard.
- `System.out`: Objeto de la clase `PrintStream` que está asociado a la salida estándard.
- `System.err`: Objeto de la clase `PrintStream` que está asociado al error estándard.

### Buferes de caracteres
También podemos utilizar buferes para realizar las operaciones de E/S. Los buferes se montan sobre flujos ya creados, bien sean de entrada o de salida. Son objetos de las clases `BufferedReader` y `BufferedWriter`.

~~~java
    ...
    private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroTexto.txt");
    ...
    try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO))){
        String linea;
        while ((linea = entrada.readLine()) != null) {
            //Procesamiento
        }
    } catch (FileNotFoundException e) {
        System.out.println("No se puede leer el fichero de entrada.");
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida.");
    }
    ....
~~~

Para la lectura podemos utilizar el método adicional `readline` que devuelve la línea leída o `null` si ha llegado al final.

Para la escritura podemos utilizar los métodos `write` y `newLine`.

Es conveniente utilizar buferes dada su eficiencia en comparación con los simples flujos. Te recomiendo que hagas una prueba: ejecuta midiendo el tiempo (por ejemplo utilizando el comando `time`) la copia de un fichero de texto utilizando flujos y utilizando buferes y fíjate en la diferencia que hay al hacerlo con ficheros grandes. Estos ejemplos los tienes en los ejercicios. Te mostraré los resultados cuando hablemos de ficheros binarios, ya que es más fácil tener ficheros algo más grandes.

## Ficheros binarios

Para trabajar con ficheros binarios tenemos las siguientes clases, que podemos ver en este diagrama de clases muy simplificado. Estos son las principales, aunque hay más.

![jerarquia de caracteres](imagenes/jerarquiaBytes.png)

### Flujos binarios

Para trabajar con **flujos binarios** utilizaremos las clases, `FileInputStream` y `FileOutputStream` que crearán un flujo de entrada o salida sobre el fichero que pasemos en el constructor. Podemos pasarle un objeto de la clase `File` o una cadena con la ruta del fichero. Al crear el flujo puede lanzar la excepción `FileNotFoundException` si el fichero no existe, o existe y es un directorío, para el caso de las lecturas y si el fichero existe y es un directorio, o no se puede escribir en la ruta indicada, para el caso de las escrituras. Para la clase `FileOutputStream` también podemos pasar en el constructor un parámetro lógico inicando si vamos a añadir o vamos a machacar (por defecto sobrescribe).

Para **leer de un flujo de entrada binario**, mediante objetos de la clase `FileInputStream`, utilizaremos los métodos:
- `int read()`: lee un solo byte y devuelve el byte leído o -1 si llegó al final.
- `int read(byte[] datos, int desplazamiento, int cantidad)`: lee hasta la cantidad de bytes indicados por `cantidad` y los almacena en el array `datos` comenzando desde la posición indicada por `desplazamiento`. Deveulve la cantidad de bytes leídos o -1 si llegó al final.

Para **escribir en un flujo de salida binario**, mediante objetos de la clase `FileOutputStream` utilizaremos los siguientes métodos:
- `void write(int dato)`: Escribe el byte indicado en el flujo.
- `void write(byte[] datos, int desplazamiento, int cantidad)`: Escribe hasta la cantidad de bytes indicados por `cantidad` comenzando en `desplazamiento` del array `datos`.

### Buferes binarios

También podemos utilizar buferes para realizar las operaciones de E/S. Los buferes se montan sobre flujos ya creados, bien sean de entrada o de salida. Son objetos de las clases `BufferedInputStream` y `BufferedOutputStream`.

~~~java
    ...
    public static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioPeque.bin");
    ...
    try (BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(FICHERO))){
        //Procesamiento
    } catch (FileNotFoundException e) {
        System.out.println("No se puede leer el fichero de entrada");
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida");
    }
	
    ....
~~~

Para la lectura podemos utilizar el método adicional `read` que devuelve el byte leíd0 o -1 si ha llegado al final.

Para la escritura podemos utilizar los métodos `write` al que se le pasa el byte a escribir.

Cuando hablamos de ficheros de texto dijimos que era conveniente utilizar buferes debido a su eficiencia. En los ejercicios tienes ejemplos, entre otros, de como copiar un fichero binario utilizando flujos y utilizando buferes. Ambos copian el mismo fichero. Os dejo, como ya os comenté, la comparativa de copiar un fichero de unos 9 MB. utilizando flujos y buferes en mi ordenador. Ni que decir tiene que lo mismo pasa con los ficheros de texto. Creo que las ventajas son obvias.

~~~bash
pepino@Tor:~/Desarrollos/java/IntelliJ/Ficheros$ ls -l  ficheros/ficheroBinarioGrande.bin 
-rw-rw-r-- 1 pepino pepino 9544366 mar 20 12:28 ficheros/ficheroBinarioGrande.bin
pepino@Tor:~/Desarrollos/java/IntelliJ/Ficheros$ time java -cp out/production/classes/ org.iesalandalus.programacion.ficheros.secuencial.bytes.flujos.CopiarFicheroBinario 
Fichero copiado satisfactoriamente.

real    1m46,534s
user    0m9,208s
sys     1m37,442s
pepino@Tor:~/Desarrollos/java/IntelliJ/Ficheros$ time java -cp out/production/classes/ org.iesalandalus.programacion.ficheros.secuencial.bytes.buffers.CopiarFicheroBinario 
Fichero copiado satisfactoriamente.

real    0m0,184s
user    0m0,118s
sys     0m0,127s
pepino@Tor:~/Desarrollos/java/IntelliJ/Ficheros$ 
~~~

### Ficheros de datos primitivos

En java también podemos leer y escribir en flujos datos primitivos. Estas operaciones las podemos realizar mediante las clases `DataInputStream` y `DataOutputStream`. Para crear objetos de estas clases, debemos pasarle al constructor el flujo correspondiente (en realidad se le pasan objetos de las clases `InputStream` y `OutputStream` que son las clases abstractas padre de esta jerarquía).

Las principales operaciones que podemos realizar con estas clases son las siguientes:

|`DataInputStream`|`DataOuputStream`|
|-----------------------------------|
| `boolean readBoolean()`|`void writeBoolean(boolean dato)`|
| `char readChar()`|`void writeChar(char dato)`|
| `double readDouble()`|`void writeDouble(double dato)`|
| `float readFloat()`|`void writeFloat(float dato)`|
| `int readInt()`|`void writeInt(int dato)`|
| `long readLong()`|`void writeLong(long dato)`|
| `short readShort()`|`void writeShort(short dato)`|
| `String readUTF()`|`void writeUTF(String dato)`|

Para realizar las lecturas debemos iterar indefinidamente hasta que salte la excepción `EOFException` indicando que se ha llegado al final del fichero.

### Serialización de objetos

A veces nos interesa guardar o transmitir objetos completos y/o leer o recibir objetos completos. Para ello se debe poder convertir el objeto en una secuencia de bytes o convertir una secuencia de bytes en un objeto. A estas operaciones se les denomina **serialización** y **deserialización**.

Java permite llevar a cabo dichas operaciones, simplemente haciendo que las clases a las que pertenecen los objetos que queremos serializar o deserializar implementen la interfaz `Serializable`. Esta interfaz es una **interfaz marcadora**, es decir, simplemente marca la clase como serializable, pero al contrario que las demás interfaces, no obliga a implementar ningún método. Para que una clase sea serializable, todos sus atributos deben ser a su vez serializables. Todos los tipos primitivos, las colecciones, los mapas, etc. son serializables.

Una vez que ya tenemos la clase serializable, ahora podemos utilizar las clases `ObjectInputStream` y `ObjectOutputStream` para leer o escribir objetos de esta clase a un flujo. Para crear objetos de esta clase se le pasa el flujo correspondiente. Luego podemos utilizar los métodos `readObject` y `writeObject` para realizar las correspondientes operaciones de lectura y escritura. Cuando leemos un objeto y lo queremos asignar a una variable, debemos realizar el correspondiente casting y además debemos capturar la excepción `ClassCastException`, que saltará si no se puede encontar la clase de los objetos que queremos leer o esta no es serializable (o alguno de sus atributos). Al realizar las lecturas devolverá `null` si llegamos al final del fichero.

~~~java
    ...
    try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO))) {
        Persona persona;
        while ((persona = (Persona) entrada.readObject()) != null) {
            System.out.printf("Nombre: %s, edad: %d%n", persona.getNombre(), persona.getEdad());
        }
    } catch (FileNotFoundException e) {
        System.out.println("No puedo crear el fichero de entrada.");
    } catch (EOFException eo) {
        System.out.println("Fichero leído satisfactoriamente.");
    } catch (ClassNotFoundException e) {
        System.out.println("No puedo encontrar la clase que tengo que leer.");
    } catch (IOException e) {
        System.out.println("No puedo abrir el fichero de entrada.");
    }
    ...
~~~

Para escribir objetos utilizaremos un código parecido al siguiente:
~~~java
    ...
    Persona persona;
    String[] nombres = { "Juan", "Alfonso", "Araceli", "Manolo", "Rubén", "Elvira", "Inés", "José Ramón" };
    int[] edades = { 31, 35, 25, 40, 37, 18, 20, 22 };
    try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO))){
        for (int i = 0; i < edades.length; i++) {
            persona = new Persona(nombres[i], edades[i]);
            salida.writeObject(persona);
        }
        System.out.println("Fichero escrito satisfactoriamente.");
    } catch (FileNotFoundException e) {
        System.out.println("No puedo crear el fichero de salida.");
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida.");
    }
    ...
~~~

En el ejemplo anterior, en cada iteración del bucle estamos creando una nueva instancia de `Persona`. Si esta clase permitiese modificar los atributos e intentamos, en vez de crear una nueva instancia, realizar las modificaciones utilizando los correspondientes métodos `set`, podremos comprobar que siempre escribe el mismo objeto, es como si no se enterase de dichas modificaciones. Para que tenga en cuenta las modificaciones es necesario utilizar el método `reset`.

~~~java
    ...
    Persona persona = new Persona("lo que sea", 1);
    String[] nombres = { "Juan", "Alfonso", "Araceli", "Manolo", "Rubén", "Elvira", "Inés", "José Ramón" };
    int[] edades = { 31, 35, 25, 40, 37, 18, 20, 22 };
    try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO))){
        for (int i = 0; i < edades.length; i++) {
            persona.setNombre(nombres[i]);
            persona.setEdad(edades[i]);
            //Como hemos modificado los atributos y no creado una nueva instancia, debemos hacer reset
            //para que se entere de los cambios. Por tanto, siempre es mejor hacer el new y olvidarnos del reset.
            salida.reset();
            salida.writeObject(persona);
        }
        System.out.println("Fichero escrito satisfactoriamente.");
    } catch (FileNotFoundException e) {
        System.out.println("No puedo crear el fichero de salida.");
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida.");
    }
    ...
~~~

Otro problema asociado a la escritura de objetos es que cada vez que abrimos el fichero se escribe una cabecera. Si cerramos el fichero y lo volvemos a abrir para añadir más objetos, se vuelve a escribir otra cabecera en medio. A la hora de leerlo esta situación provovará que salte una excepción dado que no se esperaba dicha cabecera. Si ejecutamos el siguiente código y luego pretendemos leer el fichero podéis comprobarlo.

~~~java
    ...
    Persona persona;
    String[] nombres = { "Juan", "Alfonso", "Araceli", "Manolo", "Rubén", "Elvira", "Inés", "José Ramón" };
    int[] edades = { 31, 35, 25, 40, 37, 18, 20, 43 };
    //La primera vez creamos un objeto ObjectOutputStream que escribirá la cabecera adecuada
    try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO))){
        for (int i = 0; i < edades.length; i++) {
            persona = new Persona(nombres[i], edades[i]);
            salida.writeObject(persona);
        }
    } catch (FileNotFoundException e) {
        System.out.println("No puedo crear el fichero de salida.");
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida.");
    }
    //Al cerrar el flujo y volverlo abrir para añadir, se añade entre medias una cabecera que luego
    //hará que nos salte una excepción al leerlo. Para evitarlo hemos de sobreescribir el método encargado de escribir la
    //cabecera de la clase ObjectOutputStream (writeStreamHeader).
    //Como ahora abrimos para añadir, creamos un objeto de nuestra clase heredada que no escribe cabecera
    try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO, true))) {
    //try (ObjectOutputStream salida = new MyObjectOutputStream(new FileOutputStream(FICHERO, true))) {
        for (int i = 0; i < edades.length; i++) {
            persona = new Persona(nombres[i], edades[i]);
            salida.writeObject(persona);
        }
        System.out.println("Fichero escrito satisfactoriamente.");
    } catch (FileNotFoundException e) {
        System.out.println("No puedo crear el fichero de salida.");
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida.");
    }
    ...
~~~

Para solucionar este problema debemos crear una clase que herede de `ObjectOutputStream` para sobrescribir el método `writeStreamReader` que es el encardo de escribir la cabecera y que no haga nada.

~~~java
public class MyObjectOutputStream extends ObjectOutputStream {

    public MyObjectOutputStream () throws IOException{
        super();
    }

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // No escribo ninguna cabecera
    }
}
~~~

Ahora solo queda, a la hora de abrirlo para añadir, crear una instancia de esta nueva clase y no de `ObjectOutputStream`. Lo puedes comprobar en el código anterior comentando la línea que crea la instancia de `ObjectOutputStream` y descomentar la que crea la instancia de `MyObjectOutputStream`.

### Acceso aleatorio a Ficheros

Java ofrece la clase `RandomAccessFile` para acceder de forma aleatoria a ficheros binarios. Esta clase trata el fichero como un array de bytes y maneja un puntero o índice que indica dónde se realizará la siguiente operación de E/S. Cada vez que se realiza una nueva operación de E/S el puntero se mueve los bytes implicados en dicha operación.

A la hora de abrir un fichero para acceso aleatorio debemos indicar el modo con una cadena: `r` indica lectura y `rw` indica lectura y escritura.

Podemos mover el puntero mediante el método `void seek(long posicion)` y nos ofrece los mismos métodos que los ficheros de datos primitivos.

A la hora de trabajar con este tipo de ficheros, lo común es utilizar registros de longitud fija que albergarán los diferentes campos con los que vamos a trabajar. En el apartado de ejercicios puedes ver un ejemplo de su uso.

## Ficheros especiales

En este apartado vamos a comentar cómo trabajar con algunos ficheros especiales, tales como los ficheros CSV y XML.

### Ficheros CSV

CSV es la abraviatura en inglés de comma separated values (valores separados por comas). Son un caso especial de ficheros de texto, donde cada valor va separado por un caracter separador que generalmente es la coma, de ahí su nombre. Por tanto, los trataremos como un fichero de texto normal y cada línea la dividiremos utilizando el separador. Es un formato bastante utilizado para exportar datos dada su sencillez.

~~~java
    ...
    private static final String FICHERO_CSV = String.format("%s%s%s", "ficheros", File.separator, "personas.csv");
	private static final String SEPARADOR = ",";
    ...
    try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO_CSV))){
        String linea;
        while ((linea = entrada.readLine()) != null) {
            String[] campos = linea.split(SEPARADOR);
            //Procesamos cada campo
        }
        System.out.println("Fichero CSV leído correctamente.");
    } catch (FileNotFoundException e) {
        System.out.printf("No se puede leer el fichero de entrada: %s.%n", FICHERO_CSV);
    } catch (IOException e) {
        System.out.println("Error inesperado de Entrada/Salida.");
    }
    ...
~~~

Para escribir este tipo de ficheros, formaremos cada línea a escribir concatenando cada uno de los campos separados por el separador.

~~~java
    try (BufferedWriter salida = new BufferedWriter(new FileWriter(FICHERO_CSV))){
        for (Persona persona : personas) {
            salida.write(String.format("%s%s%d%n", persona.getNombre(), SEPARADOR, persona.getEdad()));
        }
        System.out.println("Fichero CSV escrito satisfactoriamente.");
    } catch (FileNotFoundException fnfe) {
        System.out.printf("No se puede leer el fichero de salida: %s.%n", FICHERO_CSV);
    } catch (IOException e) {
        System.out.printf("No se ha podido escribir el fichero %s.%n", FICHERO_CSV);
    }
~~~

### Ficheros XML

XML es la abreviatura en inglés de eXtensible Markup Language (lenguaje de marcas extensible). Son otro caso especial de ficheros de texto. A diferencia de los ficheros CSV, manejar los ficheros XML es más complicado, por lo que utilizaremos una API que nos proporciona java para llevar a cabo el procesamiento de este tipo de ficheros.

Veamos un par de ejemplos de ficheros XML que contienen la misma información:

~~~xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<personas>
    <persona edad="31" nombre="Juan"/>
    <persona edad="35" nombre="Alfonso"/>
    <persona edad="25" nombre="Araceli"/>
    <persona edad="40" nombre="Manolo"/>
    <persona edad="37" nombre="Rubén"/>
    <persona edad="18" nombre="Elvira"/>
    <persona edad="20" nombre="Inés"/>
    <persona edad="43" nombre="José Ramón"/>
</personas>
~~~

~~~xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<personas>
    <persona>
        <nombre>Juan</nombre>
        <edad>31</edad>
    </persona>
    <persona>
        <nombre>Alfonso</nombre>
        <edad>35</edad>
    </persona>
    <persona>
        <nombre>Araceli</nombre>
        <edad>25</edad>
    </persona>
    <persona>
        <nombre>Manolo</nombre>
        <edad>40</edad>
    </persona>
    <persona>
        <nombre>Rubén</nombre>
        <edad>37</edad>
    </persona>
    <persona>
        <nombre>Elvira</nombre>
        <edad>18</edad>
    </persona>
    <persona>
        <nombre>Inés</nombre>
        <edad>20</edad>
    </persona>
    <persona>
        <nombre>José Ramón</nombre>
        <edad>43</edad>
    </persona>
</personas>
~~~

Como se puede apreciar la información que contienen es la misma. En el primero se utilizan los atributos del elemento `persona` para almacenar los valores. En el segundo se utilizan diferentes elementos dentro de cada elemento `persona`.

La API para trabajar con ficheros XML está dividida en los siguientes paquetes:
- `javax.xml.parsers`: agrupa las funcionalidades para realizar el procesamiento de un fichero XML y crear la estructura de árbol que representa dicho fichero. Dicho árbol es llamado **árbol DOM**. Algunas de las clases y/o interfaces que nos ofrece son: `DocumentBuilder` y `DocumentSbuilderFactory`. 
- `javax.xml.transformer`: agrupa las funcionalidades para transformar el árbol DOM en un fichero. Algunas de las clases y/o interfaces que nos ofrece son: `Transform`, `TransformFactory`, `DOMSource` y `StreamResult`.
- `org.w3c.dom`: agrupa las funcionalidades para trabajar con el árbolDOM. Algunas de las clases y/o interfaces que nos ofrece son: `Document`, `Element`, `Node` y `NodeList`.

Para leer un fichero XML debemos crear un objeto de la clase `DocumentBuilder`, utilizando su fábrica y así obtener el árbol DOM. Partiendo de un árbol DOM ya creado, podemos escribirlo a un fichero utilizando un objeto de la clase `Tranform`, utilizando su fábrica, para posteriormente tranformar el árbol en un fichero. Dado que estas operaciones son muy comunes, te las he agrupado en una clase de utilidades que provee los métodos para leer un fichero XML y devolver su árbol DOM y viceversa.

`UtilidadesXml.java`
~~~java
package org.iesalandalus.programacion.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class UtilidadesXml {

	private UtilidadesXml() {
		// Evito que se creen instancias.
	}

	public static void escribirDocumentoXml(Document documentoXml, String salida) {
		try (FileWriter ficheroSalida = new FileWriter(salida)) {
			TransformerFactory factoria = TransformerFactory.newInstance();
			factoria.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			factoria.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
			Transformer conversor = factoria.newTransformer();
			conversor.setOutputProperty(OutputKeys.INDENT, "yes");
			conversor.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			conversor.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			StreamResult destino = new StreamResult(ficheroSalida);
			DOMSource fuente = new DOMSource(documentoXml);
			conversor.transform(fuente, destino);
			System.out.printf("Fichero %s escrito correctamente.%n", salida);
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			System.out.println("Imposible crear el conversor.");
		} catch (TransformerException e) {
			System.out.println("Error irrecuperable en la conversión.");
		} catch (IOException e) {
			System.out.printf("No se ha podido escribir el fichero %s.%n", salida);
		}
	}

	public static Document leerDocumentoXml(String ficheroXml) {
		Document documentoXml = null;
		try {
			DocumentBuilder constructor = crearConstructorDocumentoXml();
			if (constructor != null) {
				documentoXml = constructor.parse(ficheroXml);
				documentoXml.getDocumentElement().normalize();
			}
		} catch (SAXException e) {
			System.out.println("Documento XML mal formado.");
		} catch (IOException e) {
			System.out.printf("No se ha podido leer el fichero %s.%n", ficheroXml);
		}
		return documentoXml;
	}

	public static DocumentBuilder crearConstructorDocumentoXml() {
		DocumentBuilder constructor = null;
		try {
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			constructor = fabrica.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Error al crear el constructor.");
		}
		return constructor;
	}

}
~~~

Para **leer un fichero XML** utilizaremos el método `leerDocumentoXml` al que le pasaremos la ruta del archivo que queremos leer y nos devolverá el árbol DOM. Para recorrer dicho árbol obtendremos la lista de nodos que es un objeto de la clase `NodeList` y accederemos a cada uno de ellos mediante el método `item` al que le pasamos el índice del nodo a obtener. Cada nodo podemos convertirlo a `Element` mediante un casting (asegurándonos que el nodo es de dicho tipo mediante el método `getNodeType`). Para cada elemento podemos acceder a los elementos hijo mediante el método `getElementsByTagName` (esto devuelve una lista, nos debemos quedar con su primer elemento y acceder a la información de texto asociada mediante el método `getTextContent`) o al valor de sus atributos mediante `getAttribute`.

Por ejemplo, para leer el primer fichero que hemos mostrado podíamos utilizar el siguiente código:
~~~java
    ...
    Document documentoXml = UtilidadesXml.leerDocumentoXml(FICHERO_XML);
    if (documentoXml != null) {
        System.out.println("Fichero leúido correctamente.");
        NodeList personas = documentoXml.getElementsByTagName("persona");
        for (int i = 0; i < personas.getLength(); i++) {
            Node persona = personas.item(i);
            if (persona.getNodeType() == Node.ELEMENT_NODE) {
                String nombre = ((Element)persona).getAttribute("nombre");
                int edad = Integer.parseInt(((Element)persona).getAttribute("edad"));
                System.out.println(new Persona(nombre, edad));
            }
        }
    }
    ...
~~~

Para leer el segundo fichero que hemos mostrado, podríamos utilizar el siguiente código:
~~~java
    ...
    Document documentoXml = UtilidadesXml.leerDocumentoXml(FICHERO_XML);
    if (documentoXml != null) {
        System.out.println("Fichero leúido correctamente.");
        NodeList personas = documentoXml.getElementsByTagName("persona");
        for (int i = 0; i < personas.getLength(); i++) {
            Node persona = personas.item(i);
            if (persona.getNodeType() == Node.ELEMENT_NODE) {
                String nombre = ((Element)persona).getElementsByTagName("nombre").item(0).getTextContent();
                int edad = Integer.parseInt(((Element)persona).getElementsByTagName("edad").item(0).getTextContent());
                System.out.println(new Persona(nombre, edad));
            }
        }
    }
    ...
~~~

Para **escribir un fichero XML**, primero debemos crear el árbol DOM vacío utilizando el método `newDocument` de la clase `DocumentBuilder`. Para facilitar la creación de objetos `DocumentBuilder` puedes utilizar el método `crearConstructorDocumentoXml`. Debemos añadir el elemento que hará de raíz y a este le iremos añadiendo los diferentes elementos. Para todo este podemos utilizar los métodos `createElement` y `appendChild` de la clase `Document`. También tenemos la clase `Element` que nos ofrece los métodos `appendChild`, `setAttribute`, `setTextContent` y `hasAttribute`. Una vez que ya tenemos creado nuestro árbol DOM podemos escribirlo a fichero utilizando el método `escribirDocumentoXml` que facilita la escritura, ya que crea un objeto de la clase `Transform` y las correspondientes intancias de las clases `StreamResult` y `DOMSource`.

Para escribir el primer fichero mostrado, podríamos utilizar el siguiente código:
~~~java
    ...
    DocumentBuilder constructor = UtilidadesXml.crearConstructorDocumentoXml();
    Document documentoXml = null;
    if (constructor != null) {
        documentoXml = constructor.newDocument();
        documentoXml.appendChild(documentoXml.createElement("personas"));
        for (Persona persona : personas) {
            Element elementoPersona = crearElementoPersonaConAtributos(documentoXml, persona);
            documentoXml.getDocumentElement().appendChild(elementoPersona);
        }
    }
    ...
    private static Element crearElementoPersonaConAtributos(Document documentoXML, Persona persona) {
		Element elementoPersona = documentoXML.createElement("persona");
		elementoPersona.setAttribute("nombre", persona.getNombre());
		elementoPersona.setAttribute("edad", String.format("%d", persona.getEdad()));
		return elementoPersona;
	}
    ...
~~~

Para el segundo fichero mostrado, el código podría ser el siguiente:
~~~java
    ...
    DocumentBuilder constructor = UtilidadesXml.crearConstructorDocumentoXml();
    Document documentoXml = null;
    if (constructor != null) {
        documentoXml = constructor.newDocument();
        documentoXml.appendChild(documentoXml.createElement("personas"));
        for (Persona persona : personas) {
            Element elementoPersona = crearElementoPersonaConElementos(documentoXml, persona);
            documentoXml.getDocumentElement().appendChild(elementoPersona);
        }
    }
    ...
    private static Element crearElementoPersonaConElementos(Document documentoXml, Persona persona) {
		Element elementoPersona = documentoXml.createElement("persona");
		Element elementoNombre = documentoXml.createElement("nombre");
		elementoNombre.setTextContent(persona.getNombre());
		Element elementoEdad = documentoXml.createElement("edad");
		elementoEdad.setTextContent(String.format("%d", persona.getEdad()));
		elementoPersona.appendChild(elementoNombre);
		elementoPersona.appendChild(elementoEdad);
		return elementoPersona;
	}
    ...
~~~

## Ejercicios

###### File

- **Mostrar propiedades**

  Escribir un programa en java que muestre por pantalla las propiedades de un fichero que pida por consola y si es un directorio debe mostrar también su contenido. Este proceso lo repetirá mientras no introduzcamos como nombre de fichero: `FIN`.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.file;

        import java.io.File;
        import java.util.Date;

        import org.iesalandalus.programacion.utilidades.Entrada;

        public class MostrarPropiedades {

            public static void main(String[] args) {

                mostrarPropiedadesSistema();
                System.out.print("Escribe el nombre del fichero: ");
                String nombreFichero = Entrada.cadena();
                while(!nombreFichero.equals("FIN")) {
                    File fichero = new File(nombreFichero);
                    if (fichero.exists()) {
                        mostrarPropiedadesFichero(fichero);
                    } else {
                        System.out.printf("El fichero: %s No existe.%n", nombreFichero);
                    }
                    
                    System.out.print("Escribe el nombre del fichero: ");
                    nombreFichero = Entrada.cadena();
                }

            }

            private static void mostrarPropiedadesSistema() {
                System.out.println("Propiedades del sistema");
                System.out.println("=======================");
                System.out.printf("Separador del sistema: %s%n", File.separator);
                System.out.printf("Directorio de trabajo: %s%n", new File("").getAbsolutePath());
                System.out.printf("Directorio de trabajo (user.dir): %s%n%n", System.getProperty("user.dir"));
            }

            private static void mostrarPropiedadesFichero(File fichero) {
                System.out.printf("Fecha última modificación: %s%n", new Date(fichero.lastModified()));
                System.out.printf("Directorio? %s%n", fichero.isDirectory());
                System.out.printf("Fichero? %s%n", fichero.isFile());
                System.out.printf("Se puede escribir? %s%n", fichero.canWrite());
                System.out.printf("Se puede leer? %s%n", fichero.canRead());
                System.out.printf("Se puede ejecutar? %s%n", fichero.canExecute());
                System.out.printf("Camino absoluto: %s%n", fichero.getAbsolutePath());
                System.out.printf("Tamaño: %d%n", fichero.length());
                
                if (fichero.isDirectory()) {
                    System.out.println();
                    System.out.println("Contenido del directorio");
                    System.out.println("========================");
                    File[] ficheros = fichero.listFiles();
                    if (ficheros != null) {
                        for (File file : ficheros) {
                            if (file.isDirectory()) {
                                System.out.printf("D-> %s%n", file);
                            } else {
                                System.out.printf("A-> %s%n", file);
                            }
                        }
                    }
                }
                System.out.printf("---------------------------%n%n");
            }

        }
      ~~~

      [Descargar posible solución para el programa **MostrarPropiedades**](ejercicios/file/MostrarPropiedades.java)

- **Mostrar árbol**

  Escribir un programa en java que muestre por pantalla el árbol de contenidos de la carpeta actual.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.file;

        import org.iesalandalus.programacion.utilidades.Entrada;

        import java.io.File;

        public class MostrarArbol {

            public static void main(String[] args) {
                System.out.print("Introduce la carpeta a mostrar: ");
                String nombreCarpeta = Entrada.cadena();
                File carpeta = new File(nombreCarpeta);
                if (!carpeta.exists()) {
                    System.out.printf("%s NO existe.", nombreCarpeta);
                } else {
                    imprimeArbol(carpeta, "");
                }
            }

            private static void imprimeArbol(File carpeta, String tabulador) {
                File[] contenido = carpeta.listFiles();
                if (contenido != null) {
                    for (File file : contenido) {
                        if (file.isDirectory()) {
                            System.out.printf("%s|-%s%n", tabulador, file.getName());
                            imprimeArbol(file, tabulador + "|  ");
                        } else {
                            System.out.printf("%s+-%s%n", tabulador, file.getName());
                        }
                    }
                }
            }

        }
      ~~~

      [Descargar posible solución para el programa **MostrarArbol**](ejercicios/file/MostrarArbol.java)

###### Filtros

- **Filtrar ficheros con clase anónima**

  Escribir un programa en java que liste los ficheros comprendidos entre dos fechas introducidas por teclado de la carpeta actual. Utiliza una clase anónima.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.file;

        import java.io.File;
        import java.io.FileFilter;
        import java.sql.Timestamp;
        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;
        import java.time.format.DateTimeParseException;

        import org.iesalandalus.programacion.utilidades.Entrada;

        public class MostrarFicherosEntreDosFechasConFileFilterClaseAnonima {
            
            private static final String STR_FORMATO_FECHA = "dd/MM/yyyy";
            private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(STR_FORMATO_FECHA);
            private static final String NOMBRE_CARPETA = ".";

            public static void main(String[] args) {
                
                LocalDate fechaInicio = leerFecha(String.format("Introduce la fecha de inicio (%s): ", STR_FORMATO_FECHA));
                LocalDate fechaFin = leerFecha(String.format("Introduce la fecha de fin (%s): ", STR_FORMATO_FECHA));

                File carpeta = new File(NOMBRE_CARPETA);
                File[] contenido = carpeta.listFiles(new FileFilter() {
                    
                    @Override
                    public boolean accept(File fichero) {
                        LocalDate fechaFichero = getUltimaModificacion(fichero).toLocalDate();
                        return (fichero.isFile() && !fechaFichero.isBefore(fechaInicio)	&& !fechaFichero.isAfter(fechaFin));
                    }

                });
                
                if (contenido != null) {
                    for (File fichero : contenido) {
                        System.out.printf("%s: %s%n", fichero.getName(), 
                                getUltimaModificacion(fichero).toLocalDate().format(FORMATO_FECHA));
                    }
                }
            }

            private static LocalDateTime getUltimaModificacion(File fichero) {
                return new Timestamp(fichero.lastModified()).toLocalDateTime();
            }

            private static LocalDate leerFecha(String mensaje) {
                LocalDate fecha = null;
                boolean fechaValida;
                do {
                    try {
                        System.out.printf("%s", mensaje);
                        fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
                        fechaValida = true;
                    } catch (DateTimeParseException e) {
                        fechaValida = false;
                    }

                } while(!fechaValida);
                return fecha;
            }
        }
      ~~~

      [Descargar posible solución para el programa **MostrarFicherosEntreDosFechasConFileFilterClaseAnonima**](ejercicios/file/MostrarFicherosEntreDosFechasConFileFilterClaseAnonima.java)


- **Filtrar ficheros con función lambda**

  Escribir un programa en java que liste los ficheros comprendidos entre dos fechas introducidas por teclado de la carpeta actual. Utiliza una clase anónima.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.file;

        import java.io.File;
        import java.sql.Timestamp;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;
        import java.time.format.DateTimeParseException;

        import org.iesalandalus.programacion.utilidades.Entrada;

        public class MostrarFicherosEntreDosFechasConFileFilterLambda {
            
            private static final String STR_FORMATO_FECHA = "dd/MM/yyyy";
            private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(STR_FORMATO_FECHA);
            private static final String NOMBRE_CARPETA = ".";

            public static void main(String[] args) {
                
                LocalDate fechaInicio = leerFecha(String.format("Introduce la fecha de inicio (%s): ", STR_FORMATO_FECHA));
                LocalDate fechaFin = leerFecha(String.format("Introduce la fecha de fin (%s): ", STR_FORMATO_FECHA));

                File carpeta = new File(NOMBRE_CARPETA);
                File[] contenido = carpeta.listFiles(fichero -> {
                    LocalDate fechaFichero = getUltimaModificacion(fichero);
                    return (fichero.isFile() && !fechaFichero.isBefore(fechaInicio) && !fechaFichero.isAfter(fechaFin));
                });
                
                if (contenido != null) {
                    for (File fichero : contenido) {
                        System.out.printf("%s: %s%n", fichero.getName(), 
                                getUltimaModificacion(fichero).format(FORMATO_FECHA));
                    }
                }
            }

            private static LocalDate getUltimaModificacion(File fichero) {
                return new Timestamp(fichero.lastModified()).toLocalDateTime().toLocalDate();
            }

            private static LocalDate leerFecha(String mensaje) {
                LocalDate fecha = null;
                boolean fechaValida;
                do {
                    try {
                        System.out.printf("%s", mensaje);
                        fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
                        fechaValida = true;
                    } catch (DateTimeParseException e) {
                        fechaValida = false;
                    }

                } while(!fechaValida);
                return fecha;
            }
        }
      ~~~

      [Descargar posible solución para el programa **MostrarFicherosEntreDosFechasConFileFilterLambda**](ejercicios/file/MostrarFicherosEntreDosFechasConFileFilterLambda.java)

###### Flujos de caracteres

- **Mostrar fichero de texto**

  Escribir un programa en java que muestre un fichero de texto por consola, utilizando flujos.

    - Posible solución
      ~~~java
          package org.iesalandalus.programacion.ficheros.secuencial.caracteres.flujos;
  
          import java.io.*;
  
          public class MostrarFicheroTexto {
  
              private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroTexto.txt");
              
              public static void main(String[] args) {
                  try (FileReader entrada = new FileReader(FICHERO)){
                      int dato;
                      while ((dato = entrada.read()) != -1) {
                          System.out.print((char) dato);
                      }
                  } catch (FileNotFoundException e) {
                      System.out.println("No se puede leer el fichero de entrada");
                  } catch (IOException e) {
                      System.out.println("Error inesperado de Entrada/Salida");
                  }
              }
  
          }
      ~~~

      [Descargar posible solución para el programa **MostrarFicheroTexto**](ejercicios/caracteres/flujos/MostrarFicheroTexto.java)

- **Escribir fichero de texto**

  Escribir un programa en java que escriba en un fichero de texto todo lo que introducimos por consola mientras no se lea el caracter `|`, utilizando flujos.

    - Posible solución
      ~~~java
          package org.iesalandalus.programacion.ficheros.secuencial.caracteres.flujos;
  
          import java.io.*;
  
          public class EscribirFicheroTexto {
              
              private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "salidaFicheroTexto.txt");
              
              public static void main(String[] args) {
                  try (FileWriter salida = new FileWriter(FICHERO);
                      InputStreamReader entrada = new InputStreamReader(System.in)){
                      int dato;
                      while ((dato = entrada.read()) != '|') {
                          salida.write((char)dato);
                      }
                  } catch (FileNotFoundException e) {
                      System.out.printf("No existe el fichero de destino: %s%n", FICHERO);
                  }
                  catch (IOException e) {
                      System.out.println("Error inesperado de Entrada/Salida");
                  }
              }
  
          }
      ~~~

      [Descargar posible solución para el programa **EscribirFicheroTexto**](ejercicios/caracteres/flujos/EscribirFicheroTexto.java)

- **Copiar fichero de texto**

  Escribir un programa en java que copie un fichero de texto en otro, utilizando flujos.

    - Posible solución
      ~~~java
          package org.iesalandalus.programacion.ficheros.secuencial.caracteres.flujos;
  
          import java.io.*;
  
          public class CopiarFicheroTexto {
              
              private static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroTextoGrande.txt");
              private static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "salidaFicheroTexto.txt");
              
              public static void main(String[] args) {
                  try (FileReader entrada = new FileReader(FICHERO_ENTRADA); FileWriter salida = new FileWriter(FICHERO_SALIDA)){
                      int dato;
                      while ((dato = entrada.read()) != -1) {
                          salida.write((char)dato);
                      }
                      System.out.println("Fichero copiado satisfactoriamente.");
                  } catch (FileNotFoundException e) {
                      if (e.getMessage().startsWith(FICHERO_ENTRADA)) {
                          System.out.printf("No existe el fichero de origen: %s%n", FICHERO_ENTRADA);
                      } else {
                          System.out.printf("No existe el directorio de destino o no tengo permiso de escritura: %s%n", FICHERO_SALIDA);
                      }
                  } catch (IOException e) {	
                      System.out.println("Error inesperado de Entrada/Salida.");
                  } 
              }
  
          }
      ~~~

      [Descargar posible solución para el programa **CopiarFicheroTexto**](ejercicios/caracteres/flujos/CopiarFicheroTexto.java)

###### Buferes de caracteres

- **Mostrar fichero de texto**

  Escribir un programa en java que muestre un fichero de texto por consola, utilizando buferes.

    - Posible solución
      ~~~java
          package org.iesalandalus.programacion.ficheros.secuencial.caracteres.buffers;
  
          import java.io.BufferedReader;
          import java.io.File;
          import java.io.FileNotFoundException;
          import java.io.FileReader;
          import java.io.IOException;
  
          public class MostrarFicheroTexto {
              
              private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroTexto.txt");
              
              public static void main(String[] args) {
                  try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO))){
                      String linea;
                      while ((linea = entrada.readLine()) != null) {
                          System.out.println(linea);
                      }
                  } catch (FileNotFoundException e) {
                      System.out.println("No se puede leer el fichero de entrada.");
                  } catch (IOException e) {
                      System.out.println("Error inesperado de Entrada/Salida.");
                  }
              }
          }
      ~~~

      [Descargar posible solución para el programa **MostrarFicheroTexto**](ejercicios/caracteres/buffers/MostrarFicheroTexto.java)

- **Copiar fichero de texto**

  Escribir un programa en java que copie un fichero de texto en otro, utilizando buferes.

    - Posible solución
      ~~~java
          package org.iesalandalus.programacion.ficheros.secuencial.caracteres.buffers;
  
          import java.io.BufferedReader;
          import java.io.BufferedWriter;
          import java.io.File;
          import java.io.FileNotFoundException;
          import java.io.FileReader;
          import java.io.FileWriter;
          import java.io.IOException;
  
          public class CopiarFicheroTexto {
  
              private static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroTextoGrande.txt");
              private static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "salidaFicheroTexto.txt");
              
              public static void main(String[] args) {
                  try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO_ENTRADA)); BufferedWriter salida = new BufferedWriter(new FileWriter(FICHERO_SALIDA))){
                      String linea;
                      while ((linea = entrada.readLine()) != null) {
                          salida.write(linea);
                          salida.newLine();
                      }
                      System.out.println("Fichero copiado satisfactoriamente.");
                  } catch (FileNotFoundException e) {
                      if (e.getMessage().startsWith(FICHERO_ENTRADA)) {
                          System.out.printf("No existe el fichero de origen: %s%n", FICHERO_ENTRADA);
                      } else {
                          System.out.printf("No existe el directorio de destino o no tengo permiso de escritura: %s%n", FICHERO_SALIDA);
                      }
                  } catch (IOException e) {	
                      System.out.println("Error inesperado de Entrada/Salida.");
                  } 
              }
  
          }
      ~~~

      [Descargar posible solución para el programa **CopiarFicheroTexto**](ejercicios/caracteres/buffers/CopiarFicheroTexto.java)

###### Flujos binarios

- **Mostrar fichero binario**

  Escribir un programa en java que muestre un fichero binario por consola, utilizando flujos. La salida debe ser similar a la salida del comando `hexdump -C`.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.secuencial.bytes.flujos;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;

        public class MostrarFicheroBinario {
            
            public static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioPeque.bin");
            
            public static void main(String[] args) {

                File ficheroEntrada = new File(FICHERO);
                try (FileInputStream entrada = new FileInputStream(ficheroEntrada)){
                    mostrarFichero(entrada);
                } catch (FileNotFoundException e) {
                    System.out.println("No se puede leer el fichero de entrada");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida");
                }
            }

            private static void mostrarFichero(FileInputStream entrada) throws IOException {
                int dato;
                int numBytes = 0;
                int desplazamiento = 0;
                StringBuilder lineaHexa = new StringBuilder();
                StringBuilder lineaChar = new StringBuilder();
                while ((dato = entrada.read()) != -1) {
                    numBytes++;
                    lineaHexa.append(String.format("%02x ", dato));
                    lineaChar.append((32 <= dato && 126 >= dato) ? (char)dato : ".");
                    if (numBytes == 8)
                        lineaHexa.append(" ");
                    if (numBytes == 16) {
                        System.out.printf("%08x %s |%s|%n",  desplazamiento, lineaHexa, lineaChar);
                        numBytes = 0;
                        desplazamiento += 16;
                        lineaHexa.delete(0, lineaHexa.capacity());
                        lineaChar.delete(0, lineaChar.capacity());
                    }
                }
                System.out.printf("%08x %-49s |%-16s|%n",  desplazamiento, lineaHexa, lineaChar);
            }
        }
      ~~~

      [Descargar posible solución para el programa **MostrarFicheroBinario**](ejercicios/bytes/flujos/MostrarFicheroBinario.java)

- **Copiar fichero binario**

  Escribir un programa en java que copie un fichero binario en otro, utilizando flujos.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.secuencial.bytes.flujos;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;

        public class CopiarFicheroBinario {

            private static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioGrande.bin");
            private static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "SalidaFicheroBinarioGrande.bin");

            public static void main(String[] args) {
                try (FileInputStream entrada = new FileInputStream(FICHERO_ENTRADA); FileOutputStream salida = new FileOutputStream(FICHERO_SALIDA)) {
                    copiarFichero(entrada, salida);
                } catch (FileNotFoundException e) {
                    if (e.getMessage().startsWith(FICHERO_ENTRADA)) {
                        System.out.printf("No existe el fichero de origen: %s%n", FICHERO_ENTRADA);
                    } else {
                        System.out.printf("No existe el directorio de destino o no tengo permiso de escritura: %s%n", FICHERO_SALIDA);
                    }
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
            }

            private static void copiarFichero(FileInputStream entrada, FileOutputStream salida) {
                try {
                    int dato;
                    while ((dato = entrada.read()) != -1) {
                        salida.write(dato);
                    }
                    System.out.println("Fichero copiado satisfactoriamente.");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
            }
        }
      ~~~

      [Descargar posible solución para el programa **CopiarFicheroBinario**](ejercicios/bytes/flujos/CopiarFicheroBinario.java)

###### Buferes binarios

- **Mostrar fichero binario**

  Escribir un programa en java que muestre un fichero binario por consola, utilizando buferes. La salida debe ser similar a la salida del comando `hexdump -C`.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.secuencial.bytes.buffers;

        import java.io.BufferedInputStream;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;

        public class MostrarFicheroBinario {

            public static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioPeque.bin");
            
            public static void main(String[] args) {
                File ficheroEntrada = new File(FICHERO);
                try (BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(ficheroEntrada))){
                    mostrarFichero(entrada);
                } catch (FileNotFoundException e) {
                    System.out.println("No se puede leer el fichero de entrada");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida");
                }
            }

            private static void mostrarFichero(BufferedInputStream entrada) throws IOException {
                int numBytes = 0;
                int desplazamiento = 0;
                StringBuilder lineaHexa = new StringBuilder();
                StringBuilder lineaChar = new StringBuilder();
                byte[] linea = new byte[16];
                while ((numBytes = entrada.read(linea)) != -1) {
                    for (int i = 0; i < 16; i++) {
                        if (i == 8)
                            lineaHexa.append(" ");
                        if (numBytes > i) {
                            lineaHexa.append(String.format("%02x ", linea[i]));
                            lineaChar.append((32 <= linea[i] && 126 >= linea[i]) ? (char)linea[i] : ".");
                        } else {
                            lineaHexa.append("   ");
                            lineaChar.append(" ");
                        }
                    }
                    System.out.printf("%08x %-48s |%-16s|%n",  desplazamiento, lineaHexa, lineaChar);
                    desplazamiento += 16;
                    lineaHexa.delete(0, lineaHexa.capacity());
                    lineaChar.delete(0, lineaChar.capacity());
                }
            }

        }
      ~~~

      [Descargar posible solución para el programa **MostrarFicheroBinario**](ejercicios/bytes/buffers/MostrarFicheroBinario.java)

- **Copiar fichero binario**

  Escribir un programa en java que copie un fichero binario en otro, utilizando buferes.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.secuencial.bytes.buffers;

        import java.io.BufferedInputStream;
        import java.io.BufferedOutputStream;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;

        public class CopiarFicheroBinario {
            
            private static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioGrande.bin");
            private static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "SalidaFicheroBinarioGrande.bin");
            
            public static void main(String[] args) {
                try (BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(FICHERO_ENTRADA)); BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(FICHERO_SALIDA))){
                    copiarFichero(entrada, salida);
                } catch (FileNotFoundException e) {
                    if (e.getMessage().startsWith(FICHERO_ENTRADA)) {
                        System.out.printf("No existe el fichero de origen: %s%n", FICHERO_ENTRADA);
                    } else {
                        System.out.printf("No existe el directorio de destino o no tengo permiso de escritura: %s%n", FICHERO_SALIDA);
                    }
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                } 
            }

            private static void copiarFichero(BufferedInputStream entrada, BufferedOutputStream salida) {
                try {
                    byte[] datos = new byte[1024];
                    while (entrada.read(datos) != -1) {
                        salida.write(datos);
                    }
                    System.out.println("Fichero copiado satisfactoriamente.");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida");
                }
            }


        }
      ~~~

      [Descargar posible solución para el programa **CopiarFicheroBinario**](ejercicios/bytes/buffers/CopiarFicheroBinario.java)

###### Datos primitivos

- **Leer fichero de datos primitivos**

  Escribir un programa en java que muestre los datos almacenados en un fichero de datos primitivos cuyo orden de escritura ha sido: `String`, `int` y `double`.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.secuencial.bytes.datosprimitivos;

        import java.io.*;

        public class LeerFicheroDatos {
            
            private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroDatos.bin");
            
            public static void main(String[] args) {		
                try (DataInputStream entrada = new DataInputStream(new FileInputStream(FICHERO))){
                    mostrarDatos(entrada);
                } catch (FileNotFoundException e) {
                    System.out.println("No se puede leer el fichero de entrada");
                } catch (IOException e) {
                    System.out.printf("No existe el fichero de origen: %s%n", FICHERO);
                }
            }

            private static void mostrarDatos(DataInputStream entrada) throws IOException {
                try {
                    String datoString = "";
                    int datoInt;
                    double datoDouble;
                    while (datoString != null) { //Esta condición siempre será verdadera
                        datoString = entrada.readUTF();
                        datoInt = entrada.readInt();
                        datoDouble = entrada.readDouble();
                        System.out.printf("Cadena: %s\tEntero: %s\tDoble: %s%n", datoString, datoInt, datoDouble);
                    }
                } catch (EOFException e) {
                    System.out.println("Fichero leído satisfactoriamente.");
                }
            }

        }
      ~~~

      [Descargar posible solución para el programa **LeerFicheroDatos**](ejercicios/bytes/datosprimitivos/LeerFicheroDatos.java)

- **Escribir fichero de datos primitivos**

  Escribir un programa en java que escriba un fichero con datos primitivos en este orden: `String`, `int` y `double`. Debe escribir 10 de cada uno de ellos.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.secuencial.bytes.datosprimitivos;

        import java.io.*;

        public class EscribirFicheroDatos {

            private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroDatos.bin");

            public static void main(String[] args) {

                try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(FICHERO))) {
                    escribirDatos(salida);
                } catch (FileNotFoundException e) {
                    System.out.println("No se puede leer el fichero de salida");
                } catch (IOException e) {
                    System.out.printf("No existe el fichero: %s%n", FICHERO);
                }
            }

            private static void escribirDatos(DataOutputStream salida) throws IOException {
                String datoString;
                int datoInt;
                double datoDouble;
                for (int i = 0; i < 10; i++) {
                    datoString = "Cadena número: " + i;
                    datoInt = 10 * i;
                    datoDouble = datoInt / 100.0;
                    salida.writeUTF(datoString);
                    salida.writeInt(datoInt);
                    salida.writeDouble(datoDouble);
                }
                System.out.println("Fichero creado satisfactoriamente");
            }

        }
      ~~~

      [Descargar posible solución para el programa **EscribirFicheroDatos**](ejercicios/bytes/datosprimitivos/EscribirFicheroDatos.java)

###### Serialización de objetos

Dada la siguiente clase `Persona`, realiza los ejercicios que se proponen a contincuación.
~~~java
package org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {
	
	private String nombre;
	private int edad;

	public Persona(String nombre, int edad) {
		setNombre(nombre);
		setEdad(edad);
	}

	public void setNombre(String nombre) {
		this.nombre = Objects.requireNonNull(nombre, "El nombre de una persona no puede ser nulo.");
		if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre de una persona no puede estar vacío.");
		}
	}

	public void setEdad(int edad) {
		if (edad <= 0) {
			throw new IllegalArgumentException("La edad de una persona no puede ser menor o igual a cero.");
		}
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Persona persona)) return false;
		return Objects.equals(nombre, persona.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public String toString() {
		return String.format("Persona [nombre=%s, edad=%s]", nombre, edad);
	}
	
}
~~~

- **Leer fichero de objetos**

  Escribir un programa en java que muestre los objetos de la clase `Persona` almacenados en un fichero de objetos.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos;

        import java.io.*;

        public class LeerObjetos {
            
            private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
            
            public static void main(String[] args) {
                try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO))) {
                    Persona persona;
                    while ((persona = (Persona) entrada.readObject()) != null) {
                        System.out.printf("Nombre: %s, edad: %d%n", persona.getNombre(), persona.getEdad());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("No puedo crear el fichero de entrada.");
                } catch (EOFException eo) {
                    System.out.println("Fichero leído satisfactoriamente.");
                } catch (ClassNotFoundException e) {
                    System.out.println("No puedo encontrar la clase que tengo que leer.");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
            }

        }
      ~~~

      [Descargar posible solución para el programa **LeerObjetos**](ejercicios/bytes/objetos/LeerObjetos.java)

- **Escribir fichero de objetos**

  Escribir un programa en java que escriba en un fichero 10 instancias de la clase `Persona`.

    - Posible solución
      ~~~java
        package org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.ObjectOutputStream;

        public class EscribirObjetos {
            
            private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");

            public static void main(String[] args) {
                Persona persona;
                String[] nombres = { "Juan", "Alfonso", "Araceli", "Manolo", "Rubén", "Elvira", "Inés", "José Ramón" };
                int[] edades = { 31, 35, 25, 40, 37, 18, 20, 22 };
                try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO))){
                    for (int i = 0; i < edades.length; i++) {
                        persona = new Persona(nombres[i], edades[i]);
                        salida.writeObject(persona);
                    }
                    System.out.println("Fichero escrito satisfactoriamente.");
                } catch (FileNotFoundException e) {
                    System.out.println("No puedo crear el fichero de salida.");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
            }

        }
      ~~~

      [Descargar posible solución para el programa **EscribirObjetos**](ejercicios/bytes/objetos/EscribirObjetos.java)

###### Acceso aleatorio

Dada la siguiente clase `Amigo`, realiza los ejercicios que se proponen a contincuación.
~~~java
package org.iesalandalus.programacion.ficheros.aleatorio.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Amigo {
	
	private static final String ER_TELEFONO = "\\d{9}";
	private static final String ER_CORREO = "\\w+(?:\\.\\w+)*+@\\w+\\.\\w{2,5}";
	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	protected String nombre;
	protected String telefono;
	protected String correo;
	protected String direccion;
	protected LocalDate fechaNacimiento;
	protected double peso;		
	protected int altura;		
	
	public Amigo() {
	}
	
	public Amigo(String nombre, String telefono, String correo, String direccion, LocalDate fechaNacimiento, double peso, int altura) {
		setNombre(nombre);
		setTelefono(telefono);
		setCorreo(correo);
		setDireccion(direccion);
		setFechaNacimiento(fechaNacimiento);
		setPeso(peso);
		setAltura(altura);
	}
	
	public Amigo(String nombre, String telefono, String correo, String direccion, String fechaNacimiento, double peso, int altura) {
		setNombre(nombre);
		setTelefono(telefono);
		setCorreo(correo);
		setDireccion(direccion);
		setFechaNacimiento(fechaNacimiento);
		setPeso(peso);
		setAltura(altura);
	}
	
	public Amigo(Amigo amigo) {
		Objects.requireNonNull(amigo, "El amigo a copiar no puede ser nulo.");
		nombre = amigo.nombre;
		telefono = amigo.telefono;
		correo = amigo.correo;
		direccion = amigo.direccion;
		fechaNacimiento = amigo.fechaNacimiento;
		peso = amigo.peso;
		altura = amigo.altura;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
		if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío.");
		}
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		Objects.requireNonNull(telefono,"El teléfono no puede ser nulo.");
		if (!telefono.matches(ER_TELEFONO)) {
			throw new IllegalArgumentException("El formato del teléfono no es correcto.");
		}
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		Objects.requireNonNull(correo, "El correo no puede ser nulo.");
		if (!correo.matches(ER_CORREO)) {
			throw new IllegalArgumentException("El formato del correo no es correcto.");
		}
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		Objects.requireNonNull(direccion, "La dirección no puede ser nula.");
		if (direccion.isBlank()) {
			throw new IllegalArgumentException("La dirección no puede estar vacía.");
		}
		this.direccion = direccion;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getFechaNacimientoStr() {
		return FORMATO_DIA.format(fechaNacimiento);
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		Objects.requireNonNull(fechaNacimiento, "La fecha de nacimiento no puede ser nula.");
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		Objects.requireNonNull(fechaNacimiento, "La fecha de nacimiento no puede ser nula.");
		try {
			this.fechaNacimiento = LocalDate.parse(fechaNacimiento, FORMATO_DIA);
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Formato de la fecha de nacimiento incorrecto.");
		}
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if (peso <= 0) {
			throw new IllegalArgumentException("El peso debe ser mayor que cero.");
		}
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		if (altura <= 0) {
			throw new IllegalArgumentException("La altura debe ser mayor que cero.");
		}
		this.altura = altura;
	}
	
	public int compareTo(Amigo amigo) {
		return this.getNombre().compareTo(amigo.getNombre());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Amigo amigo)) return false;
		return Objects.equals(nombre, amigo.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public String toString() {
		return String.format(
				"Amigo [nombre=%s, teléfono=%s, correo=%s, dirección=%s, fechaNacimiento=%s, peso=%s, altura=%s]",
				nombre, telefono, correo, direccion, fechaNacimiento.format(FORMATO_DIA), peso, altura);
	}
	
}
~~~
- **Agenda de amigos**

  Escribir un programa en java que cree una agenda de amigos, basándote en la clase `Amigo`. Con la agenda se podrán realizar las operaciones básicas: insertar, borrar, buscar, etc.

    - Posible solución

      `RegistroAmigo.java`
      ~~~java
        package org.iesalandalus.programacion.ficheros.aleatorio.modelo.dao;

        import java.io.IOException;
        import java.io.RandomAccessFile;
        import java.util.Arrays;

        import org.iesalandalus.programacion.ficheros.aleatorio.modelo.dominio.Amigo;

        public class RegistroAmigo extends Amigo {
            private static final int LONGITUD_NOMBRE = 75; 			// 150 bytes =  75 caracteres * 2 byte/caracter UNICODE
            private static final int LONGITUD_TELEFONO = 9;			//  18 bytes =   9 caracteres * 2 byte/caracter UNICODE
            private static final int LONGITUD_CORREO = 50;			// 100 bytes =  50 caracteres * 2 byte/caracter UNICODE
            private static final int LONGITUD_DIRECCION = 100;		// 200 bytes = 100 caracteres * 2 byte/caracter UNICODE
            private static final int LONGITUD_F_NACIMIENTO = 10;	//  20 bytes =  10 caracteres * 2 byte/caracter UNICODE
            private static final int LONGITUD_PESO = 8;				//   8 bytes ocupa un double
            private static final int LONGITUD_ALTURA = 4;			//   4 bytes ocupa un integer
            static final int LONGITUD = LONGITUD_NOMBRE  * 2 + LONGITUD_TELEFONO * 2 + LONGITUD_CORREO * 2 +
                    LONGITUD_DIRECCION * 2 + LONGITUD_F_NACIMIENTO * 2 + LONGITUD_PESO + LONGITUD_ALTURA;
            
            public RegistroAmigo() {
                super();
            }
            
            public RegistroAmigo(Amigo amigo) {
                super(amigo);
            }

            public void leer(RandomAccessFile fichero) throws IOException {
                leerNombre(fichero);
                leerTelefono(fichero);
                leerCorreo(fichero);
                leerDireccion(fichero);
                leerFechaNacimiento(fichero);
                leerPeso(fichero);
                leerAltura(fichero);
            }

            public void escribir(RandomAccessFile fichero) throws IOException {
                escribirNombre(fichero);
                escribirTelefono(fichero);
                escribirCorreo(fichero);
                escribirDireccion(fichero);
                escribirFechaNacimiento(fichero);
                escribirPeso(fichero);
                escribirAltura(fichero);
            }
            
            private void leerNombre(RandomAccessFile fichero) throws IOException {
                setNombre(leerCadena(fichero, LONGITUD_NOMBRE));
            }
            
            private void escribirNombre(RandomAccessFile fichero) throws IOException {
                escribirCadena(fichero, getNombre(), LONGITUD_NOMBRE);
            }
            
            private void leerTelefono(RandomAccessFile fichero) throws IOException {
                setTelefono(leerCadena(fichero, LONGITUD_TELEFONO));
            }
            
            private void escribirTelefono(RandomAccessFile fichero) throws IOException {
                escribirCadena(fichero, getTelefono(), LONGITUD_TELEFONO);
            }

            private void leerCorreo(RandomAccessFile fichero) throws IOException {
                setCorreo(leerCadena(fichero, LONGITUD_CORREO));
            }
            
            private void escribirCorreo(RandomAccessFile fichero) throws IOException {
                escribirCadena(fichero, getCorreo(), LONGITUD_CORREO);
            }
            
            private void leerDireccion(RandomAccessFile fichero) throws IOException {
                setDireccion(leerCadena(fichero, LONGITUD_DIRECCION));
            }
            
            private void escribirDireccion(RandomAccessFile fichero) throws IOException {
                escribirCadena(fichero, getDireccion(), LONGITUD_DIRECCION);
            }
            
            private void leerFechaNacimiento(RandomAccessFile fichero) throws IOException {
                setFechaNacimiento(leerCadena(fichero, LONGITUD_F_NACIMIENTO));
            }
            
            private void escribirFechaNacimiento(RandomAccessFile fichero) throws IOException {
                escribirCadena(fichero, getFechaNacimientoStr(), LONGITUD_F_NACIMIENTO);
            }
            
            private void leerPeso(RandomAccessFile fichero) throws IOException {
                setPeso(fichero.readDouble());
            }
            
            private void escribirPeso(RandomAccessFile fichero) throws IOException {
                fichero.writeDouble(getPeso());
            }
            
            private void leerAltura(RandomAccessFile fichero) throws IOException {
                setAltura(fichero.readInt());
            }
            
            private void escribirAltura(RandomAccessFile fichero) throws IOException {
                fichero.writeInt(getAltura());
            }
            
            private String leerCadena(RandomAccessFile fichero, int tamano) throws IOException {
                char[] campo = new char[tamano];
                for (int i = 0; i < tamano; i++) {
                    campo[i] = fichero.readChar();
                }
                return new String(campo).trim();
            }

            private void escribirCadena(RandomAccessFile fichero, String cadena, int tamano) throws IOException {
                char[] arrayCadena = Arrays.copyOf(cadena.toCharArray(), tamano);
                fichero.writeChars(new String(arrayCadena));
            }

        }
      ~~~
      `Agenda.java`
      ~~~java
        package org.iesalandalus.programacion.ficheros.aleatorio.modelo.dao;

        import java.io.File;
        import java.io.IOException;
        import java.io.RandomAccessFile;

        import org.iesalandalus.programacion.ficheros.aleatorio.modelo.dominio.Amigo;

        public class Agenda {
            
            private static final String FICHERO_AMIGOS = String.format("%s%s%s", "ficheros", File.separator, "amigos.dat");

            private RandomAccessFile fichero;

            public void abrir() throws IOException {
                fichero = new RandomAccessFile(FICHERO_AMIGOS, "rw");
            }

            public void cerrar() throws IOException {
                if (fichero != null) {
                    fichero.close();
                }
            }

            public RegistroAmigo leer() {
                RegistroAmigo registro = null;
                if (fichero != null) {
                    try {
                        registro = new RegistroAmigo();
                        registro.leer(fichero);
                    } catch (Exception error) {
                        registro = null;
                    }
                }
                return registro;
            }

            public RegistroAmigo leer(long indice) throws IOException {
                if (fichero != null) {
                    fichero.seek((indice - 1) * RegistroAmigo.LONGITUD);
                }
                return leer();
            }
            
            public void escribir(Amigo amigo) throws IOException {
                RegistroAmigo registro = new RegistroAmigo(amigo);
                if (fichero != null) {
                    registro.escribir(fichero);
                }
            }

            public void escribir(Amigo amigo, long indice) throws IOException {
                if (fichero != null) {
                    fichero.seek((indice - 1) * RegistroAmigo.LONGITUD);
                    escribir(amigo);
                }
            }
            
            public long getNumRegistros() throws IOException {
                return fichero.length() / RegistroAmigo.LONGITUD;
            }
            
            protected void setNumRegistros(long numRegistros) throws IOException {
                fichero.setLength(numRegistros * RegistroAmigo.LONGITUD);
            }
            
            public void listar() throws IOException {
                fichero.seek(0);
                for (long i = 1; i <= getNumRegistros(); i++) {
                    System.out.println(leer(i));
                }
            }

            public void limpiar() throws IOException {
                fichero.setLength(0);
            }
            
            public void borrar(Amigo amigo) throws IOException {
                long indice = buscar(amigo);
                if (indice != -1) {
                    desplazarIzquierda(indice);
                }
            }
            
            public long buscar(Amigo amigo) throws IOException {
                boolean encontrado = false;
                RegistroAmigo registro = null;
                long indiceRegistro = 1;
                while (indiceRegistro <= getNumRegistros() && !encontrado) {
                    registro = leer(indiceRegistro++);
                    encontrado = amigo.compareTo(registro) == 0;
                }
                return (encontrado) ? indiceRegistro - 1 : -1;
            }
            
            protected void desplazarIzquierda(long posicion) throws IOException {
                long numRegistros = getNumRegistros();	
                Amigo registroAuxiliar = null;
                for (long i = posicion; i < numRegistros; i++) {
                    registroAuxiliar = leer(i + 1);
                    escribir(registroAuxiliar, i);
                }
                setNumRegistros(numRegistros - 1);
            }

        }
      ~~~
      `MainApp.java`
      ~~~java
        package org.iesalandalus.programacion.ficheros.aleatorio;

        import java.io.IOException;

        import org.iesalandalus.programacion.ficheros.aleatorio.modelo.dao.Agenda;
        import org.iesalandalus.programacion.ficheros.aleatorio.modelo.dominio.Amigo;

        public class MainApp {
            public static void main(String[] args) throws IOException {
                Amigo amigo1 = new Amigo("Paco Jones", "950456789", "paco.jones@iesalandalus.org", 
                        "Parque", "01/02/2003", 75.4, 183);
                Amigo amigo2 = new Amigo("Juan Sin Miedo", "950122223", "juansinmiedo@iesalandalus.org",
                        "Casa de los Horrores", "11/12/2013", 65.8, 150);
                Amigo amigo3 = new Amigo("Bob Esponja", "950233445", "bobesponja@iesalandalus.org",
                        "Fondo de Bikini", "05/06/2007", 25.8, 100);
                
                Agenda agenda = new Agenda();
                agenda.abrir();
                agenda.escribir(amigo1);
                agenda.escribir(amigo2);
                agenda.escribir(amigo3);
                agenda.cerrar();
                agenda.abrir();
                agenda.listar();
                System.out.printf("Posición amigo1: %s%n", agenda.buscar(amigo1));
                agenda.borrar(amigo1);
                agenda.listar();
                System.out.printf("Posición amigo2: %s%n", agenda.buscar(amigo2));
                agenda.borrar(amigo2);
                agenda.listar();
                System.out.printf("Posición amigo3: %s%n", agenda.buscar(amigo3));
                agenda.borrar(amigo3);
                agenda.listar();

                agenda.cerrar();
            }

        }
      ~~~
      [Acceder a la posible solución para el programa **Agenda de amigos**](https://github.com/JRJimenezReyes/Ficheros/tree/master/src/main/java/org/iesalandalus/programacion/ficheros/aleatorio)
- **Agenda ordenada de amigos**

  Escribir un programa en java que cree una agenda ordenada de amigos, basándote en la anterior.
    - Posible solución

      `AgendaOrdenada.java`
      ~~~java
        package org.iesalandalus.programacion.ficheros.aleatorio.modelo.dao;

        import java.io.IOException;

        import org.iesalandalus.programacion.ficheros.aleatorio.modelo.dominio.Amigo;

        public class AgendaOrdenada extends Agenda {
            
            public AgendaOrdenada() {
                super();
            }
            
            public void insertar(Amigo amigo) throws IOException {
                long indice = buscar(amigo);
                if (indice != -1) {
                    desplazarDerecha(indice);
                    escribir(amigo, indice);
                } else {
                    escribir(amigo);
                }
            }
            
            @Override
            public long buscar(Amigo amigo) throws IOException {
                return busquedaBinaria(amigo, 1, getNumRegistros());
            }

            @Override
            public void borrar(Amigo amigo) throws IOException {
                long indice = busquedaBinaria(amigo, 1, getNumRegistros());
                if (indice != -1) {
                    desplazarIzquierda(indice);
                }
            }

            private long busquedaBinaria(Amigo amigo, long izquierda, long derecha) throws IOException {
                long indice = -1;
                long mitad = (izquierda + derecha) / 2;
                if (izquierda <= derecha) {
                    Amigo amigoMitad = leer(mitad);
                    if (amigo.compareTo(amigoMitad) < 0)
                        indice = busquedaBinaria(amigo, izquierda, mitad - 1);
                    else {
                        if (amigo.compareTo(amigoMitad) == 0)
                            indice = mitad;
                        else
                            indice = busquedaBinaria(amigo, mitad + 1, derecha);
                    }
                } else {
                    indice = mitad + 1;
                }
                return indice;
            }

            private void desplazarDerecha(long indice) throws IOException {
                long numRegistros = getNumRegistros();
                setNumRegistros(numRegistros + 1);
                Amigo amigoAuxiliar = null;
                for (long i = numRegistros; i > indice - 1; i--) {
                    amigoAuxiliar = leer(i);
                    escribir(amigoAuxiliar, i + 1);
                }
            }

        }
      ~~~
      `MainAppOrdenada.java`
      ~~~java
        package org.iesalandalus.programacion.ficheros.aleatorio;

        import java.io.IOException;

        import org.iesalandalus.programacion.ficheros.aleatorio.modelo.dao.AgendaOrdenada;
        import org.iesalandalus.programacion.ficheros.aleatorio.modelo.dominio.Amigo;

        public class MainAppOrdenada {
            public static void main(String[] args) throws IOException {
                Amigo amigo1 = new Amigo("Paco Jones", "950456789", "paco.jones@iesalandalus.org", 
                        "Parque", "01/02/2003", 75.4, 183);
                Amigo amigo2 = new Amigo("Juan Sin Miedo", "950122223", "juansinmiedo@iesalandalus.org",
                        "Casa de los Horrores", "11/12/2013", 65.8, 150);
                Amigo amigo3 = new Amigo("Bob Esponja", "950233445", "bobesponja@iesalandalus.org",
                        "Fondo de Bikini", "05/06/2007", 25.8, 100);
                
                AgendaOrdenada agenda = new AgendaOrdenada();
                agenda.abrir();
                agenda.insertar(amigo1);
                agenda.insertar(amigo2);
                agenda.insertar(amigo3);
                agenda.cerrar();
                agenda.abrir();
                agenda.listar();
                System.out.printf("Posición amigo1: %s%n", agenda.buscar(amigo1));
                agenda.borrar(amigo1);
                agenda.listar();
                System.out.printf("Posición amigo2: %s%n", agenda.buscar(amigo2));
                agenda.borrar(amigo2);
                agenda.listar();
                System.out.printf("Posición amigo3: %s%n", agenda.buscar(amigo3));
                agenda.borrar(amigo3);
                agenda.listar();

                agenda.cerrar();
            }

        }
      ~~~
      [Acceder a la posible solución para el programa **Agenda de amigos**](https://github.com/JRJimenezReyes/Ficheros/tree/master/src/main/java/org/iesalandalus/programacion/ficheros/aleatorio)

###### Ficheros CSV

- **Convertir CSV en fichero de objetos**

  Escribir un programa en java que lea un fichero CSV con datos sobre una persona y los escriba como un fichero de objetos.
    - Posible solución

      ~~~java
        package org.iesalandalus.programacion.csv;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.ObjectOutputStream;
        import java.util.ArrayList;
        import java.util.List;

        import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;

        public class ConvertirCSVAFicheroObjetos {
            
            private static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
            private static final String FICHERO_CSV = String.format("%s%s%s", "ficheros", File.separator, "personas.csv");
            
            private static final String SEPARADOR = ",";
            
            public static void main(String[] args) {
                List<Persona> personas = leerCSV();
                escribirFicheroObjetos(personas);
            }
            
            private static List<Persona> leerCSV() {
                List<Persona> personas = new ArrayList<>();
                try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO_CSV))){
                    String linea;
                    while ((linea = entrada.readLine()) != null) {
                        String[] campos = linea.split(SEPARADOR);
                        personas.add(new Persona(campos[0], Integer.parseInt(campos[1])));
                    }
                    System.out.println("Fichero CSV leído correctamente.");
                } catch (FileNotFoundException e) {
                    System.out.printf("No se puede leer el fichero de entrada: %s.%n", FICHERO_CSV);
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
                return personas;
            }
            
            private static void escribirFicheroObjetos(List<Persona> personas) {
                try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_OBJETOS))){
                    for (Persona persona : personas) {
                        salida.writeObject(persona);
                    }
                    System.out.println("Fichero de objetos escrito correctamente.");
                } catch (FileNotFoundException e) {
                    System.out.printf("No existe el directorio de destino o no tengo permiso de escritura: %s.%n", FICHERO_OBJETOS);
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
            }
        }
      ~~~
  [Descargar posible solución para el programa **ConvertirCSVAFicheroObjetos**](ejercicios/csv/ConvertirCSVAFicheroObjetos.java)

- **Convertir fichero de objetos en CSV**

  Escribir un programa en java que lea un fichero de objetos con datos sobre una persona y los escriba como un fichero CSV.
    - Posible solución

      ~~~java
        package org.iesalandalus.programacion.csv;

        import java.io.BufferedWriter;
        import java.io.EOFException;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.util.ArrayList;
        import java.util.List;

        import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;

        public class ConvertirFicheroObjetosACSV {
            
            private static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
            private static final String FICHERO_CSV = String.format("%s%s%s", "ficheros",  File.separator, "personas.csv");
            
            private static final String SEPARADOR = ",";

            public static void main(String[] args) {
                List<Persona> personas = leerFicheroObjetos();
                escribirFicheroCSV(personas);
            }
            
            private static List<Persona> leerFicheroObjetos() {
                List<Persona> personas = new ArrayList<>();
                try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO_OBJETOS))){
                    Persona persona;
                    while ((persona = (Persona) entrada.readObject()) != null) {
                        personas.add(persona);
                    }
                } catch (FileNotFoundException fnfe) {
                    System.out.printf("No se puede leer el fichero de entrada: %s.%n", FICHERO_OBJETOS);
                } catch (ClassNotFoundException cnfee) {
                    System.out.println("No puedo encontrar la clase que tengo que leer.");
                } catch (EOFException eo) {
                    System.out.println("Fichero de objetos leído satisfactoriamente.");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
                return personas;
            }
            
            private static void escribirFicheroCSV(List<Persona> personas) {
                try (BufferedWriter salida = new BufferedWriter(new FileWriter(FICHERO_CSV))){
                    for (Persona persona : personas) {
                        salida.write(String.format("%s%s%d%n", persona.getNombre(), SEPARADOR, persona.getEdad()));
                    }
                    System.out.println("Fichero CSV escrito satisfactoriamente.");
                } catch (FileNotFoundException fnfe) {
                    System.out.printf("No se puede leer el fichero de salida: %s.%n", FICHERO_CSV);
                } catch (IOException e) {
                    System.out.printf("No se ha podido escribir el fichero %s.%n", FICHERO_CSV);
                }
            }

        }
      ~~~
  [Descargar posible solución para el programa **ConvertirFicheroObjetosACSV**](ejercicios/csv/ConvertirFicheroObjetosACSV.java)


###### Ficheros XML
- **Convertir fichero XML con atributos en fichero de objetos**

  Escribir un programa en java que lea un fichero XML con datos sobre una persona que almacena los valores en atributos y los escriba como un fichero de objetos.
    - Posible solución

      ~~~java
        package org.iesalandalus.programacion.xml;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.ObjectOutputStream;

        import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;
        import org.w3c.dom.Document;
        import org.w3c.dom.Element;
        import org.w3c.dom.Node;
        import org.w3c.dom.NodeList;

        public class ConvertirXmlConAtributosAFicheroObjetos {
            
            private static final String FICHERO_OBJETOS = String.format("%s%s%s","ficheros", File.separator, "personas.dat");
            private static final String FICHERO_XML = String.format("%s%s%s", "ficheros", File.separator, "personasAtributos.xml");
            
            public static void main(String[] args) {
                Document documentoXml = UtilidadesXml.leerDocumentoXml(FICHERO_XML);
                if (documentoXml != null) {
                    System.out.println("Fichero XML leído correctamente.");
                    escribirXmlConAtributosAFicheroObjetos(documentoXml);
                }
            }
            
            private static void escribirXmlConAtributosAFicheroObjetos(Document documentoXml) {
                try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_OBJETOS))){
                    NodeList personas = documentoXml.getElementsByTagName("persona");
                    for (int i = 0; i < personas.getLength(); i++) {
                        Node persona = personas.item(i);
                        if (persona.getNodeType() == Node.ELEMENT_NODE) {
                            String nombre = ((Element)persona).getAttribute("nombre");
                            int edad = Integer.parseInt(((Element)persona).getAttribute("edad"));
                            salida.writeObject(new Persona(nombre, edad));
                        }
                    }
                    System.out.println("Fichero de objetos escrito correctamente.");
                } catch (FileNotFoundException e) {
                    System.out.printf("No se ha podido escribir el fichero %s.%n", FICHERO_OBJETOS);
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
            }
        }
      ~~~
  [Descargar posible solución para el programa **ConvertirXmlConAtributosAFicheroObjetos**](ejercicios/xml/ConvertirXmlConAtributosAFicheroObjetos.java)

- **Convertir fichero XML con elementos en fichero de objetos**

  Escribir un programa en java que lea un fichero XML con datos sobre una persona que almacena los valores en elementos y los escriba como un fichero de objetos.
    - Posible solución

      ~~~java
        package org.iesalandalus.programacion.xml;

        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.ObjectOutputStream;

        import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;
        import org.w3c.dom.Document;
        import org.w3c.dom.Element;
        import org.w3c.dom.Node;
        import org.w3c.dom.NodeList;

        public class ConvertirXmlConElementosAFicheroObjetos {
            
            private static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
            private static final String FICHERO_XML = String.format("%s%s%s", "ficheros", File.separator, "personasElementos.xml");
            
            public static void main(String[] args) {
                Document documentoXml = UtilidadesXml.leerDocumentoXml(FICHERO_XML);
                if (documentoXml != null) {
                    System.out.println("Fichero XML leído correctamente.");
                    escribirXmlConElementosAFicheroObjetos(documentoXml);
                }
            }
            
            private static void escribirXmlConElementosAFicheroObjetos(Document documentoXml) {
                try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_OBJETOS))){
                    NodeList personas = documentoXml.getElementsByTagName("persona");
                    for (int i = 0; i < personas.getLength(); i++) {
                        Node persona = personas.item(i);
                        if (persona.getNodeType() == Node.ELEMENT_NODE) {
                            String nombre = ((Element)persona).getElementsByTagName("nombre").item(0).getTextContent();
                            int edad = Integer.parseInt(((Element)persona).getElementsByTagName("edad").item(0).getTextContent());
                            salida.writeObject(new Persona(nombre, edad));
                        }
                    }
                    System.out.println("Fichero de objetos escrito correctamente.");
                } catch (IOException e) {
                    System.out.printf("No se ha podido escribir el fichero %s.%n", FICHERO_OBJETOS);
                }
            }
        }
      ~~~
  [Descargar posible solución para el programa **ConvertirXmlConElementosAFicheroObjetos**](ejercicios/xml/ConvertirXmlConElementosAFicheroObjetos.java)

- **Convertir fichero de objetos en XML con atributos**

  Escribir un programa en java que lea un fichero de objetos con datos sobre una persona y los escriba como un fichero XML, almacenando los valores en atributos.
    - Posible solución

      ~~~java
        package org.iesalandalus.programacion.xml;

        import java.io.EOFException;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.util.ArrayList;
        import java.util.List;

        import javax.xml.parsers.DocumentBuilder;

        import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;
        import org.w3c.dom.Document;
        import org.w3c.dom.Element;

        public class ConvertirFicheroObjetosAXmlConAtributos {
            
            private static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
            private static final String FICHERO_XML = String.format("%s%s%s", "ficheros", File.separator, "personasAtributos.xml");
            
            public static void main(String[] args) {
                List<Persona> personas = leerFicheroObjetos();
                Document documentoXml = crearDocumentoXml(personas);
                UtilidadesXml.escribirDocumentoXml(documentoXml, FICHERO_XML);
            }
            
            private static List<Persona> leerFicheroObjetos() {
                List<Persona> personas = new ArrayList<>();
                try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO_OBJETOS))){
                    Persona persona;
                    while ((persona = (Persona)entrada.readObject()) != null) {
                        personas.add(persona);
                    }
                } catch (FileNotFoundException fnfe) {
                    System.out.printf("No se puede leer el fichero de entrada: %s.%n", FICHERO_OBJETOS);
                } catch (ClassNotFoundException cnfee) {
                    System.out.println("No puedo encontrar la clase que tengo que leer.");
                } catch (EOFException eo) {
                    System.out.println("Fichero de objetos leído satisfactoriamente.");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
                return personas;
            }
            

            private static Document crearDocumentoXml(List<Persona> personas) {
                DocumentBuilder constructor = UtilidadesXml.crearConstructorDocumentoXml();
                Document documentoXml = null;
                if (constructor != null) {
                    documentoXml = constructor.newDocument();
                    documentoXml.appendChild(documentoXml.createElement("personas"));
                    for (Persona persona : personas) {
                        Element elementoPersona = crearElementoPersonaConAtributos(documentoXml, persona);
                        documentoXml.getDocumentElement().appendChild(elementoPersona);
                    }
                }
                return documentoXml;
            }

            private static Element crearElementoPersonaConAtributos(Document documentoXML, Persona persona) {
                Element elementoPersona = documentoXML.createElement("persona");
                elementoPersona.setAttribute("nombre", persona.getNombre());
                elementoPersona.setAttribute("edad", String.format("%d", persona.getEdad()));
                return elementoPersona;
            }

        }
      ~~~
  [Descargar posible solución para el programa **ConvertirFicheroObjetosAXmlConAtributos**](ejercicios/xml/ConvertirFicheroObjetosAXmlConAtributos.java)

- **Convertir fichero de objetos en XML con elementos**

  Escribir un programa en java que lea un fichero de objetos con datos sobre una persona y los escriba como un fichero XML, almacenando los valores en elementos.
    - Posible solución

      ~~~java
        package org.iesalandalus.programacion.xml;

        import java.io.EOFException;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.util.ArrayList;
        import java.util.List;

        import javax.xml.parsers.DocumentBuilder;

        import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;
        import org.w3c.dom.Document;
        import org.w3c.dom.Element;

        public class ConvertirFicheroObjetosAXmlConElementos {
            
            private static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
            private static final String FICHERO_XML = String.format("%s%s%s", "ficheros", File.separator, "personasElementos.xml");
            
            public static void main(String[] args) {
                List<Persona> personas = leerFicheroObjetos();
                Document documentoXml = crearDocumentoXml(personas);
                UtilidadesXml.escribirDocumentoXml(documentoXml, FICHERO_XML);
            }
            
            private static List<Persona> leerFicheroObjetos() {
                List<Persona> personas = new ArrayList<>();
                try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO_OBJETOS))){
                    Persona persona;
                    while ((persona = (Persona)entrada.readObject()) != null) {
                        personas.add(persona);
                    }
                } catch (FileNotFoundException fnfe) {
                    System.out.printf("No se puede leer el fichero de entrada: %s.%n", FICHERO_OBJETOS);
                } catch (ClassNotFoundException cnfee) {
                    System.out.println("No puedo encontrar la clase que tengo que leer.");
                } catch (EOFException eo) {
                    System.out.println("Fichero de objetos leído satisfactoriamente.");
                } catch (IOException e) {
                    System.out.println("Error inesperado de Entrada/Salida.");
                }
                return personas;
            }
            
            private static Document crearDocumentoXml(List<Persona> personas) {
                DocumentBuilder constructor = UtilidadesXml.crearConstructorDocumentoXml();
                Document documentoXml = null;
                if (constructor != null) {
                    documentoXml = constructor.newDocument();
                    documentoXml.appendChild(documentoXml.createElement("personas"));
                    for (Persona persona : personas) {
                        Element elementoPersona = crearElementoPersonaConElementos(documentoXml, persona);
                        documentoXml.getDocumentElement().appendChild(elementoPersona);
                    }
                }
                return documentoXml;
            }

            private static Element crearElementoPersonaConElementos(Document documentoXml, Persona persona) {
                Element elementoPersona = documentoXml.createElement("persona");
                Element elementoNombre = documentoXml.createElement("nombre");
                elementoNombre.setTextContent(persona.getNombre());
                Element elementoEdad = documentoXml.createElement("edad");
                elementoEdad.setTextContent(String.format("%d", persona.getEdad()));
                elementoPersona.appendChild(elementoNombre);
                elementoPersona.appendChild(elementoEdad);
                return elementoPersona;
            }

        }
      ~~~
  [Descargar posible solución para el programa **ConvertirFicheroObjetosAXmlConElementos**](ejercicios/xml/ConvertirFicheroObjetosAXmlConElementos.java)



