/**
 * Created by Arcos on 2/14/2015.
 */
public class Main {
    public static void main(String [ ] args)
    {
        Register register = new Register();
        register.addCSVDocument("courseList.txt");
        register.addCSVDocument("studentList.txt");
        register.viewRecords();
    }
}
