package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDB {
	public  void createTable()throws Exception{
		
		
		
		try{
			Connection con = getConnection();				
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS peopleList(id int NOT NULL AUTO_INCREMENT, first varchar(255) , last varchar(255), age SMALLINT, socialSec int, creditCard INT, PRIMARY KEY(id))");
			//will create a table if it does not already exist. This removes the need to comment out the code after the table is already made
			if(create.executeUpdate() != 0){
			
			PreparedStatement modify = con.prepareStatement("ALTER TABLE peopleList ADD UNIQUE INDEX IDX_peopleList_first_last(first,last)");
			
			modify.executeUpdate();
			}
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println(e);
			
		}
				
		
	}
	
	
	public   Connection getConnection() throws Exception{
	try{
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/datalayer?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "Canyonman1!";
		Class.forName(driver);
		
		Connection conn =  DriverManager.getConnection(url, username, password);
		//System.out.println("Connected"); //Anytime a connection is established system will print Connected
		return conn;
	}
	catch (Exception e){
		e.printStackTrace();
		System.out.println(e);
	}
return null;

	
	}
	

}
