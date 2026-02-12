import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }

        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - " +
                               p.getPrecio() + "€ - Stock: " +
                               p.getStock());
        }
    }
}
