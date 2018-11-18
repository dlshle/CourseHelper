/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursehelper;

/**
 *
 * @author amnisia
 */
public class WeeklySchedule {
    
    private DayTimePeriod[] days;
    
    public WeeklySchedule(){
        days = new DayTimePeriod[7];
        for(int i=0;i<7;i++){
            days[i] = new DayTimePeriod();
        }
    }
    
    public boolean addClass(Class c){
        return days[c.getDay()].addClass(c);
    }
    
    public boolean removeClass(Class c){
        return days[c.getDay()].removeClass(c);
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        String sday[] = new String[]{
            "Mon","Tues","Wed","Thur","Fri","Sat","Sun"
        };
        for(int i=0;i<7;i++){
            s.append(sday[i]).append(":");
            s.append("\n");
            for(Class c:days[i].getClasses()){                
                s.append("\t").append(c.timeToString()).append("@").append(c.getLocation()).append(" by ").append(c.intructorsToString()).append("\n");
            }
        }
        return s.toString();
    }
    
}
