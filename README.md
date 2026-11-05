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

