import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Arcos on 2/14/2015.
 */
public class Register {
   private Vector<Course> courseRegistry = new Vector<Course>();
   private Vector<Student> studentRegistry = new Vector<Student>();

   private void parseFile(String filePath) throws FileNotFoundException {
       CSVReader reader = new CSVReader(new FileReader(filePath));
       String [] nextLine;
       try {
           // get header
           int type = -1;
           nextLine = reader.readNext();
           if (nextLine[0] == "course_id")
           {
               type = 0;
           }
           else if (nextLine[0] == "user_id")
           {
               type = 1;
           }
           while ((nextLine = reader.readNext()) != null) {
               // nextLine[] is an array of values from the line
                if (type == 0) // parse course
                {
                    Boolean isFound = false;
                    for (Course course : courseRegistry) {
                       if (course.getCourse_ID() == Integer.parseInt(nextLine[0]))
                       {
                           course.update(nextLine[1],Boolean.parseBoolean(nextLine[2]));
                           isFound = true;
                           break;
                       }
                    }
                    if (!isFound)
                    {
                        courseRegistry.add(new Course(Integer.parseInt(nextLine[0]),nextLine[1],
                                Boolean.parseBoolean(nextLine[2])));
                    }
                }
               else if (type == 1) // parse student
               {
                   Boolean isFound = false;
                   for (Student student : studentRegistry) {
                       if (student.getCourse_ID() == Integer.parseInt(nextLine[0]))
                       {
                           student.update(nextLine[1], Integer.parseInt(nextLine[2]),Boolean.parseBoolean(nextLine[3]));
                           isFound = true;
                           break;
                       }
                   }
                   if (!isFound)
                   {
                       studentRegistry.add(new Student(Integer.parseInt(nextLine[0]),nextLine[1],
                               Integer.parseInt(nextLine[2]),Boolean.parseBoolean(nextLine[3])));
                   }
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public void addCSVDocument(String filePath)
   {
       try {
           parseFile(filePath);
       }
       catch (FileNotFoundException e)
       {
           System.out.println("File was not found:" + filePath);
       }
   }

    public void viewRecords()
    {
        System.out.println(courseRegistry);
        System.out.println(studentRegistry);
    }
}
