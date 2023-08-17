package com.hrm.Genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	/** This method is used to get random number
	 * @author sys
	 * @return
	 */
  public int getRandomNo()
  {
	  Random ran = new Random();
	  int random = ran.nextInt(500);
	  return random;
  }
  /**This method is used to get system Date
   * @author sys
   * @return
   */
  public String getsystemDate()
  {
	  Date d= new Date();
	 String date = d.toString();
	 return date;
  }
  /**This method is used get system date in format
   * @author sys
   * @return
   */
  
  public String getsystemformatDateformat()
  {
	  SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy hh-MM-ss");
 
	  Date d = new Date();
	  String systemDateformat = dateformat.format(d);
	  return systemDateformat;
  }
}
