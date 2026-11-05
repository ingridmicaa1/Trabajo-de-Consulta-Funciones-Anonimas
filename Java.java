import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

class Producto {
    String nombre;
    String categoria;
    double precio;
    int stock;

    public Producto(String nombre, String categoria, double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto(" + nombre + ", " + categoria + ", $" + precio + ", " + stock + ")";
    }
}

public class Tarea_FuncionesAnonimas {
    public static void main(String[] args) {
     
        List<Producto> productos = List.of(
            new Producto("Cyberpunk", "Videojuegos", 45.50, 10),
            new Producto("Teclado Mecánico", "Hardware", 65.00, 8),
            new Producto("Mousepad RGB", "Accesorios", 15.00, 25),
            new Producto("Audífonos Gamer", "Hardware", 85.00, 4),
            new Producto("Minecraft", "Videojuegos", 29.99, 50),
            new Producto("Silla Gamer", "Hardware", 199.99, 3),
            new Producto("Control Inalámbrico", "Accesorios", 59.99, 15),
            new Producto("Monitor 144Hz", "Hardware", 250.00, 6),
            new Producto("Elden Ring", "Videojuegos", 59.99, 12),
            new Producto("FIFA 26", "Videojuegos", 60.00, 20),
            new Producto("Micrófono USB", "Accesorios", 45.00, 9),
            new Producto("Tarjeta Gráfica", "Hardware", 450.00, 2)
        );

        // Filter
        List<Producto> filtrados = productos.stream()
            .filter(p -> p.precio > 100.0)
            .collect(Collectors.toList());
        System.out.println(filtrados);

        // Map
        List<String> nombres = productos.stream()
            .map(p -> p.nombre)
            .collect(Collectors.toList());
        System.out.println(nombres);

        // Count
        long conteoJuegos = productos.stream()
            .filter(p -> p.categoria.equals("Videojuegos"))
            .count();
        System.out.println(conteoJuegos);

        // Max
        Producto masCaro = productos.stream()
            .max(Comparator.comparingDouble(p -> p.precio))
            .orElse(null);
        System.out.println(masCaro);
    }
}