package gameClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MyDB  {
	public static final String jdbcUrl="jdbc:mysql://db-mysql-ams3-67328-do-user-4468260-0.db.ondigitalocean.com:25060/oop?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
	public static final String jdbcUser="student";
	public static final String jdbcUserPassword="OOP2020student";
	public static final int id_meir = 205464712;
	public static final int id_Ginton = 203965884;
	//return the num of games that played	
	public static  int getNumOfGames() 
	{
			int counter = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(SimpleDB.jdbcUrl, SimpleDB.jdbcUser,
						SimpleDB.jdbcUserPassword);
				Statement statement = connection.createStatement();
				String allCustomersQuery = "SELECT * FROM Logs;";
				ResultSet resultSet = statement.executeQuery(allCustomersQuery);
				while (resultSet.next()) {
					if (resultSet.getInt("UserID") == id_meir || resultSet.getInt("UserID") == id_Ginton) {
						counter++;
					} //end if
				} // end while
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("Vendor Error: " + sqle.getErrorCode());
			
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return counter;
			}

//	public int GetBestScore ()   {
//		int bestScore=0;	
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = DriverManager.getConnection(SimpleDB.jdbcUrl, SimpleDB.jdbcUser,
//					SimpleDB.jdbcUserPassword);
//			Statement statement = connection.createStatement();
//			String allCustomersQuery = "SELECT * FROM Logs;";
//			ResultSet resultSet = statement.executeQuery(allCustomersQuery);
////		int [] levels = new int [11]; //{0,1,3,5,9,11,13,16,19,20,23}
////		while (resultSet.next()) {
////			
////		int score =resultSet.getInt("score") ; 
////			if (resultSet.getInt("UserID") == id_meir || resultSet.getInt("UserID") == id_Ginton) {
////				int scanrio = resultSet.getInt("levelID") ;
////				if (scanrio == 0&&resultSet.getInt("moves") <= 290
////						&& score >= 145){
////				
////				
////					if (levels[0] < score)
////					levels[0] = score;
////			
////	}
//		while (resultSet.next()) {
//			int score =resultSet.getInt("score") ; 
//			if (resultSet.getInt("UserID") == id_meir || resultSet.getInt("UserID") == id_Ginton) 
//				if (score>bestScore) {
//					bestScore = score;
//				
//			}
//		}
//		resultSet.close();
//		statement.close();
//		connection.close();
//	} catch (SQLException sqle) {
//		System.out.println("SQLException: " + sqle.getMessage());
//		System.out.println("Vendor Error: " + sqle.getErrorCode());
//	
//	} 
//	catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	}
//				return bestScore;
//}
	//DB try to change to MyDB
		public int RankClass (int level)   {
			int myScore = GetLevelScore(level);
			int rank=1;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(SimpleDB.jdbcUrl, SimpleDB.jdbcUser,
						SimpleDB.jdbcUserPassword);
				Statement statement = connection.createStatement();
				String allCustomersQuery = "SELECT * FROM Logs;";
				ResultSet resultSet = statement.executeQuery(allCustomersQuery);
			
				while (resultSet.next()) {

			
			if (resultSet.getInt("UserID") != 205464712 && resultSet.getInt("UserID") != 205464712) {
				if (resultSet.getInt("levelID") == level)
					if (resultSet.getInt("score")>myScore)
						rank++;
			}
			}
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("Vendor Error: " + sqle.getErrorCode());
			
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
				return rank;
		}
		public int GetLevelScore (int level)   {
//			int [] levels = new int [11]; //{0,1,3,5,9,11,13,16,19,20,23}
			int max=0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(SimpleDB.jdbcUrl, SimpleDB.jdbcUser,
						SimpleDB.jdbcUserPassword);
				Statement statement = connection.createStatement();
				String allCustomersQuery = "SELECT * FROM Logs;";
				ResultSet resultSet = statement.executeQuery(allCustomersQuery);
			
			
			
			
			while (resultSet.next()) {
				//System.out.println("id user:"+resultSet.getInt("UserID")+" "+"level="+resultSet.getInt("levelID")+" score:"+resultSet.getInt("score"));
//			int score =resultSet.getInt("score") ; 
				if (resultSet.getInt("UserID") == 205464712 || resultSet.getInt("UserID") == 205464712) {
//					int scanrio = resultSet.getInt("levelID") ;
//					int score =resultSet.getInt("score") ; 
					if (resultSet.getInt("levelID") == level)
					if (resultSet.getInt("score")>max)
						max = resultSet.getInt("score");
				}
			}
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("Vendor Error: " + sqle.getErrorCode());
		
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
			
//					if (scanrio == 0&&resultSet.getInt("moves") <= 290
//							&& score >= 145){
//					
//					
//						if (levels[0] < score)
//						levels[0] = score;
//				
//		}
		return max;		
		}
		
		public int GetBestScore ()   {
			int bestScore=0;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(SimpleDB.jdbcUrl, SimpleDB.jdbcUser,
						SimpleDB.jdbcUserPassword);
				Statement statement = connection.createStatement();
				String allCustomersQuery = "SELECT * FROM Logs;";
				ResultSet resultSet = statement.executeQuery(allCustomersQuery);
//			int [] levels = new int [11]; //{0,1,3,5,9,11,13,16,19,20,23}
//			while (resultSet.next()) {
//				
//			int score =resultSet.getInt("score") ; 
//				if (resultSet.getInt("UserID") == id_meir || resultSet.getInt("UserID") == id_Ginton) {
//					int scanrio = resultSet.getInt("levelID") ;
//					if (scanrio == 0&&resultSet.getInt("moves") <= 290
//							&& score >= 145){
//					
//					
//						if (levels[0] < score)
//						levels[0] = score;
//				
//		}
			while (resultSet.next()) {
				int score =resultSet.getInt("score") ; 
				if (resultSet.getInt("UserID") == 205464712 || resultSet.getInt("UserID") == 205464712) 
					if (score>bestScore) {
						bestScore = score;
					
				}
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("Vendor Error: " + sqle.getErrorCode());
		
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
					return bestScore;
	}


		
	
	
	
}