package fil_rouge;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scheduleio.ActivityDescription;
import scheduleio.ActivityReader;
import scheduleio.ConstraintDescription;
import scheduleio.ConstraintReader;

public class Reader {

	protected Map<String,Activity > activities;
    protected String fichier1,fichier2;



	public Reader(String fichier1, String fichier2) throws java.io.FileNotFoundException, java.io.IOException {
		this.fichier1=fichier1;
		this.fichier2=fichier2;




		ActivityReader ActReader=new ActivityReader(fichier1);
		Map<String,ActivityDescription>activitiesReaden;
		activitiesReaden=ActReader.readAll();

		this.activities=new HashMap<String,Activity>();
		for (String key : activitiesReaden.keySet()) {
			Activity act = new Activity(activitiesReaden.get(key).getName(), activitiesReaden.get(key).getDuration());
			this.activities.put(key, act);
		}

		}

// ça retourne les activités qu'on a dans notre fichier activités.txt
	public Collection<Activity> getActivities()
	{
		return this.activities.values();
	}


	//ça retourne les contraintes qui sont de type precedenceconstraint dans notre fichier contraintes.txt
	public PrecedenceConstraint getPrecedenceConstraint(String []constraintArgs) {

			if(constraintArgs.length!=2) {
			throw new java.lang.IllegalArgumentException("nombre d'arguments pas respecté");
				}
			else {
				if(!activities.containsKey(constraintArgs[0]) || !activities.containsKey(constraintArgs[1])) {
					throw new java.lang.IllegalArgumentException("exception");
					}
				Activity activity1=activities.get(constraintArgs[0]);
				Activity activity2=activities.get(constraintArgs[1]);
			PrecedenceConstraint pr =new PrecedenceConstraint(activity1,activity2);

	        return pr;
	}

	}
	//ça retourne les contraintes qui sont de type precedenceconstraintWithGap dans notre fichier contraintes.txt
	public PrecedenceConstraintWithGap getPrecedenceConstraintWithGap(String []constraintArgs) {

		if(constraintArgs.length!=3) {
		throw new java.lang.IllegalArgumentException("nombre d'arguments pas respecté");
			}
		else {
			if(!activities.containsKey(constraintArgs[1]) || !activities.containsKey(constraintArgs[2])) {
				throw new java.lang.IllegalArgumentException("objets non trouvés");
				}
		return new PrecedenceConstraintWithGap(activities.get(constraintArgs[1]),activities.get(constraintArgs[2]),Integer.parseInt(constraintArgs[0]));
}

}

//ça retourne les contraintes qui sont de type MeetConstraint dans notre fichier contraintes.txt
	public MeetConstarint getMeetConstraint(String []constraintArgs) {

		if(constraintArgs.length!=2) {
		throw new IllegalArgumentException("nombre d'arguments pas respecté");
			}
		else {
			if(!activities.containsKey(constraintArgs[0]) || !activities.containsKey(constraintArgs[1])) {
				throw new java.lang.IllegalArgumentException("objets non trouvés");
				}
		return new MeetConstarint(activities.get(constraintArgs[0]),activities.get(constraintArgs[1]));
}

}


//ça retourne les contraintes qui sont de type MaxSpanconstraint dans notre fichier contraintes.txt
	public MaxSpanConstraint getMaxSpanConstraint(String []constraintArgs) {

		if(constraintArgs.length<4) {
		throw new IllegalArgumentException("nombre d'arguments pas respecté");
			}
		else {
			if(!activities.containsKey(constraintArgs[1]) || !activities.containsKey(constraintArgs[2])) {
				throw new NullPointerException("objets non trouvés");
				}
			ArrayList<Activity> al = new ArrayList<Activity>();
			for (int i = 1; i < activities.size(); i++) {
				Activity act = activities.get(constraintArgs[i]);
				al.add(act);
			}
		return new MaxSpanConstraint(Integer.parseInt((constraintArgs[0])),al);
}

}

	// elle récupère toutes les contraintes de notre fichier contraintes.txt
	public List<Constraint> readConstraintReader() throws java.io.FileNotFoundException, java.io.IOException {
		ConstraintReader dR= new ConstraintReader(this.fichier2);
		List<ConstraintDescription> descriContraints = dR.readAll();
		List<Constraint> contraints = new ArrayList<Constraint>();
		for (  ConstraintDescription descriContraint : descriContraints) {
			switch( descriContraint.getKeyword()) {
				case "PRECEDENCE":
					contraints.add(getPrecedenceConstraint(descriContraint.getArguments()));
					break;
				case "PRECEDENCE_GAP":
					contraints.add(getPrecedenceConstraintWithGap(descriContraint.getArguments()));
					break;
				case "MEET":
					contraints.add(getMeetConstraint(descriContraint.getArguments()));
					break;
				case "MAX_SPAN":
					contraints.add(getMaxSpanConstraint(descriContraint.getArguments()));
					break;
			}

		}
		return contraints;

	}



}
