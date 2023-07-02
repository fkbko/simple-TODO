public class showLists {
    public static void showList() {
        readList.readTodoList();
        if (TodoMain.myLists.size() > 0) {
            System.out.println();
            System.out.println("To-Do List");
            System.out.println("----------------------");
            int index = 0;
            for (String data : TodoMain.myLists) {
                System.out.println(String.format("[%d] %s", index, data));
                index++;
            }
        } else {
            System.out.println("no data");
        }
    }
}
