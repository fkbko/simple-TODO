import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
public class RegistrationEngine {

        private static final String usrDIR = "/Users/mac/Documents/JavaProjects/simple TODO/";


        public static boolean Register () {
            Scanner scan = new Scanner(System.in);
            System.out.println("введите имя пользователя:");
            String username = scan.nextLine();
            System.out.println("введите пароль:");
            String password = scan.nextLine();
            File usrFile = new File(usrDIR + username + ".txt");
            User user = new User(username, password);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(usrFile))) {
                writer.write(password);
                writer.newLine();
                writer.write(username);
                TaskManager tm = new TaskManager(usrFile);
                System.out.println("пользователь зарегистрирован, повторите имя пользователя и пароль чтобы войти");
                return true;
            } catch (IOException e) {
                return false;

            }

        }
    }


