package com.hrm.Genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	 Connection con=null;
	 /**This method is used connect to database
	  * @author sys
	  * @throws Throwable
	  */
   public void connectToDB() throws Throwable
   {
	   Driver driver= new Driver();
	   DriverManager.registerDriver(driver);
	  con = DriverManager.getConnection(IPathConstants.dbUrl, IPathConstants.dbusername, IPathConstants.dbpassword);
	   
   }
   /**this method is used to execute the queries and fetch the data
    * @author sys
    * @param query
    * @param columnNo
    * @param Expdata
    * @return
    * @throws SQLException
    */
    public String executeQueryandgetData(String query, int columnNo, String Expdata) throws SQLException
    {
    	ResultSet result = con.createStatement().executeQuery(query);
    	boolean flag= false;
    	while(result.next())
    	{
    		String data = result.getString(columnNo);
    		if(data.equalsIgnoreCase(Expdata))
    		{
    			flag= true;
    			break;
    		}
    	}
    	if(flag)
    	{
    		System.out.println("-- Data is verified");
    		return Expdata;
    	}
    	else
    	{
    		System.out.println("-- Data is not present");
    		return "";
    }
    }
    /**This method is used to close the Database
     * @author sys
     * @throws SQLException
     */
    public void closeDB() throws SQLException 
    {
    	con.close();
    }
}
