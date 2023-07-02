import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readList {
    static void readTodoList() {
        try {
            File file = new File(TodoMain.fileName);
            Scanner fileReader = new Scanner(file);

            TodoMain.myLists.clear();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                TodoMain.myLists.add(data);

            }

        } catch (FileNotFoundException e) {
            System.out.println("an Error occurred: " + e.getMessage());
        }
    }
}
