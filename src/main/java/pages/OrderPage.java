package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPage {
	private static Logger logger =  LoggerFactory.getLogger(OrderPage.class);

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/p[2]/a[1]")WebElement ProceedToCheckout_Button;
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/form/p/button")WebElement ProceedToCheckout_Button_Address_Page;
	@FindBy(how = How.XPATH, using = "//form[@id='form']/p/button")WebElement ProceedToCheckout_Button_Shipping_Page;
	@FindBy(how = How.XPATH, using = "//input[@id='cgv']")WebElement CheckBox_AgreeToTerms_Shipping_Page;
	@FindBy(how = How.XPATH, using = "//a[@class='bankwire']")WebElement PayByBankWire_Payment_Page;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I confirm my order')]")WebElement IConfirmMyOrder_Payment_Page;
	@FindBy(how = How.XPATH, using = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")WebElement MyAccount_Button;
	@FindBy(how = How.XPATH, using = "//p[@class='cheque-indent']/strong[@class='dark']")WebElement Order_Confirmation;

	//InteractiveMethods
	public void Click_ProceedToCheckout() {
		ProceedToCheckout_Button.click();
	}

	public void Click_ProceedToCheckout_Address_Page() {
		ProceedToCheckout_Button_Address_Page.click();
	}

	public void Click_ProceedToCheckout_Shipping_Page() {
		ProceedToCheckout_Button_Shipping_Page.click();
	}

	public void Click_CheckBox_AgreeToTerms_Shipping_Page() {
		CheckBox_AgreeToTerms_Shipping_Page.click();
	}

	public void Click_PayByBankWire_Payment_Page() {
		PayByBankWire_Payment_Page.click();
	}

	public void Click_IConfirmMyOrder_Page() {
		IConfirmMyOrder_Payment_Page.click();
	}
	
	public void Click_MyAccount_Button() {
		MyAccount_Button.click();
	}
	
	public void Assert_Order_Confirmation() {
		
		if(Order_Confirmation.getText().contains("complete")) {
			logger.warn("Order Verified");
		}else {
			logger.warn("Order not completed");
		}
		
	}
	

}
