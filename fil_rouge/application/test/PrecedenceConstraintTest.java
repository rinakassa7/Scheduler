package test;


import java.util.HashMap;

import org.junit.Test;

import fil_rouge.Activity;
import fil_rouge.MyCalendar;
import fil_rouge.PrecedenceConstraint;

import org.junit.After;
	import org.junit.Assert;
	import org.junit.Before;


	public class PrecedenceConstraintTest {
		private Activity activity1;
		private Activity activity2;
		private Activity activity3;
		private Activity activity4;
		private Activity activity5;
		private Activity activity6;

		private MyCalendar date1;
		private MyCalendar date2;
		private MyCalendar date3;
		private MyCalendar date4;
		private MyCalendar date5;
		private MyCalendar date6;


		private PrecedenceConstraint p1;
		private PrecedenceConstraint p2;
		private PrecedenceConstraint p3;

		private HashMap<Activity,MyCalendar>EDT=new HashMap<>();


		@Before
		public void init() {
			 activity1= new Activity("cours BDD",90);
			 activity2= new Activity("cours Réseaux",120);
			 activity3= new Activity("cours Système",90);
			 activity4= new Activity("cours POO",120);
			 activity5=new Activity("cours Calcul Scientifique",90);
			 activity6=new Activity("cours LCS",90);


			date1= new MyCalendar(02,27,8,30);
			date2=new MyCalendar(02,27,10,01);
			date3= new MyCalendar(02,27,11,30);
			date4=new MyCalendar(02,27,13,01);
			date5=new MyCalendar(02,27,14,00);
			date6 = new MyCalendar(02,27,16,15);


			EDT.put(activity1, date1);
			EDT.put(activity2, date2);
			EDT.put(activity3, date3);
			EDT.put(activity4, date4);
			EDT.put(activity5, date5);
			EDT.put(activity6, date6);



			p1= new PrecedenceConstraint(activity1,activity2);
			p2=new PrecedenceConstraint(activity3,activity4);
			p3= new PrecedenceConstraint(activity5,activity6);

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
		Assert.assertTrue("ça doit retourner true",p3.isSatisfiedBySchedule(EDT)==true);
		}



}
