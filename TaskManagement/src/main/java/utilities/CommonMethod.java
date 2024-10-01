package utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class CommonMethod {
	
	public static WebDriver driver;
	public static WebDriverWait wait;

	
	public static  void setUp() {
		driver = new ChromeDriver();
		driver.get("https://dev-tm.innovaturelabs.com/");
		driver.manage().window().maximize();
		}
 
	public void SendkeysToEle(By Element,String Text) {
		driver.findElement(Element).sendKeys(Text);
	}
	public void ClickEle(By Element) {
		driver.findElement(Element).click();
	}
	public void Cleardata(By Element) {
		driver.findElement(Element).sendKeys(Keys.CONTROL+"A");
		driver.findElement(Element).sendKeys(Keys.DELETE);
	}
	public WebElement WaitForElement(By Element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	}
	//@SuppressWarnings("deprecation")
	public  void Synchronize() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	public void  SelectDate(String Date,String Year,String Month,String Day) {
		 WebElement Ele =driver.findElement(By.xpath("//input[@placeholder='"+Date+"']"));
		 Ele.click();
		 Synchronize();
		 driver.findElement(By.xpath("//div[@class='v-picker__title__btn v-date-picker-title__year']")).click();
		 Synchronize();
		 driver.findElement(By.xpath("//li[text()='"+Year+"']")).click();
		 Synchronize();
		 driver.findElement(By.xpath("//div[text()='"+Month+"']")).click();
		 Synchronize();
		 driver.findElement(By.xpath("//div[text()='"+Day+"']")).click();
		 
	}
	public void  SelectEDate(String Date,String Year,String Month,String Day) {
		 WebElement Ele =driver.findElement(By.xpath("//input[@placeholder='"+Date+"']"));
		 Ele.click();
		 Synchronize();
		 driver.findElement(By.xpath("(//div[@class='v-picker__title__btn v-date-picker-title__year'])[2]")).click();
		 Synchronize();
		 driver.findElement(By.xpath("//li[text()='"+Year+"']")).click();
		 Synchronize();
		 driver.findElement(By.xpath("//div[text()='"+Month+"']")).click();
		 Synchronize();
		 driver.findElement(By.xpath("(//div[text()='"+Day+"'])[2]")).click();
	

	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	

}
