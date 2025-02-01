import java.io.Serializable;

public class TaskEngine implements Serializable {
    private String key;
    private String title;
    private String description;

    public TaskEngine(String key, String title, String description) {
        this.key = key;
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
