package locators;

import org.openqa.selenium.By;

import utilities.CommonMethod;

public class LoginLoc extends CommonMethod {
	 
	public  By UserName = By.id("input-10");
	public  By PassWord = By.id("input-14");
	public  By LoginBtn = By.id("cmnbtnstyle");
	public  By ErrorMsg = By.xpath("//p[text()='wrong password']");

}
