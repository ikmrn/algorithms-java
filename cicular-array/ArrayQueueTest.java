import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @Test
    public void testEnqueueAndDequeue() {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }
    
    @Test
    public void testQueueGrow() {
        ArrayQueue queue = new ArrayQueue(2);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3); // This should trigger array growth
        
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }
    
    @Test
    public void testDequeueEmptyQueue() {
        ArrayQueue queue = new ArrayQueue(2);
        assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });
    }
}
