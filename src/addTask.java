import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class addTask {
    public static void addItem() {
        System.out.print("Add new task: ");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        try {
            // tulis file
            FileWriter fileWriter = new FileWriter(TodoMain.fileName, true);
            fileWriter.append(String.format("%s%n", item));
            fileWriter.close();

            System.out.println("Successfully added");
        } catch (IOException e) {
            System.out.println(" an error occurred: " + e.getMessage());
        }
        showLists.showList();
    }
}
