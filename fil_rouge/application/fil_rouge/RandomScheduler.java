package fil_rouge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomScheduler {


	protected Set<Activity> activities;
	protected List<Constraint> constraintes;
	protected Random randomGenerator;

	public RandomScheduler() {
		this.activities=new HashSet<>();
		this.constraintes=new ArrayList<>();
		this.randomGenerator=new Random();


	}

	public void add(Constraint con) {
		this.constraintes.add(con);
	}

	public void add(Activity act) {
		this.activities.add(act);
	}


	/*Cette methode a pour but de tirer aléatoirement des EDT avec des activités donneés
	*/
	public HashMap<Activity,MyCalendar> EmploiAleatoire() {
		HashMap <Activity,MyCalendar>edt= new HashMap<>();
		for(Activity act: this.activities) {

			int houre=(int)(Math.random()*(10))+8;
			int minutes=randomGenerator.nextInt(60);
			MyCalendar date = new MyCalendar(02,27,houre,minutes);
			edt.put(act, date);
			}
		return edt;
		}


	//ça retourne le nombre de contraintes satisfaites dans un EDT
	public int ConstraintesSatisfaites(HashMap<Activity,MyCalendar> EDT ){
	    int i=0;
		for(Constraint constrainte:constraintes) {
			if(constrainte.isSatisfiedBySchedule(EDT)) {
				i++;
			}
		}
		return i;
		}


	//ça retourne l'emploi qui satisfait plus de contraintes parmi ceux qui sont tirés aléatoirement 
	public HashMap<Activity,MyCalendar> EmploiAleatoireMax(int n) {

		ArrayList<HashMap<Activity,MyCalendar>> listEmploiAl = new ArrayList<>();
		HashMap<Activity,MyCalendar> scheduleSatisfied =new HashMap<>();
		for(int i=0;i<=n;i++) {
			listEmploiAl.add(EmploiAleatoire());
			}
		int max=this.ConstraintesSatisfaites(listEmploiAl.get(0));

		for(int i=0;i<=n;i++) {
			if(max<this.ConstraintesSatisfaites(listEmploiAl.get(i))) {
				max=this.ConstraintesSatisfaites(listEmploiAl.get(i));
				}
		scheduleSatisfied=listEmploiAl.get(i);}
		return scheduleSatisfied;
		}

}
