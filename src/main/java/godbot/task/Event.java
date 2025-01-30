package godbot.task;
public class Event extends Task{
    private String from;
    private String to;


    public Event(String description, String from, String to, boolean isDone){
      super(description);
      this.from = from;
      this.to = to;
      this.isDone = isDone;
    }

    public Event(String description, String from, String to){
      super(description);
      this.from = from;
      this.to = to;
    }

    @Override
    public String toString(){
      return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String toFileFormat() {
      return "E | " + (isDone ? "1" : "0") + " | " + description + " | |" + from + " | " + to;
    }
  }
