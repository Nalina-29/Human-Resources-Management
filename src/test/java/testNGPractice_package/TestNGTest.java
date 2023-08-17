package testNGPractice_package;

import org.testng.annotations.Test;

public class TestNGTest {
     @Test
     public void creatTest()
     {
    	// int[] a= {1,2,3};
    	 System.out.println("---Data is created---");
     }
	
	@Test(enabled = false)
	public void edittest()
	{
		System.out.println("---Data is edited--");
	}
	
	@Test
	public void deletetest()
	{
		System.out.println("---Data is deleted---");
	}
}
