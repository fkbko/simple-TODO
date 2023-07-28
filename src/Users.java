public class Users {
    private String username;
    private String password;

    Users (String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }
    String getPassword() {
        return password;
    }
}
