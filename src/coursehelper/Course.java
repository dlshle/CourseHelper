/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursehelper;

import java.util.List;
import java.util.Set;

/**
 *
 * @author amnisia
 */
public class Course {
    
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private List<Section> sections;

    public Course(String courseCode, String courseName, String courseDescription, List<Section> sections) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.sections = sections;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public List<Section> getSections() {
        return sections;
    }
    
    public boolean addSection(Section section){
        return sections.add(section);
    }
    
    public boolean removeSection(Section section){
        return sections.remove(section);
    }
    
    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        out.append("Course(").append(courseCode).append("):").append(courseName).append("\n");
        out.append(courseDescription);
        out.append("\n");
        out.append("sections:{\n");
        for(Section s:sections){
            out.append("\t");
            out.append(s);
            out.append("\n");
        }
        out.append("}");
        return out.toString();
    }
    
}
