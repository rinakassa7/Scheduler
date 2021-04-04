package fil_rouge;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class MaxSpanConstraint implements Constraint{


	protected int span;
	protected ArrayList<Activity> activities;




	public int getSpan() {
		return span;
	}




	public void setSpan(int span) {
		this.span = span;
	}




	public ArrayList<Activity> getActivities() {
		return activities;
	}




	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}




	public MaxSpanConstraint(int span, ArrayList<Activity> activities) {
		this.span = span;
		this.activities = activities;
	}







	//dans la classe MaxSpanConstraint on vérifie si l'ensemble des activités formant un EDT donné se termine dans une durée donnée (span)

	@Override
	public boolean isSatisfiedBySchedule(HashMap<Activity, MyCalendar> EDT) {
		Activity firstActivity=this.activities.get(0);
		Activity lastActivity = this.activities.get(0);

		for(Activity activity:this.activities) {
			if(EDT.containsKey(activity) && EDT.containsKey(firstActivity)) {
				if((EDT.get(activity)).before(EDT.get(firstActivity))) {
					firstActivity=activity;}
}}

		for(Activity activity:this.activities) {
			if(EDT.containsKey(activity) && EDT.containsKey(lastActivity)) {
				if((EDT.get(activity)).after(EDT.get(lastActivity)))
					lastActivity=activity;

			}}


	      MyCalendar firstDate=EDT.get(firstActivity);
	      firstDate.add(Calendar.MINUTE, this.span);
	      MyCalendar lastDate=EDT.get(lastActivity);
	      lastDate.add(Calendar.MINUTE, lastActivity.durée);


		return lastDate.before(firstDate);
	}




	@Override
	public String toString() {
		return "MaxSpanConstraint: \n [span=" + span + ",\n activities=" + activities + "]\n";
	}
	}
