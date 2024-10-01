package pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.LoginLoc;
import utilities.CommonMethod;

public class LoginPage extends CommonMethod {
	LoginLoc Locators = new LoginLoc();
	
	

	
	public LoginPage EnterUserName(String Username) {
		SendkeysToEle(Locators.UserName,Username);
		return this;	
	}
	public LoginPage EnterPassword(String Password) {
		SendkeysToEle(Locators.PassWord, Password);
		return this;
	}
	public LoginPage ClickLoginBtn() {
		ClickEle(Locators.LoginBtn);
		return this;
	}
	public LoginPage CleardataFromUseName() {
		Cleardata(Locators.UserName);
		return this;
	}
	public LoginPage CleardataFromPassword() {
		Cleardata(Locators.PassWord);
		return this;
	}
	public LoginPage VerifyErrorMessage() {
		WaitForElement(Locators.ErrorMsg);
		String ActMessage ="wrong password";
		String ExpectedMsg =driver.findElement(Locators.ErrorMsg).getText();
		Assert.assertEquals(ActMessage,ExpectedMsg,"Proper error message is displayed");
		
		return this;
		
	}
	public LoginPage VerifySuccessfullLogin() {
		Synchronize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.urlContains("/dashboard"));
		String ActTitle =driver.getCurrentUrl();
		String ExpTile ="https://dev-tm.innovaturelabs.com/dashboard";
		Assert.assertEquals(ActTitle, ExpTile, "Login and navigated to dashboard");
		return this;
		
	}

}
