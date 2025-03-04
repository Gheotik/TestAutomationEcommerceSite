package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAnAccountPage extends BasePage {
	private static Logger logger =  LoggerFactory.getLogger(CreateAnAccountPage.class);

	WebDriver driver;
	
	public CreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='id_gender1']") WebElement mrRadioButton;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']") WebElement firstNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']") WebElement lastNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//select[@id='days']") WebElement daySelection;
	@FindBy(how = How.XPATH, using = "//select[@id='months']") WebElement monthSelection;
	@FindBy(how = How.XPATH, using = "//select[@id='years']") WebElement yearSelection;
	@FindBy(how = How.XPATH, using = "//input[@id='newsletter']") WebElement newsletterCheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='optin']") WebElement specialOfferCheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='firstname']") WebElement addressFirstNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='lastname']") WebElement addressLastNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='company']") WebElement addressCompanyField;
	@FindBy(how = How.XPATH, using = "//input[@id='address1']") WebElement address1Field;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement cityField;
	@FindBy(how = How.XPATH, using = "//select[@id='id_state']") WebElement stateField;
	@FindBy(how = How.XPATH, using = "//input[@id='postcode']") WebElement zipCodeField;
	@FindBy(how = How.XPATH, using = "//select[@id='id_country']") WebElement countryField;
	@FindBy(how = How.XPATH, using = "//input[@id='phone_mobile']") WebElement cellPhoneField;
	@FindBy(how = How.XPATH, using = "//input[@id='alias']") WebElement aliasAddressField;
	@FindBy(how = How.XPATH, using = "//button[@id='submitAccount']") WebElement registerButton;
	@FindBy(how = How.XPATH, using = "//div[@id=\"center_column\"]/div/p") WebElement errorAlertForMandatoryFields;
	
	public void clickMrRadioButton() {
		mrRadioButton.click();
	}
	
	public void fillFirstNameField(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void fillLastNameField(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void fillPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void selectDaySelection(String day) {
		
		SelectFromDropdownByValue(daySelection, RemoveDecimalPoint(day));
	}
	
	public void selectMonthSelection(String month) {
		SelectFromDropdownByValue(monthSelection, month);
	}
	
	public void selectYearSelection(String year) {
		SelectFromDropdownByValue(yearSelection, RemoveDecimalPoint(year));
	}
	
	public void clickNewsletterCheckBox() {
		newsletterCheckBox.click();
	}
	
	public void clickSpecialOfferCheckBox() {
		specialOfferCheckBox.click();
	}
	
	public void fillAddressFirstNameField(String aFirstName) {
		addressFirstNameField.sendKeys(aFirstName);
	}
	
	public void fillAddressLastNameField(String aLastName) {
		addressLastNameField.sendKeys(aLastName);
	}
	
	public void fillAddressCompanyField(String company) {
		addressCompanyField.sendKeys(company);
	}

	public void fillAddress1Field(String address) {
		address1Field.sendKeys(address);
	}

	public void fillCityField(String city) {
		cityField.sendKeys(city);
	}

	public void selectStateField(String state) {
		SelectFromDropdownByVisibleText(stateField, state);
	}

	public void fillZipCodeField(String zipCode) {
		zipCodeField.sendKeys(RemoveDecimalPoint(zipCode));
	}

	public void selectCountryField(String country) {
		SelectFromDropdownByVisibleText(countryField, country);
	}

	public void fillCellPhoneField() {
		cellPhoneField.sendKeys(Phone_Number_Generator());
	}
	
	public void fillAliasAddressField(String alias) {
		aliasAddressField.clear();
		aliasAddressField.sendKeys(alias);
	}

	public void clickRegisterButton() {
		registerButton.click();
	}

	public void verifyErrorAlertForMandatoryFields() {
		
		if(errorAlertForMandatoryFields.isDisplayed()) {
			logger.warn("Success! Error Alert For Mandatory Fields is displayed");
		}else {
			logger.error("Failure, Error Alert For Mandatory Fields is not displayed");
		}
	}
}
