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
      try{
        String[] inputParts = input.split(" ",2); //trying to process the input
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
        }
        else if (command.equals("unmark")){
          processUnmark(argument);
        }
        else if (command.equals("todo")){
          processTodo(argument);
        }
        else if (command.equals("deadline")){
          processDeadline(argument);
        }
        else if (command.equals("event")){
          processEvent(argument);
        }
        else if (command.equals("delete")){
          processDelete(argument);
        }
        else{ //invalid command
          throw new GodBotException("Speak properly mortal, I do not understand you.");
        }
        } catch (GodBotException e){
          System.out.println(e.getMessage());
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
      try{
        int index = Integer.parseInt(argument) - 1;
        if (index < 0 || index >= tasks.size()){
          throw new GodBotException("Enter a proper number, mortal. I am no fool.");
        }
        tasks.get(index).markDone();
        System.out.println("I have marked this simple task as done, mortal.");
        System.out.println(index+1 + "." + tasks.get(index)+ "\n");
    }catch (GodBotException e){
      System.out.println(e.getMessage());
      }
    }
    private void processUnmark(String argument){
      try{
        int index = Integer.parseInt(argument) - 1;
        if (index < 0 || index >= tasks.size()){
          throw new GodBotException("Enter a proper number, mortal. I am no fool.");
        }
        tasks.get(index).markNotDone();
        System.out.println("I have marked this simple task as undone, mortal.");
        System.out.println(index+1 + "." + tasks.get(index) + "\n");
      }catch (GodBotException e){
        System.out.println(e.getMessage());
      }
    }

    private void processTodo(String argument){
      Task todo = new ToDo(argument.trim());
      tasks.add(todo);
      System.out.println("I have added your mortal task: " + todo);
      System.out.println("Now you have " + tasks.size() + " mortal tasks left.\n");
    }

    private void processDeadline(String argument){
      String[] argumentParts = argument.split(" /by ");
      String description = argumentParts[0];
      String deadline = argumentParts[1];
      Task deadlineTask = new Deadline(description, deadline);
      tasks.add(deadlineTask);
      System.out.println("I have added your mortal task: " + deadlineTask);
      System.out.println("Now you have " + tasks.size() + " mortal tasks left. \n");
    }

    private void processEvent(String argument){
      String[] argumentParts = argument.split(" /from | /to");
      String description = argumentParts[0];
      String from = argumentParts[1];
      String to = argumentParts[2];
      Task eventTask = new Event(description, from, to);
      tasks.add(eventTask);
      System.out.println("I have added your mortal task: " + eventTask);
      System.out.println("Now you have " + tasks.size() + " mortal tasks left. \n");
     
    }

    
    private void processDelete(String argument){
      try{
        int index = Integer.parseInt(argument) - 1;
        if (index < 0 || index >= tasks.size()){
          throw new GodBotException("Enter a proper number, mortal. I am no fool.");
        }
        System.out.println("I have removed this simple task, mortal.");
        System.out.println(index+1 + "." + tasks.get(index)+ "\n");
        tasks.remove(index);
    }catch (GodBotException e){
      System.out.println(e.getMessage());
      }
    }
    
}
