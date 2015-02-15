/**
 * Created by Arcos on 2/14/2015.
 */
public class Student {
    Student(int userID, String userName, int courseID, Boolean state)
    {
        user_ID = userID;
        user_name = userName;
        course_ID = courseID;
        _state = state;
    }
    private int user_ID;
    private String user_name;
    private int course_ID;
    private Boolean _state;

    public void update(String userName, int courseID, Boolean state)
    {
        user_name = userName;
        course_ID = courseID;
        _state = state;
    }
    public int getUser_ID(){return user_ID;}
    public String getUser_name(){return user_name;}
    public int getCourse_ID(){return course_ID;}
    public Boolean get_state(){return _state;}
}
