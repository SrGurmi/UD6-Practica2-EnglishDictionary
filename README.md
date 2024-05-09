### Clase `WordStorage`

La clase `WordStorage` se encarga de almacenar y gestionar palabras clasificadas por su inicial. Veamos sus componentes:

#### Propiedades

-   `wordsByInitial`: Es un `Map` que utiliza como clave una letra inicial (`Character`) y como valor un conjunto (`Set`) de palabras (`String`). Este mapa permite agrupar palabras según la letra con la que comienzan.

#### Métodos

1.  `WordStorage()`: Constructor de la clase que inicializa la estructura de datos `wordsByInitial`.

2.  `addWord(String word)`: Método para agregar una palabra al diccionario. La palabra se sanitiza (convierte a minúsculas y elimina espacios al principio y final), se determina su inicial, y se añade al conjunto correspondiente en `wordsByInitial`.

3.  `removeWord(String word)`: Método para eliminar una palabra del diccionario. También sanitiza la palabra, encuentra su inicial y la elimina del conjunto correspondiente si está presente.

4.  `wordExists(String word)`: Método para verificar si una palabra existe en el diccionario. Se sanitiza la palabra, se determina su inicial, y se busca en el conjunto correspondiente en `wordsByInitial`.

5.  `getInitialsList()`: Método para obtener una lista de las iniciales (letras) que tienen al menos una palabra almacenada en el diccionario.

6.  `getWordsByInitial(char initial)`: Método para obtener una lista de palabras que comienzan con una letra inicial específica. Las palabras se devuelven en orden alfabético.

### Clase `Sanitizer`

La clase `Sanitizer` proporciona un método estático para sanitizar (normalizar) cadenas de texto. Veamos su único método:

#### Métodos

1.  `sanitize(String input)`: Método estático que toma una cadena de entrada, la limpia (elimina espacios al principio y final, convierte a minúsculas) y devuelve la versión normalizada de la cadena.

### Clase `Main`

La clase `Main` es la clase principal que contiene el bucle principal de interacción con el usuario. Veamos su funcionamiento:

#### Métodos

1.  `main(String[] args)`: Método principal que inicia la aplicación. Dentro de este método:

    -   Se crea un objeto `Scanner` para la entrada de datos desde la consola.
    -   Se crea un objeto `WordStorage` para almacenar y gestionar las palabras.
    -   Se muestra un mensaje de bienvenida.
    -   Se inicia un bucle `while` para mostrar un menú interactivo al usuario:
        -   El usuario selecciona una opción del menú (por ejemplo, agregar palabra, eliminar palabra, etc.).
        -   Según la opción seleccionada, se solicita la entrada necesaria al usuario y se llama al método correspondiente en el objeto `WordStorage`.
        -   Se muestra retroalimentación al usuario según el resultado de la operación seleccionada.
        -   El bucle continua hasta que el usuario elija salir del programa.

### Interacción entre las Clases

-   La clase `Main` instancia un objeto de la clase `WordStorage` para poder utilizar sus métodos y gestionar el diccionario de palabras.
-   Dentro del método `main` de la clase `Main`, se utiliza un bucle `while` para permitir que el usuario interactúe con el programa a través de un menú de opciones.
-   Cuando el usuario elige una opción del menú, se llama al método correspondiente en el objeto `WordStorage` para realizar la operación seleccionada (agregar palabra, eliminar palabra, etc.).
-   La clase `Sanitizer` se utiliza en los métodos de `WordStorage` para normalizar las palabras antes de procesarlas (eliminar espacios, convertir a minúsculas).

En resumen, estas clases trabajan juntas para crear un programa funcional que permite al usuario interactuar con un diccionario de palabras, agregando, eliminando y verificando palabras clasificadas por su letra inicial, con la ayuda de métodos de sanitización y manipulación de datos. La división en clases y el uso de métodos y estructuras de datos adecuadas facilitan el mantenimiento y la expansión del programa.
