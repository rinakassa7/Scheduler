package fil_rouge;

import java.util.Calendar;

public class MeetConstarint extends BinaryConstraint implements Constraint {

	//constructeur de meetConstarint qui hérite la classe BinaryConstraint et implémente l'interface Constraint
	public MeetConstarint(Activity first, Activity second) {
		super(first,second);
		}

	//isSatisfied ici est pour but de vérifier si la fin de la première activité est égale au début de la deuxième
	public boolean isSatisfied(MyCalendar date1, MyCalendar date2) {
		date1.add(Calendar.MINUTE, this.first.durée);
	return ((date1.equals(date2)));
			}


	@Override
	public String toString() {
		return "MeetConstarint\n [first=" + first + ", second=" + second + "]\n";
	}

}
