package godbot.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testMarkDoneAndMarkNotDone() {
        Task task = new ToDo("attend 2103 tutorial later"); 
        
        task.markDone();
        assertTrue(task.isDone, "Task should be marked as done");

        task.markNotDone();
        assertFalse(task.isDone, "Task should be marked as not done");
    }
}

