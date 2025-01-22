import java.util.*;

public class GodBot {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
      GodBot godBot = new GodBot();
      godBot.run();
    }
    
    public void run(){
      welcomeBanner();
      boolean isRunning = true;
      
      while(isRunning){
        String input = readInput();
        isRunning = processInput(input);
      }

      goodbyeBanner();
    }


    private void welcomeBanner(){
	  String logo ="  ________           ._____________        __    \n"
           + " /  _____/  ____   __| _/\\______   \\ _____/  |_  \n"
           + "/   \\  ___ /  _ \\ / __ |  |    |  _//  _ \\   __\\ \n"
           + "\\    \\_\\  (  <_> ) /_/ |  |    |   (  <_> )  |   \n"
           + " \\______  /\\____/\\____ |  |______  /\\____/|__|   \n"
           + "        \\/            \\/         \\/              \n"; 
          System.out.println("Speak, puny mortal.\n" + logo);
    }

    private void goodbyeBanner(){
      System.out.println("Begone mortal.");
    }

    private String readInput(){
      return scanner.nextLine();
    }

    private boolean processInput(String input){
      String[] inputParts = input.split(" "); //trying to process the input
      String command = inputParts[0];
      String argument;
      if(inputParts.length > 1){
        argument = inputParts[1];
      }
      else{
        argument = "";
      }

      if (command.equals("bye")){ //start of command checking
        return false;
      } 
      else if (command.equals("list")){
        showList();
      }
      else if (command.equals("mark")){
        processMark(argument);
        Integer index = Integer.parseInt(argument) - 1;
        System.out.println("I have marked this simple task as done, mortal. \n");
        System.out.println(index+1 + "." + tasks.get(index));
      }
      else if (command.equals("unmark")){
        processUnmark(argument);
        Integer index = Integer.parseInt(argument) - 1;
        System.out.println("I have marked this simple task as undone, mortal. \n");
        System.out.println(index+1 + "." + tasks.get(index));
      }
      else{
        storeList(input);
      }
      return true;
    }
    
    private void showList(){
      for (int i = 0; i<tasks.size();i++){
      System.out.println(i+1 + "." + tasks.get(i));
      }
    }

    private void storeList(String input){
      Task task = new Task(input);
      tasks.add(task);
      System.out.println("Added your mortal task: " + input + "\n");
    }

    private void processMark(String argument){
      int index = Integer.parseInt(argument) - 1;
      tasks.get(index).markDone();
    }
    private void processUnmark(String argument){
      int index = Integer.parseInt(argument) - 1;
      tasks.get(index).markNotDone();
    }
    
}
