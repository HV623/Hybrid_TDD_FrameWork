package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPage {

	public	WebDriver driver;
	
	public ForgotPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//div[@id='content']//h1")
		private WebElement ValidationMessage;
		

		public WebElement ValidationMessage() {
			return ValidationMessage;
		}
}
