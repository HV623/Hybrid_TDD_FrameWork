package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import BaseClass.Base;
import Page_Objects.ForgotPage;
import Page_Objects.LoginPage;
import Utilities_Class.My_Util;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends Base  {

	public	WebDriver driver;
	public File fis;
	public FileInputStream fr;
	public Properties prop;
	
	Logger log = LogManager.getLogger(LoginTest.class);
	
		public void properties_set() throws Throwable {
			prop=new Properties();
			fis=new File("C:\\Users\\lenovo\\git\\repository\\Hybrid_FrameWork\\src\\test\\java\\utilities\\data.properties");
			fr=new FileInputStream(fis);
			prop.load(fr);
		}
		
		@BeforeMethod
		public void setup() throws Throwable {
//			prop=new Properties();
//			fis=new File("C:\\Users\\lenovo\\git\\repository\\Hybrid_FrameWork\\src\\test\\java\\utilities\\data.properties");
//			fr=new FileInputStream(fis);
//			prop.load(fr);
			properties_set();
		//	Properties_Setup("value");
			driver=hii(prop.getProperty("browser"));
			log.debug("browser launched" + "browser name="+prop.getProperty("browser"));	/////////////
//			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			log.debug("url opened");
		}
		@AfterMethod(alwaysRun=true)
		public void closing() {
			driver.quit();
			log.debug("closing ");
		}
		

		@Test(priority=2,enabled=false)
		public void Login_Using_Invalid_Email_Pass() throws Throwable {
			prop=new Properties();
			fis=new File("C:\\Users\\lenovo\\git\\repository\\Hybrid_FrameWork\\src\\test\\java\\utilities\\data.properties");
			fr=new FileInputStream(fis);
			prop.load(fr);
			
			LoginPage lg=new LoginPage(driver);
			Assert.assertTrue(lg.emailinputbox().isDisplayed());
			Assert.assertTrue(lg.emailinputbox().isEnabled());
			lg.emailinputbox().clear();
			lg.emailinputbox().sendKeys("harsh623.hv68@gmail.com");
			log.debug("Typing email is in emailinput box");
			Thread.sleep(2500);
			Assert.assertTrue(lg.passwordinputbox().isDisplayed());
			Assert.assertTrue(lg.passwordinputbox().isEnabled());
			lg.passwordinputbox().clear();
			lg.passwordinputbox().sendKeys("Harsh");
			log.debug("typing password in password input boc");
			Thread.sleep(2500);	
			String str= lg.passwordinputbox().getAttribute("value");
			System.out.println(str);
			lg.LoginButton().click();
			log.debug("clicking on login button");
			Thread.sleep(2000);
			String strr=lg.Validation_Message().getText();
			lg.Validation_Message().isDisplayed();
			Assert.assertEquals(strr,"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.");
				log.info("Warnig message is displayed");
		}
			@Test(priority=1,enabled=false)
			public void Login_using_Empty_Fields() throws Throwable {
				LoginPage pg=new LoginPage(driver);
				pg.LoginButton().click();
				log.debug("clicking on login button without entring email and password");
				String str=pg.Validation_Message().getText();
				Assert.assertEquals(str,"Warning: No match for E-Mail Address and/or Password.");
				log.info("displaying warning message");
				Thread.sleep(2000);
			}

			@Test(priority=1,enabled=false)
			public void Verify_ForgotPassword_link_Working() throws Throwable {
				LoginPage ag=new LoginPage(driver);
				Assert.assertTrue(ag.ForgotButton().isDisplayed());
				ag.ForgotButton().click();
				log.debug("clicking on forgot button");
				ForgotPage fg=new ForgotPage(driver);
				String str=fg.ValidationMessage().getText();
				Assert.assertEquals(str,"Forgot Your Password?");
				log.info("validation message is displaying");
				Thread.sleep(5000);
			}
				@Test(invocationCount =2,enabled=false)
				public void ho() throws Throwable {
					LoginPage lg=new LoginPage(driver);
					lg.emailinputbox().sendKeys("harsh623.hv68@gmail.com");
					log.debug("typing email in email input box");
					lg.passwordinputbox().clear();
					lg.passwordinputbox().sendKeys("Harsh");
					log.debug("typing password in password input box");
					Thread.sleep(2500);
					lg.LoginButton().click();
					log.debug("clicking on login button");
					Thread.sleep(2000);
					String strr=lg.Validation_Message().getText();
					lg.Validation_Message().isDisplayed();
					System.out.println(strr);
					Assert.assertEquals(strr,"Warning: No match for E-Mail Address and/or Password.");
					log.info("displaying warning message");
	//				if(strr.equals("Warning: No match for E-Mail Address and/or Password.")) {
	//			Assert.assertEquals(strr,"Warning: No match for E-Mail Address and/or Password.");
				}
//else if(strr.equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")) {

	
//Assert.assertEquals(strr,"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.");			
						
	//				}
		//		}


				@Test(dependsOnMethods= "ho",enabled=false)
				public void depend() throws Throwable {
					LoginPage lg=new LoginPage(driver);
					lg.emailinputbox().sendKeys("harshkjhhbyguyg");
					log.debug("typing email in email input box");
					lg.passwordinputbox().clear();
					lg.passwordinputbox().sendKeys("Harsh");
					log.debug("typing password in password input box");
					Thread.sleep(2500);
					lg.LoginButton().click();	
					log.debug("clicking obn login button");
					String strr=lg.Validation_Message().getText();
					lg.Validation_Message().isDisplayed();
					System.out.println(strr);
					Assert.assertEquals(strr,"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.");			
					log.info("displaying warning message");
				}
//				@DataProvider	
//				public Object[][] datasupply() {
//						Object[][]ab= {{"harsh623","hsviuuvb"},{"dscdsv","svdfv"},{"dscsdvsdv","dsvv"},{"dsvv","vv"}};
//						return ab;
//					}

					@Test(dataProviderClass=Base.class,dataProvider="datasupply")
					public void runfromData(String email, String pass) throws Throwable {
						LoginPage lg=new LoginPage(driver);
						lg.emailinputbox().sendKeys(email);
						log.debug("typing email in email input box");
						lg.passwordinputbox().clear();
						lg.passwordinputbox().sendKeys(pass);
						log.debug("typing password in password input box");
						Thread.sleep(2500);
						lg.LoginButton().click();
						log.debug("clicking on login button");
					
					
					log.error("This is an error log");
				
					}










}
