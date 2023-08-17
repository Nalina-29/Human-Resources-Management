package practice_package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ksrtc {

	public static void main(String[] args)
	{
		 WebDriverManager.chromedriver().setup();
		   WebDriver driver= new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://ksrtc.in/");
		   
		   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		   
		  List<WebElement> links = driver.findElements(By.xpath("//link"));
		  System.out.println(links.size());
		  
		  ArrayList<String> link= new ArrayList<String>();
		  
		  for(int i=0; i<links.size(); i++)
		  {
			  String eachlink = links.get(i).getAttribute("href");
			  URL url=null;
				int statusCode=0;
				try {
					url= new URL(eachlink);
				HttpURLConnection connection=(HttpURLConnection)  url.openConnection();
				statusCode= connection.getResponseCode();
				
				if(statusCode>=400)
				{
					link.add(eachlink+"----->"+statusCode);
					
				}
				}
				catch (Exception e)
				{
					link.add(eachlink+"----->"+statusCode);
				}
	}


	}

}
