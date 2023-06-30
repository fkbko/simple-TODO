import java.util.Scanner;

public class addTask {
    public static void addItem() {
        System.out.print("Add new task: ");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        TodoMain.myLists.add(item);
        showLists.showList();
    }
}
