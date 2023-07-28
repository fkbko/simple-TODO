import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class removeTask {
    public static void removingTasks() {
        showLists.showList();
        System.out.println("choose task to remove: ");
        Scanner scanner = new Scanner(System.in);
        int index;
        index = Integer.parseInt(scanner.nextLine());
        try {
            if (index > TodoMain.myLists.size()) {
                throw new IndexOutOfBoundsException("wrong data");
            } else {

                System.out.println("will be removed: ");
                System.out.println(String.format("[%d] %s", index, TodoMain.myLists.get(index)));
                TodoMain.myLists.remove(index);
                try {
                    FileWriter fileWriter = new FileWriter(TodoMain.fileName, false);

                    for (String data : TodoMain.myLists) {
                        fileWriter.append(String.format("%s%n", data));
                    }
                    fileWriter.close();

                    System.out.println("Successfully removed");
                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}