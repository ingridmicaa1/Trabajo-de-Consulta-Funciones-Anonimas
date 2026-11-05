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
Permite realizar operaciones utilizando expresiones lambda como (map, filter, reduce) para el fa

**Fuente Consultada**
https://www.ciberaula.com/cursos/java/streams_java.php

**Fragmento de código real con funciones anónimas**

List<Double> salariosNetos = empleados.stream()
    .map(e -> e.getSalario() * 0.85)
    .collect(Collectors.toList());

Convierte la lista de objetos empleados en un stream después utiliza el método .map() con una función anónima (e -> e.getSalario() * 0.85) para calcular el salario neto. Finalmente, el método .collect(Collectors.toList()) une los resultados transformados en una nueva lista.
