import java.util.Scanner;
public class Menu {
    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("0. Exit the program");
        System.out.println("1. Display to-do list");
        System.out.println("2. Add new task to list");
        System.out.println("3. Remove task from list");
        System.out.println();
        System.out.print("Enter option: ");
        int choice = scanner.nextInt();
        return choice;


    }
}