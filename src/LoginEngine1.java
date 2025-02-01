import java.io.*;
import java.util.Scanner;

public class LoginEngine1 extends RegistrationEngine {
    private static final String usrDIR =  "/Users/mac/Documents/JavaProjects/simple TODO/";
    public static boolean login1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        File usrFile = new File(usrDIR + username + ".txt");
        boolean foundUser = false;
        boolean foundPassword = false;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(usrFile))){
            String readed;
            while ((readed = bufferedReader.readLine()) != null) {

                if (readed.equals(password)){
                    TaskManager tm = new TaskManager(username);
                    Menu menu = new Menu(tm);
                    menu.function();
                    return true;
                } else {
                    System.out.println("wrong password");
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("an error occurred: " + e.getMessage());
        }return false;
    }
}
