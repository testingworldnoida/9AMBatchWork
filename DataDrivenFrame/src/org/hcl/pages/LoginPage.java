package org.hcl.pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	ChromeDriver driver;
	public LoginPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(String uname)
	{
		driver.findElementById("email").sendKeys(uname);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElementById("pass").sendKeys(pass);
	}
	
	public void clickSignin()
	{
		driver.findElementById("u_0_l").click();;
	}
	
	
}
