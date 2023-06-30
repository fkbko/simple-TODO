public class showLists {
    public static void showList() {
        System.out.println();
        System.out.println("To-Do List");
        System.out.println("----------------------");
        int number = 0;
        for (String item : TodoMain.myLists) {
            System.out.println(++number + " " + item);
        }
    }
}
