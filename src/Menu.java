import java.util.Scanner;

public class Menu {
    private final TaskManager taskManager;
    private final Scanner scanner;

    public Menu(TaskManager taskManager){
        this.taskManager = taskManager;
        this.scanner = new Scanner(System.in);
    }
    public void function(){
        while(true){
            displayMenu();
            int choice = getUserChoice();
            switch (choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    redactTask();
                    break;
                case 4:
                    displayTask();
                    break;
                case 5:
                    displayAllTasks();
                    break;
                case 6:
                    System.out.println("Выход из приложения.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите действие от 1 до 6.");
                    break;
            }
        }
    }
    private void displayMenu(){
        System.out.println("Выберите функцию:");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Обновить задачу");
        System.out.println("4. Показать задачу по ключу");
        System.out.println("5. Показать все задачи");
        System.out.println("6. Выход");
    }
    private int getUserChoice(){
        return scanner.nextInt();
    }
    private void addTask(){
        TaskInputReader taskInputReader = new TaskInputReader(scanner);
        TaskEngine taskEngine = taskInputReader.readTaskInput();
        taskManager.addTask(taskEngine );
        System.out.println("задача успешно добавлена");
    }

    private void deleteTask(){
        System.out.println("введите ключ для удаления: ");
        String DeleteKey = scanner.next();
        taskManager.deleteTask(DeleteKey);
        System.out.println("задача удалена");
    }

    private void redactTask(){
        System.out.println("Ведите ключ задчи для редактирования:");
        String UpdatingKey = scanner.next();
        TaskEngine ifExist = taskManager.showTask(UpdatingKey);
        if (ifExist != null){
            TaskInputReader taskInputReader = new TaskInputReader(scanner);
            TaskEngine updatedTask = taskInputReader.readTaskInput();
            taskManager.redactTask(UpdatingKey, updatedTask);
            System.out.println("Задача обновлена");

        }else {
            System.out.println("задача не найдена");
        }

    }
    private void displayTask(){
        System.out.println("Введите ключ для просмотра задачи:");
        String DisplayingKey = scanner.next();
        TaskEngine displayingTask = taskManager.showTask(DisplayingKey);
        if (displayingTask != null){
            System.out.println("Заголовок: " + displayingTask.getTitle());
            System.out.println("Описание: " + displayingTask.getDescription());
        } else {
            System.out.println("задача не найдена");
        }
    }
    private void displayAllTasks(){
        System.out.println("список задач: ");
        for (TaskEngine taskEngine: taskManager.getAllTask()){
            System.out.println("Ключ: " + taskEngine.getKey());
            System.out.println("Заголовок: " + taskEngine.getTitle());
            System.out.println("Описание: " + taskEngine.getDescription());
            System.out.println();
        }
    }
}
