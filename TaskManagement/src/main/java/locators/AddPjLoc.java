package locators;

import org.openqa.selenium.By;

import utilities.CommonMethod;

public class AddPjLoc extends CommonMethod{
	 public By AddBtn = By.xpath("//button[@class='rounded-circle p-1 addButton']");
	 public By AddPJ  = By.xpath("(//button[text()=' Add Project '])[2]");
	 public By PjNameTxt =By.xpath("//input[@placeholder='Project']");
	 public By PjCodeTxt =By.xpath("(//div[@class='v-text-field__slot']/input[@required='required'])[2]");
	 public By Desc =By.xpath("//textarea[@required='required']");
	 public By SaveBtn = By.xpath("//span[text()=' Save ']");
	 public By StartDatetxt =By.xpath("//label[@for='startdate']");

}
