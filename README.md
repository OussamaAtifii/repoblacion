# Repoblación
## Profesor: Andrés Rubio del Río
## Alumno: Oussama Atifi

La tarea va a consistir en simular la repoblación de un bosque de unas determinadas dimensiones.


Para ello disponemos de una serie de especies de árboles para llevar a cabo la repoblación: **álamo, encina, castaño, ciprés, pino piñonero, roble mediterráneo y olivo**.

Se pedirá por teclado el **ancho** y el **alto** del bosque y la **cantidad** de arboles a repoblar. El alto y el ancho deberán ser mayores que un mínimo (10) y menores que el máximo en cada dimensión (1000 para el ancho y 500 para el alto). La cantidad de árboles a plantar no podrá superar el perímetro del bosque (2X(ancho+alto)). La aplicación plantará la cantidad de árboles especificado, escogiendo aleatoriamente una especie y una posición dentro de los límites del bosque (-ancho/2 y ancho/2, -alto/2 y alto/2). Además, en el bosque no podrán existir más de 4 especies distintas (**MAX_ESPECIES** que es una constante perteneciente a la clase Bosque). Por último, en el bosque existen una serie de especies incompatibles: álamo es incompatible con castaño, ciprés y olivo, mientras que el olivo es incompatible con el álamo y la encina.

Finalmente nos informará cuál es el árbol más centrado y el más alejado. La distancia entre dos puntos se calcula utilizando el teorema de Euclides, de la siguiente forma:  <div align="center"><img alt="Fórmula" src="imagenes/formula.png" />
</div> 

Una posible salida de la ejecución sería la siguiente:

<div align="center"><img alt="Salida ejecución" src="imagenes/salida.png" /> 
</div>

<div align="center"><img alt="Diagrama de clases para repoblación" src="imagenes/diagramaClases.png" />
</div>

#### Primeros Pasos

1. Lo primero que debes hacer es un fork de este repositorio.
2. Clona tu repositorio remoto recién copiado en **GitHub** a un repositorio local que será donde irás realizando lo que a continuación se te pide. Modifica el archivo `README.md` para que incluya tu nombre en el apartado "Alumno". Realiza tu primer commit.
3. Debes introducir correctamente en el proyecto tanto la librería `Entrada` como la `JUnit5` para utilizarla posteriormente.
4. Los paquetes en los que se encuentren las diferentes clases deberán ser los indicados en el diagrama de clases.

#### Enumerado `Especie`
1. Crea un enumerado llamado `Especie` que contenga los literales indicados en el diagrama de clases. Los literales estarán parametrizados y a cada uno le pasaremos la representación en cadena de los mismos: los nombres de las especies (álamo, encina, castaño, ciprés, pino piñonero, etc.).
2. Crea el atributo `cadenaAMostrar` (String).
3. Crea el **constructor** con la visibilidad adecuada, que almacenará en el atributo anterior la cadena que se le pase por parámetro. 
4. Crea el método `toString` que devolverá la representación en forma de cadena del literal. Realiza un commit con la creación de este enumerado.

#### Clase `Posicion`

1. Crea la clase Posicion. Crea los atributos `x` e `y` del tipo y la visibilidad indicados.
2. Crea los métodos `get`.
3. Crea el **constructor con parámetros**.
4. Crea el **constructor copia**.
5. Crea el método distancia que aceptará otra posición como parámetro y si es distinta de null devolverá la distancia entre la posición en cuestión y la pasada por parámetro y en caso contrario lanzará la excepción `NullPointerException`.
6. Crea el método `toString` que devolverá un `String` y será la representación de la posición (**x=valorX, y=valorY**). Se restringirán los decimales a tres. Realiza un commit con la creación de esta clase.

