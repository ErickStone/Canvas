/**
 * Created by Arcos on 2/14/2015.
 */
public class Course {
    Course(int courseID, String courseName, Boolean state)
    {
        course_ID = courseID;
        course_Name = courseName;
        _state = state;
    }
    private int course_ID;
    private String course_Name;
    private Boolean _state;

    public String getCourse_Name(){return course_Name;}
    public int getCourse_ID(){return course_ID;}
    public Boolean get_state(){return _state;}
    public void update(String courseName, Boolean state)
    {
        course_Name = courseName;
        _state = state;
    }
}
