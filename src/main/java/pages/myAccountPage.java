package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class myAccountPage {
	private static Logger logger =  LoggerFactory.getLogger(myAccountPage.class);

	WebDriver driver;

	public myAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	//Element Library
	@FindBy(how = How.XPATH, using = "//a[@title='Women']")
	WebElement womenButton;
	@FindBy(how = How.XPATH, using = "//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement tshirtsButton;
	@FindBy(how = How.XPATH, using = "//*[@id='center_column']/div/div[1]/ul/li[1]/a")
	WebElement orderHistoryAndDetailsButton;
	@FindBy(how = How.XPATH, using = "//a[@class='account']/span")
	WebElement NameOnAccount;

	//InteractiveMethods
	public void hoverOverWomenButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(womenButton).perform();
	}

	public void clickTshirtsButton() {
		tshirtsButton.click();
	}


	public void assertNameOnAccount(String FirstName, String LastName) {
		String FullName = FirstName + " " + LastName;
		logger.warn(FullName);
	}
}
