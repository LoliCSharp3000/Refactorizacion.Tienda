/**
 * Clase que implementa el patrón de diseño Singleton.
 * 
 * LogSystem permite registrar mensajes en consola y garantiza
 * que solo exista una única instancia de la clase en toda la aplicación.
 */
public class LogSystem {

    /**
     * Instancia única de la clase LogSystem.
     */
    private static LogSystem instancia;

    /**
     * Constructor privado para evitar que se creen objetos
     * desde fuera de la clase.
     */
    private LogSystem() {}

    /**
     * Devuelve la única instancia de LogSystem.
     * Si no existe, la crea.
     *
     * @return la instancia única de LogSystem.
     */
    public static LogSystem getInstancia() {
        if (instancia == null) {
            instancia = new LogSystem();
        }
        return instancia;
    }

    /**
     * Muestra un mensaje de registro (log) por consola.
     *
     * @param mensaje el texto que se desea registrar.
     */
    public void log(String mensaje) {
        System.out.println("[LOG] " + mensaje);
    }
}
