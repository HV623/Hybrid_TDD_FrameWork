package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	public static WebDriver driver=null;
	
		
		public static WebDriver hii(String browser) {
			
			browser="firefox";
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				 driver=new ChromeDriver();
			}else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else if(browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
		return driver;
		}
		
		

	}
