package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import locators.AddPjLoc;
import utilities.CommonMethod;

public class Add_ProjectPage extends CommonMethod{
	AddPjLoc Locators = new AddPjLoc();

	 
	 public Add_ProjectPage ClickaddBtn() {
		 ClickEle(Locators.AddBtn);
		return this;
		 
	 }
	 public Add_ProjectPage clickAddPj() {
		 ClickEle(Locators.AddPJ);
		 
		return this;
		 
	 }
	 public Add_ProjectPage EnterPjName(String PjName) {
		 SendkeysToEle(Locators.PjNameTxt, PjName);
		return this;
		 
	 }
	 public Add_ProjectPage EnterPjCode(String PjCode) {
		 WaitForElement(Locators.PjCodeTxt);
		 SendkeysToEle(Locators.PjCodeTxt, PjCode);
		return this;
		 
	 }
	 public Add_ProjectPage SelectStartDate(String SDate,String Year ,String Month ,String Day) {
		 SelectDate(SDate,Year, Month, Day);
		 ClickEle(Locators.StartDatetxt);
		 return this;
	 }
	 public Add_ProjectPage SelectEndDate(String EDate,String Year,String Month,String Day){
		 Synchronize();
		 SelectEDate(EDate,Year, Month, Day);
		return this;
		 
	 }
	 public Add_ProjectPage EnterDesc(String Desc) {
		 SendkeysToEle(Locators.Desc, Desc);
		return this;
		 
	 }
	 public Add_ProjectPage ClickSaveBtn() {
		 ClickEle(Locators.SaveBtn);
		 Assert.fail("Project code is already Exist");
		return this;
	 }
}
