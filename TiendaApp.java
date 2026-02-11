import java.util.Scanner;

public class TiendaApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        ServicioVenta servicioVenta = new ServicioVenta();

        inventario.agregarProducto(new Producto("Camiseta", 15.0, 10));
        inventario.agregarProducto(new Producto("Pantalon", 30.0, 5));
        inventario.agregarProducto(new Producto("Zapatos", 45.0, 2));

        boolean ejecutando = true;

        while (ejecutando) {

            System.out.println("\n--- TIENDA ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.next();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();

                    inventario.agregarProducto(new Producto(nombre, precio, stock));
                    break;

                case 2:
                    inventario.mostrarInventario();
                    break;

                case 3:
                    System.out.print("Producto: ");
                    String nombreVenta = sc.next();

                    Producto producto = inventario.buscarProducto(nombreVenta);

                    if (producto == null) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    try {
                        double total = servicioVenta.realizarVenta(producto, cantidad);
                        System.out.println("Total a pagar: " + total + "€");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    ejecutando = false;
                    break;
            }
        }

        sc.close();
    }
}
