package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
		public WebDriver driver;
		
		public RegisterPage(WebDriver driver) {
		this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
			@FindBy(xpath="")
			private WebElement ab;





}
