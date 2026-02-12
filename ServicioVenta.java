public class ServicioVenta {

    private static final double LIMITE_DESCUENTO = 50.0;
    private static final double PORCENTAJE_DESCUENTO = 0.90;
    private static final int STOCK_BAJO = 3;

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
