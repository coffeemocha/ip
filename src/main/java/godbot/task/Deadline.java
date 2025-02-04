package godbot.task;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a specific deadline.
 * Inherits from the {@link Task} class and adds a deadline attribute.
 */
public class Deadline extends Task {
    protected LocalDate deadline;

    /**
     * Constructs a Deadline task with a description, deadline, and completion status.
     *
     * @param description The description of the deadline task.
     * @param deadline    The due date of the task in {yyyy-MM-dd} format.
     * @param isDone      The completion status of the task. True if completed, otherwise false.
     */
    public Deadline(String description, String deadline, boolean isDone) {
        super(description);
        this.deadline = LocalDate.parse(deadline);
        this.isDone = isDone;
    }

    /**
     * Constructs a Deadline task with a description and deadline.
     * The task is marked as not done by default.
     *
     * @param description The description of the deadline task.
     * @param deadline    The due date of the task in {yyyy-MM-dd} format.
     */
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = LocalDate.parse(deadline);
    }

    /**
     * Returns a string representation of the Deadline task for display purposes.
     *
     * @return A formatted string showing the task type, status, description, and due date.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    /**
     * Converts the Deadline task to a file-friendly format for saving to storage.
     *
     * @return A string representing the task in the format {@code D | isDone | description | deadline}.
     */
    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + deadline;
    }
}

