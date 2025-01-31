package godbot.storage;

import godbot.task.Task;
import godbot.task.ToDo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {

    @Test
    public void testParseTaskFromFile() {
        String fileLine = "T | 0 | Finish homework";

        Task task = Storage.parseTask(fileLine);
        assertNotNull(task, "Task should not be null");
        assertEquals("Finish homework", task.description, "Task description should match");
        assertFalse(task.isDone, "Task should be initially not done");
    }
}

