package coursehelper;

import java.util.ArrayList;

/**
 *
 * @author amnisia
 */
public class DayTimePeriod {
    public static int CLASS_INTERVAL = 10;
    public final static int DAY_START = 0;
    public final static int DAY_END = 1440; 
    private ArrayList<Class> classes;
    
    public DayTimePeriod(){
        classes = new ArrayList<>();
    }
    
    public boolean addClass(Class c){
        //if exist overlapping
        if(classes.size()==0){
            classes.add(c);
            return true;
        }
        for(int i=0;i<classes.size();i++){
            Class ci = classes.get(i);
            if(ci.equals(c))
                //same starting time
                return false;
            //if end(i-1)+CLASS_INTERVAL<=start(i)&&end(i)+CLASS_INTERVAL<=start(i+1) then add
            if(ci.getEnd()+CLASS_INTERVAL>c.getStart()||(i+1<classes.size()&&classes.get(i+1).getStart()-CLASS_INTERVAL<c.getEnd()))
                continue;
            classes.add(c);
            return true;
        }
        return false;
    }
    
    public boolean removeClass(Class c){
        return classes.remove(c);
    }
    
    public ArrayList<Class> getClasses(){
        return classes;
    }
    
}
