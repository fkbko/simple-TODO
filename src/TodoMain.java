import com.sun.source.util.SourcePositions;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoMain {
   static List<String> myLists;
   static String fileName;

    public static void main(String[] args) {
        myLists = new ArrayList<>();
        String filePath = System.console() == null ? "/src/todolist.txt" : "/todolist.txt";
        fileName = System.getProperty("user.dir") + filePath;

        System.out.println("FILE: " + fileName);

        int menuItem = -1;
        while (menuItem != 0) {
            menuItem = Menu.menu();
            switch (menuItem) {
                case 1:
                    showLists.showList();
                    break;
                case 2:
                    addTask.addItem();
                    break;
                case 3:
                    removeTask.removingTasks();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
        }
    }
}
