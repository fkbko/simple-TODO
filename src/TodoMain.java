import com.sun.source.util.SourcePositions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoMain {
    public static List<String> myLists = new ArrayList<String>();

    public static void main(String[] args) {


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
