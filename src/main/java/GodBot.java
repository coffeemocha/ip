import java.util.*;
public class GodBot {
    public static void main(String[] args) {
	  String logo ="  ________           ._____________        __    \n"
           + " /  _____/  ____   __| _/\\______   \\ _____/  |_  \n"
           + "/   \\  ___ /  _ \\ / __ |  |    |  _//  _ \\   __\\ \n"
           + "\\    \\_\\  (  <_> ) /_/ |  |    |   (  <_> )  |   \n"
           + " \\______  /\\____/\\____ |  |______  /\\____/|__|   \n"
           + "        \\/            \\/         \\/              \n"; 
          System.out.println("Speak, puny mortal.\n" + logo);
    
    
    
    	Scanner scanner = new Scanner(System.in);
    	while (true){
	 	   String input = scanner.nextLine();
	    	if (input.equals("bye")){
	    		System.out.println("Begone mortal.");
			break;
	    	}
	    	else{
	    		System.out.println(input);
	    	}
    	}
    	scanner.close();
    }
}
