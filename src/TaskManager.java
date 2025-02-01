
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.*;

public class TaskManager implements ToDoInterface {
    private static final String usrDIR = "/Users/mac/Documents/JavaProjects/simple TODO/";
    File TxtToDoData;
    private Map<String, TaskEngine> tasks;

    public TaskManager(String username) {
        this.TxtToDoData = new File(usrDIR + username + "1" + ".txt");
        this.tasks = loadFromTxt();
    }


    @Override
    public void addTask(TaskEngine taskEngine) {
        tasks.put(taskEngine.getKey(), taskEngine);
        saveToTxt();
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TxtToDoData))) {
            for (TaskEngine task : tasks.values()) {
                writer.write(task.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<String, TaskEngine> loadFromTxt() {
        Map<String, TaskEngine> taskEngineMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(TxtToDoData))) {
            String line;
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
            String[] parts = line.split(";;"); // Пример формата: key,name,description
            String key = parts[0];
            String name = parts[1];
            String description = parts.length > 2 ? parts[2] : "";
            return new TaskEngine(key, name, description);
        } catch (Exception e) {
            System.err.println("Ошибка парсинга задачи: " + line);
            return null;
        }
    }
}


