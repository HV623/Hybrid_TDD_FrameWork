package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	public static WebDriver driver=null;
	
		
		public static WebDriver hii(String browser) {
			
			
			
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
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		return driver;
		}
		public static  void Properties_Setup() throws Throwable {
			Properties prop=new Properties();
			File file=new File("C:\\Users\\lenovo\\git\\repository\\Hybrid_FrameWork\\src\\test\\java\\utilities\\data.properties");
			FileInputStream fr=new FileInputStream(file);
			prop.load(fr);
			System.out.println(prop.getProperty("browser"));
			
		}
		@DataProvider	
		public Object[][] datasupply() {
				Object[][]ab= {{"harsh623","hsviuuvb"},{"dscdsv","svdfv"},{"dscsdvsdv","dsvv"},{"dsvv","vv"}};
				return ab;
			}

	}
