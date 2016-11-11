
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Hello {

	public static void main(String args[]) {
		String selectSQL = "SELECT name FROM myfirsttable ";

		Connection dbConnection;
		try {
			dbConnection = getcon();
		
		PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);


		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();

		
		  while (rs.next()) {
		    String userid = rs.getString("name");
		   // String username = rs.getString("USERNAME");
		    System.out.println("age : " + userid);
		  }

		} 
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally {
		    //preparedStatement.close();
		    //dbConnection.close();
		  }
	
	}
	public static Connection getcon () throws Exception{
		try {
			String driver ="com.mysql.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/database";
			String username ="root";
			String password ="1130324";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("GOOd");
			return con;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}