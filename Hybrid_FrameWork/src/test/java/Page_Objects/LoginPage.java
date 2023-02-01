package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public	WebDriver driver;
		
	public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
		@FindBy(xpath="")
		private WebElement email;
		@FindBy(xpath="")
		private WebElement password;

		

		



}
	
