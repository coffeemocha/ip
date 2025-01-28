import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    protected LocalDate deadline;


    public Deadline(String description, String deadline, boolean isDone){
      super(description);
      this.deadline = LocalDate.parse(deadline);
      this.isDone = isDone;
    }

    public Deadline(String description, String deadline){
      super(description);
      this.deadline = LocalDate.parse(deadline);
      
    }
    @Override
    public String toString(){
      return "[D]" + super.toString() + " (by: " + deadline.format(DateTimeFormatter.ofPattern("MMM dd yyy")) + ")";
    }

    @Override
    public String toFileFormat() {
      return "D | " + (isDone ? "1" : "0") + " | " + description + " | "+ deadline;
    }
  }
