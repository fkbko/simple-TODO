
public class TodoMain {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager("todolist.xml");
        Menu menu = new Menu(taskManager);
        menu.function();
    }
}