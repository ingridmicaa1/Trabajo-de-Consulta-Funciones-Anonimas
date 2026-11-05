# Trabajo de Consulta: Programación Funcional y Funciones Anónimas

## Parte 1: Explorar - La programación funcional en el mundo real

### Caso 1: Apache Spark y el Procesamiento Big Data
***¿Qué problema resuelve?***

Resuelve problemas como procesar una cantidad muy grande de información y antiguamente esto saturaba las redes y frenaba todo, tambien ayuda a detección de fraude, recomendaciones personalizadas a los usuarios, análisis de registros médicos y análisis de registro de llamadas.

***¿Qué lenguaje o herramienta usan?***

Utiliza el lenguaje Scala y la herramienta es Apache Spark y ayuda al análisis de código abierto para el procesamiento de datos a gran nivel.

***¿Qué ventaja les da el enfoque funcional?***

Las funciones como (map, filter, groupBy) ayuda a la eficiencia para manipular y analizar datos así también la persona que programa solo describe que hacer con cada elemento y Spark decide cómo repartir y ejecutar ese trabajo.

**Fuente Consultada**

https://elmundodelosdatos.com/como-usar-spark-con-scala-para-procesamiento-de-big-data/

https://docs.arenadata.io/en/ADH/current/references/spark/spark-shell.html

**Fragmento de código real con funciones anónimas**

val DFData = data.filter(line => line.contains("one"))
Crea una variable llamada DFData, después filtra la data y realiza una función lambda la cual primero usa line y contains para búsqueda y finalmente verificar si contiene la palabra 'one' devolviendo un verdadero o falso debido a line.

### Caso 2: Streams de Java en Sistemas Empresariales
***¿Qué problema resuelve?***

En los sistemas empresariales utilizar bucles con (if) suele generar errores, difícil comprensión y también no se lo puede mantener. Los Streams permiten manipular y agregar datos de forma funcional y concisa sin modificar el código original.

***¿Qué lenguaje o herramienta usan?***

Utiliza el lenguaje Java desde la version 8 con la herramienta API de Streams.

***¿Qué ventaja les da el enfoque funcional?***

Permite realizar operaciones utilizando expresiones lambda como (map, filter, reduce) para que sea más fácil de usar y mantener.

**Fuente Consultada**

https://www.ciberaula.com/cursos/java/streams_java.php

**Fragmento de código real con funciones anónimas**

List<Double> salariosNetos = empleados.stream()
    .map(e -> e.getSalario() * 0.85)
    .collect(Collectors.toList());

Convierte la lista de objetos empleados en un stream después utiliza el método .map() con una función anónima (e -> e.getSalario() * 0.85) para calcular el salario neto. Finalmente, el método .collect(Collectors.toList()) une los resultados transformados en una nueva lista.

## Parte 2: Entender ¿Qué es una función anónima? 

***¿Qué es una función anónima y de dónde viene el nombre lambda?***

Una función anónima es una función sin nombre que se escribe en el sitio donde se necesita. El nombre viene de Alonso Church en el año 1930 para representar una función y utilizo la letra griega Λ para eso. 

    Ejemplo: p => p.precio > 100
    
Fuente: https://www.quora.com/What-is-the-origin-of-the-term-lambda-in-relation-to-anonymous-functions-in-Lisp

***¿En qué se diferencia de una función nombrada? Escribe la misma lógica de ambas formas.***

La función nombrada se la define antes y se puede volver a utilizar en el código.

Lenguaje: Scala 

    // Nombrada
    
    def doble(x: Int): Int = x * 2
    List(1, 2, 3).map(doble)  
    
    //Anónima
    
     List(1, 2, 3).map(x => x * 2) 

***¿Qué significa que las funciones sean ciudadanos de primera clase? ¿Por qué eso permite pasar una lambda a map o filter?***

Significa se guarda en una variable, se pasa como argumento y se devuelve como resultado. Por eso map y filter pueden recibir una lambda porque para ellos la función es solo un parámetro más.

Ejemplo: 

    val operaciones: List[Int => Int] = List(x => x + 1, x => x * 10)
    operaciones.map(f => f(5))

***¿Qué es un closure? Muestra una lambda que use una variable definida fuera de ella.***

Una closure captura o recuerda el valor de la variable externa

Fuente: https://manuais.pages.iessanclemente.net/apuntes/2.programacion/kotlin/03_prog_funcional/31.sintaxisfunciones/314.closure/index.html

Ejemplo: 
    val factorDescuento = 0.20 
    val calcularDescuento = (precio: Double) => precio - (precio * factorDescuento)
    val precioFinal = calcularDescuento(100.0) 
    println(precioFinal) 

## Parte 3: Aplicar: ¿en qué problemas sirven las funciones anónimas?

1. Selección ¿Qué elementos cumplen una condición? filter
2. Transformación ¿Cómo convierto cada elemento en otro valor? map
3. Conteo ¿Cuántos elementos cumplen una condición? count 
4. Extremos ¿Cuál es el mejor o el peor según un criterio? maxBy, minBy

