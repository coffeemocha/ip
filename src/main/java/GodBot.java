import java.util.*;

public class GodBot {
    private ArrayList<String> tasks = new ArrayList<>();
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
      if (input.equals("bye")){
        return false;
      } 
      else if (input.equals("list")){
        showList();
      }
      else{
        storeList(input);
      }
      return true;
    }
    
    private void showList(){
      for (int i = 0; i<tasks.size();i++){
      System.out.println(i+1 + ". " + tasks.get(i));
      }
    }

    private void storeList(String input){
      tasks.add(input);
      System.out.println("Added your mortal task: " + input + "\n");
    }
    
}
