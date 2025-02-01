import java.util.Scanner;

public class TodoMain extends RegistrationEngine {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
        System.out.println("1. регистрация");
        System.out.println("2. вход");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

                switch (num){
                    case 1:
                        RegistrationEngine registrationEngine = new RegistrationEngine();
                        Register();
                        break;
                    case 2:
                        LoginEngine1.login1();

                        break;

        }
    }
}


