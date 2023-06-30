import java.util.Scanner;

public class removeTask {
    public static void removingTasks() {
        System.out.println("Remove task");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Chose task to remove ");
        int index = scanner.nextInt();
        if ((index - 1) < 0 || index > TodoMain.myLists.size()) {
            System.out.println("Wrong index number. Please enter in range of 1 to " + TodoMain.myLists.size());
        } else {
            TodoMain.myLists.remove(index - 1);
        }
        showLists.showList();
    }
}