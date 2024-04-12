import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapUsingIterativeBinaryTreeTest {

    @Test
    public void testInsert() {
        HeapUsingIterativeBinaryTree<Integer, String> heap = new HeapUsingIterativeBinaryTree<>(new ComparadorNumeros<>());
        
        // se insertan los elementos al heap
        heap.Insert(5, "proceso1");
        heap.Insert(10, "proceso2");
        heap.Insert(3, "proceso3");

        // se verifican que los elementos estén en el heap
        assertEquals("proceso2", heap.get());
    }

    @Test
    public void testRemove() {
        HeapUsingIterativeBinaryTree<Integer, String> heap = new HeapUsingIterativeBinaryTree<>(new ComparadorNumeros<>());
        
        // se insertan elementos al heap
        heap.Insert(5, "proceso1");
        heap.Insert(10, "proceso2");
        heap.Insert(3, "proceso3");

        // se elimina un elemento del heap
        String procesoEliminado = heap.remove();

        // se verifica que se haya eliminado el elemento correcto
        assertEquals("proceso2", procesoEliminado);
        assertEquals("proceso3", heap.get());
    }
}
