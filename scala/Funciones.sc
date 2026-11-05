
case class Producto(nombre: String, categoria: String, precio: Double, stock: Int)

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

// filter
val caro = (p: Producto) => p.precio > 100.0
val filtrados = productos.filter(caro)

filtrados

// map
val extraerNombre = (p: Producto) => p.nombre
val nombres = productos.map(extraerNombre)
nombres

// count
val esVideojuego = (p: Producto) => p.categoria == "Videojuegos"
val conteoJuegos = productos.count(esVideojuego)
conteoJuegos

// maxBy - minBy
val criterioPrecio = (p: Producto) => p.precio
val masCaro = productos.maxBy(criterioPrecio)
masCaro