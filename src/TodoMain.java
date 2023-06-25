import com.sun.source.util.SourcePositions;

import java.util.ArrayList;

public class TodoMain {
   ArrayList<Task> MyLists = new ArrayList<>();
public void addNew(String description){
    MyLists.add(new Task(description));
}
public void getMyListsList(){
    for (Task task : MyLists){
        System.out.println(task);
    }
}
public void info(){
    System.out.println("your tasks:");
    System.out.println();
    getMyListsList();
    if (MyLists == null){
        System.out.println("all tasks done for today!");

    }
}

    }
