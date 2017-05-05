package businesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import datalayer.UserDB;
import userinterface.UserControl;
import userinterface.guiInterface;



public class Main {

	public static void main(String[] args) {
		
		UserControl newGuy = new UserControl();
		UserDB con = new UserDB();
		
		
		try {
			newGuy.main();
			
			
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1);
		}
		
		
		
		
		
		
		try {
			con.getConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			con.createTable();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
			
		
		
		

	}
	
	

			
		

}
