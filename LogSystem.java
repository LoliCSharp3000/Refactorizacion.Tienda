public class LogSystem {

    private static LogSystem instancia;

    private LogSystem() {}

    public static LogSystem getInstancia() {
        if (instancia == null) {
            instancia = new LogSystem();
        }
        return instancia;
    }

    public void log(String mensaje) {
        System.out.println("[LOG] " + mensaje);
    }
}