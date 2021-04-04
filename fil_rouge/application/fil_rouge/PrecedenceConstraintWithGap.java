package fil_rouge;

import java.util.Calendar;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint implements Constraint {


	protected int gap;

	public PrecedenceConstraintWithGap(Activity first, Activity second,int gap) {
		super(first, second);
		this.gap = gap;

	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

//isSatisfied est une méthode qui vérifie si une activité se termine avant le debut de la deuxième avec un gap entre les deux activités
	public boolean isSatisfied(MyCalendar date1, MyCalendar date2) {
		date1.add(Calendar.MINUTE, this.first.durée);
		date1.add(Calendar.MINUTE, this.getGap());
		return((date1.compareTo(date2))<0) ;

		}



	@Override
	public String toString() {
		return super.toString()+" with gap = "+this.gap+"\n";
	}



}
