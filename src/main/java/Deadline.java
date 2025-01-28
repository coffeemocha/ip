public class Deadline extends Task{
    private String deadline;


    public Deadline(String description, String deadline, boolean isDone){
      super(description);
      this.deadline = deadline;
      this.isDone = isDone;
    }

    public Deadline(String description, String deadline){
      super(description);
      this.deadline = deadline;
      
    }
    @Override
    public String toString(){
      return "[D]" + super.toString() + " (by: " + deadline + ")";
    }

    @Override
    public String toFileFormat() {
      return "D | " + (isDone ? "1" : "0") + " | " + description + " | "+ deadline;
    }
  }
