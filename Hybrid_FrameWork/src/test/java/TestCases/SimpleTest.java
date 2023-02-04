package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {

	WebDriver driver;
		@AfterMethod
			public void closing()
		{
			driver.close();
		}
	
	@Test(priority=1)
	public void Amazone_Page_testing() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		Actions ab=new Actions(driver);
		WebElement el=driver.findElement(By.xpath("//input[@name='field-keywords']"));
		ab.moveToElement(el).build().perform();
		Thread.sleep(2000);
		ab.sendKeys(el,"oneplus").build().perform();
		Thread.sleep(2000);
		List<WebElement> li=driver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		System.out.println(li.size());
		for (WebElement aa:li) {
			System.out.println(aa.getAttribute("aria-label"));
		}
	}

	
	}

