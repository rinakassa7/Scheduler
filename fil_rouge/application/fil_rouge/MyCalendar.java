package fil_rouge;

import java.util.Calendar;
import java.util.GregorianCalendar;


/*la Classe MyCalendar est une classe qui hérite de GregorianCalendar
elle est pour but de créer notre propre calendrier on utilisant que l'année,mois,jour,heure,minutes et seconde
c'est moins compliqué qu'utiliser la classe GregorianCalendar

*/

@SuppressWarnings("serial")
public class MyCalendar extends GregorianCalendar{

		public MyCalendar(int month, int day,int houre,int minute) {
			super(2019,month,day,houre,minute,00);

	}


		public int getMonth() {
			return(this.get(Calendar.MONTH));
		}

		public int getDay() {
			return this.get(Calendar.DAY_OF_MONTH);
		}

		public int getHoure() {
			return this.get(Calendar.HOUR_OF_DAY);
		}

		public int getMinute() {
			return this.get(Calendar.MINUTE);
		}



		public String toString() {
			return "le 2019/"+this.getMonth()+"/"+ this.getDay()+" à "+this.getHoure()+"h:"+this.getMinute()+"min:00s\n";

	}







}
