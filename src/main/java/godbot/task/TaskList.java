package godbot.task;

import java.util.ArrayList;
import godbot.ui.Ui;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markDone();
        } else {
            throw new IndexOutOfBoundsException("Task index is out of range.");
        }
    }

    public void unmarkTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markNotDone();
        } else {
            throw new IndexOutOfBoundsException("Task index is out of range.");
        }
    }

    public void showTasks(godbot.ui.Ui ui) {
        if (tasks.isEmpty()) {
            ui.showMessage("No tasks in your list, mortal.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                ui.showMessage((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }
}

