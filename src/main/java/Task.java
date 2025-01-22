public class Task {
  protected String description;
  protected boolean isDone;

  public Task(String description){
    this.description = description;
    this.isDone = false;
  }

  public String getStatus(){
    if (isDone){
      return "X";
    }
    else{
      return " ";
    }
  }

  public void markDone(){
    this.isDone = true;
  }

  public void markNotDone(){
    this.isDone = false;
  }
  
  public String toString(){
    return "[" + getStatus() + "]" + this.description;
  }
}