Lista: 
  
    (nombre,  categoria    ,   precio , stock )
    
    ("Cyberpunk", "Videojuegos", 45.50, 10)
    
    ("Teclado Mecánico", "Hardware", 65.00, 8)
    
    ("Mousepad RGB", "Accesorios", 15.00, 25)
    
    ("Audífonos Gamer", "Hardware", 85.00, 4)
    
    ("Minecraft", "Videojuegos", 29.99, 50)
    
    ("Silla Gamer", "Hardware", 199.99, 3)
    
    ("Control Inalámbrico", "Accesorios", 59.99, 15)
    
    ("Monitor 144Hz", "Hardware", 250.00, 6)
    
    ("Elden Ring", "Videojuegos", 59.99, 12)
    
    ("FIFA 26", "Videojuegos", 60.00, 20)
    
    ("Micrófono USB", "Accesorios", 45.00, 9)
    
    ("Tarjeta Gráfica", "Hardware", 450.00, 2) 

**Situación real: Selección -filter-**

El sistema necesita filtrar y obtener únicamente los productos que tienen un precio mayor a $100.0 para una promoción especial.
 
Scala: 

    val caro = (p: Producto) => p.precio > 100.0
    val filtrados = productos.filter(caro)
    filtrados

Salida: List(Producto(Silla Gamer,Hardware,199.99,3), Producto(Monitor 144Hz,Hardware,250.0,6), Producto(Tarjeta Gráfica,Hardware,450.0,2))

Java (Streams): 

        List<Producto> filtrados = productos.stream()
            .filter(p -> p.getPrecio() > 100.0)
            .collect(Collectors.toList());
        filtrados.forEach(System.out::println);

Salida: Silla Gamer - $199.99
        Monitor 144Hz - $250.0
        Tarjeta Gráfica - $450.0


Python: 

    caro = lambda p: p.precio > 100.0
    filtrados = list(filter(caro, productos))
    print(filtrados)

Salida: [ Silla Gamer - $199.99, Monitor 144Hz - $250.0, Tarjeta Gráfica - $450.0 ]

**Situación real: Transformación -map-**

Extraer únicamente los nombres de todos los productos para un menú.

Scala: 

    val extraerNombre = (p: Producto) => p.nombre
    val nombres = productos.map(extraerNombre)
    nombres
    
Salida: List(Cyberpunk, Teclado Mecánico, Mousepad RGB, Audífonos Gamer, Minecraft, Silla Gamer, Control Inalámbrico, Monitor 144Hz, Elden Ring, FIFA 26, Micrófono USB, Tarjeta Gráfica)

Java (Streams): 

    List<String> nombres = productos.stream()
        .map(p -> p.nombre)
        .collect(Collectors.toList());
    nombres.forEach(System.out::println);
    
Salida:[Cyberpunk, Teclado Mecánico, Mousepad RGB, Audífonos Gamer, Minecraft, Silla Gamer, Control Inalámbrico, Monitor 144Hz, Elden Ring, FIFA 26, Micrófono USB, Tarjeta Gráfica]

Python: 

    extraer_nombre = lambda p: p.nombre
    nombres = list(map(extraer_nombre, productos))
    print(nombres)

Salida: ['Cyberpunk', 'Teclado Mecánico', 'Mousepad RGB', 'Audífonos Gamer', 'Minecraft', 'Silla Gamer', 'Control Inalámbrico', 'Monitor 144Hz', 'Elden Ring', 'FIFA 26', 'Micrófono USB', 'Tarjeta Gráfica']

**Situación real: Conteo -count-**

Calcular cuántos artículos pertenecen estrictamente a la categoría "Videojuegos".

Scala: 

    val esVideojuego = (p: Producto) => p.categoria == "Videojuegos"
    val conteoJuegos = productos.count(esVideojuego)
    conteoJuegos

Salida: 4

Java(Streams): 

    long conteoJuegos = productos.stream()
        .filter(p -> p.categoria.equals("Videojuegos"))
        .count();
    System.out.println(conteoJuegos);
    
Salida: 4

Python: 

    es_videojuego = lambda p: p.categoria == "Videojuegos"
    conteo_juegos = len(list(filter(es_videojuego, productos)))
    print(conteo_juegos)

Salida: 4

**Situación real: Extremos -maxBy, minBy-**

Identificar cuál es el artículo con el precio más alto de todo el inventario.

Scala: 

    val criterioPrecio = (p: Producto) => p.precio
    val masCaro = productos.maxBy(criterioPrecio)
    masCaro

Salida: Producto(Tarjeta Gráfica,Hardware,450.0,2)

Java(Streams): 

    Producto masCaro = productos.stream()
        .max((p1, p2) -> Double.compare(p1.precio, p2.precio))
        .orElse(null);
    System.out.println(masCaro);

Salida: Tarjeta Gráfica - $450.0

Python: 

    criterio_precio = lambda p: p.precio
    mas_caro = max(productos, key=criterio_precio)
    print(mas_caro)

Salida: Tarjeta Gráfica - $450.0
    
## Parte 4: Ampliar: cuatro operaciones nuevas

