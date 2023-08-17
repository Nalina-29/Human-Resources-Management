package practice_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReaddatafromPropertiyfileTest {

	public static void main(String[] args) throws IOException 
	{
      FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.properties");
      Properties pobj= new Properties();
      pobj.load(fis);
     Object URL = pobj.getProperty("url");
    String UN = pobj.getProperty("username");
   String PWD = pobj.getProperty("password");
   System.out.println(URL);
   System.out.println(UN);
   System.out.println(PWD);
     
   
   
	}

}
