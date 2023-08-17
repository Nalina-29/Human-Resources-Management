package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonselectQueryTest {

	public static void main(String[] args) throws SQLException
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "root");
		Statement state = con.createStatement();
		String query="insert into hr_officer values(78,'xyz', 'x@gmail.com','qwe')Y7";
		int result = state.executeUpdate(query);
		
		if(result>0)
		{
			System.out.println("data has been updated");
		}
		else
		{
			System.err.println("Data not inserted");
		}
       con.close();
	}

}
