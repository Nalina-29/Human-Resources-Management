package testNGPractice_package;

import org.testng.annotations.Test;

import com.hrm.Genericutility.BaseClass;

public class HrheadSampleTestngTest extends BaseClass

{
@Test(groups = "smoke")
public void addadmin()
{
	System.out.println("-- add admin --");
}

@Test
public void addempl()
{
	System.out.println("-- add Employee --");
}

}
