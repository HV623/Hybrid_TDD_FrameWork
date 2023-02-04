package Utilities_Class;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter_Class {

		public static ExtentReports getExtentReport_Setup() {
			
			String extentreport_File_Path= System.getProperty("user.dir")+"\\Extent\\extentreport.html";
			ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentreport_File_Path);
			sparkReporter.config().setReportName("Harsh report name");
			sparkReporter.config().setDocumentTitle("vardhan is title");
			ExtentReports extentreport=new ExtentReports();
			extentreport.attachReporter(sparkReporter);
			extentreport.setSystemInfo("Operating System is ",System.getProperty("os.name"));
			extentreport.setSystemInfo("Operating System is ",System.getProperty("java.specification.version"));
			extentreport.setSystemInfo("Operating System is ",System.getProperty("user.dir"));
			extentreport.setSystemInfo("Operating System is ",System.getProperty("user.name"));
			extentreport.setSystemInfo("Operating System is ",System.getProperty("user.home"));
			extentreport.setSystemInfo("Operating System is ","Tested by Harsh Vardhan");
			return extentreport;
		
		}
	
}
		