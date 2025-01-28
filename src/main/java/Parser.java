public class Parser {
    public static boolean processCommand(String input, TaskList tasks, Storage storage, Ui ui) {
        try {
            String[] inputParts = input.split(" ", 2);
            String command = inputParts[0];
            String argument = (inputParts.length > 1) ? inputParts[1] : "";

            if (command.equals("bye")) {
                return false;
            } else if (command.equals("list")) {
                tasks.showTasks(ui);
            } else if (command.equals("todo")) {
                Task task = new ToDo(argument);
                tasks.addTask(task);
                storage.save(tasks.getAllTasks());
                ui.showMessage("Added: " + task);
            } else if (command.equals("deadline")) {
                String[] parts = argument.split(" /by ");
                Task task = new Deadline(parts[0], parts[1]);
                tasks.addTask(task);
                storage.save(tasks.getAllTasks());
                ui.showMessage("Added: " + task);
            } else {
                ui.showMessage("Speak properly mortal, I do not understand you.");
            }
        } catch (Exception e) {
            ui.showMessage("Invalid command, mortal.");
        }
        return true;
    }
}

