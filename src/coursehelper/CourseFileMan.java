package coursehelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Course file description:
 * course
 * course0 code
 * course0 name
 * course0 description
 * sections
 * section 0 code
 * section 0 instructors(seperated by ;)
 * section 0 location
 * classes
 * class 0 instructors(seperated by ;)
 * class 0 location
 * class 0 day
 * class 0 time_periods(start, end)
 * end classes
 * section 1 ...
 * end sections
 * course1...
 * @author amnisia
 */
public class CourseFileMan {
    
    private File file;
    private Scanner input;
    
    public CourseFileMan(String path){
        file = new File(path);
        input = new Scanner(System.in);
        while(!file.exists()) {
            System.out.println(file.getAbsolutePath()+" is invalid.");
            System.out.println("Input a valid file path:");
            file = new File(input.nextLine());
        }
    }
    
    public List<Course> loadCourses(){
        List<Course> courses = new ArrayList<>();
        try {
            input = new Scanner(file);
            String line = input.nextLine();
            while(!line.equals("end courses")){
                //load course
                //code
                //name
                //description
                String code, name, desc;
                code = line;
                name = input.nextLine();
                desc = input.nextLine();
                //sections
                line = input.nextLine();
                if(!line.equals("sections"))
                    return null;
                //section part
                //code instructors location classes
                String scode, slocation, tinstructors[];
                line = input.nextLine();
                ArrayList<Section> sections = new ArrayList<>();
                while(!line.equals("end sections")){
                    HashSet<String> sinstructors = new HashSet<>();
                    scode = line;
                    tinstructors = input.nextLine().split(";");
                    for(String s:tinstructors)
                        sinstructors.add(s);
                    slocation = input.nextLine();
                    //classes
                    line = input.nextLine();
                    if(!line.equals("classes"))
                        return null;
                    line = input.nextLine();                    
                    String ccode, clocation, cday, ctp[];                              
                    ArrayList<Class> classes = new ArrayList<>();
                    while(!line.equals("end classes")) {
                        //class 0 instructors(seperated by ;) class 0 location class 0 time_periods(start, end)
                        //Class(int start, int end, String location, Set<String> instructors)                        
                        HashSet<String> cinstructors = new HashSet<>();  
                        tinstructors = line.split(";");
                        for(String s:tinstructors)
                            cinstructors.add(s);
                        clocation = input.nextLine();
                        cday = input.nextLine();
                        ctp = input.nextLine().split(",");
                        classes.add(new Class(Integer.valueOf(cday),Integer.valueOf(ctp[0]),Integer.valueOf(ctp[1]), clocation, cinstructors));
                        line = input.nextLine();
                    }
                    //Section(String sectionCode, String courseName, Set<String> instructors, String location, List<Class> classes)
                    sections.add(new Section(scode, name, sinstructors, slocation, classes));
                    line = input.nextLine();
                }                        
                //Course(String courseCode, String courseName, String courseDescription, Set<Section> sections)
                courses.add(new Course(code, name, desc, sections));
                line = input.nextLine();
            }
            return courses;
        } catch (FileNotFoundException fne) {
            Logger.getLogger(CourseFileMan.class.getName()).log(Level.SEVERE, null, fne);
        } catch (NumberFormatException nfe) {
            System.out.println("File format error!");
            nfe.printStackTrace();
        } catch (Exception ex) {
            System.out.println("File corrupted!");
            ex.printStackTrace();
        }
        return null;
    }
    
}
