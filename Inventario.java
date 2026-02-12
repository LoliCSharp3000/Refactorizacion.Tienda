import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un inventario de productos.
 * Permite agregar, buscar y mostrar productos almacenados.
 */
public class Inventario {

    /**
     * Lista que almacena los productos del inventario.
     */
    private List<Producto> productos;

    /**
     * Constructor de la clase Inventario.
     * Inicializa la lista de productos.
     */
    public Inventario() {
        productos = new ArrayList<>();
    }

    /**
     * Agrega un producto al inventario.
     *
     * @param producto El producto que se desea añadir al inventario.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Busca un producto por su nombre.
     *
     * @param nombre El nombre del producto a buscar.
     * @return El producto si se encuentra en el inventario,
     *         o null si no existe.
     */
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Muestra por pantalla todos los productos del inventario.
     * Si el inventario está vacío, muestra un mensaje indicándolo.
     */
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
