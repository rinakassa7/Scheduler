package fil_rouge;

import java.util.HashMap;


public class MainReader {

	public static void main(String[] args)  {


// ce code mis en commentaire c'est le code qui teste les contraintes, à la place d'exécuter celui la, on a préféré de faire les tests unitaires


		/*//instanciation des activities
		Activity activity1 = new Activity("cours BDD", 90);
		Activity activity2 = new Activity ("cours systeme", 75);
		Activity activity3 = new Activity ("cours réseau", 75);
		Activity activity4 = new Activity ("cours poo",90);*/






		//instancier les contraintes
		//PrecedenceConstraint p1= new PrecedenceConstraint(activity1,activity2);
		//PrecedenceConstraint p2= new PrecedenceConstraint(activity2,activity3);
		//MeetConstarint m1 = new MeetConstarint(activity1,activity2);



		/*

		//System.out.println(p1.isSatisfied(5, 8));

		//instanciation des dates de type GregorianCalendar qu'on a hérité avec la classe MyCalendar
		MyCalendar date1 = new MyCalendar(02,27,11,30);
		MyCalendar date2 = new MyCalendar(02,27,13,15);
		MyCalendar date3 = new MyCalendar(02,27,14,45);
		MyCalendar date4 = new MyCalendar(02,27,14,40);


		/*appel a la méthode isSatisfied() pour voir si les horaires des activities sont respectés

		System.out.println("test sur les deux activités"+ p1.toString());
		if((p1.isSatisfied(date1,date2))) {
			System.out.println("La contrainte est satisfaite");

		}
		else{
			System.out.println("La contrainte est non satisfaite");
		};



		System.out.println("test sur les deux activités"+ p2.toString());
				if((p1.isSatisfied(date2,date3))) {
					System.out.println("La contrainte est satisfaite");

				}
				else{
					System.out.println("La contrainte est non satisfaite");
				};




		/*/

		//instances avec gap*/

	/*	PrecedenceConstraintWithGap p1gap= new PrecedenceConstraintWithGap(activity1,activity2,14);
		System.out.println("test avec gap sur les deux activités : "+p1gap.toString());
		if((p1gap.isSatisfied(date1, date2))) {
			System.out.println("la contrainte avec un gap est satisfaite");
		}else {
			System.out.println("la contrainte avec un gap est non satisfaite");
		}


		PrecedenceConstraintWithGap p2gap= new PrecedenceConstraintWithGap(activity2,activity3,13);
		System.out.println("test avec gap sur les deux activités: "+p2gap.toString());
		if((p2gap.isSatisfied(date2, date3))) {
			System.out.println("la contrainte avec un gap est satisfaite");
		}else {
			System.out.println("la contrainte avec un gap est non satisfaite");
		}




		HashMap <Activity, MyCalendar>emploiDuTemps = new HashMap<>();
		emploiDuTemps.put(activity1, date1);
		emploiDuTemps.put(activity2, date2);
		emploiDuTemps.put(activity3, date3);
		emploiDuTemps.put(activity4, date4);

		/*System.out.println("MON EMPLOI DU TEMPS");
		for(Map.Entry map :emploiDuTemps.entrySet()) {
			System.out.println(map.getKey()+" "+ map.getValue());
		}

		System.out.println("l'emploi du temps qu'on a programmé satisfait-il les contraintes données?");
		if(p1.isSatisfiedBySchedule(emploiDuTemps)){
			System.out.println("oui, la contrainte est satisfaite entre les deux activités :)");
		}else
			System.out.println("non, la contrainte n'est pas satisfaite, veuillez reprogrammer les horaires.");

		if(m1.isSatisfied(date1, date2)) {
			System.out.println("oui, la contraint est satisfaite ");
		}
		else
			System.out.println("non, la contraint n'est pas satisfaite");*/





			/*ArrayList<Activity> activities = new ArrayList<>();
			activities.add(activity1);
			activities.add(activity2);
			activities.add(activity3);





			//instance du span, notre heure que la durÃ©e des activitÃ©es ne peuvent pas dÃ©passer.
			MaxSpanConstraint span1 = new MaxSpanConstraint (270,activities);

			System.out.println(span1.isSatisfiedBySchedule(emploiDuTemps));


			Verifier verifieur = new Verifier();
			verifieur.add(p1gap);
			verifieur.add(p2gap);



			System.out.println("L'emploi du temps satisfait-il toutes les contraintes ? ");
			if (verifieur.verify(emploiDuTemps)) {
			    System.out.println("Oui");
			} else {
			    System.out.println("Non");
			}*/


			/*RandomScheduler schedule=new RandomScheduler();

			schedule.add(activity1);
			schedule.add(p1gap);
			schedule.add(activity2);
			schedule.add(activity3);
			schedule.add(activity4);
			schedule.add(p2gap);

			HashMap<Activity,MyCalendar>scheduleAl=schedule.EmploiAleatoire();
			System.out.println(scheduleAl);
			int nombre=schedule.ConstraintesSatisfaites(emploiDuTemps);
			System.out.println(nombre);
			HashMap<Activity,MyCalendar>scheduleAlMax=schedule.EmploiAleatoireMax(3);
			System.out.println(scheduleAlMax);*/



			Reader reader;
			try {
				reader = new Reader("fil_rouge/activity.txt","fil_rouge/contraintes.txt");

				System.out.println("_____________________________________Récupérer les activités____________________");
				System.out.println(reader.getActivities());


				System.out.println("_____________________________________Récupérer les contraintes____________________");
				System.out.println(reader.readConstraintReader());


				System.out.println("______________________getPrecedenceConstraint___________________");
				String[] tab = {"POO","BDD"};
				System.out.println(reader.getPrecedenceConstraint(tab));


				System.out.println("______________________getPrecedenceConstraintWithGap___________________");
				String[] tab1 = {"14","POO","BDD"};
				System.out.println(reader.getPrecedenceConstraintWithGap(tab1));


				System.out.println("______________________getMeetConstraint___________________");
				String[] tab2 = {"POO","Réseau"};
				System.out.println(reader.getMeetConstraint(tab2));


				System.out.println("______________________getMaxSpanConstraint___________________");
				String[] tab3 = {"491","POO","BDD", "Système", "Anglais","Réseau","Math"};
				System.out.println(reader.getMaxSpanConstraint(tab3));


				RandomScheduler schedule= new RandomScheduler();

				for (Activity activity: reader.getActivities()) {
					schedule.add(activity);
				}

				for (Constraint contrainte: reader.readConstraintReader()) {
					schedule.add(contrainte);
				}


				System.out.println("________Tirer aléatoirement 3 EDT et retourner celui qui satisfait plus de contraintes_________");
				HashMap<Activity,MyCalendar>scheduleAleatoireMaxContraintes=schedule.EmploiAleatoireMax(3);
				System.out.println(scheduleAleatoireMaxContraintes);
				int nombreConSatisfaites=schedule.ConstraintesSatisfaites(scheduleAleatoireMaxContraintes);
				System.out.println("_____________________________________________");
				System.out.println("Le nombre de contraintes satisfaites est : "+nombreConSatisfaites);



			}
			catch (java.io.FileNotFoundException e)
			{
				System.err.println("une exception: fichier non trouvé !");
			}
			catch (java.io.IOException e)
			{
				System.err.println("une exception: input, output exception !");
			}
			catch (java.lang.IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		}


}
