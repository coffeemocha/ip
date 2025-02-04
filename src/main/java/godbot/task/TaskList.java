package godbot.task;

import java.util.ArrayList;
import godbot.ui.Ui;

/**
 * Represents a list of tasks managed by the user.
 * Provides functionality to add, mark, unmark, and display tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty {@code TaskList}.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a {@code TaskList} with the provided list of tasks.
     *
     * @param tasks The initial list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a new task to the task list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Marks the task at the specified index as done.
     *
     * @param index The index of the task to mark as done (0-based).
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void markTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markDone();
        } else {
            throw new IndexOutOfBoundsException("Task index is out of range.");
        }
    }

    /**
     * Marks the task at the specified index as not done.
     *
     * @param index The index of the task to mark as not done (0-based).
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void unmarkTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markNotDone();
        } else {
            throw new IndexOutOfBoundsException("Task index is out of range.");
        }
    }

    /**
     * Displays all tasks in the task list using the provided UI.
     *
     * @param ui The UI object used to display the tasks.
     */
    public void showTasks(Ui ui) {
        if (tasks.isEmpty()) {
            ui.showMessage("No tasks in your list, mortal.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                ui.showMessage((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public String findTasks(String keyword){
    	StringBuilder result = new StringBuilder("Here are the matching tasks in your list:\n");
    	boolean found = false;
    	for (int i = 0; i < tasks.size(); i++) {
          Task task = tasks.get(i);
          if (task.description.toLowerCase().contains(keyword.toLowerCase())) {
            result.append((i + 1)).append(". ").append(task).append("\n");
            found = true;
          }
    	}
    	if (!found) {
          result.append("No matching tasks found.");
    	}
    	return result.toString();	
    	}


    /**
     * Retrieves the task at the specified index.
     *
     * @param index The index of the task to retrieve (0-based).
     * @return The task at the specified index.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Retrieves the entire list of tasks.
     *
     * @return An {@code ArrayList} containing all tasks.
     */
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }
}

