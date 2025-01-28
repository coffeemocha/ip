import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage() {
        String logo ="  ________           ._____________        __    \n"
           + " /  _____/  ____   __| _/\\______   \\ _____/  |_  \n"
           + "/   \\  ___ /  _ \\ / __ |  |    |  _//  _ \\   __\\ \n"
           + "\\    \\_\\  (  <_> ) /_/ |  |    |   (  <_> )  |   \n"
           + " \\______  /\\____/\\____ |  |______  /\\____/|__|   \n"
           + "        \\/            \\/         \\/              \n";
        System.out.println("Speak, puny mortal.\n" + logo);
    }

    public void showGoodbyeMessage() {
        System.out.println("Begone mortal.");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readCommand() {
        return scanner.nextLine();
    }
}

