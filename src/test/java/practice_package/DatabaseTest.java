package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseTest {

	public static void main(String[] args) throws InterruptedException, SQLException 
	{
		String expec="poi";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		driver.get("http://rmgtestingserver:8084/");
		Thread.sleep(5000); 
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("poi");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("lkj");
		WebElement ele = driver.findElement(By.xpath("//select[@name='status']"));
		Select sc= new Select(ele);
		sc.selectByVisibleText("On Gogin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Driver driver1= new Driver();
		DriverManager.registerDriver(driver1);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query="select * from project";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actual = result.getString(4);
			
			
			
			if(actual.equalsIgnoreCase(expec))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("project created sucessfully");
		}
		else
		{
			System.out.println("project not created");
		}
		con.close();
	}

}
