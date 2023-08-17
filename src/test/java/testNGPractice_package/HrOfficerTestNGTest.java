package testNGPractice_package;

import org.testng.annotations.Test;

import com.hrm.Genericutility.BaseClass;

public class HrOfficerTestNGTest extends BaseClass
{
@Test
public void addemp()
{
	System.out.println("-- add employee by hro --");
}

@Test
public void editemp()
{
	System.out.println("-- edit employee --");
}
}
