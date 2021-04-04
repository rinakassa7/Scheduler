package fil_rouge;
import java.util.Calendar;


public class PrecedenceConstraint extends BinaryConstraint implements Constraint{


	public PrecedenceConstraint (Activity first, Activity second) {
		super(first,second);

	}






	//isSatisfied est une méthode qui vérifie si une activité se termine avant le debut de la deuxième
	public boolean isSatisfied(MyCalendar date1, MyCalendar date2) {
		date1.add(Calendar.MINUTE, this.first.durée);
	return ((date1.compareTo(date2))<0);
			}







	@Override
	public String toString() {
		return "PrecedenceConstraint: \n [first=" + first + ", second=" + second + "]\n";
	}








}
