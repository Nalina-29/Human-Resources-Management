package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sqlstatement {

	public static void main(String[] args) throws SQLException
	{
		Driver driver= new    Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "root");
		Statement state = con.createStatement();
		String query="select*from hr_officer where name='abc';";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
		String colu1 = result.getString(1);
		String c2 = result.getString(2);
		String c3 = result.getString(3);
		String c4 = result.getString(4);
		System.out.println(colu1+" "+c2+" "+c3+" "+c4);
		}
         con.close();
	}

}
