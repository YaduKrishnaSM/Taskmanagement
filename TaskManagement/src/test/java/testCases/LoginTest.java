package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.CommonMethod;
import utilities.ReadExcel;



public class LoginTest extends LoginPage {
	@BeforeTest
	public void Setup() {
		LoginPage.setUp();
	}
	
	@Test(priority=2,dataProvider = "TC_01",description="Login with valid credentials")
	public void Verify_user_can_Login(String Username,String Password) {
       
       new LoginPage() 
       .EnterUserName(Username)
       .EnterPassword(Password)
       .ClickLoginBtn()
       .VerifySuccessfullLogin();
     	
	}
	@Test(priority=1,dataProvider="TC_02",description="Valid username and invalid password")
	public void Verify_Login_with_Valid_Username_and_Invalid_Password(String Username,String password) {
		new LoginPage()
		.EnterUserName(Username)
		.EnterPassword(password)
		.ClickLoginBtn()
		.VerifyErrorMessage()
		.CleardataFromUseName()
		.CleardataFromPassword()
		.Synchronize();
		
	}
	
	@DataProvider(name="TC_01")
    public Object[][] TC_01() {
        Object[][] value = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"TC_01", 2);
        return value;
	}
	@DataProvider(name="TC_02")
	public Object[][]TC_02(){
		Object[][]value= ReadExcel.ReadTestData(this.getClass().getSimpleName(), "TC_02", 2);			
		return value;		
	}
	@AfterTest
	public void Quit() {
		driver.quit();
	}
	
}
