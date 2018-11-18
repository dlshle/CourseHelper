package coursehelper;

import java.util.List;
import java.util.Set;

/**
 *
 * @author amnisia
 */
public class Section {
    
    private String sectionCode;
    private Set<String> instructors;
    private String location;
    private List<Class> classes;//including discussion

    public Section(String sectionCode, String courseName, Set<String> instructors, String location, List<Class> classes) {
        this.sectionCode = sectionCode;
        this.instructors = instructors;
        this.location = location;
        this.classes = classes;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public Set<String> getInstructors() {
        return instructors;
    }

    public String getLocation() {
        return location;
    }

    public List<Class> getClasses() {
        return classes;
    }    
    
    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        out.append("Section:").append(sectionCode).append("\n");
        out.append("\tInstructors:\n\t");
        for(String s:instructors){
            out.append(s).append("\n\t");
        }
        out.append("location:").append(location);
        out.append("\n\tclasses:");
        for(Class c:classes){
            out.append("\n\t\t").append(c).append("\n\t\t--------------------------");
        }
        return out.toString();
    }
}
