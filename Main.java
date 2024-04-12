import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Se crea un nuevo gestor de procesos
        GestionadorProcesos gestionadorProcesos = new GestionadorProcesos();

        // Se leen los datos de los procesos desde el archivo procesos.txt
        List<proceso> listaProcesos = leerProcesosDesdeArchivo("procesos.txt");

        // ASe agregan los procesos a la cola de prioridad
        for (proceso proceso : listaProcesos) {
            gestionadorProcesos.agregarProceso(proceso);
        }

        // para atender los procesos de acuerdo con su prioridad
        while (gestionadorProcesos.hayProcesosPendientes()) {
            proceso procesoAtendido = gestionadorProcesos.atenderProceso();
            System.out.println("Atendiendo proceso de mayor a menor: " + procesoAtendido.getNombreProceso() +
                    ", Usuario: " + procesoAtendido.getNombreUsuario() +
                    ", Nice Value: " + procesoAtendido.getNiceValue());
        }
    }

    // Método para leer los datos de los procesos desde el archivo y devolver una lista de objetos Proceso
    private static List<proceso> leerProcesosDesdeArchivo(String nombreArchivo) {
        List<proceso> listaProcesos = new ArrayList<>();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((linea = br.readLine()) != null) {
                // Dividir  la línea en partes usando coma como delimitador
                String[] partes = linea.split(",");
                // Para crear un objeto Proceso con los datos de la línea y lo agregamos a la lista
                listaProcesos.add(new proceso(partes[0], partes[1], Integer.parseInt(partes[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaProcesos;
    }
}
