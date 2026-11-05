case class Producto(nombre: String, categoria: String, precio: Double, stock: Int)

// Lista con los 12 productos de la tienda de gaming
val productos = List(
  Producto("Cyberpunk", "Videojuegos", 45.50, 10),
  Producto("Teclado Mecánico", "Hardware", 65.00, 8),
  Producto("Mousepad RGB", "Accesorios", 15.00, 25),
  Producto("Audífonos Gamer", "Hardware", 85.00, 4),
  Producto("Minecraft", "Videojuegos", 29.99, 50),
  Producto("Silla Gamer", "Hardware", 199.99, 3),
  Producto("Control Inalámbrico", "Accesorios", 59.99, 15),
  Producto("Monitor 144Hz", "Hardware", 250.00, 6),
  Producto("Elden Ring", "Videojuegos", 59.99, 12),
  Producto("FIFA 26", "Videojuegos", 60.00, 20),
  Producto("Micrófono USB", "Accesorios", 45.00, 9),
  Producto("Tarjeta Gráfica", "Hardware", 450.00, 2)
)

// Ordenar los productos por precio de menor a mayor
val criterioPrecio = (p: Producto) => p.precio
val productosOrdenados = productos.sortBy(criterioPrecio)
productosOrdenados

//  Agrupar los productos por su categoría
val porCategoria = (p: Producto) => p.categoria
val productosAgrupados = productos.groupBy(porCategoria)
productosAgrupados

// Buscar el primer producto que coincida con el nombre
val buscarElden = (p: Producto) => p.nombre == "Elden Ring"
val resultadoBusqueda = productos.find(buscarElden)
resultadoBusqueda

// Sacar solo las categorías únicas sin repetir
val criterioCategoria = (p: Producto) => p.categoria
val categoriasUnicas = productos.distinctBy(criterioCategoria)
categoriasUnicas

// Operación combinada: filtrar los caros (>50) y luego agrupar por categoría
val esCaro = (p: Producto) => p.precio > 50.0
val claveCategoria = (p: Producto) => p.categoria

val resultadoCombinado = productos.filter(esCaro).groupBy(claveCategoria)
resultadoCombinado