package com.hrm.Genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpleClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) {
		
		// execution start from here
		String MethodName = result.getMethod().getMethodName();
		 test = report.createTest(MethodName);
		 Reporter.log(MethodName+"---->  TestScript execution Starts ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"-->passed");
		Reporter.log(MethodName+"-----> TestScript passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String Fscript = result.getMethod().getMethodName();
		String FailedScript = Fscript+ new JavaUtility().getsystemformatDateformat();
		 EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
         File src = edriver.getScreenshotAs(OutputType.FILE);
         File dst= new File("./Screenshot/"+FailedScript+".png");
	try {
		FileUtils.copyFile(src, dst);
	} catch (IOException e) {
		
		e.printStackTrace();
	} 
	test.log(Status.FAIL, Fscript+"---> failed");
	test.log(Status.FAIL, result.getThrowable());
	Reporter.log(FailedScript+"-----> TestScript failed");
	
	
//	try {
//		
//		String FailedSript = WebdriverUtility.getScreenShot(BaseClass.sdriver,  result.getMethod().getMethodName());
//	test.addScreenCaptureFromPath(FailedSript);
//	} catch (Throwable e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"---> Testscript Skipped" );
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"--->Testscript Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		// create html report
		ExtentSparkReporter htmlreport= new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Human Resources");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Hr Head");
		
		 report= new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("OS", "Windows 10");
		 report.setSystemInfo("Base-Browser", "chrome");
		 report.setSystemInfo("Base-Url", "http://rmgtestingserver/domain/HRM_System/");
		 report.setSystemInfo("Reporter Name", "Nalina");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// consoldate the report
		
		report.flush();
	}

	
	
	
}
