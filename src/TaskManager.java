
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.*;

public class TaskManager implements ToDoInterface {
    private static final String usrDIR = "/Users/mac/Documents/JavaProjects/simple TODO/";
    File TxtToDoData;
    private Map<String, TaskEngine> tasks;

    public TaskManager(File usrFile) {
        this.TxtToDoData = usrFile;
        this.tasks = loadFromTxt();
    }


    @Override
    public void addTask(TaskEngine taskEngine) {
        tasks.put(taskEngine.getKey(), taskEngine);
        saveToTxt( taskEngine);
    }

    @Override
    public void deleteTask(String key) {
        tasks.remove(key);
        saveToTxt();

    }

    @Override
    public void redactTask(String key, TaskEngine redactedTask) {
        tasks.put(key, redactedTask);
        saveToTxt();

    }

    @Override
    public TaskEngine showTask(String key) {
        return tasks.get(key);

    }

    @Override
    public List<TaskEngine> getAllTask() {
        return new ArrayList<>(tasks.values());

    }

    private void saveToTxt() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TxtToDoData, true))) {
            for (TaskEngine task : tasks.values()) {
                writer.newLine();
                writer.write(task.toString());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private void saveToTxt( TaskEngine taskEngine) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TxtToDoData, true))) {

                writer.newLine();
                writer.write(taskEngine.toString());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<String, TaskEngine> loadFromTxt() {
        Map<String, TaskEngine> taskEngineMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(TxtToDoData))) {
            String line;
            reader.readLine();
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                TaskEngine task = parseTask(line);

                if (task != null) {
                    taskEngineMap.put(task.getKey(), task);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return taskEngineMap;
    }
    private TaskEngine parseTask(String line) {
        try {
            String[] parts = line.split(";;");
            String key = parts[0];
            String name = parts[1];
            String description = parts.length > 2 ? parts[2] : "";
            return new TaskEngine(name, description);
        } catch (Exception e) {
            System.err.println("Ошибка парсинга задачи: " + line);
            return null;
        }
    }
}


