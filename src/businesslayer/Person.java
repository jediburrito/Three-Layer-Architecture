package businesslayer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datalayer.UserDB;



public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private long socialSec;
	private long creditCard;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Person [firstName = " + firstName + ", lastName = " + lastName + ", age = " + age + ", socialSec = " + socialSec
				+ ", creditCard = " + creditCard + "]";
	}


	public Person(String firstName, String lastName, int age, long socialSec, long creditCard) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.socialSec = socialSec;
		this.creditCard = creditCard;
	}
	
	
//	public Person(String firstName2, String lastName2, String age2, String ssn, String creditCard2) {
//		// TODO Auto-generated constructor stub
//	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getSocialSec() {
		return socialSec;
	}
	public void setSocialSec(long socialSec) {
		this.socialSec = socialSec;
	}
	public long getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(long creditCard) {
		this.creditCard = creditCard;
	}
	

	

}
