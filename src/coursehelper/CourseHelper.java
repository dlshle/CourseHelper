package coursehelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amnisia
 */
public class CourseHelper {

    private List<Course> courses;
    
    public CourseHelper(List<Course> courses){
        this.courses = courses;
    }
    
    public WeeklySchedule findBestCombo(){
        WeeklySchedule w = new WeeklySchedule();
        if(!searchCombo(w, 0))
            return null;
        return w;
    }
    
    /**
     * searchCombo
     * Try every valid section combo by DFS
     * @param w
     * @param courseIndex
     * @return 
     */
    public boolean searchCombo(WeeklySchedule w, int courseIndex){
        if(courseIndex==courses.size())
            return true;
        boolean success = true;
        for(Section s:courses.get(courseIndex).getSections()){
            ArrayList<Class> classes = (ArrayList<Class>) s.getClasses();
            for(int i=0;i<classes.size();i++) {
                Class c = classes.get(i);
                if(!w.addClass(c)){
                    //if not success, remove all added classes and try next section
                    for(int j=0;j<i;j++){
                        w.removeClass(classes.get(j));
                    }
                    success = false;
                    break;
                }
            }
            if(success){
                //if the section is valid, try next
                if(searchCombo(w,courseIndex+1))
                    return true;
                //if not solvable for the current state, remove all classes from this section and try next section
                for(Class c:classes)
                    w.removeClass(c);
                success = true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        CourseFileMan man = new CourseFileMan("courses");
        ArrayList<Course> courses = (ArrayList<Course>) man.loadCourses();
        CourseHelper helper = new CourseHelper(courses);
        for(Course c:courses){
            System.out.println(c);
        }
        WeeklySchedule w = helper.findBestCombo();
        System.out.println(w);
    }
    
    
    
}
