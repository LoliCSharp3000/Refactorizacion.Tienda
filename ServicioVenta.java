/**
 * Clase que gestiona la lógica de venta de productos.
 * 
 * Se encarga de:
 * - Verificar el stock disponible.
 * - Calcular el total de la venta.
 * - Aplicar descuentos si corresponde.
 * - Reducir el stock del producto.
 * - Registrar la operación en el sistema de logs.
 */
public class ServicioVenta {

    /**
     * Importe mínimo a partir del cual se aplica descuento.
     */
    private static final double LIMITE_DESCUENTO = 50.0;

    /**
     * Porcentaje de descuento aplicado (0.90 equivale a 10% de descuento).
     */
    private static final double PORCENTAJE_DESCUENTO = 0.90;

    /**
     * Nivel de stock considerado bajo.
     */
    private static final int STOCK_BAJO = 3;

    /**
     * Realiza la venta de un producto.
     *
     * El método:
     * - Comprueba si hay suficiente stock.
     * - Calcula el importe total.
     * - Aplica descuento si se supera el límite establecido.
     * - Reduce el stock del producto.
     * - Registra la venta en el sistema de logs.
     * - Genera una alerta si el stock queda por debajo del mínimo.
     *
     * @param producto Producto que se desea vender.
     * @param cantidad Cantidad de unidades a vender.
     * @return El importe total final de la venta (con descuento si aplica).
     * @throws IllegalArgumentException si no hay stock suficiente.
     */
    public double realizarVenta(Producto producto, int cantidad) {

        if (!producto.hayStock(cantidad)) {
            throw new IllegalArgumentException("No hay suficiente stock.");
        }

        double total = producto.getPrecio() * cantidad;

        if (total > LIMITE_DESCUENTO) {
            total *= PORCENTAJE_DESCUENTO;
        }

        producto.reducirStock(cantidad);

        LogSystem.getInstancia().log("Venta de " + cantidad + "x " + producto.getNombre());

        if (producto.getStock() < STOCK_BAJO) {
            LogSystem.getInstancia().log("ALERTA: Stock bajo de " + producto.getNombre());
        }

        return total;
    }
}
