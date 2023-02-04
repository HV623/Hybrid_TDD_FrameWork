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
			@FindBy(xpath="//input[@id='input-firstname']")
			private WebElement FirstNameInputBox;
			@FindBy(xpath="//input[@id='input-lastname']")
			private WebElement LastNameInputBox;
			@FindBy(xpath="//input[@id='input-email']")
			private WebElement EmailInputBox;
			@FindBy(xpath="//input[@id='input-telephone']")
			private WebElement TelePhoneInputBox;
			@FindBy(xpath="//input[@id='input-password']")
			private WebElement PasswordInputBox;
			@FindBy(xpath="//input[@id='input-confirm']")
			private WebElement ConfirmPasswordInputBox;
			@FindBy(xpath="//label[normalize-space()='Yes']")
			private WebElement NewsLetter_Yes_InputBox;
			@FindBy(xpath="//label[normalize-space()='No']")
			private WebElement NeewsLetter_No_InputBox;
			@FindBy(xpath="//input[@value='Continue']")
			private WebElement ContinutButton;
			
			
			
			public WebElement NewsLetter_Yes_InputBox() {
				return NewsLetter_Yes_InputBox;
			}
			public WebElement NeewsLetter_No_InputBox() {
				return NeewsLetter_No_InputBox;	
			}
			public WebElement ContinutButton() {
				return ContinutButton;
			}

}