#### Clase `Arbol`
1. Crea la clase `Arbol` cuyos atributos serán una especie (del tipo enumerado `Especie`) y posicion (de la clase `Posicion`), con la visibilidad adecuada.
2. Crea los métodos `get` y `set` para cada atributo con la visibilidad adecuada. Los métodos `set` siempre comprobarán la validez de los parámetros pasados y si no son correctos deberá lanzar la excepción adecuada con el mensaje adecuado.
3. Crea un **constructor** para la clase que acepte como parámetros especie y posición (utiliza los métodos set creados anteriormente).
4. Crea el **constructor copia**
5. Crea el método `toString` que devuelva un `String` que será la representación de dicho objeto (especie y posición). Realiza un commit con la creación de esta clase.

#### Clase `Bosque`

1. Crea la clase `Bosque` cuyos atributos y constantes serán las indicados en el diagrama de clases. Su tipo y visibilidad deben ser los indicados.
2. Crea los métodos `get` y `set` para cada atributo con la visibilidad adecuada. Los métodos `set` siempre comprobarán la validez de los parámetros pasados y si no son correctos deberá lanzar la excepción adecuada con el mensaje adecuado.
3. Crea el **constructor** que acepte los parámetros ancho, alto y población, realice las comprobaciones adecuadas y asigne los valores a los atributos correspondientes o en caso contrario lance la excepción adecuada. El constructor llamará la método `repoblar`.
4. Crea el método `duplicaBosque` que devuelve una copia del bosque.
5. Crea el método `checkPoblacion` que comprueba si el parámetro población pasado al constructor es válido. En caso de no serlo, lanzará la excepción adecuada con el mensaje adecuado.
6. Crea el método `repoblar` que para cada elemento del array de árboles, creará un nuevo árbol de una especie aleatoria y en una posición aleatoria dentro de los límites en x (-ancho/2, ancho/2) e y (-alto/2, alto/2). Este método debe tener presente que, cuando se vaya a crear el árbol:  
    6.1. La especie generada aleatoriamente debe ser compatible con la especie del árbol que le precede en el array (arboles[i-1]).  
    6.2. Que no se tengan ya en el bosque más de **MAX_ESPECIES**.
9. Crea el método `realizarCalculos` que recorrerá el array de árboles y calculará cuál es el más centrado y el más alejado del centro (punto (0, 0)).
10. Crea los métodos `getArbolMasCentrado` y `getArbolMasAlejado` que devolverán el árbol más centrado y más alejado anteriormente calculados.
11. Crea el método `toString` que devolverá un `String` que representará el alto, ancho y la lista de árboles del bosque. Realiza un commit con la realización de esta clase.


#### Clase `Consola`

1. Crea la clase `Consola` en el paquete indicado en el diagrama.
2. Crea su **constructor** teniendo en cuenta que es una clase de utilidades y que no tiene sentido instanciar objetos de la misma.
3. Crea el método `leerAnchura` que pedirá la anchura de nuestro bosque mientras ésta no sea correcta.
4. Crea el método `leerAltura` que pedirá la altura de nuestro bosque mientras ésta no sea correcta.
5. Crea el método `leerPoblacion` que pedirá la población de nuestro bosque mientras ésta sea menor o igual que cero. Realiza un commit con la realización de esta clase.


#### Clase `MainApp`

1. Crea el atributo de clase bosque.
2. El método `main` leerá la anchura, la altura. Posteriormente leerá la población e intentará crear el bosque. Este último paso lo repetirá mientras la población no sea correcta con respecto a la anchura y altura dadas. Finalmente realizará los cálculos y mostrará los resultados.
3. Realiza el push hacia tu repositorio remoto en GitHub.

#### Se valorará:

- La indentación debe ser correcta en cada uno de los apartados.
- Los identificadores utilizados deben ser adecuados y descriptivos.
- Se debe utilizar la clase `Entrada` para realizar la entrada por teclado que se encuentra como dependencia de nuestro proyecto en la librería `entrada`.
- El programa debe pasar todas las pruebas que van en el esqueleto del proyecto y toda entrada del programa será validada, para evitar que el programa termine abruptamente debido a una excepción.
- La corrección ortográfica tanto en los comentarios como en los mensajes que se muestren al usuario.
