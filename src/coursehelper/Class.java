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
public class Class implements Comparable{
    private int day;
    private int start;
    private int end;
    
    private String location;
    private Set<String> instructors;
    
    public Class(int day, int start, int end, String location, Set<String> instructors){
        this.day = day;
        this.start = start;
        this.end = end;
        this.location = location;
        this.instructors = instructors;
    }

    public int getDay() {
        return day;
    }
    
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getLocation() {
        return location;
    }

    public Set<String> getInstructors() {
        return instructors;
    }

    @Override
    public int compareTo(Object o) {
        try{
            Class c = (Class)o;
            return start-c.getStart();
        }catch(Exception e){
            System.out.println("ERROR Casting!");
            e.printStackTrace();
            return -1;
        }
    }
    
    @Override
    public boolean equals(Object o){
        try{
            Class c = (Class)o;
            return start==c.getStart()&&end==c.getEnd();
        } catch(Exception e){
            System.out.println("ERROR Casting!");
            e.printStackTrace();
            return false;
        }
    }
    
    public String timeToString(){
        StringBuilder out = new StringBuilder();
        out.append(start/60).append(":").append(start%60==0?"00":start%60).append("-").append(end/60).append(":").append(end%60==0?"00":end%60);
        return out.toString();
    }
    
    public String intructorsToString() {
        StringBuilder s = new StringBuilder();
        for(String x:instructors){
            s.append(x).append(" and ");
        }
        s.delete(s.length()-5, s.length());
        return s.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        String sday[] = new String[]{
            "Mon","Tues","Wed","Thur","Fri","Sat","Sun"
        };
        out.append(sday[day]).append(" ").append(timeToString());
        out.append("\n\t\tInstructors:\n\t\t");
        for(String s:instructors){
            out.append(s).append("\n\t\t");
        }
        out.append("location:").append(location);
        return out.toString();
    }
}
