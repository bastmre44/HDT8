import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // cola de prioridad utilizando PriorityQueue
        PriorityQueue<proceso> colaPrioridad = new PriorityQueue<>();

        // se leen los datos de los procesos desde el archivo procesos.txt
        List<proceso> listaProcesos = leerProcesosDesdeArchivo("procesos.txt");

        // para agregar  los procesos a la cola de prioridad
        colaPrioridad.addAll(listaProcesos);

        //se antienden los procesos de acuerdo con su prioridad
        while (!colaPrioridad.isEmpty()) {
            proceso procesoAtendido = colaPrioridad.poll(); // Obtenemos y eliminamos el proceso de mayor prioridad
            System.out.println("Atendiendo proceso: " + procesoAtendido.getNombreProceso() +
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
                // Dividimos la línea en partes usando coma como delimitador
                String[] partes = linea.split(",");
                // Creamos un objeto Proceso con los datos de la línea y lo agregamos a la lista
                listaProcesos.add(new proceso(partes[0], partes[1], Integer.parseInt(partes[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaProcesos;
    }
}
