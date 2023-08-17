package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProkabbadiTest {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String TeamName="Jaipur Pink Panthers";
		
		driver.get("https://www.prokabaddi.com/standings");
		driver.findElement(By.xpath("//p[.='"+TeamName+"']"));
		WebElement matches = driver.findElement(By.xpath("//p[.='"+TeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-play']"));
		WebElement won = driver.findElement(By.xpath("//p[.='"+TeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-won']"));
	WebElement lost = driver.findElement(By.xpath("//p[.='"+TeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-lost']"));
	WebElement draw = driver.findElement(By.xpath("//p[.='"+TeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-draw']"));
	WebElement scoredif = driver.findElement(By.xpath("//p[.='"+TeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data score-diff']"));
	WebElement form = driver.findElement(By.xpath("//p[.='"+TeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data form']"));
	
	WebElement points = driver.findElement(By.xpath("//p[.='"+TeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data points']"));
	
	System.out.print(matches.getText()+"--"+won.getText()+"--"+lost.getText()+"--"+draw.getText()+"--"+scoredif.getText()+"--"+form.getText()+"--"+points.getText());
	}

}
