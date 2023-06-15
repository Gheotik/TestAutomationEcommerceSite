package pages;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	Random random = new Random();

	public int Random_Number_Generator() {
		return (int) (random.nextInt() * 999 + 100);
	}

	public int Date_Number_Generator() {

		return (int) (random.nextInt() * 31 + 1);
	}

	public String Phone_Number_Generator() {
		int areaCode = (int) (random.nextInt() * 999 + 100);
		int firstThree = (int) (random.nextInt() * 999 + 100);
		int lastFour = (int) (random.nextInt() * 9999 + 1000);
		return areaCode + " " + firstThree + " " + lastFour;
	}

	public void SelectFromDropdownByVisibleText(WebElement element, String input) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(input);
	}

	public void SelectFromDropdownByValue(WebElement element, String input) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(input);
	}

	public String RemoveDecimalPoint(String str) {
		return str.substring(0, str.length() - 2);
	}

	public double ConvertStringToDouble(WebElement element) {
		String StringElement = element.getText().substring(1);
		return Double.parseDouble(StringElement);
	}

	public void WaitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
