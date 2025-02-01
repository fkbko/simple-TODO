import java.util.List;
public interface ToDoInterface {

    void addTask(TaskEngine taskEngine);

     void deleteTask(String key);

     void redactTask(String key, TaskEngine redactedTask);

     TaskEngine showTask(String key);

     List<TaskEngine> getAllTask();

}
