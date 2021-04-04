package fil_rouge;

import java.util.HashMap;

public abstract class BinaryConstraint implements Constraint {


		protected Activity first ;
		protected Activity second;


		//constructeur de binaryConstraint
		public BinaryConstraint(Activity first, Activity second) {
			this.first = first;
			this.second = second;
		}

		//Méthode toString
		public String toString() {
			return "BinaryConstraint :\n" + first + " et " + second +"\n";
		}


	//methode abstraite isSatisfied qu'on déclare ici et on complète le body de la méthode dans les classes qui l'héritent
	//isSatisfied est une méthode qui vérifie si une activité se termine avant le debut de la deuxième
	public abstract boolean isSatisfied(MyCalendar date1,MyCalendar date2);



	/*isSatisfiedBySchedule est une méthode concrète pas abstraite donc on l'écrit directement dans binaryConstraint
	il suffit de l'appler avec les instances des classes qui l'héritent
	c'est une méthode qui vérifie si une activité se termine avant que la deuxieme commence dans un emploi du temps donné
	*/
	public boolean isSatisfiedBySchedule(HashMap<Activity, MyCalendar> edt  ) {
		boolean b=true;
			if(edt.containsKey(first) & edt.containsKey(second)) {
				b=isSatisfied(edt.get(first), edt.get(second));
			}
		return b;

	}


}
