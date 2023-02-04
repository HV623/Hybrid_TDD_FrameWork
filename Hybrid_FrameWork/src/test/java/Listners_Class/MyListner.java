package Listners_Class;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities_Class.ExtentReporter_Class;

public class MyListner implements ITestListener{

	public ExtentReports et ;
	public ExtentTest etest;
	

	public void onTestStart(ITestResult result) {
		etest= et.createTest(result.getName());
		etest.log(Status.INFO,result.getName()+" Started execution");
		etest.log(Status.INFO,"Name of thest class is " +result.getTestClass()); 
	}

	public void onTestSuccess(ITestResult result) {
	 etest.log(Status.PASS,result.getName()+" Got success");
	}

	public void onTestFailure(ITestResult result) {
		String testname=result.getName(); 
		WebDriver driver=null;
			try {
		 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			
			File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//	File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath=System.getProperty("user.dir")+"\\Extent\\"+testname+".png";	///////////////////////////
			try {
				FileHandler.copy(srcScreenshot,new File (screenshotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			etest.addScreenCaptureFromPath(screenshotPath);
			etest.log(Status.INFO,result.getThrowable());
			etest.log(Status.FAIL,testname+" Got failed");
	}

	public void onTestSkipped(ITestResult result) {
		 etest.log(Status.SKIP,result.getName()+" Got Skip");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	et = ExtentReporter_Class.getExtentReport_Setup();
	}

	public void onFinish(ITestContext context) {
		et.flush();
	}

}
