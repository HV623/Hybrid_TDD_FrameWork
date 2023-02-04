package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import BaseClass.Base;
import Page_Objects.ForgotPage;
import Page_Objects.LoginPage;
import Page_Objects.RegisterPage;
import graphql.Assert;

import org.apache.logging.log4j.Logger;

public class RegisterTest extends Base{

	public	WebDriver driver;
	public File fis;
	public FileInputStream fr;
	public Properties prop;
	Logger log=LogManager.getLogger(RegisterTest.class);
		
		@BeforeMethod
		public void setup() throws Throwable {
			prop=new Properties();
			fis=new File("C:\\Users\\lenovo\\git\\repository\\Hybrid_FrameWork\\src\\test\\java\\utilities\\data.properties");
			fr=new FileInputStream(fis);
			prop.load(fr);
			driver=hii(prop.getProperty("browser"));
			log.debug("browser launched");
			driver.get(prop.getProperty("url"));
			log.debug("url got opened");
		}
		@AfterMethod(alwaysRun=true)
		public void closing() {
			driver.quit();
			log.debug("closing the browser");
		}

		@Test(enabled=false)
		public void hi() throws Throwable {
		RegisterPage rg=new RegisterPage(driver);	
		LoginPage lg=new LoginPage(driver);
			
			lg.MyaccountOption().click();
			log.debug("clicking on myaccount option");
			lg.MyaccountOption_RegisterButton().click();
			log.debug("clicking on register button available inside myaccountoption");
			Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scroll(0,800)");
			log.debug("scrolling down the web page");
			Thread.sleep(2000);
			
			boolean b=rg.NeewsLetter_No_InputBox().isEnabled();
			boolean bc=rg.NewsLetter_Yes_InputBox().isEnabled();
			System.out.println(b);
			System.out.println(bc);
			Thread.sleep(2000);
			rg.NewsLetter_Yes_InputBox().click();
			log.debug("yes checkbox newsletter option get clicked");
			Thread.sleep(2000);
			Assert.assertFalse(rg.NeewsLetter_No_InputBox().isSelected());	/////////////////////////////
			rg.ContinutButton().click();
			log.debug("clicking on continue button");
			Thread.sleep(2000);
		}	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
