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
	
		@FindBy(xpath="//input[@name='email' and @type='text']")
		private WebElement email;
		@FindBy(xpath="//input[@id='input-password']")
		private WebElement password;
		@FindBy(xpath="//input[@value='Login']")
		private WebElement Loginbutton;
		@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
		private WebElement Validation_Message;
		@FindBy(xpath="//span[normalize-space()='My Account']")
		private WebElement MyaccountOption;
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
		private WebElement MyaccountOption_RegisterButton;
		@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
		private WebElement ForgotButton;
		
		
		
		public WebElement emailinputbox() {
			return email;
		}
		public WebElement passwordinputbox() {
			return password;
		}
		public WebElement LoginButton() {
			return Loginbutton;
		}
		public WebElement Validation_Message() {
			return Validation_Message;
		}
		public WebElement MyaccountOption() {
			return MyaccountOption;
		}
		public WebElement MyaccountOption_RegisterButton() {
			return MyaccountOption_RegisterButton;
		}
		public WebElement ForgotButton() {
			return ForgotButton;
		}
		
		
		
		
		
		
		
		
		
		
}
	
