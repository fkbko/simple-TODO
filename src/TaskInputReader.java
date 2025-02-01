import java.util.Scanner;

public class TaskInputReader {
    private final Scanner scanner;
    public TaskInputReader(Scanner scanner){
        this.scanner = scanner;
    }
    public TaskEngine readTaskInput(){
        System.out.println("Введите заголовок задачи: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Введите описание задачи: ");
        String description = scanner.nextLine();
        return  new TaskEngine(title, description);
    }
}
