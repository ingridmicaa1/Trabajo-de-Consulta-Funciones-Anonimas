class Producto:
    def __init__(self, nombre, categoria, precio, stock):
        self.nombre = nombre
        self.categoria = categoria
        self.precio = precio
        self.stock = stock

    def __repr__(self):
        return f"Producto({self.nombre}, {self.categoria}, ${self.precio}, {self.stock})"

# Lista con los 12 productos base
productos = [
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
]

#Filter
es_caro = lambda p: p.precio > 100.0
filtrados = list(filter(es_caro, productos))
print("--- 1. SELECCIÓN ---")
print(filtrados)

# Map
extraer_nombre = lambda p: p.nombre
nombres = list(map(extraer_nombre, productos))
print("\n--- 2. TRANSFORMACIÓN ---")
print(nombres)

# Count
es_videojuego = lambda p: p.categoria == "Videojuegos"
conteo_juegos = len(list(filter(es_videojuego, productos)))
print("\n--- 3. CONTEO ---")
print(conteo_juegos)

# MaxBy - MinBy
criterio_precio = lambda p: p.precio
mas_caro = max(productos, key=criterio_precio)
print("\n--- 4. EXTREMOS ---")
print(mas_caro)