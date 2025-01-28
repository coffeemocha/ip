import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
          parentDir.mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("GodBot has caught an IO Exception while trying to read file");
            tasks.clear();
        }
        return tasks;
    }

    public void save(ArrayList<Task> tasks) throws IOException {
      File file = new File(filePath);
      File parentDir = file.getParentFile();
      if (parentDir != null && !parentDir.exists()){
        parentDir.mkdirs();
      }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        }
    }

    private Task parseTask(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            return null;
        }

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        if (type.equals("T")) {
            return new ToDo(description, isDone);
        }
        else if (type.equals("D")) {
            return new Deadline(description, parts[3], isDone);
        }
        else if (type.equals("E")) {
            return new Event(description, parts[3], parts[4], isDone);
        }
        else {
            return null;
        }
    }
}

