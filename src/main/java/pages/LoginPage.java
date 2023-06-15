package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{
	private static final Logger logger =  LoggerFactory.getLogger(LoginPage.class);

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement emailAddressField;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement signInButton;
	@FindBy(how = How.XPATH, using = "//button[@name='SubmitCreate']") WebElement createAnAccountButton;
	@FindBy(how = How.XPATH, using = "//input[@id='email_create']") WebElement creatAccountEmailField;
	@FindBy(how = How.XPATH, using = "//div[@id='create_account_error']/ol/li") WebElement invalidEmailAlertText;
	
	//InteractiveMethods
	public void Enter_EMail_Address(String Email) {
		emailAddressField.sendKeys(Email);
	}
	
	public void Enter_Password(String Password) {
		passwordField.sendKeys(Password);
	}
	
	public void Click_Signin_Button() {
		signInButton.click();
	}
	
	public void Click_CreateAnAccount_Button() {
		createAnAccountButton.click();
	}
	
	public void Fill_CreatAccountEmail_Field() {
		creatAccountEmailField.sendKeys(Random_Number_Generator() + "." + Random_Number_Generator() + "user@email.com");
	}

	public void Fill_CreatAccount_WithInvalidEmail_Field(String email) {
		creatAccountEmailField.sendKeys(email);
	}

	public void Verify_CreatAccount_WithInvalidEmail_Field() {
		
		if(invalidEmailAlertText.isDisplayed()) {
			logger.warn("Success! Alert for invalid email was displayed");
			logger.warn(invalidEmailAlertText.getText());
		}else {
			logger.error("Failure, alert for invalid email was not displayed ");
		}
		
	}
}
