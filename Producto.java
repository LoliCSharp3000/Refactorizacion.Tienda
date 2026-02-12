/**
 * Clase que representa un producto dentro del sistema.
 * Contiene información básica como nombre, precio y stock disponible.
 */
public class Producto {

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Precio del producto.
     */
    private double precio;

    /**
     * Cantidad disponible en stock.
     */
    private int stock;

    /**
     * Constructor que inicializa un producto con su nombre, precio y stock.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param stock  Cantidad disponible en inventario.
     */
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return el nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el precio del producto.
     *
     * @return el precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve la cantidad disponible en stock.
     *
     * @return el stock actual del producto.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Comprueba si hay suficiente stock para una cantidad solicitada.
     *
     * @param cantidad Cantidad que se desea comprobar.
     * @return true si hay stock suficiente, false en caso contrario.
     */
    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    /**
     * Reduce el stock del producto en la cantidad indicada.
     *
     * @param cantidad Cantidad que se desea descontar del stock.
     * @throws IllegalArgumentException si no hay suficiente stock disponible.
     */
    public void reducirStock(int cantidad) {
        if (!hayStock(cantidad)) {
            throw new IllegalArgumentException("Stock insuficiente");
        }
        stock -= cantidad;
    }
}