1. Ordenar sortBy, sortWith
2. Agrupar groupBy, groupMapReduce
3. Buscar find, indexWhere
4. Depurar y transformar distinctBy, collect, reduce

***Ordenar (sortBy)***

**¿Qué hace?** 

Ordena los elementos de menor a mayor es decir alfabéticamente

**¿Qué función anónima recibe?**

Una función anónima que recibe un objeto y devuelve un valor el cual inicia ordenando, un Double.

**Scala**

    val criterioPrecio = (p: Producto) => p.precio
    val productosOrdenados = productos.sortBy(criterioPrecio)
    productosOrdenados

Salida: List(Producto(Mousepad RGB, Accesorios, 15.0, 25), Producto(Minecraft, Videojuegos, 29.99, 50), Producto(Micrófono USB, Accesorios, 45.0, 9), Producto(Cyberpunk, Videojuegos, 45.5, 10), Producto(Control Inalámbrico, Accesorios, 59.99, 15), Producto(Elden Ring, Videojuegos, 59.99, 12), Producto(FIFA 26, Videojuegos, 60.0, 20), Producto(Teclado Mecánico, Hardware, 65.0, 8), Producto(Audífonos Gamer, Hardware, 85.0, 4), Producto(Silla Gamer, Hardware, 199.99, 3), Producto(Monitor 144Hz, Hardware, 250.0, 6), Producto(Tarjeta Gráfica, Hardware, 450.0, 2))

La lista va en orden desde el más barato al más caro: Mousepad RGB a $15.00 al Tarjeta Gráfica a $450.00.

**Problema que resuelve**

Muestra un catalogo visual muy ordenado por precio en la tienda virtual para que el cliente encuentre primero lo más económico o lo más caro.

***Agrupar (groupBy)***

**¿Qué hace?** 

Divide los elementos en una colección y los agrupa en listas. 

**¿Qué función anónima recibe?**

Una función anónima que recibe un objeto y devuelve un valor como String. 

**Scala**

    val porCategoria = (p: Producto) => p.categoria
    val productosAgrupados = productos.groupBy(porCategoria)
    productosAgrupados
    
Salida: Map(Accesorios -> List(Producto(Mousepad RGB, Accesorios, 15.0, 25), Producto(Control Inalámbrico, Accesorios, 59.99, 15), Producto(Micrófono USB, Accesorios, 45.0, 9)), Videojuegos -> List(Producto(Cyberpunk, Videojuegos, 45.5, 10), Producto(Minecraft, Videojuegos, 29.99, 50), Producto(Elden Ring, Videojuegos, 59.99, 12), Producto(FIFA 26, Videojuegos, 60.0, 20)), Hardware -> List(Producto(Teclado Mecánico, Hardware, 65.0, 8), Producto(Audífonos Gamer, Hardware, 85.0, 4), Producto(Silla Gamer, Hardware, 199.99, 3), Producto(Monitor 144Hz, Hardware, 250.0, 6), Producto(Tarjeta Gráfica, Hardware, 450.0, 2)))

Un map donde las llaves son "Videojuegos", "Hardware" y "Accesorios", y cada llave contiene su respectiva lista de productos.

**Problema que resuelve**

Organizar el inventario por secciones independientes dentro del sistema de la tienda.

***Buscar (find)***

**¿Qué hace?** 

Busca en la colección y devuelve el primer elemento que cumpla con esa condición 

**¿Qué función anónima recibe?**

Una función anónima que recibe un objeto y devuelve un valor como Boolean. 

**Scala**

    val buscarElden = (p: Producto) => p.nombre == "Elden Ring"
    val resultadoBusqueda = productos.find(buscarElden)
    resultadoBusqueda

Salida: Some(Producto(Elden Ring, Videojuegos, 59.99, 12))

Recorre la lista buscando el primer elemento que cumpla con la condición estricta de tener el nombre "Elden Ring". Al encontrarlo, lo envuelve en un contenedor Some(...) para indicar que la búsqueda fue exitosa, si no existiera, devolvería None.

**Problema que resuelve**

Encontrar rápidamente la ficha técnica de un producto cuando el usuario introduce su nombre exacto en la barra de búsqueda.

***Depurar y transformar (distinctBy)***

**¿Qué hace?** 

Filtra la colección y elimina los datos duplicados, conserva únicamente el primero.  

**¿Qué función anónima recibe?**

Una función anónima que recibe un objeto, extrae el atributo por el cual se evaluará si dos elementos son repetidos

**Scala**

    val criterioCategoria = (p: Producto) => p.categoria
    val categoriasUnicas = productos.distinctBy(criterioCategoria)
    categoriasUnicas

Salida: List(Producto(Cyberpunk, Videojuegos, 45.5, 10), Producto(Teclado Mecánico, Hardware, 65.0, 8), Producto(Mousepad RGB, Accesorios, 15.0, 25))

Una lista con solo 3 productos uno por cada categoría única: el primero de Videojuegos, el primero de Hardware y el primero de Accesorios.

**Problema que resuelve**

Obtener un listado único de las categorías disponibles en la base de datos para mostrarlas en los filtros del menú principal sin repetir nombres.
