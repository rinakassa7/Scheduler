package fil_rouge;

import java.util.ArrayList;
import java.util.HashMap;

public class Verifier {

	protected ArrayList<Constraint> constraintes;

	public Verifier() {
		this.constraintes=new ArrayList<>();
	}

	public void add(Constraint con) {
		this.constraintes.add(con);

	}

	// la méthode vérifie si toutes les contraintes sont réspectées dans un EDT donné
	public boolean verify(HashMap<Activity,MyCalendar>EDT) {

		for(Constraint constrainte:this.constraintes) {
			if(!(constrainte.isSatisfiedBySchedule(EDT))) {
				return false;
			}

		}
		return true;


	}


}
