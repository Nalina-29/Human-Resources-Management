package com.hrm.Genericutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

public class FileUtility
{
	/**This method is used to read the data from Property file
	 * @author sys
	 * @param key
	 * @return
	 * @throws IOException
	 */
 public String readDatafromPropertyFile(String key) throws IOException
 {
	FileInputStream fis = new FileInputStream(IPathConstants.Filepath);
	Properties pObj= new Properties();
	pObj.load(fis);
	String value = pObj.getProperty(key);
	return value;
 }
 
 public void fileupload(WebElement element)
 {
	File fu = new File(IPathConstants.docpath);
	String path1 = fu.getAbsolutePath();
	element.sendKeys(path1);
	
}
 public void imgupload(WebElement element)
 {
	File fu = new File(IPathConstants.imgpath);
	String path2 = fu.getAbsolutePath();
	element.sendKeys(path2);
}
 
}

