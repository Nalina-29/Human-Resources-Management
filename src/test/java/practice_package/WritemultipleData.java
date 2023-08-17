package practice_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WritemultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		List<WebElement> eles = driver.findElements(By.xpath("//a"));
		int count = eles.size();
		System.out.println(count);
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		for(int i=0; i<=count; i++)
		{
	          Row r = sh.createRow(i); 
	         Cell ce = r.createCell(2);
			String value = eles.get(i).getAttribute("href");
			ce.setCellValue(value);
		}
		

	}

}
