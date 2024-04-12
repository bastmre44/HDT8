

public class GestionadorProcesos {
    private HeapUsingIterativeBinaryTree<Integer, proceso> colaPrioridad;

    public GestionadorProcesos() {
        //  nueva cola de prioridad utilizando el comparador de enteros proporcionado por el heap
        colaPrioridad = new HeapUsingIterativeBinaryTree<>(Integer::compareTo);
    }

    // Método para agregar un proceso a la cola de prioridad
    public void agregarProceso(proceso proceso) {
        colaPrioridad.Insert(proceso.getNiceValue(), proceso);
    }

    // Método para atender el siguiente proceso de la cola de prioridad
    public proceso atenderProceso() {
        return colaPrioridad.remove();
    }

    // Método para verificar si hay procesos en la cola de prioridad
    public boolean hayProcesosPendientes() {
        return !colaPrioridad.isEmpty();
    }

    // Método para obtener el número de procesos en la cola de prioridad
    public int obtenerCantidadProcesosPendientes() {
        return colaPrioridad.count();
    }
}

