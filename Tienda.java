import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CÓDIGO CON CODESMELLING
 * 
 * TODO: Este código necesita un refactorización urgente.
 * - Eliminar la "Clase Dios" que es todo el main
 * - Usar programación orientada a objetos
 * - Eliminar números fijos introducidos en el código (no están dentro de variables).
 * - Mejorar la gestión de logs (Patrón Singleton).
 */
public class Tienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TiendaVerdadera> tiendas = new ArrayList<>();
        boolean func = true;
        double precioDescuento = 50.0;

        // Datos de prueba iniciales

        TiendaVerdadera n = new TiendaVerdadera("Camiseta", 15.0, 10),
        p = new TiendaVerdadera("Pantalon", 30.0, 5),
        s = new TiendaVerdadera("Zapatos", 45.0, 2);
        tiendas.add(n);
        tiendas.add(p);
        tiendas.add(s);
        
        while(func) {
            int op;
            System.out.println("\n--- TIENDA ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            

            try {
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.print("Nombre del producto: ");
                        String nombre = sc.next();
                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        System.out.print("Stock inicial: ");
                        int stock = sc.nextInt();
                
                        TiendaVerdadera tienda = new TiendaVerdadera(nombre, precio, stock);
                        tiendas.add(tienda);
                        System.out.println("Producto añadido correctamente.");
                        break;
                    case 2:
                        System.out.println("\n--- INVENTARIO ACTUAL ---");
                        if(tiendas.isEmpty()) {
                            System.out.println("No hay productos.");
                        } else {
                            for(int i=0; i<tiendas.size(); i++) {
                                System.out.println(i + ". " + tiendas.get(i).getNombre() + " - " + tiendas.get(i).getPrecio() + "€ - Stock: " + tiendas.get(i).getStock());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("\n--- VENTA ---");
                        System.out.print("Introduzca nombre del producto a vender: ");
                        String prod = sc.next();
                
                        int pos = -1;
                        for(int i=0; i<tiendas.size(); i++) {
                            if(tiendas.get(i).getNombre().equalsIgnoreCase(prod)) {
                                pos = i;
                                break;
                            }
                        }
                
                        if(pos != -1) {
                            System.out.println("Producto encontrado: " + tiendas.get(pos).getNombre());
                            System.out.println("Precio: " + tiendas.get(pos).getPrecio() + "€ | Stock: " + tiendas.get(pos).getStock());
                            System.out.print("Cantidad a comprar: ");
                            int cant = sc.nextInt();
                    
                            if(tiendas.get(pos).getStock() >= cant) {
                                double total = cant * tiendas.get(pos).getPrecio();
                        
                                // Hay números fijos que se utilizan en el código
                                if(total > precioDescuento) {
                                    System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
                                    total = total * 0.90; 
                                }
                        
                                tiendas.get(pos).setStock(tiendas.get(pos).getStock() - cant); // Actualizar stock
                                System.out.println("Venta realizada. Total a pagar: " + total + "€");
                        
                                // Debería ser Singleton
                                System.out.println("[LOG SYSTEM]: Venta de " + cant + "x " + tiendas.get(pos).getNombre() + " registrada.");
                                if(tiendas.get(pos).getStock() < 3) {
                                    System.out.println("[LOG SYSTEM]: ALERTA DE STOCK BAJO para " + tiendas.get(pos).getNombre());
                                }
                        
                            } else {
                                System.out.println("Error: No hay suficiente stock.");
                            }
                        } else {
                            System.out.println("Error: Producto no encontrado.");
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        func = false;
                        break;
                    default:
                        System.out.println("No pongas letras donde no debes");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("No pongas letras donde no debes");
                break;
            }
        }
        sc.close();
    }
}