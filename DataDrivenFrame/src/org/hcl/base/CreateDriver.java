package org.hcl.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CreateDriver {
    public ChromeDriver driver;
	@BeforeMethod
	public void createDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TestingWorld\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@AfterMethod
	public void stopDriver()
	{
		driver.quit();
	}
	
	
}
