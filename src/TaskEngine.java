import java.io.Serializable;

public class TaskEngine implements Serializable {
    private String key;
    private String title;
    private String description;
    private static int idCounter = 0;

    public TaskEngine(String title, String description) {
        int i = idCounter++;
        this.key = String.valueOf(i);
        this.title = title;
        this.description = description;

    }
    public String getKey(){
        return key;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return String.join(";;", key, title, description);
    }

}
