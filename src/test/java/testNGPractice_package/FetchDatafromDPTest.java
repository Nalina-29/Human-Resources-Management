package testNGPractice_package;

import org.testng.annotations.Test;

public class FetchDatafromDPTest

{
@Test(dataProviderClass = DataproviderTest.class, dataProvider = "data")
public void getdata(String username, String password, String Hrtype)
{
	System.out.println("USERNAME----->"+username+"  PASSWORD---->"+password+"  Hrtype--->"+Hrtype);
}
	
	
	@Test(dataProviderClass =DataproviderTest.class, dataProvider = "test", priority = 2 )
	public void fetchdata(String from, String to, int price)
	{
		System.out.println("starting from   "+from+"  towards "+to+" it takes "+price+"Rs");
	}
	
}
 