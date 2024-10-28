import java.io.FileWriter;
import java.io.IOException;


public class Registration {

    private String username;
    private String password;

    public Registration(String username, String password){
        this.username = username;
        this.password = password;
                }
        String getUsername () {
            return username;
        }

       public String getPassword () {
            return password;
        }
    }

