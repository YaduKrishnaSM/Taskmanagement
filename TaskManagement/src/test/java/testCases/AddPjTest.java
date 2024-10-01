package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Add_ProjectPage;
import utilities.ReadExcel;

public class AddPjTest extends Add_ProjectPage{
	
	@Test(dataProvider="TC_01",description="Create Project")
	public void VerifyProject_Can_be_Added(String PjName,String PjCode,String SDate,String SYear,String SMonth,String SDay,String EDate,String EYear,String EMonth,String EDay,String Desc) {
		new Add_ProjectPage()
		.ClickaddBtn()
		.clickAddPj()
		.EnterPjName(PjName)
		.EnterPjCode(PjCode)
		.SelectStartDate(SDate,SYear, SMonth, SDay)
		.SelectEndDate(EDate,EYear, EMonth, EDay)
		.EnterDesc(Desc)
		.ClickSaveBtn();		
	}
	@DataProvider(name="TC_01")
	public Object[][]TC_01(){
		Object[][]value= ReadExcel.ReadTestData(this.getClass().getSimpleName(), "TC_01", 11);			
		return value;		
	}
	

}
