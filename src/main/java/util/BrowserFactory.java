package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	private BrowserFactory() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}
	static WebDriver driver;
	
	//Open Browser
	public static WebDriver launchBrowser() {
		
		ExcelReader reader = new ExcelReader("./data/testdata.xlsx");
		String url = reader.getCellData("Sheet2", "url", 2);
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	//Close Browser
	public static void closeBrowser() {
		
		driver.close();
		driver.quit();
		
	}
	
	

}
