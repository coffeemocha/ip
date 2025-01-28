import java.util.*;
import java.io.IOException;

public class GodBot {
    private TaskList tasks;
    private Storage storage;
    private Ui ui;

    public GodBot(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showMessage("Failed to load your tasks mortal.");
            tasks = new TaskList();
        }
    }

    public static void main(String[] args) {
        new GodBot("./data/godbot.txt").run();
    }

    public void run() {
        ui.showWelcomeMessage();
        boolean isRunning = true;

        while (isRunning) {
            String input = ui.readCommand();
            isRunning = Parser.processCommand(input, tasks, storage, ui);
        }

        ui.showGoodbyeMessage();
    }
}

