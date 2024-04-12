public class proceso implements Comparable<proceso> {
    private String nombreProceso;
    private String nombreUsuario;
    private int niceValue;

    public proceso(String nombreProceso, String nombreUsuario, int niceValue) {
        this.nombreProceso = nombreProceso;
        this.nombreUsuario = nombreUsuario;
        this.niceValue = niceValue;
    }

    // Implementación del método compareTo para comparar procesos según su prioridad
    @Override
    public int compareTo(proceso otroProceso) {
        // Calculamos la prioridad (PR) de este proceso y del otro proceso
        int prioridadEsteProceso = 20 + this.niceValue;
        int prioridadOtroProceso = 20 + otroProceso.niceValue;

        // Para comprar las prioridades
        return Integer.compare(prioridadOtroProceso, prioridadEsteProceso); // Orden descendente
    }

    // Métodos para acceder a los datos del proceso
    public String getNombreProceso() {
        return nombreProceso;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getNiceValue() {
        return niceValue;
    }
}
