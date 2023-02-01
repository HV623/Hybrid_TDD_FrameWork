package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import BaseClass.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends Base  {

	public	WebDriver driver;
	public File fis;
	public FileInputStream fr;
	public Properties prop;
	
		
		@BeforeMethod
		public void setup() throws Throwable {
		
			driver=hii("chrome");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		@AfterMethod
		public void closing() {
			driver.quit();
		}
		

		@Test
		public void hi() throws Throwable {
			prop=new Properties();
			fis=new File("C:\\Users\\lenovo\\git\\repository\\Hybrid_FrameWork\\src\\test\\java\\utilities\\data.properties");
			fr=new FileInputStream(fis);
			prop.load(fr);
		
			System.out.println(prop.getProperty("url"));
			driver.get(prop.getProperty("url"));
			
			}
		

}
