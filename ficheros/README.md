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


## Introducción

En java ya sabemos cómo interactuar con el usuario, leyendo datos de la consola o mostrandolos. Es la forma en la que nuestro programa se comunica con el exterior. Este tipo de comunicación es a lo que se llama **operaciones de E/S (Entrada/Salida) estándar**.

Todo lo que hacíamos lo almacenábamos en estructuras de datos alojadas en memoria, que al terminar nuestro programa se perdían. Sería deseable que hubiese persistencia para los datos y así que no se perdiesen al finalizar. Y es aquí donde entran en juego otro tipo de operaciones de E/S como son las **operaciones de E/S a través de ficheros**.

Pero, ¿qué es un fichero o archivo? De forma escueta, podríamos decir que son una serie de datos almacenados en algún dispositivo de almacenamiento. Como ya sabemos se identifican por su **nombre** (en el que a veces queremos distinguir su **extensión**) y están almacenados en una **ruta**. La ruta indica el camino a seguir, dentro de la estrctura de carpetas, hasta llegar al archivo. Existen dos tipos de rutas:
- **Ruta absoluta**: Indica el camino completo desde la raíz del sistema de archivos. Para separar los directorios se utiliza la barra (`/`en Linux y Mac y `\` en windows), además en windows comienzan con la letra de la unidad. Por ejemplo: `/home/profesor/programacion/leeme.txt` en Linux, o `E:\datos\programacion\leeme.txt` en Windows.
- **Ruta relativa**: Indica el camino relativo a partir de una carpeta dada y comienzan por un nombre de carpeta, por ejemplo: `programacion/leeme.txt`.

Todos los ficheros almacenan una cantidad de bytes determinada por su tamaño, pero dependiendo de la **interpretación** que hagamos de ese conjunto de bytes, podemos distinguir:
- **Ficheros binarios**: No se hace ningún tipo de interpretación de los bytes almacenados en los mismos. Se suele decir que la información se almacena en crudo. Ejemplos de estos tipos son los ficheros ejecutables, los ficheros de imágenes, los ficheros de música, etc.
- **Ficheros de texto**: Cada dos bytes representa un caracter unicode y, por lo tanto, son entendibles por nosotros y fácilmente modificables. Ejemplos de estos tipos son los archivos fuente, los archivos de configuración, etc.

Si nos atenemos a cómo accedemos a los ficheros podemos distinguir dos modos de acceso:
- **Acceso secuencial**: Para acceder a un determinado byte debemos pasar por todos los bytes anteriores. Un simil podría ser las antiguas cintas de casette, en las que para escuchar una canción debíamos pasar por todas las anteriores.
- **Acceso aleatorio**: Podemos acceder a cualquier byte que deseemos. Un simil podría ser los CD de música, en los que podemos escuchar la canción que deseemos.

En java todas las operaciones de E/S se encuentran en el paquete `java.io` y es lo que veremos en los siguientes apartados. Antes de continuar, sería conveniente mencionar que en java existen un par de abstracciones relacionadas con los ficheros:
- **Flujo de datos** también conocido como `Stream`, es una abstracción que se asocia al fichero físico y que es tratada por la máquina virtual, de forma que nosotros tratamos con el flujo y la máquina virtual es la encargada de tratar con los distintos ficheros físicos.
- **Buffer de datos** es una abstracción que se asocia a un flujo y actúa de intermediario entre nuestro programa y el flujo, haciendo más eficientes las lecturas y escrituras. Se comporta como una memoria intermedia que almacena una cantidad de bytes definida, de forma que las lecturas se realizan desde esta memoria intermedia y cuando se lee por completo se carga otro bloque en la misma. Para las escrituras actúa de forma similiar, escribimos en la memoria intermedia y cuando se llena, se vuelca al flujo y se vacía.

Cuando trabajamos con ficheros, debemos crear la asociación, bien sea mediante un flujo o mediante un buffer. A esto es a lo que se conoce como **abrir el fichero**. Leeremos o escribiremos los datos y finalmente eliminaremos la asociación para liberar el recurso. A esto es a lo que se llama **cerrar el fichero**. Es importante cerrar los ficheros. 

También debemos tener en cuenta que es posible que se produzcan situaciones anómalas: el fichero no existe y no se puede abrir, no tenemos permisos para abrir el archivo, el sistema de archivos está lleno y no se puede escribir, etc. Las excepciones más comunes que pueden saltar al trabajar con ficheros son:
- `FileNotFoundException`: Cuando no se puede abrir el fichero.
- `EOFException`: Cuando se llega al final del archivo. Esta excepción salta al leer ficheros de objetos.
- `IOException`: Excepción general que indica que ha sucedido algo no esperado al trabajar con ficheros; no existe, no se tienen permisos, sistema de archivos lleno, etc. Es la clase padre de las anteriores y de cualquier excepción que puede saltar al trabajar con ficheros.

Teniendo en mente que es posible que salte alguna excepción y que es muy importante cerrar los ficheros, debemos capturar las excepciones para evitar estas situaciones inesperadas y posibilitar cerrar los ficheros. Para facilitar esta tarea, a partir de java 7, existe la construcción `try-with-resource`. Esta construcción es como un `try-catch` normal en la que se indica el o los recursos que se van a abrir y es la máquina virtual la que se encarga de cerrar el o los recursos, bien al capturar alguna excepción o bien al finalizar. Veamos un ejemplo para clarificar:

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

Ahora que ya conocemos todos estos, es la hora de que pasemos a ver las posibilidades que nos ofrece el paquete `java.io` para trabajar con ficheros.

## El sistema de archivos

