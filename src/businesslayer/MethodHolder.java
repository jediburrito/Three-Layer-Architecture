package businesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import datalayer.UserDB;

public class MethodHolder {
public static ArrayList<Person> findAllPeople() throws Exception{
	
		
		
		try{
			UserDB link = new UserDB();
		Connection con = link.getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM peopleList");
		PreparedStatement idNotice = con.prepareStatement("SELECT id FROM peopleList WHERE id =(SELECT max(id) FROM peopleList)");
		
		ResultSet idResult = idNotice.executeQuery();
		idResult.next();
		int i = idResult.getInt("id");
		Person[] allPeople;
		allPeople = new Person[i];
		ResultSet result = statement.executeQuery();
		int count = 0;
		int listSize = result.getFetchSize();
		ArrayList<Person> personList= new ArrayList();
		
		while(result.next()){
		Person person = new Person(result.getString("first"), result.getString("last"), result.getInt("age"), result.getLong("socialSec"), result.getLong("creditCard"));
			personList.add(person);	
			
		
		
		System.out.println(personList.get(count));
		count++;
		
		
		
		}
		
		
		return personList;
		
	}catch(Exception e){
		e.printStackTrace();
		System.out.println(e);
	}
		return null;
	}
	
public static void deleteRow(String name, String lastName) throws Exception{
	try{
		UserDB link = new UserDB();
	Connection con = link.getConnection();
	PreparedStatement select = con.prepareStatement("Delete FROM peopleList Where first = '"+name+"' && last = '"+lastName+"'");
	if(select.executeUpdate() ==0){
		System.out.println("Deletion fail: no person found!");
		return;
		
	}
	
	
	
	}catch(Exception e){
		e.printStackTrace();
		System.out.println(e);
	}
	System.out.println("Deletion completed");
}


public static Person findAPerson(String firstName, String lastName)throws Exception{
	
	
	
	try {
		UserDB link = new UserDB();
		Connection con = link.getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM peopleList WHERE first = '"+firstName+"' AND last = '"+lastName+"'");
		
		ResultSet result = statement.executeQuery();
		
		if(result.next()){
		Person foundPerson = new Person(result.getString("first"), result.getString("last"), result.getInt("age"), result.getLong("socialSec"), result.getLong("creditCard"));
		System.out.println(foundPerson.toString());
		return foundPerson;
		}
		else{
			System.out.println("Search failed: no valid person found!");
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
		
	}
	return null;
	
}

public static void insertPerson (Person person)throws Exception{
	String var1 = person.getFirstName();
	String var2 = person.getLastName();
	int var3 = person.getAge();
	long var4 = person.getSocialSec();
	long var5 = person.getCreditCard();
	
	try{
		UserDB con = new UserDB();
		Connection connect = con.getConnection();
		PreparedStatement posted = connect.prepareStatement("INSERT INTO peopleList (first, last, age, socialSec, creditCard) VALUES('"+var1+"', '"+var2+"', '"+var3+"','"+var4+"','"+var5+"')");
		posted.executeUpdate();
		
		
	}
	catch(Exception e){
		System.out.println(e);
	}
	finally {
		System.out.println("Insert Completed.");
	}
}


}
