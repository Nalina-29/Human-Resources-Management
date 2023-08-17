package com.hrm.Genericutility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility 
{
	/**
	 * This method is used to maximize browser
	 * @param driver
	 * @param partialTilte
	 */

    public void maximize(WebDriver driver)
    {
    	driver.manage().window().maximize();
    }
    /**
     * This is used for implicit wait
     * @param driver
     */
    public void waitforPageLoad(WebDriver driver)
    {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /**
     * This method is used for Explicit wait
     * @param driver
     * @param element
     */
    public void waitForElementTobevisible(WebDriver driver,  WebElement element)
    {
    	WebDriverWait wait= new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * This method is used for dropdown to select the element by index
     * @param element
     * @param index
     */
    public void select(WebElement element, int index)
    {
    	Select sc= new Select(element);
    	sc.selectByIndex(index);
    }
    /**
     *  This method is used for dropdown to select the element by value
     * @param element
     * @param value
     */
    public void select(WebElement element, String value)
    {
    	Select sc= new Select(element);
    	sc.selectByValue(value);
    }
    /**
     *  This method is used for dropdown to select the element by visible Text
     * @param value
     * @param element
     */
    public void select( String text,WebElement element)
    {
    	Select sc= new Select(element);
    	sc.selectByVisibleText(text);
    }
    /**
     * This method is used for mousehover Action
     * @param driver
     * @param element
     */
    public void mousehover(WebDriver driver, WebElement element)
    {
    	Actions act= new Actions(driver);
    	act.moveToElement(element).click().perform();
    }
    /**
     * This method used for drag and drop action
     * @param driver
     * @param src
     * @param dst
     */
    public void dargAnddrop(WebDriver driver, WebElement src, WebElement dst)
    {
    	Actions act= new Actions(driver);
    	act.dragAndDrop(src, dst).perform();
    }
    /**
     * This method is used for double click
     * @param driver
     * @param element
     */
    public void doubleClick(WebDriver driver, WebElement element)
    {
    	Actions act= new Actions(driver);
    	act.doubleClick(element).perform();
    	
    }
    /**
     * This method is used for right click on Web page
     * @param driver
     */
    public void rightClick(WebDriver driver)
    {
    	Actions act= new Actions(driver);
    	act.contextClick().perform();
    }
    /**
     * This method is used for right click on web Element
     * @param driver
     * @param element
     */
    public void rightClick(WebDriver driver, WebElement element)
    {
    	Actions act= new Actions(driver);
    	act.contextClick(element).perform();
    }
    /**
     * This method is used for press ENTER key using Action class
     * @param driver
     */
    public void enterKeyPress(WebDriver driver)
    {
    	Actions act= new Actions(driver);
    	act.sendKeys(Keys.ENTER).perform();
    }
    /**
     * This method is used to press ENTER key using Robot class
     * @param driver
     * @throws Throwable
     */
    public void enterkey(WebDriver driver) throws Throwable
     {
    	Robot rb = new Robot();
    	rb.keyPress(KeyEvent.VK_ENTER);
    }
    /**
     * This method is used to release ENTER key using Robot class
     * @param driver
     * @throws Throwable
     */
     public void enterRelease(WebDriver driver) throws Throwable
     {
    	 Robot rb= new Robot();
    	 rb.keyRelease(KeyEvent.VK_ENTER);
     }
     /**
      * this method used to switch the frame based on index
      * @param driver
      * @param index
      */
     public void switchToFrame(WebDriver driver, int index)
     {
    	 driver.switchTo().frame(index);
     }
     /**
      * this method used to switch the frame based on name or Id 
      * @param driver
      * @param nameOrID
      */
     public void switchToFrame(WebDriver driver, String nameOrID)
     {
    	 driver.switchTo().frame(nameOrID);
     }
     /**
      * this method used to switch the frame based on element adddress
      * @param driver
      * @param address
      */
     public void switchToFrame(WebDriver driver, WebElement address)
     {
    	 driver.switchTo().frame(address);
     }
      /**
       * this method used to accept the alert popup
       * @param driver
       */
     public void acceptAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().accept();
     }
     /**
      * this method used to dismiss the alert popup
      * @param driver
      */
     public void cancelAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().dismiss();
     }
     /**
      * This method is used to Switch the window
      * @param driver
      * @param partialTilte
      */
     public void switchToWindow(WebDriver driver, String partialTilte)
     {
    	 //step1: use getWindowHAndles to capture all window id's
    	 Set<String> windows = driver.getWindowHandles();
    	 
    	 //step2: iterate through the window
    	Iterator<String> it = windows.iterator();
    	
    	//step3: check whether there is next window
    	while(it.hasNext())
    	{
    		//step4: capture current window id
    		String winId = it.next();
    		
    		//step5: switch to current window and capture title
    		String currentTitle = driver.switchTo().window(winId).getTitle();
    		
    		//step6: check whether current window is expected
    		if(currentTitle.contains(partialTilte))
    		{
    			break;
    		}
          }
   }
     /**
      * This method is used to get the Screen Shot
      * @param driver
      * @param screenShotName
      * @return
      * @throws Throwable
      */
     public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
     {
    	 TakesScreenshot ts=(TakesScreenshot) driver;
    	 File src = ts.getScreenshotAs(OutputType.FILE);
    	 String path = "./screenshot/"+screenShotName+".png";
			File dst = new File(path);
			
			FileUtils.copyFile(src, dst);
			return path;
     }
     /**
      * This method is used for Scroll Bar Action
      * @param driver
      */
     public void scrollBarAction(WebDriver driver)
     {
    	 JavascriptExecutor jse= (JavascriptExecutor) driver;
    	 jse.executeScript("window.scrollBy(0,800)","");
     }
     /**
      * This method is used to Scroll to Specific element
      * @param driver
      * @param element
      */
     public void scrollAction(WebDriver driver, WebElement element)
     {
    	 JavascriptExecutor jse= (JavascriptExecutor) driver;
    	int y=element.getLocation().getY();
    	jse.executeScript("window.scrollBy(0,"+y+")", element);
    	//jse.executeScript("argument[0].scrollIntoView()", element);
     }
}
