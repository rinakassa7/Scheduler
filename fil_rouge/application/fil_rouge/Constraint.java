package fil_rouge;
import java.util.HashMap;

public interface Constraint {



public boolean isSatisfiedBySchedule(HashMap <Activity, MyCalendar> edt);
}