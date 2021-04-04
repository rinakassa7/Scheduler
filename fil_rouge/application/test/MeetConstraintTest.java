package test;



import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fil_rouge.Activity;
import fil_rouge.MeetConstarint;
import fil_rouge.MyCalendar;


public class MeetConstraintTest {


	private Activity activity1;
	private Activity activity2;
	private Activity activity3;
	private Activity activity4;

	private MyCalendar date1;
	private MyCalendar date2;
	private MyCalendar date3;
	private MyCalendar date4;



	private MeetConstarint p1;
	private MeetConstarint p2;


	private HashMap<Activity,MyCalendar>EDT=new HashMap<>();


	@Before
	public void init() {
		 activity1= new Activity("cours BDD",90);
		 activity2= new Activity("cours Réseaux",120);
		 activity3= new Activity("cours Système",90);
		 activity4= new Activity("cours POO",120);


		date1= new MyCalendar(02,27,8,30);
		date2=new MyCalendar(02,27,10,00);
		date3= new MyCalendar(02,27,12,00);
		date4=new MyCalendar(02,27,13,30);



		EDT.put(activity1, date1);
		EDT.put(activity2, date2);
		EDT.put(activity3, date3);
		EDT.put(activity4, date4);




		p1= new MeetConstarint(activity1,activity2);
		p2=new MeetConstarint(activity3,activity4);


	}
	
	@After
	public void after() {
		System.out.println("Finished !");
	}


@Test
public void isSatisfiedPrecedenceTest() {
	Assert.assertTrue("ça doit retourner True ",p1.isSatisfied(date1, date2)==true);
		}
@Test
public void isSatisfiedPrecedence2Test() {
	Assert.assertTrue("ça doit retourner true",p2.isSatisfied(date3, date4)==true);
	}
@Test
public void isSatisfiedBySchedulePrecedenceTest() {
	Assert.assertTrue("ça doit retourner true",p2.isSatisfiedBySchedule(EDT)==true);
	}

}
