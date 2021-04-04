package test;



import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fil_rouge.Activity;
import fil_rouge.MaxSpanConstraint;
import fil_rouge.MyCalendar;


public class MaxSpanTest {

	private Activity activity1;
	private Activity activity2;
	private Activity activity3;

	private MyCalendar date1;
	private MyCalendar date2;
	private MyCalendar date3;


	private MaxSpanConstraint p1;
	private MaxSpanConstraint p2;


	ArrayList<Activity> activities = new ArrayList<>();

	private HashMap<Activity,MyCalendar>EDT=new HashMap<>();


	@Before
	public void init() {
		 activity1= new Activity("cours BDD",90);
		 activity2= new Activity("cours Réseaux",120);
		 activity3= new Activity("cours Système",90);

		date1= new MyCalendar(02,27,8,30);
		date2=new MyCalendar(02,27,10,00);
		date3= new MyCalendar(02,27,12,00);


		EDT.put(activity1, date1);
		EDT.put(activity2, date2);
		EDT.put(activity3, date3);

		activities.add(activity1);
		activities.add(activity2);
		activities.add(activity3);

		p1= new MaxSpanConstraint(301,activities);
		p2=new MaxSpanConstraint(300,activities);


	}

	@After
	public void after() {
		System.out.println("Finished !");
	}


@Test
public void isSatisfiedPrecedenceTest() {
	Assert.assertTrue("ça doit retourner True ",p1.isSatisfiedBySchedule(EDT)==true);
		}
@Test
public void isSatisfiedPrecedence2Test() {
	Assert.assertFalse("ça doit retourner true",p2.isSatisfiedBySchedule(EDT)==true);
	}


}
